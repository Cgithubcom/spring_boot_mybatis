package com.cone.auth.controller;

import com.alibaba.fastjson.JSON;
import com.cone.auth.model.bo.SysRole;
import com.cone.auth.service.ISysResourceService;
import com.cone.auth.service.ISysRoleService;
import com.cone.utils.Message;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lin on 2017/4/15.
 */
@Controller
@RequestMapping("/auth/sysRole")
public class SysRoleAction {
    @Autowired
    private ISysRoleService service;

    @RequestMapping("/listPage")
    public String listPage(){
        return "auth/sysRoleList";
    }
    @RequestMapping("/addOrUpdatePage")
    public String addOrUpdatePage(){

        return "auth/sysRoleAddOrUpdate";
    }
    @RequestMapping("/list")
    @ResponseBody
    public String list(PageInfo page, SysRole vo){
        PageInfo rp=service.queryList(vo,page);
        String json= JSON.toJSONString(rp);
        return json;
    }
    @RequestMapping("/addOrUpdate")
    @ResponseBody
    public String addOrUpdate(SysRole vo){
        Message msg=service.saveOrUpdate(vo);
        String json= JSON.toJSONString(msg);
        return json;
    }
    @RequestMapping("/del")
    @ResponseBody
    public String del(int id){
        Message msg=service.del(id);
        String json= JSON.toJSONString(msg);
        return json;
    }

}
