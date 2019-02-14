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
 * 数据权限产品机构表对应的实体类
 * @author wucq
 */
@Entity
@Table(name = "t_organization_product_data_authority")
public class OrganizationProductDataAuthority {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	// 序号（自动编号）
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	// 产品代码
	@Column(name = "product_id", length = 30)
	@Length(min = 1, max = 30)
	@NotNull
	@NotBlank
	private String productId;
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
    private String productName;
	
	@Transient
	private String investmentId;
	
	@Transient
	private String organizationName;
	
	@Transient
    private String companyName;
	
	//是否组合产品
	@Transient
	private String isPortfolios;
	
	//是否自主发行
	@Transient
	private String isIndependent;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
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
	public String getWriteListSet() {
		return writeListSet;
	}
	public void setWriteListSet(String writeListSet) {
		this.writeListSet = writeListSet;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getIsPortfolios() {
		return isPortfolios;
	}
	public void setIsPortfolios(String isPortfolios) {
		this.isPortfolios = isPortfolios;
	}
	public String getIsIndependent() {
		return isIndependent;
	}
	public void setIsIndependent(String isIndependent) {
		this.isIndependent = isIndependent;
	}
	public String getInvestmentId() {
		return investmentId;
	}
	public void setInvestmentId(String investmentId) {
		this.investmentId = investmentId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
		
}
