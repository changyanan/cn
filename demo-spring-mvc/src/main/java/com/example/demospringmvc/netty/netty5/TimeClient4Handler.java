package com.example.demospringmvc.netty.netty5;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandlerInvoker;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.EventExecutorGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;

/**
 * @author changyanan1
 */
public class TimeClient4Handler extends ChannelHandlerAdapter {
    //    private final ByteBuf firstMessage;
    private static final Logger logger = LoggerFactory.getLogger(TimeClient4Handler.class);

//    public TimeClient4Handler() {
//        byte[] req = "客户端请求11111发鬼地方个地方官".getBytes();
//        firstMessage = Unpooled.buffer(req.length);
//        firstMessage.writeBytes(req);
//    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.err.println("【" + cause.getMessage() + "】");
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client channelActive(连接成功) ");
        for (int i = 0; i < 50; i++) {
            System.out.println(i + ",");
            ctx.writeAndFlush(Unpooled.copiedBuffer("It's a good day , I want to know time--" + i + "\n", CharsetUtil.UTF_8));
        }
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        ByteBuf buf = (ByteBuf) msg;
//        byte[] bytes = new byte[buf.readableBytes()];
//        buf.readBytes(bytes);
//        String body = new String(bytes, "UTF-8");
        System.err.println("读取server的消息" + msg);
    }
}
