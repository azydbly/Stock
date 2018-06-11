<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/common/public.jsp" %>
<html>
<head>
<title>添加菜单</title>
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="form-member-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>菜单名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" id="menuname" name="menuname">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>上级菜单：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
					<select class="select" size="1" id="pid" name="pid">
						<option value="0">顶级菜单</option>
						<c:forEach items="${menuList }" var="menu">
							<option value="${menu.getId() }">${menu.getMenuname() }</option>
						</c:forEach>
					</select>
				</span>
			</div>
		</div>
		<div class="row cl" id="icon">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>菜单图标：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" readonly id="iconSelect" name="iconfont">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">URL：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" id="url" name="url">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">状态：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
					<select class="select" size="1" name="state" />
						<option value="1">启用</option>
						<option value="0">禁用</option>
					</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">备注：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" name="remark" />
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
				<button onClick="layerClose();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</article>

<div id="menuContent" class="menuContent">
	<ul id="tree" class="ztree"></ul>
</div>
<div id="iconContent" class="menuContent">
	<ul>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe616;">&#xe616;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe613;">&#xe613;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe620;">&#xe620;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe622;">&#xe622;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe60d;">&#xe60d;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe61d;">&#xe61d;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe62d;">&#xe62d;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe61a;">&#xe61a;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe62e;">&#xe62e;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe67f;">&#xe67f;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe616;">&#xe616;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe613;">&#xe613;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe60f;">&#xe60f;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe633;">&#xe633;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe634;">&#xe634;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe681;">&#xe681;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe636;">&#xe636;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe687;">&#xe687;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe637;">&#xe637;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe691;">&#xe691;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe692;">&#xe692;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe639;">&#xe639;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe623;">&#xe623;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe627;">&#xe627;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe6a5;">&#xe6a5;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe612;">&#xe612;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe685;">&#xe685;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe62b;">&#xe62b;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe62d;">&#xe62d;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe643;">&#xe643;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe6cc;">&#xe6cc;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe621;">&#xe621;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe61e;">&#xe61e;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe618;">&#xe618;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe61c;">&#xe61c;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe6cf;">&#xe6cf;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe654;">&#xe654;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe680;">&#xe680;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe72c;">&#xe72c;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe6c6;">&#xe6c6;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe6cc;">&#xe6cc;</i> </li>
		<li> <i class="icon Hui-iconfont" title="&amp;#xe6d3;">&#xe6d3;</i> </li>
	</ul>
</div>
<script type="text/javascript" src="${ctxsty}/static/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript" src="${ctxsty}/pageList/iconfont.js"></script>
<script type="text/javascript">
$("#form-member-add").validate({
		rules:{
			menuname:{
				required:true,
				  remote:{
                    url:"selMenu.action",
                    type:"post",
                    data: {
                    	menuname: function(){
                    		return $("#menuname").val();
                    	},
                    },
 					dataType: "html",
                    dataFilter: function(data, type) {
                        if (data == "true"){
                            return true;
                        }else{
                            return false;
                        }
                    }
                }
			},
			url:{
				  remote:{
                    url:"selUrl.action",
                    type:"post",
                    data: {
                    	url: function(){
                    		return $("#url").val();
                    	},
                    },
 					dataType: "html",
                    dataFilter: function(data, type) {
                        if (data == "true"){
                            return true;
                        }else{
                            return false;
                        }
                    }
                }
			},
			iconfont:{
				required:true,
			},
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			$(form).ajaxSubmit({
				type: "post",
				url: "insertMenu.action",
				data: $(form).serialize(),
				dataType: "json",
				success: function(data) {
					if(data.status == 200) {
						var message = '添加成功!';
						var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引,隐藏layer层和shade
						parent.$('#layui-layer'+index).css({'display':'none'});
	                    parent.$('#layui-layer-shade'+index).css({'display':'none'});
	                    parent.reloadTable(); //再刷新DT
						parent.showSuccessMessage(message, null, function() {
							parent.layer.close(index); //然后执行关闭     
						});
					} else {
						var message = '添加失败!';
						parent.showFailMessage(message);
					}
				},
				error: function(XMLHttpRequest, textStatus, errorThrown) {
					layer.alert(errorThrown + '服务器端异常', {
					     closeBtn: 1,    // 是否显示关闭按钮
					     anim: 1, //动画类型
					     btn: ['确定'], //按钮
					     icon: 5,    // icon
					     });
					return false;
				}
			});
		}
});
</script>
</body>
</html>