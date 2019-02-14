package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.entity.TransactionDetails;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 更新成交汇总
 * 
 * @Description:TODO
 * @author lihuijun
 *
 * @date: 2017年3月8日 下午6:37:16
 *
 */
public interface QDAMDataMapper {

	public void deleteTradeHis(@Param("date") String date, @Param("accountId") String accountId);

	public void insertTransaction(@Param("date") String date, @Param("dataSource") Integer dataSource);

	public List<TransactionDetails> getTradeList(@Param("date") String date, @Param("accountId") String accountId);

}
