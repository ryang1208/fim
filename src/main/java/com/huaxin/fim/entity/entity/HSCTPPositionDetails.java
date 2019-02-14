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
 * ctp持仓明细原始表
 */
@Entity
@Table(name = "t_raw_hs_position_details")
public class HSCTPPositionDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// 序号（自动编号）
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	//成交日期
	@Column(name = "date", nullable = false, length = 10)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 10)
	private String date;
	
	//成交编号
	@Column(name = "transcation_no",  length = 20)
	@Length(min = 0, max = 20)
	private String transcationNO;
	
	//客户内部资金账户
	@Column(name = "invester_id", nullable = false, length = 18)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 18)
	private String investerID;
	
	//交易所
	@Column(name = "exchange",  length = 10)
	@Length(min = 0, max = 10)
	private String exchange;	
	
	//合约
	@Column(name = "contact", length = 30)
	@Length(min = 1, max = 30)
	@NotNull
	@NotBlank
	private String contact;
	
	// 买手
	@Column(name = "position_buy")
	private int positionBuy;
	// 买价
	@Column(name = "price_buy", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal priceBuy;
	// 卖手
	@Column(name = "position_sell")
	private int positionSell;
	// 卖价
	@Column(name = "price_sell", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal priceSell;
	
	//投机套保标志
	@Column(name = "sh")
	private Integer sh;
	
	//昨结算
	@Column(name = "settlementPrice_yesterday", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal settlementPriceYesterday;
	
	//结算价
	@Column(name = "settlement_price_today", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal settlementPriceToday;
	
	//浮动盈亏
	@Column(name = "position_profit", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal positionProfit;
	
	//盯市盈亏
	@Column(name = "close_profit_mark", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal closeProfitMark;
	
	//保证金
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTranscationNO() {
		return transcationNO;
	}

	public void setTranscationNO(String transcationNO) {
		this.transcationNO = transcationNO;
	}

	public String getInvesterID() {
		return investerID;
	}

	public void setInvesterID(String investerID) {
		this.investerID = investerID;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
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

	public Integer getSh() {
		return sh;
	}

	public void setSh(Integer sh) {
		this.sh = sh;
	}

	public BigDecimal getSettlementPriceYesterday() {
		return settlementPriceYesterday;
	}

	public void setSettlementPriceYesterday(BigDecimal settlementPriceYesterday) {
		this.settlementPriceYesterday = settlementPriceYesterday;
	}

	public BigDecimal getSettlementPriceToday() {
		return settlementPriceToday;
	}

	public void setSettlementPriceToday(BigDecimal settlementPriceToday) {
		this.settlementPriceToday = settlementPriceToday;
	}

	public BigDecimal getPositionProfit() {
		return positionProfit;
	}

	public void setPositionProfit(BigDecimal positionProfit) {
		this.positionProfit = positionProfit;
	}

	public BigDecimal getCloseProfitMark() {
		return closeProfitMark;
	}

	public void setCloseProfitMark(BigDecimal closeProfitMark) {
		this.closeProfitMark = closeProfitMark;
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

	public BigDecimal getMargin() {
		return margin;
	}

	public void setMargin(BigDecimal margin) {
		this.margin = margin;
	}

	

}
