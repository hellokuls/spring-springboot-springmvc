package com.kuls.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/28 10:19 上午
 */
@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    @RequestMapping("/goLogin")
    public String goLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpSession httpSession, String username, String password, Model model){

        httpSession.setAttribute("userLoginInfo",username);
        model.addAttribute("username",username);
        return "main";
    }

    @RequestMapping("/goOUT")
    public String goOUT(HttpSession httpSession){
        httpSession.removeAttribute("userLoginInfo");
        return "main";
    }
}
