package com.kuls.controller;

import com.kuls.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/28 8:32 上午
 */
@RestController
public class AjaxController {

    @RequestMapping("/t1")
    public String test(){
        return "hello";
    }

    @RequestMapping("/t2")
    public void post(String name, HttpServletResponse httpServletResponse) throws IOException {

        if ("kuls".equals(name)){
            httpServletResponse.getWriter().print("sucess");
        }else {
            httpServletResponse.getWriter().print("fail");
        }

    }

    @RequestMapping("/a1")
    public List<User> a1(){
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("KULS1",19,"男"));
        users.add(new User("KULS2",19,"男"));
        users.add(new User("KULS3",19,"男"));
        users.add(new User("KULS4",19,"男"));
        return users;
    }
}
