<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/common/public.jsp" %>
<html>
<head>
    <title>个人信息</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>用户中心<span class="c-gray en">&gt;</span>个人信息
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a>
</nav>
<div class="page-container">
    <div class="Huialert Huialert-info mt-20"><i class="icon-remove"></i> 请更改完每个选项卡的信息进行保存，否则将保存失败</div>
    <form class="form form-horizontal" id="form-article-add" enctype="multipart/form-data">
        <div id="tab-system" class="HuiTab">
            <div class="tabBar cl">
                <span><i class="Hui-iconfont">&#xe60c;</i> 个人信息</span>
                <span><i class="Hui-iconfont">&#xe63f;</i> 修改密码</span>
                <span><i class="Hui-iconfont">&#xe642;</i> 更换头像</span>
            </div>
            <div class="tabCon">
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>登录账号：</label>
                    <div class="formControls col-xs-8 col-sm-9">
                        <input type="text" name="loginName" id="loginName" value="${employee.loginName }" class="input-text">
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>姓名：</label>
                    <div class="formControls col-xs-8 col-sm-9">
                        <input type="text" name="userName" readonly value="${employee.userName}" class="input-text">
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>身份证号：</label>
                    <div class="formControls col-xs-8 col-sm-9">
                        <input type="text" readonly value="${employee.idCard}" class="input-text">
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>手机：</label>
                    <div class="formControls col-xs-8 col-sm-9">
                        <input type="text" id="telphone" name="telphone" value="${employee.telphone}" class="input-text">
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>邮箱：</label>
                    <div class="formControls col-xs-8 col-sm-9">
                        <input type="text" id="email" name="email" value="${employee.email}" class="input-text">
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-2">备注：</label>
                    <div class="formControls col-xs-8 col-sm-9">
                        <textarea class="input-text textarea" name="remark">${employee.remark}</textarea>
                    </div>
                </div>
            </div>

            <input type="hidden" name="id" id="employeeNum" value="${employee.id}"/>
            <div class="tabCon">
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>原密码：</label>
                    <div class="formControls col-xs-8 col-sm-9">
                        <input type="password" class="input-text" id="oldPassword" name="oldpassword" />
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>新密码：</label>
                    <div class="formControls col-xs-8 col-sm-9">
                        <input type="password" id="onepassword" name="newpwd" class="input-text" />
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>新密码确认：</label>
                    <div class="formControls col-xs-8 col-sm-9">
                        <input type="password" class="input-text" id="twopassword" name="newPassword" />
                    </div>
                </div>
            </div>

            <div class="tabCon">
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-2"></label>
                    <div class="formControls col-xs-8 col-sm-9">
                        <div id="localImag">
                            <img id="preview" height="400" width="360"
                                 <c:if test="${employee.url == '' || employee.url == null }">src="${ctxsty}/static/h-ui/images/ucnter/avatar-default.jpg"</c:if>
                                 <c:if test="${employee.url != '' || employee.url != null }">src="showFaces.action"</c:if> />
                        </div>
                        <span class="btn-upload form-group">
							<input class="input-text upload-url" type="hidden" id="uploadfile" name="uploadfile" readonly nullmsg="请添加附件！" style="width:360px; margin-top: 2px;">
							<a href="javascript:void();" class="btn btn-primary radius upload-btn" style="width: 360px; margin-top: 2px;"><i class="Hui-iconfont">&#xe642;</i> 更改头像</a>
							<input type="file" name="file" id="fileImg" multiple class="input-file" onchange="javascript:setImagePreview();" />
						</span>
                    </div>
                </div>
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
                <button class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存</button>
            </div>
        </div>
    </form>
</div>
<script type="text/javascript" src="${ctxsty}/static/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript">
    $(function(){
        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
        });
        $("#tab-system").Huitab({
            index:0
        });
        $("#form-article-add").validate({
            rules:{
                loginName:{
                    required:true,
                    remote:{
                        url:"showLoginName.action",
                        type:"post",
                        data: {
                            oldPassword: function(){
                                return $("#oldPassword").val();
                            },
                            id: function(){
                                return $("#employeeNum").val();
                            }
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
                idcard:{
                    required:true,
                    isIdCardNo:true,
                },
                telphone:{
                    required:true,
                    isMobile:true,
                },
                email:{
                    required:true,
                    email:true,
                },
                oldpassword:{
                    required:true,
                    remote:{
                        url:"selPasswordById.action",
                        type:"post",
                        data: {
                            oldPassword: function(){
                                return $("#oldPassword").val();
                            },
                            id: function(){
                                return $("#employeeNum").val();
                            }
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
                newpwd:{
                    required:true,
                    rangelength:[6,15]
                },
                newPassword:{
                    required:true,
                    equalTo:"#onepassword" //判断两次输入的密码是否正确！
                },
            },
            messages:{
                oldpassword:{
                    remote:"密码错误",
                },
            },
            onkeyup:false,
            focusCleanup:true,
            success:"valid",
            submitHandler:function(form){
                $(form).ajaxSubmit({
                    type: 'post',
                    url: "${pageContext.request.contextPath}/updEmployeeById.action",
                    success: function(msg) {
                        if(msg == "passwordtrue"){
                            window.parent.location.href="${pageContext.request.contextPath}/";
                        }else if(msg == "true"){
                            //刷新头部显示头像的部分
                            var src = $("#showPictuer").attr("src");
                            $("#showPictuer").attr("src",src).ready();
                            window.location.reload();
                        }else if(msg == "false"){
                            $.Huimodalalert("不能两个选项卡一起修改信息，请逐一进行保存！",3000);
                        }else if(msg == "no"){
                            $.Huimodalalert("信息没有修改！",3000);
                        }
                    }
                });
            }
        });
    });

    //图片预览
    function setImagePreview() {
        var fileImg = document.getElementById("fileImg");
        var imgObjPreview = document.getElementById("preview");
        if (fileImg.files && fileImg.files[0]) {
            //火狐下，直接设img属性
            imgObjPreview.style.display = 'block';
            imgObjPreview.style.width = '360px';
            imgObjPreview.style.height = '400px';
            //imgObjPreview.src = fileImg.files[0].getAsDataURL();
            //火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
            imgObjPreview.src = window.URL.createObjectURL(fileImg.files[0]);
        } else {
            //IE下，使用滤镜
            fileImg.select();
            var imgSrc = document.selection.createRange().text;
            var localImagId = document.getElementById("localImag");
            //必须设置初始大小
            localImagId.style.width = "360px";
            localImagId.style.height = "400px";
            //图片异常的捕捉，防止用户修改后缀来伪造图片
            try {
                localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
                localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
            } catch (e) {
                alert("您上传的图片格式不正确，请重新选择!");
                return false;
            }
            imgObjPreview.style.display = 'none';
            document.selection.empty();
        }
        return true;
    }
</script>
</body>
</html>
