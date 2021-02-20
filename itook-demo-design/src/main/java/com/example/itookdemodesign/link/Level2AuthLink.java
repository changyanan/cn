package com.example.itookdemodesign.link;

import java.util.Date;

public class Level2AuthLink extends AuthLink{
    public Level2AuthLink(String levelUserId, String levelUserName) {
        super(levelUserId, levelUserName);
    }

    @Override
    public AuthInfo doAuth(String uId, String orderId, Date authDate) {
        return null;
    }
}
