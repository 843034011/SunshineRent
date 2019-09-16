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