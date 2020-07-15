package com.kulsdemo.springdemo15;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/24 2:13 下午
 */

@Component
public class User {

    @Value("kuls")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
