package com.huaxin.fim.entity.request;

import java.io.Serializable;

/**
 * 机构管理查询条件对象
 * @author liumd
 *
 */
public class OrganizationRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6060579374621048806L;
	
	// 机构名称
	private String organizationName;
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

}