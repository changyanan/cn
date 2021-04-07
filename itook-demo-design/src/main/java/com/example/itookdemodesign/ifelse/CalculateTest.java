package com.example.itookdemodesign.ifelse;

/**
 * @author changyanan1
 */
public class CalculateTest {
    public int calculateUsingFactory(int a, int b, String operator) {
        Operation operation = OperatorFactory.getOperation(operator).orElseThrow(() -> new IllegalArgumentException("Invalid Operator"));
        return operation.apply(a, b);
    }
}
