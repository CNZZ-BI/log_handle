package com.mvc.mapper;

import java.util.List;
import java.util.Map;

public interface SysRegionMapper {
	
	/**
	 * ��ȡ����ID:countryID ��provinceID��cityID
	 * @return
	 */
	public List<Integer> getSysRegionID(String country,String province,String city);
	
	public List<Integer> getSysRegionID();

}
