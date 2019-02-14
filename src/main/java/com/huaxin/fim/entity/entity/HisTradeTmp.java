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
import java.math.BigDecimal;

/**
 * 历史成交临时实体
 * @author xieky
 */
@Entity
@Table(name = "t_his_trade_tmp")
public class HisTradeTmp implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	//成交时间
	@Column(name = "trade_time", nullable = false, length = 8)
	@NotNull
	@NotBlank
	@Length(min = 8, max = 8)
	private String tradeTime;

	//结算日期
	@Column(name = "settle_date", nullable = false, length = 8)
	@NotNull
	@NotBlank
	@Length(min = 8, max = 8)
	private String settleDate;
	
	//成交日期
	@Column(name = "trade_date", nullable = false, length = 8)
	@NotNull
	@NotBlank
	@Length(min = 8, max = 8)
	private String tradeDate;
	
	//机构代码
	@Column(name = "broker_id", nullable = false, length = 10)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 10)
	private String brokerid;
	
	//成交号
	@Column(name = "trade_id", nullable = false, length = 10)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 10)
	private String tradeID;
	
	//资金帐号
	@Column(name = "account_id", nullable = false, length = 10)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 10)
	private String accountID;
	
	// 投资者代码
	@Column(name = "investor_id", nullable = false, length = 10)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 10)
	private String investorID;
	
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
	
	// 开平标志
	@Column(name = "offset_flag", length = 1)
	private String offsetFlag;
	
	// 投机套保标志
	@Column(name = "hedge_flag", length = 1)
	private String hedgeFlag;
	
	// 成交量
	@Column(name = "trade_volume", nullable = false, precision = 19, scale = 6)
	@NotNull
	@Digits(integer = 13, fraction = 6)
	private BigDecimal tradeVolume;
	
	// 成交价格
	@Column(name = "trade_price", nullable = false, precision = 22, scale = 8)
	@NotNull
	@Digits(integer = 14, fraction = 8)
	private BigDecimal tradePrice;
	
	// 报单编号
	@Column(name = "orderSys_id", length = 30)
	@Length(min = 0, max = 30)
	private String orderSysID;
	
	// 下单席位号
	@Column(name = "seat_id", nullable = false, length = 20)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 20)
	private String seatID;
	
	//系统号
	@Column(name = "seat_system", nullable = false, length = 20)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 20)
	private String seatSystem;
	
	// 手续费
	@Column(name = "usedfee", precision = 19, scale = 3)
	@Digits(integer = 16, fraction = 3)
	private BigDecimal usedFee;
	
	//-------
	// 投资顾问
	@Column(name = "invest_adviser", nullable = false, length = 20)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 20)
	private String investAdviser;
	
	@Column(name = "invest_adviser_name", nullable = false, length = 20)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 20)
	private String investAdviserName;
	
	// 投资经理
	@Column(name = "invest_manager", nullable = false, length = 20)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 20)
	private String investManager;
	
	@Column(name = "invest_manager_name", nullable = false, length = 20)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 20)
	private String investManagerName;
	
	// 交易员
	@Column(name = "trade_user", nullable = false, length = 20)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 20)
	private String tradeUser;
	
	@Column(name = "trade_user_name", nullable = false, length = 20)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 20)
	private String tradeUserName;

	// 机构名称
	@Column(name = "inst_client_name", nullable = false, length = 10)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 10)
	private String instClientName;
	
	// 账号名称
	@Column(name = "search_type", nullable = false, length = 10)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 10)
	private String searchType;
	
	// 账号名称
	@Column(name = "begin_date", nullable = false, length = 8)
	@NotNull
	@NotBlank
	@Length(min = 8, max = 8)
	private String beginDate;
	
	// 账号名称
	@Column(name = "end_date", nullable = false, length = 8)
	@NotNull
	@NotBlank
	@Length(min = 8, max = 8)
	private String endDate;
	
	
	// 账号名称
	@Column(name = "account_name", nullable = false, length = 20)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 20)
	private String accountName;
	
	//资金账号
	@Column(name = "inneraccount_id", nullable = false, length = 10)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 10)
	private String inneraccountID;
	
	//资金账号名称
	@Column(name = "inneraccount_name", nullable = false, length = 20)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 20)
	private String inneraccountName;
	
	// 交易员IP地址
	@Column(name = "ip_address", nullable = false, length = 20)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 20)
	private String ipAddress;
	
	// 交易员MAC地址
	@Column(name = "mac_address", nullable = false, length = 20)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 30)
	private String macAddress;
	
	// 投顾IP地址
	@Column(name = "adv_ip_addr", nullable = false, length = 20)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 20)
	private String advIpAddr;
	
	// 投顾MAC地址
	@Column(name = "adv_mac_addr", nullable = false, length = 20)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 20)
	private String advMacAddr;
	
	// 投资经理IP地址
	@Column(name = "mng_ip_addr", nullable = false, length = 20)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 20)
	private String mngIpAddr;
	
	// 投资经理MAC地址
	@Column(name = "mng_mac_addr", nullable = false, length = 20)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 30)
	private String mngMacAddr;
	
	public String getInneraccountID() {
		return inneraccountID;
	}

	public void setInneraccountID(String inneraccountID) {
		this.inneraccountID = inneraccountID;
	}

	public String getInneraccountName() {
		return inneraccountName;
	}

	public void setInneraccountName(String inneraccountName) {
		this.inneraccountName = inneraccountName;
	}
	

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public HisTradeTmp(){
		
	}

	// 原始历史成交数据构成
	public HisTradeTmp(String settleDate,String tradeDate,String tradeTime, String tradeID, String accountID, String investorID, String exchID,
			String instrumentID, String direction, String offsetFlag, String hedgeFlag, BigDecimal tradeVolume,
			BigDecimal tradePrice, String orderSysID, String seatID, String seatSystem, BigDecimal usedFee,String brokerid,
			String investAdviser,String investManager, String tradeUser) {
		this.settleDate = settleDate;
		this.tradeDate =tradeDate;
		this.tradeTime = tradeTime;
		this.tradeID = tradeID;
		this.accountID = accountID;
		this.investorID = investorID;
		this.exchID = exchID;
		this.instrumentID = instrumentID;
		this.direction = direction;
		this.offsetFlag = offsetFlag;
		this.hedgeFlag = hedgeFlag;
		this.tradeVolume = tradeVolume;
		this.tradePrice = tradePrice;
		this.orderSysID = orderSysID;
		this.seatID = seatID;
		this.seatSystem = seatSystem;
		this.usedFee = usedFee;
		this.brokerid =brokerid;
		this.investAdviser = investAdviser;
		this.investManager = investManager;
		this.tradeUser = tradeUser;
	}
	
	// 工作流相关历史成交数据构成
	public HisTradeTmp(String tradeTime, String settleDate, String tradeDate, String brokerid, String tradeID,
			String accountID, String investorID, String exchID, String instrumentID, String direction,
			String offsetFlag, String hedgeFlag, BigDecimal tradeVolume, BigDecimal tradePrice, String orderSysID,
			String seatID, String seatSystem, BigDecimal usedFee, String investAdviser, String investManager,
			String tradeUser, String instClientName, String accountName,String inneraccountID,String inneraccountName) {
		this.tradeTime = tradeTime;
		this.settleDate = settleDate;
		this.tradeDate = tradeDate;
		this.brokerid = brokerid;
		this.tradeID = tradeID;
		this.accountID = accountID;
		this.investorID = investorID;
		this.exchID = exchID;
		this.instrumentID = instrumentID;
		this.direction = direction;
		this.offsetFlag = offsetFlag;
		this.hedgeFlag = hedgeFlag;
		this.tradeVolume = tradeVolume;
		this.tradePrice = tradePrice;
		this.orderSysID = orderSysID;
		this.seatID = seatID;
		this.seatSystem = seatSystem;
		this.usedFee = usedFee;
		this.investAdviser = investAdviser;
		this.investManager = investManager;
		this.tradeUser = tradeUser;
		this.instClientName = instClientName;
		this.accountName = accountName;
		this.inneraccountID = inneraccountID;
		this.inneraccountName = inneraccountName;
	}
	//excel导出相关数据构成
	public HisTradeTmp(String tradeTime, String tradeID, String investorID, String accountName, String exchID,
			String instrumentID, String direction, String offsetFlag, String hedgeFlag, BigDecimal tradeVolume,
			BigDecimal tradePrice, String orderSysID, String seatID, String seatSystem, BigDecimal usedFee,
			String instClientName, String investAdviser,String investManager, String tradeUser,String tradeDate,String settleDate) {
		this.tradeTime = tradeTime;
		this.tradeID = tradeID;
		this.accountName = accountName;
		this.investorID = investorID;
		this.exchID = exchID;
		this.instrumentID = instrumentID;
		this.direction = direction;
		this.offsetFlag = offsetFlag;
		this.hedgeFlag = hedgeFlag;
		this.tradeVolume = tradeVolume;
		this.tradePrice = tradePrice;
		this.orderSysID = orderSysID;
		this.seatID = seatID;
		this.seatSystem = seatSystem;
		this.usedFee = usedFee;
		this.instClientName =instClientName;
		this.investAdviser = investAdviser;
		this.investManager = investManager;
		this.tradeUser = tradeUser;
		this.settleDate =settleDate;
		this.tradeDate=tradeDate;
	}

	public String getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(String tradeTime) {
		this.tradeTime = tradeTime;
	}

	public String getTradeID() {
		return tradeID;
	}

	public void setTradeID(String tradeID) {
		this.tradeID = tradeID;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public String getInvestorID() {
		return investorID;
	}

	public void setInvestorID(String investorID) {
		this.investorID = investorID;
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

	public String getOffsetFlag() {
		return offsetFlag;
	}

	public void setOffsetFlag(String offsetFlag) {
		this.offsetFlag = offsetFlag;
	}

	public String getHedgeFlag() {
		return hedgeFlag;
	}

	public void setHedgeFlag(String hedgeFlag) {
		this.hedgeFlag = hedgeFlag;
	}

	public BigDecimal getTradeVolume() {
		return tradeVolume;
	}

	public void setTradeVolume(BigDecimal tradeVolume) {
		this.tradeVolume = tradeVolume;
	}

	public BigDecimal getTradePrice() {
		return tradePrice;
	}

	public void setTradePrice(BigDecimal tradePrice) {
		this.tradePrice = tradePrice;
	}

	public String getOrderSysID() {
		return orderSysID;
	}

	public void setOrderSysID(String orderSysID) {
		this.orderSysID = orderSysID;
	}

	public String getSeatID() {
		return seatID;
	}

	public void setSeatID(String seatID) {
		this.seatID = seatID;
	}

	public String getSeatSystem() {
		return seatSystem;
	}

	public void setSeatSystem(String seatSystem) {
		this.seatSystem = seatSystem;
	}

	public BigDecimal getUsedFee() {
		return usedFee;
	}

	public void setUsedFee(BigDecimal usedFee) {
		this.usedFee = usedFee;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getBrokerid() {
		return brokerid;
	}

	public void setBrokerid(String brokerid) {
		this.brokerid = brokerid;
	}

	public String getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}

	public String getInvestAdviser() {
		return investAdviser;
	}

	public void setInvestAdviser(String investAdviser) {
		this.investAdviser = investAdviser;
	}

	public String getInvestManager() {
		return investManager;
	}

	public void setInvestManager(String investManager) {
		this.investManager = investManager;
	}

	public String getTradeUser() {
		return tradeUser;
	}

	public void setTradeUser(String tradeUser) {
		this.tradeUser = tradeUser;
	}

	public String getSettleDate() {
		return settleDate;
	}

	public void setSettleDate(String settleDate) {
		this.settleDate = settleDate;
	}

	public String getInstClientName() {
		return instClientName;
	}

	public void setInstClientName(String instClientName) {
		this.instClientName = instClientName;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getAdvIpAddr() {
		return advIpAddr;
	}

	public void setAdvIpAddr(String advIpAddr) {
		this.advIpAddr = advIpAddr;
	}

	public String getAdvMacAddr() {
		return advMacAddr;
	}

	public void setAdvMacAddr(String advMacAddr) {
		this.advMacAddr = advMacAddr;
	}

	public String getMngIpAddr() {
		return mngIpAddr;
	}

	public void setMngIpAddr(String mngIpAddr) {
		this.mngIpAddr = mngIpAddr;
	}

	public String getMngMacAddr() {
		return mngMacAddr;
	}

	public void setMngMacAddr(String mngMacAddr) {
		this.mngMacAddr = mngMacAddr;
	}

	public String getInvestAdviserName() {
		return investAdviserName;
	}

	public void setInvestAdviserName(String investAdviserName) {
		this.investAdviserName = investAdviserName;
	}

	public String getInvestManagerName() {
		return investManagerName;
	}

	public void setInvestManagerName(String investManagerName) {
		this.investManagerName = investManagerName;
	}

	public String getTradeUserName() {
		return tradeUserName;
	}

	public void setTradeUserName(String tradeUserName) {
		this.tradeUserName = tradeUserName;
	}
	
	
}
