package org.example;

import org.example.domain.Calculator;
import org.example.domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomWebApplicationServer {

    private final int port;

    // Step3
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    private static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("[CustomWebApplicationServer] started {} port.", port);

            Socket clientSocket;
            logger.info("[CustomWebApplicationServer] waiting for client.");

            while ((clientSocket = serverSocket.accept()) != null) {
                logger.info("[CustomWebApplicationServer] client connected!");

                // Step2
//                new Thread(new ClientRequestHandler(clientSocket)).start();

                // Step3 - Thread Pool을 적용해 안정적인 서비스가 가능하도록 한다.
                executorService.execute(new ClientRequestHandler(clientSocket));

                /**
                 * Step1 - 사용자 요청을 메인 Thread가 처리하도록 한다.
                 * 문제점
                 * 메인 thread가 해당 작업을 수행하면서 breaking이 걸리게 되면
                 * 클라이언트의 요청이 해당 요청이 끝날때까지 기다려야하는 심각한 문제 발생
                 */
//                try (InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()) {
//                    BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
//                    DataOutputStream dos = new DataOutputStream(out);
//
//                    HttpRequest httpRequest = new HttpRequest(br);
//
//                    if (httpRequest.isGetRequest() && httpRequest.matchPath("/calculate")) {
//                        QueryStrings queryStrings = httpRequest.getQueryStrings();
//
//                        int operand1 = Integer.parseInt(queryStrings.getValue("operand1"));
//                        String operator = queryStrings.getValue("operator");
//                        int operand2 = Integer.parseInt(queryStrings.getValue("operand2"));
//
//                        int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
//                        byte[] body = String.valueOf(result).getBytes();
//
//                        HttpResponse response = new HttpResponse(dos);
//                        response.response200Header("application/json", body.length);
//                        response.responseBody(body);
//                    }

                    // HTTP protocal이 어떻게 구성되어 있는지 확인하는 코드
//                    String line;
//                    while ((line = br.readLine()) != "") {
//                        System.out.println(line);
//                    }
//                }
            }
        }
    }
}
/**
 * HttpRequest
 *  - RequestLine
 *      - HttpMethod
 *      - path
 *      - queryString
 *  - Header
 *  - Body
 *
 *  HttpResponse
 */
