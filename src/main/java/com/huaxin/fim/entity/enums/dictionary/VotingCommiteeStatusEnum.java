package com.huaxin.fim.entity.enums.dictionary;
/*
 * 投决会状态
 */
public enum VotingCommiteeStatusEnum {
	
	// 新进
	NEW("0"),
	// 注销
	CANCELLATION("1"),
	// 初审通过
	TRIAL_ACCEPT("2"),
	// 初审拒绝
	TRIAL_REFUSE("3"),
	// 初审待定
	TRIAL_UNDETERMINED("4"),
	// 复审通过
	REVIEW_ACCEPT("5"),
	// 复审拒绝
	REVIEW_REFUSE("6"),
	// 复审待定
	REVIEW_UNDETERMINED("7"),
	// 投决会通过
	JUDGMENT_ACCEPT("8"),
	// 投决会拒绝
	JUDGMENT_REFUSE("9");
	
	private String stringValue;

	private VotingCommiteeStatusEnum(String stringValue) {

		this.stringValue = stringValue;
	}

	public String getStringValue() {
		return stringValue;
	}

}
