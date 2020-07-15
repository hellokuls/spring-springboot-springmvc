package com.kulsdemo.springdemo14;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/24 1:41 下午
 */
public class MyTest {


    @Test
    public void test(){

        ApplicationContext context = new ClassPathXmlApplicationContext("beans14.xml");
        People people = context.getBean("people",People.class);

        people.getDog().shout();

    }
}
