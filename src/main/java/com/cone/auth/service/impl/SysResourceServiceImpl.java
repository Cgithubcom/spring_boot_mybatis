package com.cone.auth.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cone.auth.dao.SysResourceMapper;
import com.cone.auth.model.bo.SysResource;

@Service
public class SysResourceServiceImpl {
	@Autowired
	private SysResourceMapper mapper;
	
	public List<SysResource> getResource(){
		return mapper._queryAllResource();
	}

}
