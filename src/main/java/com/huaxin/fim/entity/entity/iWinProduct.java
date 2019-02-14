package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/*
 * 基金产品对应的实体类
 */
@Entity
@Table(name = "t_product" , uniqueConstraints = {
		@UniqueConstraint(columnNames = {"product_name"}) }	)
public class iWinProduct implements Serializable {

	private static final long serialVersionUID = 1L;
	// 序号（自动编号）
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "seq_t_product") // 适配oracle等没有主键自增长的数据库，改用sequence
	@Column(name = "id")
	private Long id;
	// 产品名称
	@Column(name = "product_name", length = 50)
	@Length(min = 1, max = 50)
	@NotNull
	@NotBlank
	private String productName;
	// 产品代码
	@Column(name = "product_code", length = 32)
	@Length(min = 0, max = 32)
	private String productCode;
	// 产品全称
	@Column(name = "product_short_name", length = 128)
	@Length(min = 0, max = 128)
	private String productShortName;
	// 产品描述
	@Column(name = "product_discription")
	private String productDiscription;
	// 产品状态(数据字典) 3为注销状态
	@Column(name = "product_status")
	private String productStatus;
	// 币种(数据字典)
	@Column(name = "currency")
	private String currency;
	// 净资产
	@Column(name = "net_value", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal netValue;
	// 最新净值
	@Column(name = "newest_net_value", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal newestNetValue;
	// 最新净值更新日期
	@Column(name = "newest_net_value_update_date", length = 8)
	@Length(min = 0, max = 8)
	private String newestNetValueUpdateDate;
	// 最新净值日期
	@Column(name = "newest_net_value_date", length = 8)
	@Length(min = 0, max = 8)
	private String newestNetValueDate;
	// 最新净值数据来源
	@Column(name = "newest_net_value_data_source", length = 8)
	@Length(min = 0, max = 8)
	private String newestNetValueDataSource;

	// 交割数据更新日期
	@Column(name = "newest_settlement_sheet_update_date", length = 8)
	@Length(min = 0, max = 8)
	private String newestSettlementSheetUpdateDate;
	// 最新交割数据日期
	@Column(name = "newest_settlement_sheet_date", length = 8)
	@Length(min = 0, max = 8)
	private String newestSettlementSheetDate;
	// 最新交割数据来源
	@Column(name = "newest_settlement_sheet_data_source", length = 8)
	@Length(min = 0, max = 8)
	private String newestSettlementSheetDataSource;
		
	// 盈利比
	@Column(name = "profit_ratio", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal profitRatio;
	// 夏普率
	@Column(name = "sharp_rate", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal sharpRate;
	// 风险收益比
	@Column(name = "risk_return_ratio", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal riskReturnRatio;
	// 最大回撤
	@Column(name = "max_drawdown", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal maxDrawdown;
	// 平均回撤
	@Column(name = "average_drawdown", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal averageDrawdown;
	// 年化收益率
	@Column(name = "annual_return", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal annualReturn;
	// 成立时间
	@Column(name = "create_date", length = 8)
	@Length(min = 0, max = 8)
	private String createDate;
	// 管理类型
	@Column(name = "type_management", length = 32)
	@Length(min = 0, max = 32)
	private String typeManagement;
	// 托管人名称
	@Column(name = "trustee_name", length = 32)
	@Length(min = 0, max = 32)
	private String trusteeName;
	// 是否分级
	@Column(name = "is_grading", length = 2)
	@Length(min = 0, max = 2)
	private String isGrading;
	// 杠杆比例
	@Column(name = "leverage_ratio", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal leverageRatio;
	// 初始规模(万元) = 发行规模(万元)
	@Column(name = "initial_asset", length=10)
	@Length(min = 0, max = 10)
	private String initialAsset;
	// 存续期限（月）
	@Column(name = "duration_month")
	@Length(min = 0, max = 5)
	private String durationMonth;
	// 开放日（描述）
	@Column(name = "open_date_describe", length = 100)
	@Length(min = 0, max = 100)
	private String openDateDescribe;
	// 认购起点
	@Column(name = "subscription_start", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal subscriptionStart;
	// 追加起点
	@Column(name = "addition_start", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal additionStart;
	// 认购费率
	@Column(name = "subscription_fee", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal subscriptionFee;
	// 赎回费率
	@Column(name = "redemption_fee", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal redemptionFee;

	// 期货投资策略
	@Column(name = "future_strategy_list", length = 64)
	@Length(min = 0, max = 64)
	private String futureStrategyList;
	// 证券投资策略
	@Column(name = "securities_strategy_list", length = 64)
	@Length(min = 0, max = 64)
	private String securitiesStrategyList;
	// 其他投资策略
	@Column(name = "other_strategy_list", length = 64)
	@Length(min = 0, max = 64)
	private String otherStrategyList;
	// 预警线
	@Column(name = "warning_line", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal warningLine;
	// 止损线
	@Column(name = "stop_loss_line", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal stopLossLine;
	// 业绩报酬
	@Column(name = "performance_reward", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal performanceReward;
	// 管理费率
	@Column(name = "management_fee_rate", precision = 21, scale = 5)
	@Digits(integer = 16, fraction = 5)
	private BigDecimal managementFeeRate;
	// 托管费率
	@Column(name = "trust_fee_rate", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal trustFeeRate;
	// 投顾费率
	@Column(name = "adviser_fee_rate", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal adviserFeeRate;
	// DECIMAL NULL 外包费率
	@Column(name = "outsource_fee_rate", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal outsourceFeeRate;
	// 基金管理人
	@Column(name = "fund_manager", length = 32)
	@Length(min = 0, max = 32)
	private String fundManager;
	// 基金托管人(基金管理人)
	@Column(name = "fund_trustee", length = 32)
	@Length(min = 0, max = 32)
	private String fundTrustee;
	// 外包服务商
	@Column(name = "outsourcing_company", length = 32)
	@Length(min = 0, max = 32)
	private String outsourcingCompany;
	// 基金份额
	@Column(name = "fund_unit", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal fundUnit;
	// 结构化形式
	@Column(name = "is_structure")
	private String isStructure;
	//基金产品类型
    @Column(name = "product_type", length = 8)
	@Length(min = 0, max = 8)
	private String productType;
    //产品管理人
    @Column(name = "product_manager", length = 50)
	@Length(min = 0, max = 50)
	private String productManager;
    //是否自主发行
    @Column(name = "is_independent", length = 2)
	@Length(min = 0, max = 2)
	private String isIndependent;
    
    //投顾来的字段添加
	@Column(name = "investment_id", nullable = true, length = 100)
	@Length(min = 0, max = 100)
	private String investmentID;//投顾ID
	
	@Column(name = "product_netChart", nullable = true, length = 100)
	@Length(min = 0, max = 100)
	private String productNetChart;//产品净值图
	
	@Column(name = "portfolio_fund", nullable = true)
	@Length(min = 0, max = 50)
	private String portfolioFund;//组合基金（母基金）
	
	@Column(name = "trustee", nullable = true)
	@Length(min = 0, max = 20)
	private String trustee;//托管机构
	
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
	
	
	@Column(name = "is_parent_product", nullable = true)
	@Length(min = 0, max = 1)
	private String isParentProduct;//是否是母基金 1是 ，0否
	
	// 分组(1:轻量；2：重量)
	@Column(name = "group_id", length = 2)
	@Length(min = 0, max = 2)
	private String group;
	
	@Column(name = "qdiam_product_code", nullable = true)
	@Length(min = 0, max = 50)
	private String QDIAMProductCode;//QDIAM产品号
	
	@Column(name = "evaluate_type", nullable = true)
	@Length(min = 0, max = 1)
	private String evaluateType;//评测类型
	
	// 投资策略
	@Column(name = "strategy_list", length = 100)
	@Length(min = 0, max = 100)
	private String strategyList;
	
	@Column(name = "calculate_type", nullable = true)
	@Length(min = 0, max = 1)
	private String calculateType;//净值计算方法（1：大赛，2：标准）
	
	//清算日期
	@Column(name = "settlement_date", length = 8)
	@Length(min = 0, max = 8)
	private String settlementDate;
	
	//主机构
	@Column(name = "organization_id", length = 8)
	@Length(min = 0, max = 30)
	private String organizationId;	
	
	//最大回撤起期
	@Column(name = "max_drawdown_start_date", length = 8)
	@Length(min = 0, max = 8)
	private String maxDrawdownStartDate;
	
	//最大回撤止期
	@Column(name = "max_drawdown_end_date", length = 8)
	@Length(min = 0, max = 8)
	private String maxDrawdownEndDate;
	
	//业务经理Id
	@Column(name = "service_manager_id", length = 8)
	@Length(min = 0, max = 30)
	private String serviceManagerId;
	
	//渠道ID
	@Column(name = "channel_user_id", length = 20)
	@Length(min = 0, max = 20)
	private String channelUserID;
	
	//投顾用户名ID
	@Column(name = "investment_user_id", length = 20)
	@Length(min = 0, max = 20)
	private String investmentUserID;
			
	public String getChannelUserID() {
		return channelUserID;
	}
	public void setChannelUserID(String channelUserID) {
		this.channelUserID = channelUserID;
	}
	public String getInvestmentUserID() {
		return investmentUserID;
	}
	public void setInvestmentUserID(String investmentUserID) {
		this.investmentUserID = investmentUserID;
	}
	public String getServiceManagerId() {
		return serviceManagerId;
	}
	public void setServiceManagerId(String serviceManagerId) {
		this.serviceManagerId = serviceManagerId;
	}
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public String getSettlementDate() {
		return settlementDate;
	}
	public void setSettlementDate(String settlementDate) {
		this.settlementDate = settlementDate;
	}
	public String getCalculateType() {
		return calculateType;
	}
	public void setCalculateType(String calculateType) {
		this.calculateType = calculateType;
	}
	@Transient
	private String futuresBroker;//期货经销商
	
	@Transient
	private String securitiesCompany;//证券经销商
	
	@Transient
	private String investmentName;//投顾名称
	
	@Transient
	private String strategy; // 策略
	
	// 是否关注(0否 1是)
	@Transient
	private String isConcentration;
	
	//是否需要计算净值（0：否，1：是）
    @Column(name = "is_calculate_netValue", length = 1)
	@Length(min = 0, max = 1)
	private String isCalculateNetValue;
    
    @Transient
    private String startDate;
    @Transient
    private String endDate;
    @Transient
    private Long relationshipId;
    // 母基金占子基金比例
    @Transient
    private BigDecimal productRatio;
	
	public String getIsCalculateNetValue() {
		return isCalculateNetValue;
	}
	public void setIsCalculateNetValue(String isCalculateNetValue) {
		this.isCalculateNetValue = isCalculateNetValue;
	}
	public String getStrategy() {
		return strategy;
	}
	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}
	@Transient
	private List<ProductInvesterRelationship> productInvesterRelationshipList;//经济公司或者证券公司
	
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getIsIndependent() {
		return isIndependent;
	}
	public void setIsIndependent(String isIndependent) {
		this.isIndependent = isIndependent;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductShortName() {
		return productShortName;
	}
	public void setProductShortName(String productShortName) {
		this.productShortName = productShortName;
	}
	public String getProductDiscription() {
		return productDiscription;
	}
	public void setProductDiscription(String productDiscription) {
		this.productDiscription = productDiscription;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public BigDecimal getNetValue() {
		return netValue;
	}
	public void setNetValue(BigDecimal netValue) {
		this.netValue = netValue;
	}
	public BigDecimal getProfitRatio() {
		return profitRatio;
	}
	public void setProfitRatio(BigDecimal profitRatio) {
		this.profitRatio = profitRatio;
	}
	public BigDecimal getSharpRate() {
		return sharpRate;
	}
	public void setSharpRate(BigDecimal sharpRate) {
		this.sharpRate = sharpRate;
	}
	public BigDecimal getRiskReturnRatio() {
		return riskReturnRatio;
	}
	public void setRiskReturnRatio(BigDecimal riskReturnRatio) {
		this.riskReturnRatio = riskReturnRatio;
	}
	public BigDecimal getMaxDrawdown() {
		return maxDrawdown;
	}
	public void setMaxDrawdown(BigDecimal maxDrawdown) {
		this.maxDrawdown = maxDrawdown;
	}
	public BigDecimal getAverageDrawdown() {
		return averageDrawdown;
	}
	public void setAverageDrawdown(BigDecimal averageDrawdown) {
		this.averageDrawdown = averageDrawdown;
	}
	public BigDecimal getAnnualReturn() {
		return annualReturn;
	}
	public void setAnnualReturn(BigDecimal annualReturn) {
		this.annualReturn = annualReturn;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getTypeManagement() {
		return typeManagement;
	}
	public void setTypeManagement(String typeManagement) {
		this.typeManagement = typeManagement;
	}
	public String getTrusteeName() {
		return trusteeName;
	}
	public void setTrusteeName(String trusteeName) {
		this.trusteeName = trusteeName;
	}
	public String getIsGrading() {
		return isGrading;
	}
	public void setIsGrading(String isGrading) {
		this.isGrading = isGrading;
	}
	public BigDecimal getLeverageRatio() {
		return leverageRatio;
	}
	public void setLeverageRatio(BigDecimal leverageRatio) {
		this.leverageRatio = leverageRatio;
	}
	public String getInitialAsset() {
		return initialAsset;
	}
	public void setInitialAsset(String initialAsset) {
		this.initialAsset = initialAsset;
	}
	public String getDurationMonth() {
		return durationMonth;
	}
	public void setDurationMonth(String durationMonth) {
		this.durationMonth = durationMonth;
	}
	public BigDecimal getSubscriptionStart() {
		return subscriptionStart;
	}
	public void setSubscriptionStart(BigDecimal subscriptionStart) {
		this.subscriptionStart = subscriptionStart;
	}
	public BigDecimal getAdditionStart() {
		return additionStart;
	}
	public void setAdditionStart(BigDecimal additionStart) {
		this.additionStart = additionStart;
	}
	public BigDecimal getSubscriptionFee() {
		return subscriptionFee;
	}
	public void setSubscriptionFee(BigDecimal subscriptionFee) {
		this.subscriptionFee = subscriptionFee;
	}
	public BigDecimal getRedemptionFee() {
		return redemptionFee;
	}
	public void setRedemptionFee(BigDecimal redemptionFee) {
		this.redemptionFee = redemptionFee;
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
	public BigDecimal getWarningLine() {
		return warningLine;
	}
	public void setWarningLine(BigDecimal warningLine) {
		this.warningLine = warningLine;
	}
	public BigDecimal getStopLossLine() {
		return stopLossLine;
	}
	public void setStopLossLine(BigDecimal stopLossLine) {
		this.stopLossLine = stopLossLine;
	}
	public BigDecimal getPerformanceReward() {
		return performanceReward;
	}
	public void setPerformanceReward(BigDecimal performanceReward) {
		this.performanceReward = performanceReward;
	}
	public BigDecimal getManagementFeeRate() {
		return managementFeeRate;
	}
	public void setManagementFeeRate(BigDecimal managementFeeRate) {
		this.managementFeeRate = managementFeeRate;
	}
	public BigDecimal getTrustFeeRate() {
		return trustFeeRate;
	}
	public void setTrustFeeRate(BigDecimal trustFeeRate) {
		this.trustFeeRate = trustFeeRate;
	}
	public BigDecimal getAdviserFeeRate() {
		return adviserFeeRate;
	}
	public void setAdviserFeeRate(BigDecimal adviserFeeRate) {
		this.adviserFeeRate = adviserFeeRate;
	}
	public BigDecimal getOutsourceFeeRate() {
		return outsourceFeeRate;
	}
	public void setOutsourceFeeRate(BigDecimal outsourceFeeRate) {
		this.outsourceFeeRate = outsourceFeeRate;
	}
	public String getFundManager() {
		return fundManager;
	}
	public void setFundManager(String fundManager) {
		this.fundManager = fundManager;
	}
	public String getFundTrustee() {
		return fundTrustee;
	}
	public void setFundTrustee(String fundTrustee) {
		this.fundTrustee = fundTrustee;
	}
	public String getOutsourcingCompany() {
		return outsourcingCompany;
	}
	public void setOutsourcingCompany(String outsourcingCompany) {
		this.outsourcingCompany = outsourcingCompany;
	}
	public BigDecimal getFundUnit() {
		return fundUnit;
	}
	public void setFundUnit(BigDecimal fundUnit) {
		this.fundUnit = fundUnit;
	}
	public String getIsStructure() {
		return isStructure;
	}
	public void setIsStructure(String isStructure) {
		this.isStructure = isStructure;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductManager() {
		return productManager;
	}
	public void setProductManager(String productManager) {
		this.productManager = productManager;
	}
	public String getInvestmentID() {
		return investmentID;
	}
	public void setInvestmentID(String investmentID) {
		this.investmentID = investmentID;
	}
	public String getProductNetChart() {
		return productNetChart;
	}
	public void setProductNetChart(String productNetChart) {
		this.productNetChart = productNetChart;
	}
	public String getPortfolioFund() {
		return portfolioFund;
	}
	public void setPortfolioFund(String portfolioFund) {
		this.portfolioFund = portfolioFund;
	}
	public String getTrustee() {
		return trustee;
	}
	public void setTrustee(String trustee) {
		this.trustee = trustee;
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
	public String getInvestmentName() {
		return investmentName;
	}
	public void setInvestmentName(String investmentName) {
		this.investmentName = investmentName;
	}
	public String getIsParentProduct() {
		return isParentProduct;
	}
	public void setIsParentProduct(String isParentProduct) {
		this.isParentProduct = isParentProduct;
	}
	public String getOpenDateDescribe() {
		return openDateDescribe;
	}
	public void setOpenDateDescribe(String openDateDescribe) {
		this.openDateDescribe = openDateDescribe;
	}
	public List<ProductInvesterRelationship> getProductInvesterRelationshipList() {
		return productInvesterRelationshipList;
	}
	public void setProductInvesterRelationshipList(List<ProductInvesterRelationship> productInvesterRelationshipList) {
		this.productInvesterRelationshipList = productInvesterRelationshipList;
	}
	public String getQDIAMProductCode() {
		return QDIAMProductCode;
	}
	public void setQDIAMProductCode(String qDIAMProductCode) {
		QDIAMProductCode = qDIAMProductCode;
	}
	public String getEvaluateType() {
		return evaluateType;
	}
	public void setEvaluateType(String evaluateType) {
		this.evaluateType = evaluateType;
	}
	public String getIsConcentration() {
		return isConcentration;
	}
	public void setIsConcentration(String isConcentration) {
		this.isConcentration = isConcentration;
	}
	public String getFuturesBroker() {
		return futuresBroker;
	}
	public void setFuturesBroker(String futuresBroker) {
		this.futuresBroker = futuresBroker;
	}
	public String getSecuritiesCompany() {
		return securitiesCompany;
	}
	public void setSecuritiesCompany(String securitiesCompany) {
		this.securitiesCompany = securitiesCompany;
	}
	
	public String getStrategyList() {
		return strategyList;
	}
	public void setStrategyList(String strategyList) {
		this.strategyList = strategyList;
	}
	
	@Transient
	private BigDecimal netAccumulativeValue;

	public BigDecimal getNetAccumulativeValue() {
		return netAccumulativeValue;
	}
	public void setNetAccumulativeValue(BigDecimal netAccumulativeValue) {
		this.netAccumulativeValue = netAccumulativeValue;
	}	
	public Long getRelationshipId() {
		return relationshipId;
	}
	public void setRelationshipId(Long relationshipId) {
		this.relationshipId = relationshipId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public BigDecimal getProductRatio() {
		return productRatio;
	}
	public void setProductRatio(BigDecimal productRatio) {
		this.productRatio = productRatio;
	}
	
	public iWinProduct() {
	}
	
	public iWinProduct(Long id,String productName,Long relationshipId,String startDate,String endDate, BigDecimal productRatio,String type) {
		this.id = id;
		this.productName = productName;
		this.relationshipId = relationshipId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.productRatio = productRatio;
		this.type = type;
	}
	public BigDecimal getNewestNetValue() {
		return newestNetValue;
	}
	public void setNewestNetValue(BigDecimal newestNetValue) {
		this.newestNetValue = newestNetValue;
	}
	public String getNewestNetValueUpdateDate() {
		return newestNetValueUpdateDate;
	}
	public void setNewestNetValueUpdateDate(String newestNetValueUpdateDate) {
		this.newestNetValueUpdateDate = newestNetValueUpdateDate;
	}
	public String getNewestNetValueDate() {
		return newestNetValueDate;
	}
	public void setNewestNetValueDate(String newestNetValueDate) {
		this.newestNetValueDate = newestNetValueDate;
	}
	public String getNewestSettlementSheetUpdateDate() {
		return newestSettlementSheetUpdateDate;
	}
	public void setNewestSettlementSheetUpdateDate(String newestSettlementSheetUpdateDate) {
		this.newestSettlementSheetUpdateDate = newestSettlementSheetUpdateDate;
	}
	public String getNewestSettlementSheetDate() {
		return newestSettlementSheetDate;
	}
	public void setNewestSettlementSheetDate(String newestSettlementSheetDate) {
		this.newestSettlementSheetDate = newestSettlementSheetDate;
	}
	public String getNewestNetValueDataSource() {
		return newestNetValueDataSource;
	}
	public void setNewestNetValueDataSource(String newestNetValueDataSource) {
		this.newestNetValueDataSource = newestNetValueDataSource;
	}
	public String getNewestSettlementSheetDataSource() {
		return newestSettlementSheetDataSource;
	}
	public void setNewestSettlementSheetDataSource(String newestSettlementSheetDataSource) {
		this.newestSettlementSheetDataSource = newestSettlementSheetDataSource;
	}
	public String getMaxDrawdownStartDate() {
		return maxDrawdownStartDate;
	}
	public void setMaxDrawdownStartDate(String maxDrawdownStartDate) {
		this.maxDrawdownStartDate = maxDrawdownStartDate;
	}
	public String getMaxDrawdownEndDate() {
		return maxDrawdownEndDate;
	}
	public void setMaxDrawdownEndDate(String maxDrawdownEndDate) {
		this.maxDrawdownEndDate = maxDrawdownEndDate;
	}
	
	@Transient
	private String type; // 母子关系类型

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
