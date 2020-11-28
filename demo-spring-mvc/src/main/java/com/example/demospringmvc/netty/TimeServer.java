package com.example.demospringmvc.netty;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author changyanan1
 */
public class TimeServer {
    public static void main(String[] args) {
        int port = 9999;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("服务启动已启动端口号：" + port);
            TimeServerHandlerExecutePool timeServerHandlerExecutePool = new TimeServerHandlerExecutePool(50, 1000);
            Socket socket;
            while (true) {
                socket = serverSocket.accept();
                timeServerHandlerExecutePool.execute(new TimeServerHandler(socket));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
