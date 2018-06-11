//通过选择单选按钮显示上传组件
$(function(){
	$("#tr").hide();
	$("#tr2").hide();
	$('#again-1').on('ifChecked', function(event){  
		$("#tr").show(); 
    	$("#tr2").show(); 
	});
	$('#again-1').on('ifUnchecked',function(even){
		$('#tr').hide();    
    	$("#tr2").hide();
	}); 
});
