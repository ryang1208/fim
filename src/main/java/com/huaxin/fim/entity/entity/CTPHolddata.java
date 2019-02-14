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
import java.util.List;

/*
 * ctp持仓汇总原始表
 */
@Entity
@Table(name = "t_raw_ctp_holddata", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "sh","invester_id","date","contact","price_buy","price_sell"})})
public class CTPHolddata implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	// 交易日期（格式:YYYYMMDD）
	@Column(name = "date", length = 10)
	@Length(min = 1, max = 10)
	@NotNull
	@NotBlank
	private String date;
	// 经济公司投资者ID
	@Column(name = "invester_id", length = 18)
	@Length(min = 1, max = 18)
	@NotNull
	@NotBlank
	private String investerID;
	
	//品种
	@Column(name = "product",  length = 20)
	@Length(min = 0, max = 20)
	private String product;
	
	//合约
	@Column(name = "contact", length = 30)
	@Length(min = 1, max = 30)
	@NotNull
	@NotBlank
	private String contact;
	
	//买持
	@Column(name = "position_buy")
	private Integer positionBuy;
	
	//买均价
	@Column(name = "price_buy", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal priceBuy;
	
	//卖持
	@Column(name = "position_sell")
	private Integer positionSell;
	
	//卖均价
	@Column(name = "price_sell", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal priceSell;
	
	//昨结算价
	@Column(name = "settlementPrice_yesterday", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal settlementPriceYesterday;
	
	//今结算价
	@Column(name = "settlementPrice_today", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal settlementPriceToday;
	
	//浮动盈亏
	@Column(name = "floating_profit", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal floatingProfit;
	
	//盯市盈亏
	@Column(name = "close_profit_mark", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal closeProfitMark;
	
	//保证金占用
	@Column(name = "margin", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal margin;
	
	//投机套保标志
	@Column(name = "sh")
	private Integer sh;
	
	//多头期权市值
	@Column(name = "long_marketValue", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal longMarketValue;
	
	//空头期权市值
	@Column(name = "short_marketValue", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal shortMarketValue;

	// 数据来源
	@Column(name = "data_source")
	private int dataSource;
	
	//品种
	@Transient
	private List<String> Varieties;	

	public List<String> getVarieties() {
		return Varieties;
	}

	public void setVarieties(List<String> varieties) {
		Varieties = varieties;
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

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Integer getPositionBuy() {
		return positionBuy;
	}

	public void setPositionBuy(Integer positionBuy) {
		this.positionBuy = positionBuy;
	}

	public BigDecimal getPriceBuy() {
		return priceBuy;
	}

	public void setPriceBuy(BigDecimal priceBuy) {
		this.priceBuy = priceBuy;
	}

	public Integer getPositionSell() {
		return positionSell;
	}

	public void setPositionSell(Integer positionSell) {
		this.positionSell = positionSell;
	}

	public BigDecimal getPriceSell() {
		return priceSell;
	}

	public void setPriceSell(BigDecimal priceSell) {
		this.priceSell = priceSell;
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

	public BigDecimal getFloatingProfit() {
		return floatingProfit;
	}

	public void setFloatingProfit(BigDecimal floatingProfit) {
		this.floatingProfit = floatingProfit;
	}

	public BigDecimal getCloseProfitMark() {
		return closeProfitMark;
	}

	public void setCloseProfitMark(BigDecimal closeProfitMark) {
		this.closeProfitMark = closeProfitMark;
	}

	public BigDecimal getMargin() {
		return margin;
	}

	public void setMargin(BigDecimal margin) {
		this.margin = margin;
	}

	public Integer getSh() {
		return sh;
	}

	public void setSh(Integer sh) {
		this.sh = sh;
	}

	public BigDecimal getLongMarketValue() {
		return longMarketValue;
	}

	public void setLongMarketValue(BigDecimal longMarketValue) {
		this.longMarketValue = longMarketValue;
	}

	public BigDecimal getShortMarketValue() {
		return shortMarketValue;
	}

	public void setShortMarketValue(BigDecimal shortMarketValue) {
		this.shortMarketValue = shortMarketValue;
	}

	public int getDataSource() {
		return dataSource;
	}

	public void setDataSource(int dataSource) {
		this.dataSource = dataSource;
	}
	
}
