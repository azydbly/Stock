$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
});	
	

$("#pid").change(function(){
	var pid = $("#pid").val();
	if(pid == 0){
		$("#icon").show();
	}else{
		$("#icon").hide();
	}
});



//菜单图标
$('#iconSelect').on('focus', function() {
	var cityObj = $("#iconSelect");
	var cityOffset = $("#iconSelect").offset();
	$("#iconContent").css({
		left: cityOffset.left + "px",
		top: (cityOffset.top + cityObj.outerHeight()) + "px",
		display: "block",
		width: (cityObj.outerWidth() - 3) + "px"
	}).slideDown("fast");

	$("body").bind("mousedown", function() {
		if(!(event.target.id == "iconContent" || $(event.target).parents("#iconContent").length > 0)) {
			$("#iconContent").css({
				left: 0,
				top: 0,
				display: "none",
				width: 0
			}).fadeOut("fast");
		}
	});
});

$("#iconContent").on('click', 'i', function() {
	$("#iconSelect").val($(this).attr('title'));
	$("#iconContent").css({
		left: 0,
		top: 0,
		display: "none",
		width: 0
	}).fadeOut("fast");
});
