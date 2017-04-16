package com.cone.auth.service.impl;

import java.util.List;
import com.cone.auth.dao.SysRoleMapper;
import com.cone.auth.model.bo.SysRole;
import com.cone.auth.service.ISysRoleService;
import com.cone.utils.Message;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by lin on 2017/4/15.
 */
@Service
public class SysRoleSerivceImpl implements ISysRoleService {
    @Autowired
    private SysRoleMapper dao;
    public  PageInfo queryList(SysRole vo, PageInfo page){
        PageHelper.startPage(page.getPageNum(), page.getPageSize(), true);
        List<SysRole>  list=dao.select(vo);
        PageInfo rp=new PageInfo(list);
        return rp;
    }
    public Message selectByid(int id){
        SysRole bo=dao.selectByPrimaryKey(id);
        Message msg=new Message();
        if(bo!=null){
            msg.setData(bo);
            msg.setSucces(true);
            msg.setMsg("操作成功");
        }else{
            msg.setSucces(false);
            msg.setMsg("操作失败，未找到对应的角色！");
        }
        return msg;
    }
    public Message saveOrUpdate(SysRole bo){
        Message msg=new Message();
        int n=0;
        if(StringUtils.isEmpty(bo.getId())){
            n=dao.insert(bo);
        }else{
            n= dao.updateByPrimaryKey(bo);
        }
        if(n>0){
            msg.setData(n);
            msg.setSucces(true);
            msg.setMsg("操作成功");
        }else{
            msg.setSucces(false);
            msg.setMsg("更新或修改失败");
        }
        return msg;
    }
    public Message del(int id){
        Message msg=new Message();
        int n=dao.deleteByPrimaryKey(id);
        if(n>0){
            msg.setData(n);
            msg.setSucces(true);
            msg.setMsg("操作成功");
        }else{
            msg.setSucces(false);
            msg.setMsg("更新或修改失败");
        }
        return msg;
    }
}
