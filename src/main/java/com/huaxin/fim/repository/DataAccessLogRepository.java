package com.huaxin.fim.repository;

import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.DataAccessLog;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("dataAccessLogRepository")
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = DataAccessLog.class)
public interface DataAccessLogRepository extends CrudRepository<DataAccessLog, Long> {
	
	@Query(value = "select l from DataAccessLog l "
			+ "where (l.accessDate = :accessDate or :accessDate is null) "
			+ "and (l.fileDate = :fileDate or :fileDate is null) "
			+ "and (l.fileSource = :fileSource or :fileSource is null) order by l.fileDate asc ")
	public List<DataAccessLog> findByCondition(@Param("accessDate") String accessDate,
                                               @Param("fileDate") String fileDate, @Param("fileSource") String fileSource);

	@Query(value="SELECT                      "
				+"   a.invester_id"
				+" FROM                        "
				+"   t_invester_fund a         "
				+" WHERE a.date = :currentDate  and data_source=:fileSource   "
				+"   AND a.invester_id NOT IN  "
				+"   (SELECT                   "
				+"     invester_id             "
				+"   FROM                      "
				+"     t_invester_fund         "
				+"   WHERE DATE = :yesterday and data_source=:fileSource   )     ",nativeQuery=true)
	public List<Object> getMoreOrLessInvesterId(@Param("currentDate") String currentDate, @Param("yesterday") String yesterday,
                                                @Param("fileSource") String fileSource);

	@Query(value="SELECT                      "
				+"   p.product_name            "
				+" FROM                        "
				+"   t_fund_valuation_table a  "
				+"   LEFT JOIN t_product p     "
				+"     ON a.product_id = p.id  "
				+" WHERE a.date = :currentDate     "
				+"   AND a.data_source = :fileSource     "
				+"   AND a.product_id NOT IN   "
				+"   (SELECT                   "
				+"     product_id              "
				+"   FROM                      "
				+"     t_fund_valuation_table  "
				+"   WHERE DATE = :yesterday     "
				+"     AND data_source = :fileSource)     ",nativeQuery=true)
	public List<Object> getMoreOrLessProductName(@Param("currentDate") String currentDate, @Param("yesterday") String yesterday,
                                                 @Param("fileSource") String fileSource);

	@Modifying
	@Transactional(propagation = Propagation.REQUIRED)
	@Query(value = "insert into t_data_access_log(access_date,file_date,file_source,log_info,operate_time) values(" +
			":accessDate,:fileDate,:fileSource,:logInfo,:operateTime)",nativeQuery = true)
	public void insert(@Param("accessDate") String accessDate, @Param("fileDate") String fileDate,
                       @Param("fileSource") String fileSource,
                       @Param("logInfo") String logInfo, @Param("operateTime") String operateTime);


	
}	
