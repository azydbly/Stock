<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/base.jsp" %>
<%@ include file="/WEB-INF/layouts/common/publicMeta.jsp" %>
<html>
<head>
    <title>欢迎使用承德老酒库存管理系统</title>
</head>
<link rel="Shortcut Icon" href="${ctxsty}/favicon/favicon.ico" />
<link rel="stylesheet" href="${ctxsty}/static/yp/css/SpecialEffect.css" />
<link rel="stylesheet" type="text/css" href="${ctxsty}/lib/Hui-iconfont/1.0.8/iconfont.css"/>
<body>
<div class="panel panel-secondary mt-5 hui-bounceinT">
    <div class="panel-header">德老酒库存管理系统 —— 价格查询
        <span style="float:right;">
            <a href="index.jsp" title="返回首页">
                <i style="color: #FFFFFF; font-size: 20px" class="Hui-iconfont">&#xe625;</i>
            </a>
        </span>
    </div>
    <div class="panel-body">
        <input name="queryname" />
    </div>
</div>
</body>
</html>
