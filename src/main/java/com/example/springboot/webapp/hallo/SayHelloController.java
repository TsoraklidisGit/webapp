package com.example.springboot.webapp.hallo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello! are you green?";
    }

    @RequestMapping("/hello-jsp")
    public String sayHello2() {
        return "sayHello";
    }
}
