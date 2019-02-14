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
 * 成交明细
 */
@Entity
@Table(name = "t_raw_cfmmc_trddata")
public class CFMMCtrddata implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	//日期,格式：YYYY-MM-DD
	@Column(name = "date",  length = 10)
	@Length(min = 0, max = 10)
	private String date;
	
	//客户内部资金账户
	//@Id
	@Column(name = "invester_id", nullable = false, length = 18)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 18)
	private String investerID;
	
	//交易流水号 
	//@Id
	@Column(name = "transaction_serialNO",  length = 16)
	@Length(min = 0, max = 16)
	private String transactionSerialNO;
	
	
	// 合约
	@Column(name = "contact", length = 30)
	@Length(min = 0, max = 30)
	private String contact;
	
	// 买卖方向(数据字典 1001)
	@Column(name = "bs")
	private int bs;
	
	// 成交量
	@Column(name = "transaction_quantity")
	private int transaction_quantity;
	
	// 成交价
	@Column(name = "price", precision = 15, scale = 3)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal price;	
	
	// 成交额
	@Column(name = "turnover", precision = 15, scale = 3)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal turnover;
	
	// 成交时间
	@Column(name = "transcation_time", length = 32)
	@Length(min = 0, max = 32)
	private String transcationTime;	
	
	//开平标示
	@Column(name = "oc")
	private int oc;
	
	//投保标示
	@Column(name = "sh")
	private int sh;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	// 平仓盈亏(逐日盯市)
	@Column(name = "close_profit_mark", precision = 15, scale = 3)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal closeProfitMark;	
	
	
	// 平仓盈亏(逐笔对冲)
	@Column(name = "close_profit_hedge", precision = 15, scale = 3)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal closeProfitHedge;
	
	// 手续费
	@Column(name = "commission", precision = 15, scale = 3)
	@Digits(integer = 12, fraction = 3)
	private BigDecimal commission;
	
	//交易编码 
	@Column(name = "transaction_NO",  length = 10)
	@Length(min = 0, max = 10)
	private String transactionNO;
	
	//交易所统一标识	
	@Column(name = "exchange_id",  length = 10)
	@Length(min = 0, max = 10)
	private String exchangeID;
	
	//是否为交易会员
	@Column(name = "is_exchange_member",  length = 10)
	@Length(min = 0, max = 10)
	private String isExchangeMember;
	
	
	//报单号
	//@Id
	@Column(name = "report_no", length = 12)
	@Length(min = 0, max = 12)
	private String reportNO;
	
	
	//席位号
	@Column(name = "seat_no",  length = 12)
	@Length(min = 0, max = 12)
	private String seatNO;
	
	
	//币种
	@Column(name = "currency",  length = 5)
	@Length(min = 0, max = 5)
	private String currency;
	
	
	//成交日期
	//@Id
	@Column(name = "trade_date",  length = 10)
	@Length(min = 0, max = 10)
	private String tradeDate;
	
	
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


	public String getTransactionSerialNO() {
		return transactionSerialNO;
	}


	public void setTransactionSerialNO(String transactionSerialNO) {
		this.transactionSerialNO = transactionSerialNO;
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


	public int getTransaction_quantity() {
		return transaction_quantity;
	}


	public void setTransaction_quantity(int transaction_quantity) {
		this.transaction_quantity = transaction_quantity;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public BigDecimal getTurnover() {
		return turnover;
	}


	public void setTurnover(BigDecimal turnover) {
		this.turnover = turnover;
	}


	public String getTranscationTime() {
		return transcationTime;
	}


	public void setTranscationTime(String transcationTime) {
		this.transcationTime = transcationTime;
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


	public BigDecimal getCloseProfitMark() {
		return closeProfitMark;
	}


	public void setCloseProfitMark(BigDecimal closeProfitMark) {
		this.closeProfitMark = closeProfitMark;
	}


	public BigDecimal getCloseProfitHedge() {
		return closeProfitHedge;
	}


	public void setCloseProfitHedge(BigDecimal closeProfitHedge) {
		this.closeProfitHedge = closeProfitHedge;
	}


	public BigDecimal getCommission() {
		return commission;
	}


	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}


	public String getTransactionNO() {
		return transactionNO;
	}


	public void setTransactionNO(String transactionNO) {
		this.transactionNO = transactionNO;
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


	public String getReportNO() {
		return reportNO;
	}


	public void setReportNO(String reportNO) {
		this.reportNO = reportNO;
	}


	public String getSeatNO() {
		return seatNO;
	}


	public void setSeatNO(String seatNO) {
		this.seatNO = seatNO;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public String getTradeDate() {
		return tradeDate;
	}


	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}
	
	
}
