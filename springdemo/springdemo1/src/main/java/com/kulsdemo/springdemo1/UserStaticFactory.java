package com.kulsdemo.springdemo1;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/10 4:21 下午
 */
public class UserStaticFactory {

    /**
     * 静态无参方法创建UserModel
     */
    public static UserModel builderUser1(){

        System.out.println(UserStaticFactory.class + ".buildUser1()");
        UserModel userModel = new UserModel();
        userModel.setName("我是静态无参方法创造的");
        userModel.setAge(20);
        return userModel;
    }

    /**
     *
     * @param name
     * @param age
     * @return
     */
    public static UserModel builderUser2(String name, int age){

        System.out.println(UserStaticFactory.class + ".buildUser2()");

        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setAge(age);
        return userModel;

    }



}
