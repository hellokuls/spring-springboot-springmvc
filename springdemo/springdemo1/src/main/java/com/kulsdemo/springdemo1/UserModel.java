package com.kulsdemo.springdemo1;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/10 3:35 下午
 */
@Getter
@Setter
@ToString
public class UserModel {
    private String name;
    private int age;

    public UserModel(){
        this.name = "我是无参数构造器";
    }

    public UserModel(String name, int age) {
        this.name = name;
        this.age = age;
    }


}

