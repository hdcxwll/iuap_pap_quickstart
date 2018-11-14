package com.yonyou.iuap.example.utils; import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.yonyou.iuap.base.utils.RestUtils;
import com.yonyou.iuap.persistence.vo.pub.BusinessException;
import com.yonyou.iuap.utils.PropertyUtil; 

public class CodeRuleUtil {   
	private static  Logger logger = LoggerFactory.getLogger(CodeRuleUtil.class);   
/**      * 获取编码规则 
     * 
用友云平台
 
8/ 11用友iuap官网 iuap.yonyoucloud.com  
     * @param billObjCode 编码对象 code 
     * @param pkAssign 分配关系 
     * @param entity      * @return      */     
	public static String getCode(String billObjCode,String pkAssign,Object entity){         
		String billvo = JSONObject.toJSONString(entity);         
		String getCodeUrl = PropertyUtil.getPropertyByKey("billcodeservice.base.url")+"/billcoderest/getBillCode";         
		Map<String,String> data = new HashMap<String,String>();         
		data.put("billObjCode",billObjCode);         
		data.put("pkAssign",pkAssign);         
		data.put("billVo",billvo);         
		JSONObject getBillCodeInfo = RestUtils.getInstance().doPost(getCodeUrl,data,JSONObject.class);         
		logger.debug(getBillCodeInfo.toJSONString());         
		String getFlag = getBillCodeInfo.getString("status");         
		String billCode = getBillCodeInfo.getString("billcode");         
		if ("failed".equalsIgnoreCase(getFlag)){             
			String errMsg = getBillCodeInfo.getString("msg");             
			logger.error("{billObjCode:" + billObjCode + ",pkAssign:" + pkAssign + ",billvo:" + billvo + "},错误信息:" + errMsg); 
            throw new BusinessException("获取编码规则发生错误",errMsg); 
        }         
		return billCode;     
     }     /**      * 回退单据号，以保证单据号连号的业务需要 
     *      * @param billObjCode      *            编码对象 code 
     * @param pkAssign      *            分配关系 
     * @param entity      * @param code 编码字段 用友云平台
 
9/ 11用友iuap官网 iuap.yonyoucloud.com  
     * @return      */     
	public static void returnCode(String billObjCode,String pkAssign,Object entity,String code){         
		String billVo = JSONObject.toJSONString(entity);         
		String returnUrl = PropertyUtil.getPropertyByKey("billcodeservice.base.url")+"/billcoderest/returnBillCode" ;         
		Map<String,String> data = new HashMap<String,String>();         
		data.put("billObjCode",billObjCode);         
		data.put("pkAssign",pkAssign);         
		data.put("billVo",billVo);         
		data.put("billCode",code);         
		JSONObject returnBillCodeInfo = RestUtils.getInstance().doPost(returnUrl,data,JSONObject.class);         
		logger.debug(returnBillCodeInfo.toJSONString());         
		String returnFlag = returnBillCodeInfo.getString("status");         
		if("failed".equalsIgnoreCase(returnFlag)){             
			String errMsg = returnBillCodeInfo.getString("msg");             
			logger.error("{billObjCode:" + billObjCode + ",pkAssign:" + pkAssign + ",billvo:" + billVo + "},错误信息:" + errMsg); 
            throw new BusinessException("返回单据号失败",errMsg); 
        }     
	} 
} 