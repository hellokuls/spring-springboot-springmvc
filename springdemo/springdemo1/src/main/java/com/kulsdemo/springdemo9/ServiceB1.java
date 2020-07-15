package com.kulsdemo.springdemo9;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/14 5:21 下午
 */
public class ServiceB1 {

    public void say() {
        ServiceA1 serviceA1 = this.getServiceA1();
        System.out.println("this:" + this + ",serviceA:" + serviceA1);
    }

    public ServiceA1 getServiceA1() { //@1
        return null; //注意这里返回的是null，我们通过spring对该方法进行拦截
    }

}
