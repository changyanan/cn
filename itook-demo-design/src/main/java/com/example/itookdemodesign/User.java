package com.example.itookdemodesign;

public class User {
    private String name;
    private int age;
    private int bust;
    private int waist;
    private int hips;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBust() {
        return bust;
    }

    public void setBust(int bust) {
        this.bust = bust;
    }

    public int getWaist() {
        return waist;
    }

    public void setWaist(int waist) {
        this.waist = waist;
    }

    public int getHips() {
        return hips;
    }

    public void setHips(int hips) {
        this.hips = hips;
    }

    public static void main(String[] args) {
        User user = Builder.of(User::new)
                .with(User::setAge, 1)
                .with(User::setBust, 2)
                .with(User::setWaist, 3)
                .with(User::setBust, 6)
                .with(User::setHips, 5)
                .with(User::setBust, 6)
                .with(User::setHips, 5)
                .build();
        System.out.println(user.toString());
    }
}
