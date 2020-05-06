package com.eyesmoons.springboot_redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class App {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(App.class,args);
    }
}
