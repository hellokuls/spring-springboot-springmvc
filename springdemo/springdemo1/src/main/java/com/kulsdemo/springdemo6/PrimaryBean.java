package com.kulsdemo.springdemo6;

import java.util.List;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/12 1:02 下午
 */
public class PrimaryBean {

    public interface IService{}
    public static class ServiceA implements PrimaryBean.IService {}
    public static class ServiceB implements PrimaryBean.IService {}

    private IService service;


    public void setService(IService service) {
        this.service = service;
    }

    public void setService1(List<IService> service) {//@0
        System.out.println(service); //@1
    }

    @Override
    public String toString() {
        return "PrimaryBean{" +
                "service=" + service +
                '}';
    }
}
