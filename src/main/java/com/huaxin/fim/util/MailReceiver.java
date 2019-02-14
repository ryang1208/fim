package com.huaxin.fim.util;

import com.dev.framework.core.configure.ConfigureProperties;
import com.huaxin.fim.entity.entity.MailReceiveLog;
import com.huaxin.fim.entity.enums.dictionary.DataSourceType;
import com.huaxin.fim.repository.MailReceiveLogRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;


/**
 * 解析邮件
 * @author liumd
 *
 */
public class MailReceiver{
	
	private static Log logger = LogFactory.getLog(MailReceiver.class);
	
	static Folder inbox = null;
	static Store store = null;	
	static List<String> errorMessageList = new ArrayList<String>();

	/**
	 * 处理接收邮件中的附件
	 * @return
	 */
	public static boolean mailReceiver(String beginDate,String endDate) {  
		logger.info("定时任务收取日期区间【"+beginDate+"】~【"+endDate+"】邮件---------------------开始");
		errorMessageList = new ArrayList<String>();
		ConfigureProperties configure = (ConfigureProperties) SpringUtils.getBean("configureProperties");
		String userName = configure.getProperty("mail.username");
		String password = configure.getProperty("mail.password");
		String protocol = configure.getProperty("mail.protocol");
		String host = configure.getProperty("mail.host");
		
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", protocol); 
        props.setProperty("mail.imap.host", host); 
        if(protocol.equals("pop3")){
        	props.setProperty("mail.pop3.host", host); 
        }
        
        String errorPath = "mailFileErrorLog";
        String statDate = beginDate;
        MailReceiveLogRepository mailReceiveLogRepository = (MailReceiveLogRepository) SpringUtils.getBean("mailReceiveLogRepository");
        List<MailReceiveLog> logList = new ArrayList<MailReceiveLog>();
        URLName urln = new URLName(protocol,host,-1,"INBOX",userName, password);
        try {
        	Session session = Session.getDefaultInstance(props,null);    
			store = session.getStore(urln);
			store.connect();
			inbox = store.getFolder("INBOX"); //获取文件夹内的消息列表
			inbox.open(Folder.READ_ONLY);
			Message[] msgArr= inbox.getMessages();
			//计算页数
			int msgAccount = inbox.getMessageCount();
			while (!DATE.isAfter(DATE.threadParse(statDate, "yyyyMMdd"), DATE.threadParse(endDate, "yyyyMMdd"))) {
				
				int mailAccount = 0;
				int uploadAccount = 0;
				for (int i=msgAccount-1; i>=0; i--) {
					Message msg = msgArr[i];
					String sendDate = getReceivedDate(msg);
					if(Integer.valueOf(sendDate)<Integer.valueOf(statDate)){
						break;
					}
					// 获取当日有附件的邮件
					if(sendDate.equals(statDate)){
						mailAccount++;
						if(isContainAttach(msg,statDate)){
							uploadAccount = saveAttachMent(msg,statDate,uploadAccount);
						}
					}
				}
				if(uploadAccount > 0){
					List<MailReceiveLog> list = mailReceiveLogRepository.findByDate(statDate);
					if(list != null && list.size() >0){
						mailReceiveLogRepository.deleteAll(list);
					}
					MailReceiveLog mr = new MailReceiveLog();
					mr.setDate(statDate);
					mr.setMailAccount(mailAccount);
					mr.setImportType("1");
					mr.setUploadFileAccount(uploadAccount);
					logList.add(mr);

				}
				statDate = DATE.addThreadDate(statDate, 0, 0, 1);
			}
		} catch (MessagingException  e) {
			errorMessageList.add("接收【"+statDate+"】日邮件，链接邮箱异常，信息为：   "+e.getMessage());
			logger.info("连接邮箱出现异常,异常日志如下：");
			e.printStackTrace();
        } catch (Exception e) {
        	errorMessageList.add("获取日期【"+statDate+"】邮件日期异常，信息为：   "+e.getMessage());
        	logger.info("获取邮件发送日期异常,异常日志如下：");
			e.printStackTrace();
    	}finally{
    		 try {
        		 if(inbox != null){
        			 inbox.close(false);
        		 }
        		 if(store != null){
        			 store.close();
        		 }
           } catch (MessagingException e) {
           		errorMessageList.add("关闭接收邮件资源异常，信息为：   "+e.getMessage());
           		logger.info("关闭资源异常,异常日志如下：");
    			e.printStackTrace();
           }
    	}
    	// 生成错误日志
		if(null != errorMessageList && errorMessageList.size()>0){
			AnalysisFileSchedule.createErrorFile(errorMessageList,statDate,errorPath);
			boolean isExist = false;
			for(int j = 0;j<logList.size();j++){
				if(logList.get(j).getDate().equals(statDate)){
					isExist = true;
					break;
				}
			}
			if(!isExist){
				MailReceiveLog mr = new MailReceiveLog();
				mr.setDate(statDate);
				mr.setMailAccount(0);
				mr.setImportType(DataSourceType.MAIL_IMPORT.getIntValue()+"");
				mr.setUploadFileAccount(0);
				List<MailReceiveLog> list = mailReceiveLogRepository.findByDate(statDate);
				if(list != null && list.size() >0){
					mailReceiveLogRepository.deleteAll(list);
				}
				logList.add(mr);
			}
		}
		if(logList != null && logList.size() > 0){
			mailReceiveLogRepository.saveAll(logList);
		}
		logger.info("定时任务收取日期区间【"+beginDate+"】~【"+endDate+"】邮件---------------------结束");
		return true;
    }  
      
