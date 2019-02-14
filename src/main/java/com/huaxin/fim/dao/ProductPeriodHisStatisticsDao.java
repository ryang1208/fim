package com.huaxin.fim.dao;

import com.dev.framework.core.annotation.Changeable;
import com.huaxin.fim.entity.entity.ProductPeriodHisStatistics;
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
 * 保存年化指标统计数据历史表
 * 
 * @author liumd
 *
 */
@Named("productPeriodHisStatisticsDao")
public class ProductPeriodHisStatisticsDao {

	private static Log logger = LogFactory.getLog(ProductPeriodHisStatisticsDao.class);

	@Inject
	private EntityManager em;

	@Changeable
	public Map<String, Object> saveProductPeriodHisStatistics(List<ProductPeriodHisStatistics> list) {
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
				for (ProductPeriodHisStatistics period_item : list) {
					if(!StringUtils.isEmpty(period_item.getProductID()) && !StringUtils.isEmpty(period_item.getDate())
							&& !StringUtils.isEmpty(period_item.getKPI())&& !StringUtils.isEmpty(period_item.getPeriodType())){
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
				logger.info("保存产品年化指标周期统计历史表异常："+e.getMessage());
				resultMap.put("errorCode","1");
				return resultMap;
			}
			return resultMap;
		}
	}
}
