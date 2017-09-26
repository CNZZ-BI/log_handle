package com.mvc.services;

import java.util.List;


public interface SysRegionService {
	
	/**
	 * ��ȡ����ID:countryID ��provinceID��cityID
	 * @return
	 */
	public List<Integer> getSysRegionID(String country,String province,String city);

}
