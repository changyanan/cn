package com.example.demospringmvc.netty.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author changyanan1
 */
public class WebSocketServer {
    public void run(int port) {
        EventLoopGroup bossLoopGroup = new NioEventLoopGroup();
        EventLoopGroup workLoopGroup = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();


        try {
            bootstrap.group(bossLoopGroup, workLoopGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();
                    pipeline.addLast("http-codec", new HttpServerCodec());
                    pipeline.addLast("aggregator", new HttpObjectAggregator(65535));
                    pipeline.addLast("http-chunked", new ChunkedWriteHandler());
                    pipeline.addLast("handler", new WebsocketServerHandler());
                }
            });
            Channel ch = bootstrap.bind(port).sync().channel();
            System.out.println("Web socket已经启动，端口：" + port);
            System.out.println("请打开浏览器。http://127.0.0.1:" + port + "/");
            ch.closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossLoopGroup.shutdownGracefully();
            workLoopGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        int port = 8888;
        new WebSocketServer().run(port);
    }
}
