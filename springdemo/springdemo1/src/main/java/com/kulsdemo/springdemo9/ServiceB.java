package com.kulsdemo.springdemo9;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/14 5:10 下午
 */
public class ServiceB implements ApplicationContextAware {

    private ApplicationContext context;
    public void say(){
        ServiceA serviceA = this.getServiceA();//@2
        System.out.println("this:"+this+",serviceA:"+ serviceA);
    }

    public ServiceA getServiceA() {
        return this.context.getBean(ServiceA.class);//@3
    }

    //spring容器在创建ServiceB的时候会自动调用setApplicationContext方法。
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        this.context = applicationContext;
    }
}
