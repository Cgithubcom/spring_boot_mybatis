package com.cone.auth.model.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.cone.auth.model.bo.SysRole;

public class SysUserDetails implements UserDetails{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String loginName;
    private String name;
    private String pwd;
    private List<SysRole> roles;

    
    /****************Override***********/
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		  List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
	        List<SysRole> roles = this.getRoles();
	        for (SysRole role : roles) {
	            auths.add(new SimpleGrantedAuthority(role.getCode()));
	        }
	        return auths;
	}

	@Override
	public String getPassword() {
		return this.pwd;
	}

	@Override
	public String getUsername() {
		return this.loginName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	
	
	
	/*******************get set******/
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public List<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}
}
