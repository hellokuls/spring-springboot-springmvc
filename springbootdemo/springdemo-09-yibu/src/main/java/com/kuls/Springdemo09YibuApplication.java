package com.kuls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync //开启异步
@EnableScheduling //开启定时任务
@SpringBootApplication
public class Springdemo09YibuApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springdemo09YibuApplication.class, args);
    }

}
