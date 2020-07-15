package com.kulsdemo.springdemo12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/16 10:04 上午
 */
public class MathTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans12.xml");
        MathI mathImpl = context.getBean("mathImpl", MathI.class);
        mathImpl.add();

    }
}
