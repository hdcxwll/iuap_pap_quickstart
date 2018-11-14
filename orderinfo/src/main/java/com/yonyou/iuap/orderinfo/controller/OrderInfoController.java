package com.yonyou.iuap.orderinfo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yonyou.iuap.baseservice.controller.GenericExController;
import com.yonyou.iuap.mvc.annotation.FrontModelExchange;
import com.yonyou.iuap.mvc.type.SearchParams;
import com.yonyou.iuap.orderinfo.entity.OrderInfo;
import com.yonyou.iuap.orderinfo.service.OrderInfoService;

@Controller
@RequestMapping(value = "/order_info")
public class OrderInfoController extends GenericExController<OrderInfo> {

	private Logger logger = LoggerFactory.getLogger(OrderInfoController.class);

	private OrderInfoService OrderInfoService;

	@Autowired
	public void setOrderInfoService(OrderInfoService OrderInfoService) {
		this.OrderInfoService = OrderInfoService;
		super.setService(OrderInfoService);
	}

	@Override
	public Object list(PageRequest pageRequest,
			@FrontModelExchange(modelType = OrderInfo.class) SearchParams searchParams) {
		return super.list(pageRequest, searchParams);
	}

}