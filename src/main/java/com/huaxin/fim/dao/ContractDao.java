package com.huaxin.fim.dao;

import com.dev.framework.core.annotation.Changeable;
import com.huaxin.fim.entity.entity.Contract;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 保存合约
 * 
 * @author liumd
 *
 */
@Named("contractDao")
public class ContractDao {

	private static Log logger = LogFactory.getLog(ContractDao.class);

	@Inject
	private EntityManager em;

	/*
	 * 批量存储产品品种表
	 */
	@Changeable
	public Map<String, Object> saveContract(String startDate,String endDate,List<Contract> list) {
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
				for (Contract period_item : list) {
					em.persist(period_item);
					if (++count % 1000 == 0) {
						em.flush();
						em.clear();
					}
					em.flush();
					em.clear();
				}
			} catch (Exception e) {
				logger.info("保存合约异常："+e.getMessage());
				resultMap.put("errorCode","1");
				return resultMap;
			}
			return resultMap;
		}
	}


	/*
	 * 批量存储产品品种表
	 */
	@Changeable
	public Map<String, Object> saveContract(List<Contract> list) {
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
				for (Contract periodItem : list) {
					em.persist(periodItem);
					if (++count % 1000 == 0) {
						em.flush();
						em.clear();
					}
					em.flush();
					em.clear();
				}
			} catch (Exception e) {
				logger.info("保存合约异常："+e.getMessage());
				resultMap.put("errorCode","1");
				return resultMap;
			}
			return resultMap;
		}
	}
}
