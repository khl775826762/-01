package com.atguigu.jf.console.baseapi.adv;

import java.util.List;
import java.util.Map;

import com.atguigu.jf.console.adv.bean.bo.IcAdvBean;
import com.atguigu.jf.console.adv.bean.pojo.IcAdv;

public interface IcAdvMapper {
    int deleteByPrimaryKey(Long advId);

    int insert(IcAdv record);

    IcAdv selectByPrimaryKey(Long advId);

    List<IcAdv> selectAll();

    int updateByPrimaryKey(IcAdv record);
    /**  
	 * @方法名: selectIcAdvList  
	 * @功能描述: 根据条件查询IcAdv的集合
	 * @param map
	 * @return
	 * @作者  
	 * @日期 2016年11月10日
	*/ 
	List<IcAdvBean> selectIcAdvList(Map<String, Object> map);
	/**
	 * @方法名: deleteIcAdv  
	 * @功能描述: 将adv对象的dataState属性设置为0
	 * @param advId
	 * @作者  
	 * @日期 2016年11月11日
	 */
	void deleteIcAdv(Long advId);
	
	IcAdvBean getAdvById(Long advId);

	void updateIcAdv(IcAdv icAdv);

	void releaseAdv(Long advId);

}