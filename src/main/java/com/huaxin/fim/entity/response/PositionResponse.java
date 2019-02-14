package com.huaxin.fim.entity.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 仓位曲线返回图表对象
 * @author sust
 *
 */
public class PositionResponse implements Serializable{

	private static final long serialVersionUID = 6362910122243802929L;
	private String date;
	private BigDecimal position;
	private BigDecimal fiveDaysAveragePosition;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public BigDecimal getPosition() {
		return position;
	}
	public void setPosition(BigDecimal position) {
		this.position = position;
	}
	public BigDecimal getFiveDaysAveragePosition() {
		return fiveDaysAveragePosition;
	}
	public void setFiveDaysAveragePosition(BigDecimal fiveDaysAveragePosition) {
		this.fiveDaysAveragePosition = fiveDaysAveragePosition;
	}
}
