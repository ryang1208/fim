package com.huaxin.fim.dao;

import com.dev.framework.core.annotation.Changeable;
import com.huaxin.fim.entity.entity.ProductFactorPeriodKPIStatistics;
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
 * 保存产品个股因子周期表
 * 
 */
@Named("productFactorPeriodKPIStatisticsDao")
public class ProductFactorPeriodKPIStatisticsDao {

	private static Log logger = LogFactory.getLog(ProductFactorPeriodKPIStatisticsDao.class);

	@Inject
	private EntityManager em;
	
 	@Changeable
	public Map<String, Object> saveFactorPeriodStatistics(List<ProductFactorPeriodKPIStatistics> list) throws Exception {
		synchronized(this){
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("errorCode", "0");
			resultMap.put("errorMessage", "");
			if (list == null || list.size() == 0) {
				return resultMap;
			}
	
			try {
				// 批量存储
				int count = 0;
				for (ProductFactorPeriodKPIStatistics period_item : list) {
					if(!StringUtils.isEmpty(period_item.getProductID()) && !StringUtils.isEmpty(period_item.getDate())
							&& !StringUtils.isEmpty(period_item.getFactorID()) && !StringUtils.isEmpty(period_item.getKPI()) ){
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
				logger.info(e.getMessage());
				resultMap.put("errorCode", "1");
				resultMap.put("errorMessage", e.getMessage());
				return resultMap;
			}
			return resultMap;
		}
	}
}
