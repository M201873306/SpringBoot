package com.hust.springbootjackson.domain;


import java.io.Serializable;

public class Friend {
    private String nickname;
    private int age;

    public Friend(String nickname, int age) {
        this.nickname = nickname;
        this.age = age;
    }

    public Friend() {
    }

    @Override
    public String toString() {
        return "Friend{" +
                "nickname='" + nickname + '\'' +
                ", age=" + age +
                '}';
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
