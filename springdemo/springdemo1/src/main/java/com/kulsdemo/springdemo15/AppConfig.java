package com.kulsdemo.springdemo15;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/24 2:13 下午
 */

//这就相当于beans标签
@Configuration
@ComponentScan("com.kulsdemo.springdemo15")
public class AppConfig {


    //这就相当于bean标签
    @Bean
    public User getUser(){
        return new User();
    }
}
