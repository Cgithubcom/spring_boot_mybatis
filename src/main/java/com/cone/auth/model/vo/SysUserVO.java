package com.cone.auth.model.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SysUserVO implements UserDetails{
	private static final long serialVersionUID = 1L;
	private Long id;
    private String username;
    private String password;
    
    private List<SysRoleVO> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<SysRoleVO> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRoleVO> roles) {
		this.roles = roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		  List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
	        List<SysRoleVO> roles = this.getRoles();
	        for (SysRoleVO role : roles) {
	            auths.add(new SimpleGrantedAuthority(role.getName()));
	        }
	        return auths;
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
	
	
}