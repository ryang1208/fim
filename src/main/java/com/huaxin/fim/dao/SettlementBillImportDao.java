package com.huaxin.fim.dao;

import com.dev.framework.core.annotation.Changeable;
import com.huaxin.fim.entity.entity.CTPHolddata;
import com.huaxin.fim.entity.entity.CTPPositionCloseDetails;
import com.huaxin.fim.entity.entity.CTPPositionDetails;
import com.huaxin.fim.entity.entity.CTPTransactionDetails;
import com.huaxin.fim.entity.entity.HSCTPPositionDetails;
import com.huaxin.fim.entity.entity.HSCTPTransactionDetails;
import com.huaxin.fim.entity.entity.Index;
import com.huaxin.fim.entity.entity.InvesterDepositWithdrawal;
import com.huaxin.fim.entity.entity.InvesterFund;
import com.huaxin.fim.entity.entity.PositionCloseDetails;
import com.huaxin.fim.entity.entity.PositionDetails;
import com.huaxin.fim.entity.entity.PositionSummary;
import com.huaxin.fim.entity.entity.TransactionDetails;
import com.huaxin.fim.entity.entity.TransactionSummary;
import com.huaxin.fim.entity.entity.VarietySummary;
import com.huaxin.fim.entity.enums.dictionary.DataSourceType;
import com.huaxin.fim.util.DATE;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.List;

@Named("settlementBillImportDao")
public class SettlementBillImportDao {

	private static Log logger = LogFactory.getLog(SettlementBillImportDao.class);

	@Inject
	private EntityManager em;
//
//	@Inject
//	private FrameworkCacheService frameworkCacheService;

	/*
	 * 批量存储"账户资金状况"
	 */
	@Changeable
	public boolean saveInvesterFundList(List<InvesterFund> list, String fileName, String parseDir) {
		synchronized (this) {
			logger.info("存储资金开始");
			boolean success = true;
			if (list == null || list.size() == 0) {
				return success;
			}
			try {
				int count = 0;
				for (InvesterFund investerFund : list) {
					//补充更新日期
					String updateDate = DATE.currentDate();//当前日期
					investerFund.setUpdateDate(updateDate);
					em.persist(investerFund);
					if (++count % 1000 == 0) {
						em.flush();
						em.clear();
					}
				}
				em.flush();
				em.clear();
			} catch (Exception e) {
				success = false;
				//frameworkCacheService.put(parseDir, "-1@" + fileName + "@" + "资金数据错误请检查数据！");
				e.printStackTrace();
				throw e;
			}
			logger.info("存储资金结束");
			return success;
		}
	}

	/*
	 * 批量存储"期货成交汇总"
	 */
	@Changeable
	public boolean saveTransactionSummaryList(List<TransactionSummary> list, String fileName, String parseDir) {
		synchronized (this) {
			logger.info("存储'期货成交汇总'开始");
			boolean success = true;
			if (list == null || list.size() == 0) {
				return success;
			}
			try {
				int count = 0;
				for (TransactionSummary transactionSummary : list) {
					//补充更新日期
					String updateDate = DATE.currentDate();//当前日期
					transactionSummary.setUpdateDate(updateDate);
					em.persist(transactionSummary);
					if (++count % 1000 == 0) {
						em.flush();
						em.clear();
					}
				}
				em.flush();
				em.clear();
			} catch (Exception e) {
				success = false;
				if (parseDir != null) {
				//	frameworkCacheService.put(parseDir, "-1@" + fileName + "@" + "期货成交汇总数据错误请检查数据！");
				}
				e.printStackTrace();
				throw e;
			}
			logger.info("存储'期货成交汇总'结束");
			return success;
		}
	}

	/*
	 * 批量存储"期货持仓汇总"
	 */
	@Changeable
	public boolean savePositionSummaryList(List<PositionSummary> list, String fileName, String parseDir) {
		synchronized (this) {
			logger.info("存储'期货持仓汇总'开始");
			boolean success = true;
			if (list == null || list.size() == 0) {
				return success;
			}
			try {
				int count = 0;
				for (PositionSummary positionSummary : list) {
					//补充更新日期
					String updateDate = DATE.currentDate();//当前日期
					positionSummary.setUpdateDate(updateDate);
					em.persist(positionSummary);
					if (++count % 1000 == 0) {
						em.flush();
						em.clear();
					}
				}
				em.flush();
				em.clear();
			} catch (Exception e) {
				success = false;
			//	frameworkCacheService.put(parseDir, "-1@" + fileName + "@" + "期货持仓汇总数据错误请检查数据！");
				e.printStackTrace();
				throw e;
			}
			logger.info("存储'期货持仓汇总'结束");
			return success;
		}
	}

