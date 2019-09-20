var url = window.location.href;
var regId = url.split("=")[1]

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
    url: "/shoppingcart/selectallbyid",
    data: "regId=" + regId,
    dataType: "json",
    success: function (data) {
        $.each(data.data, function (index, value) {

            var orderid = value.id

            if ((value.fieldId != null) && (value.goodsId == null)) {

                // 按Id查找场地图片、信息、押金、租金
                $.post({
                    url: "/shoppingcart/selectfieldbyid",
                    data: "id=" + value.fieldId,
                    dataType: "json",
                    success: function (data) {

                        onechoose()

                        $(".choose-list").append(
                            `
                                <li class="list" choosed="0" kind="field" id="${orderid}">
                                    <div class="col-md-2">
                                        <div class="choose-one-box text-left">
                   
                                        </div>
                                        <div style="margin-left: 30px">
                                            <a href="../fieldinfo.html?id=${value.fieldId}">
                                                <img class="field_picture" src="${data.data.fieldPictures[0].fieldPicture}">
                                            </a>
                                        </div>
                                    </div>
                    
                                    <div class="col-md-2 text-left">
                                        <div class="info">
                                            <a href="../fieldinfo.html?id=${value.fieldId}">【${data.data.fieldName}】${data.data.fieldInfo}</a> 
                                        </div>                                      
                                    </div>
                                    <div class="col-md-1 text-center">${data.data.fieldDayprice}/天</div>
                                    <div class="col-md-1 text-center">${data.data.fieldDeposit}</div>
                                    <div class="col-md-1 text-center"><input class="order-number" type="number" value="1" min="1" max="1" step="1"></div>
                                    <div class="col-md-2 text-center">                             
                                        <button type="button" class="btn btn-default daterange-btn" id="${orderid}">
                                            <span>
                                                <i class="icon iconfont icon-calendar1"></i>日期选择
                                            </span>
                                            <i class="icon iconfont icon-danxian-youjiantou-copy"></i>
                                        </button>
                                    </div>
                                    <div class="col-md-1 text-center">金额</div>
                                    <div class="col-md-2 text-center">
                                        <span onclick="deletethis()">删除</span>
                                    </div>
                                </li>
                            `
                        )

                        // 调用单选功能
                        onechoose()

                        // 每个li的日历选择
                        $('#' + orderid + ' button').daterangepicker({
                                startDate: moment(),
                                endDate: moment()
                            },
                            function (start, end) {
                                console.log(start.format('YYYY/MM/DD'))
                                console.log(end.format('YYYY/MM/DD'))
                                $('#' + orderid + ' button span').html(start.format('YYYY/MM/DD') + '-' + end.format('YYYY/MM/DD'));
                            }
                        );
                    },
                    error: function () {
                        alert("没取到数据！")
                    }
                })
            }

            else if ((value.fieldId == null) && (value.goodsId != null)) {
                // 按Id查找商品图片、信息、押金、租金
                $.post({
                    url: "/shoppingcart/selectgoodsbyid",
                    data: "id=" + value.goodsId,
                    dataType: "json",
                    success: function (data) {

                        onechoose()

                        $(".choose-list").append(
                            `
                                <li class="list" choosed="0" kind="goods" id="${orderid}">
                                    <div class="col-md-2">
                                        <div class="choose-one-box text-left">
                   
                                        </div>
                                        <div style="margin-left: 30px">
                                            <a href="../productinfo.html?id=${value.goodsId}">
                                                <img class="field_picture" src="${data.data.goodsPictures[0].goodsPicture}">
                                            </a>
                                        </div>
                                    </div>
                    
                                    <div class="col-md-2 text-left">
                                        <div class="info">
                                            <a href="../productinfo.html?id=${value.goodsId}">【${data.data.goodsName}】${data.data.goodsInfo}</a> 
                                        </div>                                      
                                    </div>
                                    <div class="col-md-1 text-center">${data.data.goodsDayprice}/天</div>
                                    <div class="col-md-1 text-center">${data.data.goodsDeposit}</div>
                                    <div class="col-md-1 text-center"><input class="order-number" type="number" value="1" min="1" max="${data.data.goodsSurplus}" step="1"></div>
                                    <div class="col-md-2 text-center">                             
                                        <button type="button" class="btn btn-default daterange-btn" id="${orderid}">
                                            <span>
                                                <i class="icon iconfont icon-calendar1"></i>日期选择
                                            </span>
                                            <i class="icon iconfont icon-danxian-youjiantou-copy"></i>
                                        </button>
                                    </div>
                                    <div class="col-md-1 text-center">金额</div>
                                    <div class="col-md-2 text-center">
                                        <span onclick="deletethis()">删除</span>
                                    </div>
                                </li>
                            `
                        )

                        // 调用单选功能
                        onechoose()

                        // 每个li的日历选择
                        $('#' + orderid + ' button').daterangepicker({
                                startDate: moment(),
                                endDate: moment()
                            },
                            function (start, end) {
                                console.log(start.format('YYYY/MM/DD'))
                                console.log(end.format('YYYY/MM/DD'))
                                $('#' + orderid + ' button span').html(start.format('YYYY/MM/DD') + '-' + end.format('YYYY/MM/DD'));
                            }
                        );
                    },
                    error: function () {
                        alert("没取到数据！")
                    }
                })
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

// 单选的封装
function onechoose() {
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
}