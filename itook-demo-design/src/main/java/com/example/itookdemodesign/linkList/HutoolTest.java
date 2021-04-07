package com.example.itookdemodesign.linkList;

import cn.hutool.core.lang.ObjectId;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * @author changyanan1
 */
public class HutoolTest {
    public static void main(String[] args) {
        String next = ObjectId.next();
        System.out.println(next);
        String s = IdUtil.fastUUID();
        System.out.println(s);
        Snowflake snowflake = IdUtil.getSnowflake(1, 12);
        long l = snowflake.nextId();
        System.out.println(l);
    }
}
