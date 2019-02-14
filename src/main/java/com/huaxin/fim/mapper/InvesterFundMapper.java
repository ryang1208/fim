package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.InvesterFund;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 
 * @author wangdl
 *
 */
public interface InvesterFundMapper {

	
	public List<InvesterFund> getByInvesterIDandBrokerID(@Param("investerFund") InvesterFund investerFund);

	public List<InvesterFund> getInvesterFund();
	
	/**
	 * 获取估值中子基金信息列表
	 * @param investerId
	 * @param brokerId
	 * @param productId
	 * @param date
	 * @return
	 */
	public List<InvesterFund> getInvesterFundFromValuation(@Param("investerId") String investerId, @Param("brokerId") String brokerId,
                                                           @Param("productId") String productId,
                                                           @Param("date") String date,
                                                           @Param("trusteeId") String trusteeId);
}
