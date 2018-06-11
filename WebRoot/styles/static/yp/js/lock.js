//锁屏
function lockPage(){
	layer.open({
		title : false,
		type : 1,
		content : $("#lock-box"),
		closeBtn : 0,
		shade : 0.9
	})
}
$(".lockcms").on("click",function(){
	window.sessionStorage.setItem("lockcms",true);
	lockPage();
})
// 判断是否显示锁屏
if(window.sessionStorage.getItem("lockcms") == "true"){
	lockPage();
}
// 解锁
$("#unlock").on("click",function(){
	if($(this).siblings(".admin-header-lock-input").val() == ''){
		layer.msg("请输入解锁密码！");
	}else{
		if($(this).siblings(".admin-header-lock-input").val() == "123456"){
			window.sessionStorage.setItem("lockcms",false);
			$(this).siblings(".admin-header-lock-input").val('');
			layer.closeAll("page");
		}else{
			layer.msg("密码错误，请重新输入！");
		}
	}
});
$(document).on('keydown', function() {
	if(event.keyCode == 13) {
		$("#unlock").click();
	}
});
