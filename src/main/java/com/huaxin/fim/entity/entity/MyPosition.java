package com.huaxin.fim.entity.entity;

import java.util.HashMap;
import java.util.Map;

public class MyPosition {

	private String accountID;
	private String instrumentID;
	
	private int position;
	private int last_position;
	
	private double ratio;
	
	public static Map<String, MyPosition> mdSnapshootCacheMap = new HashMap<String, MyPosition>();
	
	public MyPosition(String accountID, String instrumentID, int position, int last_position, double ratio) {
		this.accountID = accountID;
		this.instrumentID = instrumentID;
		this.position = position;
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

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
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
