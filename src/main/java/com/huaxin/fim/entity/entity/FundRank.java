package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/*
 * 综合排名表对应的实体类
 */
@Entity
@Table(name = "t_fund_rank", uniqueConstraints = {@UniqueConstraint(columnNames = { "date", "product_id","report_id"})})
public class FundRank implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "seq_t_fund_rank") // 适配oracle等没有主键自增长的数据库，改用sequence
	@Column(name = "id", nullable = false)
	private Long id;
	
	// 交易日期（格式:YYYYMMDD）
	@Column(name = "date", length = 8)
	@Length(min = 1, max = 8)
	@NotNull
	@NotBlank
	private String date;
	
	// 基金产品编号
	@Column(name = "product_id", length = 32)
	@Length(min = 1, max = 32)
	@NotNull
	@NotBlank
	private String productID;
	
	// 报表编号编号
	@Column(name = "report_id", length = 6)
	@Length(min = 1, max = 6)
	@NotNull
	@NotBlank
	private String reportID;
	
	// 排名
	@Column(name = "ranking")
	private int ranking;


	// 分数
	@Column(name = "score", precision = 5, scale = 2)
	@Digits(integer = 3, fraction = 2)
	private BigDecimal score;
	
	// 分组
	@Column(name = "group_id", length = 2)
	private String group;
	
	// 累计交易天数
	@Column(name = "accumulative_trade_days")
	private int accumulativeTradeDays;
	
	// 当日权益
	@Column(name = "invester_equity_today", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal investerEquityToday;
	
	// 当日总盈亏
	@Column(name = "tot_profit_today", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal totProfitToday;
	
	// 当日出入金
	@Column(name = "deposit_withdrawal_today", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal depositWithdrawalToday;
	
	public int getAccumulativeTradeDays() {
		return accumulativeTradeDays;
	}

	public void setAccumulativeTradeDays(int accumulativeTradeDays) {
		this.accumulativeTradeDays = accumulativeTradeDays;
	}

	public BigDecimal getInvesterEquityToday() {
		return investerEquityToday;
	}

	public void setInvesterEquityToday(BigDecimal investerEquityToday) {
		this.investerEquityToday = investerEquityToday;
	}

	public BigDecimal getTotProfitToday() {
		return totProfitToday;
	}

	public void setTotProfitToday(BigDecimal totProfitToday) {
		this.totProfitToday = totProfitToday;
	}

	public BigDecimal getDepositWithdrawalToday() {
		return depositWithdrawalToday;
	}

	public void setDepositWithdrawalToday(BigDecimal depositWithdrawalToday) {
		this.depositWithdrawalToday = depositWithdrawalToday;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

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

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getReportID() {
		return reportID;
	}

	public void setReportID(String reportID) {
		this.reportID = reportID;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	
	@Transient
	private String groupId;

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
}
