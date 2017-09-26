package com.mvc.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mvc.mapper.SysRegionMapper;
import com.mvc.services.SysRegionService;

@Service
public class SysRegionServiceImpl implements SysRegionService{
	
	@SuppressWarnings("unused")
	@Autowired
	private SysRegionMapper srMapper;

	/**
	 * ��ȡ����ID:countryID ��provinceID��cityID
	 * @return
	 */
	public List<Integer> getSysRegionID(String country,String province,String city){
		return srMapper.getSysRegionID(country,province,city);
	}

}
