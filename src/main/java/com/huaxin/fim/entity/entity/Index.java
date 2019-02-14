package com.huaxin.fim.entity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 指数标准数据
 * 
 * @author liumd
 * @since 20170601
 * @version 1.0
 */
@Entity
@Table(name = "t_index")
public class Index implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 721470539593995526L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "seq_t_index") // 适配oracle等没有主键自增长的数据库，改用sequence
	@Column(name = "id", nullable = false)
	private Long id;

	// 交易日期
	@Column(name = "date", length = 10)
	private String date;

	// 指数代码
	@Column(name = "index_id", length = 10)
	private String indexId;
	
	// 指数标准名称
	@Column(name = "index_name", length = 10)
	private String indexName;
	
	// 收盘价
	@Column(name = "close_price", precision = 16, scale = 4)
	@Digits(integer = 12, fraction = 4)
	private BigDecimal closePrice;
	
	// 日收益率
	@Column(name = "daily_yield_rate", precision = 16, scale = 4)
	@Digits(integer = 12, fraction = 4)
	private BigDecimal dailyYieldRate;
	
	// 当月连续合约
	@Column(name = "IFIC_price", precision = 16, scale = 4)
	@Digits(integer = 12, fraction = 4)
	private BigDecimal IFICPrice;
	
	// 指数5日波动率
	@Column(name = "five_day_volatility", precision = 16, scale = 8)
	@Digits(integer = 8, fraction = 8)
	private BigDecimal fiveDayVolatility;

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

	public String getIndexId() {
		return indexId;
	}

	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}

	public String getIndexName() {
		return indexName;
	}

	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	public BigDecimal getClosePrice() {
		return closePrice;
	}

	public void setClosePrice(BigDecimal closePrice) {
		this.closePrice = closePrice;
	}

	public BigDecimal getDailyYieldRate() {
		return dailyYieldRate;
	}

	public void setDailyYieldRate(BigDecimal dailyYieldRate) {
		this.dailyYieldRate = dailyYieldRate;
	}

	public BigDecimal getIFICPrice() {
		return IFICPrice;
	}

	public void setIFICPrice(BigDecimal iFICPrice) {
		IFICPrice = iFICPrice;
	}

	public BigDecimal getFiveDayVolatility() {
		return fiveDayVolatility;
	}

	public void setFiveDayVolatility(BigDecimal fiveDayVolatility) {
		this.fiveDayVolatility = fiveDayVolatility;
	}

	@Override
	public String toString() {
		return "Index{" +
				"id=" + id +
				", date='" + date + '\'' +
				", indexId='" + indexId + '\'' +
				", indexName='" + indexName + '\'' +
				", closePrice=" + closePrice +
				", dailyYieldRate=" + dailyYieldRate +
				", IFICPrice=" + IFICPrice +
				", fiveDayVolatility=" + fiveDayVolatility +
				'}';
	}
}
