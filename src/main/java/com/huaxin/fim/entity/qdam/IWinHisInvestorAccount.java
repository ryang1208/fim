package com.huaxin.fim.entity.qdam;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "t_his_investor_account", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "settle_date", "brokerid", "investorid" }) })
public class IWinHisInvestorAccount implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "settle_date", nullable = false, length = 8)
	@NotNull
	@NotBlank
	@Length(min = 8, max = 8)
	private String settleDate;
	@Column(name = "brokerid", nullable = false, length = 10)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 10)
	private String brokerageFirmID;
	@Column(name = "investorid", nullable = false, length = 20)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 20)
	private String traderID;
	@Column(name = "accountid", nullable = false, length = 20)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 20)
	private String accountID;
	@Column(name = "prebalance", nullable = false, precision = 19, scale = 3)
	@NotNull
	@Digits(integer = 16, fraction = 3)
	private double preBalance;
	@Column(name = "preavailable", nullable = false, precision = 19, scale = 3)
	@NotNull
	@Digits(integer = 16, fraction = 3)
	private double preAvailable;
	@Column(name = "deposit", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private double deposit;
	@Column(name = "withdraw", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private double withdraw;
	@Column(name = "margin", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private double margin;
	@Column(name = "premium", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private double premium;
	@Column(name = "fee", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private double fee;
	@Column(name = "frozenmargin", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private double frozenMargin;
	@Column(name = "frozenpremium", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private double frozenPremium;
	@Column(name = "frozenfee", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private double frozenFee;
	@Column(name = "closeprofit", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private double closeProfit;
	@Column(name = "manualfrozen", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private double manualfrozen;
	@Column(name = "positionprofit", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private double positionProfit;
	@Column(name = "available", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private double available;
	@Column(name = "balance", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private double balance;
	@Column(name = "longmargin", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private double longMargin;
	@Column(name = "shortmargin", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private double shortMargin;
	@Column(name = "longfrozenmargin", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private double longFrozenMargin;
	@Column(name = "shortfrozenmargin", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private double shortFrozenMargin;
	@Column(name = "dynamicrights", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private double dynamicRights;
	@Column(name = "risk", precision = 22, scale = 8)
	@Digits(integer = 14, fraction = 8)
	private double risk;
	@Column(name = "otherfee", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private double otherFee;
	@Column(name = "mortgage", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private double mortgage;
	@Column(name = "currency", length = 4)
	@Length(min = 1, max = 4)
	private String currency;
	@Column(name = "totalfrozenpos", precision = 16)
	@Digits(integer = 16, fraction = 0)
	private double totalFrozenPos;
	@Column(name = "todayinout", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private double todayInOut;
	@Column(name = "releasemargin", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private double releaseMargin;
	@Column(name = "isprofitcanuse")
	private int isProfitCanUse;
	@Transient
	private BigDecimal totalInterest;
	@Transient
	private BigDecimal totalMarketInterest;
	@Transient
	private String searchType;
	@Transient
	private String beginDate;
	@Transient
	private String endDate;
	@Transient
	private String accountName;
	@Transient
	private String instClientName;
	@Transient
	private String preBalanceStr;
	@Transient
	private String depositStr;
	@Transient
	private String availableStr;
	@Transient
	private String marginStr;
	@Transient
	private String feeStr;
	@Transient
	private String frozenMarginStr;
	@Transient
	private String frozenFeeStr;
	@Transient
	private String closeProfitStr;
	@Transient
	private String positionProfitStr;
	@Transient
	private String riskStr;
	@Transient
	private String dynamicRightsStr;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSettleDate() {
		return this.settleDate;
	}

	public void setSettleDate(String settleDate) {
		this.settleDate = settleDate;
	}

	public String getBrokerageFirmID() {
		return this.brokerageFirmID;
	}

	public void setBrokerageFirmID(String brokerageFirmID) {
		this.brokerageFirmID = brokerageFirmID;
	}

	public String getTraderID() {
		return this.traderID;
	}

	public void setTraderID(String traderID) {
		this.traderID = traderID;
	}

	public String getAccountID() {
		return this.accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public double getPreBalance() {
		return this.preBalance;
	}

	public void setPreBalance(double preBalance) {
		this.preBalance = preBalance;
	}

	public double getPreAvailable() {
		return this.preAvailable;
	}

	public void setPreAvailable(double preAvailable) {
		this.preAvailable = preAvailable;
	}

	public double getDeposit() {
		return this.deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public double getWithdraw() {
		return this.withdraw;
	}

	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}

	public double getMargin() {
		return this.margin;
	}

	public void setMargin(double margin) {
		this.margin = margin;
	}

	public double getPremium() {
		return this.premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	public double getFee() {
		return this.fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public double getFrozenMargin() {
		return this.frozenMargin;
	}

	public void setFrozenMargin(double frozenMargin) {
		this.frozenMargin = frozenMargin;
	}

	public double getFrozenPremium() {
		return this.frozenPremium;
	}

	public void setFrozenPremium(double frozenPremium) {
		this.frozenPremium = frozenPremium;
	}

	public double getFrozenFee() {
		return this.frozenFee;
	}

	public void setFrozenFee(double frozenFee) {
		this.frozenFee = frozenFee;
	}

	public double getCloseProfit() {
		return this.closeProfit;
	}

	public void setCloseProfit(double closeProfit) {
		this.closeProfit = closeProfit;
	}

	public double getManualfrozen() {
		return this.manualfrozen;
	}

	public void setManualfrozen(double manualfrozen) {
		this.manualfrozen = manualfrozen;
	}

	public double getPositionProfit() {
		return this.positionProfit;
	}

	public void setPositionProfit(double positionProfit) {
		this.positionProfit = positionProfit;
	}

	public double getAvailable() {
		return this.available;
	}

	public void setAvailable(double available) {
		this.available = available;
	}

	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getLongMargin() {
		return this.longMargin;
	}

	public void setLongMargin(double longMargin) {
		this.longMargin = longMargin;
	}

	public double getShortMargin() {
		return this.shortMargin;
	}

	public void setShortMargin(double shortMargin) {
		this.shortMargin = shortMargin;
	}

	public double getLongFrozenMargin() {
		return this.longFrozenMargin;
	}

	public void setLongFrozenMargin(double longFrozenMargin) {
		this.longFrozenMargin = longFrozenMargin;
	}

	public double getShortFrozenMargin() {
		return this.shortFrozenMargin;
	}

	public void setShortFrozenMargin(double shortFrozenMargin) {
		this.shortFrozenMargin = shortFrozenMargin;
	}

	public double getDynamicRights() {
		return this.dynamicRights;
	}

	public void setDynamicRights(double dynamicRights) {
		this.dynamicRights = dynamicRights;
	}

	public double getRisk() {
		return this.risk;
	}

	public void setRisk(double risk) {
		this.risk = risk;
	}

	public double getOtherFee() {
		return this.otherFee;
	}

	public void setOtherFee(double otherFee) {
		this.otherFee = otherFee;
	}

	public double getMortgage() {
		return this.mortgage;
	}

	public void setMortgage(double mortgage) {
		this.mortgage = mortgage;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getTotalFrozenPos() {
		return this.totalFrozenPos;
	}

	public void setTotalFrozenPos(double totalFrozenPos) {
		this.totalFrozenPos = totalFrozenPos;
	}

	public double getTodayInOut() {
		return this.todayInOut;
	}

	public void setTodayInOut(double todayInOut) {
		this.todayInOut = todayInOut;
	}

	public double getReleaseMargin() {
		return this.releaseMargin;
	}

	public void setReleaseMargin(double releaseMargin) {
		this.releaseMargin = releaseMargin;
	}

	public int getIsProfitCanUse() {
		return this.isProfitCanUse;
	}

	public void setIsProfitCanUse(int isProfitCanUse) {
		this.isProfitCanUse = isProfitCanUse;
	}

	public BigDecimal getTotalInterest() {
		return this.totalInterest;
	}

	public void setTotalInterest(BigDecimal totalInterest) {
		this.totalInterest = totalInterest;
	}

	public BigDecimal getTotalMarketInterest() {
		return this.totalMarketInterest;
	}

	public void setTotalMarketInterest(BigDecimal totalMarketInterest) {
		this.totalMarketInterest = totalMarketInterest;
	}

	public String getSearchType() {
		return this.searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getInstClientName() {
		return this.instClientName;
	}

	public void setInstClientName(String instClientName) {
		this.instClientName = instClientName;
	}

	public String getPreBalanceStr() {
		return this.preBalanceStr;
	}

	public void setPreBalanceStr(String preBalanceStr) {
		this.preBalanceStr = preBalanceStr;
	}

	public String getDepositStr() {
		return this.depositStr;
	}

	public void setDepositStr(String depositStr) {
		this.depositStr = depositStr;
	}

	public String getAvailableStr() {
		return this.availableStr;
	}

	public void setAvailableStr(String availableStr) {
		this.availableStr = availableStr;
	}

	public String getMarginStr() {
		return this.marginStr;
	}

	public void setMarginStr(String marginStr) {
		this.marginStr = marginStr;
	}

	public String getFeeStr() {
		return this.feeStr;
	}

	public void setFeeStr(String feeStr) {
		this.feeStr = feeStr;
	}

	public String getFrozenMarginStr() {
		return this.frozenMarginStr;
	}

	public void setFrozenMarginStr(String frozenMarginStr) {
		this.frozenMarginStr = frozenMarginStr;
	}

	public String getFrozenFeeStr() {
		return this.frozenFeeStr;
	}

	public void setFrozenFeeStr(String frozenFeeStr) {
		this.frozenFeeStr = frozenFeeStr;
	}

	public String getCloseProfitStr() {
		return this.closeProfitStr;
	}

	public void setCloseProfitStr(String closeProfitStr) {
		this.closeProfitStr = closeProfitStr;
	}

	public String getPositionProfitStr() {
		return this.positionProfitStr;
	}

	public void setPositionProfitStr(String positionProfitStr) {
		this.positionProfitStr = positionProfitStr;
	}

	public String getRiskStr() {
		return this.riskStr;
	}

	public void setRiskStr(String riskStr) {
		this.riskStr = riskStr;
	}

	public String getDynamicRightsStr() {
		return this.dynamicRightsStr;
	}

	public void setDynamicRightsStr(String dynamicRightsStr) {
		this.dynamicRightsStr = dynamicRightsStr;
	}

	public IWinHisInvestorAccount(String traderID, String accountName, String instClientName, String preBalance,
			String deposit, String margin, String fee, String frozenMargin, String frozenFee, String closeProfit,
			String positionProfit, String available, String dynamicRights, String risk, String settleDate) {
		this.traderID = traderID;
		this.accountName = accountName;
		this.instClientName = instClientName;
		this.preBalanceStr = preBalance;
		this.depositStr = deposit;
		this.availableStr = available;
		this.marginStr = margin;
		this.feeStr = fee;
		this.frozenMarginStr = frozenMargin;
		this.frozenFeeStr = frozenFee;
		this.closeProfitStr = closeProfit;
		this.positionProfitStr = positionProfit;
		this.dynamicRightsStr = dynamicRights;
		this.riskStr = risk;
		this.settleDate = settleDate;
	}
}