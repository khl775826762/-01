package com.atguigu.jf.console.adv.service;

import java.util.List;
import java.util.Map;

import com.atguigu.jf.console.adv.bean.bo.IcAdvBean;
import com.atguigu.jf.console.adv.bean.pojo.IcAdv;

public interface AdvService {
	
	
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
	 * @方法名: saveIcAdv  
	 * @功能描述: 保存传入的IcAdv对象
	 * @param icAdv
	 * @作者  
	 * @日期 2016年11月11日
	*/ 
	void saveIcAdv(IcAdv icAdv);
	
	/**  
	 * @方法名: deleteAdv  
	 * @功能描述: 根据id删除IcAdv对象
	 * @param advId
	 * @作者  
	 * @日期 2016年11月11日
	*/ 
	void deleteAdv(Long advId);
	
	/**  
	 * @方法名: getAdvById  
	 * @功能描述: 根据id获取adv
	 * @param advId
	 * @return
	 * @作者  
	 * @日期 2016年11月12日
	*/ 
	IcAdvBean getAdvById(Long advId);

	/**  
	 * @方法名: updateIcAdv  
	 * @功能描述: 更新指定adv
	 * @param icAdv
	 * @作者  
	 * @日期 2016年11月12日
	*/ 
	void updateIcAdv(IcAdv icAdv);

	/**  
	 * @方法名: releaseAdv  
	 * @功能描述: 发布广告信息
	 * @param advId
	 * @作者  
	 * @日期 2016年11月12日
	*/ 
	void releaseAdv(Long advId);

}
