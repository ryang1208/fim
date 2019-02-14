package com.huaxin.fim.entity.sy.entity.basicInfo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 基金产品信息
 * @author shenwei
 *
 */
@Entity
@Table(name = "t_fund_product", uniqueConstraints = {@UniqueConstraint(columnNames = {"fund_product_id"})} )
public class FundProductInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	// 基金产品代码/基金编码
	@Column(name = "fund_product_id", nullable = false, length = 10)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 10)
	private String fundProductID;
		
	// 基金产品名称
	@Column(name = "fund_product_name", nullable = false, length = 50)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 100)
	private String fundProductName;
	
	// 基金产品全称
	@Column(name = "fund_product_short_name", length = 50)
	@Length(min = 0, max = 50)
	private String fundProductShortName;
	
	// 母基金代码
	@Column(name = "prior_fund_product_id",length = 50)
	@Length(min = 0, max = 50)
	private String priorFundProductID;
	
	// 排序编号
	@Column(name = "order_id",length = 10)
	@Length(min = 0, max = 10)
	private String orderID;
	
	// 是否有效
	@Column(name = "is_active", nullable = false, length = 1)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 1)
	private String isActive;

	//产品状态
	@Column(name = "product_state", nullable = false, length = 1)
	@Length(min = 0, max = 1)
	private String productState;

	//币种
	@Column(name = "fund_org", nullable = true, length = 5)
	@Length(min = 0, max = 5)
	private String fundOrg;
	
	//成立时间
	@Column(name = "fund_established", nullable = true, length = 10)
	@Length(min = 0, max = 10)
	private String fundEstablished;
	
	//基金管理人名称
	@Column(name = "fund_managers_name", nullable = true, length = 100)
	@Length(min = 0, max = 100)
	private String fundManagersName;
	
	//管理类型
	@Column(name = "networth_updated", nullable = true, length = 20)
	@Length(min = 0, max = 20)
	private String fundManagerType;
	
	//托管人名称
	@Column(name = "fund_custodian_ame", nullable = true, length = 100)
	@Length(min = 0, max = 100)
	private String fundCustodianName;
	
	//投资经理
	@Column(name = "fund_investment_manager", nullable = true, length = 100)
	@Length(min = 0, max = 100)
	private String fundInvestmentManager;
	
	//是否分级
	@Column(name = "is_level", nullable = true, length = 1)
	@Length(min = 0, max = 1)
	private String isLevel;
	
	//杠杆比例
	@Column(name = "leverage", nullable = true, length = 10)
	@Length(min = 0, max = 10)
	private String leverage;
	
	//初始规模(万元）
	@Column(name = "beginning_capital", nullable = true, length = 9)
	@Length(min = 0, max = 9)
	private String beginningCapital;
	
	//存续期限（月）
	@Column(name = "duration", nullable = true, length = 10)
	@Length(min = 0, max = 10)
	private String duration;
	
	
	//开放日
	@Column(name = "open_day", nullable = true, length = 10)
	@Length(min = 0, max = 10)
	private String openDay;
	
	//认购起点 
	@Column(name = "subscription_starting_oint", nullable = true, length = 20)
	@Length(min = 0, max = 20)
	private String subscriptionStartingPoint;
		
	//追加起点
	@Column(name = "additional_starting_oint", nullable = true, length = 20)
	@Length(min = 0, max = 20)
	private String additionalStartingPoint;
	
	//认购费率
	@Column(name = "subscription_rate", nullable = true, length = 20)
	@Length(min = 0, max = 20)
	private String subscriptionRate;
	
	//赎回费率
	@Column(name = "repurchase_rate", nullable = true, length = 20)
	@Length(min = 0, max = 20)
	private String repurchaseRate;
	
	//期货投资策略
	@Column(name = "investment_strategy", nullable = true, length = 100)
	@Length(min = 0, max = 100)
	private String investmentStrategy;
	
	//证券投资策略
	@Column(name = "stock_investment_strategy", nullable = true, length = 100)
	@Length(min = 0, max = 100)
	private String stockInvestmentStrategy;
	
	//其他投资策略
	@Column(name = "other_investment_strategy", nullable = true, length = 100)
	@Length(min = 0, max = 100)
	private String otherInvestmentStrategy;
	
	//预警线
	@Column(name = "warning_line", nullable = true, length = 20)
	@Length(min = 0, max = 20)
	private String warningLine;
	
	//止损线
	@Column(name = "stop_loss_line", nullable = true, length = 20)
	@Length(min = 0, max = 20)
	private String stopLossLine;
	
	//业绩报酬
	@Column(name = "performance_reward", nullable = true, length = 20)
	@Length(min = 0, max = 20)
	private String performanceReward;
	
	//管理费率
	@Column(name = "administration_rate", nullable = true, length = 20)
	@Length(min = 0, max = 20)
	private String administrationRate;
	
	//托管费率
	@Column(name = "trust_rate", nullable = true, length = 20)
	@Length(min = 0, max = 20)
	private String trustRate;
	
	//投顾费率
	@Column(name = "investment_adviser_rate", nullable = true, length = 20)
	@Length(min = 0, max = 20)
	private String investmentAdviserRate;
		
	//外包费率
	@Column(name = "outsource_rate", nullable = true, length = 20)
	@Length(min = 0, max = 20)
	private String outsourceRate;
	
	//其他
	@Column(name = "other", nullable = true, length = 20)
	@Length(min = 0, max = 20)
	private String other;
	
	//基金管理人
	@Column(name = "fund_manager", nullable = true, length = 100)
	@Length(min = 0, max = 100)
	private String fundManager;
	
	//基金托管人
	@Column(name = "custodian", nullable = true, length = 100)
	@Length(min = 0, max = 100)
	private String custodian;
	
	//外包服务商
	@Column(name = "outsource_service_provider", nullable = true, length = 100)
	@Length(min = 0, max = 100)
	private String outsourceServiceProvider;
	
	//投资顾问
	@Column(name = "investment_adviser", nullable = true, length = 100)
	@Length(min = 0, max = 100)
	private String investmentAdviser;

	//证券经纪商
	@Column(name = "securities_broker", nullable = true, length = 100)
	@Length(min = 0, max = 100)
	private String securitiesBroker;
	
	//期货经纪商
	@Column(name = "futures_broker", nullable = true, length = 100)
	@Length(min = 0, max = 100)
	private String futuresBroker;
	
	// 操作员
	@Column(name = "operator_id", length = 20)
	@Length(min = 0, max = 20)
	private String operatorID;

	// 操作日期
	@Column(name = "operate_date", length = 8)
	@Length(min = 0, max = 8)
	private String operateDate;

	// 操作时间
	@Column(name = "operate_time", length = 8)
	@Length(min = 0, max = 8)
	private String operateTime;
	
	//状态
	@Column(name = "status", length = 20)
	@Length(min = 0, max = 20)
	private String status;
	
	// 投资策略
	@Column(name = "strategy_list", length = 100)
	@Length(min = 0, max = 100)
	private String strategyList;
	
	@Transient
	private String investmentreviewedStatus;//投顾注册产品审核状态 
	
	@Transient
    private String sonName;
	@Transient
    private String startDate;
    @Transient
    private String endDate;
    @Transient
    private Long relationshipId;
    // 母基金占子基金比例
    @Transient
    private BigDecimal productRatio;
	
	@Column(name = "net_value", precision = 20, scale = 4)
	@Digits(integer = 16, fraction = 4)
	private BigDecimal netValue;//最新净值
	
	@Transient
	private BigDecimal netNewValue;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getPriorFundProductID() {
		return priorFundProductID;
	}

	public void setPriorFundProductID(String priorFundProductID) {
		this.priorFundProductID = priorFundProductID;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	public String getFundOrg() {
		return fundOrg;
	}

	public void setFundOrg(String fundOrg) {
		this.fundOrg = fundOrg;
	}

	public String getFundEstablished() {
		return fundEstablished;
	}

	public void setFundEstablished(String fundEstablished) {
		this.fundEstablished = fundEstablished;
	}

	public String getFundManagersName() {
		return fundManagersName;
	}

	public void setFundManagersName(String fundManagersName) {
		this.fundManagersName = fundManagersName;
	}

	public String getFundManagerType() {
		return fundManagerType;
	}

	public void setFundManagerType(String fundManagerType) {
		this.fundManagerType = fundManagerType;
	}

	public String getFundCustodianName() {
		return fundCustodianName;
	}

	public void setFundCustodianName(String fundCustodianName) {
		this.fundCustodianName = fundCustodianName;
	}
	
	public String getFundInvestmentManager() {
		return fundInvestmentManager;
	}

	public void setFundInvestmentManager(String fundInvestmentManager) {
		this.fundInvestmentManager = fundInvestmentManager;
	}

	public String getOperatorID() {
		return operatorID;
	}

	public void setOperatorID(String operatorID) {
		this.operatorID = operatorID;
	}

	public String getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(String operateDate) {
		this.operateDate = operateDate;
	}

	public String getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getFundProductShortName() {
		return fundProductShortName;
	}

	public void setFundProductShortName(String fundProductShortName) {
		this.fundProductShortName = fundProductShortName;
	}

	public String getIsLevel() {
		return isLevel;
	}

	public void setIsLevel(String isLevel) {
		this.isLevel = isLevel;
	}

	public String getLeverage() {
		return leverage;
	}

	public void setLeverage(String leverage) {
		this.leverage = leverage;
	}

	public String getBeginningCapital() {
		return beginningCapital;
	}

	public void setBeginningCapital(String beginningCapital) {
		this.beginningCapital = beginningCapital;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getOpenDay() {
		return openDay;
	}

	public void setOpenDay(String openDay) {
		this.openDay = openDay;
	}

	public String getSubscriptionStartingPoint() {
		return subscriptionStartingPoint;
	}

	public void setSubscriptionStartingPoint(String subscriptionStartingPoint) {
		this.subscriptionStartingPoint = subscriptionStartingPoint;
	}

	public String getAdditionalStartingPoint() {
		return additionalStartingPoint;
	}

	public void setAdditionalStartingPoint(String additionalStartingPoint) {
		this.additionalStartingPoint = additionalStartingPoint;
	}

	public String getSubscriptionRate() {
		return subscriptionRate;
	}

	public void setSubscriptionRate(String subscriptionRate) {
		this.subscriptionRate = subscriptionRate;
	}

	public String getRepurchaseRate() {
		return repurchaseRate;
	}

	public void setRepurchaseRate(String repurchaseRate) {
		this.repurchaseRate = repurchaseRate;
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

	public String getPerformanceReward() {
		return performanceReward;
	}

	public void setPerformanceReward(String performanceReward) {
		this.performanceReward = performanceReward;
	}

	public String getAdministrationRate() {
		return administrationRate;
	}

	public void setAdministrationRate(String administrationRate) {
		this.administrationRate = administrationRate;
	}

	public String getTrustRate() {
		return trustRate;
	}

	public void setTrustRate(String trustRate) {
		this.trustRate = trustRate;
	}


	public String getOutsourceRate() {
		return outsourceRate;
	}

	public void setOutsourceRate(String outsourceRate) {
		this.outsourceRate = outsourceRate;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getFundManager() {
		return fundManager;
	}

	public void setFundManager(String fundManager) {
		this.fundManager = fundManager;
	}

	public String getCustodian() {
		return custodian;
	}

	public void setCustodian(String custodian) {
		this.custodian = custodian;
	}

	public String getOutsourceServiceProvider() {
		return outsourceServiceProvider;
	}

	public void setOutsourceServiceProvider(String outsourceServiceProvider) {
		this.outsourceServiceProvider = outsourceServiceProvider;
	}

	public String getInvestmentAdviser() {
		return investmentAdviser;
	}

	public void setInvestmentAdviser(String investmentAdviser) {
		this.investmentAdviser = investmentAdviser;
	}

	public String getSecuritiesBroker() {
		return securitiesBroker;
	}

	public void setSecuritiesBroker(String securitiesBroker) {
		this.securitiesBroker = securitiesBroker;
	}

	public String getFuturesBroker() {
		return futuresBroker;
	}

	public void setFuturesBroker(String futuresBroker) {
		this.futuresBroker = futuresBroker;
	}
	public String getProductState() {
		return productState;
	}

	public void setProductState(String productState) {
		this.productState = productState;
	}
	public String getInvestmentAdviserRate() {
		return investmentAdviserRate;
	}

	public void setInvestmentAdviserRate(String investmentAdviserRate) {
		this.investmentAdviserRate = investmentAdviserRate;
	}

	public String getStockInvestmentStrategy() {
		return stockInvestmentStrategy;
	}

	public void setStockInvestmentStrategy(String stockInvestmentStrategy) {
		this.stockInvestmentStrategy = stockInvestmentStrategy;
	}

	public String getOtherInvestmentStrategy() {
		return otherInvestmentStrategy;
	}

	public void setOtherInvestmentStrategy(String otherInvestmentStrategy) {
		this.otherInvestmentStrategy = otherInvestmentStrategy;
	}

	public String getInvestmentStrategy() {
		return investmentStrategy;
	}

	public void setInvestmentStrategy(String investmentStrategy) {
		this.investmentStrategy = investmentStrategy;
	}

	public String getInvestmentreviewedStatus() {
		return investmentreviewedStatus;
	}

	public void setInvestmentreviewedStatus(String investmentreviewedStatus) {
		this.investmentreviewedStatus = investmentreviewedStatus;
	}

	public BigDecimal getNetValue() {
		return netValue;
	}

	public void setNetValue(BigDecimal netValue) {
		this.netValue = netValue;
	}

	public BigDecimal getNetNewValue() {
		return netNewValue;
	}

	public void setNetNewValue(BigDecimal netNewValue) {
		this.netNewValue = netNewValue;
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

	public String getSonName() {
		return sonName;
	}

	public void setSonName(String sonName) {
		this.sonName = sonName;
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

	public Long getRelationshipId() {
		return relationshipId;
	}

	public void setRelationshipId(Long relationshipId) {
		this.relationshipId = relationshipId;
	}

	public BigDecimal getProductRatio() {
		return productRatio;
	}

	public void setProductRatio(BigDecimal productRatio) {
		this.productRatio = productRatio;
	}
	
	
}
