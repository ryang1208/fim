package com.huaxin.fim.dao;

import com.dev.framework.core.annotation.Changeable;
import com.huaxin.fim.entity.entity.Contract;
import com.huaxin.fim.entity.entity.InvesterDepositWithdrawal;
import com.huaxin.fim.entity.entity.InvesterFund;
import com.huaxin.fim.entity.entity.PositionCloseDetails;
import com.huaxin.fim.entity.entity.PositionSummary;
import com.huaxin.fim.entity.entity.ProductNetValue;
import com.huaxin.fim.entity.entity.RawQDIAMInvesterDepositWithdrawal;
import com.huaxin.fim.entity.entity.RawQDIAMInvesterFund;
import com.huaxin.fim.entity.entity.RawQDIAMPositionCloseDetails;
import com.huaxin.fim.entity.entity.RawQDIAMPositionSummary;
import com.huaxin.fim.entity.entity.RawQDIAMProductNetValue;
import com.huaxin.fim.entity.entity.RawQDIAMTransactionDetails;
import com.huaxin.fim.entity.entity.TransactionDetails;
import com.huaxin.fim.repository.TransactionDetailsRepository;
import com.huaxin.fim.util.ObjectReflectUtil;
import com.quantdo.datahub.util.DateUtils;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;

@Named("qdiamDataDao")
public class QDIAMDataDao {
	
	@Inject
	private EntityManager em;
	
	@Inject
	private TransactionDetailsRepository transactionDetailsRepository;
	
	/**
	 * 存储投资者资金
	 */
	@Changeable
	public void saveInvesterFund(List<RawQDIAMInvesterFund> investerFunds){
		
		int count = 0;
		for(RawQDIAMInvesterFund investerFund : investerFunds){
			InvesterFund inf = ObjectReflectUtil.copyPropertys(investerFund, new InvesterFund());
			inf.setUpdateDate(DateUtils.currentDate());
			em.persist(inf);
			count++;
			if(count % 500 == 0){
				em.flush();
				em.clear();
			}
		}
		em.flush();
		em.clear();
	}
	
	/**
	 * 存储投资者出入金
	 */
	@Changeable
	public void saveInvesterDepositWithdrawal(List<RawQDIAMInvesterDepositWithdrawal> investerDepositWithdrawals){
		int count = 0;
		for(RawQDIAMInvesterDepositWithdrawal investerDepositWithdrawal : investerDepositWithdrawals){
			InvesterDepositWithdrawal idw = ObjectReflectUtil.copyPropertys(investerDepositWithdrawal, new InvesterDepositWithdrawal());
			idw.setUpdateDate(DateUtils.currentDate());
			em.persist(idw);
			count++;
			if(count % 500 == 0){
				em.flush();
				em.clear();
			}
		}
		em.flush();
		em.clear();
	}
	
	/**
	 * 存储持仓汇总
	 */
	@Changeable
	public void savePositionSummary(List<RawQDIAMPositionSummary> positionSummarys, Map<String, Contract> contractMap){
		int count = 0;
		
		for(RawQDIAMPositionSummary positionSummary : positionSummarys){
			PositionSummary ps = ObjectReflectUtil.copyPropertys(positionSummary, new PositionSummary());
			ps.setUpdateDate(DateUtils.currentDate());
			
			// 补市场信息
			if(contractMap != null && contractMap.get(ps.getContact()) != null){
				ps.setMarketType(contractMap.get(ps.getContact()).getAssetType());
			}
			
			em.persist(ps);
			count++;
			if(count % 500 == 0){
				em.flush();
				em.clear();
			}
		}
		em.flush();
		em.clear();
	}
	
	/**
	 * 存储成交明细
	 */
	@Changeable
	public void saveTransactionDetails(List<RawQDIAMTransactionDetails> transactionDetails, Map<String, Contract> contractMap){
		int count = 0;

		for(RawQDIAMTransactionDetails transactionDetail : transactionDetails){
			TransactionDetails td = ObjectReflectUtil.copyPropertys(transactionDetail, new TransactionDetails());
			td.setUpdateDate(DateUtils.currentDate());
			
			// 补市场信息
			if(contractMap != null && contractMap.get(td.getContact()) != null){
				td.setMarketType(contractMap.get(td.getContact()).getAssetType());
			}
			
			em.persist(td);
			count++;
			if(count % 500 == 0){
				em.flush();
				em.clear();
			}
		}
		em.flush();
		em.clear();
	}
	
	/**
	 * 存储平仓明细
	 */
	@Changeable
	public void savePositionCloseDetails(List<RawQDIAMPositionCloseDetails> positionositionCloseDetails, Map<String, Contract> contractMap){
		int count = 0;
		for(RawQDIAMPositionCloseDetails positionositionCloseDetail : positionositionCloseDetails){
			PositionCloseDetails pcd = ObjectReflectUtil.copyPropertys(positionositionCloseDetail, new PositionCloseDetails());
			
			// 按平仓的成交号找对应成交记录,将平仓盈亏修改入成交记录中
			TransactionDetails offsetTrade = transactionDetailsRepository.findByDateAndTranscationNO(pcd.getDate(), pcd.getTranscationNO(),pcd.getInvesterID());
			if(offsetTrade != null && pcd.getCloseProfit() != null){
				offsetTrade.setCloseProfit(pcd.getCloseProfit());
				transactionDetailsRepository.save(offsetTrade);
			}
			pcd.setUpdateDate(DateUtils.currentDate());
			
			// 补市场信息
			if(contractMap != null && contractMap.get(pcd.getContact()) != null){
				pcd.setMarketType(contractMap.get(pcd.getContact()).getAssetType());
			}
			
			em.persist(pcd);
			count++;
			if(count % 500 == 0){
				em.flush();
				em.clear();
			}
		}
		em.flush();
		em.clear();
	}
	
	/**
	 * 存储产品净值
	 */
	@Changeable
	public void saveNetValues(List<RawQDIAMProductNetValue> netValues){
		int count = 0;
		for(RawQDIAMProductNetValue netValue : netValues){
			ProductNetValue nv = ObjectReflectUtil.copyPropertys(netValue, new ProductNetValue());
			nv.setUpdateDate(DateUtils.currentDate());
			em.persist(nv);
			count++;
			if(count % 500 == 0){
				em.flush();
				em.clear();
			}
		}
		em.flush();
		em.clear();
	}
	
}
