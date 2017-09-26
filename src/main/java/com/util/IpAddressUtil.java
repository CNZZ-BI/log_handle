package com.util;

import java.io.File;
import java.net.InetAddress;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
/**
 * 通过链接GeoLite2-City.mmdb数据库文件，根据IP获取地域，该方法适用于大量请求数�?
 * @author      zhaoxiang
 * @since       2017/08/31 AM
 * @lastModify  2017/08/31 AM
 * 
 */

public class IpAddressUtil {
	
	private static String dbPath =IpAddressUtil.class.getClassLoader().getResource("GeoLite2-City.mmdb").getPath();
	private static DatabaseReader reader;
	static{
		try {
			File database = new File(dbPath);
			reader = new DatabaseReader.Builder(database).build();
		} catch (Exception e) {
			e.printStackTrace();
		}   	   	
	}
	public static String getSubdivision(String ipAddress){
		//List<String> list ;
		try {
			//Map<String,String> area=new HashMap<String, String>();
			String country=null;
			String sub=null;
			String city=null;
	
			if (reader!=null) {
				CityResponse response = reader.city(InetAddress.getByName(ipAddress));
				country=response.getCountry().getNames().get("zh-CN");
				sub=response.getSubdivisions().get(0).getNames().get("zh-CN");
				city=response.getCity().getNames().get("zh-CN");   
				//IspResponse js=reader.isp(InetAddress.getByName(ipAddress)); //运营商数据库 要计�?
			}
			return country+"-"+sub+"-"+city;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}   
    //测试
	public static void main(String[] args) throws Exception{    
//		 String area = getSubdivision("171.108.233.157");
//		System.out.println(area);
	} 
}
