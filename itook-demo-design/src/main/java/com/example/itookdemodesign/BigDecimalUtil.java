package com.example.itookdemodesign;

import java.math.BigDecimal;

/**
 * @author changyanan1
 */
public class BigDecimalUtil {
    private BigDecimalUtil() {
    }

    public static BigDecimal add(double v1, double v2) {// v1 + v2
        BigDecimal b1 = new BigDecimal(String.valueOf(v1));
        BigDecimal b2 = new BigDecimal(String.valueOf(v2));
        return b1.add(b2);
    }

    public static BigDecimal sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(String.valueOf(v1));
        BigDecimal b2 = new BigDecimal(String.valueOf(v2));
        return b1.subtract(b2);
    }

    public static BigDecimal mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(String.valueOf(v1));
        BigDecimal b2 = new BigDecimal(String.valueOf(v2));
        return b1.multiply(b2);
    }

    public static BigDecimal div(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(String.valueOf(v1));
        BigDecimal b2 = new BigDecimal(String.valueOf(v2));
        // 2 = 保留小数点后两位   ROUND_HALF_UP = 四舍五入 应对除不尽的情况
        return b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP);
    }

    public static void main(String[] args) {
        BigDecimal add = BigDecimalUtil.add(0.05, 0.01);
        System.out.println(add);
    }
}
