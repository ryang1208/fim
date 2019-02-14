package com.huaxin.fim.entity.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 日内交易分布返回图表对象
 * @author sust
 *
 */
public class DaysTradeDistributionResponse implements Serializable{

	private static final long serialVersionUID = 6362910122243802929L;
	private String date;
	private BigDecimal daysPropotion;
	private BigDecimal nonDaysPropotion;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public BigDecimal getDaysPropotion() {
		return daysPropotion;
	}
	public void setDaysPropotion(BigDecimal daysPropotion) {
		this.daysPropotion = daysPropotion;
	}
	public BigDecimal getNonDaysPropotion() {
		return nonDaysPropotion;
	}
	public void setNonDaysPropotion(BigDecimal nonDaysPropotion) {
		this.nonDaysPropotion = nonDaysPropotion;
	}
	
}
