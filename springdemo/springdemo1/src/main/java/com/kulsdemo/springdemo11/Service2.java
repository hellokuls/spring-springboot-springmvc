package com.kulsdemo.springdemo11;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/14 7:31 下午
 */
public class Service2 {

    public void m1() {
        System.out.println("我是m1方法");
        this.m2(); //@1
    }

    public void m2() {
        System.out.println("我是m2方法");
    }
}
