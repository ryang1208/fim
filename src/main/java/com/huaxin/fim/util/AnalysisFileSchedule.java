package com.huaxin.fim.util;

import com.dev.framework.core.configure.ConfigureProperties;
import com.huaxin.fim.entity.entity.MailReceiveLog;
import com.huaxin.fim.repository.MailReceiveLogRepository;
import me.chanjar.weixin.common.util.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 定时分析结算单及估值表
 * @author liumd
 *
 */
public class AnalysisFileSchedule {
	
	private static Log logger = LogFactory.getLog(AnalysisFileSchedule.class);
	
	private static int successFileAccount = 0;
	private static int failFileAccount = 0;
	/**
	 * 处理结算单及估值表任务
	 * @param beginDate（时间区间开始时间）
	 * @param endDate（结束时间）
	 * @return
	 */
	public static boolean analysisFile(String beginDate,String endDate){
		logger.info("定时解析结算单或估值表文件，日期区间【"+beginDate+"】~【"+endDate+"】---------------------开始");
		ConfigureProperties configure = (ConfigureProperties) SpringUtils.getBean("configureProperties");
    	String parentPath = System.getProperty("user.dir")+ configure.getProperty("UPLOAD_FILE"); // 根目录
		String path = configure.getProperty("mail.filepath");
		String statDate = beginDate;
		List<String> errorMessageList = new ArrayList<String>();
		String errorPath = "mailFileErrorLog";
		
		try{
			while (!DATE.isAfter(DATE.threadParse(statDate, "yyyyMMdd"), DATE.threadParse(endDate, "yyyyMMdd"))) {
				errorMessageList = new ArrayList<String>();
				logger.info("定时解析结算单或估值表文件--------------------日期【"+statDate+"】");
				successFileAccount = 0;
				failFileAccount = 0;
				String uploadFilePath = parentPath.concat(path.concat(File.separator).concat(statDate));
				File newFile = new File(uploadFilePath);
				if(!newFile.exists()){
					statDate = DATE.addThreadDate(statDate, 0, 0, 1);
					continue;
				}
				File[] fileList = newFile.listFiles();
				for(File f: fileList){
					dealFile(f,errorMessageList,statDate);
					deleteDir(f,false);
				}
				deleteDir(newFile,false);
				// 生成错误日志
				if(null != errorMessageList && errorMessageList.size()>0){
					createErrorFile(errorMessageList,statDate,errorPath);
				}
				MailReceiveLogRepository mailReceiveLogRepository = (MailReceiveLogRepository) SpringUtils.getBean("mailReceiveLogRepository");
				List<MailReceiveLog> list = mailReceiveLogRepository.findByDate(statDate);
				if(list != null && list.size() > 0 ){
					MailReceiveLog mr = list.get(0);
					mr.setFileSuccessAccount(successFileAccount);
					mr.setFileFailAccount(failFileAccount);
					mailReceiveLogRepository.save(mr);
				}
				statDate = DATE.addThreadDate(statDate, 0, 0, 1);
			}
		}catch(Exception e){
			errorMessageList.add("处理日期为【"+statDate+"】异常，信息："+e.getMessage());
			logger.info("处理日期为【"+statDate+"】异常，信息：");
			e.printStackTrace();
			if(null != errorMessageList && errorMessageList.size()>0){
				createErrorFile(errorMessageList,statDate,errorPath);
			}
			e.printStackTrace();
		}
		logger.info("定时解析结算单或估值表文件，日期区间【"+beginDate+"】~【"+endDate+"】---------------------结束");
		return true;
	}
	
