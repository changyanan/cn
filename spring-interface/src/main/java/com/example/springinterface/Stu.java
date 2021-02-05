package com.example.springinterface;

import java.util.List;

/**
 * @author changyanan1
 */
public class Stu<T, H, K> {

    private T t;
    private H h;
    private K k;

    public Stu(T t, H h, K k) {
        this.t = t;
        this.h = h;
        this.k = k;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public H getH() {
        return h;
    }

    public void setH(H h) {
        this.h = h;
    }

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }

    public static void main(String[] args) {
        Stu<String, Integer, String> stu = new Stu<>("小命", 20, "性别");
        System.out.println(stu.getH());
        System.out.println(stu.getT());
        System.out.println(stu.getK());
    }
}
