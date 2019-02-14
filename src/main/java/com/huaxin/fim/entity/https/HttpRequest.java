package com.huaxin.fim.entity.https;

/**
 * Https请求请求
 * 
 * @author lihuijun
 * @since 2017年2月23日
 * @version 1.0
 */
public class HttpRequest {

	/**
	 * 管理人编码,多个使用英文逗号分隔
	 */
	private String managerCode;

	/**
	 * 接口开通的appId
	 */
	private String appId;

	/**
	 * 估值日期，格式： yyyy-MM-dd
	 */
	private String ywrq;

	/**
	 * 是否已确认（核对），0-未核对 1-已核对 空字符串-已核对未核对均查询
	 */
	private String sfqr;

	/**
	 * 签名
	 */
	private String sign;

	public String getManagerCode() {
		return managerCode;
	}

	public void setManagerCode(String managerCode) {
		this.managerCode = managerCode;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getYwrq() {
		return ywrq;
	}

	public void setYwrq(String ywrq) {
		this.ywrq = ywrq;
	}

	public String getSfqr() {
		return sfqr;
	}

	public void setSfqr(String sfqr) {
		this.sfqr = sfqr;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
