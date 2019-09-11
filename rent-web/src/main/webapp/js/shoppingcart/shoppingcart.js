// 将选择、全选的html设置为 ""
$(".choose-one-box").html("")
$(".choose-all").html("")

// 全选的click事件
$(".choose-all").click(function () {
    if($(".choose-all").html() == ""){
        $(".choose-all").html("<i class=\"icon-choose\"><img src=\"../img/shoppingcart/yes.png\" class=\"choosed\"></i>")
        $(".choose-one-box").html("<i class=\"icon-choose\"><img src=\"../img/shoppingcart/yes.png\" class=\"choosed\"></i>")
        $(".list").attr("choosed","1")
        $(".list").addClass("curr")
    } else {
        $(".choose-all").html("")
        $(".choose-one-box").html("")
        $(".list").attr("choosed","0")
        $(".list").removeClass("curr")
    }
})

// 选择的click事件
$(".choose-one-box").click(function () {
    if($(this).html() == ""){
        $(this).html("<i class=\"icon-choose\"><img src=\"../img/shoppingcart/yes.png\" class=\"choosed\"></i>")
        $(this).parent().parent().addClass("curr")
        $(this).parent().parent().attr("choosed","1")
        for (var i = 0 ; i < $(".choose-one-box").length; i ++){
            if($(".choose-one-box")[i].innerHTML == "<i class=\"icon-choose\"><img src=\"../img/shoppingcart/yes.png\" class=\"choosed\"></i>"){
                if(i == $(".choose-one-box").length - 1){
                    $(".choose-all").html("<i class=\"icon-choose\"><img src=\"../img/shoppingcart/yes.png\" class=\"choosed\"></i>")
                }
                continue
            }else {
                break
            }
        }
    } else {
        $(this).html("")
        $(".choose-all").html("")
        $(this).parent().parent().removeClass("curr")
        $(this).parent().parent().attr("choosed","0")
    }
})