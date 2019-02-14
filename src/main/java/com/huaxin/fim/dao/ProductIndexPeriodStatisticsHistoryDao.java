package com.huaxin.fim.dao;

import com.dev.framework.core.annotation.Changeable;
import com.huaxin.fim.entity.entity.ProductIndexPeriodStatisticsHistory;
import me.chanjar.weixin.common.util.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 保存产品指数指标统计数据历史表（信息比率，特雷诺比率，年化跟踪误差指标）
 * 
 * @author liumd
 *
 */
@Named("productIndexPeriodStatisticsHistoryDao")
public class ProductIndexPeriodStatisticsHistoryDao {

	private static Log logger = LogFactory.getLog(ProductIndexPeriodStatisticsHistoryDao.class);

	@Inject
	private EntityManager em;

	/*
	 * 批量存储产品品种表
	 */
	@Changeable
	public Map<String, Object> saveProductIndexPeriodStatisticsHistory(List<ProductIndexPeriodStatisticsHistory> list) {
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
				for (ProductIndexPeriodStatisticsHistory period_item : list) {
					if(!StringUtils.isEmpty(period_item.getProductID()) && !StringUtils.isEmpty(period_item.getDate())
							&& !StringUtils.isEmpty(period_item.getKPI())&& !StringUtils.isEmpty(period_item.getPeriodType())
									&& !StringUtils.isEmpty(period_item.getIndexID())){
						em.persist(period_item);
					}
					if (++count % 1000 == 0) {
						em.flush();
						em.clear();
					}
					em.flush();
					em.clear();
				}
			} catch (Exception e) {
				logger.info("保存产品年化指标周期统计表异常："+e.getMessage());
				resultMap.put("errorCode","1");
				return resultMap;
			}
			return resultMap;
		}
	}
}
