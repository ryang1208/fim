package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.TransactionSummary;
import com.huaxin.fim.entity.entity.VarietySummary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author wangdl
 *
 */
public interface VarietySummaryMapper {

	
	public List<VarietySummary> getVarietySummary(@Param("transactionSummary") TransactionSummary transactionSummary);


}
