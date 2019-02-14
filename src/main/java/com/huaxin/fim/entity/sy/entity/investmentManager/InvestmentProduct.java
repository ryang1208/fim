package com.huaxin.fim.entity.sy.entity.investmentManager;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;

/**
 * 投顾产品介绍
 * @author xieky
 *
 */
@Entity
@Table(name = "t_investment_product", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})} )
public class InvestmentProduct implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "investment_id", nullable = true, length = 100)
	@Length(min = 0, max = 100)
	private String investmentID;//投顾ID
	
	@Column(name = "fundProduct_name", nullable = true, length = 100)
	@Length(min = 0, max = 100)
	private String productName;//产品名称
	
	@Column(name = "fund_manager", nullable = true, length = 100)
	@Length(min = 0, max = 100)
	private String fundManager;//基金经理
	
	@Column(name = "fund_established", nullable = true, length = 100)
	@Length(min = 0, max = 200)
	private String createDate;//成立日期
	
	@Column(name = "beginning_capital", nullable = true, length = 100)
	@Length(min = 0, max = 10)
	private String initialAsset;//发行规模(万元)
	
	@Column(name = "net_worth", nullable = true, length = 100)
	@Length(min = 0, max = 10)
	private String netValue;//净值
	
	//期货投资策略
	@Column(name = "investment_strategy", nullable = true, length = 100)
	@Length(min = 0, max = 100)
	private String futureStrategyList;
	
	//证券投资策略
	@Column(name = "stock_investment_strategy", nullable = true, length = 100)
	@Length(min = 0, max = 100)
	private String securitiesStrategyList;
	
	//其他投资策略
	@Column(name = "other_investment_strategy", nullable = true, length = 100)
	@Length(min = 0, max = 100)
	private String otherStrategyList;
	
	@Column(name = "duration", nullable = true, length = 100)
	@Length(min = 0, max = 100)
	private String durationMonth;//存续期限(月)
	
	@Column(name = "profit_proportion", nullable = true, length = 100)
	@Length(min = 0, max = 100)
	private String profitRatio;//盈利比
	
	@Column(name = "sharp_rate", nullable = true, length = 100)
	@Length(min = 0, max = 100)
	private String sharpRate;//夏普率
	
	@Column(name = "risk_return_ratio", nullable = true, length = 100)
	@Length(min = 0, max = 100)
	private String riskReturnRatio;//风险收益比
	
	@Column(name = "maximum_withdrawal", nullable = true, length = 100)
	@Length(min = 0, max = 100)
	private String maxDrawdown;//最大回撤
	
	@Column(name = "average_withdrawal", nullable = true, length = 100)
	@Length(min = 0, max = 100)
	private String averageDrawdown;//平均回撤
	
	
	@Column(name = "annual_yield", nullable = true, length = 100)
	@Length(min = 0, max = 100)
	private String annualReturn;//年化收益率
	
	@Column(name = "product_introduction",length = 1000)
	@Length(min = 0, max = 1000)
	private String productDiscription;//产品具体介绍
	
	@Column(name = "product_netChart", nullable = true, length = 100)
	@Length(min = 0, max = 100)
	private String productNetChart;//产品净值图
	
	@Column(name = "is_not_own_issue", nullable = true)
	@Length(min = 0, max = 1)
	private String isIndependent;//是否自主发行
	
	@Column(name = "portfolio_fund", nullable = true)
	@Length(min = 0, max = 50)
	private String portfolioFund;//组合基金（母基金）
	
	@Column(name = "fund_code", nullable = true)
	@Length(min = 0, max = 20)
	private String productCode;//基金编号
	
	@Column(name = "fund_status", nullable = true)
	@Length(min = 0, max = 20)
	private String productStatus;//产品状态

	@Column(name = "fund_administrator", nullable = true)
	@Length(min = 0, max = 100)
	private String fundTrustee;//基金管理人
	
	@Column(name = "trustee", nullable = true)
	@Length(min = 0, max = 20)
	private String trustee;//托管机构
	
	@Column(name = "is_not_structured", nullable = true)
	@Length(min = 0, max = 1)
	private String isStructure;//是否结构化
	
	@Column(name = "investment_closure_period", nullable = true)
	@Length(min = 0, max = 10)
	private String investmentClosurePeriod;//投资封闭期(月)
	
	@Column(name = "recruitment_scale", nullable = true)
	@Length(min = 0, max = 10)
	private String recruitmentScale;//募集规模
	
	@Column(name = "scope_of_investment", nullable = true)
	@Length(min = 0, max = 10)
	private String scopeOfInvestment;//投资范围
	
	@Column(name = "subscription_amount", nullable = true)
	@Length(min = 0, max = 10)
	private String subscriptionAmount;//认购金额
	
	@Column(name = "performance_compensation", nullable = true)
	@Length(min = 0, max = 10)
	private String performanceReward;//业绩报酬
	
	@Column(name = "net_release_frequency", nullable = true)
	@Length(min = 0, max = 10)
	private String netReleaseFrequency;//净值公布频率
	
	@Column(name = "monthly_yield", nullable = true)
	@Length(min = 0, max = 10)
	private String monthlyYield;//月收益率
	
	@Column(name = "average_earnings_cycle", nullable = true)
	@Length(min = 0, max = 10)
	private String averageEarningsCycle;//平均盈利周期(天)
	
	@Column(name = "average_loss_cycle", nullable = true)
	@Length(min = 0, max = 10)
	private String averageLossPeriod;//平均亏损周期（天）
	
	@Column(name = "warning_line", nullable = true)
	@Length(min = 0, max = 10)
	private String warningLine;//预警线
	
	@Column(name = "stop_line", nullable = true)
	@Length(min = 0, max = 10)
	private String stopLossLine;//止损线
	
	@Column(name = "investment_source", nullable = true)
	@Length(min = 0, max = 1)
	private String investmentSource;//投顾来源
	
	@Column(name = "investment_user_name", nullable = true)
	@Length(min = 0, max = 50)
	private String investmentUserName;//投顾用户名
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInvestmentID() {
		return investmentID;
	}

	public void setInvestmentID(String investmentID) {
		this.investmentID = investmentID;
	}

	public String getDurationMonth() {
		return durationMonth;
	}

	public void setDurationMonth(String durationMonth) {
		this.durationMonth = durationMonth;
	}

	public String getSharpRate() {
		return sharpRate;
	}

	public void setSharpRate(String sharpRate) {
		this.sharpRate = sharpRate;
	}

	public String getRiskReturnRatio() {
		return riskReturnRatio;
	}

	public void setRiskReturnRatio(String riskReturnRatio) {
		this.riskReturnRatio = riskReturnRatio;
	}

	public String getMaxDrawdown() {
		return maxDrawdown;
	}

	public void setMaxDrawdown(String maxDrawdown) {
		this.maxDrawdown = maxDrawdown;
	}

	public String getAverageDrawdown() {
		return averageDrawdown;
	}

	public void setAverageDrawdown(String averageDrawdown) {
		this.averageDrawdown = averageDrawdown;
	}

	public String getAnnualReturn() {
		return annualReturn;
	}

	public void setAnnualReturn(String annualReturn) {
		this.annualReturn = annualReturn;
	}

	public String getProductDiscription() {
		return productDiscription;
	}

	public void setProductDiscription(String productDiscription) {
		this.productDiscription = productDiscription;
	}

	public String getProductNetChart() {
		return productNetChart;
	}

	public void setProductNetChart(String productNetChart) {
		this.productNetChart = productNetChart;
	}

	public String getFundManager() {
		return fundManager;
	}

	public void setFundManager(String fundManager) {
		this.fundManager = fundManager;
	}

	public String getIsIndependent() {
		return isIndependent;
	}

	public void setIsIndependent(String isIndependent) {
		this.isIndependent = isIndependent;
	}

	public String getPortfolioFund() {
		return portfolioFund;
	}

	public void setPortfolioFund(String portfolioFund) {
		this.portfolioFund = portfolioFund;
	}
	
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public String getFundTrustee() {
		return fundTrustee;
	}

	public void setFundTrustee(String fundTrustee) {
		this.fundTrustee = fundTrustee;
	}

	public String getTrustee() {
		return trustee;
	}

	public void setTrustee(String trustee) {
		this.trustee = trustee;
	}

	public String getIsStructure() {
		return isStructure;
	}

	public void setIsStructure(String isStructure) {
		this.isStructure = isStructure;
	}

	public String getInvestmentClosurePeriod() {
		return investmentClosurePeriod;
	}

	public void setInvestmentClosurePeriod(String investmentClosurePeriod) {
		this.investmentClosurePeriod = investmentClosurePeriod;
	}

	public String getRecruitmentScale() {
		return recruitmentScale;
	}

	public void setRecruitmentScale(String recruitmentScale) {
		this.recruitmentScale = recruitmentScale;
	}

	public String getScopeOfInvestment() {
		return scopeOfInvestment;
	}

	public void setScopeOfInvestment(String scopeOfInvestment) {
		this.scopeOfInvestment = scopeOfInvestment;
	}

	public String getSubscriptionAmount() {
		return subscriptionAmount;
	}

	public void setSubscriptionAmount(String subscriptionAmount) {
		this.subscriptionAmount = subscriptionAmount;
	}

	public String getPerformanceReward() {
		return performanceReward;
	}

	public void setPerformanceReward(String performanceReward) {
		this.performanceReward = performanceReward;
	}

	public String getNetReleaseFrequency() {
		return netReleaseFrequency;
	}

	public void setNetReleaseFrequency(String netReleaseFrequency) {
		this.netReleaseFrequency = netReleaseFrequency;
	}

	public String getMonthlyYield() {
		return monthlyYield;
	}

	public void setMonthlyYield(String monthlyYield) {
		this.monthlyYield = monthlyYield;
	}

	public String getAverageEarningsCycle() {
		return averageEarningsCycle;
	}

	public void setAverageEarningsCycle(String averageEarningsCycle) {
		this.averageEarningsCycle = averageEarningsCycle;
	}

	public String getAverageLossPeriod() {
		return averageLossPeriod;
	}

	public void setAverageLossPeriod(String averageLossPeriod) {
		this.averageLossPeriod = averageLossPeriod;
	}

	public String getWarningLine() {
		return warningLine;
	}

	public void setWarningLine(String warningLine) {
		this.warningLine = warningLine;
	}

	public String getStopLossLine() {
		return stopLossLine;
	}

	public void setStopLossLine(String stopLossLine) {
		this.stopLossLine = stopLossLine;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getInvestmentSource() {
		return investmentSource;
	}

	public void setInvestmentSource(String investmentSource) {
		this.investmentSource = investmentSource;
	}

	public String getInvestmentUserName() {
		return investmentUserName;
	}

	public void setInvestmentUserName(String investmentUserName) {
		this.investmentUserName = investmentUserName;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getInitialAsset() {
		return initialAsset;
	}

	public void setInitialAsset(String initialAsset) {
		this.initialAsset = initialAsset;
	}

	public String getNetValue() {
		return netValue;
	}

	public void setNetValue(String netValue) {
		this.netValue = netValue;
	}

	public String getFutureStrategyList() {
		return futureStrategyList;
	}

	public void setFutureStrategyList(String futureStrategyList) {
		this.futureStrategyList = futureStrategyList;
	}

	public String getSecuritiesStrategyList() {
		return securitiesStrategyList;
	}

	public void setSecuritiesStrategyList(String securitiesStrategyList) {
		this.securitiesStrategyList = securitiesStrategyList;
	}

	public String getOtherStrategyList() {
		return otherStrategyList;
	}

	public void setOtherStrategyList(String otherStrategyList) {
		this.otherStrategyList = otherStrategyList;
	}

	public String getProfitRatio() {
		return profitRatio;
	}

	public void setProfitRatio(String profitRatio) {
		this.profitRatio = profitRatio;
	}
	
}
