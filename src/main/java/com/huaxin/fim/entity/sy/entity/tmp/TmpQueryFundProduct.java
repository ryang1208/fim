package com.huaxin.fim.entity.sy.entity.tmp;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 产品多元选查询优化
 * @author xieky
 *
 */
public class TmpQueryFundProduct implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3117148536962259417L;

	//产品名称
	private String fundProductName;
	
	//发行规模
	private String beginningCapital;
	
	//是否分级
	private String isLevel;

	//发行规模多选项
	private List<Map<String,Integer>> beginningCapitalList;
	
	public List<Map<String, Integer>> getBeginningCapitalList() {
		return beginningCapitalList;
	}

	public void setBeginningCapitalList(List<Map<String, Integer>> beginningCapitalList) {
		this.beginningCapitalList = beginningCapitalList;
	}

	public String getFundProductName() {
		return fundProductName;
	}

	public void setFundProductName(String fundProductName) {
		this.fundProductName = fundProductName;
	}

	public String getBeginningCapital() {
		return beginningCapital;
	}

	public void setBeginningCapital(String beginningCapital) {
		this.beginningCapital = beginningCapital;
	}

	public String getIsLevel() {
		return isLevel;
	}

	public void setIsLevel(String isLevel) {
		this.isLevel = isLevel;
	}
	
	
	
}
