package com.example.itookdemodesign.hash;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class Node {
    private String name;
    private String host;
    private String port;
    private Map<String, Object> data = new ConcurrentHashMap<>();

    public Node(String name, String host, String port) {
        this.name = name;
        this.host = host;
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public void put(String key, Object value) {
        data.put(key, value);
    }

    public void remove(String key) {
        data.remove(key);
    }

    public Object get(String key) {
        return data.get(key);
    }

    public int dataSize() {
        return this.data.size();
    }

    public static void main(String[] args) {

    }
}
