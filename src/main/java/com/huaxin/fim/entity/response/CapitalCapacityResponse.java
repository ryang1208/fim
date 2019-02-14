package com.huaxin.fim.entity.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 交易类型返回图表对象
 * @author sust
 *
 */
public class CapitalCapacityResponse implements Serializable{

	private static final long serialVersionUID = 6362910122243802929L;
	private BigDecimal maxInvesterEquity;
	private BigDecimal maxRiskDegree;
	private BigDecimal marginOccupied;
	private BigDecimal investerEquity;
	private String maxRiskDate;
	
	public BigDecimal getMaxInvesterEquity() {
		return maxInvesterEquity;
	}
	public void setMaxInvesterEquity(BigDecimal maxInvesterEquity) {
		this.maxInvesterEquity = maxInvesterEquity;
	}
	public BigDecimal getMaxRiskDegree() {
		return maxRiskDegree;
	}
	public void setMaxRiskDegree(BigDecimal maxRiskDegree) {
		this.maxRiskDegree = maxRiskDegree;
	}
	public BigDecimal getMarginOccupied() {
		return marginOccupied;
	}
	public void setMarginOccupied(BigDecimal marginOccupied) {
		this.marginOccupied = marginOccupied;
	}
	public BigDecimal getInvesterEquity() {
		return investerEquity;
	}
	public void setInvesterEquity(BigDecimal investerEquity) {
		this.investerEquity = investerEquity;
	}
	public String getMaxRiskDate() {
		return maxRiskDate;
	}
	public void setMaxRiskDate(String maxRiskDate) {
		this.maxRiskDate = maxRiskDate;
	}
	
}
