package com.kuls.controller;

import com.kuls.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/26 5:44 下午
 */
@Controller
@RequestMapping("/user")
public class UserController {

    //RequestParam：只要是和前端发送关系的，最好都加上这个注解

    //Model
    //ModelMap
    //ModelAndView
    @RequestMapping("/t1")
    public String test1(@RequestParam("username") String name, Model model){

        model.addAttribute("msg",name);
        return "test";
    }


    //如果前端传过来的是一个对象，需要保证表单传送过来的数据和对象属性相对应
    @RequestMapping("/t2")
    public String test2(User user){
        System.out.println(user);
        return "test";
    }
}
