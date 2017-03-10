package com.cone.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cone.auth.model.vo.SysMenum;
import com.cone.auth.service.ISysResourceService;
import com.cone.utils.Message;
import com.cone.utils.UserUtils;

@RestController
@RequestMapping(value="/auth")
public class SysResourceServiceAction {
	@Autowired
	private ISysResourceService service;
	
	@RequestMapping(value="/queryMenum")
	public Message queryMenum(@RequestParam("rootId")String rootId){
		Message msg=new Message();
		try{
			SysMenum m=service.queryMenum(rootId, UserUtils.getCurrentUser());
			msg.setSucces(true);
			msg.setData(m);
			
		}catch(Exception e){
			msg.setSucces(false);
		}
		return msg;
	}

}
