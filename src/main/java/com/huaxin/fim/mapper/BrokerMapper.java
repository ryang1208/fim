package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.Broker;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * 2017041815114
 * @author wangdl
 *
 */
public interface BrokerMapper {

	
	public List<Broker> getBrokerByBrokerType(@Param("brokerType") String brokerType);
	
}
