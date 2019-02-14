package com.huaxin.fim.dao;

import com.dev.framework.core.annotation.Changeable;
import com.huaxin.fim.entity.entity.CTPInvesterDepositWithdrawal;
import com.huaxin.fim.entity.entity.HSCTPInvesterDepositWithdrawal;
import com.huaxin.fim.entity.entity.InvesterDepositWithdrawal;
//import com.dev.framework.service.systemService.FrameworkCacheService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.List;

@Named("investerDepositWithdrawalDao")
public class InvesterDepositWithdrawalDao {

	@Inject
	private EntityManager em;
//
//	@Inject
//	private FrameworkCacheService frameworkCacheService;

	/*
	 * 批量存储"ctp出入金"
	 */
	@Changeable
	public boolean saveCTPInvesterDepositWithdrawalList(List<CTPInvesterDepositWithdrawal> list, String parseDir, String fileName) {

		synchronized(list){
			
			boolean saveFlag = true;

			if (list == null || list.size() == 0) {
				return saveFlag;
			}
			try {
				int count = 0;
				for (CTPInvesterDepositWithdrawal investerDepositWithdrawal : list) {
					em.persist(investerDepositWithdrawal);
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
	 * 批量存储"恒生ctp出入金"
	 */
	@Changeable
	public boolean saveHSCTPInvesterDepositWithdrawalList(List<HSCTPInvesterDepositWithdrawal> list, String parseDir, String fileName) {

		synchronized(list){
			
			boolean saveFlag = true;

			if (list == null || list.size() == 0) {
				return saveFlag;
			}
			try {
				int count = 0;
				for (HSCTPInvesterDepositWithdrawal investerDepositWithdrawal : list) {
					em.persist(investerDepositWithdrawal);
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
	 * 批量存储"出入金"
	 */
	@Changeable
	public boolean saveInvesterDepositWithdrawalList(List<InvesterDepositWithdrawal> list, String parseDir, String fileName) {

		synchronized(list){
			
			boolean saveFlag = true;

			if (list == null || list.size() == 0) {
				return saveFlag;
			}
			try {
				int count = 0;
				for (InvesterDepositWithdrawal investerDepositWithdrawal : list) {
					em.persist(investerDepositWithdrawal);
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
	
}
