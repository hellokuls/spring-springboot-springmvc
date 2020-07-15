package com.kulsdemo.springdemo5;

import com.kulsdemo.springdemo3.IocUtils;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/11 1:18 下午
 */
public class DependOnTest {
    /**
     * 无依赖的bean创建和销毁的顺序
     */
    @Test
    public void normalBean() {
        //从输出中可以得到2点结论：
        //
        //bean对象的创建顺序和bean xml中定义的顺序一致
        //bean销毁的顺序和bean xml中定义的顺序相反
        System.out.println("容器启动中!");
        String beanXml = "beans5.xml";
        ClassPathXmlApplicationContext context = IocUtils.context(beanXml);

        System.out.println("容器启动完毕，准备关闭spring容器!");
        //关闭容器
        context.close();
        System.out.println("spring容器已关闭!");
    }



    /**
     * 强依赖的bean的创建和销毁顺序测试
     * 从输出中可以得到2点结论：
     *
     * bean对象的创建顺序和bean依赖的顺序一致
     * bean销毁的顺序和bean创建的顺序相反
     */
    @Test
    public void strongDependenceBean() {
        System.out.println("容器启动中!");
        String beanXml = "beans5.xml";
        ClassPathXmlApplicationContext context = IocUtils.context(beanXml);
        System.out.println("容器启动完毕，准备关闭spring容器!");
        context.close();
        System.out.println("spring容器已关闭!");
    }


    /**
     * 通过depend-on来干预bean创建和销毁顺序
     */
    @Test
    public void dependOnBean() {
        System.out.println("容器启动中!");
        String beanXml = "beans5.xml";
        ClassPathXmlApplicationContext context = IocUtils.context(beanXml);
        System.out.println("容器启动完毕，准备关闭spring容器!");
        context.close();
        System.out.println("spring容器已关闭!");
    }


    /**
     *
     */
    @Test
    public void SetterBean() {
        System.out.println("容器启动中!");
        String beanXml = "beans5.xml";
        ClassPathXmlApplicationContext context = IocUtils.context(beanXml);
        System.out.println("容器启动完毕，准备关闭spring容器!");
        context.close();
        System.out.println("spring容器已关闭!");
    }
}
