package com.yonyou.iuap.helloworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yonyou.iuap.baseservice.service.GenericExService;
import com.yonyou.iuap.helloworld.dao.HelloworldMapper;
import com.yonyou.iuap.helloworld.entity.Helloworld;

@Service
public class HelloworldService extends GenericExService<Helloworld> {
	
	private HelloworldMapper hellowordMapper;

	@Autowired
	public void setHellowordMapper(HelloworldMapper hellowordMapper) {
		this.hellowordMapper = hellowordMapper;
		super.setIbatisMapperEx(hellowordMapper);
	}
	
}
