package com.huaxin.fim.entity.sy.entity.financial;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 财务核算-财务核算
 * @author JIHB
 *
 */
@Entity
@Table(name = "t_calculate")
public class Calculate implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	// 基金代码
	@Column(name = "fund_product_id", nullable = false, length = 15)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 15)
	private String fundProductID;
	
	//核算日期
	@Column(name = "calculate_date", nullable = false, length = 10)
	@Length(min = 0, max = 10)
	private String calculateDate;
	
	//复核净资产
	@Column(name = "check_net_asset", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String checkNetAsset;
	
	//托管方净资产
	@Column(name = "net_asset", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String netAsset;
	
	//国泰净值
	@Column(name = "guotai_iopv", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String guotaiIopv;
	
	//净值
	@Column(name = "iopv", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String iopv;
	
	//收入
	@Column(name = "income", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String income;
	
	//利息收入
	@Column(name = "interest_income", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String interestIncome;
	
	//累计利息收入
	@Column(name = "add_interest_income", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String addInterestIncome;
		
	//平仓盈亏(gl = gain or loss)
	@Column(name = "liquidate_gl", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String liquidateGl;
	
	//盯市盈亏
	@Column(name = "mark_to_market_gl", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String markToMarketGl;
	
	//逆回购净收入
	@Column(name = "reverse_repo_income", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String reverseRepoIncome;
	
	//期权收益
	@Column(name = "option_income", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String optionIncome;
	
	//支出
	@Column(name = "expenditure", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String expenditure;
	
	//管理费
	@Column(name = "management_fee", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String managementFee;
	
	//累计管理费
	@Column(name = "add_management_fee", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String addManagementFee;
	
	
	//托管费
	@Column(name = "trustee_fee", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String trusteeFee;
	
	//累计托管费
	@Column(name = "add_trustee_fee", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String addTrusteeFee;
	
	//运营费
	@Column(name = "operating_charge", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String operatingCharge;
	
	//累计运营费
	@Column(name = "add_operating_charge", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String addOperatingCharge;
	

	//手续费
	@Column(name = "handling_charge", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String handlingCharge;
	
	//其它
	@Column(name = "other", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String other;
	
	//利润
	@Column(name = "profit", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String profit;
	
	//年初未分配利润
	@Column(name = "beginning_retained_earnings", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String beginningRetainedEarnings;
	
	//实收资本
	@Column(name = "paidin_capital", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String paidinCapital;
	
	//未分配利润
	@Column(name = "retained_earnings", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String retainedEarnings;
	
	//旗舰基金收益
	@Column(name = "flagship_income", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String flagshipIncome;
	
	//损益平准金
	@Column(name = "buffer_fund_gl", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String bufferFundGl;
	
	//归档时间
	@Column(name = "create_time", nullable = true, length = 25)
	@Length(min = 0, max = 25)
	private String createTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFundProductID() {
		return fundProductID;
	}

	public String getCalculateDate() {
		return calculateDate;
	}

	public void setCalculateDate(String calculateDate) {
		this.calculateDate = calculateDate;
	}

	public void setFundProductID(String fundProductID) {
		this.fundProductID = fundProductID;
	}

	public String getCheckNetAsset() {
		return checkNetAsset;
	}

	public void setCheckNetAsset(String checkNetAsset) {
		this.checkNetAsset = checkNetAsset;
	}

	public String getGuotaiIopv() {
		return guotaiIopv;
	}

	public void setGuotaiIopv(String guotaiIopv) {
		this.guotaiIopv = guotaiIopv;
	}

	public String getIopv() {
		return iopv;
	}

	public void setIopv(String iopv) {
		this.iopv = iopv;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public String getInterestIncome() {
		return interestIncome;
	}

	public void setInterestIncome(String interestIncome) {
		this.interestIncome = interestIncome;
	}

	public String getLiquidateGl() {
		return liquidateGl;
	}

	public void setLiquidateGl(String liquidateGl) {
		this.liquidateGl = liquidateGl;
	}

	public String getMarkToMarketGl() {
		return markToMarketGl;
	}

	public void setMarkToMarketGl(String markToMarketGl) {
		this.markToMarketGl = markToMarketGl;
	}

	public String getReverseRepoIncome() {
		return reverseRepoIncome;
	}

	public void setReverseRepoIncome(String reverseRepoIncome) {
		this.reverseRepoIncome = reverseRepoIncome;
	}

	public String getOptionIncome() {
		return optionIncome;
	}

	public void setOptionIncome(String optionIncome) {
		this.optionIncome = optionIncome;
	}

	public String getExpenditure() {
		return expenditure;
	}

	public void setExpenditure(String expenditure) {
		this.expenditure = expenditure;
	}

	public String getManagementFee() {
		return managementFee;
	}

	public void setManagementFee(String managementFee) {
		this.managementFee = managementFee;
	}

	public String getTrusteeFee() {
		return trusteeFee;
	}

	public void setTrusteeFee(String trusteeFee) {
		this.trusteeFee = trusteeFee;
	}

	public String getOperatingCharge() {
		return operatingCharge;
	}

	public void setOperatingCharge(String operatingCharge) {
		this.operatingCharge = operatingCharge;
	}

	public String getHandlingCharge() {
		return handlingCharge;
	}

	public void setHandlingCharge(String handlingCharge) {
		this.handlingCharge = handlingCharge;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getBeginningRetainedEarnings() {
		return beginningRetainedEarnings;
	}

	public void setBeginningRetainedEarnings(String beginningRetainedEarnings) {
		this.beginningRetainedEarnings = beginningRetainedEarnings;
	}

	public String getPaidinCapital() {
		return paidinCapital;
	}

	public void setPaidinCapital(String paidinCapital) {
		this.paidinCapital = paidinCapital;
	}

	public String getRetainedEarnings() {
		return retainedEarnings;
	}

	public void setRetainedEarnings(String retainedEarnings) {
		this.retainedEarnings = retainedEarnings;
	}
	
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getProfit() {
		return profit;
	}

	public void setProfit(String profit) {
		this.profit = profit;
	}

	public String getFlagshipIncome() {
		return flagshipIncome;
	}

	public void setFlagshipIncome(String flagshipIncome) {
		this.flagshipIncome = flagshipIncome;
	}

	public String getBufferFundGl() {
		return bufferFundGl;
	}

	public void setBufferFundGl(String bufferFundGl) {
		this.bufferFundGl = bufferFundGl;
	}

	public String getAddInterestIncome() {
		return addInterestIncome;
	}

	public void setAddInterestIncome(String addInterestIncome) {
		this.addInterestIncome = addInterestIncome;
	}

	public String getAddManagementFee() {
		return addManagementFee;
	}

	public void setAddManagementFee(String addManagementFee) {
		this.addManagementFee = addManagementFee;
	}

	public String getAddTrusteeFee() {
		return addTrusteeFee;
	}

	public void setAddTrusteeFee(String addTrusteeFee) {
		this.addTrusteeFee = addTrusteeFee;
	}

	public String getAddOperatingCharge() {
		return addOperatingCharge;
	}

	public void setAddOperatingCharge(String addOperatingCharge) {
		this.addOperatingCharge = addOperatingCharge;
	}

	public String getNetAsset() {
		return netAsset;
	}

	public void setNetAsset(String netAsset) {
		this.netAsset = netAsset;
	}

}
