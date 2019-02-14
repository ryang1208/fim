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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用户投顾白名单实体类
 * @author wucq
 *
 */
@Entity
@Table(name = "t_user_investment_data_authority", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "category", "item_id"})})
public class UserInvestmentDataAuthority implements Serializable {

	private static final long serialVersionUID = 1L;
	// 序号（自动编号）
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "seq_t_user_product_data_authority") // 适配oracle等没有主键自增长的数据库，改用sequence
	@Column(name = "id", nullable = false)
	private Long id;
	
	// 用户名称
	@Column(name = "user_id", length = 30)
	@Length(min = 1, max = 30)
	@NotNull
	@NotBlank
	private String userId;

	// 类型（1：投顾,2：机构,3:用户）
	@Column(name = "category", length = 2)
	@Length(min = 1, max = 2)
	@NotNull
	@NotBlank
	private String category;
	
	// ID
	@Column(name = "item_id", length = 30)
	@Length(min = 1, max = 30)
	@NotNull
	@NotBlank
	private String itemId;
	
	// 权限（1：增，2：删，3：改，4：查）
	@Column(name = "authority", length = 10)
	@Length(min = 1, max = 10)
	@NotNull
	@NotBlank
	private String authority;
	

	@Transient
	private String userName;
	
	@Transient
	private String itemName;
	
	@Transient
	private String categoryName;
		
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
}
