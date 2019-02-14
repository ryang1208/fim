/**
 * 
 */
package com.huaxin.fim.entity.enums.dictionary;

/**
 *  是或否
 *  
 * @author Jiabing
 *
 */
public enum YesOrNo {
	
	// 0:否;
	NO(0),
	
	//1:是;
	YES(1);

	private int intValue;

	private YesOrNo(int intValue) {

		this.intValue = intValue;
	}

	public int getIntValue() {
		return intValue;
	}
}
