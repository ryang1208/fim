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
import java.util.List;

/*
 * ctp持仓明细原始表
 */
@Entity
@Table(name = "t_raw_ctp_position_details")
public class CTPPositionDetails implements Serializable {
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
	
	//开仓日期
	@Column(name = "open_date",  length = 10)
	@Length(min = 0, max = 10)
	private String openDate;
	
	//投机套保标志
	@Column(name = "sh")
	private Integer sh;
	
	//买卖标志
	@Column(name = "bs")
	private Integer bs;
	
	//持仓量
	@Column(name = "position")
	private int position;
	
	//开仓价
	@Column(name = "open_price", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal openPrice;
	
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
	
	//期权市值
	@Column(name = "options_market_value", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal optionsMarketValue;
	
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

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
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

	public String getOpenDate() {
		return openDate;
	}

	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	public Integer getSh() {
		return sh;
	}

	public void setSh(Integer sh) {
		this.sh = sh;
	}

	public Integer getBs() {
		return bs;
	}

	public void setBs(Integer bs) {
		this.bs = bs;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public BigDecimal getOpenPrice() {
		return openPrice;
	}

	public void setOpenPrice(BigDecimal openPrice) {
		this.openPrice = openPrice;
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

	public BigDecimal getMargin() {
		return margin;
	}

	public void setMargin(BigDecimal margin) {
		this.margin = margin;
	}

	public BigDecimal getOptionsMarketValue() {
		return optionsMarketValue;
	}

	public void setOptionsMarketValue(BigDecimal optionsMarketValue) {
		this.optionsMarketValue = optionsMarketValue;
	}

	public int getDataSource() {
		return dataSource;
	}

	public void setDataSource(int dataSource) {
		this.dataSource = dataSource;
	}

}
