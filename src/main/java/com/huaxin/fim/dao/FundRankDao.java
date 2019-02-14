package com.huaxin.fim.dao;

import com.dev.framework.core.annotation.Changeable;
import com.huaxin.fim.entity.entity.FundRank;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 保存产品指标评分表
 * 
 * @author liumd
 *
 */
@Named("fundRankDao")
public class FundRankDao {

	private static Log logger = LogFactory.getLog(FundRankDao.class);

	@Inject
	private EntityManager em;

	/*
	 * 批量存储产品品种表
	 */
	@Changeable
	public Map<String, Object> saveFundRank(String startDate,String endDate,List<FundRank> list) {
		synchronized(this){
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("errorCode","0");
			resultMap.put("errorMessage","");
			if (list == null || list.size() == 0) {
				return resultMap;
			}
	
			try {
				// 批量存储
				int count = 0;
				for (FundRank period_item : list) {
					em.persist(period_item);
					if (++count % 1000 == 0) {
						em.flush();
						em.clear();
					}
					em.flush();
					em.clear();
				}
			} catch (Exception e) {
				logger.info("保存综合排名异常："+e.getMessage());
				resultMap.put("errorCode","1");
				resultMap.put("errorMessage","保存综合排名异常：开始日期："+startDate+",结束日期："+endDate+",异常信息："+e.getMessage());
				return resultMap;
			}
			return resultMap;
		}
	}
}
