package com.cone.auth.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cone.auth.model.bo.SysResource;
import com.cone.utils.mybatisConfig.MyMapper;

@Mapper
public interface SysResourceMapper extends MyMapper<SysResource>{
	/*获取所有普通资源（resource_type='0'）及其权限列表，**/
	List<SysResource> _queryAllResource();
	/*****
	 * 
	 * @param rootId
	 * @param roles 权限集合，例如:"'ROLE_ADMIN','ROLE_SDDS','ROLE_ds'"
	 * @return
	 */
	List<SysResource> _queryMenum(@Param("rootId")String rootId,@Param("roles")String roles);
}
