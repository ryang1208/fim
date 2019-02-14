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
 * ctp平仓明细原始表 
 * 
 */
@Entity
@Table(name = "t_raw_ctp_position_close_details")
public class CTPPositionCloseDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// 序号（自动编号）
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	//客户内部资金账户
	@Column(name = "invester_id", length = 18)
	@Length(min = 1, max = 18)
	@NotNull
	@NotBlank
	private String investerID;
	
	//平仓日期
	@Column(name = "date", length = 10)
	@Length(min = 1, max = 10)
	@NotNull
	@NotBlank
	private String date;
	
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
	
	//买卖标志
	@Column(name = "bs")
	private Integer bs;
	
	//手数
	@Column(name = "lots")
	private Integer lots;
	
	//开仓价
	@Column(name = "price_open", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal priceOpen;
	
	//昨结算价
	@Column(name = "settlementPrice_yesterday", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal settlementPriceYesterday;
	
	//成交价
	@Column(name = "price", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal price;
	
	//平仓盈亏
	@Column(name = "close_profit", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal closeProfit;
	
	//权利金收支
	@Column(name = "premium_received_paid", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal premiumReceivedPaid;

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

	public String getInvesterID() {
		return investerID;
	}

	public void setInvesterID(String investerID) {
		this.investerID = investerID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public Integer getBs() {
		return bs;
	}

	public void setBs(Integer bs) {
		this.bs = bs;
	}

	public Integer getLots() {
		return lots;
	}

	public void setLots(Integer lots) {
		this.lots = lots;
	}

	public BigDecimal getPriceOpen() {
		return priceOpen;
	}

	public void setPriceOpen(BigDecimal priceOpen) {
		this.priceOpen = priceOpen;
	}

	public BigDecimal getSettlementPriceYesterday() {
		return settlementPriceYesterday;
	}

	public void setSettlementPriceYesterday(BigDecimal settlementPriceYesterday) {
		this.settlementPriceYesterday = settlementPriceYesterday;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getCloseProfit() {
		return closeProfit;
	}

	public void setCloseProfit(BigDecimal closeProfit) {
		this.closeProfit = closeProfit;
	}

	public BigDecimal getPremiumReceivedPaid() {
		return premiumReceivedPaid;
	}

	public void setPremiumReceivedPaid(BigDecimal premiumReceivedPaid) {
		this.premiumReceivedPaid = premiumReceivedPaid;
	}

	public int getDataSource() {
		return dataSource;
	}

	public void setDataSource(int dataSource) {
		this.dataSource = dataSource;
	}
	
}
