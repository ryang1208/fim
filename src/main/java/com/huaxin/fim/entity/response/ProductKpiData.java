package com.huaxin.fim.entity.response;

/**
 * 产品指标日期--申万综合排名使用
 * 
 * @author liumd
 *
 */
public class ProductKpiData {

	private String productId;
	private String date;
	private String kpi;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getKpi() {
		return kpi;
	}
	public void setKpi(String kpi) {
		this.kpi = kpi;
	}
	
}
