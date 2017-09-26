package com.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CRequest {
    /**
     * 解析出url参数中的键�?�对
     * �? "index.jsp?Action=del&id=123"，解析出Action:del,id:123存入map�?
     * @param URL  url地址
     * @return  url请求参数部分
     */
    public static List<String> URLRequest(String parms){
	    Map<String, String> mapRequest = new HashMap<String, String>();
	    List<String> list=new ArrayList<String>(); 
	    String[] arrSplit=null;
	    if(parms==null){
	        return null;
	    }
	    //每个键�?�为�?�? www.2cto.com
	    arrSplit=parms.split("[&]");
	    for(String strSplit:arrSplit){
	          String[] arrSplitEqual=null;         
	          arrSplitEqual= strSplit.split("[=]");
	          //解析出键�?
	          if(arrSplitEqual.length>1){
	              //正确解析
	              mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);
	          }else{
	              if(arrSplitEqual[0]!=""){
		              //只有参数没有值，不加�?
		              mapRequest.put(arrSplitEqual[0], "");       
	              }
	          }
	    }   
        //url参数键�?�对
        @SuppressWarnings("unused")
		String strRequestKeyAndValues="";
        for(String strRequestKey: mapRequest.keySet()) {
            String strRequestValue=mapRequest.get(strRequestKey);
            list.add(strRequestValue);      
        }
	    return list;   
    }
    
    /**用于测试CRequest�?
     * @param args
     */
    public static void main(String[] args) {
//    	List<String> list=new ArrayList<String>(); 
//        //url参数键�?�对
//    	String parms ="1=5&3=4";
//        String strRequestKeyAndValues="";       
//        List<String> urlRequest = CRequest.URLRequest(parms);
//        
//        System.out.println(urlRequest.get(0));
//        System.out.println(urlRequest.get(1));
        
    }
}

///**
//* 解析出url请求的路径，包括页面
//* @param strURL url地址
//* @return url路径
//*/
//public static String UrlPage(String strURL){
//String strPage=null;
//String[] arrSplit=null;
//strURL=strURL.trim().toLowerCase();
//arrSplit=strURL.split("[?]");
//if(strURL.length()>0){
//   if(arrSplit.length>1){
//       if(arrSplit[0]!=null){
//     	  strPage=arrSplit[0];
//       }
//   }
//}
//return strPage;   
//}
///**
//* 去掉url中的路径，留下请求参数部�?
//* @param strURL url地址
//* @return url请求参数部分
//*/
//private static String TruncateUrlPage(String strURL){
//   String strAllParam=null;
//   String[] arrSplit=null;
//   strURL=strURL.trim().toLowerCase();
//   arrSplit=strURL.split("[?]");
//   if(strURL.length()>1){
//       if(arrSplit.length>1){
//           if(arrSplit[1]!=null){
//         	  strAllParam=arrSplit[1];
//           }
//       }
//   }
// return strAllParam;   
//}