	@SuppressWarnings("static-access")
	public static List<String> dealFile(File file,List<String> errorMessageList,String date){
		String fileName = null;
		String filePath = null;
		try{
//			DataFileService dataFileService = (DataFileService) SpringUtils.getBean("dataFileService");
//			FrameworkCacheService frameworkCacheService = (FrameworkCacheService) SpringUtils.getBean(FrameworkCacheService.class);
//			File[] fileList = file.listFiles();
//			for(File f: fileList){
//				if (!f.isDirectory()) {
//					logger.info("path=" + f.getPath());
//					fileName = f.getName();
//					if(!StringUtils.isEmpty(fileName) && (fileName.contains(".txt") || fileName.contains(".zip")
//                    		|| fileName.contains(".xlsx")|| fileName.contains(".xls"))){
//						filePath = f.getPath();
//						String fileType = fileName.substring(fileName.lastIndexOf("."), fileName.length()).toLowerCase();
//						dataFileService.fileAnalysis(fileType, filePath, null, DataSourceType.MAIL_IMPORT.getIntValue());
//						String	parseDir = f.getParent().substring(f.getParent().lastIndexOf(f.separator)+1, f.getParent().length());
//						String status = frameworkCacheService.get(parseDir);
//						while(true){
//							status = frameworkCacheService.get(parseDir);
//							if(null !=status && (status.indexOf("#") >=0 || status.indexOf("-1") >=0)){
//								if(null !=status && status.indexOf("#") >=0){
//									// 移动文件夹到成功的目录下
//									ConfigureProperties configure = (ConfigureProperties) SpringUtils.getBean("configureProperties");
//									String parentPath = System.getProperty("user.dir")+ configure.getProperty("UPLOAD_FILE"); // 根目录
//									String path = configure.getProperty("mail.filepath.completed");
//									String uploadFilePath = parentPath.concat(path).concat(File.separator).concat(date);
//									InputStream in = new FileInputStream(f);
//									MailReceiver.saveFile(f.getName(),in,date,uploadFilePath);
//									// 处理成功后删除文件
//									deleteDir(f,false);
//									deleteDir(file,false);
//									successFileAccount = successFileAccount+1;
//								}else{
//									String []arr = status.split("@");
//									if(arr != null && arr.length >=2){
//										fileName = arr[1];
//									}
//									errorMessageList.add("处理日期为【"+date+"】，文件路径【"+f.getPath()+"】,文件名称【"+fileName+"】异常，信息为：      "+status);
//									logger.info("处理日期为【"+date+"】，文件名称【"+fileName+"】异常："+status);
//									failFileAccount = failFileAccount+1;
//								}
//								// 如果是zip包将加压到当前目录中的文件也一同删除
//								if(filePath.contains(".zip")){
//									String fileNameNew = filePath.replace(".zip", "");
//									File fileNew = new File(fileNameNew);
//									deleteDir(fileNew,true);
//								}
//								break;
//							}
//						}
//					}
//				}else{
//					dealFile(f,errorMessageList,date);
//				}
//			}
		}catch(Exception e){
			errorMessageList.add("处理日期为【"+date+"】，文件名称【"+fileName+"】异常，信息为：      "+e.getMessage());
			logger.info("处理日期为【"+date+"】，文件名称【"+fileName+"】异常："+e.getMessage());
		}
		return errorMessageList;
	}
	/**
     * 递归删除目录下的所有文件及子目录下所有文件
     * @param dir 将要删除的文件目录
     * @return boolean
     */
    public static  boolean deleteDir(File dir,boolean determineChildOrNot) {
    	logger.info("删除文件路径："+dir.getPath());
    	boolean result = false;
    	try{
    		if(!dir.exists()){
    			return true;
    		}
    		if (dir.isDirectory()) {
                String[] children = dir.list();
                if(null == children || children.length <=0){
                	result = dir.delete();
                }else{
                	if(determineChildOrNot){
                		//递归删除目录中的子目录下
                		for (int i=0; i<children.length; i++) {
                			boolean success = deleteDir(new File(dir,children[i]),true);
                			if (!success) {
                				return false;
                			}
                		}
                		result = dir.delete();
                	}
                }
            }else{
            	result = dir.delete();
            }
    	}catch(Exception e){
    		e.printStackTrace();
    	}
        // 目录此时为空，可以删除
        return result;
    }
	
    
    /**
	 * 定时解析结算单及估值表时生成错误日志
	 * @return
	 */
	public static boolean createErrorFile(List<String> errorMessageList,String date,String path){
		ConfigureProperties configure = (ConfigureProperties) SpringUtils.getBean("configureProperties");
    	String parentPath = System.getProperty("user.dir")+ configure.getProperty("UPLOAD_FILE")
    		.concat(configure.getProperty("mail.filepath")).concat(File.separator).concat(path); // 根目录
		InputStream inStream = null;
		FileOutputStream fs = null;
		try {
			File newFile = null;
			int byteread = 0;
			String fileName = date.concat(".txt");
			// 生成本地文件
			String localFilePath = parentPath.concat(File.separator)+fileName;
			newFile = new File(localFilePath);
			// 创建本地文件
			if (!newFile.exists()) {
				newFile.getParentFile().mkdirs();
				newFile.createNewFile();
			}
			fs = new FileOutputStream(newFile,true);
			for(String errorMessage:errorMessageList){
				String message = "系统时间【".concat(DATE.currentDatetime()).concat("】  ").concat(errorMessage.concat(System.getProperty("line.separator")));
				inStream =  new ByteArrayInputStream(message.getBytes());
				byte[] buffer = new byte[1024];
				while ((byteread = inStream.read(buffer)) != -1) {
					fs.write(buffer, 0, byteread);
				}
			}
		} catch (IOException e) {
			logger.info("定时解析结算单及估值表时生成错误日志出现异常");
			e.printStackTrace();
			return false;
		}finally{
			try {
				if(inStream!=null){
					inStream.close();
				}
				if(fs!=null){
					fs.close();
				}
			} catch (IOException e) {
				logger.info("定时解析结算单及估值表时生成错误日志出现异常");
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
}
