package com.kulsdemo.springdemo1;

/**
 * @author kuls
 * @Desc
 * @date 2020/3/10 3:31 下午
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/helloWorld")
public class HelloWorldController {
    @RequestMapping("/index")
    public String index() {
        return "hello world!";
    }
}