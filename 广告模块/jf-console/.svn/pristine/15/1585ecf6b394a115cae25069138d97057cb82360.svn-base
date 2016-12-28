<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String rootPath=request.getContextPath(); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="keyword" content="">
<title>登录</title>
<link href="<%=rootPath %>/theme/gray/css/base.css" rel="stylesheet" />
<link href="<%=rootPath %>/theme/gray/css/main.css" rel="stylesheet" />
<!-- extjs库 -->
<script type="text/javascript" src="<%=rootPath %>/res/extjs/ext-all.js"></script>
<script type="text/javascript" src="<%=rootPath %>/res/extjs/ext-lang-zh_CN.js"></script>
<!-- jQuery库 -->
<script type="text/javascript" src="<%=rootPath %>/res/jquery/jquery-1.6.4.min.js"></script>
<script type="text/javascript"
	src="<%=rootPath %>/res/jquery/plugins/jquery.tmpl.min.js"></script>
<script type="text/javascript">
	
	var errMsg="${errMsg}";
	if(errMsg!=""){
		alert(errMsg);
	}
	
	function checkForm(){
		var username=$("#userName").val();
		var passwd=$("#passwd").val();
		if(username==""){
			alert("请输入用户名");
			return false;
		}
		if(passwd==""){
			alert("请输入密码");
			return false;
		}
	}
	
	
	//验证码逻辑
	function reloadVerifyCode() {
		var imgSrc = $("#verifyCodeImage");
		var src = imgSrc.attr("src");
		imgSrc.attr("src", chgUrl(src));
	}
	function chgUrl(url) {
		var timestamp = (new Date()).valueOf();
		newurl = url + "?timestamp=" + timestamp;
		return newurl;
	}
</script>
</head>
<body class="lg-wrap">
	<div class="wrapper2">
		<form class="login-cnt" action="<%=rootPath %>/loginController/login" method="POST">
			<ul class="login">
				<li>
					<label class="login-tip">用户名</label> 
					<span class="login-ipt user-ico">
						<input type="text" name="username" id="userName" placeholder="请输入用户名" />
					</span>
				</li>
				<li>
					<label class="login-tip">密&nbsp;&nbsp;&nbsp;码</label> 
					<span class="login-ipt pwd-ico"> 
					<input type="password"
						name="password" id="passwd" placeholder="请输入密码" />
					</span>
				</li>
				<li>
					<label class="login-tip">验证码</label> 
					<span class="login-ipt code-ipt"> 
					<input type="text" name="verifyCode" id="verifyCode" />
					</span> 
					<img id="verifyCodeImage" class="verify-code" onclick="reloadVerifyCode()" src="<%=rootPath %>/loginController/getVerifyCode" /> 
					<em class="ver-turn" onclick="reloadVerifyCode()" title="换一张">换一张</em>
				</li>
				<li class="login-action">
					<input type="submit" class="login-btn"
					id="submitbutton" onclick="return checkForm()" value="登录" />
				</li>
			</ul>
		</form>
	</div>
</body>
</html>