package com.huaxin.fim.entity.entity;

public class LastPosition {

	private String accountID;
	private String instrumentID;
	private int last_position;
	private double ratio;
	
	public LastPosition(String accountID, String instrumentID, int last_position, double ratio) {
		this.accountID = accountID;
		this.instrumentID = instrumentID;
		this.last_position = last_position;
		this.ratio = ratio;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getInstrumentID() {
		return instrumentID;
	}

	public void setInstrumentID(String instrumentID) {
		this.instrumentID = instrumentID;
	}

	public int getLast_position() {
		return last_position;
	}

	public void setLast_position(int last_position) {
		this.last_position = last_position;
	}

	public double getRatio() {
		return ratio;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
	}
	
}