	/*
	 * 批量存储"出入金"
	 */
	@Changeable
	public boolean saveInvesterDepositWithdrawalList(List<InvesterDepositWithdrawal> list, String fileName,
													 String parseDir) {
		synchronized (this) {
			logger.info("存储'出入金'开始");
			boolean success = true;
			if (list == null || list.size() == 0) {
				return success;
			}
			try {
				int count = 0;
				for (InvesterDepositWithdrawal investerDepositWithdrawal : list) {
					//补充更新日期
					String updateDate = DATE.currentDate();//当前日期
					investerDepositWithdrawal.setUpdateDate(updateDate);
					em.persist(investerDepositWithdrawal);
					if (++count % 1000 == 0) {
						em.flush();
						em.clear();
					}
				}
				em.flush();
				em.clear();
			} catch (Exception e) {
				success = false;
				//frameworkCacheService.put(parseDir, "-1@" + fileName + "@" + "出入金数据错误请检查数据！");
				e.printStackTrace();
				throw e;
			}
			logger.info("存储'出入金'结束");
			return success;
		}
	}

	/*
	 * 批量存储"ctp持仓汇总"
	 */
	@Changeable
	public boolean saveCTPHolddataList(List<CTPHolddata> list, String fileName, String parseDir) {
		synchronized (this) {
			logger.info("存储'ctp持仓汇总'开始");
			boolean success = true;
			if (list == null || list.size() == 0) {
				return success;
			}
			try {
				int count = 0;
				for (CTPHolddata ctpHolddata : list) {
					em.persist(ctpHolddata);
					if (++count % 1000 == 0) {
						em.flush();
						em.clear();
					}
				}
				em.flush();
				em.clear();
			} catch (Exception e) {
				success = false;
				//frameworkCacheService.put(parseDir, "-1@" + fileName + "@" + "ctp持仓汇总数据错误请检查数据！");
				e.printStackTrace();
				throw e;
			}
			logger.info("存储'ctp持仓汇总'结束");
			return success;
		}
	}

