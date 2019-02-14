package com.huaxin.fim.repository;


import com.dev.framework.core.annotation.EntityClass;
import com.dev.framework.core.annotation.Forbid;
import com.huaxin.fim.entity.entity.BondEvaluate;
import com.huaxin.fim.entity.entity.MailReceiveLog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 邮件接收处理日志数据处理接口
 * @author liumd
 *
 */
@Repository("mailReceiveLogRepository")
@Forbid(forbiddenMethods = { "deleteAll" })
@EntityClass(entityClass = BondEvaluate.class)
public interface MailReceiveLogRepository extends CrudRepository<MailReceiveLog, Long> {
	
	public List<MailReceiveLog> findByDate(String date);
	
	@Query(value="select m from MailReceiveLog m where m.date=:date or :date is null order by m.date desc")
	public List<MailReceiveLog> getLogList(@Param("date") String date);
	
}
	