package com.kulsdemo.springdemo9;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 单例bean中使用多例bean
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/14 5:15 下午
 */
public class LookUpMethodTest {

    @Test
    public void alicationcontextaware() {
        String beanXml = "beans9.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);

        System.out.println(context.getBean(com.kulsdemo.springdemo9.ServiceA.class)); //@1
        System.out.println(context.getBean(com.kulsdemo.springdemo9.ServiceA.class)); //@2

        System.out.println("serviceB中的serviceA");
        com.kulsdemo.springdemo9.ServiceB serviceB = context.getBean(com.kulsdemo.springdemo9.ServiceB.class); //@3
        serviceB.say();
        serviceB.say();
    }

    @Test
    public void lookupmethod() {
        String beanXml = "beans9.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);

        System.out.println(context.getBean(com.kulsdemo.springdemo9.ServiceA1.class)); //@1
        System.out.println(context.getBean(com.kulsdemo.springdemo9.ServiceA1.class)); //@2

        System.out.println("serviceB1中的serviceA1");
        com.kulsdemo.springdemo9.ServiceB1 serviceB1 = context.getBean(com.kulsdemo.springdemo9.ServiceB1.class); //@3
        serviceB1.say();
        serviceB1.say();
    }


    @Test
    public void replacedmethod() {
        String beanXml = "beans9.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);

        System.out.println(context.getBean(ServiceA2.class)); //@1
        System.out.println(context.getBean(ServiceA2.class)); //@2

        System.out.println("serviceB2中的serviceA2");
        ServiceB2 serviceB2= context.getBean(ServiceB2.class); //@3
        serviceB2.say();
        serviceB2.say();
    }

}
