package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/*
 * 数据权限投顾机构表对应的实体类
 * @author wucq
 */
@Entity
@Table(name = "t_organization_investment_data_authority" )
public class OrganizationInvestmentDataAuthority {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	// 序号（自动编号）
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	// 投顾代码
	@Column(name = "investment_id", length = 30)
	@Length(min = 1, max = 30)
	@NotNull
	@NotBlank
	private String investmentId;
	// 机构代码
	@Column(name = "organization_id", length = 30)
	@Length(min = 1, max = 30)
	@NotNull
	@NotBlank
	private String organizationId;
	// 机构类型（1：主机构，2：副机构）
	@Column(name = "organization_type", length = 30)
	@Length(min = 1, max = 30)
	@NotNull
	@NotBlank
	private String organizationType;
	// 权限（1：增，2：删，3：改，4：查）
	@Column(name = "authority", length = 30)
	@Length(min = 1, max = 30)
	@NotNull
	@NotBlank
	private String authority;
	
	@Transient
	private String writeListSet;
	
	@Transient
    private String companyName;
	
	@Transient
	private String organizationName;
		
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getWriteListSet() {
		return writeListSet;
	}
	public void setWriteListSet(String writeListSet) {
		this.writeListSet = writeListSet;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getInvestmentId() {
		return investmentId;
	}
	public void setInvestmentId(String investmentId) {
		this.investmentId = investmentId;
	}
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
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
