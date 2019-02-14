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
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/*
 * 持仓明细表对应的实体类
 */
@Entity
@Table(name = "t_position_details")
public class PositionDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// 序号（自动编号）
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@SequenceGenerator(name = "sequence", sequenceName = "seq_t_product") // 适配oracle等没有主键自增长的数据库，改用sequence
	@Column(name = "id")
	private Long id;
	
	// 交易日期（格式:YYYYMMDD）
	@Column(name = "date", length = 8)
	@Length(min = 1, max = 8)
	@NotNull
	@NotBlank
	private String date;
	// 实际成交日期（格式:YYYYMMDD）
	@Column(name = "transaction_date", length = 8)
	@Length(min = 0, max = 8)
	private String transactionDate;	
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
	// 市场类型（允许市场）
	@Column(name = "market_type", length = 2)
	private String marketType;
	// 成交序号
	@Column(name = "transcation_no", length = 32)
	@Length(min = 0, max = 32)
	private String transcationNO;
	// 买持仓
	@Column(name = "position_buy")
	private int positionBuy;
	// 买入价
	@Column(name = "price_buy", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal priceBuy;
	// 卖持仓
	@Column(name = "position_sell")
	private int positionSell;
	// 卖出价
	@Column(name = "price_sell", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal priceSell;
	// 今结算价
	@Column(name = "settlement_price_today", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal settlementPriceToday;
	// 昨结算价
	@Column(name = "settlement_price_yesterday", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal settlementPriceYesterday;
	// 浮动盈亏
	@Column(name = "position_profit", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal positionProfit;
	// 投保标志(数据字典 1003)
	@Column(name = "sh")
	private Integer sh;
	// 交易保证金
	@Column(name = "margin", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal margin;
	// 交易编码
	@Column(name = "trading_code", length = 32)
	@Length(min = 1, max = 32)
	private String tradingCode;
	// 数据来源
	@Column(name = "data_source")
	private int dataSource;
	@Transient
	private String startDate;
	@Transient
	private String endDate;
	// 更新日期（格式:YYYYMMDD）
	@Column(name = "update_date", length = 8)
	@Length(min = 1, max = 8)
	private String updateDate;
	
	// 持仓盈亏
	@Column(name = "position_profit_market", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal positionProfitMarket;


	
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

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
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

	public String getTranscationNO() {
		return transcationNO;
	}

	public void setTranscationNO(String transcationNO) {
		this.transcationNO = transcationNO;
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

	public BigDecimal getPositionProfit() {
		return positionProfit;
	}

	public void setPositionProfit(BigDecimal positionProfit) {
		this.positionProfit = positionProfit;
	}

	public int getSh() {
		return sh;
	}

	public void setSh(Integer sh) {
		this.sh = sh;
	}

	public BigDecimal getMargin() {
		return margin;
	}

	public void setMargin(BigDecimal margin) {
		this.margin = margin;
	}

	public String getTradingCode() {
		return tradingCode;
	}

	public void setTradingCode(String tradingCode) {
		this.tradingCode = tradingCode;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public BigDecimal getPositionProfitMarket() {
		return positionProfitMarket;
	}

	public void setPositionProfitMarket(BigDecimal positionProfitMarket) {
		this.positionProfitMarket = positionProfitMarket;
	}

	
}
