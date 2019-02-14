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
 * 成交汇总表对应的实体类
 */
@Entity
@Table(name = "t_transaction_summary", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "date", "invester_id", "broker_id", "contact", "bs", "oc", "sh", "price" }) })
public class TransactionSummary implements Serializable {

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
	// 合约
	@Id
	@Column(name = "contact", length = 32)
	@Length(min = 1, max = 32)
	@NotNull
	@NotBlank
	private String contact;
	// 买卖方向(数据字典 1001)
	@Id
	@Column(name = "bs")
	private int bs;
	// 开平标志(数据字典 1002)
	@Id
	@Column(name = "oc")
	private int oc;
	// 投保标志(数据字典 1003)
	@Id
	@Column(name = "sh")
	private int sh;
	// 成交价
	@Id
	@Column(name = "price", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal price;
	// 成交手数
	@Column(name = "lots")
	private int lots;
	// 成交额
	@Column(name = "turnover", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal turnover;
	// 手续费
	@Column(name = "commission", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal commission;
	// 平仓盈亏
	@Column(name = "close_profit", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal closeProfit;
	// 数据来源
	@Column(name = "data_source")
	private int dataSource;
	// 品种
	@Column(name = "variety_id")
	private String varietyID;
	// 行业
	@Column(name = "industry")
	private String industry;
	// 市场类型（允许市场）
	@Column(name = "market_type", length = 2)
	private String marketType;

	public String getTotalExpense() {
		return totalExpense;
	}

	public void setTotalExpense(String totalExpense) {
		this.totalExpense = totalExpense;
	}

	/**
	 * 总费用
	 */
	@Column(name = "total_expense",length = 50)
	private String totalExpense;

	@Transient
	private String startDate;
	@Transient
	private String endDate;

	// 更新日期（格式:YYYYMMDD）
	@Column(name = "update_date", length = 8)
	@Length(min = 1, max = 8)
	private String updateDate;
	
	// 平仓盈亏(逐笔)
	@Column(name = "close_profit_hedge", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal closeProfitHedge;

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public int getBs() {
		return bs;
	}

	public void setBs(int bs) {
		this.bs = bs;
	}

	public int getOc() {
		return oc;
	}

	public void setOc(int oc) {
		this.oc = oc;
	}

	public int getSh() {
		return sh;
	}

	public void setSh(int sh) {
		this.sh = sh;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getLots() {
		return lots;
	}

	public void setLots(int lots) {
		this.lots = lots;
	}

	public BigDecimal getTurnover() {
		return turnover;
	}

	public void setTurnover(BigDecimal turnover) {
		this.turnover = turnover;
	}

	public BigDecimal getCommission() {
		return commission;
	}

	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}

	public BigDecimal getCloseProfit() {
		return closeProfit;
	}

	public void setCloseProfit(BigDecimal closeProfit) {
		this.closeProfit = closeProfit;
	}

	public int getDataSource() {
		return dataSource;
	}

	public void setDataSource(int dataSource) {
		this.dataSource = dataSource;
	}

	public int getBrokerID() {
		return brokerID;
	}

	public void setBrokerID(int brokerID) {
		this.brokerID = brokerID;
	}

	public String getVarietyID() {
		return varietyID;
	}

	public void setVarietyID(String varietyID) {
		this.varietyID = varietyID;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getMarketType() {
		return marketType;
	}

	public void setMarketType(String marketType) {
		this.marketType = marketType;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public BigDecimal getCloseProfitHedge() {
		return closeProfitHedge;
	}

	public void setCloseProfitHedge(BigDecimal closeProfitHedge) {
		this.closeProfitHedge = closeProfitHedge;
	}


}
