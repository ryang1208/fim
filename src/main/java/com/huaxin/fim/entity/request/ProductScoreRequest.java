package com.huaxin.fim.entity.request;

/**
 * 期货大赛产品评分报表查询条件对象
 * 
 * @author liumd
 *
 */
public class ProductScoreRequest {

	private String capitalAccount;
	private String name;
	private String tradeDate;
	private String[] groupType;
	private String reportId;
	
	public String getReportId() {
		return reportId;
	}
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	public String[] getGroupType() {
		return groupType;
	}
	public void setGroupType(String[] groupType) {
		this.groupType = groupType;
	}
	public String getCapitalAccount() {
		return capitalAccount;
	}
	public void setCapitalAccount(String capitalAccount) {
		this.capitalAccount = capitalAccount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}

}
