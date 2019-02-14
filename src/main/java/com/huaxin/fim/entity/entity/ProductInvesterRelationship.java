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

/*
 * 子产品投資人对应关系表对应的实体类
 */
@Entity
@Table(name = "t_product_invester_relationship", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "product_id", "invester_id", "invester_type", "broker_id"})})
public class ProductInvesterRelationship implements Serializable {

	private static final long serialVersionUID = 1L;
	// 序号（自动编号）
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "seq_t_brokerInvester") // 适配oracle等没有主键自增长的数据库，改用sequence
	@Column(name = "id", nullable = false)
	private Long id;
	
	// 子产品ID
	@Column(name = "product_id")
	private int productID;
	
	// 经济公司投资者ID
	@Column(name = "invester_id", length = 32)
	@Length(min = 1, max = 32)
	@NotNull
	@NotBlank
	private String investerID;
	
	// 投资账户类型1期货公司 2证券公司
	@Column(name = "invester_type", length = 32)
	@Length(min = 1, max = 32)
	@NotNull
	@NotBlank
	private String investerType;
	
	// 投赢汇经纪公司ID
	@Column(name = "broker_id", length = 32)
	private int brokerID;
	
	// 保证金监控中心账号
	@Column(name = "CFMMC_account", length = 32)
	@Length(min = 1, max = 32)
	private String CFMMCAccount;
	
	// 保证金监控中心密码
	@Column(name = "CFMMC_password", length = 32)
	@Length(min = 1, max = 32)
	private String CFMMCPassword;
	
	@Transient
	private String brokerIDStr;
	
	@Transient
	private String productIDStr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getInvesterID() {
		return investerID;
	}

	public void setInvesterID(String investerID) {
		this.investerID = investerID;
	}

	public String getInvesterType() {
		return investerType;
	}

	public void setInvesterType(String investerType) {
		this.investerType = investerType;
	}

	public int getBrokerID() {
		return brokerID;
	}

	public void setBrokerID(int brokerID) {
		this.brokerID = brokerID;
	}

	public String getCFMMCAccount() {
		return CFMMCAccount;
	}

	public void setCFMMCAccount(String cFMMCAccount) {
		CFMMCAccount = cFMMCAccount;
	}

	public String getCFMMCPassword() {
		return CFMMCPassword;
	}

	public void setCFMMCPassword(String cFMMCPassword) {
		CFMMCPassword = cFMMCPassword;
	}

	public String getBrokerIDStr() {
		return brokerIDStr;
	}

	public void setBrokerIDStr(String brokerIDStr) {
		this.brokerIDStr = brokerIDStr;
	}

	public String getProductIDStr() {
		return productIDStr;
	}

	public void setProductIDStr(String productIDStr) {
		this.productIDStr = productIDStr;
	}

	public ProductInvesterRelationship() {
	}

	public ProductInvesterRelationship(String investerID, int brokerID, int productID) {
		this.investerID = investerID;
		this.brokerID = brokerID;
		this.productID = productID;
	}

	
}