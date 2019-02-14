package com.huaxin.fim.entity.response;

import java.io.Serializable;

/**
 * 风险指标对比数据对象
 * 
 * @author liumd
 *
 */
public class RiskCompareResponse implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private String productName; // 产品名称
	private String productId; // 产品代码
	private String yearVolatilityRatio; // 年化波动率
	private String sharpRatio; // 夏普比率
	private String sortinoRatio; // 索提诺比率
	private String calmarRatio; // 卡玛比率
	private String skewness; // 偏度值
	private String kurtosis; // 风度值
	private String infoRatio; // 年化信息比率
	private String treyorRatio; // 特雷诺比率
	private String underWater; // 水下最大回撤比率
	private String upWater; // 水上最大回撤比率
	private String recoverDays; // 最大回撤恢复期
	private String foramtionDays; // 最大回撤形成期
	
	public String getInfoRatio() {
		return infoRatio;
	}

	public void setInfoRatio(String infoRatio) {
		this.infoRatio = infoRatio;
	}

	public String getTreyorRatio() {
		return treyorRatio;
	}

	public void setTreyorRatio(String treyorRatio) {
		this.treyorRatio = treyorRatio;
	}

	public String getUnderWater() {
		return underWater;
	}

	public void setUnderWater(String underWater) {
		this.underWater = underWater;
	}

	public String getUpWater() {
		return upWater;
	}

	public void setUpWater(String upWater) {
		this.upWater = upWater;
	}

	public String getRecoverDays() {
		return recoverDays;
	}

	public void setRecoverDays(String recoverDays) {
		this.recoverDays = recoverDays;
	}

	public String getForamtionDays() {
		return foramtionDays;
	}

	public void setForamtionDays(String foramtionDays) {
		this.foramtionDays = foramtionDays;
	}

	private String maxDrawDownRecoverDay;
	private String maxDdrawdown; 
	private String undermaxDdrawdown;
	private String yieldRatio;
	private String yearYieldRatio;
	

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getMaxDdrawdown() {
		return maxDdrawdown;
	}

	public void setMaxDdrawdown(String maxDdrawdown) {
		this.maxDdrawdown = maxDdrawdown;
	}

	public String getSharpRatio() {
		return sharpRatio;
	}

	public void setSharpRatio(String sharpRatio) {
		this.sharpRatio = sharpRatio;
	}

	public String getSortinoRatio() {
		return sortinoRatio;
	}

	public void setSortinoRatio(String sortinoRatio) {
		this.sortinoRatio = sortinoRatio;
	}


	public String getUndermaxDdrawdown() {
		return undermaxDdrawdown;
	}

	public void setUndermaxDdrawdown(String undermaxDdrawdown) {
		this.undermaxDdrawdown = undermaxDdrawdown;
	}

	public String getYieldRatio() {
		return yieldRatio;
	}

	public void setYieldRatio(String yieldRatio) {
		this.yieldRatio = yieldRatio;
	}

	public String getYearYieldRatio() {
		return yearYieldRatio;
	}

	public void setYearYieldRatio(String yearYieldRatio) {
		this.yearYieldRatio = yearYieldRatio;
	}

	public String getYearVolatilityRatio() {
		return yearVolatilityRatio;
	}

	public void setYearVolatilityRatio(String yearVolatilityRatio) {
		this.yearVolatilityRatio = yearVolatilityRatio;
	}

	public String getCalmarRatio() {
		return calmarRatio;
	}

	public void setCalmarRatio(String calmarRatio) {
		this.calmarRatio = calmarRatio;
	}

	public String getSkewness() {
		return skewness;
	}

	public void setSkewness(String skewness) {
		this.skewness = skewness;
	}

	public String getKurtosis() {
		return kurtosis;
	}

	public void setKurtosis(String kurtosis) {
		this.kurtosis = kurtosis;
	}

	public String getMaxDrawDownRecoverDay() {
		return maxDrawDownRecoverDay;
	}

	public void setMaxDrawDownRecoverDay(String maxDrawDownRecoverDay) {
		this.maxDrawDownRecoverDay = maxDrawDownRecoverDay;
	}
	
	
}
