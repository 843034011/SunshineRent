var telecode

// 定义手机号输入框的正则表达式
var reg = /^1[3456789]\d{9}$/

// 获取验证码的点击事件
$('#btn').click(function () {

    // 获取用户输入的手机号
    var telephone = $("#telephone").val()

    // 校验当前手机号是否正确
    if(reg.test(telephone) == false){
        $("#telephone").val("")
        $("#telephone").attr("placeholder","请输入正确的手机号")
        return
    }

    // 手机号正确，即将发送短信验证码
    // 手机号输入框失去输入功能
    $('#telephone').attr("disabled","disabled")

    $.post({
        url:"/shortmessage/send",
        data:"telephone=" + telephone,
        dataType:"json",
        success:function (data) {
            telecode = data.data
            alert(telecode)
        },
        error:function (data) {

        }
    })

    $('#btn').val("短信已发送。。")
    $('#btn').css("pointer-events","none")
})

$("#submit").click(function () {
    var telephone = $("#telephone").val()
    var password = $("#password").val()
    var confirm = $("#confirm-repassword").val()
    var code = $("#code").val()

    console.log(telephone)
    console.log(password)
    console.log(confirm)
    console.log(code)

    if(password.length >= 6 && password.length <=16 && confirm == password && code == telecode){
        alert("成功了！！")
        $.post({
            url:""
        })
    } else {
        $("#password").val("")
        $("#confirm-repassword").val("")
    }
})