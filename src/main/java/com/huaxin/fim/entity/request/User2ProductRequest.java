package com.huaxin.fim.entity.request;

import java.io.Serializable;

/**
 * 用户产品关联关系查询条件
 * @author liumd
 *
 */
public class User2ProductRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6060579374621048806L;
	private String category;
	private String keyValue;
	private String userId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getKeyValue() {
		return keyValue;
	}
	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}
}
