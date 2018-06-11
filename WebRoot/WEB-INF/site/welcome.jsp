<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/common/public.jsp" %>
<%@ page import="java.net.InetAddress"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${ctxsty}/static/h-ui.admin/css/welcome_consult.css" />
<script type="text/javascript" src="${ctxsty}/static/yp/jquery_cmhello.js"></script> 
<title>我的桌面</title>
</head>
<body>
<div class="page-container">
	<p class="f-20 text-success">欢迎使用承德老酒库存管理系统</p>
	<table class="table table-border table-bordered table-bg mt-20">
		<thead>
			<tr>
				<th colspan="2" scope="col">服务器信息</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td width="30%">服务器计算机名</td>
				<td>${pageContext.request.serverName}</td>
			</tr>
			<tr>
				<td>服务器IP地址</td>
				<td><%=InetAddress.getLocalHost().getHostAddress()%></td>
			</tr>
			<tr>
				<td>服务器域名</td>
				<td><%=System.getenv().get("USERDOMAIN")%></td>
			</tr>
			<tr>
				<td>服务器端口 </td>
				<td><%=request.getServerPort() %></td>
			</tr>
			<tr>
				<td>运行环境版本 </td>
				<td><%=System.getProperty("java.class.version")%></td>
			</tr>
			<tr>
				<td>服务器IIS版本 </td>
				<td>sdsd</td>
			</tr>
			<tr>
				<td>JDK路径</td>
				<td><%=System.getProperty("java.home")%></td>
			</tr>
			<tr>
				<td>Tomcat的地址 </td>
				<td><%=System.getProperty("user.dir")%></td>
			</tr>
			<tr>
				<td>服务器操作系统 </td>
				<td><%=System.getProperty("os.name")%></td>
			</tr>
			<tr>
				<td>操作系统架构 </td>
				<td><%=System.getProperty("os.arch")%></td>
			</tr>
			<tr>
				<td>操作系统版本</td>
				<td><%=System.getProperty("os.version")%></td>
			</tr>
			<tr>
				<td>系统所在文件夹 </td>
				<td>C:\WINDOWS\system32</td>
			</tr>
			<tr>
				<td>服务器脚本超时时间 </td>
				<td>30000秒</td>
			</tr>
			<tr>
				<td>服务器的语言种类 </td>
				<td>Chinese (People's Republic of China)</td>
			</tr>
			<tr>
				<td>服务器当前时间 </td>
				<td><fmt:formatDate value='<%=new java.util.Date()%>' pattern='yyyy-MM-dd HH:mm' /></td>
			</tr>
			<tr>
				<td>服务器IE版本 </td>
				<td>6.0000</td>
			</tr>
			<tr>
				<td>服务器上次启动到现在已运行 </td>
				<td>7210分钟</td>
			</tr>
			<tr>
				<td>逻辑驱动器 </td>
				<td>C:\D:\</td>
			</tr>
			<tr>
				<td>CPU 总数 </td>
				<td>4</td>
			</tr>
			<tr>
				<td>CPU 类型 </td>
				<td>x86 Family 6 Model 42 Stepping 1, GenuineIntel</td>
			</tr>
			<tr>
				<td>虚拟内存 </td>
				<td>5G</td>
			</tr>
			<tr>
				<td>当前程序占用内存 </td>
				<td>3.29M</td>
			</tr>
			<tr>
				<td>浏览器的版本号、类型</td>
				<td><%=request.getHeader("User-agent") %></td>
			</tr>
			<tr>
				<td>当前Session数量 </td>
				<td><%-- <%=session.count %> --%>500</td>
			</tr>
			<tr>
				<td>当前SessionID </td>
				<td><%=request.getSession().hashCode()%></td>
			</tr>
			<tr>
				<td>当前系统用户名 </td>
				<td><%=System.getProperty("user.name")%></td>
			</tr>
		</tbody>
	</table>

	<!--右侧悬浮菜单-->
	<div class="slide">
		<ul class="icon">
			<li class="up" title="↑ 返回顶部"></li>
			<li class="qq" title="QQ咨询"></li>
			<li class="tel" title="电话咨询"></li>
			<li class="wx" title="微信咨询"></li>
			<li class="down" title="↓ 移至底部"></li>
		</ul>
		<ul class="info">
			<li class="qq">
				<p>在线沟通，请点我<a href="http://wpa.qq.com/msgrd?v=3&uin=614749555&site=qq&menu=yes" target="_blank">在线咨询</a></p>
			</li>
			<li class="tel">
				<p>咨询热线：<br>188-1042-0654<br>客服qq：<br>614749555</p>
			</li>
			<li class="wx">
				<div class="img">
					<img src="${pageContext.request.contextPath}/styles/static/h-ui.admin/images/consult/614749555.png" />
				</div>
			</li>
		</ul>
	</div>
	<div id="btn" class="index_cy"></div>
</div>
	
<footer class="footer mt-20">
	<div class="container">
		<!-- <p>联系方式:
			<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=614749555&site=qq&menu=yes">
				<img border="0" src="http://wpa.qq.com/pa?p=2:614749555:51" alt="点击这里给我发消息" title="点击这里给我发消息"/>
			</a>
		</p> -->
		<p>维护信息：<a href="http://mt.sohu.com/learning/d20170509/139309213_157101.shtml" target="_blank">****有限公司</a></p>
	</div>
</footer>
<script type="text/javascript" src="${ctxsty}/static/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript">
$(function(){

	$('.slide .icon li').not('.up,.down').mouseenter(function(){
		$('.slide .info').addClass('hover');
		$('.slide .info li').hide();
		$('.slide .info li.'+$(this).attr('class')).show();//.slide .info li.qq
	});
	$('.slide').mouseleave(function(){
		$('.slide .info').removeClass('hover');
	});
	
	$('#btn').click(function(){
		$('.slide').toggle();
		if($(this).hasClass('index_cy')){
			$(this).removeClass('index_cy');
			$(this).addClass('index_cy2');
		}else{
			$(this).removeClass('index_cy2');
			$(this).addClass('index_cy');
		}
		
	});
});
</script>
</body>
</html>