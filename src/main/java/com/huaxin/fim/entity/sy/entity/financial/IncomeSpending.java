package com.huaxin.fim.entity.sy.entity.financial;

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
 * 财务核算-收入支出维护
 * @author JIHB
 *
 */
@Entity
@Table(name = "t_income_spending" , uniqueConstraints = {@UniqueConstraint(columnNames = {"fund_product_id"})} )
public class IncomeSpending implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	// 基金代码
	@Column(name = "fund_product_id", nullable = false, length = 15)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 10)
	private String fundProductID;
	
	//利息调整
	@Column(name = "interest_adjust", nullable = true, length = 20)
	@Length(min = 0, max = 15)
	private String interestAdjust;
	
	//平仓盈亏(gl = gain or loss)
	@Column(name = "liquidate_gl", nullable = true, length = 20)
	@Length(min = 0, max = 15)
	private String liquidateGl;
	
	//顶市盈亏
	@Column(name = "mark_to_market_gl", nullable = true, length = 20)
	@Length(min = 0, max = 15)
	private String markToMarketGl;
	
	//逆回购净收入
	@Column(name = "reverse_repo_income", nullable = true, length = 20)
	@Length(min = 0, max = 15)
	private String reverseRepoIncome;
	
	//旗舰份额
	@Column(name = "flagship_share", nullable = true, length = 20)
	@Length(min = 0, max = 15)
	private String flagshipShare;
	
	//旗舰投资额
	@Column(name = "flagship_investment", nullable = true, length = 20)
	@Length(min = 0, max = 15)
	private String flagshipInvestment;

	//手续费
	@Column(name = "handling_charge", nullable = true, length = 20)
	@Length(min = 0, max = 15)
	private String handlingCharge;
	
	//其它
	@Column(name = "other", nullable = true, length = 20)
	@Length(min = 0, max = 15)
	private String other;
	
	//年初未分配利润
	@Column(name = "beginning_retained_earnings", nullable = true, length = 20)
	@Length(min = 0, max = 15)
	private String beginningRetainedEarnings;
	
	//实收资本
	@Column(name = "paidin_capital", nullable = true, length = 20)
	@Length(min = 0, max = 15)
	private String paidinCapital;
	
	//损益平准金
	@Column(name = "buffer_fund_gl", nullable = true, length = 20)
	@Length(min = 0, max = 15)
	private String bufferFundGl;
	
	//未分配利润
	@Column(name = "retained_earnings", nullable = true, length = 20)
	@Length(min = 0, max = 15)
	private String retainedEarnings;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFundProductID() {
		return fundProductID;
	}

	public void setFundProductID(String fundProductID) {
		this.fundProductID = fundProductID;
	}

	public String getInterestAdjust() {
		return interestAdjust;
	}

	public void setInterestAdjust(String interestAdjust) {
		this.interestAdjust = interestAdjust;
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

	public String getFlagshipShare() {
		return flagshipShare;
	}

	public void setFlagshipShare(String flagshipShare) {
		this.flagshipShare = flagshipShare;
	}

	public String getFlagshipInvestment() {
		return flagshipInvestment;
	}

	public void setFlagshipInvestment(String flagshipInvestment) {
		this.flagshipInvestment = flagshipInvestment;
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

	public String getBufferFundGl() {
		return bufferFundGl;
	}

	public void setBufferFundGl(String bufferFundGl) {
		this.bufferFundGl = bufferFundGl;
	}

	public String getRetainedEarnings() {
		return retainedEarnings;
	}

	public void setRetainedEarnings(String retainedEarnings) {
		this.retainedEarnings = retainedEarnings;
	}
	
}
