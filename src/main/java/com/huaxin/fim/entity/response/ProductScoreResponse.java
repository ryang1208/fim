package com.huaxin.fim.entity.response;

import java.util.List;

/**
 * 产品评分报表返回结果集对象
 * 
 * @author liumd
 *
 */
public class ProductScoreResponse {

	private String team; // 组别
	private String investerId; // 投资账户
	private String productScore; // 综合得分
	private String tradeDays; // 累计交易日
	private String investerEquity; // 当日权益
	private String closeProfit; // 当日盈亏
	private String inOutMoney;  // 当日出入金
	private String capitalAccout; // 资金账户
	private String productId; // 产品ID
	private String date; // 交易日期
	private String ranking ; // 排名
	private List<ComplexRankColumValueResponse> tdValueList; // 每行动态列数值
	
	public List<ComplexRankColumValueResponse> getTdValueList() {
		return tdValueList;
	}
	public void setTdValueList(List<ComplexRankColumValueResponse> tdValueList) {
		this.tdValueList = tdValueList;
	}
	public String getRanking() {
		return ranking;
	}
	public void setRanking(String ranking) {
		this.ranking = ranking;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getInvesterId() {
		return investerId;
	}
	public void setInvesterId(String investerId) {
		this.investerId = investerId;
	}
	public String getProductScore() {
		return productScore;
	}
	public void setProductScore(String productScore) {
		this.productScore = productScore;
	}
	public String getTradeDays() {
		return tradeDays;
	}
	public void setTradeDays(String tradeDays) {
		this.tradeDays = tradeDays;
	}
	public String getInvesterEquity() {
		return investerEquity;
	}
	public void setInvesterEquity(String investerEquity) {
		this.investerEquity = investerEquity;
	}
	public String getCloseProfit() {
		return closeProfit;
	}
	public void setCloseProfit(String closeProfit) {
		this.closeProfit = closeProfit;
	}
	public String getInOutMoney() {
		return inOutMoney;
	}
	public void setInOutMoney(String inOutMoney) {
		this.inOutMoney = inOutMoney;
	}
	public String getCapitalAccout() {
		return capitalAccout;
	}
	public void setCapitalAccout(String capitalAccout) {
		this.capitalAccout = capitalAccout;
	}
}
