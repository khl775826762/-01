<%@page import="com.atguigu.jf.console.adv.bean.pojo.IcAdv"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/page/common/base.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keyword" content="">
    <title>添加广告位</title>
    <link href="res/extjs/resources/css/ext-all.css" rel="stylesheet" />
    <link href="theme/gray/css/base.css" rel="stylesheet" />
    <link href="theme/gray/css/ext/ext.css" rel="stylesheet" />
    <link href="theme/gray/css/main.css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="res/cui/app/datepicker/My97DatePicker/skinex/skinex.css" />
	<script type="text/javascript" src="res/jquery/jquery-1.6.4.min.js"></script>
	
	<script type="text/javascript">
		var rootPath="${pageContext.request.contextPath}"
		var startTime="${icAdv.advStartTime}";
		var endTime="${icAdv.advEndTime}";
	</script>
	<script type="text/javascript" src="res/jquery/plugins/jquery.ajaxfileupload.js"></script>
</head>

<body>
	<h1>添加广告信息</h1>
    <div class="asideR-cont">
        <div class="add-cnt">
            <ul class="add-lst">
            <form action="" method="post" id="fbean">
           		 <input type="hidden" id="type" name="type" value="${type }">
                 <input type="hidden" id="advId" name="advId" value="${icAdv.advId}">
                 <input type="hidden" id="advPic" name="advPic" value="${icAdv.advPic }">
                <li>
                    <label class="lbl-txt">广告位位置：</label>
                    <span class="require">*</span>
                    <label class="mr30">
                    <input  type="radio" id="" name="advPos" value="1" ${icAdv.advPos==1?'checked="checked"':''}>首页</label>
                    <input type="radio" id="" name="advPos" value="2" ${icAdv.advPos==2?'checked="checked"':''}>特价区
                </li>
                <li>
                    <label class="lbl-txt">区域：</label>
                    <span class="require">*</span>
                    <span class="query-item">
                        <div class="combo" id="advAreaCombo"></div>
                    </span>
                    <input type="hidden" id="advAreaId" name="advAreaId" value="${icAdv.advAreaId}">
                </li>
                <li>
                    <label class="lbl-txt">广告位名称：</label>
                    <span class="require">*</span>
                    <input type="text" class="input-text ver-right" id="" name="advName" value="${icAdv.advName}" />
                </li>
                <li>
                    <label class="lbl-txt">广告位超链地址：</label>
                    <span class="require">*</span>
                    <input type="text" class="input-text ver-right" id="" name="advUrl" value="${icAdv.advUrl}"/>
                </li>
                <li>
                    <label class="lbl-txt">广告位说明：</label>
                    <span class="require">*</span>
                    <input type="text" class="input-text ver-right" id="" name="advDesc" value="${icAdv.advDesc}" />
                </li>
                <li>
                    <label class="lbl-txt">播放开始时间：</label>
                        <span  class="require">*</span>
                    <span class="posR">
                        <input readonly="readonly" id="startDate" name="advStartTime" type="text" class="input-text">
                        <i class="cal-ico" id="timeStartBox"></i>
                    </span> -
                    <label class="lbl-txt">播放结束时间：</label>
                    <span class="posR">
                        <input readonly="readonly" id="endDate" name="advEndTime" type="text" class="input-text">
                        <i class="cal-ico" id="timeEndBox"></i>
                    </span>
                 </li>   
            </form>
                <li class="bot-line"></li>
                <li>
                    <label class="lbl-txt">广告图片：</label>
                    <span class="require">*</span>
                    <div class="upload-box">
                        <input type="text" class="input-text" name="path" id="path"/>
                        <input type="file" id="uploadFile" onchange="showPath()" name="uploadFile" class="file-upload" />
                        <button class="browse-btn">浏览</button>
                    </div>  
                     <input type="button" class="upload-btn" name="uploadImg" id="uploadImg" onclick="upload();" value="上传"> 
                     <p style="color:red;margin-left:120px">建议上传图片选取400×300像素图片，大小在300K以下，以达到最佳显示效果。</p>
			     	<img src="${icAdv.advPic }" class="pro-img" id="img" style="display:table-cell;"/>
                </li>
            </ul>
            <div class="form-aciton">
                <button class="submit-btn" id="" onclick="saveAdv('1');">发布</button>
                <button class="submit-btn" id="" onclick="saveAdv('2');">保存</button>
                <button class="quit-btn" onclick="history.back();">取消</button>
            </div>
        </div>
    </div>
    <script src="res/extjs/ext-all.js"></script>
    <script src="res/extjs/ext-lang-zh_CN.js"></script>
    <script src="page/pageManagement/js/addAdv.js"></script>
    
    <!-- 引用的资源中包含其他引用,不能使用base标签,否则二级引用会出错 -->
    <script src="${pageContext.request.contextPath }/res/cui/app/datepicker/My97DatePicker/WdatePicker.js"></script>
	<script src="${pageContext.request.contextPath }/res/cui/app/datepicker/js/dateField.js"></script>
</body>

</html>