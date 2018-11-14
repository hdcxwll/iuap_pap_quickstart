package com.yonyou.iuap.orderinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.yonyou.iuap.baseservice.ref.service.RefCommonService;
import com.yonyou.iuap.baseservice.service.GenericExService;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.orderinfo.dao.OrderInfoMapper;
import com.yonyou.iuap.orderinfo.entity.OrderInfo;


@Service
public class OrderInfoService extends  GenericExService <OrderInfo>{

    @Autowired
    RefCommonService refCommonService;
    private OrderInfoMapper OrderInfoMapper;

    @Autowired
    public void setOrderInfoMapper(OrderInfoMapper OrderInfoMapper) {
        this.OrderInfoMapper = OrderInfoMapper;
        super.setIbatisMapperEx(OrderInfoMapper);
    }

    @Override
    public Page<OrderInfo> selectAllByPage(PageRequest pageRequest, SearchParams searchParams) {
        Page<OrderInfo> page = super.selectAllByPage(pageRequest, searchParams);
        refCommonService.fillListWithRef(page.getContent());
        return page;
     }
}
