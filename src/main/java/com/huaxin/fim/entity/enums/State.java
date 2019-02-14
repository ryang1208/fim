package com.huaxin.fim.entity.enums;
/*
 * 定义文件解析存储状态
 */
public enum State {
	//成功
	SUCCESS("0"),
	//处理中
	PROCESSING("1"),
	//失败
	FAIL("2");

	private String stateType;

	private State(String stateType) {

		this.stateType = stateType;
	}

	public String getStateType() {
		return stateType;
	}
}
