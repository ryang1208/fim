package com.huaxin.fim.entity.entity;

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

/*
 * ctp资金表
 */
@Entity
/*@Table(name = "t_raw_ctp_invester_fund", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "date", "invester_id"})})*/
@Table(name = "t_raw_hs_invester_fund")
public class HSCTPInvesterFund implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// 序号（自动编号）
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;	
	
	//日期,格式：YYYY-MM-DD
	@Column(name = "date", nullable = false, length = 10)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 10)
	private String date;
	
	//客户内部资金账户
	@Column(name = "invester_id", nullable = false, length = 18)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 18)
	private String investerID;
	
	//期初结存 
	@Column(name = "balance_yesterday", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal balanceYesterday;
		
	//期末结存
	@Column(name = "balance_today", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal balanceToday;
	
	//基础保证金
	@Column(name = "basic_margin", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal basicMargin;
	
	//保证金占用
	@Column(name = "margin_occupied", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal marginOccupied;
		
	//出入金
	@Column(name = "deposit_withdraw_today", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal depositWithdrawToday;
	
	//平仓盈亏
	@Column(name = "close_profit", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal closeProfit;
	
	//质押金
	@Column(name = "quality_deposit", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal qualityDeposit;
	
	//浮动盈亏(逐笔)
	@Column(name = "accumulated_profit", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal accumulatedProfit;
	
	//持仓盯市盈亏  
	@Column(name = "totProfit", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal totProfit;
	
	//客户权益
	@Column(name = "invester_equity", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal investerEquity;
		
	//手续费(当日)
	@Column(name = "commission_toady", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal commissionToady;
	
	//市值权益
	@Column(name = "market_equity", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal marketEquity;
	
	//质押变化金额
	@Column(name = "pedge_change_amount", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal pedgeChangeAmount;
	
	//可用资金
	@Column(name = "available", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal available;
	
	// decimal(20,4) comment '权利金收入',
	@Column(name = "premium_income", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal premiumIncome;
	
	//风险度
	@Column(name = "risk_degree", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal riskDegree;
	
	//权利金支出
	@Column(name = "premium_payment", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal premiumPayment;
	
	//应追加资金
	@Column(name = "margin_call", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal marginCall;

	// 数据来源
	@Column(name = "data_source")
	private int dataSource;

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

	public BigDecimal getBalanceYesterday() {
		return balanceYesterday;
	}

	public void setBalanceYesterday(BigDecimal balanceYesterday) {
		this.balanceYesterday = balanceYesterday;
	}

	public BigDecimal getBasicMargin() {
		return basicMargin;
	}

	public void setBasicMargin(BigDecimal basicMargin) {
		this.basicMargin = basicMargin;
	}

	public BigDecimal getDepositWithdrawToday() {
		return depositWithdrawToday;
	}

	public void setDepositWithdrawToday(BigDecimal depositWithdrawToday) {
		this.depositWithdrawToday = depositWithdrawToday;
	}


	public BigDecimal getCloseProfit() {
		return closeProfit;
	}

	public void setCloseProfit(BigDecimal closeProfit) {
		this.closeProfit = closeProfit;
	}

	public BigDecimal getQualityDeposit() {
		return qualityDeposit;
	}

	public void setQualityDeposit(BigDecimal qualityDeposit) {
		this.qualityDeposit = qualityDeposit;
	}

	public BigDecimal getAccumulatedProfit() {
		return accumulatedProfit;
	}

	public void setAccumulatedProfit(BigDecimal accumulatedProfit) {
		this.accumulatedProfit = accumulatedProfit;
	}

	public BigDecimal getTotProfit() {
		return totProfit;
	}

	public void setTotProfit(BigDecimal totProfit) {
		this.totProfit = totProfit;
	}

	public BigDecimal getInvesterEquity() {
		return investerEquity;
	}

	public void setInvesterEquity(BigDecimal investerEquity) {
		this.investerEquity = investerEquity;
	}


	public BigDecimal getCommissionToady() {
		return commissionToady;
	}

	public void setCommissionToady(BigDecimal commissionToady) {
		this.commissionToady = commissionToady;
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

	public BigDecimal getAvailable() {
		return available;
	}

	public void setAvailable(BigDecimal available) {
		this.available = available;
	}

	public BigDecimal getRiskDegree() {
		return riskDegree;
	}

	public void setRiskDegree(BigDecimal riskDegree) {
		this.riskDegree = riskDegree;
	}

	public BigDecimal getMarginCall() {
		return marginCall;
	}

	public void setMarginCall(BigDecimal marginCall) {
		this.marginCall = marginCall;
	}

	public int getDataSource() {
		return dataSource;
	}

	public void setDataSource(int dataSource) {
		this.dataSource = dataSource;
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

	public BigDecimal getBalanceToday() {
		return balanceToday;
	}

	public void setBalanceToday(BigDecimal balanceToday) {
		this.balanceToday = balanceToday;
	}

	public BigDecimal getMarginOccupied() {
		return marginOccupied;
	}

	public void setMarginOccupied(BigDecimal marginOccupied) {
		this.marginOccupied = marginOccupied;
	}
	
	
	
}
