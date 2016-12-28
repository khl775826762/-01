package com.atguigu.jf.console.user.service;

import java.util.List;
import java.util.Map;

import com.atguigu.jf.console.user.bean.pojo.SysOp;

/** 
 * @包名 com.atguigu.jf.console.user.service
 * @类名 UserService.java
 * @作者  
 * @创建日期 2016年11月8日
 * @描述 
 * @版本 V 1.0
 */
public interface UserService {

	/**
	 * @方法名: selectSysOpList  
	 * @功能描述:查询列表
	 * @param map
	 * @return
	 * @作者  
	 * @日期 2016年11月7日
	 */
	public List<SysOp> selectSysOpList(Map<String,Object> map) throws Exception;
	
	/**
	 * @方法名: selectSysOpListCount  
	 * @功能描述: 查询总数
	 * @param map
	 * @return
	 * @作者  
	 * @日期 2016年11月7日
	 */
	public Integer selectSysOpListCount(Map<String,Object> map) throws Exception;

	/**
	 * @方法名: saveSysOp  
	 * @功能描述:	保存用户
	 * @param sysOp
	 * @作者  
	 * @日期 2016年11月8日
	 */
	public void saveSysOp(SysOp sysOp);
	
	/**  
	 * @方法名: selectByPrimaryKey  
	 * @功能描述:	根据id查询用户对象
	 * @param opId
	 * @return
	 * @作者  
	 * @日期 2016年11月8日
	*/ 
	public SysOp selectByPrimaryKey(Long opId);

	/**  
	 * @方法名: updateByPrimaryKeySelective  
	 * @功能描述: 更新用户信息
	 * @param sysOp
	 * @return
	 * @作者  
	 * @日期 2016年11月8日
	*/ 
	public int updateByPrimaryKeySelective(SysOp sysOp);

	
	/**  
	 * @方法名: deleteSysOpById  
	 * @功能描述: 通过参数param中的id删除user对象
	 * @param param
	 * @return
	 * @作者  
	 * @日期 2016年11月9日
	*/ 
	public int deleteSysOpById(SysOp param); 
}
