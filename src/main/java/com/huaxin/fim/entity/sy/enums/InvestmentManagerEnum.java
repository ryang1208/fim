package com.huaxin.fim.entity.sy.enums;

/**
 * 投顾状态
 * @author xieky
 *
 */
public enum InvestmentManagerEnum {

	NEW("0"),//新进
	CANCEL("1"),//注销
	TRIAL_SUCCESS("2"),//初审通过
	TRIAL_REFUSE("3"),//初审拒绝
	TRIAL_UNDETERMINED("4"),//初审待定
	ASSESSMENT_SUCCESS("5"),//评估通过
	ASSESSMENT_REFUSE("6"),//评估拒绝
	ASSESSMENT_UNDETERMINED("7"),//评估待定
	INVESTMENT_COUNCIL_SUCCESS("8"),//投决会通过
	INVESTMENT_COUNCIL_REFUSE("9");//投决会拒绝
	
	private String stringValue;
	
	private InvestmentManagerEnum(String stringValue) {
		
		this.stringValue = stringValue;
	}

	public String getStringValue() {
		return stringValue;
	}
}
