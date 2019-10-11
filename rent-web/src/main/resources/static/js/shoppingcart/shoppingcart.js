// 从cookie中获取当前用户的regId
var regId = $.cookie("id")

// 定义两个全局变量传参
var kind;
var num;

// 定义一个全局数组，存放禁用的日期
var jsonInvalidDate = new Array();

// 计算页面信息
var totalNumber = 0;
var totalDeposit = 0;
var totalRent = 0;
var totalMoney = 0;
var sedate = '';

// 设定全选、单选的html为null
$(".choose-list").html("")
$(".choose-all").html("")

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
                    async: false,
                    data: "id=" + value.fieldId,
                    dataType: "json",
                    success: function (data) {

                        // 拼接html元素
                        $(".choose-list").append(
                            `
                                <li class="list" choosed="0" kind="field" id="${orderid}">
                                    <div class="col-md-2">
                                        <div class="choose-one-box text-left" onclick="oneclick(this)">
                                        </div>
                                        <div style="margin-left: 30px">
                                            <a href="../fieldinfo.html?id=${value.fieldId}">
                                                <img class="field_picture" src="${data.data.fieldPictures[0].fieldPicture}">
                                            </a>
                                        </div>
                                    </div>
                    
                                    <div class="col-md-2 text-left">
                                        <div class="info">
                                            <a href="../fieldinfo.html?id=${value.fieldId}"><span>【${data.data.fieldName}】</span>${data.data.fieldInfo}</a> 
                                        </div>                                      
                                    </div>
                                    <div class="col-md-2 text-center three-line">
                                        >=1天&nbsp&nbsp<span class="day-price">${data.data.fieldDayprice}</span>/天<br>
                                        >=7天&nbsp&nbsp<span class="week-price">${data.data.fieldWeekprice}</span>/天<br>
                                        >=30天&nbsp&nbsp<span class="month-price">${data.data.fieldMonthprice}</span>/天</div>
                                    <div class="col-md-1 text-center deposit">${data.data.fieldDeposit}</div>
                                    <div class="col-md-2 text-center">                             
                                        <button type="button" class="btn btn-default daterange-btn" id="${orderid}" kind="field" num="${value.fieldId}">
                                            <span>
                                                <i class="icon iconfont icon-calendar1"></i>日期选择
                                            </span>
                                            <i class="icon iconfont icon-danxian-youjiantou-copy"></i>
                                        </button>
                                    </div>
                                    <div class="col-md-1 text-center onetotalmoney">金额</div>
                                    <div class="col-md-2 text-center">
                                        <span class="delete-this" onclick="deletethis(this)">删除</span>
                                    </div>
                                </li>
                            `
                        )

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
                    async: false,
                    data: "id=" + value.goodsId,
                    dataType: "json",
                    success: function (data) {

                        $(".choose-list").append(
                            `
                                <li class="list" choosed="0" kind="goods" id="${orderid}">
                                    <div class="col-md-2">
                                        <div class="choose-one-box text-left" onclick="oneclick(this)">
                                        </div>
                                        <div style="margin-left: 30px">
                                            <a href="../productinfo.html?id=${value.goodsId}">
                                                <img class="field_picture" src="${data.data.goodsPictures[0].goodsPicture}">
                                            </a>
                                        </div>
                                    </div>
                    
                                    <div class="col-md-2 text-left">
                                        <div class="info">
                                            <a href="../productinfo.html?id=${value.goodsId}"><span>【${data.data.goodsName}】</span>${data.data.goodsInfo}</a> 
                                        </div>                                      
                                    </div>
                                    <div class="col-md-2 text-center two-line">
                                        >=1天&nbsp&nbsp<span class="day-price">${data.data.goodsDayprice}<span>/天<br>
                                        >=7天&nbsp&nbsp<span class="week-price">${data.data.goodsWeekprice}<span>/天<br>
                                    </div>
                                    <div class="col-md-1 text-center deposit">${data.data.goodsDeposit}</div>
                                    <div class="col-md-2 text-center">                             
                                        <button type="button" class="btn btn-default daterange-btn" id="${orderid}" kind="goods" num="${value.goodsId}">
                                            <span>
                                                <i class="icon iconfont icon-calendar1"></i>日期选择
                                            </span>
                                            <i class="icon iconfont icon-danxian-youjiantou-copy"></i>
                                        </button>
                                    </div>
                                    <div class="col-md-1 text-center onetotalmoney">金额</div>
                                    <div class="col-md-2 text-center">
                                        <span class="delete-this" onclick="deletethis(this)">删除</span>
                                    </div>
                                </li>
                            `
                        )

                        $('#' + orderid + ' button').click(function () {
                            num = $('#' + orderid + ' button').attr("num")
                            kind = $('#' + orderid + ' button').attr("kind")

                            jsonInvalidDate.length = 0
                        })

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

// 单个购物车数据删除函数
function deletethis(obj) {
    var result = confirm("您确定要把这条数据从购物车里删除么？")
    if (result) {
        var shoppingId = parseInt($(obj).parent().parent().attr("id"))
        if (shoppingId > 0) {
            $.post({
                url: "/shoppingcart/deletebyshoppingid",
                data: "shoppingId=" + shoppingId,
                dataType: "json",
                success: function (data) {
                    if (data.data != null) {
                        window.location.href = "/shoppingcart/showcart";
                    }
                }
            })
        }
    } else {

    }
}

// 单选
function oneclick(obj) {

    // 如果当前choose-one-box没有选中，将其置为''
    if ($(obj).html() != '<i class="icon-choose"><img src="../img/shoppingcart/yes.png" class="choosed"></i>') {
        $(obj).html("")
    }

    if ($(obj).html() == "") {

        sedate = $(obj).parent().parent().find("button span").text().trim()
        // 判断当前商品是否选中了日期
        if (sedate == '日期选择') {
            alert('请先选择日期！！！')
        }

        if (sedate != '日期选择') {
            // 设置当前li处于选中状态
            $(obj).html('<i class="icon-choose"><img src="../img/shoppingcart/yes.png" class="choosed"></i>')
            $(obj).parent().parent().addClass("curr")
            $(obj).parent().parent().attr("choosed", "1")

            sdate = sedate.split("-")[0];
            edate = sedate.split("-")[1];
            var days = Math.abs(new Date(edate).getTime() - new Date(sdate).getTime()) / (1000 * 60 * 60 * 24) + 1

            var onetotalmoney;

            if ($(obj).parent().parent().attr("kind") == 'field') {
                // 场地租金分 日、周、月
                if (days >= 7) {
                    totalRent += parseInt($(obj).parent().parent().find(".week-price").html()) * days
                    onetotalmoney = parseInt($(obj).parent().parent().find(".week-price").html()) * days + parseInt($(obj).parent().parent().find(".deposit").html())
                } else if (days >= 30) {
                    totalRent += parseInt($(obj).parent().parent().find(".month-price").html()) * days
                    onetotalmoney = parseInt($(obj).parent().parent().find(".month-price").html()) * days + parseInt($(obj).parent().parent().find(".deposit").html())
                } else {
                    totalRent += parseInt($(obj).parent().parent().find(".day-price").html()) * days
                    onetotalmoney = parseInt($(obj).parent().parent().find(".day-price").html()) * days + parseInt($(obj).parent().parent().find(".deposit").html())
                }
            } else if ($(obj).parent().parent().attr("kind") == 'goods') {
                // 商品租金分 日、周
                if (days >= 7) {
                    totalRent += parseInt($(obj).parent().parent().find(".week-price").html()) * days
                    onetotalmoney = parseInt($(obj).parent().parent().find(".week-price").html()) * days + parseInt($(obj).parent().parent().find(".deposit").html())
                } else {
                    totalRent += parseInt($(obj).parent().parent().find(".day-price").html()) * days
                    onetotalmoney = parseInt($(obj).parent().parent().find(".day-price").html()) * days + parseInt($(obj).parent().parent().find(".deposit").html())
                }
            }

            totalDeposit += parseInt($(obj).parent().parent().find(".deposit").html())
            totalMoney = totalDeposit + totalRent;
            totalNumber++;

            $(obj).parent().parent().find(".onetotalmoney").html(onetotalmoney)

            $(".number").html(totalNumber)
            $(".rent-money").html(totalRent)
            $(".deposit-money").html(totalDeposit)
            $(".total-money").html(totalMoney)
        }

        for (var i = 0; i < $(".choose-one-box").length; i++) {
            if ($(".choose-one-box")[i].innerHTML == '<i class="icon-choose"><img src="../img/shoppingcart/yes.png" class="choosed"></i>') {
                if (i == $(".choose-one-box").length - 1) {
                    $(".choose-all").html('<i class="icon-choose"><img src="../img/shoppingcart/yes.png" class="choosed"></i>')
                }
                continue
            } else {
                break
            }
        }
    } else {
        sedate = $(obj).parent().parent().find("button span").text().trim()

        sdate = sedate.split("-")[0];
        edate = sedate.split("-")[1];
        var days = Math.abs(new Date(edate).getTime() - new Date(sdate).getTime()) / (1000 * 60 * 60 * 24) + 1

        if ($(obj).parent().parent().attr("kind") == 'field') {
            // 场地租金分 日、周、月
            if (days >= 7) {
                totalRent -= parseInt($(obj).parent().parent().find(".week-price").html()) * days
            } else if (days >= 30) {
                totalRent -= parseInt($(obj).parent().parent().find(".month-price").html()) * days
            } else {
                totalRent -= parseInt($(obj).parent().parent().find(".day-price").html()) * days
            }
        } else if ($(obj).parent().parent().attr("kind") == 'goods') {
            // 商品租金分 日、周
            if (days >= 7) {
                totalRent -= parseInt($(obj).parent().parent().find(".week-price").html()) * days
            } else {
                totalRent -= parseInt($(obj).parent().parent().find(".day-price").html()) * days
            }
        }

        totalDeposit -= parseInt($(obj).parent().parent().find(".deposit").html())
        totalMoney = totalDeposit + totalRent;
        totalNumber--;

        $(obj).parent().parent().find(".onetotalmoney").html("金额")

        $(".number").html(totalNumber)
        $(".rent-money").html(totalRent)
        $(".deposit-money").html(totalDeposit)
        $(".total-money").html(totalMoney)

        $(obj).html("")
        $(".choose-all").html("")
        $(obj).parent().parent().removeClass("curr")
        $(obj).parent().parent().attr("choosed", "0")
    }
}

// 全选的click事件
$(".choose-all").click(function () {

    totalNumber = 0;
    totalDeposit = 0;
    totalRent = 0;
    totalMoney = 0;

    if ($(".choose-all").html() == "") {
        for (var i = 0; i < $(".choose-one-box").length; i++) {

            if ($(".choose-one-box")[i].parentNode.parentNode.children[4].children[0].children[0].innerText.trim() == '日期选择') {
                alert("请先为全部商品选择日期！！")
                break;
            }
            if (i == ($(".choose-one-box").length - 1)) {
                $(".choose-all").html("<i class=\"icon-choose\"><img src=\"../img/shoppingcart/yes.png\" class=\"choosed\"></i>")
                $(".choose-one-box").html("<i class=\"icon-choose\"><img src=\"../img/shoppingcart/yes.png\" class=\"choosed\"></i>")
                $(".list").attr("choosed", "1")
                $(".list").addClass("curr")

                for (var i = 0; i < $(".choose-one-box").length; i++) {
                    totalNumber = i + 1;

                    sedate = $(".choose-one-box")[i].parentNode.parentNode.children[4].children[0].children[0].innerText.trim()
                    sdate = sedate.split("-")[0];
                    edate = sedate.split("-")[1];
                    var days = Math.abs(new Date(edate).getTime() - new Date(sdate).getTime()) / (1000 * 60 * 60 * 24) + 1

                    var oneRentMoney;

                    if ($(".choose-one-box")[i].parentNode.parentNode.getAttribute("kind") == 'field') {
                        // 场地租金分 日、周、月
                        if (days >= 7) {
                            oneRentMoney = parseInt($(".choose-one-box")[i].parentNode.parentNode.children[2].children[2].innerText) * days
                            totalRent += oneRentMoney
                            $(".choose-one-box")[i].parentNode.parentNode.children[5].innerText = oneRentMoney + parseInt($(".choose-one-box")[i].parentNode.parentNode.children[3].innerText)
                        } else if (days >= 30) {
                            oneRentMoney = parseInt($(".choose-one-box")[i].parentNode.parentNode.children[2].children[4].innerText) * days
                            totalRent += oneRentMoney
                            $(".choose-one-box")[i].parentNode.parentNode.children[5].innerText = oneRentMoney + parseInt($(".choose-one-box")[i].parentNode.parentNode.children[3].innerText)
                        } else {
                            oneRentMoney = parseInt($(".choose-one-box")[i].parentNode.parentNode.children[2].children[0].innerText) * days
                            totalRent += oneRentMoney
                            $(".choose-one-box")[i].parentNode.parentNode.children[5].innerText = oneRentMoney + parseInt($(".choose-one-box")[i].parentNode.parentNode.children[3].innerText)
                        }
                    } else if ($(".choose-one-box")[i].parentNode.parentNode.getAttribute("kind") == 'goods') {
                        // 商品租金分 日、周
                        if (days >= 7) {
                            oneRentMoney = parseInt($(".choose-one-box")[i].parentNode.parentNode.children[2].children[2].innerText) * days
                            totalRent += oneRentMoney
                            $(".choose-one-box")[i].parentNode.parentNode.children[5].innerText = oneRentMoney + parseInt($(".choose-one-box")[i].parentNode.parentNode.children[3].innerText)
                        } else {
                            oneRentMoney = parseInt($(".choose-one-box")[i].parentNode.parentNode.children[2].children[0].innerText) * days
                            totalRent += oneRentMoney
                            $(".choose-one-box")[i].parentNode.parentNode.children[5].innerText = oneRentMoney + parseInt($(".choose-one-box")[i].parentNode.parentNode.children[3].innerText)
                        }
                    }

                    totalDeposit += parseInt($(".choose-one-box")[i].parentNode.parentNode.children[3].innerText)

                    totalMoney = totalRent + totalDeposit
                }
            }
        }

        $(".number").html(totalNumber)
        $(".rent-money").html(totalRent)
        $(".deposit-money").html(totalDeposit)
        $(".total-money").html(totalMoney)

    } else {
        $(".choose-all").html("")
        $(".choose-one-box").html("")
        $(".list").attr("choosed", "0")
        $(".list").removeClass("curr")

        totalNumber = 0;
        totalDeposit = 0.00;
        totalRent = 0.00;
        totalMoney = 0.00;

        $(".onetotalmoney").html("金额")

        $(".number").html(totalNumber)
        $(".rent-money").html(totalRent)
        $(".deposit-money").html(totalDeposit)
        $(".total-money").html(totalMoney)
    }
})

// 结算函数
function totalmoney() {

    var results = [];

    for (var i = 0; i < $(".choose-one-box").length; i++) {

        if ($(".choose-one-box")[i].innerHTML == '<i class="icon-choose"><img src="../img/shoppingcart/yes.png" class="choosed"></i>') {

            var shoppingCartId = $(".choose-one-box")[i].parentNode.parentNode.getAttribute("id")
            var type = $(".choose-one-box")[i].parentNode.parentNode.getAttribute("kind")
            var id = $(".choose-one-box")[i].parentNode.parentNode.children[4].children[0].getAttribute("num")
            var name = $(".choose-one-box")[i].parentNode.parentNode.children[1].children[0].children[0].children[0].innerText

            var sedate = $(".choose-one-box")[i].parentNode.parentNode.children[4].children[0].children[0].innerText.trim()
            var sdate = sedate.split("-")[0].replace(/\//g, "-");
            var edate = sedate.split("-")[1].replace(/\//g, "-");
            var startTime = sdate;
            var endTime = edate;

            var total = $(".choose-one-box")[i].parentNode.parentNode.children[5].innerText;

            var fid = null;
            var gid = null;

            if ($(".choose-one-box")[i].parentNode.parentNode.getAttribute("kind") == 'field') {
                fid = $(".choose-one-box")[i].parentNode.parentNode.children[4].children[0].getAttribute("num")
            } else if ($(".choose-one-box")[i].parentNode.parentNode.getAttribute("kind") == 'goods') {
                gid = $(".choose-one-box")[i].parentNode.parentNode.children[4].children[0].getAttribute("num")
            }

            var fieldId = fid;
            var goodsId = gid;

            var result = {
                "shoppingCartId": shoppingCartId,
                "type": type,
                "id": id,
                "name": name,
                "startTime": startTime,
                "endTime": endTime,
                "total": total,
                "fieldId": fieldId,
                "goodsId": goodsId,
            };

            results.push(result)
        }
    }


    var json = {
        "orderNumber": $("#num").text(),
        "rId": regId,
        "orderTotal": $(".total-money").text(),
        "results": results
    };

    console.log(JSON.stringify(json))

    if (1) {
        $.post({
            url: "/orders/addinfo",
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify(json),
            dataType: "json",
            success: function (data) {
                if(data.code == 0){
                    window.location.href = "/orders/ensureorder"
                }
            }
        })
    }

}