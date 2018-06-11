<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/common/public.jsp" %>
<html>
<head>
<title>承德老酒库存平台</title>
<link rel="stylesheet" type="text/css" href="${ctxsty}/static/yp/css/lock.css" />
</head>
<body>
<header class="navbar-wrapper">
	<div class="navbar navbar-fixed-top">
		<div class="container-fluid cl">
			<a class="logo navbar-logo f-l mr-10 hidden-xs">承德老酒库存管理平台</a>
			<span class="logo navbar-slogan f-l mr-10 hidden-xs">V1.0</span>
			<a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
		<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
			<ul class="cl">
				<li>当前用户&nbsp;&nbsp;</li>
				<li class="dropDown dropDown_hover" id="showPictuer">
					<c:if test="${employee.url != null && employee.url != '' }">
						<img width="40px;" height="40px;" src="showFaces.action" class="round">
					</c:if>
					<c:if test="${employee.url == null || employee.url == '' }">
						<img width="40px;" height="40px;" class="round" src="${ctxsty}/images/welcome.gif">
					</c:if>
					<a href="#" class="dropDown_A">${sessionScope.employee.userName }<i class="Hui-iconfont">&#xe6d5;</i></a>
					<ul class="dropDown-menu menu radius box-shadow">
						<li class="personal">
							<a data-href="personal.action" data-title="个人信息" href="javascript:void(0)" <i class="Hui-iconfont">&#xe705;</i> 个人信息</a>
						</li>
						<li>
							<a href="javascript:;" onclick="member_quit(this)"><i class="Hui-iconfont">&#xe726;</i> 退出</a>
						</li>
					</ul>
				</li>
				<li id="Hui-skin" class="dropDown right dropDown_hover"><a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
					<ul class="dropDown-menu menu radius box-shadow">
						<li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
						<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
						<li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
						<li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
						<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
						<li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
					</ul>
				</li>
			</ul>
		</nav>
	</div>
</div>

</header>
<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">
		<dl id="menu-article">
			<c:if test="${empty subMenuList}">
				<script type="text/javascript">
				    $.Huimodalalert('该角色没有菜单权限！',3000);
				</script> 
			</c:if>
			<c:if test="${not empty subMenuList}">
				<c:forEach items="${subMenuList }" var="menu">
					<c:if test="${menu.pid == 0 }">
						<dt>
							<i class="Hui-iconfont">${menu.iconfont }</i> ${menu.menuname }<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
						</dt>
						<dd>
							<ul>
								<li>
									<c:forEach items="${subMenuList }" var="submenu">
										<c:if test="${submenu.pid == menu.id }">
											<c:if test="${submenu.target == 1 }">
												<a data-href="${submenu.url }" data-title="${submenu.menuname }" href="javascript:void(0)">${submenu.menuname }</a>
											</c:if>
											<c:if test="${submenu.target == 2 }">
												<a href="${submenu.url }" data-title="${submenu.menuname }" target="_blank">${submenu.menuname }</a>
											</c:if>
										</c:if>
									</c:forEach>
								</li>
							</ul>
						</dd>
					</c:if>
				</c:forEach>
			</c:if>
		</dl>
	</div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
	<div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
		<div class="Hui-tabNav-wp">
			<ul id="min_title_list" class="acrossTab cl">
				<li class="active">
					<span title="主页" data-href="welcome">主页</span> <em></em>
				</li>
			</ul>
		</div>
		<div class="Hui-tabNav-more btn-group">
			<a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;">
				<i class="Hui-iconfont">&#xe6d4;</i>
			</a>
			<a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;">
				<i class="Hui-iconfont">&#xe6d7;</i>
			</a>
		</div>
	</div>
	<div id="iframe_box" class="Hui-article">
		<div class="show_iframe">
			<div style="display:none" class="loading"></div>
			<iframe scrolling="yes" frameborder="0" src="welcome.action"></iframe>
		</div>
	</div>
</section>
<div class="contextMenu" id="Huiadminmenu">
	<ul>
		<li id="closethis">关闭当前 </li>
		<li id="closeall">关闭全部 </li>
	</ul>
</div>
<script type="text/javascript" src="${ctxsty}/static/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript" src="${ctxsty}/static/yp/js/lock.js" ></script> 
<script type="text/javascript">
$(function(){
	$("#min_title_list li").contextMenu('Huiadminmenu', {
		bindings: {
			'closethis': function(t) {
				console.log(t);
				if(t.find("i")){
					t.find("i").trigger("click");
				}		
			},
			'closeall': function(t) {
				layer.msg('没有更多的标签了！', {time: 2000, icon:5});

			},
		}
	});
});

/* 退出系统 */
function member_quit(obj){
	layer.confirm('确认要退出吗？',function(index){
		$.ajax({
			url: 'quit.action',
			type: 'POST',
			dataType: 'json',
			success:function(msg){
				if(msg){
					window.parent.location.href="${pageContext.request.contextPath}/login.jsp";
				}
			}
		});		
	});
}

$(document).on('keydown', function() {
	if(event.keyCode == 13) {
		$("#unlock").click();
	}
});

</script> 
</body>
</html>
