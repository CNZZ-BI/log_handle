package com.util;
import java.io.Serializable;

/**
 * 查询条件封装子对象
 * @author 赵翔 
 * @lastModify 2016/10/13 13:00
 * @version
 */
@SuppressWarnings("serial")
public class Condition implements Serializable{
	
	//逻辑运算符and 或者 or
	private String andOr;
	//列名称
	private String columnName;
	//比较运算符 =，<，>,！=.......
	private String opentor;
	//值：字符串，整数，浮点数.......
	private Object value;
	
	
	public Condition(String andOr, String columnName, String opentor,
			Object value) {
		this.andOr = andOr;
		this.columnName = columnName;
		this.opentor = opentor;
		this.value = value;
	}
	public String getAndOr() {
		return andOr;
	}
	public void setAndOr(String andOr) {
		this.andOr = andOr;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getOpentor() {
		return opentor;
	}
	public void setOpentor(String opentor) {
		this.opentor = opentor;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	

}
