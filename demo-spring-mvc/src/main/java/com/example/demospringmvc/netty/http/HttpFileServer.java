package com.example.demospringmvc.netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author changyanan1
 */
public class HttpFileServer {
    private static final String DEFAULT_URL = "/demo-spring-mvc/";

    public void run(final int port, final String url) {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast("http-decoder", new HttpRequestDecoder());
                //把多个消息转化成一个消息(FullHttpRequest或者FullHttpResponse),原因是HTTP解码器在每个HTTP消息中会生成多个消息对象
                socketChannel.pipeline().addLast("http-aggregator", new HttpObjectAggregator(65536));
                socketChannel.pipeline().addLast("http-encoder", new HttpResponseEncoder());
                //支持处理异步发送大数据文件，但不占用过多的内存，防止发生内存泄漏
                socketChannel.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
                socketChannel.pipeline().addLast("http-fileServerHandler", new HttpFileServerHandler(url));
            }
        });
        try {
            ChannelFuture channelFuture = serverBootstrap.bind("127.0.0.1", port).sync();
            System.out.println("HTTP 文件目录服务器启动，网址是："+"http://127.0.0.1:"+port+url);
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        int port = 8888;
        String url = DEFAULT_URL;
        new HttpFileServer().run(port, url);
    }
}
