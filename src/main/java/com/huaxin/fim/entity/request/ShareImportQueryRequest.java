package com.huaxin.fim.entity.request;

import java.io.Serializable;

/**
 * 基金份额查询条件对象
 * 
 * @author liumd
 *
 */
public class ShareImportQueryRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private String productId; // 产品代码
	private String confirmDate; // 确认日期
	private String dataSource; // 数据来源

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(String confirmDate) {
		this.confirmDate = confirmDate;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

}
