$(".show-nav").find("li").click(function () {
    var small = $(this).find("img")[0].src;
    $(".first").find("img").attr("src",small)/*.animate({"opacity":0},2000)*/;
    target.css("border","2px solid rgba(255,255,255,0)");
    target = $(this).css("border","2px solid rgb(0,200,190)");
});

//定时轮播
var index = 1;


var target = $(".show-nav").find("li").eq(index-1).css("border","2px solid rgb(0,200,190)");
setInterval(function(){
    index++;
    if(index>5){
        index=1;
    }
    // $img.eq(outOrd).animate({"opacity":0},2000);
    // //让一张(ord)淡入下一张图片显示
    // $img.eq(ord).animate({"opacity":1},2000);
    // $("#banImg").attr("src","img/index/images/banner0"+(index)+".jpg").animate({"opacity":0},2000);
    // if(index >= 4){
    //     $("#banImg").attr("src","img/index/images/banner0"+1+".jpg").animate({"opacity":1},2000);
    // }else{
    $("#banImg").attr("src","img/index/images/banner0"+(index)+".jpg")/*.animate({"opacity":1},2000)*/;
    // }
    // target =  $(".show-nav").find("li").eq(index-1)
    target.css("border","2px solid rgba(255,255,255,0)");
    target = $(".show-nav").find("li").eq(index-1).css("border","2px solid rgb(0,200,190)");
},4000);

var reg_id = $.cookie('id');

//顶部导航栏
if(reg_id == undefined){
    $('.items').html(
        ' <li class="item"><a href="/shoppingcart/showcart'+
        '                        ">购物车</a></li>\n' +
        '                        <li class="item"><a href="">咨询中心</a></li>\n' +
        '                        <li class="item userCenter" onclick="user()"><a href="">个人中心</a></li>\n' +
        '                        <!--<li class="item"><a href="">成为租赁商</a></li>-->\n' +
        '                        <li class="item"><a href="login.html">登录</a></li>\n' +
        '                        <li class="item">\n' +
        // llb 2019-9-20 修改首页到注册页面的跳转方式
        '                            <a href="/register/showregister">注册</a>\n' +
        '                        </li>\n' +
        '                        <li class="item">\n' +
        '                            <span class="tel"><a href="">159-8444-5209</a></span>\n' +
        '                        </li>'
    )
}else{
    $('.items').html(
        ' <li class="item"><a href="/shoppingcart/showcart'+
        '                        ">购物车</a></li>\n' +
        '                        <li class="item"><a href="">咨询中心</a></li>\n' +
        '                        <li class="item userCenter"><a href="/goodsManageCon/showManage">个人中心</a></li>\n' +
        '                        <li class="item" onclick="unlogin()"><a href="">退出登录</a></li>\n' +
        '                        <!--<li class="item"><a href="">成为租赁商</a></li>-->\n' +
        '                        <li class="item">\n' +
        '                            <span class="tel"><a href="">159-8444-5209</a></span>\n' +
        '                        </li>'
    )
}

// function jump_center() {
//     alert("跳转")
//     window.location.href="http://localhost:8080/goodsManageCon/showManage";
// }

function user() {
    alert("未登录，请登录")
}

function unlogin(){
    $.cookie('id', '', { expires: -1 });
    $.cookie('key', '', { expires: -1 });
    $.cookie('isIdentified', '', { expires: -1 });
    // $.cookie("isIdentified",data.data.isIdentified)
    // window.location.href="/index.html";
}

