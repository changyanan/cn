package com.example.layuiweb.common;

/**
 * @author changyanan1
 */
public class FebUtil {
    private final static String VIEW_PREFIX = "page/";

    public static String view(String viewName) {
        return VIEW_PREFIX + viewName;
    }
}
