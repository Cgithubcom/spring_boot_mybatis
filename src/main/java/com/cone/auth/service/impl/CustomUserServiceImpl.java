package com.cone.auth.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cone.auth.model.vo.SysRoleVO;
import com.cone.auth.model.vo.SysUserVO;

public class CustomUserServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		SysUserVO user=findUser(userName);
		if(user==null){
			throw new UsernameNotFoundException("用户名不存在");
		}
		return user;
	}
	
	public SysUserVO findUser(String userName){
		if (!"t1".equals(userName)) {
			return null;
		}
		SysUserVO user=new SysUserVO();
		user.setId(1L);
		user.setUsername("t1");
		user.setPassword("t1");
		List<SysRoleVO> list=new ArrayList<SysRoleVO>();
		SysRoleVO role=new SysRoleVO();
		role.setId("1");
		role.setName("ROLE_TQ");
		role.setStatus("1");
		user.setRoles(list);
		return user;
	}

}
