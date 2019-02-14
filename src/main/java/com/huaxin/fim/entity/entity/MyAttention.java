package com.huaxin.fim.entity.entity;

public class MyAttention {
	
	private String dataValue;
	
	private String dataDescribe;

	public MyAttention(String dataValue, String dataDescribe) {
		this.dataValue = dataValue;
		this.dataDescribe = dataDescribe;
	}

	public String getDataValue() {
		return dataValue;
	}

	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}

	public String getDataDescribe() {
		return dataDescribe;
	}

	public void setDataDescribe(String dataDescribe) {
		this.dataDescribe = dataDescribe;
	}
	
}
