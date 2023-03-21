package org.example.calculator.calculate;

public class DivisionOperator implements NewArithmeticOperator{
    @Override
    public boolean supports(String operator) {
        return "/".equals(operator);
    }

    @Override
    public int calculate(PositiveNumber operand1, PositiveNumber operand2) {
        // PositiveNumber에서 양수임을 확인하기 때문에 해당 메소드에서 체크할 필요가 없다.
//        if (operand2.toInt() == 0) {
//            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
//        }
        return operand1.toInt() / operand2.toInt();
    }
}
