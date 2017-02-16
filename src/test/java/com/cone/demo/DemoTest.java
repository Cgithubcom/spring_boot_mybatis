package com.cone.demo;


import com.alibaba.fastjson.JSON;
import com.cone.App;
import com.cone.demo.dao.UserMapper;
import com.cone.demo.model.bo.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
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
public class DemoTest{
    private static Logger log=Logger.getLogger(DemoTest.class);
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
    @Test
    public void selectAll(){
        List<User> list=mapper.selectAll();
        String str= JSON.toJSONString(list);
        System.out.println(str);
    }
    @Test
    public void select(){
        User user=new User();
        user.setUserName("王范德");
        user.setAge(23);
        mapper.insert(user);
    }
    @Test
    public void selectAllPage(){
        PageHelper.startPage(1,4,true);
        //Page<List<User>> p_list=mapper.selectAll();
        List<User> list=mapper.selectAll();
        PageInfo page = new PageInfo(list);
        String str= JSON.toJSONString(page);
        log.info(str);
        System.out.println(str);
    }
}
