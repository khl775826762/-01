package com.atguigu.jf.console.common.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.jf.console.common.bean.pojo.CodeValue;
import com.atguigu.jf.console.common.service.CommonService;

@Controller
@RequestMapping("common")
public class CommonController {
	
	@Autowired
	private CommonService commonService;
	/**
	 * @方法名: getCodeValue  
	 * @功能描述: 通用获取下拉框的数据
	 * @param codeType
	 * @return
	 * @throws Exception
	 * @作者  
	 * @日期 2016年11月7日
	 */
	@RequestMapping("getCodeValue")
	@ResponseBody
	public List<CodeValue> getCodeValue(String codeType) throws Exception{
		Map<String,Object> map=new HashMap<>();
		map.put("codeType", codeType);
		
		return commonService.selectCodeValueByType(map);
	}
}
