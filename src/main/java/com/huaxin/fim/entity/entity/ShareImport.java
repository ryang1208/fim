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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 份额导入表
 * 
 * @author liumd
 */
@Entity
@Table(name = "t_share_import" , uniqueConstraints = {@UniqueConstraint(columnNames = {"client_name","product_name","business_type","confirm_date"})})
public class ShareImport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "seq_t_share_import") // 适配oracle等没有主键自增长的数据库，改用sequence
	@Column(name = "id", nullable = false)
	private Long id;
	
	// 基金账号
	@Column(name = "fund_code", length = 20)
	private String fundCode;
	
	// 客户名称
	@Column(name = "client_name", length = 50)
	@Length(min = 1, max = 50)
	@NotNull
	@NotBlank
	private String clientName;

	// 客户名称
	@Column(name = "client_product_id", length = 10)
	private String clientProductId;
	
	// 客户类型
	@Column(name = "client_type", length = 2)
	private String clientType;

	public String getClientProductId() {
		return clientProductId;
	}

	public void setClientProductId(String clientProductId) {
		this.clientProductId = clientProductId;
	}

	// 证件类型
	@Column(name = "certificate_type", length = 2)
	private String certificateType;
	
	// 证件号码
	@Column(name = "certificate_code", length = 20)
	private String certificateCode;
	
	// 产品账号
	@Column(name = "product_code", length = 20)
	private String productCode;
	
	// 产品名称
	@Column(name = "product_name", length = 50)
	@NotNull
	@NotBlank
	private String productName;
	
	// 业务类型
	@Column(name = "business_type", length = 2)
	@NotNull
	@NotBlank
	private String businessType;
	
	// 产品代码（产品表主键）
	@Column(name = "product_id", length = 10)
	private String productId;
	
	// 申请日期
	@Column(name = "apply_date", length = 8)
	private String applyDate;
	
	// 申请份额
	@Column(name = "apply_share", precision = 20, scale = 6)
	@Digits(integer = 14, fraction = 6)
	private BigDecimal applyShare;
	
	// 确认日期
	@Column(name = "confirm_date", length = 8)
	@Length(min = 1, max = 8)
	@NotNull
	@NotBlank
	private String confirmDate;
	
	// 确认份额
	@Column(name = "confirm_share", precision = 24, scale = 6)
	@Digits(integer = 18, fraction = 6)
	@NotNull
	private BigDecimal confirmShare;
	
	// 成交金额
	@Column(name = "deal_amount", precision = 20, scale = 6)
	@Digits(integer = 14, fraction = 6)
	private BigDecimal dealAmount;
	
	// 确认金额
	@Column(name = "confirm_amount", precision = 20, scale = 6)
	@Digits(integer = 14, fraction = 6)
	private BigDecimal confirmAmount;
	
	// 交易费
	@Column(name = "transaction_fee", precision = 20, scale = 6)
	@Digits(integer = 14, fraction = 6)
	private BigDecimal transactionFee;
	
	// 销售商
	@Column(name = "sellers", length = 30)
	private String sellers;

	// 数据源（1：数据导入，2：手工录入）
	@Column(name = "data_source", length = 2)
	@NotNull
	@NotBlank
	private String dataSource;
	
	// 更新日期
	@Column(name = "update_date", length = 8)
	@NotNull
	@NotBlank
	private String updateDate;
	
	// 创建用户
	@Column(name = "create_user", length = 20)
	@NotNull
	@NotBlank
	private String createUser;
	
	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFundCode() {
		return fundCode;
	}

	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public String getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}

	public String getCertificateCode() {
		return certificateCode;
	}

	public void setCertificateCode(String certificateCode) {
		this.certificateCode = certificateCode;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}


	public BigDecimal getApplyShare() {
		return applyShare;
	}

	public void setApplyShare(BigDecimal applyShare) {
		this.applyShare = applyShare;
	}

	public String getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(String confirmDate) {
		this.confirmDate = confirmDate;
	}

	public BigDecimal getConfirmShare() {
		return confirmShare;
	}

	public void setConfirmShare(BigDecimal confirmShare) {
		this.confirmShare = confirmShare;
	}

	public BigDecimal getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(BigDecimal dealAmount) {
		this.dealAmount = dealAmount;
	}

	public BigDecimal getConfirmAmount() {
		return confirmAmount;
	}

	public void setConfirmAmount(BigDecimal confirmAmount) {
		this.confirmAmount = confirmAmount;
	}

	public BigDecimal getTransactionFee() {
		return transactionFee;
	}

	public void setTransactionFee(BigDecimal transactionFee) {
		this.transactionFee = transactionFee;
	}

	public String getSellers() {
		return sellers;
	}

	public void setSellers(String sellers) {
		this.sellers = sellers;
	}
	
}