<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/common/public.jsp" %>
<html>
<head>
<title>添加酒</title>
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="form-member-add">
        <input type="hidden" name="level" value="1" />
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" id="name" name="name">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>所属种类：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<span class="select-box">
					<select class="select" size="1" name="pid" style="color:black;">
						<option value="">--请选择--</option>
						<c:forEach items="${varietiesList }" var="varieties">
							<option value="${varieties.id }">${varieties.name}</option>
						</c:forEach>
					</select>
				</span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">描述：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <textarea type="text" class="input-text textarea" name="describe"></textarea>
            </div>
		</div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">每箱几瓶：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" name="boxNumber" />
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">每箱的进价：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" name="boxPurchasePrice" />
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">每箱的售价：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" name="boxPrice" />
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">起购箱数为批发：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" name="boxWholesaleNumber" />
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">批发每箱价格：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" name="boxWholesalePrice" />
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">每瓶进价：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" name="bottlePurchasePrice" />
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">每瓶售价：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" name="bottlePrice" />
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">起购瓶数为批发：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" name="bottleWholesaleNumber" />
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">批发每瓶价格：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" name="bottleWholesalePrice" />
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
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
				<button onClick="layerClose();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
			</div>
		</div>
	</form>
</article>

<script type="text/javascript" src="${ctxsty}/static/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript">
$("#form-member-add").validate({
	rules:{
		name:{
			required:true,
			remote:{
				url:"selVarieties.action",
				type:"post",
				data: {
                    name: function(){
						return $("#name").val();
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
	},
	onkeyup:false,
	focusCleanup:true,
	success:"valid",
	submitHandler:function(form){
		$(form).ajaxSubmit({
			type: "post",
			url: "insertAlcohol.action",
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