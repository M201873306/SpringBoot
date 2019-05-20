package com.hust.springbootconfig.winter.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by Donghua.Chen on 2018/6/1.
 */
@Component
@ConfigurationProperties(prefix = "com.my1")
@PropertySource("classpath:my11.yml")
public class MyProperties1 {
    //@Value("${com.my1.age}")
    private int age;
    //@Value("${com.my1.name}")
    private String name;
    // 省略 get set

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

    @Override
    public String toString() {
        return "MyProperties1{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}