package com.kulsdemo.springdemo9;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.MethodReplacer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.Method;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/14 5:25 下午
 */

/**
 * servieB2的方法替换者
 */
public class ServiceBMethodReplacer implements MethodReplacer, ApplicationContextAware {
    @Override
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        return this.context.getBean(ServiceA2.class);
    }
    private ApplicationContext context;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        this.context = applicationContext;
    }
}
