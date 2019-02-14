package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 历史持仓查询临时实体表
 * <br>创建日期：2017年02月28日 下午3:57:24
 * <br><b>Copyright 2015 上海量投网络科技有限公司 All Rights Reserved</b>
 * @author xieky
 * @since 1.0
 * @version 1.0
 */
@Entity
@Table(name = "t_his_position_tmp")
public class HisPositionTmp implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	
	//结算日期
	@Column(name = "settle_date", nullable = false, length = 8)
	@NotNull
	@NotBlank
	@Length(min = 8, max = 8)
	private String settleDate;
	
	//结算开始日期
	@Column(name = "settle_start_date", nullable = false, length = 8)
	@NotNull
	@NotBlank
	@Length(min = 8, max = 8)
	private String settleStartDate;
	
	//结算结束日期
	@Column(name = "settle_end_date", nullable = false, length = 8)
	@NotNull
	@NotBlank
	@Length(min = 8, max = 8)
	private String settleEndDate;
	
	//账号
	@Column(name = "account_id", nullable = false, length = 20)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 20)
	private String accountID;
	
	// 账号名称
	@Column(name = "account_name", nullable = false, length = 20)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 20)
	private String accountName;
	
	//机构代码
	@Column(name = "broker_id", nullable = false, length = 10)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 10)
	private String brokerid;
	
	//机构名称
	@Column(name = "inst_client_name", nullable = false, length = 10)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 10)
	private String instClientName;
	
	// 交易所代码
	@Column(name = "exch_id", nullable = false, length = 10)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 10)
	private String exchID;
	
	// 合约代码
	@Column(name = "instrument_id", nullable = false, length = 10)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 10)
	private String instrumentID;
	
	// 买卖方向
	@Column(name = "direction", nullable = false, length = 1)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 1)
	private String direction;
	
	// 投机套保标志
	@Column(name = "offset_flag", length = 1)
	private String hedgeFlag;
	
	// 今持仓量
	@Column(name = "position", nullable = false, precision = 19, scale = 6)
	@NotNull
	@Digits(integer = 13, fraction = 6)
	private double position;
	
	@Column(name = "position_str")
	@Length(min = 0, max = 20)
	private String positionStr;
	
	// 今持仓成本
//	private double positionCost;
	
