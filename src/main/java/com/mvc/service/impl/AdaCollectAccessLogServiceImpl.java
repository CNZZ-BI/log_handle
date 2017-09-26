package com.mvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mvc.mapper.AdaCollectAccessLogMapper;
import com.mvc.model.AdaCollectAccessLogModel;
import com.mvc.services.AdaCollectAccessLogService;

@Service
public class AdaCollectAccessLogServiceImpl implements AdaCollectAccessLogService{
	
	@Autowired
	private AdaCollectAccessLogMapper acaMapper;

	/**
	 * 读取日志插入数据库־
	 * @param adaLogModel
	 * @return
	 */
	@Override
	public void insert(AdaCollectAccessLogModel adaLogModel) {
		acaMapper.insert(adaLogModel);
	}
	
	/**
	 * 批量读取日志插入数据库־
	 * @param adaLogModel
	 * @return
	 */
	public void addTrainRecordBatch(List<AdaCollectAccessLogModel> adaLogList) {
		acaMapper.addTrainRecordBatch(adaLogList);
	}

}
