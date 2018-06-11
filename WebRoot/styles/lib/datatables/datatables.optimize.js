/**
 * datatables优化
 */
$.extend($.fn.dataTable.defaults, {
	dom: 't<"dataTables_info"il>p',
	language: {
		"url": "styles/lib/datatables/datatables_language.json"
	},
	//pageLength:20, //定义初始的长度
	processing: true, //当datatable获取数据时候是否显示正在处理提示信息。
	showRowNumber:true,
	serverSide: true, //服务器处理分页
//	scrollY:690,
	responsive: {
		details: false
	},
	initComplete: function(settings) {
		var _$this = this;

		 //模糊查询事件
		$('#doSearch').bind('click', function(e) {
			_$this.api().ajax.reload();
		});
		$('#search').bind('keyup', function(e) {
			if(e.keyCode == 13 || (e.keyCode == 8 && (this.value.length == 0))) {
				_$this.api().ajax.reload();
			}
		});
	},
	drawCallback: drawCallbackDefault
});


/**
 * DT绘制完成默认回调函数
 * 单独写出来是方便二次定制
 * 
 * 默认回调函数功能：
 * 1.DT第一列checkbox初始化成icheck
 * 2.iCheck全选、取消多选、多选与单选双向关联
 * 3.选中的tr加上selected class
 * 
 * @param {Object} settings
 */
function drawCallbackDefault(settings, _$this) {
	_$this = (isExitsVariable('_$this') && _$this) ? _$this : this;
	selector = _$this.selector;
	$(selector + ' input').iCheck({
		checkboxClass: 'icheckbox_minimal-blue',
		increaseArea: '20%'
	});

	/**
	 * DT thead iCheck 点击事件
	 */
	$(selector + ' input[name=all]').on('ifChecked ifUnchecked', function(e) {
		$(this).closest('table').find('input[name=single]').each(function() {
			if(e.type == 'ifChecked') {
				$(this).iCheck('check');
				$(this).closest('tr').addClass('selected');
			} else {
				$(this).iCheck('uncheck');
				$(this).closest('tr').removeClass('selected');
			}
		});
	});

	/**
	 * DT tbody iCheck点击事件
	 */
	$(selector + ' input[name=single]').on('ifChecked ifUnchecked', function(e) {
		if(e.type == 'ifChecked') {
			$(this).iCheck('check');
			$(this).closest('tr').addClass('selected');
			//全选单选框的状态处理
			var selected = _$this.api().rows('.selected').data().length; //被选中的行数
			var recordsDisplay = _$this.api().page.info().recordsDisplay; //搜索条件过滤后的总行数
			var iDisplayStart = _$this.api().page.info().start; // 起始行数
			if(selected === _$this.api().page.len() || selected === recordsDisplay || selected === (recordsDisplay - iDisplayStart)) {
				$(selector + ' input[name=all]').iCheck('check');
			}
		} else {
			$(this).iCheck('uncheck');
			$(this).closest('tr').removeClass('selected');
			$(selector + ' input[name=all]').attr('checked', false);
			$(selector + ' input[name=all]').iCheck('update');
		}
	});

	/**
	 * 检测参数是否定义
	 * @param {Object} variableName
	 */
	function isExitsVariable(variableName) {
		try {
			if(typeof(variableName) == "undefined") {
				return false;
			} else {
				return true;
			}
		} catch(e) {}
		return false;
	}
}

/** 
 * 对Date的扩展，将 Date 转化为指定格式的String
 * 月(M)、日(d)、12小时(h)、24小时(H)、分(m)、秒(s)、周(E)、季度(q)可以用 1-2 个占位符 
 * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
 *eg: 
 * (new Date()).pattern("yyyy-MM-dd hh:mm:ss.S")==> 2006-07-02 08:09:04.423
 * (new Date()).pattern("yyyy-MM-dd E HH:mm:ss") ==> 2009-03-10 二 20:09:04      
 * (new Date()).pattern("yyyy-MM-dd EE hh:mm:ss") ==> 2009-03-10 周二 08:09:04      
 * (new Date()).pattern("yyyy-MM-dd EEE hh:mm:ss") ==> 2009-03-10 星期二 08:09:04      
 * (new Date()).pattern("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18      
 */
Date.prototype.pattern = function(fmt) {
	var o = {
		"M+": this.getMonth() + 1, //月份         
		"d+": this.getDate(), //日         
		"h+": this.getHours() % 12 == 0 ? 12 : this.getHours() % 12, //小时         
		"H+": this.getHours(), //小时         
		"m+": this.getMinutes(), //分         
		"s+": this.getSeconds(), //秒         
		"q+": Math.floor((this.getMonth() + 3) / 3), //季度         
		"S": this.getMilliseconds() //毫秒         
	};
	var week = {
		"0": "/u65e5",
		"1": "/u4e00",
		"2": "/u4e8c",
		"3": "/u4e09",
		"4": "/u56db",
		"5": "/u4e94",
		"6": "/u516d"
	};
	if(/(y+)/.test(fmt)) {
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	}
	if(/(E+)/.test(fmt)) {
		fmt = fmt.replace(RegExp.$1, ((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "/u661f/u671f" : "/u5468") : "") + week[this.getDay() + ""]);
	}
	for(var k in o) {
		if(new RegExp("(" + k + ")").test(fmt)) {
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
		}
	}
	return fmt;
}