//	 持仓均价
	@Column(name = "position_avg", nullable = false, precision = 22, scale = 8)
	@NotNull
	@Digits(integer = 14, fraction = 8)
	private double positionAvg;
	
	@Column(name = "position_avg_str")
	@Length(min = 0, max = 20)
	private String positionAvgStr;
	
	// 占用保证金
	@Column(name = "used_margin", nullable = false, precision = 22, scale = 8)
	@NotNull
	@Digits(integer = 14, fraction = 8)
	private double usedMargin;
	
	@Column(name = "used_margin_str")
	@Length(min = 0, max = 20)
	private String usedMarginStr;
	
	// 持仓盈亏
	@Column(name = "position_profit", nullable = false, precision = 22, scale = 8)
	@NotNull
	@Digits(integer = 14, fraction = 8)
	private double positionProfit;
	
	@Column(name = "position_profit_str")
	@Length(min = 0, max = 20)
	private String positionProfitStr;
		
	// 市价
	@Column(name = "last_price", nullable = false, precision = 22, scale = 8)
	@NotNull
	@Digits(integer = 14, fraction = 8)
	private double lastPrice;
	
	@Column(name = "last_price_str")
	@Length(min = 0, max = 20)
	private String lastPriceStr;
	
	//查询方式 1资金账号 2 风险账号
	@Column(name = "search_type", nullable = false, length = 10)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 10)
	private String searchType;

	public HisPositionTmp() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public HisPositionTmp(String settleDate, String accountID, String accountName, String brokerid, String exchID,
			String instrumentID, String direction, String hedgeFlag, double position, double usedMargin,
			double positionProfit, double lastPrice, double positionAvg, String instClientName) {
		super();
		this.settleDate = settleDate;
		this.accountID = accountID;
		this.accountName = accountName;
		this.brokerid = brokerid;
		this.exchID = exchID;
		this.instrumentID = instrumentID;
		this.direction = direction;
		this.hedgeFlag = hedgeFlag;
		this.position = position;
		this.usedMargin = usedMargin;
		this.positionProfit = positionProfit;
		this.lastPrice = lastPrice;
		this.positionAvg = positionAvg;
		this.instClientName = instClientName;
	}

	public HisPositionTmp(String settleDate, String accountID,
			String accountName, String brokerid, String exchID, String instrumentID, String direction, String hedgeFlag,
			String positionStr, String positionAvgStr, String usedMarginStr, String positionProfitStr,
			String lastPriceStr, String instClientName) {
		super();
		this.settleDate = settleDate;
		this.accountID = accountID;
		this.accountName = accountName;
		this.brokerid = brokerid;
		this.exchID = exchID;
		this.instrumentID = instrumentID;
		this.direction = direction;
		this.hedgeFlag = hedgeFlag;
		this.positionStr = positionStr;
		this.positionAvgStr = positionAvgStr;
		this.usedMarginStr = usedMarginStr;
		this.positionProfitStr = positionProfitStr;
		this.lastPriceStr = lastPriceStr;
		this.instClientName = instClientName;
	}


	public String getSettleDate() {
		return settleDate;
	}

	public void setSettleDate(String settleDate) {
		this.settleDate = settleDate;
	}

	public String getSettleStartDate() {
		return settleStartDate;
	}

	public void setSettleStartDate(String settleStartDate) {
		this.settleStartDate = settleStartDate;
	}

	public String getSettleEndDate() {
		return settleEndDate;
	}

	public void setSettleEndDate(String settleEndDate) {
		this.settleEndDate = settleEndDate;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getBrokerid() {
		return brokerid;
	}

	public void setBrokerid(String brokerid) {
		this.brokerid = brokerid;
	}

	public String getExchID() {
		return exchID;
	}

	public void setExchID(String exchID) {
		this.exchID = exchID;
	}

	public String getInstrumentID() {
		return instrumentID;
	}

	public void setInstrumentID(String instrumentID) {
		this.instrumentID = instrumentID;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getHedgeFlag() {
		return hedgeFlag;
	}

	public void setHedgeFlag(String hedgeFlag) {
		this.hedgeFlag = hedgeFlag;
	}

	public double getPosition() {
		return position;
	}

	public void setPosition(double position) {
		this.position = position;
	}

	public double getUsedMargin() {
		return usedMargin;
	}

	public void setUsedMargin(double usedMargin) {
		this.usedMargin = usedMargin;
	}

	public double getPositionProfit() {
		return positionProfit;
	}

	public void setPositionProfit(double positionProfit) {
		this.positionProfit = positionProfit;
	}

	public double getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(double lastPrice) {
		this.lastPrice = lastPrice;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}


	public double getPositionAvg() {
		return positionAvg;
	}


	public void setPositionAvg(double positionAvg) {
		this.positionAvg = positionAvg;
	}


	public String getPositionStr() {
		return positionStr;
	}


	public void setPositionStr(String positionStr) {
		this.positionStr = positionStr;
	}


	public String getPositionAvgStr() {
		return positionAvgStr;
	}


	public void setPositionAvgStr(String positionAvgStr) {
		this.positionAvgStr = positionAvgStr;
	}


	public String getUsedMarginStr() {
		return usedMarginStr;
	}


	public void setUsedMarginStr(String usedMarginStr) {
		this.usedMarginStr = usedMarginStr;
	}


	public String getPositionProfitStr() {
		return positionProfitStr;
	}


	public void setPositionProfitStr(String positionProfitStr) {
		this.positionProfitStr = positionProfitStr;
	}


	public String getLastPriceStr() {
		return lastPriceStr;
	}


	public void setLastPriceStr(String lastPriceStr) {
		this.lastPriceStr = lastPriceStr;
	}


	public String getInstClientName() {
		return instClientName;
	}


	public void setInstClientName(String instClientName) {
		this.instClientName = instClientName;
	}
	
	
	
}
