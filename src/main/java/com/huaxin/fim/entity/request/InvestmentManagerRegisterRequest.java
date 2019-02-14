package com.huaxin.fim.entity.request;

import java.io.Serializable;

/**
 *投顾注册对象
 * @author sust
 *
 */
public class InvestmentManagerRegisterRequest implements Serializable{

	private static final long serialVersionUID = -6060579374621048806L;
	private String systemId;
	private String requestType;
	private String productInvestmentManager;
	private String investmentId;
	
	public String getSystemId() {
		return systemId;
	}
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public String getProductInvestmentManager() {
		return productInvestmentManager;
	}
	public void setProductInvestmentManager(String productInvestmentManager) {
		this.productInvestmentManager = productInvestmentManager;
	}
	public String getInvestmentId() {
		return investmentId;
	}
	public void setInvestmentId(String investmentId) {
		this.investmentId = investmentId;
	}
	
}
