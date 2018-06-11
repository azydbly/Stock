<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/layouts/common/public.jsp" %>
<%@ include file="/WEB-INF/layouts/common/publicList.jsp" %>
<html>
<head>
<title>系统管理</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont"></i> 首页 <span class="c-gray en">&gt;</span>系统管理 <span class="c-gray en">&gt;</span>菜单管理 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">
	<div class="cl pd-5 bg-1 bk-gray mt-20">
		<span class="l">
			<a href="javascript:;" onclick="delAll(getDTSelect(), 'delMenu.action', reloadTable)" class="btn btn-danger radius">
				<i class="Hui-iconfont">&#xe6e2;</i> 批量删除
			</a>
			<a href="javascript:;" onclick="add('添加菜单','selPid.action','893','400')" class="btn btn-primary radius">
				<i class="Hui-iconfont">&#xe600;</i> 添加菜单
			</a>
		</span>
		<div class="r">
			状态:
			<select id="state" style="width:80px; height:30px;">
				<option value="">--请选择--</option>
				<option value="1">启用</option>
				<option value="0">禁用</option>
			</select>&nbsp;&nbsp;
			菜单名称:<input type="text" class="input-text" style="width:200px" placeholder="菜单名称" id="search">&nbsp;&nbsp;
			<button type="submit" id="doSearch" class="btn btn-success radius"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
		</div>
	</div>
	<div class="mt-20">
		<table class="table table-border table-bordered table-hover table-bg table-sort" width="100%" >
			<thead>
				<tr class="text-c">
					<th class="list_a">序号</th>
					<th class="list_a">
						<input id="input-0" type="checkbox" name="all"><label for="input-0"></label>
					</th>
					<th class="list_c">菜单名称</th>
					<th>URL</th>
					<th class="list_b">状态</th>
					<th class="list_b">操作</th>
				</tr>
			</thead>
		</table>
	</div>
</div>
<script type="text/javascript" src="${ctxsty}/static/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript">
var datatable = null,idList=[];
$(function() {
	datatable = $('.table-sort').DataTable({
		"aoColumnDefs": [
		  {"bVisible": false, "aTargets": [0]} //控制列的隐藏显示
		],
		ajax: {
			url: "showPageMenu.action",
			type: 'post',
			data: function(d) {
				d.search = $('#search').val();
				d.state = $('#state').val();
			}
		},
		columns: [{
			data: null,
			orderable:false,
			render: function(data, type, row, meta) {
				var startIndex = meta.settings._iDisplayStart;  
                return startIndex + meta.row + 1;
			}  
		}, {
			data: "id",
			defaultContent: "",
			orderable:false,
			render: function(data, type, row, meta) {
				return '<input id="input-' + data + '" type="checkbox" name="single"><label for="input-' + data + '"></label>';
			}
		}, {
			data: "menuname",
			defaultContent: "",
		}, {
			data: "url",
			defaultContent: "",
		}, {
			data: "state",
			defaultContent: "",
			render: function(data, type, row, meta) {
				return '<span class="label label-' + clazz[data] + ' radius">' + text[data] + '</span>';
			}
		}, {
			data: "state",
			defaultContent: "",
			orderable:false,
			responsivePriority: 1,
			render: function(data, type, row, meta) {
				var a = "";
				a += '<a title="' + state[data] + '" style="text-decoration:none" onClick="changeStatus(' + "'" +  state[data] + "'" + ',[' + "'" + row.menuname + "'" + '],\'updMenuState.action\',' + row.id + ', '+ flag[data] + ')" href="javascript:;"><i class="Hui-iconfont">' + icon[data] + '</i></a>';
				a += '<a title="编辑" href="javascript:;" onclick="edit_show([' + "'" + row.menuname + "'" + '],\'selMenuById.action\',' + row.id + ',\'893\',\'400\')" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>';
				a += '<a title="删除" href="javascript:;" onclick="del([' + row.id + '],\'delMenu.action\',[' + "'" + row.menuname + "'" + '],reloadTable)" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6e2;</i></a>';
				return a;
			}
		}],
	});
	
	
	$('#state').on('change',function(){
		datatable.ajax.reload();
	});
});

function reloadTable() {
	datatable.ajax.reload(null, false);
}

function getDTSelect() {
	var lines = datatable.rows('.selected').data();
	for (var i = 0; i < lines.length; i++) {
		idList.push(lines[i].id);
	}
	return idList;
}
</script>
</body>
</html>