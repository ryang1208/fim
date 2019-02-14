package com.huaxin.fim.entity.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 风险度返回图表对象
 * @author sust
 *
 */
public class RiskDegreeResponse implements Serializable{

	private static final long serialVersionUID = 6362910122243802929L;
	private String date;
	private BigDecimal riskDegree;
	private BigDecimal averageRiskDegree;
	//仓位
	private BigDecimal position;
	private BigDecimal fiveDaysAveragePosition;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public BigDecimal getRiskdegree() {
		return riskDegree;
	}
	public void setRiskdegree(BigDecimal riskdegree) {
		this.riskDegree = riskdegree;
	}
	public BigDecimal getAverageRiskdegree() {
		return averageRiskDegree;
	}
	public void setAverageRiskdegree(BigDecimal averageRiskdegree) {
		averageRiskDegree = averageRiskdegree;
	}
	public BigDecimal getPosition() {
		return position;
	}
	public void setPosition(BigDecimal position) {
		this.position = position;
	}
	public BigDecimal getFiveDaysAveragePosition() {
		return fiveDaysAveragePosition;
	}
	public void setFiveDaysAveragePosition(BigDecimal fiveDaysAveragePosition) {
		this.fiveDaysAveragePosition = fiveDaysAveragePosition;
	}
	
	
}
