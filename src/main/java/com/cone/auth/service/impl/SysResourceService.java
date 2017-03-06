package com.cone.auth.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.cone.auth.model.bo.SysResource;
import com.cone.auth.model.bo.SysRole;

@Service
public class SysResourceService {
	public List<SysResource> getResource(){
		List<SysResource> list=new ArrayList<SysResource>();
		SysResource sr1=new SysResource();
		sr1.setId("1");
		sr1.setType("1");
		sr1.setUrl("/demo/role/test/user");
		SysRole rol1=new SysRole();
		rol1.setId("1");
		rol1.setName("ROLE_USER");
		rol1.setStatus("1");
		List<SysRole> roles=new ArrayList<SysRole>();
		roles.add(rol1);
		sr1.setRoles(roles);
		list.add(sr1);
		
		SysResource sr2=new SysResource();
		sr2.setId("1");
		sr2.setType("1");
		sr2.setUrl("/demo/role/test/admin");
		SysRole rol2=new SysRole();
		rol2.setId("1");
		rol2.setName("ROLE_admin");
		rol2.setStatus("1");
		List<SysRole> roles2=new ArrayList<SysRole>();
		roles2.add(rol2);
		sr2.setRoles(roles2);
		list.add(sr2);
		return list;
	}

}
