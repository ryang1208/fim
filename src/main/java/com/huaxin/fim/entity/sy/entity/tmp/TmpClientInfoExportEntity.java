package com.huaxin.fim.entity.sy.entity.tmp;

import java.io.Serializable;

/**
 * 客户信息导出实体类
 * @author shenwei
 *
 */
public class TmpClientInfoExportEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	// 客户名
	private String clientName;
		
	// 客户类型
	private String clientType;
	
	// 证件类型
	private String idType;
	
	// 证件号码
	private String idNumber;
	
	// 移动电话
	private String mobilePhone;
	
	// 邮箱地址
	private String mailAddress;
	
	// 地址
	private String address;
	
	// 邮编
	private String postCode;
	
	// 开户日期
	private String regDate;
	
	// 是否复核
	private String status;
	
	// 开户行信息
	private String bankDeposit;
	
	// 银行名称
	private String bankName;
	
	// 银行账号
	private String bankAccount;
	
	//客户信息加密盐
	private String clientSalt;
	
	//合同信息加密盐
	private String contractSalt;
	
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

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBankDeposit() {
		return bankDeposit;
	}

	public void setBankDeposit(String bankDeposit) {
		this.bankDeposit = bankDeposit;
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

}
