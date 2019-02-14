package com.huaxin.fim.entity.request;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * B-L模型投资者观点对象定义
 * @author liumd
 *
 */
public class BLOpinionRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	private String mainProductId; // 主观产品
	private String relativelyProductId; // 相对于产品
	private String type; // 1绝对，2相对
	private BigDecimal yieldValue;
	private String mainProductName;
	private String relativelyProductName;
	
	public String getMainProductName() {
		return mainProductName;
	}
	public void setMainProductName(String mainProductName) {
		this.mainProductName = mainProductName;
	}
	public String getRelativelyProductName() {
		return relativelyProductName;
	}
	public void setRelativelyProductName(String relativelyProductName) {
		this.relativelyProductName = relativelyProductName;
	}
	public String getMainProductId() {
		return mainProductId;
	}
	public void setMainProductId(String mainProductId) {
		this.mainProductId = mainProductId;
	}
	public String getRelativelyProductId() {
		return relativelyProductId;
	}
	public void setRelativelyProductId(String relativelyProductId) {
		this.relativelyProductId = relativelyProductId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigDecimal getYieldValue() {
		return yieldValue;
	}
	public void setYieldValue(BigDecimal yieldValue) {
		this.yieldValue = yieldValue;
	}
	
}
