//点击效果
function show() {
    var $target1 = $('.items1').find('li').eq(0).css({'color':'rgb(0,200,190)','border-bottom':'2px solid rgb(0,200,190)'});
    var $target2 = $('.items1').find('li').eq(0).find('span').css('color','rgb(0,200,190)');
    var $target3 = $('.items2').find('li').eq(0).css({'color':'rgb(0,200,190)'});
    var $target4 = $('.items2').find('li').eq(0).find('span').css('color','rgb(0,200,190)');
    $('.items1').find('li').click(function () {
        if($(this).val() == 1){
            // alert($(this).val())
            $('#ul').css('display','block');
            $('.items2').find('li').click(function () {
                $target3.css('color', '#666');
                $target4.css('color', '#666');
                $target4 = $(this).find('span').css('color', 'rgb(0,200,190)');
                $target3 = $(this).css({'color': 'rgb(0,200,190)'});
            })
        }else{
            $('#ul').css('display','none');
        }
        $target1.css({'color':'#666','border-bottom':'0px solid #333'});
        $target2.css('color','#666');
        $target2 = $(this).find('span').css('color','rgb(0,200,190)');
        $target1 = $(this).css({'color':'rgb(0,200,190)','border-bottom':'2px solid rgb(0,200,190)'});
    })
}

// $('#ul-good').html(
//     '<li>商品管理</li>\n' +
//     '<li><a href="/goodsManageCon/showManage?regId='+$.cookie("id")+'">商品管理</a></li>');

// 截取当前用户的id
// var url = window.location.href;
// var reg_id = url.split("=")[1];
// alert(reg_id);
var reg_id = $.cookie('id');
var myGoods;
var len;
// alert("注册用户id:"+reg_id);
if(reg_id != null || reg_id != 0) {
$.post({
        url: "/goodsManageCon/selectRegId",
        dataType: "json",
        data: "regId=" + reg_id,//页面获取
        success: function (data) {
            // alert(123)
            myGoods = data.data;
            len = myGoods.length;
            $.each(myGoods, function (index, value) {
                $('.con-ul').append(
                    `
                <li class="two">
                    <div class="div1">
                    <img src="${value.goodsPictures[0].goodsPicture}" height="88" width="88"/>
                    </div>
                    <div class="div2">
                        <div class="div2-con">
                            <span>${value.goodsName}</span>
                            <span>${value.goodsInfo}</span><br/>
                            <span>押金:${value.goodsDeposit}</span>
                            <span>天租金:${value.goodsDayprice}</span>
                            <span>月租金:${value.goodsWeekprice}</span>
                            <span class="span-id" style="display:none;">${value.id}</span>
                        </div>
                        <div class="div2-input">
                        数量：<input type="number" min="1" step="1" value="${value.goodsNumber}">
                        </div>
                    </div>
                    <div class="div3">
                        <button class="good-updata" id="${value.id}"><a href="addGoods?value=0">修改</a></button>
                        <button class="good-delete">删除</button>
                    </div>
                </li>
                `
                )
            });

            $(".good-updata").click(function () {
                var value_id = $(this).attr('id');
                // alert(value_id);
                sessionStorage.setItem("value_id",value_id);
            })

            if (len != 0) {
                // $('.items1').html('');
                $('.items1').html(
                    ' <li class="item" value="0">\n' +
                    '                我的商品(<span>' + len + '</span>)\n' +
                    '            </li>\n' +
                    '            <li class="item" value="1">\n' +
                    '                再租商品(<span>0</span>)\n' +
                    '            </li>\n' +
                    '            <li class="item" value="2">\n' +
                    '                退租商品(<span>0</span>)\n' +
                    '            </li>');
            };
            show();

            // 删除商品
            $('.good-delete').click(function () {
                $.post({
                    url: "/goodsManageCon/deleteGood",
                    //实际使用
                    data:"id="+$(this).parent().prev('.div2').find('.div2-con').find('.span-id').text(),
                    //测试
                    // data: "id=" + 5,
                    dataType: "json",
                    success: function (data) {
                        if (data.code == 0) {
                            // alert("删除成功");
                            window.location.reload();
                        } else {
                            alert("删除失败")
                        }
                    }
                })
            })
            //修改商品信息
            // $('.good-updata').click(function () {
            //     window.location.href = "../goodsManageCon/addGoods";
            // })
        }
    })
}else{
    // alert("请登录");
    // window.location.href = "../login.html";
    alert("未登录，请登录");
}


//点击搜索
$('.search').find('.search-btn').click(function () {
    var html ;
    var putName = $('.search').find('.search-input').val();
    if(putName == 0){
        html = '';
        // console.log(123)
    }else{
        $.each(myGoods, function (index, value) {
            var inName = value.goodsName;
            console.log(inName)
            if(inName.indexOf(putName)>=0){
                html+='<li class="one">'+商品信息+'</li>\n' +
                    '  <li class="one">'+操作+'</li>\n'+
                    '<li class="two">\n'+
                    '                <div class="div1">\n' +
                    '                <img src="'+value.goodsPictures[0].goodsPicture+'" height="88" width="88"/>\n' +
                    '                </div>\n' +
                    '                <div class="div2">\n' +
                    '                <div class="div2-con">\n' +
                    '                <span>'+value.goodsName+'</span>\n' +
                    '                <span>'+value.goodsInfo+'</span><br/>\n' +
                    '                <span>押金:'+value.goodsDeposit+'</span>\n' +
                    '                <span>天租金:'+value.goodsDayprice+'</span>\n' +
                    '                <span>月租金:'+value.goodsWeekprice+'</span>\n' +
                    '            </div>\n' +
                    '            <div class="div2-input">\n' +
                    '                数量：<input type="number" min="1" step="1" value="'+value.goodsNumber+'">\n' +
                    '                </div>\n' +
                    '\n' +
                    '                </div>\n' +
                    '                <div class="div3">\n' +
                    '                <button class="good-updata"><a href="addGoods?id=0">修改</a></button>\n' +
                    '                <button class="good-delete">删除</button>\n' +
                    '                </div>\n' +
                    '</li>'
            }
        })
    }
    $('.con-ul').html(html);
})
show();


