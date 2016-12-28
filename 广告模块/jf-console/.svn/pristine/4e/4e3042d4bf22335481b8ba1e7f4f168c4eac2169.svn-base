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
    <title>列表</title>
    <link href="<%=rootPath %>/res/extjs/resources/css/ext-all.css" rel="stylesheet" />
    <link href="<%=rootPath %>/theme/gray/css/base.css" rel="stylesheet" />
    <link href="<%=rootPath %>/theme/gray/css/ext/ext.css" rel="stylesheet" />
    <link href="<%=rootPath %>/theme/gray/css/main.css" rel="stylesheet" />
    <!-- 日期控件CSS -->
	<link rel="stylesheet" type="text/css" href="<%=rootPath %>/res/cui/app/datepicker/My97DatePicker/skinex/skinex.css" />
	<script type="text/javascript">
		var rootPath="<%=rootPath %>";
	</script>
</head>

<body>
    <div class="asideR-cont">
        <div class="query-head clearfix">
            <span class="query-item mr20">
                <label class="query-txt">操作员类型</label>
                <div class="combo" id="opKindCombo"></div>
                <input type="hidden" id="opKind" name="opKind">
            </span>
            <span class="query-item">
                   <input class="query-input" id="opName" name="opName" placeholder="操作员名称" />
            </span>
            <span class="query-btns">
                 <button type="submit" class="btn-search" onclick="query()" title="查询"></button>
                 <button type="submit" class="btn-reset" title="重置"></button>
             </span>
        </div>
        <div class="grid-com com-line" id="queryGrid">
        </div>
    </div>
    <script src="<%=rootPath %>/res/jquery/jquery-1.6.4.min.js"></script>
    <script src="<%=rootPath %>/res/extjs/ext-all.js"></script>
    <script src="<%=rootPath %>/res/extjs/ext-lang-zh_CN.js"></script>
    <!-- 日期控件JS  -->
	<script type="text/javascript" src="<%=rootPath %>/res/cui/app/datepicker/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=rootPath %>/res/cui/app/datepicker/js/dateField.js"></script>
    <script src="<%=rootPath %>/page/user/js/userMgnt.js"></script>
</body>

</html>