<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/common/public.jsp" %>
<html>
<head>
<title>用户查看</title>
</head>
<body>
<div class="cl pd-20" style="background-color:#5bacb6">
	<c:if test="${user.url == null || user.url == '' }">
		<img class="avatar size-XL l" src="${pageContext.request.contextPath}/styles/images/face.jpg">
	</c:if>
	<c:if test="${user.url != null && user.url != '' }">
		<img class="avatar size-XL l" src="showFaces.action" />
	</c:if>
	<dl style="margin-left:80px; color:#fff">
		<dt>
			<span class="f-18">${user.userName }</span>
			<span class="pl-10 f-12">年龄：40</span>
		</dt>
		<dd class="pt-10 f-12" style="margin-left:0">这家伙很懒，什么也没有留下</dd>
	</dl>
</div>
<div class="pd-20">
	<table class="table">
		<tbody>
			<tr>
				<th class="text-r">登录账号：</th>
				<td>${user.loginName }</td>
			</tr>
			<tr>
				<th class="text-r">身份证：</th>
				<td>${user.idCard }</td>
			</tr>
			<tr>
				<th class="text-r">联系电话：</th>
				<td>${user.telphone }</td>
			</tr>
			<tr>
				<th class="text-r">邮箱：</th>
				<td>${user.email }</td>
			</tr>
			<tr>
				<th class="text-r">联系地址：</th>
				<td>${user.address }</td>
			</tr>
		</tbody>
	</table>
</div>
<script type="text/javascript" src="${ctxsty}/static/h-ui.admin/js/H-ui.admin.js"></script>
</body>
</html>