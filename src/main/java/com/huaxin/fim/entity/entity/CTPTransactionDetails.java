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
 * CTP成交明细原始表
 */
@Entity
@Table(name = "t_raw_ctp_transaction_details")
public class CTPTransactionDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	// 序号（自动编号）
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	//成交日期 
	@Column(name = "date", length = 10)
	@Length(min = 1, max = 10)
	@NotNull
	@NotBlank
	private String date;
	
	//客户内部资金账户
	@Column(name = "invester_id", length = 18)
	@Length(min = 1, max = 18)
	@NotNull
	@NotBlank
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
	
	//买卖标志
	@Column(name = "bs")
	private Integer bs;
	
	//投机套保标志
	@Column(name = "sh")
	private Integer sh;
	
	//成交价
	@Column(name = "price", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal price;
	
	//手数
	@Column(name = "lots")
	private Integer lots;
	
	//成交额
	@Column(name = "turnover", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal turnover;
	
	//开平
	@Column(name = "oc")
	private Integer oc;
	
	//手续费
	@Column(name = "commission", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal commission;
	
	//平仓盈亏
	@Column(name = "close_prifit", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal closePrifit;
	
	//权利金收支
	@Column(name = "premium_received_paid", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal premiumReceivedPaid;
	
	//成交序号
	@Column(name = "transcationNO", length = 30)
	@Length(min = 0, max = 30)
	private String transcationNO;

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

	public Integer getBs() {
		return bs;
	}

	public void setBs(Integer bs) {
		this.bs = bs;
	}

	public Integer getSh() {
		return sh;
	}

	public void setSh(Integer sh) {
		this.sh = sh;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getLots() {
		return lots;
	}

	public void setLots(Integer lots) {
		this.lots = lots;
	}

	public BigDecimal getTurnover() {
		return turnover;
	}

	public void setTurnover(BigDecimal turnover) {
		this.turnover = turnover;
	}

	public Integer getOc() {
		return oc;
	}

	public void setOc(Integer oc) {
		this.oc = oc;
	}

	public BigDecimal getCommission() {
		return commission;
	}

	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}

	public BigDecimal getClosePrifit() {
		return closePrifit;
	}

	public void setClosePrifit(BigDecimal closePrifit) {
		this.closePrifit = closePrifit;
	}

	public BigDecimal getPremiumReceivedPaid() {
		return premiumReceivedPaid;
	}

	public void setPremiumReceivedPaid(BigDecimal premiumReceivedPaid) {
		this.premiumReceivedPaid = premiumReceivedPaid;
	}

	public String getTranscationNO() {
		return transcationNO;
	}

	public void setTranscationNO(String transcationNO) {
		this.transcationNO = transcationNO;
	}

	public int getDataSource() {
		return dataSource;
	}

	public void setDataSource(int dataSource) {
		this.dataSource = dataSource;
	}
	
}
