package com.kuls.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/26 4:52 下午
 */

@Controller
public class RestfuleController {

    // @GetMapping
    // @PostMapping
    @RequestMapping("add/{a}/{b}")
    public String test(@PathVariable int a,@PathVariable int b, Model model){
        int c = a+b;
        model.addAttribute("msg",c);

        return "test";
    }

}
