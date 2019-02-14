package com.huaxin.fim.entity.entity;

/**
 * 因子对象
 */
public class FactorObject {

    private String factorID;	// 因子ID
    private String sortType;	// 排序方式:1.从小到大 2.从大到小
    
	public FactorObject(String factorID, String sortType) {
        this.factorID = factorID;
        this.sortType = sortType;
    }

	public String getFactorID() {
		return factorID;
	}

	public String getSortType() {
		return sortType;
	}

	public FactorObject(String factorID) {
		this.factorID = factorID;
	}

}
