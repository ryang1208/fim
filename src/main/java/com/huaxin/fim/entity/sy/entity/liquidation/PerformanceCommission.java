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
 * 业绩提成流水
 * @author shenwei
 *
 */
@Entity
@Table(name = "t_performance_commission")
public class PerformanceCommission implements Serializable{

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
	@Column(name = "client_name",  length = 10)
	@Length(min = 0, max = 10)
	private String clientName;
	
	// 客户类型
	@Column(name = "client_type", length = 15)
	@Length(min = 0, max = 15)
	private String clientType;
	
	// 销售商
	@Column(name = "seller", length = 20)
	@Length(min = 0, max = 20)
	private String seller;
	
	// 业务类型
	@Column(name = "business_type", length = 20)
	@Length(min = 0, max = 20)
	private String businessType;
	
	// 申请日期
	@Column(name = "apply_date", length = 8)
	@Length(min = 0, max = 8)
	private String applyDate;
	
	// 基金产品代码
	@Column(name = "fund_product_id", length = 10)
	@Length(min = 0, max = 10)
	private String fundProductID;
	
	// 基金名称
	@Column(name = "fund_product_name", length = 15)
	@Length(min = 0, max = 15)
	private String fundProductName;
	
	// 份额注册日期
	@Column(name = "share_reg_date", length = 8)
	@Length(min = 0, max = 8)
	private String shareRegDate;
	
	// 发生份额
	@Column(name = "share_happened", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private BigDecimal shareHappened;
	
	// 期初日期
	@Column(name = "initial_date", length = 8)
	@Length(min = 0, max = 8)
	private String initialDate;
	
	// 期初单位净值
	@Column(name = "initial_unit_networth", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private BigDecimal initialUnitNetWorth;
	
	// 期初累计净值
	@Column(name = "initial_sum_networth", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private BigDecimal initialSumNetWorth;
	
	// 期末单位净值
	@Column(name = "final_unit_networth", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private BigDecimal finalUnitNetWorth;
	
	// 期末累计净值
	@Column(name = "final_sum_networth", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private BigDecimal finalSumNetWorth;
	
	// 当年收益率
	@Column(name = "current_yield", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private BigDecimal currentYield;
	
	// 年化收益率
	@Column(name = "annualized_return", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private BigDecimal annualizedReturn;
	
	// 保底收益率
	@Column(name = "min_yield", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private BigDecimal minYield;
	
	// 管理费
	@Column(name = "management_fee", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private BigDecimal managementFee;
	
	// 应提成/保底金额
	@Column(name = "should_commission_amount", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private BigDecimal shouldCommissionAmount;
	
	// 实际提成/保底金额
	@Column(name = "actual_commission_amount", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private BigDecimal actualCommissionAmount;
	
	// 实际提成/保底份额
	@Column(name = "actual_commission_share", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private BigDecimal actualCommissionShare;
	
	// 分红总金额
	@Column(name = "sum_bonus", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private BigDecimal sumBonus;
	
	// 实际收益
	@Column(name = "actual_income", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private BigDecimal actualIncome;
	
	// 业绩提成比例
	@Column(name = "performance_percentage", length = 10)
	@Length(min = 0, max = 10)
	private String performancePercentage;
	
	// 累计单位分红
	@Column(name = "sum_unit_bonus", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private BigDecimal sumUnitBonus;
	
	// 管理人名称
	@Column(name = "admin_name", length = 10)
	@Length(min = 0, max = 10)
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

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getFundProductName() {
		return fundProductName;
	}

	public void setFundProductName(String fundProductName) {
		this.fundProductName = fundProductName;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public String getShareRegDate() {
		return shareRegDate;
	}

	public void setShareRegDate(String shareRegDate) {
		this.shareRegDate = shareRegDate;
	}

	public BigDecimal getShareHappened() {
		return shareHappened;
	}

	public void setShareHappened(BigDecimal shareHappened) {
		this.shareHappened = shareHappened;
	}

	public String getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(String initialDate) {
		this.initialDate = initialDate;
	}

	public BigDecimal getInitialUnitNetWorth() {
		return initialUnitNetWorth;
	}

	public void setInitialUnitNetWorth(BigDecimal initialUnitNetWorth) {
		this.initialUnitNetWorth = initialUnitNetWorth;
	}

	public BigDecimal getInitialSumNetWorth() {
		return initialSumNetWorth;
	}

	public void setInitialSumNetWorth(BigDecimal initialSumNetWorth) {
		this.initialSumNetWorth = initialSumNetWorth;
	}

	public BigDecimal getFinalUnitNetWorth() {
		return finalUnitNetWorth;
	}

	public void setFinalUnitNetWorth(BigDecimal finalUnitNetWorth) {
		this.finalUnitNetWorth = finalUnitNetWorth;
	}

	public BigDecimal getFinalSumNetWorth() {
		return finalSumNetWorth;
	}

	public void setFinalSumNetWorth(BigDecimal finalSumNetWorth) {
		this.finalSumNetWorth = finalSumNetWorth;
	}

	public BigDecimal getCurrentYield() {
		return currentYield;
	}

	public void setCurrentYield(BigDecimal currentYield) {
		this.currentYield = currentYield;
	}

	public BigDecimal getAnnualizedReturn() {
		return annualizedReturn;
	}

	public void setAnnualizedReturn(BigDecimal annualizedReturn) {
		this.annualizedReturn = annualizedReturn;
	}

	public BigDecimal getMinYield() {
		return minYield;
	}

	public void setMinYield(BigDecimal minYield) {
		this.minYield = minYield;
	}

	public BigDecimal getManagementFee() {
		return managementFee;
	}

	public void setManagementFee(BigDecimal managementFee) {
		this.managementFee = managementFee;
	}

	public BigDecimal getShouldCommissionAmount() {
		return shouldCommissionAmount;
	}

	public void setShouldCommissionAmount(BigDecimal shouldCommissionAmount) {
		this.shouldCommissionAmount = shouldCommissionAmount;
	}

	public BigDecimal getActualCommissionAmount() {
		return actualCommissionAmount;
	}

	public void setActualCommissionAmount(BigDecimal actualCommissionAmount) {
		this.actualCommissionAmount = actualCommissionAmount;
	}

	public BigDecimal getActualCommissionShare() {
		return actualCommissionShare;
	}

	public void setActualCommissionShare(BigDecimal actualCommissionShare) {
		this.actualCommissionShare = actualCommissionShare;
	}

	public BigDecimal getSumBonus() {
		return sumBonus;
	}

	public void setSumBonus(BigDecimal sumBonus) {
		this.sumBonus = sumBonus;
	}

	public BigDecimal getActualIncome() {
		return actualIncome;
	}

	public void setActualIncome(BigDecimal actualIncome) {
		this.actualIncome = actualIncome;
	}

	public String getPerformancePercentage() {
		return performancePercentage;
	}

	public void setPerformancePercentage(String performancePercentage) {
		this.performancePercentage = performancePercentage;
	}

	public BigDecimal getSumUnitBonus() {
		return sumUnitBonus;
	}

	public void setSumUnitBonus(BigDecimal sumUnitBonus) {
		this.sumUnitBonus = sumUnitBonus;
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

	public String getFundProductID() {
		return fundProductID;
	}

	public void setFundProductID(String fundProductID) {
		this.fundProductID = fundProductID;
	}

}
