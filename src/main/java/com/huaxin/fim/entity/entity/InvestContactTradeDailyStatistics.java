package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;


/*
 * 投资帐户每日合约交易周期统计表对应的实体类
 */
@Embeddable
@Entity
@Table(name = "t_invest_contact_trade_daily_statistics" , uniqueConstraints = {@UniqueConstraint(columnNames = {"date","broker_invester_id","contact"})})

public class InvestContactTradeDailyStatistics implements Serializable {

	// 交易日期
	@Id
	@Column(name = "date", nullable = false, length = 8)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 8)
	private String date;

	// 投资者资金账号ID
	@Id
	@Column(name = "broker_invester_id", nullable = false, length = 32)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 32)
	private String brokerInvesterID;
	
	// 合约
	@Id
	@Column(name = "contact", nullable = false, length = 6)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 6)
	private String contact;
	
	// 数据来源
	@Column(name = "data_source", nullable = false, length = 100)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 100)
	private String dataSource;
	
	// 统计日期
	@Column(name = "stat_date", nullable = false, length = 8)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 8)
	private String statDate;
	
	// 当日日内平仓交易额
	@Column(name = "position_close_day_trade_turnover", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal positionCloseDayTradeTurnover;

	// 当日日内平仓交易额占比
	@Column(name = "position_close_day_trade_propotion", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal positionCloseDayTradePropotion;
	
	// 当日净持仓手数
	@Column(name = "net_position")
	private int netPosition;
	
	// 当日持仓持续天数
	@Column(name = "position_day")
	private int positionDay;
	
	// 买向最大天数净持仓手数
	@Column(name = "max_net_position_buy")
	private int maxNetPositionBuy;	
	
	// 买向最大持仓天数
	@Column(name = "max_position_day_buy")
	private int maxPositionDayBuy;
	
	// 卖向最大天数净持仓手数
	@Column(name = "max_net_position_sell")
	private int maxNetPositionSell;
	
	// 卖向最大持仓天数
	@Column(name = "max_position_day_sell")
	private int maxPositionDaySell;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	public String getBrokerInvesterID() {
		return brokerInvesterID;
	}

	public void setBrokerInvesterID(String brokerInvesterID) {
		this.brokerInvesterID = brokerInvesterID;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getStatDate() {
		return statDate;
	}

	public void setStatDate(String statDate) {
		this.statDate = statDate;
	}

	public BigDecimal getPositionCloseDayTradeTurnover() {
		return positionCloseDayTradeTurnover;
	}

	public void setPositionCloseDayTradeTurnover(BigDecimal positionCloseDayTradeTurnover) {
		this.positionCloseDayTradeTurnover = positionCloseDayTradeTurnover;
	}

	public BigDecimal getPositionCloseDayTradePropotion() {
		return positionCloseDayTradePropotion;
	}

	public void setPositionCloseDayTradePropotion(BigDecimal positionCloseDayTradePropotion) {
		this.positionCloseDayTradePropotion = positionCloseDayTradePropotion;
	}

	public int getNetPosition() {
		return netPosition;
	}

	public void setNetPosition(int netPosition) {
		this.netPosition = netPosition;
	}

	public int getPositionDay() {
		return positionDay;
	}

	public void setPositionDay(int positionDay) {
		this.positionDay = positionDay;
	}

	public int getMaxNetPositionBuy() {
		return maxNetPositionBuy;
	}

	public void setMaxNetPositionBuy(int maxNetPositionBuy) {
		this.maxNetPositionBuy = maxNetPositionBuy;
	}

	public int getMaxPositionDayBuy() {
		return maxPositionDayBuy;
	}

	public void setMaxPositionDayBuy(int maxPositionDayBuy) {
		this.maxPositionDayBuy = maxPositionDayBuy;
	}

	public int getMaxNetPositionSell() {
		return maxNetPositionSell;
	}

	public void setMaxNetPositionSell(int maxNetPositionSell) {
		this.maxNetPositionSell = maxNetPositionSell;
	}

	public int getMaxPositionDaySell() {
		return maxPositionDaySell;
	}

	public void setMaxPositionDaySell(int maxPositionDaySell) {
		this.maxPositionDaySell = maxPositionDaySell;
	}

	
}
