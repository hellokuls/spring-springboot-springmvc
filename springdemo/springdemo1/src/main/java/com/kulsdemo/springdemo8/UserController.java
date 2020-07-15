package com.kulsdemo.springdemo8;

import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/14 3:46 下午
 */

@Repository("userController")
public class UserController {

@Resource(name = "userService")
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void say(){
        this.userService.say();
        System.out.println("userController----say");
    }
}
