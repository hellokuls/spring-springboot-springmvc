package com.kulsdemo.springdemo12;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/16 9:54 上午
 */
@Component
@Aspect
public class MathAspect {

    @Before(value = "execution(public void com.kulsdemo.springdemo12.MathImpl.*(..))")
    public void beforeMethod(){

        System.out.println("方法运行前。。。");
    }

    @After(value = "execution(public void com.kulsdemo.springdemo12.MathImpl.*(..))")
    public void afterMethod(){
        System.out.println("方法运行后。。。");
    }
}
