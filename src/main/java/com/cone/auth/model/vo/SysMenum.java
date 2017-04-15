package com.cone.auth.model.vo;

import java.util.List;

public class SysMenum {
	private Integer id;
	private String name;
	private String code;
	private String resourceType;
	private Integer parentId;
	private String status;
	private Integer sort;
	private int leve;
	
	private List<SysMenum> cls;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public int getLeve() {
		return leve;
	}

	public void setLeve(int leve) {
		this.leve = leve;
	}

	public List<SysMenum> getCls() {
		return cls;
	}

	public void setCls(List<SysMenum> cls) {
		this.cls = cls;
	}
}
