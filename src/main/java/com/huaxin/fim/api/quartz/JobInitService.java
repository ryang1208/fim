package com.huaxin.fim.api.quartz;

import com.dev.framework.core.annotation.Gateway;

import javax.annotation.PostConstruct;

/**
 * 业务数据分层（定时任务）触发接口
 * 
 * @author liumd
 *
 */
@Gateway
public interface JobInitService {

	@PostConstruct
	public void init() throws Exception;
}
