package com.kuls.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/4/2 8:52 上午
 */
@Controller
public class RouterController {

    @RequestMapping({"/","/index"})
    public String index(){

        return "index";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){

        return "views/login";
    }

    @RequestMapping("/level1/{id}")
    public String level1(@PathVariable("id")int id){

        return "views/level1/"+id;
    }
    @RequestMapping("/level2/{id}")
    public String level2(@PathVariable("id")int id){

        return "views/level2/"+id;
    }
    @RequestMapping("/level3/{id}")
    public String level3(@PathVariable("id")int id){

        return "views/level3/"+id;
    }
}
