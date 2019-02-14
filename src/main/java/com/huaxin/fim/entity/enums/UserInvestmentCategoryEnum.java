package com.huaxin.fim.entity.enums;

/**
 * 用户投顾类别枚举对象
 * @author wucq
 *
 */
public enum UserInvestmentCategoryEnum {
	
	// 投顾
	INVESTMENT("1"),
	// 机构
	ORGANIZATION("2"),
	// 用户
	USER("3");

	private String cateory;

	private UserInvestmentCategoryEnum(String cateory) {

		this.cateory = cateory;
	}

	public String getCateory() {
		return cateory;
	}
}
