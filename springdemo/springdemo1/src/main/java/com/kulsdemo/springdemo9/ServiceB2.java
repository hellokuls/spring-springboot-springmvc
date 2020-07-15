package com.kulsdemo.springdemo9;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/14 5:28 下午
 */
public class ServiceB2 {

    public void say() {
        ServiceA2 serviceA2 = this.getServiceA2();
        System.out.println("this:" + this + ",serviceA:" + serviceA2);
    }

    public ServiceA2 getServiceA2() { //@1
        return null;
    }
}
