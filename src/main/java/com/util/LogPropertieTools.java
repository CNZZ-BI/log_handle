package com.util;

import java.io.*;
import java.util.*;
/**
 * 读取*.properties配置文件的工具类�?
 * @author      zhaoxiang
 * @since       2017/08/28 AM
 * @lastModify  2017/08/28 AM
 * 
 */

public class LogPropertieTools {
	//属�?�文件的路径   
    static String profilepath="D:\\eclipseWorkspace\\log_handle\\src\\main\\resources\\logLines.properties";  
    /**  
     * 采用静�?�方�?  
     */   
     private static Properties pro = new Properties();   
     static {   
         try {   
             pro.load(new FileInputStream(profilepath));   
         } catch (FileNotFoundException e) {   
             e.printStackTrace();   
             System.exit(-1);   
         } catch (IOException e) {          
             System.exit(-1);   
         }   
     }  
    
    /**  
     * 读取属�?�文件中相应键的�?  
     * @param key  主键  
     * @return int  
     */   
     public static int getKeyValue(String key) { 
         return Integer.valueOf(pro.getProperty(key));   
     } 
     
     /**  
      * 根据主键key读取主键的�?�value  
      * @param filePath 属�?�文件路�?  
      * @param key 键名  
      */   
      public static String readValue(String filePath, String key) {   
          Properties props = new Properties();   
          try {   
              InputStream in = new BufferedInputStream(new FileInputStream(   
                      filePath));   
              props.load(in);   
              String value = props.getProperty(key);   
              System.out.println(key +"键的值是�?"+ value);   
              return value;   
          } catch (Exception e) {   
              e.printStackTrace();   
              return null;   
          }   
      } 
     
     /**  
      * 更新（或插入）一对properties信息(主键及其键�??)  
      * 如果该主键已经存在，更新该主键的值；  
      * 如果该主键不存在，则插件�?对键值�??  
      * @param keyname 键名  
      * @param keyvalue 键�??  
      */   
      public static void writeProperties(String keyname,String keyvalue) {          
          try {   
              // 调用 Hashtable 的方�? put，使�? getProperty 方法提供并行性�??   
              // 强制要求为属性的键和值使用字符串。返回�?�是 Hashtable 调用 put 的结果�??   
              OutputStream fos = new FileOutputStream(profilepath);   
              //pro.setProperty("logLines", String.valueOf(LogView.getLogLines()));
              pro.setProperty(keyname,keyvalue);
              // 以�?�合使用 load 方法加载�? Properties 表中的格式，   
              // 将此 Properties 表中的属性列表（键和元素对）写入输出�?   
              pro.store(fos, "Update '" + keyname + "' value");    
          } catch (IOException e) {   
              System.err.println("属�?�文件更新错�?");   
          }   
      }  
      
      /**  
       * 更新properties文件的键值对  
       * 如果该主键已经存在，更新该主键的值；  
       * 如果该主键不存在，则插件�?对键值�??  
       * @param keyname 键名  
       * @param keyvalue 键�??  
       */   
       public static void updateProperties(String keyname,String keyvalue) {   
           try {   
               pro.load(new FileInputStream(profilepath));   
               // 调用 Hashtable 的方�? put，使�? getProperty 方法提供并行性�??   
               // 强制要求为属性的键和值使用字符串。返回�?�是 Hashtable 调用 put 的结果�??   
               OutputStream fos = new FileOutputStream(profilepath);              
               pro.setProperty(keyname, keyvalue);   
               // 以�?�合使用 load 方法加载�? Properties 表中的格式，   
               // 将此 Properties 表中的属性列表（键和元素对）写入输出�?   
               pro.store(fos, "Update '" + keyname + "' value");   
           } catch (IOException e) {   
               System.err.println("属�?�文件更新错�?");   
           }   
       } 
      
      
      
    //测试代码   
      public static void main(String[] args) {   
          readValue("D:\\eclipseWorkspace\\CNZZ_LOG\\src\\LogLines.properties", "logLines");   
          //writeProperties("logLines", "75"); 
          //updateProperties("logLines", "798"); 
          getKeyValue("logLines");
          System.out.println("操作完成");   
      }  

}
