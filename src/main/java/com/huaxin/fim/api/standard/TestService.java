package com.huaxin.fim.api.standard;

import com.dev.framework.core.annotation.DisabledLog;
import com.dev.framework.core.annotation.Gateway;
import com.dev.framework.core.annotation.RequestMethod;
import com.dev.framework.core.annotation.SessionAttribute;
import com.dev.framework.core.enums.RequestMethodEnum;
import com.dev.framework.core.exception.ServiceException;
import com.dev.framework.core.util.Constants;
import com.huaxin.fim.entity.entity.TestBean;
import com.huaxin.fim.entity.entity.TestEntity;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * 对外提供的服务 需要声明Gateway
 * 
 * @author fan
 *
 */
@Gateway
public interface TestService {

	// 对外提供的业务方法
	// 会对方法上的校验规则自动校验
	// @SessionAttribute 会自动将session中对应的key注入作为参数
	public TestBean service(@NotNull String a,
							@SessionAttribute("userId") String userName);

	// 多参数
	public void service2(@NotNull String a, String b, int c, Long d,
                         List<String> strs, List<Map<?, ?>> maps, TestBean testBean,
                         List<TestBean> testBeans, List<List<TestBean>> testBeanss);

	// 返回集合
	public List<TestEntity> getAllTestEntity();

	// 执行异步方法
	public void asyncService();

	// 上传文件，文件参数放在最先
	public String uploadFile(List<File> uploadFile1, @NotNull String params);

	// 无参数上传文件
	public String uploadFile2(List<File> uploadFile1) throws ServiceException;

	// 下载文件
	public File downloadFile(String params);

	/**
	 * 缓存测试
	 *
	 * @param userName
	 * @return
	 */
	public String cacheService(String userName);

	/**
	 * 带sessionid参数的缓存测试
	 *
	 * @param userName
	 * @param sessionid
	 * @return
	 */
	public String cache2Service(String userName,
                                @SessionAttribute(Constants.SESSION_ID) String sessionid);

	/**
	 * session缓存测试
	 *
	 * @param userName
	 * @return
	 */
	public String sessionCacheService(String userName);

	/**
	 * 参数校验测试
	 *
	 * @param param1
	 * @return
	 */
	public String paramValidate(
            @NotNull(message = "1|参数param1不能为空") String param1) throws ServiceException;

	/**
	 * restfulservice get方法测试 参数为普通参数
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	@RequestMethod(RequestMethodEnum.GET)
	public TestBean restfulservice(String a, String b);

	/**
	 * restfulservice get方法测试 参数为对象
	 * 
	 * @param testBean
	 * @return
	 */
	@RequestMethod(RequestMethodEnum.GET)
	public TestBean restfulservice2(TestBean testBean);

	/**
	 * restfulservice del方法测试
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	@RequestMethod(RequestMethodEnum.DELETE)
	public TestBean restfulserviceDel(String a, String b);

	/**
	 * restfulservice Put方法测试
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	@RequestMethod(RequestMethodEnum.CREATE)
	public TestBean restfulservicePut(String a, String b);

	/**
	 * restfulservice update方法测试
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	@RequestMethod(RequestMethodEnum.UPDATE)
	public TestBean restfulservicePost(String a, String b);

	/**
	 * 锁测试
	 * 
	 * @return
	 */
	@RequestMethod(RequestMethodEnum.GET)
	public String lockService();

	/**
	 * 发送消息
	 * 
	 * @param topic
	 *            主题
	 * @param msg
	 *            消息内容
	 * @return
	 */
	@RequestMethod(RequestMethodEnum.GET)
	public String sendMessage(String topic, String msg);

	/**
	 * DisenableLog注解不打印参数日志
	 * 
	 * @param msg
	 * @return
	 */
	@DisabledLog
	public String disenableLog(String msg);

	/**
	 * 发送短信
	 * 
	 * @param phoneNumber
	 */
	public boolean sendSMS(String phoneNumber);

}
