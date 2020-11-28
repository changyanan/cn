package com.example.demospringmvc.netty.msgpack;

import org.msgpack.MessagePack;
import org.msgpack.template.Templates;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author changyanan1
 */
public class Test {
    public static void main(String[] args) {
        List<String> src = new ArrayList<>();
        src.add("message.msg");
        src.add("tom");
        src.add("eric");
        MessagePack messagePack = new MessagePack();
        try {
            byte[] write = messagePack.write(src);
            List<String> dst1 = (List<String>) messagePack.read(write, Templates.tList(Templates.tString()));
            System.out.println(dst1.get(0));
            System.out.println(dst1.get(1));
            System.out.println(dst1.get(2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
