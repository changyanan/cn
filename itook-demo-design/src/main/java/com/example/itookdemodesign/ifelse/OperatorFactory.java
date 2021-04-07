package com.example.itookdemodesign.ifelse;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author changyanan1
 */
public class OperatorFactory {
    static Map<String, Operation> operationMap = new HashMap<>();

    static {
        operationMap.put("add", new Addition());
        operationMap.put("divide", new Division());
        operationMap.put("subtract", new Subtraction());
    }

    public static Optional<Operation> getOperation(String operation) {
        return Optional.ofNullable(operationMap.get(operation));
    }
}
