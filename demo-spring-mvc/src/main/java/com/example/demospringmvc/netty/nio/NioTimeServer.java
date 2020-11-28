package com.example.demospringmvc.netty.nio;

import org.springframework.util.MultiValueMap;

import java.awt.font.MultipleMaster;

/**
 * @author changyanan1
 */
public class NioTimeServer {
    public static void main(String[] args) {
        int port =9999;
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer,"Nio-MultiplexerTimeServer").start();
    }
}
