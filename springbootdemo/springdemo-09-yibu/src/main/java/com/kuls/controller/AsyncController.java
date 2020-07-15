package com.kuls.controller;

import com.kuls.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/4/11 2:41 下午
 */
@RestController
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/hello")
    public String hello(){
        asyncService.Hello();
        return "OK";
    }
}
