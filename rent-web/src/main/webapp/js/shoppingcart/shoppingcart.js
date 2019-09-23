// 截取当前用户的id
var url = window.location.href;
var regId = url.split("=")[1]

// 定义两个全局变量传参
var kind;
var num;

// 定义一个全局数组，存放禁用的日期
var jsonInvalidDate = new Array();

// 计算页面信息
var totalNumber;
var totalDeposit;
var totalRent;
var totalMoney;

// 设定全选、单选的html为null
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
    total();
})

// 页面的动态加载
$.post({
    url: "/shoppingcart/selectallbyid",
    data: "regId=" + regId,
    async: false,
    dataType: "json",
    success: function (data) {
        $.each(data.data, function (index, value) {

            // 获取购物车中的id
            var orderid = value.id

            // 根据两种商品的种类不同，分别到不同的表中取值
            if ((value.fieldId != null) && (value.goodsId == null)) {
                // 按Id查找场地图片、信息、押金、租金
                $.post({
                    url: "/shoppingcart/selectfieldbyid",
                    data: "id=" + value.fieldId,
                    dataType: "json",
                    success: function (data) {

                        // 调用单选功能
                        onechoose()

                        // 拼接html元素
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
                                    <div class="col-md-2 text-center three-line">>1天&nbsp&nbsp${data.data.fieldDayprice}/天<br>>1周&nbsp&nbsp${data.data.fieldWeekprice}/天<br>>1月&nbsp&nbsp${data.data.fieldMonthprice}/天</div>
                                    <div class="col-md-1 text-center deposit">${data.data.fieldDeposit}</div>
                                    <div class="col-md-2 text-center">                             
                                        <button type="button" class="btn btn-default daterange-btn" id="${orderid}" kind="field" num="${value.fieldId}">
                                            <span>
                                                <i class="icon iconfont icon-calendar1"></i>日期选择
                                            </span>
                                            <i class="icon iconfont icon-danxian-youjiantou-copy"></i>
                                        </button>
                                    </div>
                                    <div class="col-md-1 text-center">金额</div>
                                    <div class="col-md-2 text-center">
                                        <span class="delete-this" onclick="deletethis()">删除</span>
                                    </div>
                                </li>
                            `
                        )

                        // 调用单选功能
                        onechoose()

                        // 向下一个js中准备参数
                        $('#' + orderid + ' button').click(function () {
                            num = $('#' + orderid + ' button').attr("num")
                            kind = $('#' + orderid + ' button').attr("kind")

                            jsonInvalidDate.length = 0
                        })

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
            } else if ((value.fieldId == null) && (value.goodsId != null)) {
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
                                    <div class="col-md-2 text-center two-line">>1天&nbsp&nbsp${data.data.goodsDayprice}/天<br>>1周&nbsp&nbsp${data.data.goodsWeekprice}/天<br></div>
                                    <div class="col-md-1 text-center deposit">${data.data.goodsDeposit}</div>
                                    <div class="col-md-2 text-center">                             
                                        <button type="button" class="btn btn-default daterange-btn" id="${orderid}" kind="goods" num="${value.goodsId}">
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

                        onechoose()

                        $('#' + orderid + ' button').daterangepicker({
                                startDate: moment(),
                                endDate: moment(),
                            },
                            function (start, end) {
                                console.log(start.format('YYYY/MM/DD'))
                                console.log(end.format('YYYY/MM/DD'))
                                $('#' + orderid + ' button span').html(start.format('YYYY/MM/DD') + '-' + end.format('YYYY/MM/DD'));
                            }
                        );

                        $('#' + orderid + ' button').click(function () {
                            num = $('#' + orderid + ' button').attr("num")
                            kind = $('#' + orderid + ' button').attr("kind")

                            jsonInvalidDate.length = 0
                        })
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
function total() {

    totalNumber = 0;
    totalDeposit = 0;
    totalRent = 0;
    totalMoney = 0;
    var sedate;

    for (var i = 0; i < $(".choose-one-box").length; i++) {
        if ($(".choose-one-box")[i].innerHTML == '<i class="icon-choose"><img src="../img/shoppingcart/yes.png" class="choosed"></i>') {
            totalNumber++;
            totalDeposit += $(".choose-one-box").parent().parent().find(".deposit")[i].innerText
            sedate = $(".choose-one-box").parent().parent().find("button span")[i].innerText

            if(sedate == '日期选择 '){
                alert('请先选择日期！！！')
            }
            sdate = sedate.split("-")[0];
            edate = sedate.split("-")[1];
            var days = Math.abs( new Date(edate).getTime()- new Date(sdate).getTime())/ (1000 * 60 * 60 * 24)


        }
    }
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


