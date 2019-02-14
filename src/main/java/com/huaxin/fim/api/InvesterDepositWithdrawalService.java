package com.huaxin.fim.api;

import java.math.BigDecimal;
import java.util.List;

import com.dev.framework.core.annotation.Gateway;
import com.dev.framework.core.exception.ServiceException;
import com.huaxin.fim.entity.entity.InvesterDepositWithdrawal;

/**
 * 
 * @author
 * @date
 * @version 1.0
 */
@Gateway
public interface InvesterDepositWithdrawalService {
	
	public InvesterDepositWithdrawal add(InvesterDepositWithdrawal investerDepositWithdrawal) throws ServiceException;
	
	public void delete(long id) throws ServiceException;
	
	public InvesterDepositWithdrawal update(InvesterDepositWithdrawal investerDepositWithdrawal) throws ServiceException;
	
	public List<InvesterDepositWithdrawal> findByCondition(String productName, String beginDate, String endDate) throws ServiceException;
	
	public List<InvesterDepositWithdrawal> findAll() throws ServiceException;
	
	/**
	 * 按日期查询交易资金帐号出入金合计（当日存取合计）
	 * @param invester_id
	 * @param broker_id
	 * @param date
	 * @return
	 */
	public BigDecimal getInvesterDepositWithdrawalOfInvestor(String invester_id, int broker_id, String date);
	
}
