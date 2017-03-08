package com.cone.auth;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.cone.auth.dao.SysResourceMapper;
import com.cone.auth.dao.SysUserMapper;
import com.cone.auth.model.bo.SysResource;
import com.cone.auth.model.bo.SysUser;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserTest {
	private static Logger log=Logger.getLogger(SysUserTest.class);
	@Autowired
	private SysUserMapper userMapper;
	
	@Test
	public void _queryUserAndRole(){
		SysUser user=new SysUser();
		List<SysUser> list=userMapper._queryUserAndRole(user);
		System.out.println(JSON.toJSONString(list));
	}
}
