package org.example;

import org.example.domain.Calculator;
import org.example.domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientRequestHandler implements Runnable{

    private static final Logger logger = LoggerFactory.getLogger(ClientRequestHandler.class);
    private final Socket clientSocket;

    public ClientRequestHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    /**
     * Step2 - 사용자 요청이 들어올 때마다 Thread를 새로 생성해서 사용자 요청을 처리하도록 한다.
     * 문제점
     * 사용자가 요청할 때마다 Thread를 새로 생성한다.
     * Thread는 생성할 때마다 독립적인 스택메모리 공간을 할당 받는다. 메모리를 할당받는 작업은 비싼 작업이다.
     * 사용자의 요청이 있을때마다 Thread를 생성하게 된다면 성능이 매우 떨어진다.
     * 요청이 몰리게 되면 Thread를 굉장히 많이 생성하게 되며 메모리 할당 작업이 발생한다.
     * 포포먼스 측면에서 좋지 않고 동접자가 많아질경우 Thread가 생성되어 cpu context swiching 횟수가 증가되고
     * 최악의 경우 서버의 리소스가 감당하지 못해서 서버가 다운될 가능성이 있다.
     */
    @Override
    public void run() {
        logger.info("[ClientRequestHandler] new client {} started.", Thread.currentThread().getName());
        try (InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()) {
            BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
            DataOutputStream dos = new DataOutputStream(out);

            HttpRequest httpRequest = new HttpRequest(br);

            if (httpRequest.isGetRequest() && httpRequest.matchPath("/calculate")) {
                QueryStrings queryStrings = httpRequest.getQueryStrings();

                int operand1 = Integer.parseInt(queryStrings.getValue("operand1"));
                String operator = queryStrings.getValue("operator");
                int operand2 = Integer.parseInt(queryStrings.getValue("operand2"));

                int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
                byte[] body = String.valueOf(result).getBytes();

                HttpResponse response = new HttpResponse(dos);
                response.response200Header("application/json", body.length);
                response.responseBody(body);
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
