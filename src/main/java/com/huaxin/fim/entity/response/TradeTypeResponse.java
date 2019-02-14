package com.huaxin.fim.entity.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 交易类型返回图表对象
 * @author sust
 *
 */
public class TradeTypeResponse implements Serializable{

	private static final long serialVersionUID = 6362910122243802929L;
	private String date;
	private BigDecimal arbitrage;
	private BigDecimal hedges;
	private BigDecimal trend;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public BigDecimal getArbitrage() {
		return arbitrage;
	}
	public void setArbitrage(BigDecimal arbitrage) {
		this.arbitrage = arbitrage;
	}
	public BigDecimal getHedges() {
		return hedges;
	}
	public void setHedges(BigDecimal hedges) {
		this.hedges = hedges;
	}
	public BigDecimal getTrend() {
		return trend;
	}
	public void setTrend(BigDecimal trend) {
		this.trend = trend;
	}
	
	
}
