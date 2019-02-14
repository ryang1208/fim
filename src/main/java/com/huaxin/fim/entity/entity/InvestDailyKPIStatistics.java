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
@Table(name = "t_invest_daily_kpi_statistics" , uniqueConstraints = {@UniqueConstraint(columnNames = {"date","broker_invester_id"})})

public class InvestDailyKPIStatistics implements Serializable {

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

}
