package com.kuls.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/28 10:02 上午
 */
@RestController
public class testController {

    @RequestMapping("t1")
    public String t1(){
        System.out.println("======正在执行controller========");
        return "123123";
    }
}
