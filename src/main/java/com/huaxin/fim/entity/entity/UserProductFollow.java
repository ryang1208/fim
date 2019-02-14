package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/*
 * 用户产品关注表对应的实体类
 */
@Entity
@Table(name = "t_user_product_follow", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "login_id", "product_id"})})
public class UserProductFollow implements Serializable {

	private static final long serialVersionUID = 1L;
	// 产品ID
	@Id
	@Column(name = "product_id")
	private int productID;
	// 登入ID
	@Id
	@Column(name = "login_id")
	@NotNull
	@NotBlank
	private String loginID;

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}


	

}
