package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.TransactionDetails;
import com.huaxin.fim.entity.entity.TransactionSummary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author wangdl
 *
 */
public interface TransactionSummaryMapper {

	public List<TransactionSummary> getTransactionSummary();
	
	public List<TransactionSummary> getTransactionSummaryByIdList(@Param("productIdList") List<String> productIdList);
	
	public List<TransactionSummary> getTransactionSummaryByType(@Param("transactionSummary") TransactionSummary transactionSummary);
	
	public List<TransactionSummary> getTransactionSummaryByTransactionDetails(@Param("transactionDetails") TransactionDetails transactionDetails);


}
