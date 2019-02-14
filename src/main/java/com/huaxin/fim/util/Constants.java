package com.huaxin.fim.util;

import java.util.Set;

/**
 * 系统常量定义
 * @Description:TODO
 * @author lihuijun
 *
 * @date:  2017年2月23日 下午2:23:42
 *
 */
public class Constants {
	
	public static final String APPID="appId";
	/**
	 * 秘钥
	 */
	public static final String AppSecret="secret";
	/**
	 * 管理人编号
	 */
	public static final String ManagerCode="managerCode";
	/**
	 * Https请求服务配置
	 */
	public static final String HTTPS_URL = "HTTPS_URL";
	/**
	 * 业务日期
	 */
	public static final String YWRQ = "ywrq";
	/**
	 * 是否确认
	 */
	public static final String SFQR = "sfqr";
	/**
	 * 签名
	 */
	public static final String SIGN= "sign";
	/**
	 * 基金单位净值
	 */
	public static final String FundUnitNetValue = "FundUnitNetValue";
	/**
	 * 累计单位净值
	 */
	public static final String AccumulatedNet = "AccumulatedNet";

	/**
	 * 沪深300指数代码
	 */
	public static final String HS300 = "000300";
	
	/**
	 * 中证500指数代码
	 */
	public static final String ZZ500 = "000905";

	/**
	 * 从qdiam接取的CTP文件,在存入raw_ctp表时错误的文件名
	 */
	public static Set<String> errorFilesFromSaveQdiamCtpRaw = null;
	
	/**
	 * 从qdiam接取的CTP文件,在存入业务表时错误的文件名
	 */
	public static Set<String> errorFilesFromSaveQdiamCtpProcessed = null;
	
	/**
	 * 从鑫管家成功接入的沣泛国富原始产品个数
	 */
	public static int productsSuccessFromSaveXinRaw_GF = 0;
	
	/**
	 * 从鑫管家成功接入的沣泛国富清理后产品个数
	 */
	public static int productsSuccessFromSaveXinProcessed_GF = 0;
	
	/**
	 * 从鑫管家成功接入的沣泛宽渡原始产品个数
	 */
	public static int productsSuccessFromSaveXinRaw_QDIAM = 0;
	
	/**
	 * 从鑫管家成功接入的沣泛宽渡清理后产品个数
	 */
	public static int productsSuccessFromSaveXinProcessed_QDIAM = 0;
	
	/**
	 * 从鑫管家成功接入的上海翼牛原始产品个数
	 */
	public static int productsSuccessFromSaveXinRaw_YINIU = 0;
	
	/**
	 * 从鑫管家成功接入的上海翼牛清理后产品个数
	 */
	public static int productsSuccessFromSaveXinProcessed_YINIU = 0;
	
	/**
	 * 从鑫管家成功接入的深圳前海中宏金控原始产品个数
	 */
	public static int productsSuccessFromSaveXinRaw_QHZH = 0;
	
	/**
	 * 从鑫管家成功接入的深圳前海中宏金控清理后产品个数
	 */
	public static int productsSuccessFromSaveXinProcessed_QHZH = 0;
	
	public static final String YES = "1";
	
	public static final String NO = "0"; 
	
}
