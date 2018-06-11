function getCityByProvince(){
    var province = $("#province").val();
    $.ajax({
        type: "post",
        url: "ajaxCity.action",
        data: "number=" + province,
        success: function(msg){
            $("#list").val(msg);
            var list = eval("("+msg+")");
            var html = "";

            if(list.length != 0){
                html += "<option value=''>选择城市</option>"
                for(var i = 0;i < list.length;i++){
                    html += "<option value='"+list[i].number+"'>"+list[i].name+"</option>";
                }
            }else{
                layer.alert('该省份下没有城市！', {
                    closeBtn: 1,    // 是否显示关闭按钮
                    anim: 1, //动画类型
                    btn: ['确定'], //按钮
                    icon: 5,    // icon
                });
                html += "<option value=''>选择城市</option>";
            }
            $("#city").html(html);
        }
    });
}

function getCountyByCity(){
    var city = $("#city").val();
    $.ajax({
        type: "post",
        url: "ajaxCounty.action",
        data: "number=" + city,
        success: function(msg){
            $("#list").val(msg);
            var list = eval("("+msg+")");
            var html = "";
            if(list.length != 0){
                html += "<option value=''>选择区县</option>";
                for(var i = 0;i < list.length;i++){
                    html += "<option value='"+list[i].number+"'>"+list[i].name+"</option>";
                }
            }else{
                layer.alert('该城市下没有区县！', {
                    closeBtn: 1,    // 是否显示关闭按钮
                    anim: 1, //动画类型
                    btn: ['确定'], //按钮
                    icon: 5,    // icon
                });
                html += "<option value=''>选择区县</option>";
            }
            $("#county").html(html);
        }
    });
}

function getTownByCounty(){
    var county = $("#county").val();
    $.ajax({
        type: "post",
        url: "ajaxTown.action",
        data: "number=" + county,
        success: function(msg){
            $("#list").val(msg);
            var list = eval("("+msg+")");
            var html = "";
            if(list.length != 0){
                html += "<option value=''>选择城镇</option>";
                for(var i = 0;i < list.length;i++){
                    html += "<option value='"+list[i].number+"'>"+list[i].name+"</option>";
                }
            }else{
                layer.alert('该区县下没有城镇！', {
                    closeBtn: 1,    // 是否显示关闭按钮
                    anim: 1, //动画类型
                    btn: ['确定'], //按钮
                    icon: 5,    // icon
                });
                html += "<option value=''>选择城镇</option>";
            }
            $("#town").html(html);
        }
    });
}


function getVillageByTown(){
    var town = $("#town").val();
    $.ajax({
        type: "post",
        url: "ajaxVillage.action",
        data: "number=" + town,
        success: function(msg){
            $("#list").val(msg);
            var list = eval("("+msg+")");
            var html = "";
            if(list.length != 0){
                html += "<option value=''>选择村庄</option>";
                for(var i = 0;i < list.length;i++){
                    html += "<option value='"+list[i].number+"'>"+list[i].name+"</option>";
                }
            }else{
                layer.alert('该城镇下下没有村庄！', {
                    closeBtn: 1,    // 是否显示关闭按钮
                    anim: 1, //动画类型
                    btn: ['确定'], //按钮
                    icon: 5,    // icon
                });
                html += "<option value=''>选择村庄</option>";
            }
            $("#village").html(html);
        }
    });
}