package com.huaxin.fim.entity.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 交易周期分布返回图表对象
 * @author sust
 *
 */
public class TradePeriodDistributionResponse implements Serializable{

	private static final long serialVersionUID = 6362910122243802929L;
	private String contact;
	private BigDecimal bs;
	private BigDecimal days;
	private BigDecimal lots;
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public BigDecimal getBs() {
		return bs;
	}
	public void setBs(BigDecimal bs) {
		this.bs = bs;
	}
	public BigDecimal getDays() {
		return days;
	}
	public void setDays(BigDecimal days) {
		this.days = days;
	}
	public BigDecimal getLots() {
		return lots;
	}
	public void setLots(BigDecimal lots) {
		this.lots = lots;
	}
	
	
	
}
