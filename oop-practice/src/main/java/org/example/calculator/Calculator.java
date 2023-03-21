package org.example.calculator;

import org.example.calculator.calculate.*;

import java.util.List;

public class Calculator {

    // 인터페이스를 implements 를 이용한 구현체를 List<NewArithmeticOperator>에 받는다.
    private static final List<NewArithmeticOperator> arithmeticOperators = List.of(new AdditionOperator(),
            new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());

    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
//        if("+".equals(operator)) {
//            return operand1 + operand2;
//        } else if ("-".equals(operator)) {
//            return operand1 - operand2;
//        } else if ("*".equals(operator)) {
//            return operand1 * operand2;
//        } else if ("/".equals(operator)) {
//            return operand1 / operand2;
//        }

//        // enum을 활용한 객체지향 프로그래밍
//        return ArithmeticOperator.calculate(operand1, operator, operand2);

        // interface를 활용한 객체지향 프로그래밍
        // 입력된 operator에 맞는 List<NewArithmeticOperator>안의 구현체를 찾고 그 구현체에게
        // operand1, operand2를 전달하여 calculate라는 작업을 위임
        return arithmeticOperators.stream()
                .filter(arithmeticOperators -> arithmeticOperators.supports(operator))
                // 해당하는 메서드의 return 값이 int기 때문에 map을 사용
                .map(arithmeticOperators -> arithmeticOperators.calculate(operand1, operand2))
                .findFirst() // 첫번째 값을 받는다.
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
