package com.huaxin.fim.dao;

import com.dev.framework.core.annotation.Changeable;
import com.huaxin.fim.entity.entity.PendingJob;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.List;

@Named("pendingJobDao")
public class PendingJobDao {

	private static Log logger = LogFactory.getLog(SettlementBillImportDao.class);

	@Inject
	private EntityManager em;

	@Changeable
	public boolean savePendingJobList(List<PendingJob> list) {
		
			logger.info("存储PendingJob开始");
			boolean success = true;
			if (list == null || list.size() == 0) {
				return success;
			}
			try {
				int count = 0;
				for (PendingJob pendingJob : list) {
					em.persist(pendingJob);
					if (++count % 1000 == 0) {
						em.flush();
						em.clear();
					}
				}
				em.flush();
				em.clear();
			} catch (Exception e) {
				success = false;
				e.printStackTrace();
				throw e;
			}
			logger.info("存储PendingJob结束");
			return success;
	}
}
