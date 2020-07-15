package com.kuls.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kuls.pojo.User;
import com.kuls.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author kuls
 * @Desc 公众号：JAVAandPython君
 * @date 2020/3/27 8:34 上午
 */

@Controller
public class UserController {

    @RequestMapping("/t1")
    @ResponseBody // 使用该注解，他就不会走视图解析器，直接返回字符串
    public String jsontest() throws JsonProcessingException {
        User user = new User("kuls", 19, "男");

        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(user);

        return s;
    }

    @RequestMapping("/t2")
    @ResponseBody // 使用该注解，他就不会走视图解析器，直接返回字符串
    public String jsontest2() {
        User user = new User("kuls", 19, "男");


        return JsonUtils.getJson(user);
    }

    @RequestMapping("/t3")
    @ResponseBody // 使用该注解，他就不会走视图解析器，直接返回字符串
    public String jsontest3(){
        User user = new User("kuls", 19, "男");
        String value = JSON.toJSONString(user);
        return value;
    }
}
