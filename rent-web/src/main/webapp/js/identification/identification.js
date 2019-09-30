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

    for (var i = 0; i < imgs.length; i++) {
        console.log(imgs[i])
    }

    var file1 = $("#f")[0].files;
    var file2 = $("#b")[0].files;

    console.log(file1.length)
    console.log(file2.length)

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
            }
        })
    } else {
        alert("请按顺序上传全部图片！！！！")
    }
})

var imgUrl;

var preImgWidth = $("#cut").css("width");
var preImgheight = $("#cut").css("height");

var image = new Image();

$('#head').change(function() {
    var file = this.files[0];
    var reader = new FileReader();
    reader.onload = function() {
        // 通过 reader.result 来访问生成的 DataURL
        var url = reader.result;

        setImageURL(url);
    };
    reader.readAsDataURL(file);
});

function setImageURL(url) {

    // image.width = 600;
    // image.height = 400;
    image.src = url;
    image.id = "target";

    console.log(image.src)

    $("#img").append(image);

    var cut = document.getElementById("cut");
    var ctx = cut.getContext("2d");

    image.onload = function() {

        $('#target').Jcrop({
            onChange: updatePreview,
            onSelect: updatePreview,
        });

        //裁剪过程中，每改变裁剪大小执行该函数
        function updatePreview(c) {
            if(parseInt(c.w) > 0) {
                ctx.drawImage(image, c.x, c.y, c.w, c.h, 0, 0, parseInt(preImgWidth), parseInt(preImgheight));
                imgUrl = cut.toDataURL("image/png");//canvas画布转换为base64
                console.log(c.x, c.y, c.w, c.h);
            }
        };
    }
}