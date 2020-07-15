package com.kulsdemo.springdemo2;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/10 5:05 下午
 */

/**
 * 自定义本地线程级别的bean作用域，不同的线程中对应的bean实例是不同的，同一个线程中同名的bean是同一个实例
 */
public class ThreadScope implements Scope {
    public static final String THREAD_SCOPE = "thread";//@1

    private ThreadLocal<Map<String, Object>> beanMap = new ThreadLocal() {
        @Override
        protected Object initialValue() {
            return new HashMap<>();
        }
    };

    /**
     * 返回当前作用域中name对应的bean对象
     * name：需要检索的bean的名称
     * objectFactory：如果name对应的bean在当前作用域中没有找到，那么可以调用这个ObjectFactory来创建这个对象
     **/
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {

        Object bean = beanMap.get().get(name);
        if (Objects.isNull(bean)) {
            bean = objectFactory.getObject();
            beanMap.get().put(name, bean);
        }
        return bean;
    }

    /**
     * 将name对应的bean从当前作用域中移除
     **/
    @Override
    public Object remove(String name) {
        return this.beanMap.get().remove(name);
    }


    /**
     * 用于注册销毁回调，如果想要销毁相应的对象,则由Spring容器注册相应的销毁回调，而由自定义作用域选择是不是要销毁相应的对象
     */
    @Override
    public void registerDestructionCallback(String name, Runnable runnable) {
        //bean作用域范围结束的时候调用的方法，用于bean清理
        System.out.println(name);
    }


    /**
     * 用于解析相应的上下文数据，比如request作用域将返回request中的属性。
     */
    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    /**
     * 作用域的会话标识，比如session作用域将是sessionId
     */
    @Override
    public String getConversationId() {
        return Thread.currentThread().getName();
    }
}
