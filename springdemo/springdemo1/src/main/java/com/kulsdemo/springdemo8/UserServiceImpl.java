package com.kulsdemo.springdemo8;

import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/14 3:42 下午
 */
@Repository("userService")
public class UserServiceImpl implements UserService {

    @Resource(name = "userDao") //相当于配置文件中的<property name="userDao" ref="userDao"/>
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void say() {
        //调用userdao中的say方法
        this.userDao.say();
        System.out.println("userService-----say");
    }
}
