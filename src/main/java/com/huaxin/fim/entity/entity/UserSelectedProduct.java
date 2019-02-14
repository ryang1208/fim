package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/*
 * 登录用户选中产品表
 */
@Entity
@Table(name = "t_user_selected_product")
public class UserSelectedProduct implements Serializable {

	private static final long serialVersionUID = 1L;
	// 序号（自动编号）
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "seq_t_user_selected_product") // 适配oracle等没有主键自增长的数据库，改用sequence
	@Column(name = "id", nullable = false)
	private Long id;

	// 登录用户代码
	@Column(name = "user_id", nullable = false, length = 30)
	@Length(min = 1, max = 30)
	private String userId;
	
	// 产品代码
	@Column(name = "product_id", length = 30)
	@Length(min = 1, max = 30)
	@NotNull
	@NotBlank
	private String productId;
	
	@Transient
	private String productName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
}
