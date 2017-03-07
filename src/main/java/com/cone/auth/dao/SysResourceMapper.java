package com.cone.auth.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.cone.auth.model.bo.SysResource;
import com.cone.utils.mybatisConfig.MyMapper;

@Mapper
public interface SysResourceMapper extends MyMapper<SysResource>{
	/*获取所有普通资源（resource_type='0'）及其权限列表，**/
	List<SysResource> _queryAllResource();
}
