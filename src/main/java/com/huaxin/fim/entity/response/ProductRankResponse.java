package com.huaxin.fim.entity.response;

import java.math.BigDecimal;
import java.util.List;

/**
 * 产品排名返回对象
 * 
 * @author liumd
 *
 */
public class ProductRankResponse {

	private String investerId; // 投资账户
	public String getInvesterId() {
		return investerId;
	}

	public void setInvesterId(String investerId) {
		this.investerId = investerId;
	}

	private BigDecimal productScore; // 综合得分
	private String productId; // 产品ID
	private String ranking ; // 排名
	private List<ComplexRankColumValueResponse> tdValueList; // 每行动态列数值
	
	private String kpi; // 指标代码
	private String periodType; // 指标周期类型
	private BigDecimal score; // 指标得分
	private String date; // 交易日期
	
	private String productStatus; //产品状态
	private BigDecimal AverageScore;
	private BigDecimal OriginScore;
	private BigDecimal Weight;
	private BigDecimal value;
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	private List<ProductKpiData> kpiInfo;

	public BigDecimal getProductScore() {
		return productScore;
	}

	public void setProductScore(BigDecimal productScore) {
		this.productScore = productScore;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getRanking() {
		return ranking;
	}

	public void setRanking(String ranking) {
		this.ranking = ranking;
	}

	public List<ComplexRankColumValueResponse> getTdValueList() {
		return tdValueList;
	}

	public void setTdValueList(List<ComplexRankColumValueResponse> tdValueList) {
		this.tdValueList = tdValueList;
	}

	public String getKpi() {
		return kpi;
	}

	public void setKpi(String kpi) {
		this.kpi = kpi;
	}

	public String getPeriodType() {
		return periodType;
	}

	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	public List<ProductKpiData> getKpiInfo() {
		return kpiInfo;
	}

	public void setKpiInfo(List<ProductKpiData> kpiInfo) {
		this.kpiInfo = kpiInfo;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public BigDecimal getAverageScore() {
		return AverageScore;
	}

	public void setAverageScore(BigDecimal averageScore) {
		AverageScore = averageScore;
	}

	public BigDecimal getOriginScore() {
		return OriginScore;
	}

	public void setOriginScore(BigDecimal originScore) {
		OriginScore = originScore;
	}

	public BigDecimal getWeight() {
		return Weight;
	}

	public void setWeight(BigDecimal weight) {
		Weight = weight;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
}
