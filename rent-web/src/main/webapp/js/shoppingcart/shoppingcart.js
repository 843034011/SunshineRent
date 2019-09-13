$(".choose-list").html("")

$(".choose-all").html("")

// 全选的click事件
$(".choose-all").click(function () {
    if ($(".choose-all").html() == "") {
        $(".choose-all").html("<i class=\"icon-choose\"><img src=\"../img/shoppingcart/yes.png\" class=\"choosed\"></i>")
        $(".choose-one-box").html("<i class=\"icon-choose\"><img src=\"../img/shoppingcart/yes.png\" class=\"choosed\"></i>")
        $(".list").attr("choosed", "1")
        $(".list").addClass("curr")
    } else {
        $(".choose-all").html("")
        $(".choose-one-box").html("")
        $(".list").attr("choosed", "0")
        $(".list").removeClass("curr")
    }
})

$.post({
    url: "/shoppingcart/selectall",
    dataType: "json",
    success: function (data) {
        $.each(data.data, function (index, value) {

            // 查找订单中的数量、租期

            var startTime = value.startTime.split("T")[0]
            var endTime = value.endTime.split("T")[0]

            console.log(startTime)
            console.log(endTime)

            if ((value.fieldId != null) && (value.goodsId == null)) {

                // 按Id查找场地图片、信息、押金、租金
                $.post({
                    url: "/shoppingcart/selectfieldbyid",
                    data: "id=" + value.fieldId,
                    dataType: "json",
                    success: function (data) {

                        // 将选择的html设置为 ""
                        $(".choose-one-box").html("")

                        // 选择的click事件
                        $(".choose-one-box").click(function () {
                            if ($(this).html() == "") {
                                $(this).html("<i class=\"icon-choose\"><img src=\"../img/shoppingcart/yes.png\" class=\"choosed\"></i>")
                                $(this).parent().parent().addClass("curr")
                                $(this).parent().parent().attr("choosed", "1")
                                for (var i = 0; i < $(".choose-one-box").length; i++) {
                                    if ($(".choose-one-box")[i].innerHTML == "<i class=\"icon-choose\"><img src=\"../img/shoppingcart/yes.png\" class=\"choosed\"></i>") {
                                        if (i == $(".choose-one-box").length - 1) {
                                            $(".choose-all").html("<i class=\"icon-choose\"><img src=\"../img/shoppingcart/yes.png\" class=\"choosed\"></i>")
                                        }
                                        continue
                                    } else {
                                        break
                                    }
                                }
                            } else {
                                $(this).html("")
                                $(".choose-all").html("")
                                $(this).parent().parent().removeClass("curr")
                                $(this).parent().parent().attr("choosed", "0")
                            }
                        })

                        $(".choose-list").append(
                            `
                                <li class="list" choosed="0" kind="field" num="${data.data.shoppingcartId}">
                                    <div class="col-md-2">
                                        <div class="choose-one-box text-left">
                    
                                        </div>
                                        <div>
                                            <a href="../fieldinfo.html?id=${data.data.shoppingcartId}">
                                                <img class="field_picture" src="${data.data.fieldPictures[0].fieldPicture}">
                                            </a>
                                        </div>
                                    </div>
                    
                                    <div class="col-md-2 text-left">
                                        <div class="info">
                                            <a href="../fieldinfo.html?id=${data.data.shoppingcartId}">【${data.data.fieldName}】${data.data.fieldInfo}</a> 
                                        </div>                                      
                                    </div>
                                    <div class="col-md-1 text-center">${data.data.fieldDeposit}</div>
                                    <div class="col-md-1 text-center">${data.data.fieldDayprice}/天</div>
                                    <div class="col-md-1 text-center"><input class="order-number" type="number" value="1" min="1" max="1" step="1"></div>
                                    <div class="col-md-2 text-center">租用日期</div>
                                    <div class="col-md-1 text-center">金额</div>
                                    <div class="col-md-2 text-center">
                                        <span onclick="deletethis()">删除</span>
                                    </div>
                                </li>
                            `
                        )

                        // 将选择的html设置为 ""
                        $(".choose-one-box").html("")

                        // 选择的click事件
                        $(".choose-one-box").click(function () {
                            if ($(this).html() == "") {
                                $(this).html("<i class=\"icon-choose\"><img src=\"../img/shoppingcart/yes.png\" class=\"choosed\"></i>")
                                $(this).parent().parent().addClass("curr")
                                $(this).parent().parent().attr("choosed", "1")
                                for (var i = 0; i < $(".choose-one-box").length; i++) {
                                    if ($(".choose-one-box")[i].innerHTML == "<i class=\"icon-choose\"><img src=\"../img/shoppingcart/yes.png\" class=\"choosed\"></i>") {
                                        if (i == $(".choose-one-box").length - 1) {
                                            $(".choose-all").html("<i class=\"icon-choose\"><img src=\"../img/shoppingcart/yes.png\" class=\"choosed\"></i>")
                                        }
                                        continue
                                    } else {
                                        break
                                    }
                                }
                            } else {
                                $(this).html("")
                                $(".choose-all").html("")
                                $(this).parent().parent().removeClass("curr")
                                $(this).parent().parent().attr("choosed", "0")
                            }
                        })
                    },
                    errot: function () {
                        alert("没取到数据！")
                    }
                })

            } else if ((value.fieldId == null) && (value.goodsId != null)) {
                // 按Id查找商品图片、信息、押金、租金
            }
        })
    },
    error: function () {
        alert("失败了！！")
    }
})

function deletethis() {
    alert("删除这个")
}