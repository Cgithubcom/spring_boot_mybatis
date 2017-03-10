package com.cone.auth.service;

import java.lang.reflect.InvocationTargetException;

import com.cone.auth.model.vo.SysMenum;
import com.cone.auth.model.vo.SysUserDetails;

public interface ISysResourceService {
	SysMenum queryMenum(String rootId,SysUserDetails user)throws IllegalAccessException, InvocationTargetException;

}
