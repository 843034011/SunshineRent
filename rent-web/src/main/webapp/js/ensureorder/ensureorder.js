// 从cookie中获取当前用户的regId
var regId = $.cookie("id")

var goodId = ''

$.post({
    url: "/orders/getfirstorder",
    dataType: "json",
    success: function (data) {
        if(data.code == 0){

            console.log(JSON.stringify(data.data))

            $("#orderId").text(data.data.orderId)
            $("#orderNumber").text(data.data.orderNumber)
            $("#orderTotal").text(data.data.orderTotal)

            for (var i = 0; i < data.data.results.length; i++) {
                if(data.data.results[i].type == "field"){
                    // 拼接html元素
                    $(".order-list").append(
                        `
                            <li class="list" kind="${data.data.results[i].type}" id="${data.data.results[i].id}">
                                <form>
                                    <div class="form-group">
                                        <label>场地名称：</label>
                                        <span>${data.data.results[i].name}</span>
                                    </div>
                                    <div class="form-group">
                                        <label>开始时间：</label>
                                        <span>${data.data.results[i].startTime}</span>
                                    </div>
                                    <div class="form-group">
                                        <label>结束时间：</label>
                                        <span>${data.data.results[i].endTime}</span>
                                    </div>
                                    <div class="form-group">
                                        <label>当前价格：</label>
                                        <span>${data.data.results[i].total}</span>
                                    </div>
                                </form>
                            </li>
                        `
                    )
                } else if(data.data.results[i].type == "goods"){
                    // 拼接html元素
                    $(".order-list").append(
                        `
                            <li class="list" kind="${data.data.results[i].type}">
                                <form>
                                    <div class="form-group">
                                        <label>商品名称：</label>
                                        <span>${data.data.results[i].name}</span>
                                    </div>
                                    <div class="form-group">
                                        <label>开始时间：</label>
                                        <span>${data.data.results[i].startTime}</span>
                                    </div>
                                    <div class="form-group">
                                        <label>结束时间：</label>
                                        <span>${data.data.results[i].endTime}</span>
                                    </div>
                                    <div class="form-group">
                                        <label>当前价格：</label>
                                        <span>${data.data.results[i].total}</span>
                                    </div>
                                    <div class="form-group">
                                        <label>收获地址：</label>
                                        <span id="${data.data.results[i].id}" class="address" style="color: red" onclick="getAddress(this)">点击此处选择收获地址！</span>
                                    </div> 
                                </form>
                            </li>
                        `
                    )
                }
            }
        }
    }
})

function getAddress(obj) {

    goodId = $(obj).attr("id")

    $.post({
        url: "/userAddressCon/selectRegId",
        data: "regId=" + regId,
        dataType: "json",
        success: function (data) {
            $("#content").html('')
            if(data.code == 0){
                for (var i = 0; i < data.data.length; i++) {
                    $("#content").append(
                        `
                            <li class="list">
                                <div>
                                    <div class="choose-one-box" onclick="oneclick(this)">
        
                                    </div>
                                </div>
                                <form>
                                    <div>
                                        <label>收货人姓名：</label>
                                        <span>${data.data[i].pickerName}</span>
                                    </div>
                                    <div>
                                        <label>收货人电话：</label>
                                        <span>${data.data[i].pickerPhone}</span>
                                    </div>
                                    <div>
                                        <label>收货人地址：</label>
                                        <span>${data.data[i].address}</span>
                                    </div>
                                </form>
                            </li>
                        `
                    )
                }
            }
        }
    })

    $("#new").modal("show")
}

// 单选
function oneclick(obj) {
    // 如果当前choose-one-box没有选中，将其置为''
    if ($(obj).html() != '<i class="icon-choose"><img src="../img/shoppingcart/yes.png" class="choosed"></i>') {
        $(obj).html("")

        for (var i = 0; i < $(".choose-one-box").length; i++) {
            $(".choose-one-box")[i].innerHTML = ''
        }

        $(obj).html('<i class="icon-choose"><img src="../img/shoppingcart/yes.png" class="choosed"></i>')

    } else{
        $(obj).html('')
    }
}

function addaddress() {
    var address;

    for (var i = 0; i < $(".choose-one-box").length; i++) {
        if($(".choose-one-box")[i].innerHTML == '<i class="icon-choose"><img src="../img/shoppingcart/yes.png" class="choosed"></i>'){
            address = $(".choose-one-box")[i].parentNode.parentNode.children[1].children[2].children[1].innerHTML
        }
    }

    $.post({
        url: "/orders/addaddress",
        data: "id=" + goodId + "&address=" + address,
        dataType: "json",
        success: function (data) {
            console.log(JSON.stringify(data.data))
            for (var i = 0; i < data.data.results.length; i++) {
                if(data.data.results[i].id == goodId){
                    $("#"+goodId).text(data.data.results[i].address)
                }
            }
            $("#new").modal("hide")
        }
    })
}

function confirm() {

    if($(".address").length > 0){
        for (let i = 0; i < $(".address").length; i++) {
            if($(".address")[i].innerHTML == "点击此处选择收获地址！"){
                alert("请为全部商品选择收获地址！！！")
                break
            }
        }
    }

    window.location.href = "/orders/confirm"
}