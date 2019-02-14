package com.huaxin.fim.entity.response;

/**
 * 
 * @author sust 风险指标
 */
public class RiskIndicatorResponse {
	private String yearStandardDeviation;// 年化收益率的标准差
	private String skewness;// 偏度值
	private String kurtosis;// 峰度值
	private String maxDrawDownCycle; // 最大水下回撤恢复周期(天)
	private String thisYearYieldRate;// 今年以来收益率
	private String byYearYieldRate;// 年化收益率
	private String riskReturnRate;// 收益回撤比
	private String sharpRatio; // 夏普率
	private String sortinoRatio; // 索提诺比率
	private String calmarRatio; // 卡玛
	
	
	private String reynorPerformanceMeasure;
	private String informationRatio;
	private String maxUnderWaterDrawdown;
	private String maxWaterDrawdown;
	private String maxDrawdownFCycle;
	private String drawdownFCycle;
	private String maxDrawdownRCycle;
	private String drawdownRCycle;
		
	public String getMaxDrawDownCycle() {
		return maxDrawDownCycle;
	}

	public void setMaxDrawDownCycle(String maxDrawDownCycle) {
		this.maxDrawDownCycle = maxDrawDownCycle;
	}

	public String getYearStandardDeviation() {
		return yearStandardDeviation;
	}

	public void setYearStandardDeviation(String yearStandardDeviation) {
		this.yearStandardDeviation = yearStandardDeviation;
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

	public String getThisYearYieldRate() {
		return thisYearYieldRate;
	}

	public void setThisYearYieldRate(String thisYearYieldRate) {
		this.thisYearYieldRate = thisYearYieldRate;
	}

	public String getByYearYieldRate() {
		return byYearYieldRate;
	}

	public void setByYearYieldRate(String byYearYieldRate) {
		this.byYearYieldRate = byYearYieldRate;
	}

	public String getRiskReturnRate() {
		return riskReturnRate;
	}

	public void setRiskReturnRate(String riskReturnRate) {
		this.riskReturnRate = riskReturnRate;
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

	public String getCalmarRatio() {
		return calmarRatio;
	}

	public void setCalmarRatio(String calmarRatio) {
		this.calmarRatio = calmarRatio;
	}

	public String getReynorPerformanceMeasure() {
		return reynorPerformanceMeasure;
	}

	public void setReynorPerformanceMeasure(String reynorPerformanceMeasure) {
		this.reynorPerformanceMeasure = reynorPerformanceMeasure;
	}

	public String getMaxDrawdownFCycle() {
		return maxDrawdownFCycle;
	}

	public void setMaxDrawdownFCycle(String maxDrawdownFCycle) {
		this.maxDrawdownFCycle = maxDrawdownFCycle;
	}

	public String getDrawdownFCycle() {
		return drawdownFCycle;
	}

	public void setDrawdownFCycle(String drawdownFCycle) {
		this.drawdownFCycle = drawdownFCycle;
	}

	public String getInformationRatio() {
		return informationRatio;
	}

	public void setInformationRatio(String informationRatio) {
		this.informationRatio = informationRatio;
	}

	public String getMaxUnderWaterDrawdown() {
		return maxUnderWaterDrawdown;
	}

	public void setMaxUnderWaterDrawdown(String maxUnderWaterDrawdown) {
		this.maxUnderWaterDrawdown = maxUnderWaterDrawdown;
	}

	public String getMaxWaterDrawdown() {
		return maxWaterDrawdown;
	}

	public void setMaxWaterDrawdown(String maxWaterDrawdown) {
		this.maxWaterDrawdown = maxWaterDrawdown;
	}

	public String getMaxDrawdownRCycle() {
		return maxDrawdownRCycle;
	}

	public void setMaxDrawdownRCycle(String maxDrawdownRCycle) {
		this.maxDrawdownRCycle = maxDrawdownRCycle;
	}

	public String getDrawdownRCycle() {
		return drawdownRCycle;
	}

	public void setDrawdownRCycle(String drawdownRCycle) {
		this.drawdownRCycle = drawdownRCycle;
	}

		
}