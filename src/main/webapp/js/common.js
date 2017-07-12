//chechbox的事件
$(".piaochecked").on("click",function(){
    $(this).hasClass("on_check")? $(this).removeClass("on_check"):$(this).addClass("on_check");
    //或者这么写
    // $(this).toggleClass( "on_check" );
});

//页面倒计时
function timer(){
    var t=60;
    var times=setInterval(function(){
        $(".timer").html(t);
        t--;
        if(t===0){
            clearInterval(times);
        }
    },1000);
}





