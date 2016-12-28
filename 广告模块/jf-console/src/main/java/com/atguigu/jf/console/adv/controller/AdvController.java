package com.atguigu.jf.console.adv.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.atguigu.jf.console.adv.bean.bo.IcAdvBean;
import com.atguigu.jf.console.adv.bean.pojo.AreaDef;
import com.atguigu.jf.console.adv.bean.pojo.IcAdv;
import com.atguigu.jf.console.adv.service.AdvService;
import com.atguigu.jf.console.adv.service.AreaService;
import com.atguigu.jf.console.common.bean.bo.ResultBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Controller
@RequestMapping("adv")
public class AdvController {
	
	@Autowired
	private AdvService advService;
	
	@Autowired
	private AreaService areaService;
	
	/**  
	 * @方法名: releaseAdv  
	 * @功能描述: 发布广告信息
	 * @param advId
	 * @作者  
	 * @日期 2016年11月12日
	*/ 
	@RequestMapping("releaseAdv")
	@ResponseBody
	public void releaseAdv(Long advId){
		advService.releaseAdv(advId);
		
	}
	
	
	/**  
	 * @方法名: updateAdvOrder  
	 * @功能描述: 调整顺序
	 * @param advId
	 * @param advOrder
	 * @param prevAdvId
	 * @param prevOrder
	 * @param nextAdvId
	 * @param nextOrder
	 * @作者  
	 * @日期 2016年11月12日
	*/ 
	@RequestMapping("updateAdvOrder")
	@ResponseBody
	public void updateAdvOrder(long advId,long advOrder,Long prevAdvId,Long prevOrder,Long nextAdvId,Long nextOrder){
		IcAdv adv1=new IcAdv();
		IcAdv adv2=new IcAdv();
		adv1.setAdvId(advId);
		adv2.setAdvOrder(advOrder);
		
		if(prevAdvId!=null&&prevOrder!=null){
			adv2.setAdvId(prevAdvId);
			adv1.setAdvOrder(prevOrder);
		}
		if(nextAdvId!=null&&nextOrder!=null){
			adv2.setAdvId(nextAdvId);
			adv1.setAdvOrder(nextOrder);
		}
		advService.updateIcAdv(adv1);
		advService.updateIcAdv(adv2);
	}
	
