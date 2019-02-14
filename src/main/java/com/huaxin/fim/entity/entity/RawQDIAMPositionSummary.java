package com.huaxin.fim.entity.entity;

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

/*
 * 持仓汇总表对应的元数据实体类
 */
@Entity
@Table(name = "t_raw_qdiam_position_summary", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "date", "invester_id","broker_id","contact","sh","bs"})})
public class RawQDIAMPositionSummary implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// 序号（自动编号）
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
		
	// 交易日期（格式:YYYYMMDD）
	@Column(name = "date", length = 8)
	@Length(min = 1, max = 8)
	@NotNull
	@NotBlank
	private String date;
	// 经济公司投资者ID
	@Column(name = "invester_id", length = 32)
	@Length(min = 1, max = 32)
	@NotNull
	@NotBlank
	private String investerID;
	// 投赢汇经纪公司代号
	@Column(name = "broker_id")
	private int brokerID;
	// 合约
	@Column(name = "contact", length = 32)
	@Length(min = 1, max = 32)
	@NotNull
	@NotBlank
	private String contact;
	//买持仓
	@Column(name = "position_buy")
	private int positionBuy;
	//买均价
	@Column(name = "price_buy", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal priceBuy;
	//卖持仓
	@Column(name = "position_sell")
	private int positionSell;
	//卖均价
	@Column(name = "price_sell", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal priceSell;
	//今结算价
	@Column(name = "settlementPrice_today", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal settlementPriceToday;
	//昨结算价
	@Column(name = "settlementPrice_yesterday", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal settlementPriceYesterday;
	//浮动盈亏
	@Column(name = "floating_profit", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal floatingProfit;
	//交易保证金
	@Column(name = "margin", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal margin;
	//投保标志(数据字典 1003)
	@Column(name = "sh")
	@NotNull
	private int sh;
	//数据来源
	@Column(name = "data_source")
	private int dataSource;
	//买卖标志(数据字典 1001)
	@Column(name = "bs")
	@NotNull
	private int bs;	
	//补填的交易保证金
	@Column(name = "ori_margin", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal oriMargin;
	
	// 市场类型（允许市场）
	@Column(name = "market_type", length = 2)
	private String marketType;
	
	// 持仓成本
	@Column(name = "position_cost", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal positionCost;
	
	// 收益（持仓+平仓）
	@Column(name = "total_profit", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal totalProfit;
	
	// 市值
	@Column(name = "market_capitalization", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal marketCapitalization;
	
	// 所属证券行业
	@Column(name = "industry", length = 50)
	private String industry;
	
	// 证券盘型
	@Column(name = "stock_type", length = 50)
	private String stockType;
	
	@Transient
	private String brokerIDStr;
	
	public String getMarketType() {
		return marketType;
	}
	public void setMarketType(String marketType) {
		this.marketType = marketType;
	}
	public BigDecimal getPositionCost() {
		return positionCost;
	}
	public void setPositionCost(BigDecimal positionCost) {
		this.positionCost = positionCost;
	}
	public BigDecimal getTotalProfit() {
		return totalProfit;
	}
	public void setTotalProfit(BigDecimal totalProfit) {
		this.totalProfit = totalProfit;
	}
	public BigDecimal getMarketCapitalization() {
		return marketCapitalization;
	}
	public void setMarketCapitalization(BigDecimal marketCapitalization) {
		this.marketCapitalization = marketCapitalization;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getStockType() {
		return stockType;
	}
	public void setStockType(String stockType) {
		this.stockType = stockType;
	}
	public BigDecimal getOriMargin() {
		return oriMargin;
	}
	public void setOriMargin(BigDecimal oriMargin) {
		this.oriMargin = oriMargin;
	}
	public int getBs() {
		return bs;
	}
	public void setBs(int bs) {
		this.bs = bs;
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
	public int getPositionBuy() {
		return positionBuy;
	}
	public void setPositionBuy(int positionBuy) {
		this.positionBuy = positionBuy;
	}
	public BigDecimal getPriceBuy() {
		return priceBuy;
	}
	public void setPriceBuy(BigDecimal priceBuy) {
		this.priceBuy = priceBuy;
	}
	public int getPositionSell() {
		return positionSell;
	}
	public void setPositionSell(int positionSell) {
		this.positionSell = positionSell;
	}
	public BigDecimal getPriceSell() {
		return priceSell;
	}
	public void setPriceSell(BigDecimal priceSell) {
		this.priceSell = priceSell;
	}
	public BigDecimal getSettlementPriceToday() {
		return settlementPriceToday;
	}
	public void setSettlementPriceToday(BigDecimal settlementPriceToday) {
		this.settlementPriceToday = settlementPriceToday;
	}
	public BigDecimal getSettlementPriceYesterday() {
		return settlementPriceYesterday;
	}
	public void setSettlementPriceYesterday(BigDecimal settlementPriceYesterday) {
		this.settlementPriceYesterday = settlementPriceYesterday;
	}
	public BigDecimal getFloatingProfit() {
		return floatingProfit;
	}
	public void setFloatingProfit(BigDecimal floatingProfit) {
		this.floatingProfit = floatingProfit;
	}
	public BigDecimal getMargin() {
		return margin;
	}
	public void setMargin(BigDecimal margin) {
		this.margin = margin;
	}
	public int getSh() {
		return sh;
	}
	public void setSh(int sh) {
		this.sh = sh;
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
	public String getBrokerIDStr() {
		return brokerIDStr;
	}
	public void setBrokerIDStr(String brokerIDStr) {
		this.brokerIDStr = brokerIDStr;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
