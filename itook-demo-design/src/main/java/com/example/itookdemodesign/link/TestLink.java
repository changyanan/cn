package com.example.itookdemodesign.link;

import org.junit.Test;

public class TestLink {
    @Test
    void linkTest() {
        AuthLink authLink = new Level1AuthLink("1111", "t1")
                .appendNext(new Level2AuthLink("2222", "t2"))
                .appendNext(new Level3AuthLink("3333", "t3"));
    }
}
