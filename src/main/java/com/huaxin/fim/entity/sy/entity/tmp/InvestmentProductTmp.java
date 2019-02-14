package com.huaxin.fim.entity.sy.entity.tmp;


import com.huaxin.fim.entity.entity.iWinProduct;

import java.io.Serializable;
import java.util.List;

/**
 * 投顾产品产品
 * @author xieky
 *
 */
public class InvestmentProductTmp implements Serializable{

	private static final long serialVersionUID = 1L;

	private String investmentID;//投顾ID
	
	private String productType;//basic,info 基础信息以及详情
	
	private List<iWinProduct> investmentProductList;//产品基本信息
	
	public String getInvestmentID() {
		return investmentID;
	}

	public void setInvestmentID(String investmentID) {
		this.investmentID = investmentID;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public List<iWinProduct> getInvestmentProductList() {
		return investmentProductList;
	}

	public void setInvestmentProductList(List<iWinProduct> investmentProductList) {
		this.investmentProductList = investmentProductList;
	}

}
