package com.yonyou.iuap.helloworld.dao;

import com.yonyou.iuap.baseservice.persistence.mybatis.mapper.GenericExMapper;
import com.yonyou.iuap.helloworld.entity.Helloworld;
import com.yonyou.iuap.mybatis.anotation.MyBatisRepository;

@MyBatisRepository
public interface HelloworldMapper extends GenericExMapper<Helloworld> {

}
