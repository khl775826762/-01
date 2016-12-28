package com.atguigu.jf.console.adv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.jf.console.adv.bean.pojo.AreaDef;
import com.atguigu.jf.console.adv.service.AreaService;
import com.atguigu.jf.console.baseapi.adv.AreaDefMapper;

@Service
public class AreaServiceImpl implements AreaService{

	@Autowired
	private AreaDefMapper areaDefMapper;
	
	@Override
	public List<AreaDef> getList() {
		return areaDefMapper.getList();
	}

}
