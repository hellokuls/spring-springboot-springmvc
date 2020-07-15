package com.kulsdemo.springdemo11;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/16 9:14 上午
 */
public class NameProxy implements MethodInterceptor {
    private Object target;

    public NameProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("方法"+method.getName()+"开始执行啦！！！");
        Object result = method.invoke(target, objects);
        System.out.println("方法"+method.getName()+"执行完啦！！！");
        return result;
    }

    public static <T> T createProxy(T target){
        NameProxy nameProxy = new NameProxy(target);
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(nameProxy);
        enhancer.setSuperclass(target.getClass());
        return (T) enhancer.create();

    }
}
