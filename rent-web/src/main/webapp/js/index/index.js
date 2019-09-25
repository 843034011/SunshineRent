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

//顶部导航栏
$('.items').html(
    ' <li class="item"><a href="/shoppingcart/showcart?regId='+$.cookie("id")+
    '                        ">购物车</a></li>\n' +
    '                        <li class="item"><a href="">商家旺铺</a></li>\n' +
    '                        <li class="item"><a href="">咨询中心</a></li>\n' +
    '                        <li class="item"><a href="/goodsManageCon/showManage">个人中心</a></li>\n' +
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


//搜索框相关
var $li_i = $('#ul-search').find('li').find('i').eq(0).css('background-color','#0abfb6');
getValue()
getValue2();
$('#ul-search').find('li').click(function () {
    getValue2();
    $li_i.css('background-color','#fff');
    $li_i = $(this).find('i').css('background-color','#0abfb6');
    if($(this).val() == 0){
        $('.div-show').html(
            '           <table>\n' +
            '                <tr>\n' +
            '                    <td>场地</td>\n' +
            '                    <td>\n' +
            '                        <span>教育</span>\n' +
            '                        <span>娱乐</span>\n' +
            '                        <span>办公</span>\n' +
            '                        <span>教育</span>\n' +
            '                        <span>娱乐</span>\n' +
            '                        <span>办公</span>\n' +
            '                        <span>教育</span>\n' +
            '                    </td>\n' +
            '                </tr>\n' +
            '                <tr>\n' +
            '                    <td>商品</td>\n' +
            '                    <td>\n' +
            '                        <span>电脑</span>\n' +
            '                        <span>打印机</span>\n' +
            '                        <span>手机</span>\n' +
            '                    </td>\n' +
            '                </tr>\n' +
            '            </table>')
        getValue()
    }else if($(this).val() == 1){
        $('.div-show').html(
            '           <table>\n' +
            '                <tr>\n' +
            '                    <td>场地</td>\n' +
            '                    <td>\n' +
            '                        <span>教育</span>\n' +
            '                        <span>娱乐</span>\n' +
            '                        <span>办公</span>\n' +
            '                        <span>教育</span>\n' +
            '                        <span>娱乐</span>\n' +
            '                        <span>办公</span>\n' +
            '                        <span>教育</span>\n' +
            '                    </td>\n' +
            '                </tr>\n' +
            '            </table>');
        getValue()
    }else if($(this).val() == 2){
        $('.div-show').html(
            '           <table>\n' +
            '                <tr>\n' +
            '                    <td>商品</td>\n' +
            '                    <td>\n' +
            '                        <span>电脑</span>\n' +
            '                        <span>打印机</span>\n' +
            '                        <span>手机</span>\n' +
            '                    </td>\n' +
            '                </tr>\n' +
            '            </table>');
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