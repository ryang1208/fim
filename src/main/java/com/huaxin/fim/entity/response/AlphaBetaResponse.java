package com.huaxin.fim.entity.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 詹森，贝塔值返回图表对象
 * @author wcq
 *
 */

public class AlphaBetaResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2362910122243802929L;
	private String date;
	private BigDecimal alphaValue;
	private BigDecimal betaVale;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public BigDecimal getAlphaValue() {
		return alphaValue;
	}
	public void setAlphaValue(BigDecimal alphaValue) {
		this.alphaValue = alphaValue;
	}
	public BigDecimal getBetaVale() {
		return betaVale;
	}
	public void setBetaVale(BigDecimal betaVale) {
		this.betaVale = betaVale;
	}
	
	

}
