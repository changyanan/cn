package com.example.itookdemodesign;

/**
 * @author changyanan1
 */
public class Misc {
    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        String s = "test";
        System.out.println(s.hashCode());
    }
}
