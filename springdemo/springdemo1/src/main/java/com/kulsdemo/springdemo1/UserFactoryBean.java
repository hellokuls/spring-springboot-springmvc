package com.kulsdemo.springdemo1;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.lang.Nullable;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/10 4:31 下午
 */

public class UserFactoryBean implements FactoryBean<UserModel> {
    int count = 1;
    @Nullable
    @Override
    public UserModel getObject() throws Exception { //@1
        UserModel userModel = new UserModel();
        userModel.setName("我是通过FactoryBean创建的第"+count+++ "对象");//@4
        return userModel;
    }

    @Nullable
    @Override
    public Class<?> getObjectType() {
        return UserModel.class; //@2
    }

    @Override
    public boolean isSingleton() {
        //如果返回true则是单例，如果返回false则不是单例
        return true; //@3
    }
}
