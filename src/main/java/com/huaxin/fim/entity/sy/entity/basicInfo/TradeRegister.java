package com.huaxin.fim.entity.sy.entity.basicInfo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 交易登记
 * @author shenwei
 *
 */
@Entity
@Table(name = "t_trade_register")
public class TradeRegister implements Serializable{

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
		
	// 唯一标识号(contractid+bankid+bankaccount)
	@Column(name = "client_contract_id",nullable=false, length = 70)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 70)
	private String clientContractID;
	
	// 业务代码
	@Column(name = "business_code", length = 5)
	@Length(min = 0, max = 5)
	private String businessCode;
	
	// 基金产品代码
	@Column(name = "fund_product_id", length = 10)
	@Length(min = 0, max = 10)
	private String fundProductID;
	
	// 份额类别
	@Column(name = "share_type", length = 1)
	@Length(min = 0, max = 1)
	private String shareType;
	
	// 申请金额
	@Column(name = "apply_amount", precision = 15, scale = 3)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal applyAmount;
	
	// 申请份额
	@Column(name = "apply_share", precision = 15, scale = 3)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal applyShare;
	
	// 份额级别
	@Column(name = "share_grade", length = 1)
	@Length(min = 0, max = 1)
	private String shareGrade;
	
	// 申请日期
	@Column(name = "apply_date", length = 8)
	@Length(min = 0, max = 8)
	private String applyDate;
	
	// 备注
	@Column(name = "remarks", length = 300)
	@Length(min = 0, max = 300)
	private String remarks;
	
	// 是否到账
	@Column(name = "is_to_account", length = 1)
	@Length(min = 0, max = 1)
	private String isToAccount;

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
	
	
	// 确认到账的操作员
	@Column(name = "confirm_operator_id", length = 20)
	@Length(min = 0, max = 20)
	private String confirmOperatorID;

	// 确认到账的日期
	@Column(name = "confirm_operate_date", length = 8)
	@Length(min = 0, max = 8)
	private String confirmOperateDate;

	// 确认到账的时间
	@Column(name = "confirm_operate_time", length = 8)
	@Length(min = 0, max = 8)
	private String confirmOperateTime;
	
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
	
}
