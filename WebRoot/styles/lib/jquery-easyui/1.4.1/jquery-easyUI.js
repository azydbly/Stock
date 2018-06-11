/* 分配角色-对话框定义 */
function distribute_action_Fun(roleId){
	 $("#dd").dialog({  
	    title: "角色权限配置",
	    width: 350,    
	    height: 450,
	    position: "center",
	    closed: false,    
	    cache: false,
	  /*  minimizable: true,*/
        maximizable: true,
        /* resizable: true, */ //是否可以手动改变窗口大小。true 可以改变
	    href: "deploy.action?roleId=" + roleId,    
	    modal: true,
	    /*在状态栏上添加按钮，最小化左边*/
	   /* tools: [{
            iconCls: 'icon-add',
            handler: function () {
                alert('add');
            }
        }, {
            iconCls: 'icon-remove',
            handler: function () {
                alert('remove');
            }
        }],*/
	    /*最上面显示添加和保存*/
	   /*  toolbar: [{
            text: "添加",
            iconCls: 'icon-add',
            handler: function () {
                alert("add");
            }
        }, '-', {
            text: "保存",
            iconCls: "icon-save",
            handler: function () {
                alert("save");
            }
        }], */
	    buttons: [{
            text: "保存",
            iconCls: "icon-save",
            handler: function () {
	            var nodes = $('#tt').tree('getChecked');
				var nodes1 = $('#tt').tree('getChecked','indeterminate');
				var s = "";
				var ss = "";
				for(var i = 0; i < nodes.length; i++){
					if (s != ""){
						s += ',';
					}
					s += nodes[i].id;
				}
				for(var i = 0; i < nodes1.length; i++){
					if (ss != ''){
						ss += ',';
					}
					ss += nodes1[i].id;
				}
				if(s == "" && ss == ""){
					 layer.alert('请选择分配的权限！', {
					     closeBtn: 1,    // 是否显示关闭按钮
					     anim: 1, //动画类型
					     btn: ['确定'], //按钮
					     icon: 5,    // icon
					     })
				}else{
					/*$.post('savetree.action?roleId=' + roleid +'&menus=' + s + '&operationId='+ ss,'JSON');
		            $("#dd").dialog("close");*/
					$.ajax({                     
						 url:'savetree.action?roleId=' + roleid +'&menus=' + s + '&operationId='+ ss,                    
						 dataType:'json',                    
						 type:'post',                     
						 success:function(data){                         
							 if(data){
								 showSuccessMessage("授权成功！");
								 $("#dd").dialog("close");
							 }else{
								 showSuccessMessage("授权失败！");
							 }
						 }
					 })
				}
            }
        }, {
            text: "取消",
            iconCls: "icon-clear",
            handler: function () {
                $("#dd").dialog("close");
            }
        }]
	 });
}


//显示所选节点
function getChecked(){
	var nodes = $('#tt').tree('getChecked');
	var nodes1 = $('#tt').tree('getChecked','indeterminate');
	var s = '';
	for(var i = 0; i < nodes.length; i++){
		if (s != ''){
			s += ',';
		}
		s += nodes[i].id;
	}
	for(var i = 0; i < nodes1.length; i++){
		if (s != ''){
			s += ',';
		}
		s += nodes1[i].id;
	}
	alert(s);
}

function showSuccessMessage(message, successFn, endFn) {
	successFn = isExitsFunction(successFn) ? successFn : function() {};
	endFn = isExitsFunction(endFn) ? endFn : function() {};
	layer.alert(message, {
		icon: 6,
		title: '成功',
		time: 2000,
		shade: 0,
		btn: 0,
		succss:successFn,
		end: endFn,
		offset: ['40px', ($(window).width() - 300) + 'px']
	});
}
     