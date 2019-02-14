package com.huaxin.fim.entity.enums.dictionary;

public enum DepositWithdrawalType {

	//入金;
	DEPOSIT(1),
	//出金;
	WITHDRAWAL(2);
	
	private int intValue;

	private DepositWithdrawalType(int intValue) {

		this.intValue = intValue;
	}

	public int getIntValue() {
		return intValue;
	}


}
