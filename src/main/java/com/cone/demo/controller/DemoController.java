package com.cone.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by pactera on 2017/2/6.
 */
@Controller
public class DemoController {
    @Value("${other.name}")
    private String name;
    @Value("${other.code}")
    private String code;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!<br>name:"+name+"<br>code:"+code;
    }
    @RequestMapping("/test")
    String test() {
        return "test";
    }
}
