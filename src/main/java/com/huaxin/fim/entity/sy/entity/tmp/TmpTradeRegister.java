package com.huaxin.fim.entity.sy.entity.tmp;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 交易注册导出类
 * @author shenwei
 *
 */
public class TmpTradeRegister implements Serializable{

	private static final long serialVersionUID = 1L;
	// id
	private long id;
	
	// 唯一标识号
	private String clientID;
	
	// 唯一标识号
	private String clientContractID;
	
	// 业务代码
	private String businessCode;
	
	// 基金代码
	private String fundProductID;
	
	// 份额类型
	private String shareType;
	
	// 申请金额
	private BigDecimal applyAmount;
	
	// 申请份额
	private BigDecimal applyShare;
	
	// 份额级别
	private String shareGrade;
	
	// 申请日期
	private String applyDate;
	
	// 备注
	private String remarks;
	
	// 客户名
	private String clientName;
	
	// 客户类型
	private String clientType;
	
	// 证件类型
	private String idType;
	
	// 证件号码
	private String idNumber;
	
	// 银行名
	private String bankName;
	
	// 银行账号
	private String bankAccount;
	
	// 合同号
	private String contractID;
	
	// 银行代码
	private String bankID;
	
	// 是否到账
	private String isToAccount;
	
	// 确认到账的操作员
	private String confirmOperatorID;

	// 确认到账的日期
	private String confirmOperateDate;

	// 确认到账的时间
	private String confirmOperateTime;
	
	//客户信息加密盐
	private String clientSalt;
	
	//合同信息加密盐
	private String contractSalt;
	
	//手机号码
	private String mobilePhone;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getClientContractID() {
		return clientContractID;
	}

	public void setClientContractID(String clientContractID) {
		this.clientContractID = clientContractID;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getContractID() {
		return contractID;
	}

	public void setContractID(String contractID) {
		this.contractID = contractID;
	}

	public String getBankID() {
		return bankID;
	}

	public void setBankID(String bankID) {
		this.bankID = bankID;
	}

	public String getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}

	public String getFundProductID() {
		return fundProductID;
	}

	public void setFundProductID(String fundProductID) {
		this.fundProductID = fundProductID;
	}

	public String getShareType() {
		return shareType;
	}

	public void setShareType(String shareType) {
		this.shareType = shareType;
	}

	public BigDecimal getApplyAmount() {
		return applyAmount;
	}

	public void setApplyAmount(BigDecimal applyAmount) {
		this.applyAmount = applyAmount;
	}

	public BigDecimal getApplyShare() {
		return applyShare;
	}

	public void setApplyShare(BigDecimal applyShare) {
		this.applyShare = applyShare;
	}

	public String getShareGrade() {
		return shareGrade;
	}

	public void setShareGrade(String shareGrade) {
		this.shareGrade = shareGrade;
	}

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public String getIsToAccount() {
		return isToAccount;
	}

	public void setIsToAccount(String isToAccount) {
		this.isToAccount = isToAccount;
	}

	public String getConfirmOperatorID() {
		return confirmOperatorID;
	}

	public void setConfirmOperatorID(String confirmOperatorID) {
		this.confirmOperatorID = confirmOperatorID;
	}

	public String getConfirmOperateDate() {
		return confirmOperateDate;
	}

	public void setConfirmOperateDate(String confirmOperateDate) {
		this.confirmOperateDate = confirmOperateDate;
	}

	public String getConfirmOperateTime() {
		return confirmOperateTime;
	}

	public void setConfirmOperateTime(String confirmOperateTime) {
		this.confirmOperateTime = confirmOperateTime;
	}

	public String getClientSalt() {
		return clientSalt;
	}

	public void setClientSalt(String clientSalt) {
		this.clientSalt = clientSalt;
	}

	public String getContractSalt() {
		return contractSalt;
	}

	public void setContractSalt(String contractSalt) {
		this.contractSalt = contractSalt;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public TmpTradeRegister(long id, String clientID, String clientContractID, String businessCode,
			String fundProductID, String shareType, BigDecimal applyAmount, BigDecimal applyShare, String shareGrade,
			String applyDate, String remarks, String clientName, String clientType, String idType, String idNumber,
			String bankName, String bankAccount, String contractID, String bankID,String isToAccount,String confirmOperatorID,
			String confirmOperateDate,String confirmOperateTime,String clientSalt,String contractSalt,String mobilePhone) {
		this.id = id;
		this.clientID = clientID;
		this.clientContractID = clientContractID;
		this.businessCode = businessCode;
		this.fundProductID = fundProductID;
		this.shareType = shareType;
		this.applyAmount = applyAmount;
		this.applyShare = applyShare;
		this.shareGrade = shareGrade;
		this.applyDate = applyDate;
		this.remarks = remarks;
		this.clientName = clientName;
		this.clientType = clientType;
		this.idType = idType;
		this.idNumber = idNumber;
		this.bankName = bankName;
		this.bankAccount = bankAccount;
		this.contractID = contractID;
		this.bankID = bankID;
		this.isToAccount = isToAccount;
		this.confirmOperatorID = confirmOperatorID;
		this.confirmOperateDate = confirmOperateDate;
		this.confirmOperateTime = confirmOperateTime;
		this.clientSalt = clientSalt;
		this.contractSalt = contractSalt;
		this.mobilePhone = mobilePhone;
	}

}
