package com.kulsdemo.springdemo4;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/11 12:44 下午
 */
/**
 * 构造函数的方式进行自动注入
 */
public class DiAutowireByConstructor {

    public static class BaseServie {
        private String desc;

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        @Override
        public String toString() {
            return "BaseServie{" +
                    "desc='" + desc + '\'' +
                    '}';
        }
    }

    //Service1实现了IService1接口
    public static class Service1 extends BaseServie {
    }

    //Service1实现了IService1接口
    public static class Service2 extends BaseServie {
    }

    private Service1 service1;
    private Service2 service2;

    public DiAutowireByConstructor() { //@0
    }

    public DiAutowireByConstructor(Service1 service1) { //@1
        System.out.println("DiAutowireByConstructor(Service1 service1)");
        this.service1 = service1;
    }

    public DiAutowireByConstructor(Service1 service1, Service2 service2) { //@2
        System.out.println("DiAutowireByConstructor(Service1 service1, Service2 service2)");
        this.service1 = service1;
        this.service2 = service2;
    }

    public Service1 getService1() {
        return service1;
    }

    public void setService1(Service1 service1) {
        this.service1 = service1;
    }

    public Service2 getService2() {
        return service2;
    }

    public void setService2(Service2 service2) {
        this.service2 = service2;
    }

    @Override
    public String toString() {
        return "DiAutowireByConstructor{" +
                "service1=" + service1 +
                ", service2=" + service2 +
                '}';
    }
}