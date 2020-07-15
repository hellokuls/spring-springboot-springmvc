package com.kulsdemo.springdemo6;

import com.kulsdemo.springdemo3.IocUtils;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/12 8:25 上午
 */
public class PrimaryTest {

    @Test
    public void normalBean() {
        String beanXml = "beans6.xml";
        ClassPathXmlApplicationContext context = IocUtils.context(beanXml);
        //下面我们通过spring容器的T getBean(Class<T> requiredType)方法获取容器中对应的bean
        NormalBean.IService service = context.getBean(NormalBean.IService.class); //@1
        System.out.println(service);
    }

    @Test
    public void PrimaryBean(){

        String beanXml = "beans6.xml";
        ClassPathXmlApplicationContext context = IocUtils.context(beanXml);
        PrimaryBean.IService service = context.getBean(PrimaryBean.IService.class);
        System.out.println(service);
        PrimaryBean primaryBean = context.getBean(PrimaryBean.class);
        System.out.println(primaryBean);
    }
}
