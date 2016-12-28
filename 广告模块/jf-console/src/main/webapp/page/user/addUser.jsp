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
    <title>添加积分供应商</title>
    <link href="<%=rootPath %>/res/extjs/resources/css/ext-all.css" rel="stylesheet" />
    <link href="<%=rootPath %>/theme/gray/css/base.css" rel="stylesheet" />
    <link href="<%=rootPath %>/theme/gray/css/ext/ext.css" rel="stylesheet" />
    <link href="<%=rootPath %>/theme/gray/css/main.css" rel="stylesheet" />
    <!-- 日期控件CSS -->
	<link rel="stylesheet" type="text/css" href="<%=rootPath %>/res/cui/app/datepicker/My97DatePicker/skinex/skinex.css" />
	<script type="text/javascript">
		var rootPath="<%=rootPath%>";
	</script>
	<script type="text/javascript" src="<%=rootPath %>/res/jquery/jquery-1.6.4.min.js"></script>
	<script type="text/javascript" src="<%=rootPath %>/res/jquery/plugins/jquery.ajaxfileupload.js"></script>
</head>

<body>
    <div class="asideR-cont">
        <div class="add-cnt">
            <ul class="add-lst">
            <form action="" method="post" id="fbean">
           		 <input type="hidden" id="type" name="type" value="${type }">
                 <input type="hidden" id="opId" name="opId" value="${opId}">
                <li>
                    <label class="lbl-txt">操作员类型：</label>
                    <span class="query-item">
                        <div class="combo" id="opKindCombo"></div>
                    </span>
                    <span class="require">*</span>
                    <input type="hidden" id="opKind" name="opKind" value="${sysOp.opKind }">
                </li>
                <li>
                    <label class="lbl-txt">操作员名称：</label>
                    <input type="text" class="input-text ver-right" id="opName" name="opName" value="${sysOp.opName }" />
                    <span class="require">*</span>
                </li>
                <li>
                    <label class="lbl-txt">操作员编码：</label>
                    <input type="text" class="input-text ver-right" id="opCode" name="opCode" value="${sysOp.opCode }"/>
                    <span class="require">*</span>
                </li>
                <li>
                    <label class="lbl-txt">登录名：</label>
                    <input type="text" class="input-text ver-right" id="loginCode" name="loginCode" value="${sysOp.loginCode }" />
                    <span class="require">*</span>
                </li>
                <li>
                    <label class="lbl-txt">手机号：</label>
                    <input type="text" class="input-text ver-right" id="mobileNo" name="mobileNo" value="${sysOp.mobileNo }" />
                    <span class="require">*</span>
                </li>
                <li>
                    <label class="lbl-txt">电子邮件地址：</label>
                    <input type="text" class="input-text ver-right" id="emailAdress" name="emailAdress" value="${sysOp.emailAdress }" />
                    <span class="require">*</span>
                </li>
            </form>
                <li class="bot-line"></li>
                <li>
                    <label class="lbl-txt">用户图片：</label>
                    <div class="upload-box">
                        <input type="text" class="input-text" name="path" id="path"/>
                        <input type="file" id="uploadFile" name="uploadFile" class="file-upload" />
                        <span class="require">*</span>
                        <button class="browse-btn">浏览</button>
                    </div>  
                     <input type="button" class="upload-btn" name="uploadImg" id="uploadImg" onclick="upload();" value="上传"> 
                     <p style="color:red;margin-left:120px">建议上传图片选取400×300像素图片，大小在300K以下，以达到最佳显示效果。</p>
                </li>
                <li>
			    	<label class="lbl-txt"></label>
			     	<img src="" class="pro-img" id="img" style="display:none"/>
			   </li>
            </ul>
            <div class="form-aciton">
                <button class="submit-btn" id="saveUser" onclick="save();">保存</button>
                <button class="quit-btn" onclick="history.back();">取消</button>
            </div>
        </div>
    </div>
    <script src="<%=rootPath %>/res/extjs/ext-all.js"></script>
    <script src="<%=rootPath %>/res/extjs/ext-lang-zh_CN.js"></script>
    <script src="<%=rootPath %>/page/user/js/addUser.js"></script>
</body>

</html>