//搜索框相关
var $li_i = $('#ul-search').find('li').find('i').eq(0).css('background-color','#0abfb6');
getValue()
getValue2();
$('#ul-search').find('li').click(function () {
    getValue2();
    $li_i.css('background-color','#fff');
    $li_i = $(this).find('i').css('background-color','#0abfb6');
    if($(this).val() == 0){
        $('.div-show').html('<table>\n' +
            '                <tr>\n' +
            '                    <td>场地</td>\n' +
            '                    <td>\n' +
            '                        <span>办公场地</span>\n' +
            '                        <span>运动场地</span>\n' +
            '                        <span>体育电竞</span>\n' +
            '                        <span>展览展示</span>\n' +
            '                        <!--<hr>-->\n' +
            '                        <span>派对沙龙</span>\n' +
            '                    </td>\n' +
            '                </tr>\n' +
            '                <tr>\n' +
            '                    <td>商品</td>\n' +
            '                    <td>\n' +
            '                        <span>电脑</span>\n' +
            '                        <span>打印机</span>\n' +
            '                        <span>手机</span>\n' +
            '                    </td>\n' +
            '               </tr>\n' +
            '          </table>')
        getValue()
    }else if($(this).val() == 1){
        $('.div-show').html(
            '<table>\n' +
            '                <tr>\n' +
            '                    <td>场地</td>\n' +
            '                    <td>\n' +
            '                        <span>办公场地</span>\n' +
            '                        <span>运动场地</span>\n' +
            '                        <span>体育电竞</span>\n' +
            '                        <span>展览展示</span>\n' +
            '                        <!--<hr>-->\n' +
            '                        <span>派对沙龙</span>\n' +
            '                    </td>\n' +
            '                </tr>\n' +
            '          </table>');
        getValue()
    }else if($(this).val() == 2){
        $('.div-show').html(
            '<table>\n' +
            '                <tr>\n' +
            '                    <td>商品</td>\n' +
            '                    <td>\n' +
            '                        <span>电脑</span>\n' +
            '                        <span>打印机</span>\n' +
            '                        <span>手机</span>\n' +
            '                    </td>\n' +
            '               </tr>\n' +
            '          </table>');
        getValue()
    }

})

btn()//点击搜索框显示选择列表框
function btn(){
    $('body').click(function () {
        $('.div-show').css('visibility','hidden');
    })
    $('#search-box').click(function(event){
        $('.div-show').css('visibility','visible');
        event.stopPropagation();
    });
}

//获取选择的类型，填入搜索框
var type;
var type_value;
function getValue() {
    $('.div-show').find('table').find('span').click(function () {
        $('#search-box').find('.input-2').attr('value',$(this).text());
        type = $(this).parent().prev().text();
    })
}
function getValue2() {
    $('#ul-search').find('li').click(function () {
        $('#search-box').find('.input-2').attr('value','');
    })
}

//点击搜索
$('.div-btn').click(function () {
    // alert(type);
    type_value = $('#search-box').find('.input-2').val()
    // alert(type_value)
    if(type == '场地'){
        // yy
        $(location).attr('href','fieldlist.html?name='+type_value);
    }else if(type == '商品'){
        $(location).attr('href','productlist.html?name='+type_value);
    }
})
// 拿到是否注冊的值
if(reg_id != undefined) {
    $.post({
        url: "/indexCon/selectById",
        data: "userId=" + reg_id,
        dataType: "json",
        success: function (data) {
            if (data.data == 0) {
                $.cookie("isIdentified",data.data.isIdentified)
                console.log("成功");
            } else {
                console.log("失败")
            }
        }
    })
}


$.post({
    url:"/indexCon/selectFields",
    data:"fieldType="+"办公场地",
    dataType:"json",
    success:function (data) {
        allFieldData = data.data;
        $.each(allFieldData, function (index, value) {
            if (index < 8) {
                $('.product-item').append(`
                    <li class="item">
                        <div class="prod-img sram-fake-table">
                            <a class="link sram-fake-table-cell"  href="/fieldinfo.html?id=${value.id}" target="_blank">
                                <img src="${value.fieldPictures[0].fieldPicture}"/>
                            </a>
                        </div>
                        <a  class="prod-desc" target="_blank" href="/fieldinfo.html?id=${value.id}">
                            <div class="prod-rental sram-ellipsis">
                                <span>￥${value.fieldMonthprice}</span>/月                                                                    
                            </div>
                            <div class="prod-title sram-ellipsis">
                                ${value.fieldName}                                                                  
                            </div>
                            <div class="prod-deposit-timer sram-ellipsis">
                                <span class="deposit">押金￥${value.fieldDeposit}</span>
                                &nbsp;&nbsp;
                                <span class="timer">可容纳人数:${value.fieldVolume}</span>
                                &nbsp;&nbsp;
                                <span class="timer">评分:${value.fieldGrade}</span>
                            </div>
                        </a>
                    </li>
                `)
            }
        })
    }
})

