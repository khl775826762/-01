package com.atguigu.jf.console.baseapi.user;

import java.util.List;
import java.util.Map;

import com.atguigu.jf.console.user.bean.bo.SysFuncBean;
import com.atguigu.jf.console.user.bean.pojo.SysOp;

public interface SysOpMapper {


    /**
     * @方法名: selectSysOpByUnameAndPwd  
     * @功能描述: 根据用户名密码查询
     * @param sysOp
     * @return
     * @throws Exception
     * @作者  
     * @日期 2016年11月5日
     */
	SysOp selectSysOpByUnameAndPwd(SysOp sysOp);
	/**
     * @方法名: selectSysOpList  
     * @功能描述:查询列表
     * @param map
     * @return
     * @throws Exception
     * @作者  
     * @日期 2016年11月7日
     */
	List<SysOp> selectSysOpList(Map<String, Object> map);
	/**
     * @方法名: selectSysOpListCount  
     * @功能描述: 查询总数
     * @param map
     * @return
     * @throws Exception
     * @作者  
     * @日期 2016年11月7日
     */
	Integer selectSysOpListCount(Map<String, Object> map);
	
	/**  
	 * @方法名: saveSysOp  
	 * @功能描述: 保存用户
	 * @param sysOp
	 * @作者  
	 * @日期 2016年11月8日
	*/ 
	void saveSysOp(SysOp sysOp);
	/**
	 * @方法名: selectByPrimaryKey  
	 * @功能描述: 根据id查询用户对象
	 * @param opId
	 * @return
	 * @作者  
	 * @日期 2016年11月8日
	 */
	SysOp selectByPrimaryKey(Long opId);
	
	/**  
	 * @方法名: updateByPrimaryKeySelective  
	 * @功能描述: 更新指定用户的信息 
	 * @param sysOp
	 * @return
	 * @作者  
	 * @日期 2016年11月8日
	*/ 
	int updateByPrimaryKeySelective(SysOp sysOp);

	/**  
	 * @方法名: deleteSysOpById  
	 * @功能描述: 通过参数param中的id删除user对象
	 * @param param
	 * @return
	 * @作者  
	 * @日期 2016年11月9日
	*/ 
	int deleteSysOpById(SysOp param);

	/**  
	 * @方法名: getCredentialsByUserName  
	 * @功能描述: 通过用户名获取用户的密码
	 * @param principal 当前用户名
	 * @return
	 * @作者  
	 * @日期 2016年11月14日
	*/ 
	String getCredentialsByUserName(String principal);
	

    /**
     * @方法名: selectSysOpByUnameAndPwd  
     * @功能描述: 根据用户名查询对象
     * @param username
     * @return
     * @throws Exception
     * @作者  
     * @日期 2016年11月5日
     */
	SysOp selectSysOpByUname(String username);
}
