package com.kulsdemo.springdemo3;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/11 9:36 上午
 */
public class DiTest {
    /**
     * 通过构造器的参数索引注入
     */
    @Test
    public void diByConstructorParamIndex(){
        //参数位置的注入对参数顺序有很强的依赖性，若构造函数参数位置被人调整过，会导致注入出错。
        //不过通常情况下，不建议去在代码中修改构造函数，如果需要新增参数的，可以新增一个构造函数来实现，这算是一种扩展，不会影响目前已有的功能。
        String beanXml = "beans3.xml";
        ClassPathXmlApplicationContext context = IocUtils.context(beanXml);
        System.out.println(context.getBean("diByConstructorParamIndex"));
    }

    /**
     * 通过构造器的参数类型注入
     */
    @Test
    public void diByConstructorParamType() {
        //实际上按照参数位置或者按照参数的类型注入，都有一个问题，很难通过bean的配置文件，知道这个参数是对应UserModel中的那个属性的，
        // 代码的可读性不好，比如我想知道这每个参数对应UserModel中的那个属性，必须要去看UserModel的源码
        String beanXml = "beans3.xml";
        ClassPathXmlApplicationContext context = IocUtils.context(beanXml);
        System.out.println(context.getBean("diByConstructorParamType"));
    }


    /**
     * 通过构造器的参数名称注入
     */
    @Test
    public void diByConstructorParamName() {
        String beanXml = "beans3.xml";
        ClassPathXmlApplicationContext context = IocUtils.context(beanXml);
        System.out.println(context.getBean("diByConstructorParamName"));
    }


    /**
     * 通过setter方法注入
     */
    @Test
    public void diBySetter() {

        //setter注入相对于构造函数注入要灵活一些，构造函数需要指定对应构造函数中所有参数的值，
        // 而setter注入的方式没有这种限制，不需要对所有属性都进行注入，可以按需进行注入。
        String beanXml = "beans3.xml";
        ClassPathXmlApplicationContext context = IocUtils.context(beanXml);
        System.out.println(context.getBean("diBySetter"));
    }


    @Test
    public void diBean(){
        String beanXml = "beans3.xml";
        ClassPathXmlApplicationContext context = IocUtils.context(beanXml);
        System.out.println(context.getBean("diBeanByConstructor"));
        System.out.println(context.getBean("diBeanBySetter"));
    }


    /**
     * 其他各种类型注入
     */
    @Test
    public void diOtherType() {
        String beanXml = "beans3.xml";
        ClassPathXmlApplicationContext context = IocUtils.context(beanXml);
        System.out.println(context.getBean("diOtherType"));
    }


}



