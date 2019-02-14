package com.huaxin.fim.dao;

import com.dev.framework.core.annotation.Changeable;
import com.huaxin.fim.entity.https.ResponseDetail;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 保存估值原表
 * 
 * @author liumd
 *
 */
@Named("responseDetailDao")
public class ResponseDetailDao {

	private static Log logger = LogFactory.getLog(ResponseDetailDao.class);

	@Inject
	private EntityManager em;

	/*
	 * 批量存储产品品种表
	 */
	@Changeable
	public Map<String, Object> saveResponseDetail(List<ResponseDetail> list) {
		synchronized(this){
			Map<String, Object> resultMap = new HashMap<String, Object>();
			if (list == null || list.size() == 0) {
				return resultMap;
			}
	
			try {
				// 批量存储
				int count = 0;
				for (ResponseDetail period_item : list) {
					em.persist(period_item);
					if (++count % 1000 == 0) {
						em.flush();
						em.clear();
					}
					em.flush();
					em.clear();
				}
			} catch (Exception e) {
				logger.info(e.getMessage());
				resultMap.put("result", "1");
				resultMap.put("message", "保存估值源数据异常："+e.getMessage());
			}
			resultMap.put("result", "0");
			return resultMap;
		}
	}
}
