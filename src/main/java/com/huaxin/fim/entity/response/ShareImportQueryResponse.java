package com.huaxin.fim.entity.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 基金份额条件查询结果对象
 * 
 * @author liumd
 *
 */
public class ShareImportQueryResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	// 基金账号
	private String fundCode;

	// 客户名称
	private String clientName;

	// 客户名称
	private String clientProductId;

	// 客户类型
	private String clientType;

	// 证件类型
	private String certificateType;

	// 证件号码
	private String certificateCode;

	// 产品账号
	private String productCode;

	// 产品名称
	private String productName;

	// 业务类型
	private String businessType;

	// 产品代码（产品表主键）
	private String productId;

	// 申请日期
	private String applyDate;

	// 申请份额
	private BigDecimal applyShare;

	// 确认日期
	private String confirmDate;

	// 确认份额
	private BigDecimal confirmShare;

	// 成交金额
	private BigDecimal dealAmount;

	// 确认金额
	private BigDecimal confirmAmount;

	// 交易费
	private BigDecimal transactionFee;

	// 销售商
	private String sellers;

	// 数据源（1：数据导入，2：手工录入）
	private String dataSource;

	// 更新日期
	private String updateDate;

	// 创建用户
	private String createUser;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getClientProductId() {
		return clientProductId;
	}

	public void setClientProductId(String clientProductId) {
		this.clientProductId = clientProductId;
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

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

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

}
