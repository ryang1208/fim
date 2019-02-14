package com.huaxin.fim.entity.enums.dictionary;

/**
 * 评分配置指标类型枚举
 * @author liumd
 *
 */
public enum ReportKpiTypeEnum {
	// 1:定性;
	Qualitative("1"),
	// 2:定量;
	Quantitative("2");
	
	private String value;

	private ReportKpiTypeEnum(String value) {

		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
