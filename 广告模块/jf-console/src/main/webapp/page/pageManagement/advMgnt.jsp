<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/page/common/base.jsp" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var rootPath="${pageContext.request.contextPath}";
</script>
<link href="res/extjs/resources/css/ext-all.css" rel="stylesheet" />
<link href="theme/gray/css/base.css" rel="stylesheet" />
<link href="theme/gray/css/ext/ext.css" rel="stylesheet" />
<link href="theme/gray/css/main.css" rel="stylesheet" />
<script src="res/jquery/jquery-1.6.4.min.js"></script>
<script src="res/extjs/ext-all.js"></script>
<script src="res/extjs/ext-lang-zh_CN.js"></script>


</head>
<body>
	广告位管理
	<div class="asideR-cont">
        <div class="query-head clearfix">
            <span class="query-item mr20">
                <label class="query-txt">广告位状态</label>
                <div class="combo" id="advStateCombo"></div>
                <input type="hidden" id="advState" name="advState">
            </span>
            <span class="query-item mr20">
                <label class="query-txt">广告位位置</label>
                <div class="combo" id="advPosCombo"></div>
                <input type="hidden" id="advPos" name="advPos">
            </span>
            <br><br>
            <span class="query-item mr20">
                <label class="query-txt">区域</label>
                <div class="combo" id="advAreaCombo"></div>
                <input type="hidden" id="advAreaId" name="advAreaId">
            </span>
            <span class="query-item">
                   <input class="query-input" id="advName" name="advName" placeholder="请输入广告位名称" />
            </span>
            
            <span class="query-btns">
                 <button type="submit" class="btn-search" onclick="query()" title="查询"></button>
                 <button type="submit" class="btn-reset" title="重置" onclick="reset();"></button>
             </span>
             
        </div>
        <div class="grid-com com-line" id="queryGrid">
        </div>
    </div>
    <!-- 日期控件JS  -->
    <!-- 引用的资源中包含其他引用,不能使用base标签,否则二级引用会出错 -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/res/cui/app/datepicker/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/res/cui/app/datepicker/js/dateField.js"></script>
	<script type="text/javascript" src="page/pageManagement/js/advMgnt.js"></script>
</body>
</html>