// js数组拓展方法
Array.prototype.indexOf = function(val) {
	for(var i = 0; i < this.length; i++) {
		if(this[i] == val)
			return i;
	}
	return -1;
};
Array.prototype.remove = function(val) {
	var index = this.indexOf(val);
	if(index > -1) {
		this.splice(index, 1);
	}
};

/**
 * JS Map插件
 */
function HashMap() {
	// 私有变量
	var arr = {};
	// 增加
	this.put = function(key, value) {
			arr[key] = value;
		}
		// 查询
	this.get = function(key) {
			if(arr[key]) {
				return arr[key]
			} else {
				return null;
			}
		}
		// 删除
	this.remove = function(key) {
			// delete 是javascript中关键字 作用是删除类中的一些属性
			delete arr[key]
		}
		// 遍历
	this.eachMap = function(fn) {
			for(var key in arr) {
				fn(key, arr[key])
			}
		}
		//长度
	this.size = function() {
			var len = 0;
			for(var key in arr) {
				len++;
			}
			return len;
		}
		//key数组
	this.getKeyArray = function() {
			var keys = new Array();
			for(var key in arr) {
				keys.push(key);
			}
			return keys;
		}
		//Value数组
	this.getValueArray = function() {
			var values = new Array();
			for(var key in arr) {
				values.push(this.get(key));
			}
			return values;
		}
		//是否存在某个元素(值)
	this.isExitValue = function(value) {
			for(var key in arr) {
				if(this.get(key) == value) {
					return true;
				}
			}
			return false;
		}
		//是否存在某个元素(键)
	this.isExitKey = function(param) {
		for(var key in arr) {
			if(key == param) {
				return true;
			}
		}
		return false;
	}
};

/**
 * 
 * @param {Object} btns 操作按钮数组
 * @param {Object} id 实体ID
 * @param {Object} jsp jsp地址
 * @param {Object} otherParam 其它的参数
 * @param {Object} url ajax地址
 * @param {Object} fn 回调函数
 */
function getDTOperateBtn(btns, id, jsp, otherParam, url, fn) {
	var html = '';
	if(contains(btns, 'review')) {
		var icon, text;
		switch(otherParam) {
			case 0:
				icon = '&#xe637;';
				text = '审核';
				break;
			case 1:
				text = '重审';
				icon = '&#xe6dd;';
				break;
			case 3:
				text = '发布';
				icon = '&#xe603;';
				break;
			case 2:
				text = '撤回';
				icon = '&#xe6de;';
				break;

		}
		html += '&nbsp;<a title="' + text + '" href="javascript:;" onclick="review(' + id + ',' + otherParam + ')" style="text-decoration:none"><i class="Hui-iconfont">' + icon + '</i></a>&nbsp;';
	}
	if(contains(btns, 'newTabEdit')) {
		html += '&nbsp;<a data-title="编辑" href="javascript:;" _href="' + jsp + '?id=' + id + '" onclick="Hui_admin_tab(this)" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>&nbsp;';
	}
	if(contains(btns, 'edit')) {
		html += '&nbsp;<a title="编辑" href="javascript:;" onclick="edit(\'编辑\',\'' + jsp + '\',' + id + ',\'700\',\'480\')" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>&nbsp;';
	}
	if(contains(btns, 'reply')) {
		html += '&nbsp;<a title="回复" href="javascript:;" onclick="edit(\'回复\',\'' + jsp + '\',' + id + ',\'700\',\'480\')" style="text-decoration:none"><i class="Hui-iconfont">&#xe6c5;</i></a>&nbsp;';
	}
	if(contains(btns, 'download')) {
		html += '&nbsp;<a title="下载" href="javascript:;" onclick="downloadFile(' + id + ',\'' + otherParam + '\')" style="text-decoration:none"><i class="Hui-iconfont">&#xe641;</i></a>&nbsp;';
	}
	if(contains(btns, 'del')) {
		html += '&nbsp;<a title="删除" href="javascript:;" onclick="del([' + id + '],\'' + url + '\',' + fn + ')" style="text-decoration:none"><i class="Hui-iconfont">&#xe609;</i></a>&nbsp;';
	}
	return html;
}

/**
 * 元素obj时候存在于array中
 *
 * @param {Object} array
 * @param {Object} obj
 */
function contains(array, obj) {
	var i = array.length;
	while(i--) {
		if(array[i] === obj) {
			return true;
		}
	}
	return false;
}