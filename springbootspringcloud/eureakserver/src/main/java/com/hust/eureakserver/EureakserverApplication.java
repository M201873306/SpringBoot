package com.hust.eureakserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EureakserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(EureakserverApplication.class, args);
    }

}
