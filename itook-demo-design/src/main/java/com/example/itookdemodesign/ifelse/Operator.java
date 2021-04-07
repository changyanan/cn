package com.example.itookdemodesign.ifelse;

/**
 * @author changyanan1
 */

public enum Operator {
    ADD {
        @Override
        public int apply(int a, int b) {
            return a + b;
        }
    },
    DIVIDE {
        @Override
        public int apply(int a, int b) {
            return a / b;
        }
    },
    MULTIPLY {
        @Override
        public int apply(int a, int b) {
            return a * b;
        }
    };

    public abstract int apply(int a, int b);
}
