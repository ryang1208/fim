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
 * 期货持仓实体类，对应的表t_raw_cfmmc_holddata
 */
@Entity
@Table(name = "t_raw_cfmmc_holddata")
public class CFMMCHoldData implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	//交易编码
	@Column(name = "transcation_no", nullable = false, length = 10)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 10)
	private String transcationNO;
	
	//客户内部资金账户
	@Column(name = "invester_id", nullable = false, length = 18)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 18)
	private String investerID;

	//日期，格式：YYYY-MM-DD
	@Column(name = "date", nullable = false, length = 10)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 10)
	private String date;
	
	//品种合约
	@Column(name = "contact", nullable = false, length = 30)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 30)
	private String contact;
	
	//买卖标志
	@Column(name = "bs", nullable = false, length = 10)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 10)
	private String bs;
	
	//创建日期
	@Column(name = "create_time",  length = 30)
	@Length(min = 0, max = 30)
	private String createTime;
	
	//币种
	@Column(name = "currency", nullable = false, length = 5)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 5)
	private String currency;
	
	//投机套保标志
	@Column(name = "sh", nullable = false, length = 10)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 10)
	private String sh;
	
	
	//交易保证金
	@Column(name = "margin", precision = 15, scale = 3)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal margin;
	
	//持仓量
	@Column(name = "position")
	private int position;	
	
	//持仓盈亏(逐笔对冲)
	@Column(name = "position_hedge", precision = 15, scale = 3)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal positionHedge;
	
	//持仓盈亏(逐日盯市)	
	@Column(name = "position_mark", precision = 15, scale = 3)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal positionMark;
	
	//持仓均价
	@Column(name = "position_average_price", precision = 15, scale = 3)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal positionAveragePrice;
	
	//昨结算价
	@Column(name = "settlementPrice_yesterday", precision = 15, scale = 3)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal settlementPriceYesterday;
	
	//今结算价	
	@Column(name = "settlementPrice_today", precision = 15, scale = 3)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal settlementPriceToday;	
	
	//交易所统一标识	
	@Column(name = "exchange_id",  length = 10)
	@Length(min = 0, max = 10)
	private String exchangeID;
	
	//是否为交易会员
	@Column(name = "is_exchange_member",  length = 10)
	@Length(min = 0, max = 10)
	private String isExchangeMember;
	

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getBs() {
		return bs;
	}

	public void setBs(String bs) {
		this.bs = bs;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getSh() {
		return sh;
	}

	public void setSh(String sh) {
		this.sh = sh;
	}

	public BigDecimal getMargin() {
		return margin;
	}

	public void setMargin(BigDecimal margin) {
		this.margin = margin;
	}

	public BigDecimal getPositionHedge() {
		return positionHedge;
	}

	public void setPositionHedge(BigDecimal positionHedge) {
		this.positionHedge = positionHedge;
	}

	public BigDecimal getPositionMark() {
		return positionMark;
	}

	public void setPositionMark(BigDecimal positionMark) {
		this.positionMark = positionMark;
	}

	public BigDecimal getPositionAveragePrice() {
		return positionAveragePrice;
	}

	public void setPositionAveragePrice(BigDecimal positionAveragePrice) {
		this.positionAveragePrice = positionAveragePrice;
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

	public String getExchangeID() {
		return exchangeID;
	}

	public void setExchangeID(String exchangeID) {
		this.exchangeID = exchangeID;
	}

	public String getIsExchangeMember() {
		return isExchangeMember;
	}

	public void setIsExchangeMember(String isExchangeMember) {
		this.isExchangeMember = isExchangeMember;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}
