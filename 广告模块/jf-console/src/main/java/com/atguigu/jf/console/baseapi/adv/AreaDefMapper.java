package com.atguigu.jf.console.baseapi.adv;

import java.util.List;

import com.atguigu.jf.console.adv.bean.pojo.AreaDef;

public interface AreaDefMapper {
    int deleteByPrimaryKey(String areaId);

    int insert(AreaDef record);

    AreaDef selectByPrimaryKey(String areaId);

    List<AreaDef> selectAll();

    int updateByPrimaryKey(AreaDef record);

	List<AreaDef> getList();
}