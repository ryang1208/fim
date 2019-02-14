package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/*
 * 品种汇总表对应的实体类
 */
@Entity
@Table(name = "t_variety_summary", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "date", "invester_id", "broker_id", "variety_id" }) })
public class VarietySummary implements Serializable {

	private static final long serialVersionUID = 1L;
	// 交易日期（格式:YYYYMMDD）
	@Id
	@Column(name = "date", length = 8)
	@Length(min = 1, max = 8)
	@NotNull
	@NotBlank
	private String date;
	// 经济公司投资者ID
	@Id
	@Column(name = "invester_id", length = 32)
	@Length(min = 1, max = 32)
	@NotNull
	@NotBlank
	private String investerID;
	// 投赢汇经纪公司代号
	@Id
	@Column(name = "broker_id")
	private int brokerID;
	// 品种
	@Id
	@Column(name = "variety_id", length = 32)
	@Length(min = 1, max = 32)
	@NotNull
	@NotBlank
	private String varietyID;
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
	// 更新日期（格式:YYYYMMDD）
	@Column(name = "update_date", length = 8)
	@Length(min = 1, max = 8)
	private String updateDate;
	// 平仓盈亏(逐笔)
	@Column(name = "close_profit_hedge", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal closeProfitHedge;

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

	public String getVarietyID() {
		return varietyID;
	}

	public void setVarietyID(String varietyID) {
		this.varietyID = varietyID;
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

	public int getBrokerID() {
		return brokerID;
	}

	public void setBrokerID(int brokerID) {
		this.brokerID = brokerID;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public BigDecimal getCloseProfitHedge() {
		return closeProfitHedge;
	}

	public void setCloseProfitHedge(BigDecimal closeProfitHedge) {
		this.closeProfitHedge = closeProfitHedge;
	}

	

}
