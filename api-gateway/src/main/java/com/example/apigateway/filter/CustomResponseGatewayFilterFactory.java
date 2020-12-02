package com.example.apigateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author changyanan1
 */
@Component
public class CustomResponseGatewayFilterFactory extends
        AbstractGatewayFilterFactory<CustomResponseGatewayFilterFactory.Config> {
    public CustomResponseGatewayFilterFactory() {
        super(Config.class);
    }
    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList(NAME_KEY);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            ServerHttpResponse response = exchange.getResponse();
            if (HttpStatus.OK.equals(response.getStatusCode())) {
                for (Map.Entry<String, String> entry : toMap(config.getCookie()).entrySet()) {
                    response.addCookie(ResponseCookie.from(entry.getKey(), entry.getValue()).build());
                }
                for (Map.Entry<String, String> entry : toMap(config.getHeader()).entrySet()) {
                    response.getHeaders().add(entry.getKey(), entry.getValue());
                }
                return chain.filter(exchange.mutate().response(response).build());
            } else {
                return chain.filter(exchange);
            }
        });
    }

    private static Map<String, String> toMap(String value) {
        String[] split = value.split("=");
        Map<String, String> map = new HashMap<>(8);
        map.put(split[0], split[1]);
        return map;
    }

    public static class Config {

        private String cookie;
        private String header;

        public String getCookie() {
            return cookie;
        }

        public void setCookie(String cookie) {
            this.cookie = cookie;
        }

        public String getHeader() {
            return header;
        }

        public void setHeader(String header) {
            this.header = header;
        }
    }
}

