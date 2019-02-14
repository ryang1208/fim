package com.huaxin.fim.entity.entity;

import java.io.Serializable;

/**
 * 品系类
 * @author 
 *
 */

public class Classify implements Serializable{
	
	private static final long serialVersionUID = 6362910122243803030L;
	private String productId;
	private String date;
	private String classify;
	
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
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	
	

}
