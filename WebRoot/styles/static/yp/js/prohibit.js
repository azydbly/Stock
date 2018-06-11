//关闭弹出来的窗口  layer
function layerClose(){
	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.close(index);
}


//禁止鼠标右键菜单和F12打开控制台看源码
/*document.oncontextmenu = function () { return false; };
document.onkeydown = function () {
	if (window.event && window.event.keyCode == 123) {       
		event.keyCode = 0;
		event.returnValue = false;
		return false;
	}
}; */
