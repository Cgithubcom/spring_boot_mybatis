package com.cone.auth.model.vo;

import java.util.List;

public class SysMenum {
	private String id;
	private String name;
	private String code;
	private String resourceType;
	private String parentId;
	private String status;
	private String sort;
	private int leve;
	
	private List<SysMenum> cls;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public List<SysMenum> getCls() {
		return cls;
	}

	public void setCls(List<SysMenum> cls) {
		this.cls = cls;
	}

	public int getLeve() {
		return leve;
	}

	public void setLeve(int leve) {
		this.leve = leve;
	}

}
