package com.cone.auth.service.impl;

import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.cone.auth.dao.SysUserMapper;
import com.cone.auth.model.bo.SysUser;
import com.cone.auth.model.vo.SysUserDetails;

@Service
public class CustomUserServiceImpl implements UserDetailsService {
	@Autowired
	private SysUserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		SysUserDetails user=findUser(userName);
		if(user==null){
			throw new UsernameNotFoundException("用户名不存在");
		}
		return user;
	}
	
	public SysUserDetails findUser(String userName){
		SysUser user=new SysUser();
		user.setLoginName(userName);
		List<SysUser> list=userMapper._queryUserAndRole(user);
		
		if(list!=null&&list.size()>0){
			SysUser bo=list.get(0);
			SysUserDetails vo=new SysUserDetails();
			try {
				BeanUtils.copyProperties(vo, bo);
			}catch (Exception e) {
				e.printStackTrace();
			}
			return vo;
		}else{
			return null;
		}
	}

}
