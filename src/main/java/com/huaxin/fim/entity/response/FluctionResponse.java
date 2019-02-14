package com.huaxin.fim.entity.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 仓位曲线返回图表对象
 * @author sust
 *
 */
public class FluctionResponse implements Serializable{

	private static final long serialVersionUID = 6362910122243802929L;
	private String date;
	
	private BigDecimal today;

    private BigDecimal valuea;
	
	public BigDecimal getValuea() {
		return valuea;
	}
	public void setValuea(BigDecimal Valuea) {
		this.valuea = Valuea;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public BigDecimal getToday() {
		return today;
	}
	public void setToday(BigDecimal today) {
		this.today = today;
	}
	
}