	/**  
     * 获得邮件发送日期  
     */  
    public static String getReceivedDate(Message msg) throws Exception {   
        Date sentdate = msg.getSentDate();   
        String dateformat = "yyyyMMdd";
        SimpleDateFormat format = new SimpleDateFormat(dateformat);   
        return format.format(sentdate);   
    } 
    
    /**
     * 判断此邮件是否包含附件
     */
    public static boolean isContainAttach(Part part,String date) throws Exception {
		boolean attachFlag = false;
		try{
		    if (part.isMimeType("multipart/*")) {
		        Multipart mp = (Multipart) part.getContent();
		        for (int i = 0; i < mp.getCount(); i++) {
		            BodyPart mPart = mp.getBodyPart(i);
		            String disposition = mPart.getDisposition();
		            if ((disposition != null) && ((disposition.equals(Part.ATTACHMENT)) || (disposition.equals(Part.INLINE)))){
		            	attachFlag = true;
		            }else if (mPart.isMimeType("multipart/*")) {
		                attachFlag = isContainAttach((Part) mPart,date);
		            } else {
		                String conType = mPart.getContentType();
		                if (conType.toLowerCase().indexOf("application") != -1){
		                	attachFlag = true;
		                }   
		                if (conType.toLowerCase().indexOf("name") != -1){
		                	attachFlag = true;
		                }
		            }
		        }
		    } else if (part.isMimeType("message/rfc822")) {
		        attachFlag = isContainAttach((Part) part.getContent(),date);
		    }
		}catch(Exception e){
			logger.info("判断【"+date+"】邮件是否有附件出现异常");
       		errorMessageList.add("判断【"+date+"】邮件是否有附件出现异常，信息为：   "+e.getMessage());
			e.printStackTrace();
		}
        
        return attachFlag;
    }
    
    /**
     * 保存附件
     * @param part
     * @throws Exception
     */
    public static int saveAttachMent(Part part,String date ,int fileAccouont) throws Exception {
    	String fileName = "";
    	try{
    		ConfigureProperties configure = (ConfigureProperties) SpringUtils.getBean("configureProperties");
        	String parentPath = System.getProperty("user.dir")+ configure.getProperty("UPLOAD_FILE"); // 根目录
    		String path = configure.getProperty("mail.filepath");
    		if (part.isMimeType("multipart/*")) {
                Multipart mp = (Multipart) part.getContent();
                for (int i = 0; i < mp.getCount(); i++) {
                    BodyPart mPart = mp.getBodyPart(i);
                    String disposition = mPart.getDisposition();
                    if ((disposition != null)
                            && ((disposition.equals(Part.ATTACHMENT)) || (disposition
                                    .equals(Part.INLINE)))) {
                        fileName = mPart.getFileName();
                        fileName = MimeUtility.decodeText(fileName);
            			String uploadFilePath = parentPath.concat(path).concat(File.separator).concat(date).concat(File.separator).concat(date+DATE.currentTime().replace(":", ""));
                    	saveFile(fileName, mPart.getInputStream(),date,uploadFilePath);
                    	fileAccouont++;
                    } else if (mPart.isMimeType("multipart/*")) {
                        saveAttachMent(mPart,date,fileAccouont);
                    } else {
                        fileName = mPart.getFileName();
                        if (fileName != null) {
                            fileName = MimeUtility.decodeText(fileName);
                			String uploadFilePath = parentPath.concat(path).concat(File.separator).concat(date).concat(File.separator).concat(date+DATE.currentTime().replace(":", ""));
                        	saveFile(fileName, mPart.getInputStream(),date,uploadFilePath);
                        	fileAccouont++;
                        }
                    }
                }
            } else if (part.isMimeType("message/rfc822")) {
                saveAttachMent((Part) part.getContent(),date,fileAccouont);
            }
    	}catch(Exception e){
    		logger.info("保存【"+date+"】邮件附件出现异常，文件名称【"+fileName+"】");
       		errorMessageList.add("保存【"+date+"】邮件附件出现异常，文件名称【"+fileName+"】，信息为：   "+e.getMessage());

			e.printStackTrace();
    	}
        return fileAccouont;
    }
    
   /**
    * 真正的保存附件到指定目录里 　
    * @param fileName
    * @param in
    * @throws Exception
    */
    public static void saveFile(String fileName, InputStream in,String date,String uploadFilePath) throws Exception {
    	logger.info("保存【"+date+"】，文件名称【"+fileName+"】---------------------开始");
        File newFile = null;
		FileOutputStream fs = null;
		try {
			String path = uploadFilePath.concat(File.separator).concat(fileName);
			// 生成本地文件
			newFile = new File(path);
			// 创建本地文件
			if (!newFile.exists()) {
				newFile.getParentFile().mkdirs();
				newFile.createNewFile();
			}
			fs = new FileOutputStream(newFile);
			byte[] buffer = new byte[1024];
            int len = 0;
            while((len=in.read(buffer))>0){
            	fs.write(buffer, 0, len);
            }
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(in!=null){
					in.close();
				}
				if(fs!=null){
					fs.close();
				}
			} catch (IOException e) {
				logger.info("保存【"+date+"】文件到指定目录出现异常，文件名称【"+fileName+"】");
	       		errorMessageList.add("保存【"+date+"】文件到指定目录出现异常，文件名称【"+fileName+"】 ，信息为：   "+e.getMessage());

				e.printStackTrace();
			}
		}
    	logger.info("保存【"+date+"】,文件名称【"+fileName+"】---------------------结束");
    }
    
}
