package com.huaxin.fim.entity.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 仓位曲线返回图表对象
 * @author sust
 *
 */
public class ConcentrationOnStocksResponse implements Serializable{

	private static final long serialVersionUID = 6362910122243802929L;
	private String date;
	private BigDecimal bigAwkwardness;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public BigDecimal getBigAwkwardness() {
		return bigAwkwardness;
	}
	public void setBigAwkwardness(BigDecimal bigAwkwardness) {
		this.bigAwkwardness = bigAwkwardness;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
