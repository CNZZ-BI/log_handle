package com.mvc.services;

import java.util.List;

import com.mvc.model.AdaCollectAccessLogModel;

public interface AdaCollectAccessLogService {
	
	/**
	 * 读取日志插入数据库־
	 * @param adaLogModel
	 * @return
	 */
	public void insert(AdaCollectAccessLogModel adaLogModel);
	
	/**
	 * 批量读取日志插入数据库־
	 * @param adaLogModel
	 * @return
	 */
	public void addTrainRecordBatch(List<AdaCollectAccessLogModel> adaLogList);

}
