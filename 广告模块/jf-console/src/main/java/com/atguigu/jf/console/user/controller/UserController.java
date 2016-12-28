package com.atguigu.jf.console.user.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.atguigu.jf.console.common.bean.bo.PageModel;
import com.atguigu.jf.console.common.bean.bo.ResultBean;
import com.atguigu.jf.console.user.bean.pojo.SysOp;
import com.atguigu.jf.console.user.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	
	Logger logger=Logger.getLogger(UserController.class);
	//private Logger logger=Logger.getLogger(LoginController.class);
	
	
	@RequestMapping("uploadFile")
	@ResponseBody
	public ResultBean uploadFile(MultipartFile uploadFile,HttpServletRequest request) throws Exception{
		ResultBean result=new ResultBean();
		String path="uploadFile";
		path=request.getRealPath(path);
		File filePath=new File(path);
		if(!filePath.exists()){
			filePath.mkdirs();
		}
		
		try {
			File newFile=new File(path,uploadFile.getOriginalFilename());
			uploadFile.transferTo(newFile);
		} catch (Exception e) {
			e.printStackTrace();
			result.setResult(ResultBean.RESULT_FAILED);
			result.setMsg("上传失败");
		}
		result.setResult(ResultBean.RESULT_SUCCESS);
		result.setMsg("上传成功");
		return result;
	}
	
	/*@RequestMapping("selectUserList")
	@ResponseBody
	public PageModel<SysOp> selectUserList(SysOp sysOp,Integer start,Integer limit,
			@RequestParam(value="opName",required=false)String opName) throws Exception{
		Map<String,Object> map=new HashMap<>();
		map.put("start", start);
		map.put("limit", limit);
		if(opName!=null && !opName.equals("")){
			System.out.println(opName);
			map.put("opName", opName);
		}
		List<SysOp> list=userService.selectSysOpList(map);
		
		Integer count=userService.selectSysOpListCount(map);
		PageModel<SysOp> pageModel=new PageModel<>();
		pageModel.setPageNum(start);
		pageModel.setPageSize(limit);
		pageModel.setTotal(count);
		pageModel.setRows(list);
		
		
		return pageModel;
	}*/
	@RequestMapping("selectUserList")
	@ResponseBody
	public String selectUserList(SysOp sysOp,Integer start,Integer limit,
			@RequestParam(value="opName",required=false)String opName,
			@RequestParam(value="opKind",required=false)Integer opKind) throws Exception{
		Map<String,Object> map=new HashMap<>();
		map.put("start", start);
		map.put("limit", limit);
		if(opName!=null && !opName.equals("")){
			System.out.println(opName);
			map.put("opName", opName);
			
		}
		if(opKind!=null){
			map.put("opKind",opKind);
		}
		List<SysOp> list=userService.selectSysOpList(map);
		
		Integer count=userService.selectSysOpListCount(map);
		PageModel<SysOp> pageModel=new PageModel<>();
		pageModel.setPageNum(start);
		pageModel.setPageSize(limit);
		pageModel.setTotal(count);
		pageModel.setRows(list);
		String jsonString = JSON.toJSONString(pageModel,
												SerializerFeature.WriteMapNullValue
												,SerializerFeature.WriteNullStringAsEmpty);
		
		return jsonString;
	}
/*	@RequestMapping("selectUserList")
	@ResponseBody
	public String selectUserList(SysOp sysOp,Integer start,Integer limit,
			@RequestParam(value="opName",required=false)String opName,
			@RequestParam(value="opKind",required=false)Integer opKind) throws Exception{
		Map<String,Object> map=new HashMap<>();
		map.put("start", start);
		map.put("limit", limit);
		if(opName!=null && !opName.equals("")){
			System.out.println(opName);
			map.put("opName", opName);
			
		}
		if(opKind!=null){
			map.put("opKind",opKind);
		}
		List<SysOp> list=userService.selectSysOpList(map);
		
		Integer count=userService.selectSysOpListCount(map);
		PageModel<SysOp> pageModel=new PageModel<>();
		pageModel.setPageNum(start);
		pageModel.setPageSize(limit);
		pageModel.setTotal(count);
		pageModel.setRows(list);
		String jsonString = JSON.toJSONString(pageModel,
				SerializerFeature.WriteMapNullValue
				,SerializerFeature.WriteNullStringAsEmpty);
		
		return jsonString;
	}
*/	
	@RequestMapping(value="deleteUser")
	@ResponseBody
	public ResultBean deleteUser(Long opId,HttpSession session)throws Exception{
		ResultBean result=new ResultBean();
		SysOp currentUser = (SysOp) session.getAttribute("currentUser");
		SysOp param=new SysOp();
		try{
			if(currentUser!=null){
				param.setModifier(currentUser.getOpId());
			}
			param.setOpId(opId);
			int num=userService.deleteSysOpById(param);
			if(num>0){
				result.setResult(ResultBean.RESULT_SUCCESS);
				result.setMsg("删除成功!");
				logger.debug("===========删除成功=============");
			}else{
				result.setResult(ResultBean.RESULT_FAILED);
				result.setMsg("删除失败，未找到对应用户!");
				logger.debug("===========删除失败=============");
			}
		 } catch (Exception e) {
		       //构造返回值
		       result.setResult(ResultBean.RESULT_FAILED);
		       result.setMsg("删除失败！");
		       logger.debug("===========删除失败=============");
		 }

		return result;
	}
	
	@RequestMapping(value="addUserPage",method=RequestMethod.GET)
	public String addUserPage(String type,Long opId,Map<String,Object> map)throws Exception{
		SysOp sysOp=null;
		if("modify".equals(type)){
			sysOp=userService.selectByPrimaryKey(opId);
			map.put("sysOp", sysOp);
			map.put("opId",opId);
		}
		map.put("type", type);
		
		return "user/addUser";
	}
	
	@RequestMapping(value="addUser",method=RequestMethod.POST)
	public String addUser(SysOp sysOp)throws Exception{
		userService.saveSysOp(sysOp);
		return "user/userMgnt";
	}
	
	@RequestMapping(value="modifyUser")
	public String updateUser(SysOp sysOp)throws Exception{
		int i=userService.updateByPrimaryKeySelective(sysOp);
		return "user/userMgnt";
	}
}


















