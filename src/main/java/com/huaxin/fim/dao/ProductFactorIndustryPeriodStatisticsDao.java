package com.huaxin.fim.dao;

import com.dev.framework.core.annotation.Changeable;
import com.huaxin.fim.entity.entity.ProductFactorIndustryPeriodStatistics;
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
 * 保存产品行业因子周期表
 * 
 */
@Named("productFactorIndustryPeriodStatisticsDao")
public class ProductFactorIndustryPeriodStatisticsDao {

	private static Log logger = LogFactory.getLog(ProductFactorIndustryPeriodStatisticsDao.class);

	@Inject
	private EntityManager em;

	@Changeable
	public Map<String, Object> saveFactorIndustryPeriodStatistics(List<ProductFactorIndustryPeriodStatistics> list) throws Exception {
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
				for (ProductFactorIndustryPeriodStatistics period_item : list) {
					if(!StringUtils.isEmpty(period_item.getProductId()) && !StringUtils.isEmpty(period_item.getDate())
							&& !StringUtils.isEmpty(period_item.getIndustry()) && !StringUtils.isEmpty(period_item.getKpi())
							&& !StringUtils.isEmpty(period_item.getFactorID()) ){
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