	@Changeable
	public boolean saveVarietySummaryList(List<VarietySummary> list){
		synchronized (this) {
			logger.info("存储品种汇总开始");
			boolean success = true;
			if (list == null || list.size() == 0) {
				return success;
			}
			try {
				int count = 0;
				for (VarietySummary varietySummary : list) {
					//补充更新日期
					String updateDate = DATE.currentDate();//当前日期
					varietySummary.setUpdateDate(updateDate);
					if(varietySummary.getVarietyID()!=null){
						varietySummary.setVarietyID(varietySummary.getVarietyID().toUpperCase());
					}
					em.persist(varietySummary);
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
			logger.info("存储品种汇总结束");
			return success;
		}
	}

	/*
	 * 批量存储"品种汇总"
	 */
	@Changeable
	public boolean saveVarietySummaryList(List<VarietySummary> list, String fileName, String parseDir) {
		synchronized (this) {
			logger.info("存储品种汇总开始");
			boolean success = true;
			if (list == null || list.size() == 0) {
				return success;
			}
			try {
				int count = 0;
				for (VarietySummary varietySummary : list) {
					//补充更新日期
					String updateDate = DATE.currentDate();//当前日期
					varietySummary.setUpdateDate(updateDate);
					varietySummary.setDataSource(DataSourceType.SYSTEM_CALCULATE.getIntValue());
					em.persist(varietySummary);
					if (++count % 1000 == 0) {
						em.flush();
						em.clear();
					}
				}
				em.flush();
				em.clear();
			} catch (Exception e) {
				success = false;
				if (parseDir != null) {
				//	frameworkCacheService.put(parseDir, "-1@" + fileName + "@" + "品种汇总数据错误请检查数据！");
				}
				e.printStackTrace();
				throw e;
			}
			logger.info("存储品种汇总结束");
			return success;
		}
	}

	/*
	 * 批量存储"成交明细"
	 */
	@Changeable
	public boolean saveTransactionDetailsList(List<TransactionDetails> list, String fileName, String parseDir) {
		synchronized (this) {
			logger.info("存储成交明细开始");
			boolean success = true;
			if (list == null || list.size() == 0) {
				return success;
			}
			try {
				int count = 0;
				for (TransactionDetails transactionDetail : list) {
					//补充更新日期
					String updateDate = DATE.currentDate();//当前日期
					transactionDetail.setUpdateDate(updateDate);
					em.persist(transactionDetail);
					if (++count % 1000 == 0) {
						em.flush();
						em.clear();
					}
				}
				em.flush();
				em.clear();
			} catch (Exception e) {
				success = false;
				//frameworkCacheService.put(parseDir, "-1@" + fileName + "@" + "成交明细数据错误请检查数据！");
				e.printStackTrace();
				throw e;
			}
			logger.info("存储成交明细结束");
			return success;
		}
	}

	@Changeable
	public boolean saveCTPTransactionDetailsList(List<CTPTransactionDetails> list, String fileName, String parseDir) {
		synchronized (this) {
			logger.info("存储ctp成交明细开始");
			boolean success = true;
			if (list == null || list.size() == 0) {
				return success;
			}
			try {
				int count = 0;
				for (CTPTransactionDetails ctpTransactionDetails : list) {
					em.persist(ctpTransactionDetails);
					if (++count % 1000 == 0) {
						em.flush();
						em.clear();
					}
				}
				em.flush();
				em.clear();
			} catch (Exception e) {
				success = false;
				//frameworkCacheService.put(parseDir, "-1@" + fileName + "@" + "ctp成交明细数据错误请检查数据！");
				e.printStackTrace();
				throw e;
			}
			logger.info("存储ctp成交明细结束");
			return success;
		}
	}

	
	@Changeable
	//恒生成交明细
	public boolean saveHSCTPTransactionDetailsList(List<HSCTPTransactionDetails> list, String fileName, String parseDir) {
		synchronized (this) {
			logger.info("存储ctp成交明细开始");
			boolean success = true;
			if (list == null || list.size() == 0) {
				return success;
			}
			try {
				int count = 0;
				for (HSCTPTransactionDetails ctpTransactionDetails : list) {
					em.persist(ctpTransactionDetails);
					if (++count % 1000 == 0) {
						em.flush();
						em.clear();
					}
				}
				em.flush();
				em.clear();
			} catch (Exception e) {
				success = false;
				//frameworkCacheService.put(parseDir, "-1@" + fileName + "@" + "ctp成交明细数据错误请检查数据！");
				e.printStackTrace();
				throw e;
			}
			logger.info("存储ctp成交明细结束");
			return success;
		}
	}
	/*
	 * 批量存储"平仓明细"
	 */
	@Changeable
	public boolean saveCTPPositionCloseDetailsList(List<CTPPositionCloseDetails> list, String fileName,
												   String parseDir) {
		synchronized (this) {
			logger.info("存储ctp平仓明细开始");
			boolean success = true;
			if (list == null || list.size() == 0) {
				return success;
			}
			try {
				int count = 0;
				for (CTPPositionCloseDetails ctpPositionCloseDetails : list) {
					em.persist(ctpPositionCloseDetails);
					if (++count % 1000 == 0) {
						em.flush();
						em.clear();
					}
				}
				em.flush();
				em.clear();
			} catch (Exception e) {
				success = false;
			//	frameworkCacheService.put(parseDir, "-1@" + fileName + "@" + "ctp平仓明细数据错误请检查数据！");
				e.printStackTrace();
				throw e;
			}
			logger.info("存储ctp平仓明细结束");
			return success;
		}
	}

	@Changeable
	public boolean savePositionCloseDetailsList(List<PositionCloseDetails> list, String fileName, String parseDir) {
		synchronized (this) {
			logger.info("存储平仓明细开始");
			boolean success = true;
			if (list == null || list.size() == 0) {
				return success;
			}
			try {
				int count = 0;
				for (PositionCloseDetails positionCloseDetail : list) {
					//补充更新日期
					String updateDate = DATE.currentDate();//当前日期
					positionCloseDetail.setUpdateDate(updateDate);
					em.persist(positionCloseDetail);
					if (++count % 1000 == 0) {
						em.flush();
						em.clear();
					}
				}
				em.flush();
				em.clear();
			} catch (Exception e) {
				success = false;
				//frameworkCacheService.put(parseDir, "-1@" + fileName + "@" + "平仓明细数据错误请检查数据！");
				e.printStackTrace();
				throw e;
			}
			logger.info("存储平仓明细结束");
			return success;
		}
	}

	/*
	 * 批量存储"持仓明细"
	 */
	@Changeable
	public boolean savePositionDetailList(List<PositionDetails> list, String fileName, String parseDir) {
		synchronized (this) {
			logger.info("存储持仓明细开始");
			boolean success = true;
			if (list == null || list.size() == 0) {
				return success;
			}
			try {
				int count = 0;
				for (PositionDetails positionDetail : list) {
					//补充更新日期
					String updateDate = DATE.currentDate();//当前日期
					positionDetail.setUpdateDate(updateDate);
					// positionDetail.setId(1L);
					em.persist(positionDetail);
					if (++count % 1000 == 0) {
						em.flush();
						em.clear();
					}
				}
				em.flush();
				em.clear();
			} catch (Exception e) {
				success = false;
			//	frameworkCacheService.put(parseDir, "-1@" + fileName + "@" + "持仓明细数据错误请检查数据！");
				e.printStackTrace();
				throw e;
			}
			logger.info("存储持仓明细结束");
			return success;
		}
	}

	/*
	 * 批量存储"ctp持仓明细"
	 */
	@Changeable
	public boolean saveCTPPositionDetailsList(List<CTPPositionDetails> list, String fileName, String parseDir) {
		synchronized (this) {
			logger.info("存储ctp持仓明细原数据开始");
			boolean success = true;
			if (list == null || list.size() == 0) {
				return success;
			}
			try {
				int count = 0;
				for (CTPPositionDetails positionDetail : list) {
					em.persist(positionDetail);
					if (++count % 1000 == 0) {
						em.flush();
						em.clear();
					}
				}
				em.flush();
				em.clear();
			} catch (Exception e) {
				success = false;
			//	frameworkCacheService.put(parseDir, "-1@" + fileName + "@" + "ctp持仓明细原数据错误请检查数据！");
				e.printStackTrace();
				throw e;
			}
			logger.info("存储ctp持仓明细原数据结束");
			return success;
		}
	}
	
	@Changeable
	// 恒生
	public boolean saveHSCTPPositionDetailsList(List<HSCTPPositionDetails> list, String fileName, String parseDir) {
		synchronized (this) {
			logger.info("存储恒生ctp持仓明细原数据开始");
			boolean success = true;
			if (list == null || list.size() == 0) {
				return success;
			}
			try {
				int count = 0;
				for (HSCTPPositionDetails positionDetail : list) {
					em.persist(positionDetail);
					if (++count % 1000 == 0) {
						em.flush();
						em.clear();
					}
				}
				em.flush();
				em.clear();
			} catch (Exception e) {
				success = false;
				//frameworkCacheService.put(parseDir, "-1@" + fileName + "@" + "恒生ctp持仓明细原数据错误请检查数据！");
				e.printStackTrace();
				throw e;
			}
			logger.info("存储恒生ctp持仓明细原数据结束");
			return success;
		}
	}
	
	@Changeable
	// 指数
	public boolean saveIndexValueList(List<Index> list, String fileName, String parseDir) {
		synchronized (this) {
			logger.info("存储指数原数据开始");
			boolean success = true;
			if (list == null || list.size() == 0) {
				return success;
			}
			try {
				int count = 0;
				for (Index indexList : list) {
					em.persist(indexList);
					if (++count % 1000 == 0) {
						em.flush();
						em.clear();
					}
				}
				em.flush();
				em.clear();
			} catch (Exception e) {
				success = false;
			//	frameworkCacheService.put(parseDir, "-1@" + fileName + "@" + "指数原数据错误请检查数据！");
				e.printStackTrace();
				throw e;
			}
			logger.info("存储指数原数据结束");
			return success;
		}
	}
}
