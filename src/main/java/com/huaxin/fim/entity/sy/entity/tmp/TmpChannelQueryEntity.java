package com.huaxin.fim.entity.sy.entity.tmp;

import java.io.Serializable;

/**
 * 渠道信息查询entity
 * @author xieky
 *
 */
public class TmpChannelQueryEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	
	private String channelName;//渠道用户名
	
	private String serviceManagerID;//业务经理
	
	private String channelStatus;//渠道状态

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getServiceManagerID() {
		return serviceManagerID;
	}

	public void setServiceManagerID(String serviceManagerID) {
		this.serviceManagerID = serviceManagerID;
	}

	public String getChannelStatus() {
		return channelStatus;
	}

	public void setChannelStatus(String channelStatus) {
		this.channelStatus = channelStatus;
	}
	
}
