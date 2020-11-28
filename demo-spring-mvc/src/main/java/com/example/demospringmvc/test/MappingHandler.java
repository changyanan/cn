package com.example.demospringmvc.test;


import org.springframework.beans.factory.BeanFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author changyanan1
 */
public class MappingHandler {
    private String uri;
    private Method method;
    private Class<?> controller;
    private String[] args;

    /**
     * @param uri
     * @param method
     * @param controller
     * @param args
     */
    public MappingHandler(String uri, Method method, Class<?> controller, String[] args) {
        this.uri = uri;
        this.method = method;
        this.controller = controller;
        this.args = args;
    }

    public boolean handle(ServletRequest request, ServletResponse response) throws IOException {
        String requestUri = ((HttpServletRequest) request).getRequestURI();
        if (!uri.equals(requestUri)) {
            return false;
        }
        Object[] parameters = new Object[args.length];
        for(int i = 0; i < args.length; i++){
            parameters[i] = request.getParameter(args[i]);
        }
//        Object ctl = BeanFactory.getBean(String.valueOf(controller));
//        Object res = method.invoke(ctl, parameters);
//        response.getWriter().println(res.toString());
        return true;
    }
}
