package com.huaxin.fim.dao;

import com.dev.framework.core.annotation.Changeable;
import com.huaxin.fim.entity.entity.ProductNetValue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named("productNetValueDao")
public class ProductNetValueDao {
	
	private static Log logger = LogFactory.getLog(ProductNetValueDao.class);
	@Inject
	private EntityManager em;
	
	/*
	 * 批量存储"产品净值"
	 */
	@Changeable
	public Map<String,Object> saveProductNetValue(List<ProductNetValue> list, String startDate, String endDate, String productID) {
		synchronized(this){
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("result", "0");
			if (list == null || list.size() == 0) {
				return resultMap;
			}
			try {
				// 批量存储
				int count = 0;
				for (ProductNetValue period_item : list) {
					if(period_item.getNetAssetValue() != null && period_item.getNetAssetValue().compareTo(BigDecimal.ZERO)>0){
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
				resultMap.put("result", "1");
				resultMap.put("msg", "保存单位净值异常：统计起日:"+startDate+",统计迄日:"+endDate+",产品编码:"+productID+","+e.getMessage());
			}
			return resultMap;
		}
	}
	
	/*
	 * 批量g更新"产品净值"
	 */
	@Changeable
	public Map<String,Object> updateProductNetValueList(List<ProductNetValue> list,String startDate,String endDate,String productID) {
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
				for (ProductNetValue period_item : list) {
					em.merge(period_item);
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
				resultMap.put("errorMessage", "更新累计净值异常：产品代码："+productID+",开始日期:"+startDate+",结束日期:"+endDate+",异常信息："+e.getMessage());
			}
			return resultMap;
		}
	}
}
