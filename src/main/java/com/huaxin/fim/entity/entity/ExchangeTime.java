package com.huaxin.fim.entity.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 交易所交易时段表
 * 
 * @author liumd
 * @since 20170601
 * @version 1.0
 */
@Entity
@Table(name = "t_exchange_time")
public class ExchangeTime implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 721470539593995526L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "seq_t_exchange_time") // 适配oracle等没有主键自增长的数据库，改用sequence
	@Column(name = "id", nullable = false)
	private Long id;

	// 交易所代码
	@Column(name = "exchange_id", length = 32)
	private String exchangeId;

	// 开盘时间
	@Column(name = "opening_quotation_time", length = 10)
	private String openingQuotationTime;
	
	// 收盘时间
	@Column(name = "closing_quotation_time", length = 10)
	private String closingQuotationTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExchangeId() {
		return exchangeId;
	}

	public void setExchangeId(String exchangeId) {
		this.exchangeId = exchangeId;
	}

	public String getOpeningQuotationTime() {
		return openingQuotationTime;
	}

	public void setOpeningQuotationTime(String openingQuotationTime) {
		this.openingQuotationTime = openingQuotationTime;
	}

	public String getClosingQuotationTime() {
		return closingQuotationTime;
	}

	public void setClosingQuotationTime(String closingQuotationTime) {
		this.closingQuotationTime = closingQuotationTime;
	}

}
