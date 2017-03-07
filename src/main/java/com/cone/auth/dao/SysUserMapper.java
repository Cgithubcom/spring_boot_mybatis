package com.cone.auth.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.cone.auth.model.bo.SysUser;
import com.cone.utils.mybatisConfig.MyMapper;

@Mapper
public interface SysUserMapper  extends MyMapper<SysUser> {
	/****根据用户查询匹配的用户信息及权限表********/
	List<SysUser> _queryUserAndRole(SysUser user);
}
