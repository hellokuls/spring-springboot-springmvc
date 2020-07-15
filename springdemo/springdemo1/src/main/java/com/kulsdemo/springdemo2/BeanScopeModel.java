package com.kulsdemo.springdemo2;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/10 4:41 下午
 */
public class BeanScopeModel {

    public BeanScopeModel(String beanScope) {
        System.out.println(String.format("create BeanScopeModel,{sope=%s},{this=%s}", beanScope, this));
    }
}
