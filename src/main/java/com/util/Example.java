package com.util;

import java.util.ArrayList;
import java.util.List;
/**
 * 查询条件封装总对象
 * @author 赵翔 
 * @lastModify 2016/10/13 17:10
 * @version
 */
public class Example {
	
	//组合条件查询的条件集合
	private List<Condition> conditions;
	
	//order by子句  
	private String orderByClause;
	
	//分页的limit后面第一个参数
	private int beginIndex=-1;
	
	//分页的limit后面第二个参数
	private int pageSize;
	
	
	public Example(String orderByClause,
			int beginIndex, int pageSize) {
		conditions=new ArrayList<Condition>();
		this.orderByClause = orderByClause;
		this.beginIndex = beginIndex;
		this.pageSize = pageSize;
	}
	
	public List<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}

	public String getOrderByClause() {
		return orderByClause;
	}
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}
	public int getBeginIndex() {
		return beginIndex;
	}
	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
