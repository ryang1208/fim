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
 * 成交明细表对应的元数据实体类
 */
@Entity
@Table(name = "t_raw_qdiam_transaction_details")
public class RawQDIAMTransactionDetails implements Serializable {
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
	// 实际交易日期（格式:YYYYMMDD） 
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
	// 成交序号
	@Column(name = "transcation_no", length = 32)
	@Length(min = 0, max = 32)
	private String transcationNO;
	// 成交时间,格式是“HHSSMM”
	
	@Column(name = "transcation_time", length = 32)
	@Length(min = 0, max = 32)
	private String transcationTime;	
	// 买卖方向(数据字典 1001)
	@Column(name = "bs")
	private int bs;
	// 开平标志(数据字典 1002)
	@Column(name = "oc")
	private int oc;
	// 投保标志(数据字典 1003)
	@Column(name = "sh")
	private int sh;
	// 成交价
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
	@Transient
	private String startDate;
	@Transient
	private String endDate;
	
	@Transient
	private String brokerIDStr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
	
	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
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
	
	public String getTranscationTime() {
		return transcationTime;
	}

	public void setTranscationTime(String transcationTime) {
		this.transcationTime = transcationTime;
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
	
}
