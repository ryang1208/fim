package com.huaxin.fim.entity.response;

import java.util.List;

/**
 * 导出pdf协方差返回结果对象
 * 
 * @author liumd
 *
 */
public class ExportPDFCovarianceResponse {

	private String productname;
	private List<SimulationCovarianceResponse> covList;
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public List<SimulationCovarianceResponse> getCovList() {
		return covList;
	}
	public void setCovList(List<SimulationCovarianceResponse> covList) {
		this.covList = covList;
	}
	
}
