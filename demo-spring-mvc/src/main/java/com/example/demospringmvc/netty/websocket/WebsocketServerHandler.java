package com.example.demospringmvc.netty.websocket;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.util.Date;

import static io.netty.handler.codec.http.HttpHeaders.isKeepAlive;
import static io.netty.handler.codec.http.HttpHeaders.setContentLength;

/**
 * @author changyanan1
 */
public class WebsocketServerHandler extends SimpleChannelInboundHandler<Object> {

    private static final Logger logger = LoggerFactory.getLogger(WebsocketServerHandler.class);
    private WebSocketServerHandshaker handShaker;

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, Object msg) {
        //传统http接入
        if (msg instanceof FullHttpRequest) {
            handleHttpRequest(ctx, (FullHttpRequest) msg);
            //websocket接入
        } else if (msg instanceof WebSocketFrame) {
            handleWebSocketFrame(ctx, (WebSocketFrame) msg);
        }

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    private void handleWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) {
        //判断是否关闭链路指令
        if (frame instanceof CloseWebSocketFrame) {
            handShaker.close(ctx.channel(), ((CloseWebSocketFrame) frame).retain());
            return;
        }
        //判断是否是ping消息
        if (frame instanceof PingWebSocketFrame) {
            ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
            return;
        }

        //本程序只支持文本消息，不支持二进制
        if (!(frame instanceof TextWebSocketFrame)) {
            throw new UnsupportedOperationException(String.format("%s frame type not supported", frame.getClass().getName()));
        }
        String request = ((TextWebSocketFrame) frame).text();
        ctx.channel().write(new TextWebSocketFrame(request + ",欢迎使用netty websocket服务，现在时刻：" + new Date().toString()));
    }

    private void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest request) {
        //如果http解码失败 返回http异常
        if (!request.getDecoderResult().isSuccess() || (!"websocket".equals(request.headers().get("Upgrade")))) {
            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST);
            setHttpResponse(ctx, request, response);
            return;
        }
        //构建握手响应返回，本机测试
        WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory("ws://127.0.0.1:8888/websocket", null, false);
        handShaker = wsFactory.newHandshaker(request);
        if (handShaker == null) {
            WebSocketServerHandshakerFactory.sendUnsupportedWebSocketVersionResponse(ctx.channel());
        } else {
            handShaker.handshake(ctx.channel(), request);
        }
    }

    private void setHttpResponse(ChannelHandlerContext ctx, FullHttpRequest request, DefaultFullHttpResponse response) {
        //返回应答给客户端
        if (response.getStatus().code() != 200) {
            ByteBuf byteBuf = Unpooled.copiedBuffer(response.getStatus().toString(), CharsetUtil.UTF_8);
            response.content().writeBytes(byteBuf);
            byteBuf.release();
            //设置content length 长度
            setContentLength(response, response.content().readableBytes());
        }
        //如果是非keep-alive,关闭连接
        ChannelFuture f = ctx.channel().writeAndFlush(response);
        if (!isKeepAlive(request) || response.getStatus().code() != 200) {
            f.addListener(ChannelFutureListener.CLOSE);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
