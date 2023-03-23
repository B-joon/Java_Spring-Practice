package org.example;

import org.example.calculate.domain.Calculator;
import org.example.calculate.domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

// interface servlet
@WebServlet("/calculate")
public class InterfaceCalculatorServlet implements Servlet {
    private static final Logger logger = LoggerFactory.getLogger(InterfaceCalculatorServlet.class);
    private ServletConfig servletConfig;

    @Override
    public void init(ServletConfig config) throws ServletException {
        logger.info("init");
        this.servletConfig = config;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        logger.info("servie");
        int operand1 = Integer.parseInt(request.getParameter("operand1"));
        String operator = request.getParameter("operator");
        int operand2 = Integer.parseInt(request.getParameter("operand2"));

        int result = Calculator.calculate(new PositiveNumber(operand1),operator, new PositiveNumber(operand2));

        PrintWriter writer = response.getWriter();
        writer.println(result);
    }

    @Override
    public void destroy() {
        // resource release
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    @Override
    public String getServletInfo() {
        return null;
    }
}
