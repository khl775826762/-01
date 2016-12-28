<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<base href="http://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keyword" content="">
    <title>首页</title>
    <link href="theme/gray/css/base.css" rel="stylesheet" />
    <link href="theme/gray/css/main.css" rel="stylesheet" />
</head>

<body class="main">
    <div class="default-cnt clearfix">
        <div class="change-skin">
            <i class="skin-ico"></i>
        </div>
        <div class="nav">
            <img src="theme/gray/images/logo.png" alt="小积快跑后台管理系统" />
            <ul id="menu" class="menu">
                 <!-- 通过js去拼装 -->
            </ul>
        </div>
        <!-- 右侧主内容 -->
        <div class="aside-rgt">
            <div class="aside-cnt">
                <div class="head-tit">
                    <h1 class="cnt-tit" id="cnt-title">标题提示</h1>
                    <div class="user-info">
                        <img src="theme/gray/images/po.jpg" class="portrait" />
                        <em class="user-xx">您好，<i><shiro:principal></shiro:principal></i></em>
                        <em class="logout"><a href="logout">注销</a></em>
                    </div>
                </div>
                <div class="">
                    <iframe src="demo/grid.html" frameborder="0" scrolling="no" height="2300px" width="100%" id="indexiframe"></iframe>
                </div>
            </div>
        </div>
        <!-- foot-->
        <div class="clearfix"></div>
        <div class="footer">
            <span>联系电话：xxxxxx</span>
            <span>传真号码：xxxxxx</span>
            <span>地址：xxxxxx</span>
            <span>版权：xxxxxx</span>
        </div>
    </div>
     <script src="res/jquery/jquery-1.6.4.min.js"></script>
    <script src="res/extjs/ext-all.js"></script>
    <script src="page/common/js/index_page.js"></script>
    <script src="page/index.js"></script>
</body>

</html>