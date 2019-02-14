package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/*
 * 经济公司投资者资金表对应实体类
 */
@Entity
@Table(name = "t_invester_fund", uniqueConstraints = { @UniqueConstraint(columnNames = { "date", "invester_id","broker_id" }) })
public class InvesterFund implements Serializable {

	private static final long serialVersionUID = 1L;
	// 交易日期（格式:YYYYMMDD）
	@Id
	@Column(name = "date", length = 8)
	@Length(min = 1, max = 8)
	@NotNull
	@NotBlank
	private String date;
	// 经济公司投资者ID
	@Id
	@Column(name = "invester_id", length = 32)
	@Length(min = 1, max = 32)
	@NotNull
	@NotBlank
	private String investerID;
	
	// 投赢汇经纪公司代号
	@Id
	@Column(name = "broker_id")
	private int brokerID;
	
	// 客户权益
	@Column(name = "invester_equity", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal investerEquity;
	// 浮动盈亏（逐笔）
	@Column(name = "accumulated_profit", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal accumulatedProfit;
	// 平仓盈亏（当日总盈亏逐笔）
	@Column(name = "close_profit", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal closeProfit;
	// 当日手续费
	@Column(name = "commission_toady", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal commissionToady;
	// 冻结资金
	@Column(name = "cash_frozen", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal cashFrozen;
	// 保证金占用
	@Column(name = "margin_occupied", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal marginOccupied;
	// 可用资金
	@Column(name = "available", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal available;
	// 当日结存
	@Column(name = "balance_today", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal balanceToday;
	// 上日结存
	@Column(name = "balance_yesterday", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal balanceYesterday;
	// 风险度
	@Column(name = "risk_degree", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal riskDegree;
	// 当日存取合计
	@Column(name = "deposit_withdraw_today", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal depositWithdrawToday;

	//期货保证金
	@Column(name = "future_margin",precision = 20,scale = 4)
	@Digits(integer = 16,fraction = 4)
	private BigDecimal futureMargin;
	//期权保证金
	@Column(name = "option_margin",precision = 20,scale = 4)
	@Digits(integer = 14,fraction = 4)
	private BigDecimal optionMargin;
	// 实有货币资金
	@Column(name = "currency", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal currency;
	// 追加保证金
	@Column(name = "margin_call", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal marginCall;
	// 当日总权利金
	@Column(name = "premium_today", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal premiumToday;
	// 数据来源
	@Column(name = "data_source")
	private int dataSource;
	// 货币充抵金额
	@Column(name = "monetary_offsetting_amount", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal monetaryOffsettingAmount;
	// 非货币充抵金额
	@Column(name = "non_monetary_offsetting_amount", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal nonMonetaryOffsettingAmount;	
	// 当日总盈亏（盯市）
	@Column(name = "tot_profit", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal totProfit;
	//基础保证金
	@Column(name = "basic_margin", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal basicMargin; 
	//质押金
	@Column(name = "quality_Deposit", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal qualityDeposit;
	//期权执行盈亏
	@Column(name = "option_profit_loss", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal optionProfitLoss;
	//货币质押保证金占用
	@Column(name = "currency_pledge_deposit_occupancy", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal currencyPledgeDepositOccupancy;
	//行权手续费
	@Column(name = "exercise_fee", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal exerciseFee;
	//交割保证金
	@Column(name = "delivery_margin", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal deliveryMargin;
	//交割手续费
	@Column(name = "delivery_commission", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal deliveryCommission;
	//多头期权市值
	@Column(name = "long_option_market_value", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal longOptionMarketValue;
	//空头期权市值
	@Column(name = "short_option_market_value", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal shortOptionMarketValue;
	//市值权益
	@Column(name = "market_equity", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal marketEquity;
	//质押变化金额
	@Column(name = "pedge_change_amount", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal pedgeChangeAmount;
	//权利金收入
	@Column(name = "premium_income", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal premiumIncome;
	//权利金支出
	@Column(name = "premium_payment", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal premiumPayment;
	// 更新日期（格式:YYYYMMDD）
	@Column(name = "update_date", length = 8)
	@Length(min = 1, max = 8)
	private String updateDate;
	
	// 平仓盈亏（盯市）
	@Column(name = "close_profit_market", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal closeProfitMarket;
	
	// 持仓盈亏
	@Column(name = "position_profit_market", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal positionProfitMarket;
	
	@Transient
	private String brokerIDStr;
	
	@Transient
	private BigDecimal initShare;
	
	@Transient
	private String initDate;
	
	public String getInitDate() {
		return initDate;
	}
	public void setInitDate(String initDate) {
		this.initDate = initDate;
	}
	public BigDecimal getInitShare() {
		return initShare;
	}
	public void setInitShare(BigDecimal initShare) {
		this.initShare = initShare;
	}
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
	public int getBrokerID() {
		return brokerID;
	}
	public void setBrokerID(int brokerID) {
		this.brokerID = brokerID;
	}
	public BigDecimal getInvesterEquity() {
		return investerEquity;
	}
	public void setInvesterEquity(BigDecimal investerEquity) {
		this.investerEquity = investerEquity;
	}
	public BigDecimal getAccumulatedProfit() {
		return accumulatedProfit;
	}
	public void setAccumulatedProfit(BigDecimal accumulatedProfit) {
		this.accumulatedProfit = accumulatedProfit;
	}
	public BigDecimal getCloseProfit() {
		return closeProfit;
	}
	public void setCloseProfit(BigDecimal closeProfit) {
		this.closeProfit = closeProfit;
	}
	public BigDecimal getCommissionToady() {
		return commissionToady;
	}
	public void setCommissionToady(BigDecimal commissionToady) {
		this.commissionToady = commissionToady;
	}
	public BigDecimal getCashFrozen() {
		return cashFrozen;
	}
	public void setCashFrozen(BigDecimal cashFrozen) {
		this.cashFrozen = cashFrozen;
	}
	public BigDecimal getMarginOccupied() {
		return marginOccupied;
	}
	public void setMarginOccupied(BigDecimal marginOccupied) {
		this.marginOccupied = marginOccupied;
	}
	public BigDecimal getAvailable() {
		return available;
	}
	public void setAvailable(BigDecimal available) {
		this.available = available;
	}
	public BigDecimal getBalanceToday() {
		return balanceToday;
	}
	public void setBalanceToday(BigDecimal balanceToday) {
		this.balanceToday = balanceToday;
	}
	public BigDecimal getBalanceYesterday() {
		return balanceYesterday;
	}
	public void setBalanceYesterday(BigDecimal balanceYesterday) {
		this.balanceYesterday = balanceYesterday;
	}
	public BigDecimal getRiskDegree() {
		return riskDegree;
	}
	public void setRiskDegree(BigDecimal riskDegree) {
		this.riskDegree = riskDegree;
	}
	public BigDecimal getDepositWithdrawToday() {
		return depositWithdrawToday;
	}
	public void setDepositWithdrawToday(BigDecimal depositWithdrawToday) {
		this.depositWithdrawToday = depositWithdrawToday;
	}
	public BigDecimal getCurrency() {
		return currency;
	}
	public void setCurrency(BigDecimal currency) {
		this.currency = currency;
	}
	public BigDecimal getMarginCall() {
		return marginCall;
	}
	public void setMarginCall(BigDecimal marginCall) {
		this.marginCall = marginCall;
	}
	public BigDecimal getPremiumToday() {
		return premiumToday;
	}
	public void setPremiumToday(BigDecimal premiumToday) {
		this.premiumToday = premiumToday;
	}
	public int getDataSource() {
		return dataSource;
	}
	public void setDataSource(int dataSource) {
		this.dataSource = dataSource;
	}
	public BigDecimal getMonetaryOffsettingAmount() {
		return monetaryOffsettingAmount;
	}
	public void setMonetaryOffsettingAmount(BigDecimal monetaryOffsettingAmount) {
		this.monetaryOffsettingAmount = monetaryOffsettingAmount;
	}
	public BigDecimal getNonMonetaryOffsettingAmount() {
		return nonMonetaryOffsettingAmount;
	}
	public void setNonMonetaryOffsettingAmount(BigDecimal nonMonetaryOffsettingAmount) {
		this.nonMonetaryOffsettingAmount = nonMonetaryOffsettingAmount;
	}
	public BigDecimal getTotProfit() {
		return totProfit;
	}
	public void setTotProfit(BigDecimal totProfit) {
		this.totProfit = totProfit;
	}
	public BigDecimal getBasicMargin() {
		return basicMargin;
	}
	public void setBasicMargin(BigDecimal basicMargin) {
		this.basicMargin = basicMargin;
	}
	public BigDecimal getQualityDeposit() {
		return qualityDeposit;
	}
	public void setQualityDeposit(BigDecimal qualityDeposit) {
		this.qualityDeposit = qualityDeposit;
	}
	public BigDecimal getOptionProfitLoss() {
		return optionProfitLoss;
	}
	public void setOptionProfitLoss(BigDecimal optionProfitLoss) {
		this.optionProfitLoss = optionProfitLoss;
	}
	public BigDecimal getCurrencyPledgeDepositOccupancy() {
		return currencyPledgeDepositOccupancy;
	}
	public void setCurrencyPledgeDepositOccupancy(BigDecimal currencyPledgeDepositOccupancy) {
		this.currencyPledgeDepositOccupancy = currencyPledgeDepositOccupancy;
	}
	public BigDecimal getExerciseFee() {
		return exerciseFee;
	}
	public void setExerciseFee(BigDecimal exerciseFee) {
		this.exerciseFee = exerciseFee;
	}
	public BigDecimal getDeliveryMargin() {
		return deliveryMargin;
	}
	public void setDeliveryMargin(BigDecimal deliveryMargin) {
		this.deliveryMargin = deliveryMargin;
	}
	public BigDecimal getDeliveryCommission() {
		return deliveryCommission;
	}
	public void setDeliveryCommission(BigDecimal deliveryCommission) {
		this.deliveryCommission = deliveryCommission;
	}
	public BigDecimal getLongOptionMarketValue() {
		return longOptionMarketValue;
	}
	public void setLongOptionMarketValue(BigDecimal longOptionMarketValue) {
		this.longOptionMarketValue = longOptionMarketValue;
	}
	public BigDecimal getShortOptionMarketValue() {
		return shortOptionMarketValue;
	}
	public void setShortOptionMarketValue(BigDecimal shortOptionMarketValue) {
		this.shortOptionMarketValue = shortOptionMarketValue;
	}
	public BigDecimal getMarketEquity() {
		return marketEquity;
	}
	public void setMarketEquity(BigDecimal marketEquity) {
		this.marketEquity = marketEquity;
	}
	public BigDecimal getPedgeChangeAmount() {
		return pedgeChangeAmount;
	}
	public void setPedgeChangeAmount(BigDecimal pedgeChangeAmount) {
		this.pedgeChangeAmount = pedgeChangeAmount;
	}
	public BigDecimal getPremiumIncome() {
		return premiumIncome;
	}
	public void setPremiumIncome(BigDecimal premiumIncome) {
		this.premiumIncome = premiumIncome;
	}
	public BigDecimal getPremiumPayment() {
		return premiumPayment;
	}
	public void setPremiumPayment(BigDecimal premiumPayment) {
		this.premiumPayment = premiumPayment;
	}
	
	public String getBrokerIDStr() {
		return brokerIDStr;
	}
	public void setBrokerIDStr(String brokerIDStr) {
		this.brokerIDStr = brokerIDStr;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	@Transient
	private BigDecimal deposit; // 当日入金
	
	@Transient
	private BigDecimal withdrawal; // 当日出金
	
	@Transient
	private BigDecimal profit; // 当日总盈亏

	public BigDecimal getDeposit() {
		return deposit;
	}
	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit;
	}
	public BigDecimal getWithdrawal() {
		return withdrawal;
	}
	public void setWithdrawal(BigDecimal withdrawal) {
		this.withdrawal = withdrawal;
	}
	public BigDecimal getProfit() {
		return profit;
	}
	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}
	public BigDecimal getCloseProfitMarket() {
		return closeProfitMarket;
	}
	public void setCloseProfitMarket(BigDecimal closeProfitMarket) {
		this.closeProfitMarket = closeProfitMarket;
	}
	public BigDecimal getPositionProfitMarket() {
		return positionProfitMarket;
	}
	public void setPositionProfitMarket(BigDecimal positionProfitMarket) {
		this.positionProfitMarket = positionProfitMarket;
	}

	public BigDecimal getFutureMargin() {
		return futureMargin;
	}

	public void setFutureMargin(BigDecimal futureMargin) {
		this.futureMargin = futureMargin;
	}

	public BigDecimal getOptionMargin() {
		return optionMargin;
	}

	public void setOptionMargin(BigDecimal optionMargin) {
		this.optionMargin = optionMargin;
	}
	

}
