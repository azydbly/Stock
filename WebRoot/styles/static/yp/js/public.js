$(function(){

    $(".textarea").Huitextarealength({
        minlength:1,
        maxlength:200.
    });

    $(".input-text,.textarea").Huifocusblur();

    //邮箱提示
    $("#email").emailsuggest();

})