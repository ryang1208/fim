package com.huaxin.fim.dao;

import com.dev.framework.core.annotation.Changeable;
import com.huaxin.fim.entity.entity.ProductNetValue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.List;

@Named("productNetValueImportDao")
public class ProductNetValueImportDao {
	
	private static Log logger = LogFactory.getLog(ProductNetValueImportDao.class);
	
	@Inject
	private EntityManager em;
//
//	@Inject
//	private FrameworkCacheService globalCacheService;
	
	/*
	 * 批量存储"产品净值"
	 */
	@Changeable
	public boolean saveProductNetValueList(List<ProductNetValue> list, String fileName, String parseDir) {
		synchronized(this){
			logger.info("存储产品净值开始");
			boolean success = true;
			if (list == null || list.size() == 0) {
				return success;
			}
			try {
				int count = 0;
				for (ProductNetValue productNetValue : list) {
					em.persist(productNetValue);
					if (++count % 1000 == 0) {
						em.flush();
						em.clear();
					}
				}
				em.flush();
				em.clear();
			} catch (Exception e) {
				success = false;
			//	globalCacheService.put(parseDir, "-1@"+fileName+"@"+"产品净值数据错误请检查数据！");
				e.printStackTrace();
				throw e;
			}
			logger.info("存储产品净值结束");
			return success;
		}
	}
}
