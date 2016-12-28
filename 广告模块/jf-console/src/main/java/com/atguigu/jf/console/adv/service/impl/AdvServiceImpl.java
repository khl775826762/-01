package com.atguigu.jf.console.adv.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.jf.console.adv.bean.bo.IcAdvBean;
import com.atguigu.jf.console.adv.bean.pojo.IcAdv;
import com.atguigu.jf.console.adv.service.AdvService;
import com.atguigu.jf.console.baseapi.adv.IcAdvMapper;

@Service
public class AdvServiceImpl implements AdvService {

	@Autowired
	private IcAdvMapper icAdvMapper;
	
	@Override
	public List<IcAdvBean> selectIcAdvList(Map<String, Object> map) {
		return icAdvMapper.selectIcAdvList(map);
	}

	@Override
	public void saveIcAdv(IcAdv icAdv) {
		icAdvMapper.insert(icAdv);
	}

	@Override
	public void deleteAdv(Long advId) {
		icAdvMapper.deleteIcAdv(advId);
	}

	@Override
	public IcAdvBean getAdvById(Long advId) {
		return icAdvMapper.getAdvById(advId);
	}

	@Override
	public void updateIcAdv(IcAdv icAdv) {
		icAdvMapper.updateIcAdv(icAdv);
	}

	@Override
	public void releaseAdv(Long advId) {
		icAdvMapper.releaseAdv(advId);
	}

}
