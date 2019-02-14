package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.https.ResponseDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FundNetAssetMapper {

	public String getMaxDate(@Param("xinRawDataSource") Integer xinRawDataSource);

	public List<ResponseDetail> queryByDate(@Param("date") String date, @Param("kmdms") List<String> kmdms,
											@Param("xinRawDataSource") Integer xinRawDataSource);

}
