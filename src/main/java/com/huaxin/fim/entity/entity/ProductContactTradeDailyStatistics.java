package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
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
@Table(name = "t_product_contact_trade_daily_statistics" , uniqueConstraints = {@UniqueConstraint(columnNames = {"date","product_id","contact"})})

public class ProductContactTradeDailyStatistics implements Serializable {

	private static final long serialVersionUID = 1L;

	// 交易日期
	@Id
	@Column(name = "date", nullable = false, length = 8)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 8)
	private String date;

	// 基金产品编号
	@Id
	@Column(name = "product_id", nullable = false, length = 32)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 32)
	private String productID;
	
	// 合约
	@Id
	@Column(name = "contact", nullable = false, length = 32)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 32)
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
	
	// 当日日内平仓手数占比
	@Column(name = "days_close_lots_propotion", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal daysCloseLotsPropotion;

	// 当日日内开仓成交额
	@Column(name = "days_open_turnover", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal daysOpenTurnover;
	
	// 当日日内总成交额
	@Column(name = "days_turnover", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal daysTurnover;

	// 当日日内平仓成交额
	@Column(name = "days_close_turnover", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal daysCloseTurnover;
	
	// 当日日内平仓成交额占比
	@Column(name = "days_close_turnover_propotion", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal daysCloseTurnoverPropotion;
	
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
	
	// 买向持仓金额
	@Column(name = "position_value_buy", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal positionValueBuy;
	
	// 卖向持仓金额
	@Column(name = "position_value_sell", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal positionValueSell;
	
	// 买向持仓比例
	@Column(name = "position_ratio_buy", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal positionRatioBuy;
	
	// 卖向持仓比例
	@Column(name = "position_ratio_sell", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal positionRatioSell;
	
	// 买卖
	@Transient
	private int bs;

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
	

	public BigDecimal getDaysCloseLotsPropotion() {
		return daysCloseLotsPropotion;
	}

	public void setDaysCloseLotsPropotion(BigDecimal daysCloseLotsPropotion) {
		this.daysCloseLotsPropotion = daysCloseLotsPropotion;
	}

	public BigDecimal getDaysOpenTurnover() {
		return daysOpenTurnover;
	}

	public void setDaysOpenTurnover(BigDecimal daysOpenTurnover) {
		this.daysOpenTurnover = daysOpenTurnover;
	}

	public BigDecimal getDaysTurnover() {
		return daysTurnover;
	}

	public void setDaysTurnover(BigDecimal daysTurnover) {
		this.daysTurnover = daysTurnover;
	}

	public BigDecimal getDaysCloseTurnover() {
		return daysCloseTurnover;
	}

	public void setDaysCloseTurnover(BigDecimal daysCloseTurnover) {
		this.daysCloseTurnover = daysCloseTurnover;
	}

	public BigDecimal getDaysCloseTurnoverPropotion() {
		return daysCloseTurnoverPropotion;
	}

	public void setDaysCloseTurnoverPropotion(BigDecimal daysCloseTurnoverPropotion) {
		this.daysCloseTurnoverPropotion = daysCloseTurnoverPropotion;
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

	public BigDecimal getPositionValueBuy() {
		return positionValueBuy;
	}

	public void setPositionValueBuy(BigDecimal positionValueBuy) {
		this.positionValueBuy = positionValueBuy;
	}

	public BigDecimal getPositionValueSell() {
		return positionValueSell;
	}

	public void setPositionValueSell(BigDecimal positionValueSell) {
		this.positionValueSell = positionValueSell;
	}

	public BigDecimal getPositionRatioBuy() {
		return positionRatioBuy;
	}

	public void setPositionRatioBuy(BigDecimal positionRatioBuy) {
		this.positionRatioBuy = positionRatioBuy;
	}

	public BigDecimal getPositionRatioSell() {
		return positionRatioSell;
	}

	public void setPositionRatioSell(BigDecimal positionRatioSell) {
		this.positionRatioSell = positionRatioSell;
	}

	public int getBs() {
		return bs;
	}

	public void setBs(int bs) {
		this.bs = bs;
	}
	@Transient
	private BigDecimal buyLots;
	@Transient
	private BigDecimal sellLots;
	@Transient
	private BigDecimal openLots;
	@Transient
	private BigDecimal closeLots;

	public BigDecimal getBuyLots() {
		return buyLots;
	}

	public void setBuyLots(BigDecimal buyLots) {
		this.buyLots = buyLots;
	}

	public BigDecimal getSellLots() {
		return sellLots;
	}

	public void setSellLots(BigDecimal sellLots) {
		this.sellLots = sellLots;
	}

	public BigDecimal getOpenLots() {
		return openLots;
	}

	public void setOpenLots(BigDecimal openLots) {
		this.openLots = openLots;
	}

	public BigDecimal getCloseLots() {
		return closeLots;
	}

	public void setCloseLots(BigDecimal closeLots) {
		this.closeLots = closeLots;
	}

}
