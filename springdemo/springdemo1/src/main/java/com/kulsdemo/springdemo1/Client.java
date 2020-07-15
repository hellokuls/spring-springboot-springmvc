package com.kulsdemo.springdemo1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/10 3:52 下午
 */
public class Client {

    public static void main(String[] args) {
        String beanXml = "beans.xml";

        ClassPathXmlApplicationContext c = new ClassPathXmlApplicationContext(beanXml);

        System.out.println("当前容器中所含有的beans：");

        for (String beanName : c.getBeanDefinitionNames()){
            System.out.println(beanName + "：" + c.getBean(beanName));
        }

        //多次获取createByFactoryBean看看是否是同一个对象
        System.out.println("createByFactoryBean:" + c.getBean("createByFactoryBean"));
        System.out.println("createByFactoryBean:" + c.getBean("createByFactoryBean"));
    }
}
