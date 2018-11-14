package com.yonyou.iuap.helloworld.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yonyou.iuap.baseservice.controller.GenericController;
import com.yonyou.iuap.helloworld.entity.Helloworld;
import com.yonyou.iuap.helloworld.service.HelloworldService;
import com.yonyou.iuap.mvc.type.SearchParams;

@Controller
@RequestMapping("/hello_world")
public class HelloworldController extends GenericController<Helloworld> {

	private HelloworldService service;

	@Autowired
	public void setService(HelloworldService service) {
		this.service = service;
		super.setService(service);
	}
	
	  @RequestMapping({"/bobtest"})
	  @ResponseBody
	  public Object bobtest(PageRequest pageRequest, SearchParams searchParams)
	  {
		
		System.out.print("hello");
		return null;
		
//	    Page page = this.service.selectAllByPage(pageRequest, searchParams);
	    
//	    Page page = new Page();
//	    Map map = new HashMap();
//	    map.put("data", page);
//	    return buildMapSuccess(map);
	  }
	
}
