package com.kuls.controller;

import com.kuls.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/4/9 9:18 上午
 */


@RestController
public class HelloController {


    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    @ApiOperation("user方法")
    @GetMapping(value = "/user")
    public User user(@ApiParam("user方法中的参数") String name){
        return new User();
    }
}
