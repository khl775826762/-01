package com.atguigu.jf.console.login.controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.atguigu.jf.console.common.utils.VerifyCodeUtil;
import com.atguigu.jf.console.login.service.LoginService;
import com.atguigu.jf.console.user.bean.bo.SysFuncBean;
import com.atguigu.jf.console.user.bean.pojo.SysOp;

@Controller
@RequestMapping("loginController")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	private static final Logger logger=Logger.getLogger(LoginController.class);
	
	
	
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(@RequestParam("username")String username,String password,String verifyCode,HttpSession session,
			RedirectAttributes redirectAttributes) throws Exception{
		logger.debug("登录的参数为:"+username+"-----"+password+"-----"+verifyCode);
		String session_verifyCode=(String)session.getAttribute("verifyCode");
		
		if(!verifyCode.equals(session_verifyCode)){
			logger.debug("验证码不正确..");
			redirectAttributes.addFlashAttribute("errMsg","验证码不正确..");
			return "redirect:/login";
		}
		
		/*SysOp param=new SysOp();
		param.setLoginCode(username);
		param.setLoginPasswd(password);
		
		SysOp sysOp=loginService.selectSysOpByUnameAndPwd(param);
		if(sysOp==null){
			logger.debug("用户名或密码不正确！");
			redirectAttributes.addFlashAttribute("errMsg", "用户名或密码不正确！");
			return "redirect:/login";
		}
		// 注意、在登陆成功之后。把用户的信息放在session中
		session.setAttribute("currentUser", sysOp);*/
		
		//获取当前登录用户
		Subject currentUser = SecurityUtils.getSubject();
		//判断是否经过了认证,即是否登录
		if(!currentUser.isAuthenticated()){
			UsernamePasswordToken token=new UsernamePasswordToken(username,password);
			token.setRememberMe(true);
			try{
				currentUser.login(token);
				SysOp sysOp=loginService.selectSysOpByUname(username);
				//在登陆成功之后。把用户的信息放在session中
				session.setAttribute("currentUser", sysOp);
			}catch(AuthenticationException ae){
				logger.info("****>  发生了异常：" + ae.getMessage());
				redirectAttributes.addFlashAttribute("errMsg","用户名密码不匹配..");
				return "redirect:/login";
			}
		}
		return "redirect:/index";
	}
	
	@RequestMapping("getVerifyCode")
	public void getVerifyCode(HttpServletResponse response,HttpSession session) throws IOException{
		/**
		 *   0）想办法禁用缓存
			  1）先使用VerifyCodeUtil工具类生成随机的4位数字
			  2）将生成的验证码放入session中
			  3）根据随机4位数字生成图片流
			  4）将图片流写入到输出流response.getOutputStream()
		 */
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		/*
		 * Parameters:
			type 验证码类型,参见本类的静态属性
			length 验证码长度,要求大于0的整数
			excludeString 需排除的特殊字符（无需排除则为null）
		 */
		String verifyCode = VerifyCodeUtil.generateTextCode(VerifyCodeUtil.TYPE_NUM_ONLY, 4, null);
		
		session.setAttribute("verifyCode", verifyCode);
		logger.debug("已将验证码放入到session中：【"+ verifyCode +"】");
		/*
		 * textCode 文本验证码
			width 图片宽度(注意此宽度若过小,容易造成验证码文本显示不全,如4个字符的文本可使用85到90的宽度)
			height 图片高度
			interLine 图片中干扰线的条数
			randomLocation 每个字符的高低位置是否随机
			backColor 图片颜色,若为null则表示采用随机颜色
			foreColor 字体颜色,若为null则表示采用随机颜色
			lineColor 干扰线颜色,若为null则表示采用随机颜色

		 */
		response.setContentType("image/jpeg");
		BufferedImage bufferedImage = VerifyCodeUtil.generateImageCode(verifyCode, 90, 30, 5, true, Color.WHITE, Color.BLACK, null);
		
		// 1、生成的图片流
		// 2、图片格式的定义
		// 3、输出流
		ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
	}
	
	@RequestMapping("getMenu")
	@ResponseBody
	public List<SysFuncBean> getMenu(HttpSession session) throws Exception{
		SysOp sysOp=(SysOp) session.getAttribute("currentUser");
//		Long opId=1l;
		Long opId=sysOp.getOpId();
		
		Map<String,Object> map=new HashMap<>();
		map.put("opId", opId);
		List<SysFuncBean> list=loginService.selectSysFuncByOpId(map);
		List<SysFuncBean> newList=new ArrayList<>();
		
		for(int i=0;i<list.size();i++){
			SysFuncBean parent=list.get(i);
			if(list.get(i).getFuncLevel().equals(new Short("1"))){
				List<SysFuncBean> childList=new ArrayList<>();
				for(int j=0;j<list.size();j++){
					SysFuncBean child=list.get(j);
					if(parent.getFuncId().equals(child.getSupFuncId())){
						childList.add(child);
					}
				}
				parent.setChildren(childList);
				newList.add(parent);
			}
		}
		
		return newList;
	}
	
}
