package com.kulsdemo.springdemo8;

import org.springframework.stereotype.Repository;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/14 3:39 下午
 */

@Repository("userDao")
//上面的注解，相当于在xml文件中配置了UserDaoImpl类的bean

public class UserDaoImpl implements UserDao{
    @Override
    public void say() {
        System.out.println("userdao----save");
    }
}
