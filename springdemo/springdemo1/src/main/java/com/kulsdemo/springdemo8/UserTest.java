package com.kulsdemo.springdemo8;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/14 3:50 下午
 */
public class UserTest {
    public static void main(String[] args) {
        String xml = "beans8.xml";
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xml);
        UserController userController = (UserController) applicationContext.getBean("userController");
        userController.say();
    }
}
