$(document).ready(function(){
    $("#Mymodal").click(function(){
        $('.btn-sub').attr('type','button')
        $('.btn-updata').attr('type','hidden');
        $("#new").modal("show")
        // $('.btn-updata').attr('display','none');
    })
})

// 数据库读取数据
function each_fun() {
    $.each(myAddress,function (index,value) {
        var addresses = value.address.split('-');
        $('#myaddress').html()

        $('#myaddress').append(`
                <li class="clearfix li-num">
                    <div class="div-out">
                        <div class="div-in1">
                            <p class="p-name">收货人：<span>${value.pickerName}</span></p>
                            <p class="p-scope">所在地区：<span>${addresses[0]}</span></p>
                            <p class="p-address">详细地址：<span>${addresses[1]} </span></p>
                            <p class="p-phone">手机号码：<span>${value.pickerPhone}</span></p>
                            <p class="last-p" style="display:none;">编号：<span>${value.id}</span></p>
                        </div>
                        <div class="div-in2">
                            <div class="fl delete">
                                <span>默认地址</span>
                                <span class="span-updata">修改</span>
                            </div>
                            <span class="span-last">×</span>
                        </div>
                    </div>
                </li>
            `)
    })
}




var myAddress;
var reg_id = $.cookie("id");
if(reg_id != null || reg_id != 0){
    $.post({
        url:"/userAddressCon/selectRegId",
        dataType:"json",
        data:"regId="+reg_id,
        success:function (data) {
            // alert("hahaha")
            myAddress = data.data;
            each_fun()

            //删除数据
            $('.div-in2').find('.span-last').click(function () {
                // alert($(this).parent().prev().find('.last-p').find('span').text());
                $.post({
                    url:"/userAddressCon/deleteById",
                    data:"id="+$(this).parent().prev().find('.last-p').find('span').text(),
                    // data:"id="+3,
                    dataType:"json",
                    success:function (data) {
                        // alert(data.code)
                        if(data.code == 0) {
                            alert("删除成功");
                            // $('#myaddress').html(' ');
                            // $('#myaddress').html(each_fun());
                        } else {
                            alert("删除失败")
                        }
                    }
                })
            })

            //修改地址
            var get_updata_id;
            $('.span-updata').click(function () {
                get_updata_id = $(this).parent().parent().prev().find('.last-p').find('span').text();
                // alert("需要修改的id:"+get_updata_id);
                $('.btn-updata').attr('type','button');
                $('.btn-sub').attr('type','hidden')
                $('.modal-header').text('修改地址');
                $("#new").modal("show");

                $('#inputUserName').val($(this).parent().parent().prev().find('.p-name').find('span').text());
                $('#inputScope').val($(this).parent().parent().prev().find('.p-scope').find('span').text());
                $('#inputAddress').val($(this).parent().parent().prev().find('.p-address').find('span').text());
                $('#inputPhone').val($(this).parent().parent().prev().find('.p-phone').find('span').text());
            })

            //修改数据到数据库
            $('.btn-updata').click(function () {
                var updatainfo = JSON.stringify(
                    {
                        "id":get_updata_id,
                        "pickerName":$('#inputUserName').val(),
                        "address":$('#inputScope').val()+'-'+$('#inputAddress').val(),
                        "pickerPhone":$('#inputPhone').val(),
                        "regId":myAddress[0].regId
                    });
                // console.log(updatainfo);
                $.post({
                    url:"/userAddressCon/updataAddress",
                    data:updatainfo,
                    // data:"id="+get_updata_id,
                    dataType:"json",
                    // processData: false,//发送异步请求必须设置
                    contentType: "application/json",
                    success:function (data) {
                        if(data.code == 0) {
                            alert("修改成功");
                            $("#new").modal("hide");
                        } else {
                            // alert("传到这的id:"+get_updata_id);
                            alert("修改失败");
                            // alert(data.code);
                        }
                    }
                })

            })
        }
    })
}


//添加地址到数据库
$('.btn-sub').click(function () {
    var addressinfo = JSON.stringify({
            "pickerName":$('#inputUserName').val(),
            "address":$('#inputScope').val()+'-'+$('#inputAddress').val(),
            "pickerPhone":$('#inputPhone').val(),
            "regId":myAddress[0].regId
        });
    $.post({
        url:"/userAddressCon/insertAddress",
        data:addressinfo,
        contentType:"application/json",
        dataType:"json",
        // processData: false,//发送异步请求必须设置
        // contentType: false,
        success:function (data) {
            if(data.code == 0) {
               alert("添加成功");
                $("#new").modal("hide")
            } else {
                alert("添加失败")
            }
        }
    })

})



