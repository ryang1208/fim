/**
 * 
 */
package com.huaxin.fim.entity.enums.dictionary;

/**
 * @author Jiabing
 *
 */
public enum JobRunStatus
{
	// 0: 关闭;
	NO(0),
	
	//1: 启动;
	YES(1);

	private int intValue;

	private JobRunStatus(int intValue) {

		this.intValue = intValue;
	}

	public int getIntValue() {
		return intValue;
	}

}
