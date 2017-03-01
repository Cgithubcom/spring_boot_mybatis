package com.cone.demo.controller;

import com.alibaba.fastjson.JSON;
import com.cone.demo.dao.UserMapper;
import com.cone.demo.model.bo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by pactera on 2017/2/6.
 */
@Controller
@RequestMapping("/demo")
public class DemoController {
    @Value("${other.name}")
    private String name;
    @Value("${other.code}")
    private String code;
    @Autowired
    private UserMapper mapper;

    @RequestMapping("/index")
    @ResponseBody
    String home() {
        return "Hello World!<br>name:"+name+"<br>code:"+code;
    }
    @RequestMapping("/test")
    String test(Model model) {
        model.addAttribute("name","desar都是");
        return "test";
    }
    @RequestMapping("/main")
    String main(Model model) {
        return "main";
    }
    @RequestMapping("/rest/{id}")
    @ResponseBody
    List<User> rest(@PathVariable("id") String id){
        List<User> list=mapper._queryAll();
        //String str= JSON.toJSONString(list);
        //return "id"+id+"<br>"+str;
        return list;
    }
}
