package com.cone.auth.service;

import com.cone.auth.model.bo.SysRole;
import com.cone.utils.Message;
import com.github.pagehelper.PageInfo;

/**
 * Created by lin on 2017/4/15.
 */
public interface ISysRoleService {
    PageInfo queryList(SysRole vo, PageInfo page);
    public Message selectByid(int id);
    Message saveOrUpdate(SysRole bo);
    Message del(int id);
}
