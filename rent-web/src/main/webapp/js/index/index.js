$(".show-nav").find("li").click(function () {
    var small = $(this).find("img")[0].src;
    $(".first").find("img").attr("src",small);
    target.css("border","2px solid rgba(255,255,255,0)");
    target = $(this).css("border","2px solid rgb(0,200,190)");
});

//定时轮播
var index = 1;
var target = $(".show-nav").find("li").eq(index-1).css("border","2px solid rgb(0,200,190)");
setInterval(function(){
    index++;
    if(index>5){
        index=1;
    }
    $("#banImg").attr("src","img/index/images/banner0"+(index)+".jpg");
    // target =  $(".show-nav").find("li").eq(index-1)
    target.css("border","2px solid rgba(255,255,255,0)");
    target = $(".show-nav").find("li").eq(index-1).css("border","2px solid rgb(0,200,190)");
},5000);
