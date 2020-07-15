package com.kulsdemo.springdemo7;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/12 4:02 下午
 */
public class ServiceC {
    private String name;
    private ServiceA serviceA;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ServiceA getServiceA() {
        return serviceA;
    }

    public void setServiceA(ServiceA serviceA) {
        this.serviceA = serviceA;
    }

    @Override
    public String toString() {
        return "ServiceC{" +
                "name='" + name + '\'' +
                ", serviceA=" + serviceA +
                '}';
    }
}
