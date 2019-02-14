package com.huaxin.fim.dao;

import com.dev.framework.core.annotation.Changeable;
import com.huaxin.fim.entity.entity.CTPInvesterFund;
import com.huaxin.fim.entity.entity.HSCTPInvesterFund;
import com.huaxin.fim.entity.entity.InvesterFund;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.List;

@Named("investerFundDao")
public class InvesterFundDao {

	@Inject
	private EntityManager em;
//
//	@Inject
//	private FrameworkCacheService frameworkCacheService;
	/*
	 * 批量存储"持仓数据"
	 */
	@Changeable
	public boolean saveInvesterFundList(List<InvesterFund> list, String parseDir, String fileName) {
		synchronized(list){
			boolean saveFlag = true;

			if (list == null || list.size() == 0) {
				return saveFlag;
			}
			try {
				int count = 0;
				for (InvesterFund investerFund : list) {
					em.persist(investerFund);
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
			//	frameworkCacheService.put(parseDir, "-1@" + fileName + "@" + "数据错误！");
				e.printStackTrace();
			}

			return saveFlag;
			
		}
		
	}
	
	/*
	 * 批量存储"持仓数据"
	 */
	@Changeable
	public boolean saveCTPInvesterFundList(List<CTPInvesterFund> list, String parseDir, String fileName) {
		synchronized(list){
			boolean saveFlag = true;

			if (list == null || list.size() == 0) {
				return saveFlag;
			}
			try {
				int count = 0;
				for (CTPInvesterFund investerFund : list) {
					em.persist(investerFund);
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
			//	frameworkCacheService.put(parseDir, "-1@" + fileName + "@" + "数据错误！");
				e.printStackTrace();
			}

			return saveFlag;
			
		}
		
	}
	
	@Changeable
	public boolean saveHSCTPInvesterFundList(List<HSCTPInvesterFund> list, String parseDir, String fileName) {
		synchronized(list){
			boolean saveFlag = true;

			if (list == null || list.size() == 0) {
				return saveFlag;
			}
			try {
				int count = 0;
				for (HSCTPInvesterFund investerFund : list) {
					em.persist(investerFund);
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
			//	frameworkCacheService.put(parseDir, "-1@" + fileName + "@" + "数据错误！");
				e.printStackTrace();
			}

			return saveFlag;
			
		}
		
	}
	/*
	 * 批量存储"持仓数据"
	 */
	@Changeable
	public boolean mergeInvesterFundList(List<InvesterFund> list) {

		boolean saveFlag = true;

		if (list == null || list.size() == 0) {
			return saveFlag;
		}
		try {
			int count = 0;
			for (InvesterFund investerFund : list) {
				if (!"无结算信息".equals(investerFund.getDate())) {
					em.merge(investerFund);
				}
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
