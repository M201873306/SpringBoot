package com.hust.springbootsso;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.hust.springbootsso")
//@ComponentScan(basePackages = {"com.hust.springbootsso"})
@EnableCaching//开启缓存
public class SpringbootSsoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSsoApplication.class, args);
    }

}
