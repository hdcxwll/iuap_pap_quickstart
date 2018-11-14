package com.yonyou.iuap.happynewyear.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yonyou.iuap.baseservice.service.GenericExService;
import com.yonyou.iuap.happynewyear.dao.HappyNewYearMapper;
import com.yonyou.iuap.happynewyear.entity.HappyNewYear;
@Service
public class HappyNewYearService extends GenericExService<HappyNewYear> {
	private HappyNewYearMapper HappyNewYearMapper;

	@Autowired
	public void setHappyNewYearMapper(HappyNewYearMapper happyNewYearMapper) {
		this.HappyNewYearMapper = happyNewYearMapper;
		super.setIbatisMapperEx(happyNewYearMapper);
	}
	
	
}
