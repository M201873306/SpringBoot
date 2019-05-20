package com.hust.springbootjackson.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("FriendDetail123")
@JsonIgnoreProperties({"uselessProp1", "uselessProp3"})
public class FriendDetail {
    @JsonProperty("NickName")
    private String name;
    @JsonProperty("Age")
    private int age;
    private String uselessProp1;
    //@JsonIgnore
    private int uselessProp2;
    private String uselessProp3;

    public FriendDetail() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "FriendDetail{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", uselessProp1='" + uselessProp1 + '\'' +
                ", uselessProp2=" + uselessProp2 +
                ", uselessProp3='" + uselessProp3 + '\'' +
                '}';
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUselessProp1() {
        return uselessProp1;
    }

    public void setUselessProp1(String uselessProp1) {
        this.uselessProp1 = uselessProp1;
    }

    public int getUselessProp2() {
        return uselessProp2;
    }

    public void setUselessProp2(int uselessProp2) {
        this.uselessProp2 = uselessProp2;
    }

    public String getUselessProp3() {
        return uselessProp3;
    }

    public void setUselessProp3(String uselessProp3) {
        this.uselessProp3 = uselessProp3;
    }

    public FriendDetail(String name, int age, String uselessProp1, int uselessProp2, String uselessProp3) {
        this.name = name;
        this.age = age;
        this.uselessProp1 = uselessProp1;
        this.uselessProp2 = uselessProp2;
        this.uselessProp3 = uselessProp3;
    }
}