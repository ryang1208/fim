/**
 * 
 */
package com.huaxin.fim.api;

import com.huaxin.fim.entity.entity.IWinJobConfig;

import java.util.List;


/**
 * 查询投赢汇Job执行配置服务
 * @author Jiabing
 *
 */
public interface IWinJobConfigService
{
	/**  
	 * @Description: 根据Job组名和Job名称查询Job执行参数
	 * @param:			 jobGroup - Job 组名
	 *                			 jobName - Job 名称   
	 * @return:  			Job Entity 对象       IWinJobConfig
	 */
	public List<IWinJobConfig> getJobByJobGroupAndJobName(String jobGroup, String jobName);

}
