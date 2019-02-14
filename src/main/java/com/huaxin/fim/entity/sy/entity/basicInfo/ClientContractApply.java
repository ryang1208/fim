package com.huaxin.fim.entity.sy.entity.basicInfo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 未复核合同信息
 * @author shenwei
 *
 */
@Entity
@Table(name = "t_client_contract_apply",uniqueConstraints = {@UniqueConstraint(columnNames = {"contract_id","bank_id","bank_account"})})
public class ClientContractApply implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	// 唯一标识号(idtype+idnumber)
	@Column(name = "client_id",nullable=false, length = 25)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 25)
	private String clientID;
		
	// 合同号
	@Column(name = "contract_id", nullable = false, length = 30)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 30)
	private String contractID;
	
	// 唯一标识号(contractid+bankid+bankaccount)
	@Column(name = "client_contract_id",nullable=false, length = 90)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 90)
	private String clientContractID;
	
	// 银行代码
	@Column(name = "bank_id", nullable = false, length = 100)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 100)
	private String bankID;
	
	// 银行账号
	@Column(name = "bank_account", nullable = false, length = 50)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 50)
	private String bankAccount;

	// 开户行信息
	@Column(name = "bank_deposit", length = 50)
	@Length(min = 0, max = 50)
	private String bankDeposit;
	
	// 基金产品代码/基金编码
	@Column(name = "fund_product_id", nullable = false, length = 10)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 10)
	private String fundProductID;
	
	// 操作员
	@Column(name = "operator_id", length = 20)
	@Length(min = 0, max = 20)
	private String operatorID;

	// 操作日期
	@Column(name = "operate_date", length = 8)
	@Length(min = 0, max = 8)
	private String operateDate;

	// 操作时间
	@Column(name = "operate_time", length = 8)
	@Length(min = 0, max = 8)
	private String operateTime;
	
	//盐
	@Column(name = "salt", length = 20)
	@Length(min = 0, max = 20)
	private String salt;
	
	
	public String getFundProductID() {
		return fundProductID;
	}

	public void setFundProductID(String fundProductID) {
		this.fundProductID = fundProductID;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBankID() {
		return bankID;
	}

	public void setBankID(String bankID) {
		this.bankID = bankID;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getContractID() {
		return contractID;
	}

	public void setContractID(String contractID) {
		this.contractID = contractID;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getClientContractID() {
		return clientContractID;
	}

	public void setClientContractID(String clientContractID) {
		this.clientContractID = clientContractID;
	}

	public String getBankDeposit() {
		return bankDeposit;
	}

	public void setBankDeposit(String bankDeposit) {
		this.bankDeposit = bankDeposit;
	}

	public String getOperatorID() {
		return operatorID;
	}

	public void setOperatorID(String operatorID) {
		this.operatorID = operatorID;
	}

	public String getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(String operateDate) {
		this.operateDate = operateDate;
	}

	public String getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

}
