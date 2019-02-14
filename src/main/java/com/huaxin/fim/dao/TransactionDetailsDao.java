package com.huaxin.fim.dao;

import com.dev.framework.core.annotation.Changeable;
import com.huaxin.fim.entity.entity.TransactionDetails;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.List;

@Named("transactionDetailsDao")
public class TransactionDetailsDao {

	@Inject
	private EntityManager em;
//
//	@Inject
//	private FrameworkCacheService frameworkCacheService;
	/*
	 * 批量存储"持仓数据"
	 */
	@Changeable
	public boolean saveTransactionDetailsList(List<TransactionDetails> list, String parseDir, String fileName) {
		synchronized(list){
			
			boolean saveFlag = true;

			if (list == null || list.size() == 0) {
				return saveFlag;
			}
			try {
				int count = 0;
				for (TransactionDetails transactionDetails : list) {
					em.persist(transactionDetails);
					if (++count % 1000 == 0) {
						em.flush();
						em.clear();
					}
				}
				em.flush();
				em.clear();
			} catch (Exception e) {
				saveFlag = false;
				System.out.println(e.getMessage());
				//frameworkCacheService.put(parseDir, "-1@" + fileName + "@" + "数据错误！");
				e.printStackTrace();
			}

			return saveFlag;
			
		}
		
	}
}
