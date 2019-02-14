package com.huaxin.fim.entity.response;

import java.io.Serializable;

/**
 * 按类别返回图表对象的值&比例(前N大品种、合约、行业)
 * @author sust
 *
 */
public class ProductMarketTypeResponse implements Serializable{

	private static final long serialVersionUID = 6362910122243802929L;
	private String future;
	private String security;
	private String spotMarket;
	private String bond;
	
	public String getFuture() {
		return future;
	}
	public void setFuture(String future) {
		this.future = future;
	}
	public String getSecurity() {
		return security;
	}
	public void setSecurity(String security) {
		this.security = security;
	}
	public String getSpotMarket() {
		return spotMarket;
	}
	public void setSpotMarket(String spotMarket) {
		this.spotMarket = spotMarket;
	}
	public String getBond() {
		return bond;
	}
	public void setBond(String bond) {
		this.bond = bond;
	}
	
}
