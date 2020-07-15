package com.kulsdemo.springdemo12;

import org.springframework.stereotype.Component;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/16 9:53 上午
 */
@Component
public class MathImpl implements MathI {

    @Override
    public void add() {
        System.out.println("我是方法");
    }
}
