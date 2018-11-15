package com.yonyou.iuap.baseservice.controller;

import cn.hutool.core.util.StrUtil;
import com.yonyou.iuap.base.web.BaseController;
import com.yonyou.iuap.baseservice.entity.Model;
import com.yonyou.iuap.baseservice.service.GenericService;
import com.yonyou.iuap.mvc.constants.RequestStatusEnum;
import com.yonyou.iuap.mvc.type.JsonResponse;
import com.yonyou.iuap.mvc.type.SearchParams;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class GenericController<T extends Model> extends BaseController
{
  private Logger log = LoggerFactory.getLogger(GenericController.class);
  private GenericService<T> service;

  @RequestMapping({"/list"})
  @ResponseBody
  public Object list(PageRequest pageRequest, SearchParams searchParams)
  {
	  if(true)
	  {
		  System.out.println("=======");
		  System.out.println("left====");
		  
//		  JsonResponse jsonResp = buildError("msg", "返回测试", RequestStatusEnum.FAIL_FIELD);
//		  return jsonResp;
		  
		  Map map = new HashMap();
		  map.put("data", "aaabbbccc");
		  return buildMapSuccess(map);
		  
	  }
	  
    Page page = this.service.selectAllByPage(pageRequest, searchParams);
    Map map = new HashMap();
    map.put("data", page);
    return buildMapSuccess(map);
    
  }
  @RequestMapping({"/get"})
  @ResponseBody
  public Object get(PageRequest pageRequest, SearchParams searchParams) { String id = MapUtils.getString(searchParams.getSearchMap(), "id");
    if (id == null) {
      return buildSuccess();
    }
    if (StrUtil.isBlank(id)) {
      return buildError("msg", "主键id参数为空!", RequestStatusEnum.FAIL_FIELD);
    }
    Model entity = this.service.findById(id);
    return buildSuccess(entity); }

  @RequestMapping({"/save"})
  @ResponseBody
  public Object save(@RequestBody T entity) {
    JsonResponse jsonResp;
    try {
      this.service.save(entity);
      jsonResp = buildSuccess(entity);
    }
    catch (Exception exp)
    {
//      JsonResponse jsonResp;
      jsonResp = buildError("msg", exp.getMessage(), RequestStatusEnum.FAIL_FIELD);
    }
    return jsonResp;
  }
  @RequestMapping({"/saveBatch"})
  @ResponseBody
  public Object saveBatch(@RequestBody List<T> listData) { this.service.saveBatch(listData);
    return buildSuccess(); }

  @RequestMapping({"/delete"})
  @ResponseBody
  public Object delete(@RequestBody T entity, HttpServletRequest request, HttpServletResponse response) throws Exception {
    this.service.delete(entity);
    return super.buildSuccess();
  }
  @RequestMapping({"/deleteBatch"})
  @ResponseBody
  public Object deleteBatch(@RequestBody List<T> listData, HttpServletRequest request, HttpServletResponse response) throws Exception { this.service.deleteBatch(listData);
    return super.buildSuccess();
  }

  public void setService(GenericService<T> genericService)
  {
    this.service = genericService;
  }
}