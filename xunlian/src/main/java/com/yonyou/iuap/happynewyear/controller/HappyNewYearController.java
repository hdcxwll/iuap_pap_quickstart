package com.yonyou.iuap.happynewyear.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yonyou.iuap.baseservice.controller.GenericController;
import com.yonyou.iuap.happynewyear.entity.HappyNewYear;
import com.yonyou.iuap.happynewyear.service.HappyNewYearService;
import com.yonyou.iuap.mvc.type.SearchParams;
@Controller
@RequestMapping("/happy_newyear")
public class HappyNewYearController extends GenericController<HappyNewYear> {
	private Logger logger = LoggerFactory.getLogger(HappyNewYear.class);
	
	private HappyNewYearService service;
	
	@Autowired
	public void setService(HappyNewYearService service) {
		this.service = service;
		super.setService(service);
	}
	@RequestMapping({"/list"})
	@ResponseBody
	public Object list(PageRequest pageRequest, SearchParams searchParams){
//		System.out.print("hello");
//		return null;
		
		return super.list(pageRequest, searchParams);
		
//	    Page page = this.service.selectAllByPage(pageRequest, searchParams);
	    
//	    Page page = new Page();
//	    Map map = new HashMap();
//	    map.put("data", page);
//	    return buildMapSuccess(map);
	}
	  @RequestMapping({"/getListWithAttach"})
	  @ResponseBody
	  public Object getListWithAttach(PageRequest pageRequest, SearchParams searchParams)
	  {
		  if(true)
		  {
			  System.out.println("=======");
			  Map map = new HashMap();
			  map.put("data", "aaabbbccc");
			  return buildMapSuccess(map);
			  
		  }
		  
	    Page page = this.service.selectAllByPage(pageRequest, searchParams);
	    Map map = new HashMap();
	    map.put("data", page);
	    return buildMapSuccess(map);
	    
	  }
}
