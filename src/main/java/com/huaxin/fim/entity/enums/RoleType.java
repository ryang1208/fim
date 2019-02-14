package com.huaxin.fim.entity.enums;

public enum RoleType {
	
	// 1:业务经理;
	BUSINESS_MANAGER(1),
	// 投资管理人
	INVESTMENT_ADVISOR(2),
	//3:超级管理员;
	ADMIN(3),
	// 渠道用户
	CHANNEL_USER(4),
	// 初审人员
	VOTING_TRIAL_USER(5),
	// 复审人员
	VOTING_REVIEW_USER(6),
	// 投决会审批人员
	VOTING_JUDGMENT_USER(7),
	//机构管理员
	ORDANIZATION_ADNIN(8);
	
	private int intValue;

	private RoleType(int intValue) {

		this.intValue = intValue;
	}

	public int getIntValue() {
		return intValue;
	}

}
