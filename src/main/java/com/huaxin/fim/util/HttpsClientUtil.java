package com.huaxin.fim.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Https客户端
 * 
 * @author lihuijun
 * @since 2017年2月23日 上午10:34:08
 * @version 1.0
 */
public class HttpsClientUtil {

	private static Log logger = LogFactory.getLog(HttpsClientUtil.class);

	private static class TrustAnyTrustManager implements X509TrustManager {

		public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}

		public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		}

		public X509Certificate[] getAcceptedIssuers() {
			return new X509Certificate[] {};
		}
	}

	private static class TrustAnyHostnameVerifier implements HostnameVerifier {
		public boolean verify(String hostname, SSLSession session) {
			return true;
		}
	}

	String _url = "";
	String _param = "";

	public HttpsClientUtil(String url, String param) {
		logger.info("\n连接请求地址：" + url + "\n请求参数列表: " + param);
		this._url = url;
		this._param = param;
	}

	public HttpsURLConnection getConnection() throws Exception {
		HttpsURLConnection connection = null;
		try {
			logger.info("开始建立https连接");
			String urlStr = this._url.concat("?").concat(this._param);
			logger.info("https请求完整路径: "+urlStr); 
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, new TrustManager[] { new TrustAnyTrustManager() }, new java.security.SecureRandom());
			URL realUrl = new URL(urlStr);
			// 打开和URL之间的连接
			connection = (HttpsURLConnection) realUrl.openConnection();
			// 设置https相关属性
			connection.setSSLSocketFactory(sc.getSocketFactory());
			connection.setHostnameVerifier(new TrustAnyHostnameVerifier());
			connection.setDoOutput(true);

			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("Content-Type", "GBK");

			connection.setRequestProperty("Path", "/SelfOpenAccount");

			// 设置通讯超时时间
//			connection.setConnectTimeout(50000);
			// 设置读取超时时间
//			connection.setReadTimeout(50000);
			// 建立实际的连接
			connection.connect();
			logger.info("https连接建立成功");
			return connection;
		} catch (Exception e) {
			logger.error("https连接失败", e);
			throw e;
		}
	}

	public String getResponse() throws Exception {
		String result = "";
		BufferedReader in = null;
		// StringBuilder buffer = new StringBuilder();
		try {
			InputStream is = responseStream();
			if (null != is) {
				// in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				// String line = null;
				// while ((line = in.readLine()) != null) {
				// buffer.append(line);
				// }
				// result = URLDecoder.decode(buffer.toString(), "UTF-8");
				if (is != null) {
					ByteArrayOutputStream outStream = new ByteArrayOutputStream();
					byte[] buffer = new byte[4096];
					int len = 0;
					while ((len = is.read(buffer)) != -1) {
						outStream.write(buffer, 0, len);
					}
					is.close();
					result = new String(outStream.toByteArray());
				}
				logger.info("获取的结果为：" + result);
			}
		} catch (Throwable e) {
			logger.error("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				throw e2;
			}
		}
		return result;
	}

	/**
	 * 获取返回的输入流
	 * 
	 * @return
	 * @throws Exception
	 */
	public InputStream responseStream() throws Exception {
		try {
			HttpsURLConnection connection = getConnection();
			if (null != connection) {
				return connection.getInputStream();
			}
		} catch (Throwable e) {
			logger.error("发送GET请求出现异常！" + e);

		}
		return null;
	}

	/**
	 * 获取会话session 返回格式 JSESSIONID=593E2A1AB154E50FCE9D2ED053F096FC
	 * 
	 * @return
	 * @throws Exception
	 */
	public String responseSession() throws Exception {
		String sId = "";
		try {
			HttpsURLConnection connection = getConnection();
			if (null != connection) {
				String sessionStr = connection.getHeaderField("Set-Cookie");
				if (StringUtils.isNotBlank(sessionStr)) {
					sId = sessionStr.substring(0, sessionStr.indexOf(";"));
				}
				logger.info("获取的结果为：" + sId);
			}
			return sId;
		} catch (Throwable e) {
			logger.error("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		// String str1 =
		// "https://127.0.0.1:1234/SelfOpenAccount/firmController.fir?funcflg=checkOpenTime&appid=testtest&sig=86750ce051f163be0c3715ebac9a232b";
		// String str2 =
		// "https://60.28.133.148:16969/SelfOpenAccount/firmController.fir?funcflg=sendSMS&appid=testtest&PhoneNo=13524886742&sig=7eaafe020e753d5e3bfb11c63b4cb0fc";

		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
