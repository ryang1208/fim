package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.huaxin.fim.entity.entity.IWinJobConfig;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 投赢汇Job配置存储类
 * 
 * @author Jiabing
 *
 */
@Repository("iWinJobConfigRepository")
@EntityClass(entityClass = IWinJobConfig.class)
public interface IWinJobConfigRepository extends CrudRepository<IWinJobConfig, Long>
{
	
	/**  
	 * @Description: 根据Job组名和Job名称查询Job执行参数
	 * @param:			 jobGroup - Job 组名
	 *                			 jobName - Job 名称   
	 * @return:  			
	 * IWinJobConfig      
	 */
	@Query(value = "select j from IWinJobConfig j "
			+ "where j.jobGroup = :jobGroup and j.jobName = :jobName")
	public List<IWinJobConfig> getJobByJobGroupAndJobName(@Param("jobGroup") String jobGroup, @Param("jobName") String jobName);

	/**
	 * 根据唯一的scheduleName去找对应实体
	 * @param scheduleName
	 * @return
	 */
	@Query(value = "select j from IWinJobConfig j "
			+ "where j.scheduleName = :scheduleName")
	public IWinJobConfig findByScheduleName(@Param("scheduleName") String scheduleName);
}
