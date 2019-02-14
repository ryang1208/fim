package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/*
 * 资金，对应的表
 */
@Entity
@Table(name = "t_raw_cfmmc_cusFund")
public class CFMMCCusFund implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//日期,格式：YYYY-MM-DD
	@Id
	@Column(name = "date", nullable = false, length = 10)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 10)
	private String date;
	
	//客户内部资金账户
	@Id
	@Column(name = "invester_id", nullable = false, length = 18)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 18)
	private String investerID;
	
	//资金权益总额 
	@Column(name = "cash_equity_total", precision = 15, scale = 3)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal cashEquityTotal;
	
	//可用资金
	@Column(name = "available", precision = 15, scale = 3)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal available;
	
	//需追加保证金 
	@Column(name = "margin_call", precision = 15, scale = 3)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal marginCall;
	
	//风险度
	@Column(name = "risk_degree", precision = 15, scale = 3)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal riskDegree;
	
	//上日结存（逐日盯市）
	@Column(name = "balance_yesterday_mark", precision = 15, scale = 3)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal balanceYesterdayMark; 
	
	//上日结存（逐笔对冲）
	@Column(name = "balance_yesterday_hedge", precision = 15, scale = 3)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal balanceYesterdayHedge;
	
	//当日结存（逐日盯市）	Number(15,3)	N   
	@Column(name = "balance_today_mark", precision = 15, scale = 3)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal balanceTodayMark;
	
	//当日结存（逐笔对冲） 
	@Column(name = "balance_today_hedge", precision = 15, scale = 3)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal balanceTodayHedge;
	
	//当日总盈亏（逐日盯市）	  
	@Column(name = "total_profit_today_mark", precision = 15, scale = 3)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal totalProfitTodayMark;
	
	
	//当日总盈亏（逐笔对冲）
	@Column(name = "total_profit_today_hedge", precision = 15, scale = 3)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal totalProfitTodayHedge;
	
	
	//浮动盈亏（逐笔对冲） 
	@Column(name = "accumulated_profit_hedge", precision = 15, scale = 3)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal accumulatedProfitHedge;
	
	//非货币充抵金额 
	@Column(name = "non_monetary_offsetting_amount", precision = 15, scale = 3)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal nonMonetaryOffsettingAmount;
	
	//是否为交易会员
	@Column(name = "is_exchange_member", nullable = false, length = 10)
	@Length(min = 1, max = 10)
	@NotNull
	@NotBlank
	private String isExchangeMember;
	
	//币种
	@Column(name = "currency", nullable = false, length = 5)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 5)
	private String currency;
	
	//实有货币资金  
	@Column(name = "actual_capital", precision = 15, scale = 3)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal actualCapital;
	
	//货币充抵金额 
	@Column(name = "monetary_offsetting_amount", precision = 15, scale = 3)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal monetaryOffsettingAmount;
	
	//其它货币质出金额
	@Column(name = "other_monetary_quality", precision = 15, scale = 3)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal otherMonetaryQuality;
	
	//货币质押保证金占用   
	@Column(name = "money_pledge_margin_occupy", precision = 15, scale = 3)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal moneyPledgeMarginOccupy;
	
	//当日总权利金
	@Column(name = "total_royalty_today", precision = 15, scale = 3)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal totalRoyaltyToday;
	
	//冻结资金
	@Column(name = "cash_frozen", precision = 15, scale = 3)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal cashFrozen;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getInvesterID() {
		return investerID;
	}

	public void setInvesterID(String investerID) {
		this.investerID = investerID;
	}

	public BigDecimal getCashEquityTotal() {
		return cashEquityTotal;
	}

	public void setCashEquityTotal(BigDecimal cashEquityTotal) {
		this.cashEquityTotal = cashEquityTotal;
	}

	public BigDecimal getAvailable() {
		return available;
	}

	public void setAvailable(BigDecimal available) {
		this.available = available;
	}

	public BigDecimal getMarginCall() {
		return marginCall;
	}

	public void setMarginCall(BigDecimal marginCall) {
		this.marginCall = marginCall;
	}

	public BigDecimal getRiskDegree() {
		return riskDegree;
	}

	public void setRiskDegree(BigDecimal riskDegree) {
		this.riskDegree = riskDegree;
	}

	public BigDecimal getBalanceYesterdayMark() {
		return balanceYesterdayMark;
	}

	public void setBalanceYesterdayMark(BigDecimal balanceYesterdayMark) {
		this.balanceYesterdayMark = balanceYesterdayMark;
	}

	public BigDecimal getBalanceYesterdayHedge() {
		return balanceYesterdayHedge;
	}

	public void setBalanceYesterdayHedge(BigDecimal balanceYesterdayHedge) {
		this.balanceYesterdayHedge = balanceYesterdayHedge;
	}

	public BigDecimal getBalanceTodayMark() {
		return balanceTodayMark;
	}

	public void setBalanceTodayMark(BigDecimal balanceTodayMark) {
		this.balanceTodayMark = balanceTodayMark;
	}

	public BigDecimal getBalanceTodayHedge() {
		return balanceTodayHedge;
	}

	public void setBalanceTodayHedge(BigDecimal balanceTodayHedge) {
		this.balanceTodayHedge = balanceTodayHedge;
	}

	public BigDecimal getTotalProfitTodayMark() {
		return totalProfitTodayMark;
	}

	public void setTotalProfitTodayMark(BigDecimal totalProfitTodayMark) {
		this.totalProfitTodayMark = totalProfitTodayMark;
	}

	public BigDecimal getTotalProfitTodayHedge() {
		return totalProfitTodayHedge;
	}

	public void setTotalProfitTodayHedge(BigDecimal totalProfitTodayHedge) {
		this.totalProfitTodayHedge = totalProfitTodayHedge;
	}

	public BigDecimal getAccumulatedProfitHedge() {
		return accumulatedProfitHedge;
	}

	public void setAccumulatedProfitHedge(BigDecimal accumulatedProfitHedge) {
		this.accumulatedProfitHedge = accumulatedProfitHedge;
	}

	public BigDecimal getNonMonetaryOffsettingAmount() {
		return nonMonetaryOffsettingAmount;
	}

	public void setNonMonetaryOffsettingAmount(BigDecimal nonMonetaryOffsettingAmount) {
		this.nonMonetaryOffsettingAmount = nonMonetaryOffsettingAmount;
	}

	public String getIsExchangeMember() {
		return isExchangeMember;
	}

	public void setIsExchangeMember(String isExchangeMember) {
		this.isExchangeMember = isExchangeMember;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getActualCapital() {
		return actualCapital;
	}

	public void setActualCapital(BigDecimal actualCapital) {
		this.actualCapital = actualCapital;
	}

	public BigDecimal getMonetaryOffsettingAmount() {
		return monetaryOffsettingAmount;
	}

	public void setMonetaryOffsettingAmount(BigDecimal monetaryOffsettingAmount) {
		this.monetaryOffsettingAmount = monetaryOffsettingAmount;
	}

	public BigDecimal getOtherMonetaryQuality() {
		return otherMonetaryQuality;
	}

	public void setOtherMonetaryQuality(BigDecimal otherMonetaryQuality) {
		this.otherMonetaryQuality = otherMonetaryQuality;
	}

	public BigDecimal getMoneyPledgeMarginOccupy() {
		return moneyPledgeMarginOccupy;
	}

	public void setMoneyPledgeMarginOccupy(BigDecimal moneyPledgeMarginOccupy) {
		this.moneyPledgeMarginOccupy = moneyPledgeMarginOccupy;
	}

	public BigDecimal getTotalRoyaltyToday() {
		return totalRoyaltyToday;
	}

	public void setTotalRoyaltyToday(BigDecimal totalRoyaltyToday) {
		this.totalRoyaltyToday = totalRoyaltyToday;
	}

	public BigDecimal getCashFrozen() {
		return cashFrozen;
	}

	public void setCashFrozen(BigDecimal cashFrozen) {
		this.cashFrozen = cashFrozen;
	}
	
}
