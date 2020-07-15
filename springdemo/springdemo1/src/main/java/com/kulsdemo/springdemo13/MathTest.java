package com.kulsdemo.springdemo13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/16 10:04 上午
 */
public class MathTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans13.xml");
        // 动态代理的是接口，所以此处应该转成接口
        MathI mathImpl = (MathI) context.getBean("mathImpl");
        mathImpl.add(1, 2);

    }
}
