var imgs = []

function imgChange(e) {
    var reads = new FileReader();
    var f = $(e).get(0).files[0];
    var rep = /jpeg|png|gif|bmp/ig;

    var gstyle = f.type.split("/")[1];
    if (rep.test(gstyle)) {
        reads.readAsDataURL(f);
        var that = this;
        reads.onload = function (o) {
            if ($(e).attr("id") == "f") {
                imgs.push(this.result)
                $("#front").attr("src", this.result)
            } else if ($(e).attr("id") == "b") {
                imgs.push(this.result)
                $("#back").attr("src", this.result)
            } else if ($(e).attr("id") == "head"){
                imgs.push(this.result)
                $("#h").attr("src", this.result)
            }

        };
    } else {
        alert("图片格式不正确，请上传 jpeg|png|gif|bmp 格式的图片")
    }
}

var formData = new FormData();

$("#idcard-submit").click(function () {
    
    var file1 = $("#f")[0].files;
    var file2 = $("#b")[0].files;

    if (file1.length == 1 && file2.length == 1) {

        formData.append("front", file1[0])
        formData.append("back", file2[0])

        $.post({
            url: "/identification/idcard",
            data: formData,
            dataType: "json",
            cache: false,
            processData: false,
            contentType: false,
            success: function (data) {

                $("#idcard-submit").css("display", "none");
                $("#total-form").css("display", "block");

                if (data.code == 0) {
                    $("#realname").attr("value", data.data.realName)
                    $("#idcard").attr("value", data.data.idNumber)
                    $("#phone").attr("value", $.cookie("key"))

                    $("first-submit").css("display","none")
                    $("total-form").css("display","block")

                } else if (data.code == 1) {
                    alert(data.message)
                }

                formData.delete("front")
                formData.delete("back")
            }
        })
    } else {
        alert("请按顺序上传全部图片！！！！")
    }
})

function emailchange(){
    var emailreg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/
    if(emailreg.test($("#email").val()) == false){
        $("#con").css("display","block")
        $("#confirm").text("当前邮箱格式不正确！")
    } else {
        $("#con").css("display","none")
        $("#confirm").text("")
    }

}

$("#c").click(function () {

    if($("#nickname").val() != "" && $("#confirm").text() == ""){

        var headimg = $("#head")[0].files[0];

        formData.append("headimg",headimg)
        formData.append("realname",$("#realname").val())
        formData.append("idcard",$("#idcard").val())
        formData.append("phone",$("#phone").val())
        formData.append("nickname",$("#nickname").val())
        formData.append("email",$("#email").val())

        $.post({
            url: "/identification/update",
            data: formData,
            dataType: "json",
            cache: false,
            processData: false,
            contentType: false,
            success: function (data) {
                alert("成功了！！！")
                window.location.href = "../index.html"
                formData.delete("headimg")
                formData.delete("realname")
                formData.delete("idcard")
                formData.delete("phone")
                formData.delete("nickname")
                formData.delete("email")
            }
        })
    }else{
        alert("请完成必填项！！！")
    }
})
