package com.huaxin.fim.entity.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 盈亏分析返图表回对象
 * @author liumd
 *
 */
public class TotalYieldAndLossResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6362910122243802929L;
	private String date;
	private BigDecimal amount;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
