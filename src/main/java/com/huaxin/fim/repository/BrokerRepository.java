package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.Broker;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = Broker.class)
public interface BrokerRepository extends CrudRepository<Broker, Long> {
	
	@Query(value = "select b from Broker b where ( b.brokerName like %:brokerName% or :brokerName is null) "
			+ "and ( b.brokerType = :brokerType ) ")
	public List<Broker> queryBybrokerNameAndBrokerType(@Param("brokerName") String brokerName, @Param("brokerType") String brokerType);


//	@Query(value = "SELECT t.id FROM t_broker t "
//			+ "WHERE t.broker_type=:brokerType AND t.CFMMC_code =:cfmmcCode ", nativeQuery = true)
//	public Integer queryByBrokerTypeAndCfmmcCode( @Param("brokerType") String brokerType,@Param("cfmmcCode") String cfmmcCode);

	@Query(value = "select b from Broker b where ( b.brokerType = :brokerType) "
			+ "and ( b.cfmmcCode like %:cfmmcCode% ) ")
	public List<Broker> queryByBrokerTypeAndCfmmcCode(@Param("brokerType") String brokerType, @Param("cfmmcCode") String cfmmcCode);

	public List<Broker> findByBrokerType(String brokerType);

	@Query(value = "select b from Broker b where ( b.brokerType = :brokerType) "
			+ "and ( b.brokerName = :brokerName or :brokerName is null) ")
	public List<Broker> queryByBrokerTypeAndbrokerName(@Param("brokerType") String brokerType, @Param("brokerName") String brokerName);

	@Query(value = "select b from Broker b where b.brokerName like concat(:brokerName,'%')")
	public List<Broker> queryByBrokerName(@Param("brokerName") String brokerName);
}	
