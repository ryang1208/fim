package com.huaxin.fim.entity.https;

import java.util.List;

/**
 * Https请求应答
 * 
 * @author lihuijun
 * @since 2017年2月23日
 * @version 1.0
 */
public class HttpResponse {

	/**
	 * 返回结果代码
	 */
	private String code;

	/**
	 * 返回结果消息
	 */
	private String message;

	/**
	 * 应答明细
	 */
	private List<ResponseDetail> returnObject;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<ResponseDetail> getReturnObject() {
		return returnObject;
	}

	public void setReturnObject(List<ResponseDetail> returnObject) {
		this.returnObject = returnObject;
	}

	@Override
	public String toString() {
		return "HttpResponse [code=" + code + ", msssage=" + message + ", returnObject=" + returnObject + "]";
	}
	
	
	

}
