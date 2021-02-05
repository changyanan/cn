package com.example.itookdemodesign.link;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author changyanan1
 */
public abstract class AuthLink {
    protected Logger logger = LoggerFactory.getLogger(AuthLink.class);
    protected SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * 级别⼈员ID
     */
    protected String levelUserId;
    /**
     * 级别⼈员姓名
     */
    protected String levelUserName;
    private AuthLink next;

    public AuthLink(String levelUserId, String levelUserName) {
        this.levelUserId = levelUserId;
        this.levelUserName = levelUserName;
    }

    public AuthLink next() {
        return next;
    }

    public AuthLink appendNext(AuthLink next) {
        this.next = next;
        return this;
    }

    public abstract AuthInfo doAuth(String uId, String orderId, Date authDate);
}
