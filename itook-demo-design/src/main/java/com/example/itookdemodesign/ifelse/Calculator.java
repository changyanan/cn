package com.example.itookdemodesign.ifelse;

/**
 * @author changyanan1
 */
public class Calculator {
    public int calculate(int a, int b, Operator operator) {
        return operator.apply(a, b);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.calculate(10, 20, Operator.DIVIDE));
    }
}
