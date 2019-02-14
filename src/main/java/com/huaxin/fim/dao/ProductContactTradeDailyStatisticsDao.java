package com.huaxin.fim.dao;

import com.dev.framework.core.annotation.Changeable;
import com.huaxin.fim.entity.entity.ProductContactTradeDailyStatistics;
import me.chanjar.weixin.common.util.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named("ProductContactTradeDailyStatisticsDao")
public class ProductContactTradeDailyStatisticsDao {
	
	private static Log logger = LogFactory.getLog(ProductContactTradeDailyStatisticsDao.class);
	@Inject
	private EntityManager em;
	
	/*
	 * 批量存储"产品合约"
	 */
	@Changeable
	public Map<String,Object> saveProductContactTradeDailyStatisticsList(List<ProductContactTradeDailyStatistics> list, int paramCount) throws Exception {
		synchronized(this){
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("errorCode", "0");
			resultMap.put("errorMessage", "");
			if (list == null || list.size() == 0) {
				return resultMap;
			}
			if(paramCount==2){
				try {
					// 批量存储
					int count = 0;
					for (ProductContactTradeDailyStatistics contact_item : list) {
						if(!StringUtils.isEmpty(contact_item.getProductID()) && !StringUtils.isEmpty(contact_item.getDate())&& !StringUtils.isEmpty(contact_item.getContact())){
							em.persist(contact_item);
						}
						if (++count % 1000 == 0) {
							em.flush();
							em.clear();
						}
					}
					em.flush();
					em.clear();
				} catch (Exception e) {
					logger.info(e.getMessage());
					resultMap.put("errorCode", "1");
					resultMap.put("errorMessage", e.getMessage());
					return resultMap;
				}
			}else if(paramCount>2){
				try {
					// 批量更新
					int count = 0;
					for (ProductContactTradeDailyStatistics contact_item : list) {
						em.merge(contact_item);
						if (++count % 1000 == 0) {
							em.flush();
							em.clear();
						}
					}
					em.flush();
					em.clear();
				} catch (Exception e) {
					logger.info(e.getMessage());
					resultMap.put("errorCode", "1");
					resultMap.put("errorMessage", e.getMessage());
					return resultMap;
				}
			}
			return resultMap;
		}
	}
	
}
