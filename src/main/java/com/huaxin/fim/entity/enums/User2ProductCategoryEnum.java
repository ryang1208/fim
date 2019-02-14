package com.huaxin.fim.entity.enums;

/**
 * 用户产品类别枚举对象
 * @author liumd
 *
 */
public enum User2ProductCategoryEnum {
	
	// 用户
	USER("1"),
	// 投顾
	INVESTMENT("2"),
	// 机构
	ORGANIZATION("3"),
	// 产品
	PRODUCT("4");

	private String cateory;

	private User2ProductCategoryEnum(String cateory) {

		this.cateory = cateory;
	}

	public String getCateory() {
		return cateory;
	}
}
