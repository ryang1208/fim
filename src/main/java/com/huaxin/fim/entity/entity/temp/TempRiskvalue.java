package com.huaxin.fim.entity.entity.temp;

import java.math.BigDecimal;

//风险价值
public class TempRiskvalue {
	//最新净值
	private BigDecimal newNetValue;
	//净值差
	private BigDecimal netValuePool;
//	时间权重
	private BigDecimal timeWeight;
//	累计权重
	private BigDecimal addUpWeight;
	
	private String dateEvery;
	
	
	public String getDateEvery() {
		return dateEvery;
	}
	public void setDateEvery(String dateEvery) {
		this.dateEvery = dateEvery;
	}
	public BigDecimal getAddUpWeight() {
		return addUpWeight;
	}
	public void setAddUpWeight(BigDecimal addUpWeight) {
		this.addUpWeight = addUpWeight;
	}
	public BigDecimal getTimeWeight() {
		return timeWeight;
	}
	public void setTimeWeight(BigDecimal timeWeight) {
		this.timeWeight = timeWeight;
	}
	public BigDecimal getNewNetValue() {
		return newNetValue;
	}
	public void setNewNetValue(BigDecimal newNetValue) {
		this.newNetValue = newNetValue;
	}
	public BigDecimal getNetValuePool() {
		return netValuePool;
	}
	public void setNetValuePool(BigDecimal netValuePool) {
		this.netValuePool = netValuePool;
	}



}
