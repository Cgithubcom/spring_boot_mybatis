package com.cone.auth.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cone.auth.dao.SysResourceMapper;
import com.cone.auth.model.bo.SysResource;
import com.cone.auth.model.bo.SysRole;
import com.cone.auth.model.bo.SysUser;
import com.cone.auth.model.vo.SysMenum;
import com.cone.auth.model.vo.SysUserDetails;
import com.cone.auth.service.ISysResourceService;
import com.cone.utils.UserUtils;
import com.github.pagehelper.StringUtil;

@Service
public class SysResourceServiceImpl implements ISysResourceService{
	@Autowired
	private SysResourceMapper mapper;
	
	public List<SysResource> getResource(){
		return mapper._queryAllResource();
	}
	
	public SysMenum queryMenum(String rootId,SysUserDetails user) throws IllegalAccessException, InvocationTargetException{
		if(StringUtil.isEmpty(rootId))return null;
		String roles="''";
		if(user!=null&&user.getRoles()!=null){
			for(SysRole r:user.getRoles()){
				if(r!=null){
					roles+=",'"+r.getCode()+"'";
				}
			}
		}
		List<SysResource> list= mapper._queryMenum(rootId, roles);
		int leve=0;
		if(list!=null&&list.size()>0)
		{
			for(SysResource item:list){
				if(rootId.equals(item.getId())){
					SysMenum m=new SysMenum();
					BeanUtils.copyProperties(m, item);
					m.setLeve(leve);
					m.setCls(getCls(list,m.getId(),leve));
					return m;
				}
			}
		}
		return null;
	}
	@SuppressWarnings("unused")
	private List<SysMenum> getCls(List<SysResource> list,Integer pid,int leve) throws IllegalAccessException, InvocationTargetException{
		List<SysMenum> rs=new ArrayList<SysMenum>();
		leve++;
		if(list!=null){
			for(SysResource item:list){
				if(pid.equals(item.getParentId())){
					SysMenum m=new SysMenum();
					BeanUtils.copyProperties(m, item);
					m.setLeve(leve);
					m.setCls(getCls(list,m.getId(),leve));
					rs.add(m);
				}
			}
			return rs;
		}else{
			return null;
		}
	}
}
