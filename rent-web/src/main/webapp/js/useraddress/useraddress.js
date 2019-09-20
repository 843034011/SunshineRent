$(document).ready(function(){
    $("#Mymodal").click(function(){
        $('.btn-sub').attr('type','button')
        $('.btn-updata').attr('type','hidden');
        $("#new").modal("show")
        // $('.btn-updata').attr('display','none');
    })
})

// 数据库读取数据
var myAddress;
$.post({
    url:"/userAddressCon/selectRegId",
    dataType:"json",
    data:"regId="+4,
    success:function (data) {
        // alert("hahaha")
        myAddress = data.data;
        $.each(myAddress,function (index,value) {
            var addresses = value.address.split('-');
            $('#myaddress').append(`
                <li class="clearfix">
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

        //删除数据
        $('.div-in2').find('.span-last').click(function () {
            // alert($(this).parent().prev().find('.last-p').find('span').text());
            $.post({
                url:"/userAddressCon/deleteById",
                data:"id="+$(this).parent().prev().find('.last-p').find('span').text(),
                // data:"id="+3,
                dataType:"json",
                success:function (data) {
                    alert("删除成功")
                    console.log("删除成功")
                    // if(data.code == 0) {
                    //
                    //     // $("#new").modal("hide")
                    // } else {
                    //     alert("增加失败")
                    // }
                }
            })
        })

        //修改地址
        $('.span-updata').click(function () {
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
                {pickerName:$('#inputUserName').val(),
                    address:$('#inputScope').val()+'-'+$('#inputAddress').val(),
                    pickerPhone:$('#inputPhone').val(),
                    regId:myAddress[0].regId
                });
            console.log(updatainfo);
            $.post({
                url:"/userAddressCon/updataAddress",
                data:{
                    "userAddress":updatainfo
                },
                dataType:"json",
                // processData: false,//发送异步请求必须设置
                // contentType: false,
                success:function (data) {
                    if(data.code == 0) {
                        console.log("修改成功")
                        $("#new").modal("hide")
                    } else {
                        alert("修改失败")
                    }
                }
            })

        })
    }
})

//添加地址到数据库
$('.btn-sub').click(function () {
    // alert(123);
    // var addressinfo = new FormData();
    var addressinfo = JSON.stringify(
        {pickerName:$('#inputUserName').val(),
        address:$('#inputScope').val()+'-'+$('#inputAddress').val(),
        pickerPhone:$('#inputPhone').val(),
        regId:myAddress[0].regId
        // pickerName:$('#inputUsernamer').val()
        });
    // addressinfo.append('pickerName',$('#inputUsernamer').val());
    // addressinfo.append('address',$('#inputAddress').val()-$('#inputAddresses').val());
    // addressinfo.append('pickerPhone',$('#inputPhone').val());
    // addressinfo.append('regId',$(myAddress[0].regId));
    console.log(addressinfo);
    $.post({
        url:"/userAddressCon/insertAddress",
        data:{
            "userAddress":addressinfo
        },
        dataType:"json",
        // processData: false,//发送异步请求必须设置
        // contentType: false,
        success:function (data) {
            if(data.code == 0) {
                console.log("添加成功")
                $("#new").modal("hide")
            } else {
                alert("增加失败")
            }
        }
    })

})



