package com.atguigu.jf.console.login.service;

import java.util.List;
import java.util.Map;

import com.atguigu.jf.console.user.bean.bo.SysFuncBean;
import com.atguigu.jf.console.user.bean.pojo.SysOp;

public interface LoginService {

	/**
     * @方法名: selectSysOpByUnameAndPwd  
     * @功能描述: 根据用户名密码查询
     * @param sysOp
     * @return
     * @throws Exception
     * @作者  
     * @日期 2016年11月5日
     */
    public SysOp selectSysOpByUnameAndPwd(SysOp sysOp) throws Exception;

    /**
     * @方法名: selectSysFuncByOpId  
     * @功能描述: 根据OP_ID查询菜单
     * @param map
     * @return
     * @作者  
     * @日期 2016年11月7日
     */
	public List<SysFuncBean> selectSysFuncByOpId(Map<String, Object> map) throws Exception;

	
	/**  
	 * @方法名: getCredentialsByUserName  
	 * @功能描述: 通过用户名获取用户的密码
	 * @param principal 当前用户名
	 * @return
	 * @作者  
	 * @日期 2016年11月14日
	*/ 
	public String getCredentialsByUserName(String principal);
	
	/**
     * @方法名: selectSysOpByUnameAndPwd  
     * @功能描述: 根据用户名查询用户对象
     * @param sysOp
     * @return
     * @throws Exception
     * @作者  
     * @日期 2016年11月5日
     */
	public SysOp selectSysOpByUname(String username);

}
