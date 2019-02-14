package com.huaxin.fim.dao;

import com.dev.framework.core.annotation.Changeable;
import com.huaxin.fim.entity.entity.ReportKPIGrade;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.List;

@Named("reportKPIGradeDao")
public class ReportKpiGradeDao {

	private static Log logger = LogFactory.getLog(ReportKpiGradeDao.class);

	@Inject
	private EntityManager em;
	
	@Changeable
	public boolean save(List<ReportKPIGrade> list) {
		
			logger.info("存储ReportKPIGrade开始");
			boolean success = true;
			if (list == null || list.size() == 0) {
				return success;
			}
			try {
				int count = 0;
				for (ReportKPIGrade pendingJob : list) {
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
			logger.info("存储ReportKPIGrade结束");
			return success;
	}
}
