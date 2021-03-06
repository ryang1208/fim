package com.huaxin.fim.dao;

import com.dev.framework.core.annotation.Changeable;
import com.huaxin.fim.entity.entity.ProductPeriodKPIStatistics;
import com.huaxin.fim.mapper.AnalysisProductMapper;
import me.chanjar.weixin.common.util.StringUtils;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named("productStatisticImportDao")
public class ProductStatisticImportDao{

	@Inject
	private EntityManager em;
	@Inject
	AnalysisProductMapper analysisProductMapper;

	/*
	 * 批量存储"产品周期统计表"
	 */
	@Changeable
	public Map<String, Object> saveProductPeriodKPIStatisticsList(List<ProductPeriodKPIStatistics> list) throws Exception{
		synchronized(this){
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("errorCode", "0");
			resultMap.put("errorMessage","");
			if (list == null || list.size() == 0) {
				return resultMap;
			}
			try{
				//批量存储
				int count = 0;
				
				for(ProductPeriodKPIStatistics period_item : list){
					if(!StringUtils.isEmpty(period_item.getProductID()) && !StringUtils.isEmpty(period_item.getDate())){
						em.persist(period_item);
					}
					if (++count % 1000 == 0) {
						em.flush();
						em.clear();
					}
				}
				em.flush();
				em.clear();
			}
			catch (Exception e){
				System.out.println(e.getMessage());
				resultMap.put("errorCode", "1");
				resultMap.put("errorMessage", e.getMessage());
				return resultMap;
			}
			return resultMap;
		}
	}

}
