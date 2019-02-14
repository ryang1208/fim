package com.huaxin.fim.entity.entity.temp;

import java.math.BigDecimal;

/**
 * 单合约临时数据实体,便于数据计算统计使用
 * @author shenwei
 *
 */
public class TmpContractEntity {

	// 合约代码
	private String contractID;
	
	// 年份
	private String year;
	
	// 值1
	private BigDecimal value1;

	public String getContractID() {
		return contractID;
	}

	public void setContractID(String contractID) {
		this.contractID = contractID;
	}

	public BigDecimal getValue1() {
		return value1;
	}

	public void setValue1(BigDecimal value1) {
		this.value1 = value1;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
}
