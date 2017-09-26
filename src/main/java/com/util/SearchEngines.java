package com.util;

import java.util.regex.*;
import java.net.URLDecoder;
import java.io.*;
/**
 * 获取搜索引擎及其参数
 * @author      zhaoxiang
 * @since       2017/08/30 AM
 * @lastModify  2017/08/31 AM
 * 
 */

public class SearchEngines{
	//测试
	public static void main(String[] arg){
	    @SuppressWarnings("unused")
		String ref="http://www.google.com/s?wd=javaѧϰ��";
		//String referer="http://www.cnblogs.com/lyafeng/p/4262354.html";
		if(arg.length!=0){
			ref=arg[0];
	    }
//	    SearchEngines getKeyword=new SearchEngines();
//	    String searchEngine=getKeyword.getSearchEngine(ref);
//	    System.out.println("searchEngine:"+searchEngine);
	    //System.out.println("keyword:"+getKeyword.getKeyword(ref));
	}
	
	public String getKeyword(String refererUrl){
	     StringBuffer sb=new StringBuffer();
	     if(refererUrl!=null){
	       sb.append("(google\\.[a-zA-Z]+/.+[\\&|\\?]q=([^\\&]*)")
	           .append("|iask\\.[a-zA-Z]+/.+[\\&|\\?]k=([^\\&]*)")
	           .append("|iask\\.[a-zA-Z]+/.+[\\&|\\?]_searchkey=([^\\&]*)")
	           .append("|sogou\\.[a-zA-Z]+/.+[\\&|\\?]query=([^\\&]*)")
	           .append("|163\\.[a-zA-Z]+/.+[\\&|\\?]q=([^\\&]*)")
	           .append("|yahoo\\.[a-zA-Z]+/.+[\\&|\\?]p=([^\\&]*)")
	           .append("|baidu\\.[a-zA-Z]+/.+[\\&|\\?]wd=([^\\&]*)")
	           .append("|baidu\\.[a-zA-Z]+/.+[\\&|\\?]word=([^\\&]*)")
	           .append("|lycos\\.[a-zA-Z]+/.*[\\&|\\?]query=([^\\&]*)")
	           .append("|aol\\.[a-zA-Z]+/.+[\\&|\\?]encquery=([^\\&]*)")
	           .append("|3721\\.[a-zA-Z]+/.+[\\&|\\?]p=([^\\&]*)")
	           .append("|3721\\.[a-zA-Z]+/.+[\\&|\\?]name=([^\\&]*)")
	           .append("|search\\.[a-zA-Z]+/.+[\\&|\\?]q=([^\\&]*)")
	           .append("|soso\\.[a-zA-Z]+/.+[\\&|\\?]w=([^\\&]*)")
	           .append("|zhongsou\\.[a-zA-Z]+/.+[\\&|\\?]w=([^\\&]*)")
	           .append("|alexa\\.[a-zA-Z]+/.+[\\&|\\?]q=([^\\&]*)")
	           .append(")");
	       Pattern p = Pattern.compile(sb.toString());
	       Matcher m = p.matcher(refererUrl);
	       return decoderKeyword(m,refererUrl);
	     }
	     return null;
	}
	
	/**
	 * 获取网址参数
	 * @param m
	 * @param refererUrl  搜索网址
	 * @return            参数
	 */
	public String decoderKeyword(Matcher m,String refererUrl){
	   String keyword=null;
	   String encode="UTF-8";
	   String searchEngine=getSearchEngine(refererUrl);
	   if(searchEngine!=null){
	       if ((checkCode("3721|iask|sogou|163|baidu|soso|zhongsou",searchEngine)
	    		   ||(checkCode("yahoo",searchEngine)&&!checkCode("ei=utf-8",refererUrl.toLowerCase())))){
	    	   encode = "GBK";
	       }
	       if (m.find()){
	    	   for (int i = 2; i <= m.groupCount(); i++){
		           if (m.group(i) != null){
			           try{
			               keyword = URLDecoder.decode(m.group(i), encode);
			           }
			               catch(UnsupportedEncodingException e)
			           {
			               System.out.println(e.getMessage());
			           }
			           break;
		           }
	           }
	       }
	   }
	   return keyword;
	}
	
	/**
	 * 获取搜索引擎
	 * @param refUrl 搜索网址
	 * @return       搜索引擎名称
	 */
	public String getSearchEngine(String refUrl) {
	    if(refUrl.length()>11){
	        //p是匹配各种搜索引擎的正则表达�?
	    	Matcher m = Pattern.compile("http:\\/\\/.*\\.(google\\.com(:\\d{1,}){0,1}\\/|google\\.cn(:\\d{1,}){0,1}\\/|baidu\\.com(:\\d{1,}){0,1}\\/|yahoo\\.com(:\\d{1,}){0,1}\\/|iask\\.com(:\\d{1,}){0,1}\\/|sogou\\.com(:\\d{1,}){0,1}\\/|163\\.com(:\\d{1,}){0,1}\\/|lycos\\.com(:\\d{1,}){0,1}\\/|aol\\.com(:\\d{1,}){0,1}\\/|3721\\.com(:\\d{1,}){0,1}\\/|search\\.com(:\\d{1,}){0,1}\\/|soso.com(:\\d{1,}){0,1}\\/|zhongsou\\.com(:\\d{1,}){0,1}\\/|alexa\\.com(:\\d{1,}){0,1}\\/)").matcher(refUrl);     
	        //Matcher m = p.matcher(refUrl);
	        Matcher m2 = Pattern.compile("https:\\/\\/.*\\.(google\\.com(:\\d{1,}){0,1}\\/|google\\.cn(:\\d{1,}){0,1}\\/|baidu\\.com(:\\d{1,}){0,1}\\/|yahoo\\.com(:\\d{1,}){0,1}\\/|iask\\.com(:\\d{1,}){0,1}\\/|sogou\\.com(:\\d{1,}){0,1}\\/|163\\.com(:\\d{1,}){0,1}\\/|lycos\\.com(:\\d{1,}){0,1}\\/|aol\\.com(:\\d{1,}){0,1}\\/|3721\\.com(:\\d{1,}){0,1}\\/|search\\.com(:\\d{1,}){0,1}\\/|soso.com(:\\d{1,}){0,1}\\/|zhongsou\\.com(:\\d{1,}){0,1}\\/|alexa\\.com(:\\d{1,}){0,1}\\/)").matcher(refUrl);     
	        //Matcher m2 = p2.matcher(refUrl);
	        if (m.find()){
	            return insteadCode(m.group(1),"(\\.com(:\\d{1,}){0,1}\\/|\\.cn(:\\d{1,}){0,1}\\/|\\.org(:\\d{1,}){0,1}\\/)","");
	        }else if(m2.find()){
	            return insteadCode(m2.group(1),"(\\.com(:\\d{1,}){0,1}\\/|\\.cn(:\\d{1,}){0,1}\\/|\\.org(:\\d{1,}){0,1}\\/)","");
	        }
	    }
	    //return "未发现有搜索引擎";
	    return "其它";
	}
	
	public String insteadCode(String str,String regEx,String code){
	    Pattern p=Pattern.compile(regEx);
	    Matcher m=p.matcher(str);
	    String s=m.replaceAll(code);
	    return s;
	}
	
	public boolean checkCode(String regEx,String str){
	    Pattern p=Pattern.compile(regEx);
	    Matcher m=p.matcher(str);
	    return m.find();
	}
}
