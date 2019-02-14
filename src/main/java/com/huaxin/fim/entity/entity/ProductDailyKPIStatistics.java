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
 * 投资账户每日统计表对应的实体类
 */
@Embeddable
@Entity
@Table(name = "t_product_daily_kpi_statistics" , uniqueConstraints = {@UniqueConstraint(columnNames = {"date","product_id"})})

public class ProductDailyKPIStatistics implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5928243727801229042L;

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
	
	// 夏普率
	@Column(name = "sharp_ratio", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal sharpRatio;

	// 索提诺比率
	@Column(name = "sortino_ratio", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal sortinoRatio;
	
	// 卡玛比率
	@Column(name = "calmar_ratio", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal calmarRatio;
	
	// 最大回撤
	@Column(name = "max_drawdown", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal maxDrawdown;
	
	// 平均回撤
	@Column(name = "average_drawdown", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal averageDrawdown;	
	
	// 累计净值
	@Column(name = "net_accumulative_value", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal netAccumulativeValue;
	
	// 最新淨值
	@Column(name = "net_newest_value", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal netNewestValue;

	// 风报比
	@Column(name = "risk_return_ratio", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal riskReturnRatio;
	
	// 最大水下回撤恢复天数
	@Column(name = "max_underwater_drawdown_recover_day", length = 8)
	private int maxUnderwaterDrawdownRecoverDay;
	
	// 当前连续上涨天数
	@Column(name = "current_rise_continuously_day", length = 8)
	private int currentRiseContinuouslyDay;
	
	// 股票仓位
	@Column(name = "stock_position", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal stockPosition;
	
	// 大盘股市值
	@Column(name = "large_stock_market_value", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal largeStockMarketValue;
	
	// 中盘股市值
	@Column(name = "middle_stock_market_value", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal middleStockMarketValue;
	
	// 小盘股市值
	@Column(name = "small_stock_market_value", precision = 24, scale = 8)
	@Digits(integer = 16, fraction = 8)
	private BigDecimal smallStockMarketValue;
	// 最大连续上涨天数
	@Column(name = "max_rise_continuously_day", length = 8)
	private int maxRiseContinuouslyDay;
	
	// 最大连续下跌天数
	@Column(name = "max_plummet_continuously_day", length = 8)
	private int maxPlummetContinuouslyDay;
		
	public BigDecimal getRiskReturnRatio() {
		return riskReturnRatio;
	}

	public void setRiskReturnRatio(BigDecimal riskReturnRatio) {
		this.riskReturnRatio = riskReturnRatio;
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

	public BigDecimal getSharpRatio() {
		return sharpRatio;
	}

	public void setSharpRatio(BigDecimal sharpRatio) {
		this.sharpRatio = sharpRatio;
	}

	public BigDecimal getSortinoRatio() {
		return sortinoRatio;
	}

	public void setSortinoRatio(BigDecimal sortinoRatio) {
		this.sortinoRatio = sortinoRatio;
	}

	public BigDecimal getCalmarRatio() {
		return calmarRatio;
	}

	public void setCalmarRatio(BigDecimal calmarRatio) {
		this.calmarRatio = calmarRatio;
	}

	public BigDecimal getMaxDrawdown() {
		return maxDrawdown;
	}

	public void setMaxDrawdown(BigDecimal maxDrawdown) {
		this.maxDrawdown = maxDrawdown;
	}

	public BigDecimal getAverageDrawdown() {
		return averageDrawdown;
	}

	public void setAverageDrawdown(BigDecimal averageDrawdown) {
		this.averageDrawdown = averageDrawdown;
	}

	public BigDecimal getNetAccumulativeValue() {
		return netAccumulativeValue;
	}

	public void setNetAccumulativeValue(BigDecimal netAccumulativeValue) {
		this.netAccumulativeValue = netAccumulativeValue;
	}

	public BigDecimal getNetNewestValue() {
		return netNewestValue;
	}

	public void setNetNewestValue(BigDecimal netNewestValue) {
		this.netNewestValue = netNewestValue;
	}

	
}
