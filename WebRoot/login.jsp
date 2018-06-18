<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/base.jsp" %>
<%@ include file="/WEB-INF/layouts/common/publicMeta.jsp" %>
<html>
<head>
<title>承德老酒库存系统</title>
<!-- ico 图标  -->
<link rel="Bookmark" href="${ctxsty}/favicon/favicon.ico" >
<link rel="Shortcut Icon" href="${ctxsty}/favicon/favicon.ico" />
<link rel="stylesheet" href="${ctxsty}/static/login/css/login1.css" />
<link rel="stylesheet" href="${ctxsty}/static/yp/css/SpecialEffect.css" />
<link rel="stylesheet" type="text/css" href="${ctxsty}/lib/Hui-iconfont/1.0.8/iconfont.css"/>
<script type="text/javascript" src="${ctxsty}/lib/jquery/1.9.1/jquery.min.js"></script>
<script src="${ctxsty}/static/login/particleground/js/jquery.particleground.min.js"></script>
<script src="${ctxsty}/static/login/js/login1.js"></script>
</head>
<body>
<form action="login.action" method="post">
	<div style="width: 50px; height: 50px; margin-top: 10px; margin-left: 10px;" id="text" class="hui-fadeinB">
		<a href="index.jsp" title="返回首页"><i style="color: #FFFFFF; font-size:30px;" class="Hui-iconfont">&#xe625;</i></a>
	</div>
	<dl class="admin_login hui-fadeinB">
		<dt>
			<strong>承德老酒库存系统</strong> <em>Chengde Old Wine System</em>
		</dt>
		<dd class="user_icon">
			<input type="text" name="loginName" placeholder="账号" class="login_txtbx" value="${loginName }" />
		</dd>
		<dd class="pwd_icon">
			<input type="password" name="loginPassword" placeholder="${messagePassword != null?messagePassword:'密码'}" class="login_txtbx" value="${loginPassword }" />
		</dd>
		<dd>
			<input type="submit" value="立即登陆" class="submit_btn" />
		</dd>
		<dd>
			<p>© 2017 某某有限公司 版权所有</p>
			<p>
				<span id="showsectime"></span>
			</p>
		</dd>
	</dl>
</form>
</body>
</html>