var li_item = $('.tabs-bar').find('div').eq(0).css({'background':'#00A9E0','color':'#ecfafa'});
$('.tabs-bar').find('div').click(function () {
    $(".product-item").html('');
    var li_type = $(this).find('span').text();
    li_item.css({'background':'#ecfafa','color':'#444'});
    li_item = $(this).css({'background':'#00A9E0','color':'#ecfafa'});
    $.post({
        url:"/indexCon/selectFields",
        data:"fieldType="+li_type,
        dataType:"json",
        success:function (data) {
            allFieldData = data.data;
            $.each(allFieldData, function (index, value) {
                if (index < 8) {
                    $('.product-item').append(`
                    <li class="item">
                        <div class="prod-img sram-fake-table">
                            <a class="link sram-fake-table-cell"  href="/fieldinfo.html?id=${value.id}" target="_blank">
                                <img src="${value.fieldPictures[0].fieldPicture}"/>
                            </a>
                        </div>
                        <a  class="prod-desc" target="_blank" href="/fieldinfo.html?id=${value.id}">
                            <div class="prod-rental sram-ellipsis">
                                <span>￥${value.fieldMonthprice}</span>/月                                                                    
                            </div>
                            <div class="prod-title sram-ellipsis">
                                ${value.fieldName}                                                                  
                            </div>
                            <div class="prod-deposit-timer sram-ellipsis">
                                <span class="deposit">押金￥${value.fieldDeposit}</span>
                                &nbsp;&nbsp;
                                <span class="timer">可容纳人数:${value.fieldVolume}</span>
                                &nbsp;&nbsp;
                                <span class="timer">评分:${value.fieldGrade}</span>
                            </div>
                        </a>
                    </li>
                `)
                }
            })
        }
    })
})

// 展示租赁次数较多，好评较高的场地
var fieid_id ;
var allFieldData;

// 展示个人闲置商品
$.post({
    url:"/goodsManageCon/selectByType",
    dataType:"json",
    data:"goodsType="+"笔记本",
    success:function (data) {
        $.each(data.data, function (index, value) {
            if(index < 6){
                $('.ls-show').append(`
                <div class="ls-box ls">
                    <img src="${value.goodsPictures[0].goodsPicture}" height="180" width="175"/>
                    <div class="text-box">
                        <a  class="prod-desc" target="_blank" href="">
                            <div class="prod-rental sram-ellipsis">
                                <span>￥${value.goodsDayprice}</span>/天                                                                 </div>
                            <div class="prod-title sram-ellipsis">
                                ${value.goodsName}                                                                    </div>
                            <div class="prod-deposit-timer sram-ellipsis">
                                <span class="deposit">押金:￥${value.goodsDeposit}</span>
                                <br>
                                <span class="timer">￥${value.goodsWeekprice}</span>/周
                            </div>
                        </a>
                    </div>
                </div>
               `)
            }
        })
    }
})

var li_goods = $('.ls-items').find('li').eq(0).css('color','#00A9E0');
$('.ls-items').find('li').click(function () {
    $(".ls-show").html('');
    var li_goodstype = $(this).find('span').text();
    // alert(li_goodstype)
    li_goods.css('color','#444');
    li_goods = $(this).css('color','#00A9E0');
    $.post({
        url:"/goodsManageCon/selectByType",
        dataType:"json",
        data:"goodsType="+li_goodstype,
        success:function (data) {
            $.each(data.data, function (index, value) {
                if(index < 6){
                    $('.ls-show').append(`
                <div class="ls-box ls">
                    <img src="${value.goodsPictures[0].goodsPicture}" height="180" width="175"/>
                    <div class="text-box">
                        <a  class="prod-desc" target="_blank" href="">
                            <div class="prod-rental sram-ellipsis">
                                <span>￥${value.goodsDayprice}</span>/天                                                                 </div>
                            <div class="prod-title sram-ellipsis">
                                ${value.goodsName}                                                                    </div>
                            <div class="prod-deposit-timer sram-ellipsis">
                                <span class="deposit">押金:￥${value.goodsDeposit}</span>
                                <br>
                                <span class="timer">￥${value.goodsWeekprice}</span>/周
                            </div>
                        </a>
                    </div>
                </div>
               `)
                }
            })
        }
    })
})
