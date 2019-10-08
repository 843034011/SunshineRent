var url = window.location.href;
var info = url.split("=")[1]

if (info == "unlogin") {
    $("#unlogin").text("还没登录，请先登录！！!")
}

// 定义手机号输入框的正则表达式
var reg = /^1[3456789]\d{9}$/

$("#login").click(function () {
    var telephone = $("#telephone").val()

    // 校验当前手机号是否正确
    if (reg.test(telephone) == false) {
        $("#telephone").val("")
        $("#telephone").attr("placeholder", "请输入正确的手机号")
        return
    }

    var password = $.md5($("#password").val())
    console.log(password)

    $.post({
        url: "/register/selectregister",
        data: "telephone=" + telephone + "&password=" + password,
        dataType: "json",
        success: function (data) {
            if(data.code == 0){

                $.cookie("id",data.data.regId,"Session")
                $.cookie("key",data.data.regUsername,"Session")
                console.log($.cookie("id"))
                console.log($.cookie("key"))

                alert(1)
                var href = $.cookie("header_href")

                if(href == undefined){
                    window.location.href = "/index.html"
                } else {
                    window.location.href = '/' + href.split("/")[1] +'';
                }

            } else {
                $("#telephone").val("")
                $("#telephone").attr("placeholder", "手机号或密码不正确，请重新输入！")
                $("#password").val("")
                $("#password").attr("placeholder", "手机号或密码不正确，请重新输入！")
            }
        },
        error: function () {
            alert("Ajax发送请求失败了！！！")
        }
    })
})