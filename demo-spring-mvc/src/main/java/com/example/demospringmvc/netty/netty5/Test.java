package com.example.demospringmvc.netty.netty5;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;


/**
 * @author changyanan1
 */
public class Test {
    public static void main(String[] args) {
        ByteBuf byteBuf;
        Channel channel;
        Channel.Unsafe unsafe;
        Future future;
        ChannelFuture future1;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
    }
}
