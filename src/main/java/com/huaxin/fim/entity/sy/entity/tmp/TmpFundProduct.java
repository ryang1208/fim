package com.huaxin.fim.entity.sy.entity.tmp;

import java.io.Serializable;

/**
 * 基金产品导出实体类
 * @author konglingqi
 *
 */
public class TmpFundProduct  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	// 基金产品代码/基金编码
	private String fundProductID;
		
	// 基金产品名称
	private String fundProductName;
	
	//累计净值
	private String accumulationIopv;
	
	//当前净值
	private String iopv;
	
	//更新日期
	private String fundUpdated;
	

	public TmpFundProduct(){}
	
	public TmpFundProduct(String fundProductID, String fundProductName, String accumulationIopv,
			String iopv,String fundUpdated) {
		super();
		this.fundUpdated = fundUpdated;
		this.fundProductID = fundProductID;
		this.fundProductName = fundProductName;
		this.accumulationIopv = accumulationIopv;
		this.iopv = iopv;
	}

	public String getFundProductID() {
		return fundProductID;
	}

	public void setFundProductID(String fundProductID) {
		this.fundProductID = fundProductID;
	}

	public String getFundProductName() {
		return fundProductName;
	}

	public void setFundProductName(String fundProductName) {
		this.fundProductName = fundProductName;
	}

	public String getAccumulationIopv() {
		return accumulationIopv;
	}

	public void setAccumulationIopv(String accumulationIopv) {
		this.accumulationIopv = accumulationIopv;
	}

	public String getIopv() {
		return iopv;
	}

	public void setIopv(String iopv) {
		this.iopv = iopv;
	}

	public String getFundUpdated() {
		return fundUpdated;
	}

	public void setFundUpdated(String fundUpdated) {
		this.fundUpdated = fundUpdated;
	}
	
}
