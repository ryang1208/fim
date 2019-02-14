package com.huaxin.fim.api;

import java.util.List;

import com.dev.framework.core.annotation.Gateway;
import com.huaxin.fim.entity.entity.Broker;

/**
 * 获取期货公司或者证券公司服务
 * @author xieky
 *
 */
@Gateway
public interface BrokerService {

	/**
	 * 获取期货公司
	 * @return
	 */
	public List<Broker> findFuturesCompany();
	
	/**
	 * 获取期货公司根据公司名称
	 * @return
	 */
	public List<Broker> findFuturesCompanyByBrokerName(String brokerName);

	/**
	 * 获取证券公司
	 * @return
	 */
	public List<Broker> findSecuritiesCompany();

}
