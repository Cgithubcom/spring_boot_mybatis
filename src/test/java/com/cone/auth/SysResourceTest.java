package com.cone.auth;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.cone.auth.dao.SysResourceMapper;
import com.cone.auth.model.bo.SysResource;
import com.cone.auth.model.vo.SysMenum;
import com.cone.auth.service.impl.SysResourceServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysResourceTest {

	@Autowired
	private SysResourceMapper resourceMapper;
	@Autowired
	private SysResourceServiceImpl sysResourceService;
	
	@Test
	public void _queryMenum(){
		List<SysResource> list=resourceMapper._queryMenum("0","'ROLE_ADMIN'");
		System.out.println(JSON.toJSONString(list));
	}
	@Test
	public void queryAll(){
		List<SysResource> list=resourceMapper.selectAll();
		System.out.println(JSON.toJSONString(list));
		
	}
	
	@Test
	public void getMenum() throws IllegalAccessException, InvocationTargetException{
		SysMenum m=sysResourceService.queryMenum("0",null);
		System.out.println(JSON.toJSONString(m));
	}

}
