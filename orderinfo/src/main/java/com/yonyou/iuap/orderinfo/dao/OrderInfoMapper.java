package com.yonyou.iuap.orderinfo.dao;

import com.yonyou.iuap.baseservice.persistence.mybatis.mapper.GenericExMapper;
import com.yonyou.iuap.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.orderinfo.entity.OrderInfo;


@MyBatisRepository
public interface OrderInfoMapper extends GenericExMapper<OrderInfo> {


}

