package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.TransactionDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author wangdl
 *
 */
public interface TransactionDetailsMapper {

	public List<TransactionDetails> getTransactionDetails();
	
	public List<TransactionDetails> getTransactionDetailsByIdList(@Param("productIdList") List<String> productIdList);
	
	//金仕达
	public List<TransactionDetails> getJSDTransactionDetails(@Param("transactionDetails") TransactionDetails transactionDetails);

	public List<TransactionDetails> getTransactionDetailsByType(@Param("transactionDetails") TransactionDetails transactionDetails);
	
}
