//导航栏点击切换
var $first = $('.nav-left').find('li').eq(0).css({'background-color':'#fff','color':'rgb(0,200,190)'});
$('.nav-left').find('li').click(function () {
    $first.css({'background-color':'rgb(0,200,190)','color':'#fff'});
    $first = $(this).css({'background-color':'#fff','color':'rgb(0,200,190)'});
})

//搜索栏取值
$('.selectsearch').find('.ul-in').find('li').click(function () {
    $(this).parent().parent().find('span').text($(this).text());
    // $(this).parent().parent().find('span').val();
})
$('.ul-out').find('li').click(function () {
    $(this).find('ul').slideToggle("slow");
})

$('.fieldinfo-search').click(function () {
    var li_city = $('.ul-out').find('.li-city').find('span').text();
    var li_type = $('.ul-out').find('.li-type').find('span').text();
    var li_num =  $('.ul-out').find('.li-num').find('span').text();
    var li_area = $('.ul-out').find('.li-area').find('span').text();
    alert(li_city+' '+li_type+' '+li_num+' '+li_area);
})