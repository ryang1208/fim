package com.huaxin.fim.entity.sy.entity.liquidation;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 交易确认信息
 * @author shenwei
 *
 */
@Entity
@Table(name = "t_trade_confirmation")
public class TradeConfirmation implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	// 确认日期
	@Column(name = "confirm_date", length = 8)
	@Length(min = 0, max = 8)
	private String confirmDate;
	
	// 客户名
	@Column(name = "client_name",  length = 100)
	@Length(min = 0, max = 100)
	private String clientName;
	
	// 客户类型
	@Column(name = "client_type", length = 1)
	@Length(min = 0, max = 1)
	private String clientType;
	
	// 证件类型
	@Column(name = "id_type", length = 15)
	@Length(min = 0, max = 15)
	private String idType;
	
	// 证件号码
	@Column(name = "id_number", length = 50)
	@Length(min = 0, max = 50)
	private String idNumber;
	
	// 销售商
	@Column(name = "seller", length = 20)
	@Length(min = 0, max = 20)
	private String seller;
	
	// 基金产品代码
	@Column(name = "fund_product_id", length = 10)
	@Length(min = 0, max = 10)
	private String fundProductID;
	
	// 基金产品名称
	@Column(name = "fund_product_name", length = 15)
	@Length(min = 0, max = 15)
	private String fundProductName;
	
	// 确认状态
	@Column(name = "confirm_status", length = 10)
	@Length(min = 0, max = 10)
	private String confirmStatus;
	
	// 失败原因
	@Column(name = "fail_reason", length = 255)
	@Length(min = 0, max = 255)
	private String failReason;
	
	// 申请金额
	@Column(name = "apply_amount", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private BigDecimal applyAmount;
	
	// 申请份额
	@Column(name = "apply_share", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private BigDecimal applyShare;
	
	// 确认金额
	@Column(name = "confirm_amount", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private BigDecimal confirmAmount;
	
	// 确认份额
	@Column(name = "confirm_share", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private BigDecimal confirmShare;
	
	// 交易费用
	@Column(name = "trade_fee", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private BigDecimal tradeFee;
	
	// 业绩报酬
	@Column(name = "reward", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private BigDecimal reward;
	
	// 总费用
	@Column(name = "total_fee", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private BigDecimal totalFee;
	
	// 归销售机构费用
	@Column(name = "sales_fee", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private BigDecimal salesFee;
	
	// 归基金资金费用
	@Column(name = "fund_product_fee", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private BigDecimal fundProductFee;
	
	// 归管理人费用
	@Column(name = "admin_fee", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private BigDecimal adminFee;
	
	// 单位净值
	@Column(name = "unit_networth", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private BigDecimal unitNetWorth;
	
	// 成交价格
	@Column(name = "trade_price", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private BigDecimal tradePrice;
	
	// 申请日期
	@Column(name = "apply_date", length = 8)
	@Length(min = 0, max = 8)
	private String applyDate;
	
	// 申请时间
	@Column(name = "apply_time", length = 8)
	@Length(min = 0, max = 8)
	private String applyTime;
	
	// 分红方式
	@Column(name = "bonus_type", length = 15)
	@Length(min = 0, max = 15)
	private String bonusType;
	
	// 管理人名称
	@Column(name = "admin_name", length = 10)
	@Length(min = 0, max = 30)
	private String adminName;
	
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(String confirmDate) {
		this.confirmDate = confirmDate;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
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

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getFundProductID() {
		return fundProductID;
	}

	public void setFundProductID(String fundProductID) {
		this.fundProductID = fundProductID;
	}

	public String getFundProductName() {
		return fundProductName;
	}

	public void setFundProductName(String fundProductName) {
		this.fundProductName = fundProductName;
	}

	public String getConfirmStatus() {
		return confirmStatus;
	}

	public void setConfirmStatus(String confirmStatus) {
		this.confirmStatus = confirmStatus;
	}

	public String getFailReason() {
		return failReason;
	}

	public void setFailReason(String failReason) {
		this.failReason = failReason;
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

	public BigDecimal getConfirmAmount() {
		return confirmAmount;
	}

	public void setConfirmAmount(BigDecimal confirmAmount) {
		this.confirmAmount = confirmAmount;
	}

	public BigDecimal getConfirmShare() {
		return confirmShare;
	}

	public void setConfirmShare(BigDecimal confirmShare) {
		this.confirmShare = confirmShare;
	}

	public BigDecimal getTradeFee() {
		return tradeFee;
	}

	public void setTradeFee(BigDecimal tradeFee) {
		this.tradeFee = tradeFee;
	}

	public BigDecimal getReward() {
		return reward;
	}

	public void setReward(BigDecimal reward) {
		this.reward = reward;
	}

	public BigDecimal getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(BigDecimal totalFee) {
		this.totalFee = totalFee;
	}

	public BigDecimal getSalesFee() {
		return salesFee;
	}

	public void setSalesFee(BigDecimal salesFee) {
		this.salesFee = salesFee;
	}

	public BigDecimal getFundProductFee() {
		return fundProductFee;
	}

	public void setFundProductFee(BigDecimal fundPrductFee) {
		this.fundProductFee = fundPrductFee;
	}

	public BigDecimal getAdminFee() {
		return adminFee;
	}

	public void setAdminFee(BigDecimal adminFee) {
		this.adminFee = adminFee;
	}

	public BigDecimal getUnitNetWorth() {
		return unitNetWorth;
	}

	public void setUnitNetWorth(BigDecimal unitNetWorth) {
		this.unitNetWorth = unitNetWorth;
	}

	public BigDecimal getTradePrice() {
		return tradePrice;
	}

	public void setTradePrice(BigDecimal tradePrice) {
		this.tradePrice = tradePrice;
	}

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public String getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	public String getBonusType() {
		return bonusType;
	}

	public void setBonusType(String bonusType) {
		this.bonusType = bonusType;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
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

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

}
