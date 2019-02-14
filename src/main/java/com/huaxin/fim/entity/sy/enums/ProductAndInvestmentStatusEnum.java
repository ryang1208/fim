package com.huaxin.fim.entity.sy.enums;

/**
 * 审核投顾产品状态
 * @author xieky
 *
 */
public enum ProductAndInvestmentStatusEnum {

	REG("0"), // 注册
	REG_AGAIN("1"),//再注册
	FIRST_ADVISER_PASS("2"),//初审通过
	FIRST_ADVISER_REFUSE("3"),//初审拒绝
	FIRST_ADVISER_UNDETERMINED("4"),//初审拒绝
	LAST_ADVISER_PASS("5"),//终审通过	
	LAST_ADVISER_REFUSE("6"),//终审通过	
	CONFIRM_SET("7"),//确定配置	
	LAST_ADVISER_UNDETERMINED("8");//待定
	
	private String stringValue;
	
	private ProductAndInvestmentStatusEnum(String stringValue) {
		
		this.stringValue = stringValue;
	}

	public String getStringValue() {
		return stringValue;
	}
}
