package com.huaxin.fim.dao;

import com.dev.framework.core.annotation.Changeable;
import com.huaxin.fim.entity.entity.CFMMCCusFund;
import com.huaxin.fim.entity.entity.CFMMCCustomer;
import com.huaxin.fim.entity.entity.CFMMCFundchg;
import com.huaxin.fim.entity.entity.CFMMCHoldData;
import com.huaxin.fim.entity.entity.CFMMCtrddata;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.List;

@Named("settlementBillCompanyImportDao")
public class SettlementBillCompanyImportDao {

	@Inject
	private EntityManager em;
//
//	@Inject
//	private FrameworkCacheService frameworkCacheService;

	/*
	 * 批量存储"出入金"
	 */
	@Changeable
	public boolean saveCFMMCFundchgList(List<CFMMCFundchg> list, String parseDir, String fileName) {
		synchronized(list){
			
			boolean saveFlag = true;

			if (list == null || list.size() == 0) {
				return saveFlag;
			}
			try {
				int count = 0;
				for (CFMMCFundchg fundchg : list) {
					em.persist(fundchg);
					if (++count % 1000 == 0) {
						em.flush();
						em.clear();
					}
				}
				em.flush();
				em.clear();
			} catch (Exception e) {
				saveFlag = false;
		//		frameworkCacheService.put(parseDir, "-1@" + fileName + "@" + "数值错误！");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}

			return saveFlag;
			
		}
		
	}

	/*
	 * 批量存储"资金"
	 */
	@Changeable
	public boolean saveCFMMCCusFundList(List<CFMMCCusFund> list, String parseDir, String fileName) {
		synchronized(list){
			boolean saveFlag = true;

			if (list == null || list.size() == 0) {
				return saveFlag;
			}
			try {
				int count = 0;
				for (CFMMCCusFund cusFund : list) {
					em.persist(cusFund);
					if (++count % 1000 == 0) {
						em.flush();
						em.clear();
					}
				}
				em.flush();
				em.clear();
			} catch (Exception e) {
				saveFlag = false;
				//frameworkCacheService.put(parseDir, "-1@" + fileName + "@" + "数值错误！");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			return saveFlag;
		}
		
	}

	/*
	 * 批量存储"资金"
	 */
	@Changeable
	public boolean saveCFMMCHoldDataList(List<CFMMCHoldData> list, String parseDir, String fileName) {

		synchronized(list){
			
			boolean saveFlag = true;

			if (list == null || list.size() == 0) {
				return saveFlag;
			}
			try {
				int count = 0;
				for (CFMMCHoldData cusFund : list) {
					em.persist(cusFund);
					if (++count % 1000 == 0) {
						em.flush();
						em.clear();
					}
				}
				em.flush();
				em.clear();
			} catch (Exception e) {
				saveFlag = false;
			//	frameworkCacheService.put(parseDir, "-1@" + fileName + "@" + "数值错误！");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}

			return saveFlag;
			
		}
		
	}

	@Changeable
	public boolean saveCFMMCCustomerList(List<CFMMCCustomer> list, String parseDir, String fileName) {
		synchronized(list){
			boolean saveFlag = true;

			if (list == null || list.size() == 0) {
				return saveFlag;
			}
			try {
				int count = 0;
				for (CFMMCCustomer customer : list) {
					em.persist(customer);
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
			//	frameworkCacheService.put(parseDir, "-1@" + fileName + "@" + "数值错误！");
				e.printStackTrace();
			}

			return saveFlag;
		}
		
	}
	
	@Changeable
	public boolean saveCFMMCtrddataList(List<CFMMCtrddata> list, String parseDir, String fileName) {
		//synchronized(list){
			
			boolean saveFlag = true;

			if (list == null || list.size() == 0) {
				return saveFlag;
			}
			try {
				int count = 0;
				for (CFMMCtrddata trddata : list) {
					em.persist(trddata);
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
				//frameworkCacheService.put(parseDir, "-1@" + fileName + "@" + "数值错误！");
				e.printStackTrace();
			}

			return saveFlag;
			
		//}
		
	}
}
