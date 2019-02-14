package com.huaxin.fim.entity.enums;

public enum DepositWithdrawalType {
	//入金
	DEPOSIT(1),
	//出金
	WITHDRAWAL(2);
	

	private int depositWithdrawalType;

	private DepositWithdrawalType(int depositWithdrawalType) {

		this.depositWithdrawalType = depositWithdrawalType;
	}

	public int getDepositWithdrawalType() {
		return depositWithdrawalType;
	}

	public void setDepositWithdrawalType(int depositWithdrawalType) {
		this.depositWithdrawalType = depositWithdrawalType;
	}

}
