
package com.yonyou.iuap.orderinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yonyou.iuap.baseservice.attachment.service.GenericAtService;
import com.yonyou.iuap.orderinfo.dao.OrderInfoMapper;
import com.yonyou.iuap.orderinfo.entity.OrderInfo;

@Service
public class OrderInfoAttachmentService extends GenericAtService<OrderInfo>{

    private OrderInfoMapper OrderInfoMapper;

    @Autowired
    public void setOrderInfoMapper(OrderInfoMapper OrderInfoMapper) {
        this.OrderInfoMapper = OrderInfoMapper;
        super.setMapper(OrderInfoMapper);
    }

	@Override
	public OrderInfo saveWithAttachment(OrderInfo entity) {
		return super.saveWithAttachment(entity);
	}
}
