package com.atguigu.jf.console.baseapi.common;

import java.util.List;
import java.util.Map;

import com.atguigu.jf.console.common.bean.pojo.CodeValue;

public interface CodeValueMapper {

    /**
     * @方法名: selectCodeValueByType  
     * @功能描述: 查询codeValue
     * @param map
     * @return
     * @throws Exception
     * @作者  
     * @日期 2016年11月7日
     */
    public List<CodeValue> selectCodeValueByType(Map<String,Object> map) throws Exception;
}
