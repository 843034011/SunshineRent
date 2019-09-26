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

    if(file1.length == 1 && file2.length == 1){

        formData.append("front",file1[0])
        formData.append("back",file2[0])

        $.post({
            url: "/identification/idcard",
            data: formData,
            dataType: "json",
            cache:false,
            processData: false,
            contentType: false,
            success: function (data) {
                alert("成功了！！！！！！！！！！！！！！！！")
            }
        })
    } else {
        alert("请按顺序上传全部图片！！！！")
    }
})
















images = document.getElementsByClassName("img-head");
for (var i = 0; i < images.length; i++) {
    images[i].onclick = function (e) {
        var btn_info = document.getElementsByClassName("btn-default")
        btn_info[0].innerHTML = e.target.alt
        var headimage = document.getElementById("headimage")
        headimage.src = e.target.src
    }
}

