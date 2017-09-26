package com.mvc.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import com.util.CRequest;
import com.util.IpAddressUtil;
import com.util.LogPropertieTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import com.mvc.model.AdaCollectAccessLogModel;
import com.mvc.services.AdaAdItemService;
import com.mvc.services.AdaCollectAccessLogService;
import com.mvc.services.SysRegionService;
/**
 * 录入日志
 * @author     zhaoxiang 
 * @since      2017/09/10
 * @lastModify 2017/09/25
 *
 */

@Controller
@Component
@Lazy(false)
@EnableScheduling
@SuppressWarnings("all")
public class AdaCollectAccessLogController {
	@Autowired
	private AdaCollectAccessLogService acaService;
	@Autowired
	private SysRegionService srService;
	@Autowired
	private AdaAdItemService aaiService;
	
	static {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\nginx\\logs\\access2.log"))));
		//读取指定的行数据
		LineNumberReader lur = new LineNumberReader(br);
		if(lur.readLine() == null) {
			System.out.println("access.log ==> 日志文件无数据！！！");
			LogPropertieTools.updateProperties("logLines", String.valueOf(0));//回归初始值 ：0
		}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 每隔5分钟读取日志，并插入数据库
	 * @throws Exception
	 * 
	 */
	@Scheduled(cron = "0/10 * * * * ?")
	public void readLogData() throws Exception{	
		LinkedList<AdaCollectAccessLogModel> adaLogModelList =new LinkedList<AdaCollectAccessLogModel>();
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:\\nginx\\logs\\access2.log"))));
		//读取指定的行数据
		LineNumberReader lur=new LineNumberReader(br);
		int ii = LogPropertieTools.getKeyValue("logLines");
		System.out.println("=============从"+ii+"行开始读取……=============");
		while (lur.readLine() != null) {
			 if(lur.getLineNumber() >= ii) {
				String str=lur.readLine(); //读取每一行数据
				System.out.println(str);
				if (str !=null && !"".equals(str)) {				
					String[] parms=str.split("\\  ");  
					//跳过第一行
                	if(parms[0].equals("No")) continue;
                	//把得到的数据放进list
                	List<String> list = trim(parms);
                	//read++;
                	SimpleDateFormat sourceFormat = new SimpleDateFormat("dd/MMM/yyyy:hh:mm:ss Z", Locale.ENGLISH);
                	SimpleDateFormat transferFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                	
                	Date accessTime = transferFormat.parse(transferFormat.
                			format(sourceFormat.parse(list.get(1))));//获取访问时间
                	String remoteIp = list.get(0);//获取远程IP
                	String realIp = list.get(list.size()-1);
                	if(realIp==null) {//获取真实IP
                		realIp=null;
                	}
                	
                	List<String> parmsList = CRequest.URLRequest(list.get(4));
                	String referer = parmsList.get(0);//引用地址或跳转来源
                	String clientId = parmsList.get(1);//客户端cookie
                	//String duration = parmsList.get(2);//页面停留时长
                	
                	/**
                	 * 根据IP获取地域 :
                	 * 通过调用第三方接口（淘宝、新浪、百度……），根据IP获取地域，该方法适用于少量请求数据
                	 * String area = new AddressUtils().getAddresses("ip="+list.get(0), "utf-8");
                	 * 通过链接GeoLite2-City.mmdb数据库文件，根据IP获取地域，该方法适用于大量请求数据
                	 */
					String area = IpAddressUtil.getSubdivision(list.get(0));
                	String[] split3 = area.split("\\-"); 
                	List<String> list4 = trim(split3);
                	String country =list4.get(0);//国家
                	String province =list4.get(1);//省份
                	String city =list4.get(2);//城市
                	//List<Integer> select2 = srService.getSysRegionID(country, province, city);

                	String[] split = list.get(2).split("\\ "); 
                	List<String> list2 = trim(split);
                	String os = list2.get(1).replace("(", "");//获取操作系统类型

                	String domain = new URL(list.get(3)).getHost();// 获取url域名
                	String requestID =null;// 获取请求ID
                	String requestURL =null;// 获取请求url 
                	//int siteId = aaiService.getAdaAdItemID(list.get(3));//获取站点ID
                	AdaCollectAccessLogModel logModel = new AdaCollectAccessLogModel(1,1,requestID,clientId,
                			list.get(2),requestURL,list.get(3),referer,remoteIp,realIp,os,
                			domain,1,2,3,accessTime);
                	if(logModel==null||logModel.equals("")) {
                		break;
                	}else {
                		adaLogModelList.add(logModel);
                		//批量插入数据
                    	acaService.addTrainRecordBatch(adaLogModelList);
                    	ii ++ ;
                	}
                	
                	//依次、单条插入数据
//                	acaService.insert(new AdaCollectAccessLogModel(1,1,requestID,clientId,
//                			list.get(2),requestURL,list.get(3),referer,remoteIp,realIp,os,
//                			domain,1,2,3,accessTime));
				}
			}	
		}	
		adaLogModelList.removeAll(adaLogModelList);
		System.out.println("=============已经读取到"+ii+"行了=============");
		LogPropertieTools.updateProperties("logLines",String.valueOf(ii));
		br.close();
	}
	public static List<String> trim(String[] source){
        List<String> list = new ArrayList<String>();
        //循环遍历得到的行文件，加入到list中
        for(String item : source){
            if(null==item||"".equals(item))
                continue;
            list.add(item);
        }
        return list;
    }
	//测试
	public static void main(String[] args) throws Exception {

		new AdaCollectAccessLogController().readLogData();
		
	}
	

	
	
//	acaService.insert(new AdaCollectAccessLogModel(Integer.valueOf(1),"1",requestid,clientId,
//	list.get(2),requesturl,list.get(3),referer,remoteIp,realIp,os,
//	domain,select2.get(0),select2.get(1),select2.get(2),accessTime,sysDate));
	

}

