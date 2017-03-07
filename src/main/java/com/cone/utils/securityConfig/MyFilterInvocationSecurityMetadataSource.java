package com.cone.utils.securityConfig;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import com.cone.auth.model.bo.SysResource;
import com.cone.auth.model.bo.SysRole;
import com.cone.auth.service.impl.SysResourceServiceImpl;

@Component
public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource{
	private AntPathMatcher antMatcher = new AntPathMatcher();
	@Autowired
	private SysResourceServiceImpl sysResourceService;
	
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
    /***********
     * 加载资源权限
     * @param isUpdate，是否为强制更新
     */
    private synchronized void loadResourceDefine(boolean isUpdate) {
    	if(resourceMap!=null&&!isUpdate)return;
        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();  
        List<SysResource> rlist=sysResourceService.getResource();//(new SysResourceService()).getResource();
        for(SysResource resource:rlist){
        	 Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
        	 for(SysRole role:resource.getRoles()){
        		 ConfigAttribute ca = new SecurityConfig(role.getCode());
        		 atts.add(ca);
        	 }
        	 resourceMap.put(resource.getCode(), atts);
        } 
    }    
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}
	@Override
	public Collection<ConfigAttribute> getAttributes(Object arg0) throws IllegalArgumentException {
		if(resourceMap==null){
			loadResourceDefine(false);
		}
		String url = ((FilterInvocation) arg0).getRequestUrl();
		Iterator<String> ite = resourceMap.keySet().iterator();
		while (ite.hasNext()) {
			String resURL = ite.next();
			if (antMatcher.match(resURL, url)) {
				return resourceMap.get(resURL);
			}
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}
