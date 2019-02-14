package com.huaxin.fim.entity.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 回撤返回图表对象
 * @author sust
 *
 */
public class DrawDownResponse implements Serializable{

	private static final long serialVersionUID = 6362910122243802929L;
	private String date;
	private BigDecimal amount;
	private BigDecimal min_amount;
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
	public BigDecimal getMin_amount() {
		return min_amount;
	}
	public void setMin_amount(BigDecimal min_amount) {
		this.min_amount = min_amount;
	}
	
}
