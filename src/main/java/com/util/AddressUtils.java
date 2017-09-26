package com.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * 根据IP地址获取详细的地域信�? 
 * @author     Lwl
 * @introduce  zhaoxiang
 * @dateJan    26, 2016
 * 
 */

public class AddressUtils {
  
	/** 
	 * 
	 * @param content 
	 *      请求的参�? 格式为：name=xxx&pwd=xxx 
	 * @param encoding 
	 *      服务器端请求编码。如GBK,UTF-8�? 
	 * @param urlStr     
	 *      淘宝API：http://ip.taobao.com/service/getIpInfo.php?ip=218.192.3.42
	 *	           新浪API：http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json&ip=218.192.3.42
	 *		pconline API：http://whois.pconline.com.cn/
	 *		百度API：http://api.map.baidu.com/location/ip?ip=218.192.3.42
	 * @return 
	 * @throws UnsupportedEncodingException    "ip="+ip, "utf-8"
	 */
	 public String getAddresses(String content, String encodingString) 
	  throws UnsupportedEncodingException { 
		 // 这里调用pconline的接�? 
		 String urlStr = "http://ip.taobao.com/service/getIpInfo.php"; 
		 //String ip=null;
		 // 从http://whois.pconline.com.cn取得IP�?在的省市区信�? 
		 String returnStr = this.getResult(urlStr, content, encodingString); 
		 String str =null;
		 if (returnStr != null) { 
		  // 处理返回的省市区信息 
		  //System.out.println(returnStr); 
			 
		  String[] temp = returnStr.split(","); 
		  if(temp.length<3){ 
		  return "0";//无效IP，局域网测试 
		  } 
		  String region = (temp[5].split(":"))[1].replaceAll("\"", ""); 
		  region = decodeUnicode(region);// 省份 
		   
		      String country = ""; 
		      String area = ""; 
		      // String region = ""; 
		      String city = ""; 
		      String county = ""; 
		      String isp = ""; 
		      for (int i = 0; i < temp.length; i++) { 
		        switch (i) { 
		        case 1: 
		          country = (temp[i].split(":"))[2].replaceAll("\"", ""); 
		          country = decodeUnicode(country);// 国家 
		          break; 
		          case 3: 
		            area = (temp[i].split(":"))[1].replaceAll("\"", ""); 
		            area = decodeUnicode(area);// 地区  
		          break; 
		          case 5: 
		            region = (temp[i].split(":"))[1].replaceAll("\"", ""); 
		            region = decodeUnicode(region);// 省份  
		          break;  
		          case 7: 
		            city = (temp[i].split(":"))[1].replaceAll("\"", ""); 
		            city = decodeUnicode(city);// 市区 
		          break;  
		          case 9: 
		              county = (temp[i].split(":"))[1].replaceAll("\"", ""); 
		              county = decodeUnicode(county);// 地区  
		          break; 
		          case 11: 
		            isp = (temp[i].split(":"))[1].replaceAll("\"", ""); 
		            isp = decodeUnicode(isp); // ISP公司 
		          break; 
		        } 
		      } 
		  str = country+area+region+city+county;
		  //return new StringBuffer(country).append(area).append(region).append(city).append(county).append(isp).toString(); 
		 } 
		 //System.out.println(str); 
		 return str; 
	 } 
	 /** 
	 * @param urlStr 
	 *      请求的地�? 
	 * @param content 
	 *      请求的参�? 格式为：name=xxx&pwd=xxx 
	 * @param encoding 
	 *      服务器端请求编码。如GBK,UTF-8�? 
	 * @return 
	 */
	 private String getResult(String urlStr, String content, String encoding) { 
		 URL url = null; 
		 HttpURLConnection connection = null; 
		 try { 
		  url = new URL(urlStr); 
		  connection = (HttpURLConnection) url.openConnection();// 新建连接实例 
		  connection.setConnectTimeout(2000);// 设置连接超时时间，单位毫�? 
		  connection.setReadTimeout(33000);// 设置读取数据超时时间，单位毫�? 
		  connection.setDoOutput(true);// 是否打开输出�? true|false 
		  connection.setDoInput(true);// 是否打开输入流true|false 
		  connection.setRequestMethod("POST");// 提交方法POST|GET 
		  connection.setUseCaches(false);// 是否缓存true|false 
		  connection.connect();// 打开连接端口 
		  DataOutputStream out = new DataOutputStream(connection.getOutputStream());// 打开输出流往对端服务器写数据 
		  out.writeBytes(content);// 写数�?,也就是提交你的表�? name=xxx&pwd=xxx 
		  out.flush();// 刷新 
		  out.close();// 关闭输出�? 
		  BufferedReader reader = new BufferedReader(new InputStreamReader( 
		   connection.getInputStream(), encoding));// �?对端写完数据对端服务器返回数�? 
		  // ,以BufferedReader流来读取 
		  StringBuffer buffer = new StringBuffer(); 
		  String line = ""; 
		  while ((line = reader.readLine()) != null) { 
		  buffer.append(line); 
		  } 
		  reader.close(); 
		  return buffer.toString(); 
		 } catch (IOException e) { 
		  e.printStackTrace(); 
		 } finally { 
		  if (connection != null) { 
		  connection.disconnect();// 关闭连接 
		  } 
		 } 
		 return null; 
		 } 
		 /** 
		 * unicode 转换�? 中文 
		 * 
		 * @author fanhui 2007-3-15 
		 * @param theString 
		 * @return 
		 */
		 public static String decodeUnicode(String theString) { 
		 char aChar; 
		 int len = theString.length(); 
		 StringBuffer outBuffer = new StringBuffer(len); 
		 for (int x = 0; x < len;) { 
		  aChar = theString.charAt(x++); 
		  if (aChar == '\\') { 
		  aChar = theString.charAt(x++); 
		  if (aChar == 'u') { 
		   int value = 0; 
		   for (int i = 0; i < 4; i++) { 
		   aChar = theString.charAt(x++); 
		   switch (aChar) { 
		   case '0': 
		   case '1': 
		   case '2': 
		   case '3': 
		   case '4': 
		   case '5': 
		   case '6': 
		   case '7': 
		   case '8': 
		   case '9': 
		    value = (value << 4) + aChar - '0'; 
		    break; 
		   case 'a': 
		   case 'b': 
		   case 'c': 
		   case 'd': 
		   case 'e': 
		   case 'f': 
		    value = (value << 4) + 10 + aChar - 'a'; 
		    break; 
		   case 'A': 
		   case 'B': 
		   case 'C': 
		   case 'D': 
		   case 'E': 
		   case 'F': 
		    value = (value << 4) + 10 + aChar - 'A'; 
		    break; 
		   default: 
		    throw new IllegalArgumentException( 
		     "Malformed   encoding."); 
		   } 
		   } 
		   outBuffer.append((char) value); 
		  } else { 
		   if (aChar == 't') { 
		   aChar = '\t'; 
		   } else if (aChar == 'r') { 
		   aChar = '\r'; 
		   } else if (aChar == 'n') { 
		   aChar = '\n'; 
		   } else if (aChar == 'f') { 
		   aChar = '\f'; 
		   } 
		   outBuffer.append(aChar); 
		  } 
		  } else { 
		  outBuffer.append(aChar); 
		  } 
		 } 
		 return outBuffer.toString(); 
	 } 
		 
	 // 测试 
	 public static void main(String[] args) { 
		 AddressUtils T3 = new AddressUtils(); 
		 // 测试ip 219.136.134.157 中国=华南=广东�?=广州�?=越秀�?=电信 
		 String ip = "125.70.11.136"; 
		 @SuppressWarnings("unused")
		String address = ""; 
		 try { 
		     address = T3.getAddresses("ip="+ip, "utf-8"); 
		 } catch (UnsupportedEncodingException e) { 
		  e.printStackTrace(); 
		 } 
		 // 输出结果为：广东�?,广州�?,越秀�?
		 //System.out.println(address); 
		  
	 } 
  
  
}
