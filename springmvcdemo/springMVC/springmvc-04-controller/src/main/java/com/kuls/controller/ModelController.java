package com.kuls.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/26 5:29 下午
 */

@Controller
public class ModelController {

    @RequestMapping("m1/t1/")
   public String test1(Model model){
        model.addAttribute("msg","hello");

        //转发,此处需要把视图解析器关闭
       return "/WEB-INF/jsp/test.jsp";
       // return "forward:/WEB-INF/jsp/test.jsp";

        //重定向
//        return  "redirect:/index.jsp";

   }
}
