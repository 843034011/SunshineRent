/* 返回首页 */
document.getElementById("return-aa").onmouseover=function(){

    document.getElementById("return-aaa").style="color:#fff;background-color:#3a81fd;";
}

document.getElementById("return-aa").onmouseout=function(){

    document.getElementById("return-aaa").style="color:#3a81fd;background-color:#fff;";
}

//限制商品名称输入框的字数
function limit_name_words(){
    //获取input输入框元素
    var inputText = document.getElementById('goodsname').value;
    if(inputText.length > 20){
        var text = inputText.substring(0,20);
        document.getElementById('goodsname').value = text;//重新设置input输入框的值
        document.getElementById("goodsname-span").innerHTML="商品名称不能超过20个字符！";
        document.getElementById("goodsname-span").style.color="#e5312a";
    }else{
        document.getElementById("goodsname-span").innerHTML="请输入商品名称！";
        document.getElementById("goodsname-span").style.color="#0282d3";
    }

}

//选择商品类型
$("#goodstype-ul").on("click", "li", function(){
    $("#goodstype").val($(this).text());
});

//限制商品名称输入框的字数
function limit_model_words(){
    //获取input输入框元素
    var inputText = document.getElementById('goodsmodel').value;
    if(inputText.length > 50){
        var text = inputText.substring(0,50);
        document.getElementById('goodsmodel').value = text;//重新设置input输入框的值
        document.getElementById("goodsmodel-span").innerHTML="商品型号不能超过50个字符！";
        document.getElementById("goodsmodel-span").style.color="#e5312a";
    }else{
        document.getElementById("goodsmodel-span").innerHTML="请输入商品型号！";
        document.getElementById("goodsmodel-span").style.color="#0282d3";
    }

}

//评价字数限制
function words_deal()
{
    var curLength=$("#goodsinfo").val().length;
    if(curLength>140)
    {
        var num=$("#goodsinfo").val().substr(0,140);
        $("#goodsinfo").val(num);
        alert("超过字数限制，多出的字将被截断！" );
        $("#textCount").text(0);
    }
    else
    {
        $("#textCount").text(140-$("#goodsinfo").val().length);
    }
}