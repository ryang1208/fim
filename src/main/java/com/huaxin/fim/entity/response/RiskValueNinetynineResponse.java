package com.huaxin.fim.entity.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 风险价值图表对象
 * @author sust
 *
 */
public class RiskValueNinetynineResponse implements Serializable{

	private static final long serialVersionUID = 6362910122243802929L;
	
	
	private String date;
	
	private BigDecimal fiveMarkday;
	
	private BigDecimal tenMarkday;

    private BigDecimal twentyMarkday;

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public BigDecimal getFiveMarkday() {
		return fiveMarkday;
	}

	public void setFiveMarkday(BigDecimal fiveMarkday) {
		this.fiveMarkday = fiveMarkday;
	}

	public BigDecimal getTenMarkday() {
		return tenMarkday;
	}

	public void setTenMarkday(BigDecimal tenMarkday) {
		this.tenMarkday = tenMarkday;
	}

	public BigDecimal getTwentyMarkday() {
		return twentyMarkday;
	}

	public void setTwentyMarkday(BigDecimal twentyMarkday) {
		this.twentyMarkday = twentyMarkday;
	}
    
	
}
