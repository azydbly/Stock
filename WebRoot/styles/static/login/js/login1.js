$(function() {
	//粒子背景特效
	$('body').particleground({
		dotColor : '#5cbdaa',
		lineColor : '#5cbdaa'
	});
	//网站计时器
	showsectime();
})

/**
 * 网站计时器
 */
function NewDate(str) {
	str = str.split('-');
	var date = new Date();
	date.setUTCFullYear(str[0], str[1] - 1, str[2]);
	date.setUTCHours(0, 0, 0, 0);
	return date;
}
function showsectime() {
	var birthDay = NewDate("2017-11-11");
	var today = new Date();
	var timeold = today.getTime() - birthDay.getTime();

	var sectimeold = timeold / 1000
	var secondsold = Math.floor(sectimeold);
	var msPerDay = 24 * 60 * 60 * 1000;

	var e_daysold = timeold / msPerDay;
	var daysold = Math.floor(e_daysold);
	var e_hrsold = (daysold - e_daysold) * -24;
	var hrsold = Math.floor(e_hrsold);
	var e_minsold = (hrsold - e_hrsold) * -60;
	var minsold = Math.floor((hrsold - e_hrsold) * -60);

	var seconds = Math.floor((minsold - e_minsold) * -60).toString();
	document.getElementById("showsectime").innerHTML = "网站运行：" + daysold + "天" + hrsold + "小时" + minsold + "分" + seconds + "秒";
	setTimeout(showsectime, 1000);
}


/* 更换验证码 */
function changeCode(img){
	img.src="code.action?id= " + Math.random();
}

/**
 * 用户登录
 */
$(function() {
	$('.submit_btn').click(function() {
		var loginName = $("input[name='loginName']").val();
		if (loginName.length <= 0) {
			$("input[name='loginName']").attr("placeholder", "请输入帐号");
			return false;
		}
		var loginPassword = $("input[name='loginPassword']").val();
		if (loginPassword.length <= 0) {
			$("input[name='loginPassword']").attr("placeholder", "请输入密码");
			return false;
		}
		var registerCode = $("input[name='code']").val();
		if (registerCode.length <= 0) {
			$("input[name='code']").attr("placeholder", "输入验证码");
			return false;
		}
	})
});

/**
 * 回车登录实现
 */
$(document).keyup(function(event) {
	if (event.keyCode == 13) {
		$(".submit_btn").trigger("click");
	}
});