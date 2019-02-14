package com.huaxin.fim.entity.response;


/**
 * 模拟组合基金存续期查询结果存储对象
 * 
 * @author liumd
 *
 */
public class DurationResponse {

	private String minDate; // 存续期开始日期
	private String maxDate; // 存续期结束日期
	public String getMinDate() {
		return minDate;
	}
	public void setMinDate(String minDate) {
		this.minDate = minDate;
	}
	public String getMaxDate() {
		return maxDate;
	}
	public void setMaxDate(String maxDate) {
		this.maxDate = maxDate;
	}
}
