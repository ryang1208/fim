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

/**
 * 用户机构权限表实体类
 * @author liumd
 *
 */
@Entity
@Table(name = "t_user_organization_data_authority")
public class UserOrganizationDataAuthority implements Serializable {

	private static final long serialVersionUID = 1L;
	// 序号（自动编号）
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "seq_t_user_organization_data_authority") // 适配oracle等没有主键自增长的数据库，改用sequence
	@Column(name = "id", nullable = false)
	private Long id;
	
	// 机构ID
	@Column(name = "organization_id", length = 30)
	@Length(min = 1, max = 30)
	@NotNull
	@NotBlank
	private String organizationId;

	// 用户ID
	@Column(name = "user_id", length = 30)
	@Length(min = 1, max = 30)
	@NotNull
	@NotBlank
	private String userId;
	
	// 机构类型（1：主机构，2：副机构）
	@Column(name = "organization_type", length = 30)
	@Length(min = 1, max = 30)
	@NotNull
	@NotBlank
	private String organizationType;

	// 权限（1：增，2：删，3：改，4：查）
	@Column(name = "authority", length = 10)
	@Length(min = 1, max = 10)
	@NotNull
	@NotBlank
	private String authority;
	
	@Transient
	private String organizationName;
	
	@Transient
	private String userName;
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOrganizationType() {
		return organizationType;
	}

	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
