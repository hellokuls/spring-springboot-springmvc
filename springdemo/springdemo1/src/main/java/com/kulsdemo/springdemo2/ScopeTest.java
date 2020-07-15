package com.kulsdemo.springdemo2;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Before;
/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/10 4:43 下午
 */
public class ScopeTest {

    ClassPathXmlApplicationContext context;

    @Before
    public void before() {
        System.out.println("spring容器准备启动.....");
        //1.bean配置文件位置
        String beanXml = "beans2.xml";
        //2.创建ClassPathXmlApplicationContext容器，给容器指定需要加载的bean配置文件
        this.context = new ClassPathXmlApplicationContext(beanXml);
        //BeanScopeModel的构造方法是在容器启动过程中调用的，说明这个bean实例在容器启动过程中就创建好了，放在容器中缓存着
        // 如果bean的lazy-init设置为true那么则是在使用bean时才会创建
        System.out.println("spring容器启动完毕！");
    }

    /**
     * 单例bean
     */
    @Test
    public void singletonBean() {
        System.out.println("---------单例bean，每次获取的bean实例都一样---------");
        System.out.println(context.getBean("singletonBean"));
        System.out.println(context.getBean("singletonBean"));
        System.out.println(context.getBean("singletonBean"));
    }

    /**
     * 多例bean
     */
    @Test
    public void prototypeBean() {
        System.out.println("---------多例bean，每次获取的bean实例都不一样---------");
        System.out.println(context.getBean("prototypeBean"));
        System.out.println(context.getBean("prototypeBean"));
        System.out.println(context.getBean("prototypeBean"));
        //输出中可以看出，容器启动过程中并没有去创建BeanScopeModel对象，
        // 3次获取prototypeBean得到的都是不同的实例，每次获取的时候才会去调用构造方法创建bean实例。
        //多例bean每次获取的时候都会重新创建，如果这个bean比较复杂，创建时间比较长，会影响系统的性能，这个地方需要注意。
    }
}
