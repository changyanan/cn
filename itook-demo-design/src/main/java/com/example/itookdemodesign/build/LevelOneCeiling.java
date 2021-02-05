package com.example.itookdemodesign.build;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LevelOneCeiling implements Matter
{
    @Override
    public String scene() {
        return null;
    }

    @Override
    public String brand() {
        return null;
    }

    @Override
    public String model() {
        return null;
    }

    @Override
    public BigDecimal price() {
        return null;
    }

    @Override
    public String desc() {

        return null;
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("c", "v", "a", "e");
        Collections.shuffle(strings);
        System.out.println(strings);
    }
}
