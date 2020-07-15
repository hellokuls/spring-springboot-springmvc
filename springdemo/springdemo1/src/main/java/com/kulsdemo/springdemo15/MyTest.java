package com.kulsdemo.springdemo15;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/24 2:15 下午
 */
public class MyTest {

    public static void main(String[] args) {

        //加载注解配置
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        User user = (User) context.getBean("getUser");
        System.out.println(user.getName());
    }
}
