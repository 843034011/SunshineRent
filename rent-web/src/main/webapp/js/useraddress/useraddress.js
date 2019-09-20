$(document).ready(function(){
    $("#Mymodal").click(function(){
        $("#new").modal("show")
    })
})

// 数据库读取数据
var myAddress;
$.post({
    url:"/userAddressCon/selectRegId",
    dataType:"json",
    data:"regId="+4,
    success:function (data) {
        myAddress = data.data;
        $.each(myAddress,function (index,value) {
            var addresses = value.address.split('-');
            $('#myaddress').append(`
                <li class="clearfix">
                    <div class="div-out">
                        <div class="div-in1">
                            <p>收货人：<span>${value.pickerName}</span></p>
                            <p>所在地区：<span>${addresses[0]}</span></p>
                            <p>详细地址：<span>${addresses[1]} </span></p>
                            <p>手机号码：<span>${value.pickerPhone}</span></p>
                        </div>
                        <div class="div-in2">
                            <div class="fl delete">
                                <span>默认地址</span>
                                <span>修改</span>
                            </div>
                            <span class="span-last">×</span>
                        </div>
                    </div>
                </li>
            `)
        })
    }
})

//添加地址到数据库
$('.btn-sub').click(function () {
    var insertAddress = new addressData();
    insertAddress.append('pickerName',$('#inputUsernamer').val());
    insertAddress.append('address',$('#inputAddress').val()-$('#inputAddresses').val());
    insertAddress.append('pickerPhone',$('#inputPhone').val());
    insertAddress.append('regId',$(myAddress[0].regId));

    $.post({
        url:"/userAddressCon/insertAddress",
        data:insertAddress,
        dataType:"json",
        processData: false,//发送异步请求必须设置
        contentType: false,
        success:function (data) {
            if(data.code == 0) {
                alert("增加成功")
            } else {
                alert("增加失败")
            }
        }
    })
})
