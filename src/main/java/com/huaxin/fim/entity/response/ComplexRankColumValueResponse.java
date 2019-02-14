package com.huaxin.fim.entity.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 综合排名中一组指标对应数据对象
 * 
 * @author liumd
 *
 */
public class ComplexRankColumValueResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal kpiValue; // 指标数值
	private BigDecimal kpiScore; // 指标得分
	private BigDecimal weight; // 指标权重
	private BigDecimal totalScore; // 指标总分

	public BigDecimal getKpiValue() {
		return kpiValue;
	}

	public void setKpiValue(BigDecimal kpiValue) {
		this.kpiValue = kpiValue;
	}

	public BigDecimal getKpiScore() {
		return kpiScore;
	}

	public void setKpiScore(BigDecimal kpiScore) {
		this.kpiScore = kpiScore;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public BigDecimal getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(BigDecimal totalScore) {
		this.totalScore = totalScore;
	}

}
