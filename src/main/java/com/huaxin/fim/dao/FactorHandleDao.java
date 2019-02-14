package com.huaxin.fim.dao;

import com.dev.framework.core.annotation.Changeable;
import com.huaxin.fim.entity.entity.FactorIndustryPeriodStatistics;
import com.huaxin.fim.entity.entity.FactorIndustryStatistics;
import com.huaxin.fim.entity.entity.FactorPeriodKPIStatistics;
import com.huaxin.fim.entity.entity.FactorStatistics;
import me.chanjar.weixin.common.util.StringUtils;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * 因子计算结果入库DAO
 * @author shenwei
 *
 */
@Named("factorHandleDao")
public class FactorHandleDao {
	
	@Inject
	private EntityManager em;
	
	/**
	 * 单合约因子指标存储
	 * @param list
	 */
	@Changeable
	public void saveFactorStatisticsList(List<FactorStatistics> list) throws Exception{
		if (list == null || list.size() == 0) {
			return;
		}
		try {
			int count = 0;
			for (FactorStatistics item : list) {
				if(!StringUtils.isEmpty(item.getDate()) && !StringUtils.isEmpty(item.getFactorID()) 
						&& !StringUtils.isEmpty(item.getFactorType())){
					em.persist(item);
				}
				if (++count % 1000 == 0) {
					em.flush();
					em.clear();
				}
				em.flush();
				em.clear();
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * 单合约因子指标存储
	 * @param list
	 */
	@Changeable
	public void saveFactorIndustryStatisticsList(List<FactorIndustryStatistics> list) throws Exception{
		if (list == null || list.size() == 0) {
			return;
		}
		try {
			int count = 0;
			for (FactorIndustryStatistics item : list) {
				if(!StringUtils.isEmpty(item.getDate()) && !StringUtils.isEmpty(item.getFactorID()) 
						&& !StringUtils.isEmpty(item.getFactorType()) && !StringUtils.isEmpty(item.getIndustry())){
					em.persist(item);
				}
				if (++count % 1000 == 0) {
					em.flush();
					em.clear();
				}
				em.flush();
				em.clear();
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * 行业因子周期指标存储
	 * @param list
	 */
	@Changeable
	public void saveFactorIndustryPeriodList(List<FactorIndustryPeriodStatistics> list) throws Exception{
		if (list == null || list.size() == 0) {
			return;
		}
		try {
			int count = 0;
			for (FactorIndustryPeriodStatistics item : list) {
				if(!StringUtils.isEmpty(item.getDate()) && !StringUtils.isEmpty(item.getFactorID()) 
						&& !StringUtils.isEmpty(item.getIndustry()) && !StringUtils.isEmpty(item.getKpi())){
					em.persist(item);
				}
				if (++count % 1000 == 0) {
					em.flush();
					em.clear();
				}
				em.flush();
				em.clear();
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * 单合约因子周期指标存储
	 * @param list
	 */
	@Changeable
	public void saveFactorPeriodKPIList(List<FactorPeriodKPIStatistics> list) throws Exception{
		if (list == null || list.size() == 0) {
			return;
		}
		try {
			int count = 0;
			for (FactorPeriodKPIStatistics item : list) {
				if(!StringUtils.isEmpty(item.getDate()) && !StringUtils.isEmpty(item.getFactorID()) 
						 && !StringUtils.isEmpty(item.getKPI())){
					em.persist(item);
				}
				if (++count % 1000 == 0) {
					em.flush();
					em.clear();
				}
				em.flush();
				em.clear();
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
}
