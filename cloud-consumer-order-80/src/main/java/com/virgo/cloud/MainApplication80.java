package com.virgo.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MainApplication80 {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication80.class, args);
    }
}
