package com.huaxin.fim.entity.enums;

public enum BSType {
	//买方向
	BUY(0),
	//卖方向
	SELL(1);
	

	private int bsType;

	private BSType(int bsType) {

		this.bsType = bsType;
	}

	public int getBsType() {
		return bsType;
	}

	public void setBsType(int bsType) {
		this.bsType = bsType;
	}

}
