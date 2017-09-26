package com.mvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mvc.mapper.AdaAdItemMapper;
import com.mvc.services.AdaAdItemService;

@Service
public class AdaAdItemServiceImpl implements AdaAdItemService{
	
	@SuppressWarnings("unused")
	@Autowired
	private AdaAdItemMapper srMapper;

	/**
	 * 通过referer获取站点ID
	 * @param  referer
	 * @return
	 */
	public int getAdaAdItemID(String referer) {
		return srMapper.getAdaAdItemID(referer);
	}

}
