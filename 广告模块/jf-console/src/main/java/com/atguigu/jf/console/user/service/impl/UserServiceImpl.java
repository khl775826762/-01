package com.atguigu.jf.console.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.jf.console.baseapi.user.SysOpMapper;
import com.atguigu.jf.console.user.bean.pojo.SysOp;
import com.atguigu.jf.console.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private SysOpMapper sysOpMapper;

	@Override
	public List<SysOp> selectSysOpList(Map<String, Object> map)
			throws Exception {
		return sysOpMapper.selectSysOpList(map);
	}

	@Override
	public Integer selectSysOpListCount(Map<String, Object> map)
			throws Exception {
		return sysOpMapper.selectSysOpListCount(map);
	}

	@Override
	public void saveSysOp(SysOp sysOp) {
		sysOpMapper.saveSysOp(sysOp);
	}

	@Override
	public SysOp selectByPrimaryKey(Long opId) {
		return sysOpMapper.selectByPrimaryKey(opId);
	}

	@Override
	public int updateByPrimaryKeySelective(SysOp sysOp) {
		return sysOpMapper.updateByPrimaryKeySelective(sysOp);
	}

	@Override
	public int deleteSysOpById(SysOp param) {
		return sysOpMapper.deleteSysOpById(param);
	}
	

}
