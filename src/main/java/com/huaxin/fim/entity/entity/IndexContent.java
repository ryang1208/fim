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
@Table(name = "t_index_content")
public class IndexContent implements Serializable {
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
	@Column(name = "index_id", length = 30)
	private String indexId;
	
	// 行业
	@Column(name = "industry", length = 50)
	private String industry;
	
	// 基准收益率
	@Column(name = "base_yield_rate", precision = 16, scale = 4)
	@Digits(integer = 12, fraction = 4)
	private BigDecimal baseYieldRate;
	
	// 基准权重率
	@Column(name = "base_weight", precision = 16, scale = 4)
	@Digits(integer = 12, fraction = 4)
	private BigDecimal baseWeight;

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

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public BigDecimal getBaseYieldRate() {
		return baseYieldRate;
	}

	public void setBaseYieldRate(BigDecimal baseYieldRate) {
		this.baseYieldRate = baseYieldRate;
	}

	public BigDecimal getBaseWeight() {
		return baseWeight;
	}

	public void setBaseWeight(BigDecimal baseWeight) {
		this.baseWeight = baseWeight;
	}


	@Override
	public String toString() {
		return "IndexContent{" +
				"id=" + id +
				", date='" + date + '\'' +
				", indexId='" + indexId + '\'' +
				", industry='" + industry + '\'' +
				", baseYieldRate=" + baseYieldRate +
				", baseWeight=" + baseWeight +
				'}';
	}
}
