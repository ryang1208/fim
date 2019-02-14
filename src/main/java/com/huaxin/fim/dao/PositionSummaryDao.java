package com.huaxin.fim.dao;

import com.dev.framework.core.annotation.Changeable;
import com.huaxin.fim.entity.entity.PositionSummary;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.List;

@Named("positionSummaryDao")
public class PositionSummaryDao {

	@Inject
	private EntityManager em;
//
//	@Inject
//	private FrameworkCacheService frameworkCacheService;
	/*
	 * 批量存储"持仓数据"
	 */
	@Changeable
	public boolean savePositionSummaryList(List<PositionSummary> list, String parseDir, String fileName) {

		synchronized(list){
			
			boolean saveFlag = true;

			if (null == list || list.size() == 0) {
				return saveFlag;
			}
			try {
				int count = 0;
				for (PositionSummary positionSummary : list) {
					em.persist(positionSummary);
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
	
	/*
	 * 批量更新"持仓汇总"
	 */
	@Changeable
	public boolean mergePositionSummaryList(List<PositionSummary> list) {

		boolean saveFlag = true;

		if (list == null || list.size() == 0) {
			return saveFlag;
		}
		try {
			int count = 0;
			for (PositionSummary positionSummary : list) {
				em.merge(positionSummary);
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
			e.printStackTrace();
		}

		return saveFlag;
	}
}
