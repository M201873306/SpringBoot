package com.hust.springbootjackson.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.time.LocalDate;

@JsonRootName("Person")
public class Person {
    @JsonProperty("Name")
    private String name;
    @JsonProperty("NickName")
    private String nickname;
    @JsonProperty("Age")
    private int age;
    @JsonProperty("IdentityCode")
    private String identityCode;
    @JsonProperty
    @JsonFormat(pattern = "yyyy-MM-DD")
    private LocalDate birthday;

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                ", identityCode='" + identityCode + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getIdentityCode() {
        return identityCode;
    }

    public void setIdentityCode(String identityCode) {
        this.identityCode = identityCode;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Person(String name, String nickname, int age, String identityCode, LocalDate birthday) {
        this.name = name;
        this.nickname = nickname;
        this.age = age;
        this.identityCode = identityCode;
        this.birthday = birthday;
    }
}