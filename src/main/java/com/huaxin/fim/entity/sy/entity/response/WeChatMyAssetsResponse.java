package com.huaxin.fim.entity.sy.entity.response;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 微信公众号我的资产：微信用户绑定客户资产信息
 * <br>创建日期：2016年6月20日 下午1:44:14
 * <br><b>Copyright 2016 上海量投网络科技有限公司 All Rights Reserved</b>
 *
 * @author 周胜兵
 * @since 1.0
 * @version 1.0
 */
public class WeChatMyAssetsResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 客户代码
	 */
	private String clientID;
	
	/**
	 * 基金代码
	 */
	private String fundProductID; 
	
	/**
	 * 基金名称
	 */
	private String fundProductName;
	
	/**
	 * 客户所拥有单个基金的总资产
	 */
	private BigDecimal totalAssets;
	
	/**
	 * 可用份额
	 */
	private BigDecimal shareRemain;
	
	/**
	 * 当前净值
	 */
	private BigDecimal iopv;
	
	/**
	 * 估值日期
	 */
	private String evaluateDate;
	
	/**
	 * 累积收益
	 */
	private BigDecimal accumulationNetworth;
	
	/**
	 * 成立时间
	 */
	private String fundEstablished;
	
	/**
	 * 投资经理
	 */
	private String fundInvestmentManager;

	
	
	public WeChatMyAssetsResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
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

	public BigDecimal getTotalAssets() {
		return totalAssets;
	}

	public void setTotalAssets(BigDecimal totalAssets) {
		this.totalAssets = totalAssets;
	}

	public BigDecimal getShareRemain() {
		return shareRemain;
	}

	public void setShareRemain(BigDecimal shareRemain) {
		this.shareRemain = shareRemain;
	}

	public BigDecimal getIopv() {
		return iopv;
	}

	public void setIopv(BigDecimal iopv) {
		this.iopv = iopv;
	}

	public String getEvaluateDate() {
		return evaluateDate;
	}

	public void setEvaluateDate(String evaluateDate) {
		this.evaluateDate = evaluateDate;
	}

	public BigDecimal getAccumulationNetworth() {
		return accumulationNetworth;
	}

	public void setAccumulationNetworth(BigDecimal accumulationNetworth) {
		this.accumulationNetworth = accumulationNetworth;
	}

	public String getFundEstablished() {
		return fundEstablished;
	}

	public void setFundEstablished(String fundEstablished) {
		this.fundEstablished = fundEstablished;
	}

	public String getFundInvestmentManager() {
		return fundInvestmentManager;
	}

	public void setFundInvestmentManager(String fundInvestmentManager) {
		this.fundInvestmentManager = fundInvestmentManager;
	}
	
}
