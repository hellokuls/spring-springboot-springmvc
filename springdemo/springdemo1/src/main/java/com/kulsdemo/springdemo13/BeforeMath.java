package com.kulsdemo.springdemo13;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/16 7:21 下午
 */
public class BeforeMath implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object target) throws Throwable {

        System.out.println("我在你前面执行哦！！！");
    }
}
