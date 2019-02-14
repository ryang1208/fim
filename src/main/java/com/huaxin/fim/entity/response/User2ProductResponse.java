package com.huaxin.fim.entity.response;

import java.io.Serializable;

/**
 * 詹森，贝塔值返回图表对象
 * @author wcq
 *
 */

public class User2ProductResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2362910122243802929L;

	private String userName;
	private String category;
	private String itemName;
	private String authority;
	private String id;
	private String itemId;
	private String userId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
