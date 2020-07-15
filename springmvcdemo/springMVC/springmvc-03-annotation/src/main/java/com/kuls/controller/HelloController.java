package com.kuls.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/26 1:24 下午
 */

@Controller
public class HelloController {

    @RequestMapping("/hello")
        public String Hello(Model model){

        model.addAttribute("msg", "Hello SpringMVC");
        return "hello";

    }

}
