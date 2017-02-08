package com.cone.demo;


import com.alibaba.fastjson.JSON;
import com.cone.App;
import com.cone.demo.dao.UserMapper;
import com.cone.demo.model.bo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by pactera on 2017/2/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTest {
    @Autowired
    private UserMapper mapper;
    @Value("${other.name}")
    private String name;

    @Test
    public void testInsert(){
        System.out.println(name);
        User user = new User();
        user.setUserName("张三1");
        user.setAge(231);
        mapper.save(user);
        //List<User> list=mapper.queryAll();
        System.out.println("插入用户信息"+user.getUserName());
    }
    @Test
    public void testQueryAll(){
        List<User> list=mapper.queryAll();
        String str= JSON.toJSONString(list);
        System.out.println(str);
    }
}
