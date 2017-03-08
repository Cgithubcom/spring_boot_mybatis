package com.cone.utils;

import org.springframework.security.core.context.SecurityContextHolder;

import com.cone.auth.model.vo.SysUserDetails;

public class UserUtils {
	public static SysUserDetails getCurrentUser(){
		SysUserDetails user=(SysUserDetails)SecurityContextHolder.getContext()
    		    .getAuthentication()
    		    .getPrincipal();
		return user;
	}

}
