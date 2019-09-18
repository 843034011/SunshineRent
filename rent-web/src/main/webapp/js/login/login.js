// 定义手机号输入框的正则表达式
var reg = /^1[3456789]\d{9}$/

$("#login").click(function () {
    var telephone = $("#telephone").val()

    // 校验当前手机号是否正确
    if(reg.test(telephone) == false){
        $("#telephone").val("")
        $("#telephone").attr("placeholder","请输入正确的手机号")
        return
    }
    console.log($("#chb_agreement").is(":checked"))
    var password = $.md5($("#password").val())
    console.log(password)

    $.post({
        url:"/register/selectregisterbytelephone",
        data:"telephone=" + telephone,
        dataType:"json",
        success:function (data) {
            var confirm = data.data.regPassword
            console.log(confirm)

            if(password == confirm && $("#chb_agreement").is(":checked")){
                window.location.href="index.html"
            }
        },
        error:function () {
            alert("密码错误")
            $("#password").val("")
        }
    })
})