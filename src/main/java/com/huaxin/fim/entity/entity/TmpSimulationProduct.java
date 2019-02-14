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
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 模拟组合构建产品表
 * @author liumd
 *
 */
@Entity
@Table(name = "t_simulation_product")
public class TmpSimulationProduct implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "seq_t_simulation_product")
	@Column(name = "id")
	private long id;

	private static final long serialVersionUID = 1L;
	// 产品名称
	@Column(name = "product_name", length = 30)
	@Length(min = 1, max = 30)
	@NotNull
	@NotBlank
	private String productName;

	// 发行规模
	@Column(name = "initial_asset", length = 10)
	@Length(min = 1, max = 10)
	@NotNull
	@NotBlank
	private String initialAsset;

	// 期货投资策略
	@Column(name = "future_strategy_list", length = 64)
	@Length(min = 0, max = 64)
	private String futureStrategyList;
	
	// 证券投资策略
	@Column(name = "securities_strategy_list", length = 64)
	@Length(min = 0, max = 64)
	private String securitiesStrategyList;
	
	// 其他投资策略
	@Column(name = "other_strategy_list", length = 64)
	@Length(min = 0, max = 64)
	private String otherStrategyList;
	
	// 产品存续期（开始时间）
	@Column(name = "duration_begin_date", length = 8)
	@Length(min = 1, max = 8)
	@NotNull
	@NotBlank
	private String durationBeginDate;
	
	// 产品存续期（结束时间）
	@Column(name = "duration_end_date", length = 8)
	@Length(min = 1, max = 8)
	@NotNull
	@NotBlank
	private String durationEndDate;
	
	// 投资策略
	@Column(name = "strategy_list", length = 100)
	@Length(min = 0, max = 100)
	private String strategyList;
	
	// 产品共有存续期（开始时间）
	@Column(name = "co_begin_date", length = 8)
	@Length(min = 1, max = 8)
	@NotNull
	@NotBlank
	private String coBeginDate;
	
	// 产品共有存续期（结束时间）
	@Column(name = "co_end_date", length = 8)
	@Length(min = 1, max = 8)
	@NotNull
	@NotBlank
	private String coEndDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getInitialAsset() {
		return initialAsset;
	}

	public void setInitialAsset(String initialAsset) {
		this.initialAsset = initialAsset;
	}

	public String getFutureStrategyList() {
		return futureStrategyList;
	}

	public void setFutureStrategyList(String futureStrategyList) {
		this.futureStrategyList = futureStrategyList;
	}

	public String getSecuritiesStrategyList() {
		return securitiesStrategyList;
	}

	public void setSecuritiesStrategyList(String securitiesStrategyList) {
		this.securitiesStrategyList = securitiesStrategyList;
	}

	public String getOtherStrategyList() {
		return otherStrategyList;
	}

	public void setOtherStrategyList(String otherStrategyList) {
		this.otherStrategyList = otherStrategyList;
	}

	public String getDurationBeginDate() {
		return durationBeginDate;
	}

	public void setDurationBeginDate(String durationBeginDate) {
		this.durationBeginDate = durationBeginDate;
	}

	public String getDurationEndDate() {
		return durationEndDate;
	}

	public void setDurationEndDate(String durationEndDate) {
		this.durationEndDate = durationEndDate;
	}

	public String getStrategyList() {
		return strategyList;
	}

	public void setStrategyList(String strategyList) {
		this.strategyList = strategyList;
	}

	public String getCoBeginDate() {
		return coBeginDate;
	}

	public void setCoBeginDate(String coBeginDate) {
		this.coBeginDate = coBeginDate;
	}

	public String getCoEndDate() {
		return coEndDate;
	}

	public void setCoEndDate(String coEndDate) {
		this.coEndDate = coEndDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