	/**  
	 * @方法名: modifyAdv  
	 * @功能描述: 更新信息
	 * @param icAdv
	 * @return
	 * @作者  
	 * @日期 2016年11月12日
	*/ 
	@RequestMapping("modifyAdv")
	@ResponseBody
	public ResultBean modifyAdv(IcAdv icAdv){
		ResultBean result=new ResultBean();
		try{
			advService.updateIcAdv(icAdv);
			Short advState = icAdv.getAdvState();
			if(advState==2){
				result.setMsg("修改成功");
			}else{
				result.setMsg("发布成功");
			}
			result.setResult(ResultBean.RESULT_SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			result.setMsg("保存失败");
			result.setResult(ResultBean.RESULT_FAILED);
		}
		return result;
	}
	
	@RequestMapping("deleteAdv")
	@ResponseBody
	public ResultBean deleteAdv(Long advId){
		ResultBean result =new ResultBean();
		try{
			advService.deleteAdv(advId);
			result.setResult(ResultBean.RESULT_SUCCESS);
			result.setMsg("删除成功");
		}catch(Exception e){
			e.printStackTrace();
			result.setResult(ResultBean.RESULT_FAILED);
			result.setMsg("删除失败");
		}
		return result;
	}
	
/*	@RequestMapping("addAdv")
	@ResponseBody //无返回值时也必须加ResponseBody注解,否则会发生adjax请求失败
	public void addAdv(IcAdv icAdv){
		ResultBean result=new ResultBean();
		try{
			advService.saveIcAdv(icAdv);
			result.setMsg("保存成功");
			result.setResult(ResultBean.RESULT_SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			result.setMsg("保存失败");
			result.setResult(ResultBean.RESULT_FAILED);
		}
	}*/
	/**  
	 * @方法名: addAdv  
	 * @功能描述: 新增adv
	 * @param icAdv
	 * @return
	 * @作者  
	 * @日期 2016年11月12日
	*/ 
	@RequestMapping("addAdv")
	@ResponseBody
	public ResultBean addAdv(IcAdv icAdv){
		ResultBean result=new ResultBean();
		try{
			advService.saveIcAdv(icAdv);
			if(icAdv.getAdvState().equals("2")){
				result.setMsg("保存成功");
			}else{
				result.setMsg("发布成功");
			}
			result.setResult(ResultBean.RESULT_SUCCESS);
		}catch(Exception e){
			e.printStackTrace();
			result.setMsg("保存失败");
			result.setResult(ResultBean.RESULT_FAILED);
		}
		return result;
	}
	
	
	@RequestMapping("addAdvPage")
	public String addAdvPage(String type,Long advId,Map<String,Object> map){
		if("modify".equals(type)){
			map.put("type", type);
			IcAdvBean icAdv=advService.getAdvById(advId);
			map.put("icAdv", icAdv);
		}else{
			map.put("type", "add");
		}
		return "pageManagement/addAdv";
	}

	/**  
	 * @方法名: selectIcAdvList  
	 * @功能描述: 带条件的查询
	 * @param icAdv
	 * @param page
	 * @param limit
	 * @return
	 * @作者  
	 * @日期 2016年11月12日
	*/ 
	@RequestMapping("selectIcAdvList")
	@ResponseBody
	public String selectIcAdvList(IcAdv icAdv,Integer page,Integer limit){
		
		Map<String,Object> map=new HashMap<>();
		
		map.put("page",page);
		map.put("limit",limit);
		
		if(icAdv!=null){
			if(icAdv.getAdvAreaId()!=null){
				map.put("advAreaId", icAdv.getAdvAreaId());
			}
			if(icAdv.getAdvName()!=""){
				map.put("advName", icAdv.getAdvName());
			}
			if(icAdv.getAdvPos()!=null){
				map.put("advPos", icAdv.getAdvPos());
			}
			if(icAdv.getAdvState()!=null){
				map.put("advState", icAdv.getAdvState());
			}
		}
		
		PageHelper.startPage(page,limit);
		List<IcAdvBean> list=advService.selectIcAdvList(map);
		PageInfo<IcAdvBean> pageInfo=new PageInfo<>(list);
		String jsonString = JSON.toJSONString(pageInfo,
				SerializerFeature.WriteMapNullValue
				,SerializerFeature.WriteNullStringAsEmpty
				,SerializerFeature.WriteDateUseDateFormat);
		return jsonString;
	}
	
	/**  
	 * @方法名: getAreaList  
	 * @功能描述: 获取所有区域信息
	 * @return
	 * @作者  
	 * @日期 2016年11月12日
	*/ 
	@RequestMapping("getAreaList")
	@ResponseBody
	public List<AreaDef> getAreaList(){
		List<AreaDef> list=areaService.getList();
		return list;
	}
	
	/**  
	 * @方法名: uploadFile  
	 * @功能描述: 上传文件
	 * @param uploadFile
	 * @param request
	 * @return
	 * @throws Exception
	 * @作者  
	 * @日期 2016年11月12日
	*/ 
	@RequestMapping("uploadFile")
	@ResponseBody
	public ResultBean uploadFile(MultipartFile uploadFile,HttpServletRequest request) throws Exception{
		ResultBean result=new ResultBean();
		String path="uploadFile/img";
		path=request.getRealPath(path); //获得"uploadFile/img"在系统中的实际路径
		File filePath=new File(path);
		if(!filePath.exists()){
			filePath.mkdirs();
		}
		File newFile=null;
		try {
			newFile=new File(path,uploadFile.getOriginalFilename());//根据图片原始图片名命名上传的图片
			uploadFile.transferTo(newFile);
		} catch (Exception e) {
			e.printStackTrace();
			result.setResult(ResultBean.RESULT_FAILED);
			result.setMsg("上传失败");
		}
		String imgPath="/uploadFile/img/"+newFile.getName();
		result.setResult(imgPath); //将图片路径返回,供页面回显
		result.setMsg("上传成功");
		return result;
	}
}
