var detailId =  sessionStorage.getItem("detail_id");
var orderDetaildata;


$.get({
    url:"/orderDetail/showOrderDetail",
    dataType:"json",   //text -》 data(string)    json ->(js中的json对象)
    data:{"detailId": detailId},
    success:function(data){
        console.log(data);
        if(data!=null){
            orderDetaildata = data.data;
            show(orderDetaildata);
        }else{
            alert("没有数据！")
        }
    }
})

function show(data){
    var startTime = changeDate(data.startTime);
    var endTime = changeDate(data.endTime);
    if(data.fieldId != null && data.goodsId == null){
        $('#evaluate-order-info').text("");
        $('#evaluate-order-info').append(
            `
                    <div class="col-xs-3 evaluate-order-img">
                        <a href="#"><img src="${data.extra3}"></a>
                    </div>
                    <div class="col-xs-1"></div>
                    <div class="col-xs-8 evaluate-order-info">
                        <div class="col-xs-12 evaluate-order-info-name"><a href="http://localhost:8080/fieldinfo.html?id=${data.fieldId}">${data.productName}</a></div>
                        <div class="col-xs-12 evaluate-order-info-weekprice">总价：<span class="glyphicon glyphicon-yen" aria-hidden="true">${data.productTotal}</span></div>
                        <div class="col-xs-6 evaluate-order-info-deposit">押金：<span class="glyphicon glyphicon-yen" aria-hidden="true">${data.productDeposit}</span></div>
                        <div class="col-xs-6 evaluate-order-info-dayprice">日租：<span class="glyphicon glyphicon-yen" aria-hidden="true">${data.productPrice}</span>&nbsp;/天</div>
                        <div class="col-xs-6 evaluate-order-info-grade">开始租用时间：${startTime}</div>
                        <div class="col-xs-6 evaluate-order-info-grade">结束租用时间：${endTime}</div>
                        <div class="col-xs-12 evaluate-order-info-address">地址：<span>${data.productAddress}</span></div>
                        <div class="col-xs-12 evaluate-order-info-phone">联系电话：<span>${data.masterPhone}</span></div>
                     </div>
                 `
        )
    }else if(data.fieldId == null && data.goodsId != null){
        $('#evaluate-order-info').text("");
        $('#evaluate-order-info').append(
            `
                    <div class="col-xs-3 evaluate-order-img">
                        <a href="#"><img src="${data.extra3}"></a>
                    </div>
                    <div class="col-xs-1"></div>
                    <div class="col-xs-8 evaluate-order-info">
                        <div class="col-xs-12 evaluate-order-info-name"><a href="#">${data.productName}</a></div>
                        <div class="col-xs-12 evaluate-order-info-weekprice">总价：<span class="glyphicon glyphicon-yen" aria-hidden="true">${data.productTotal}</span></div>
                        <div class="col-xs-6 evaluate-order-info-deposit">押金：<span class="glyphicon glyphicon-yen" aria-hidden="true">${data.productDeposit}</span></div>
                        <div class="col-xs-6 evaluate-order-info-dayprice">日租：<span class="glyphicon glyphicon-yen" aria-hidden="true">${data.productPrice}</span>&nbsp;/天</div>
                        <div class="col-xs-6 evaluate-order-info-grade">开始租用时间：${startTime}</div>
                        <div class="col-xs-6 evaluate-order-info-grade">结束租用时间：${endTime}</div>
                        <div class="col-xs-12 evaluate-order-info-address">产品型号：<span>${data.productModel}</span></div>
                        <div class="col-xs-12 evaluate-order-info-phone">联系电话：<span>${data.masterPhone}</span></div>
                     </div>
                 `
        )
    }

}


//图片上传预览功能
var userAgent = navigator.userAgent;
//用于判断浏览器类型
// 使用formData完成多图片上传
var formData = new FormData();
var formData2 = new FormData();
var count = 0;
$(".file").change(function() {
    //获取选择图片的对象
    var docObj = $(this)[0];
    var picDiv = $(this).parents(".picDiv");
    //得到所有的图片文件
    var fileList = docObj.files;
    //将图片数据放到formData中传递后台
    if($(this)[0].files.length==1){
        formData.append("file",docObj.files[0]);
        formData2.append("file",docObj.files[0]);
        count = count+1;
    }else{
        for(var i=0; i<$(this)[0].files.length;i++){
            formData.append("file",$(this)[0].files[i]);
            formData2.append("file",$(this)[0].files[i]);
        }
    }

    if( count > 5 ){
        console.log("超过五张！");
    }else{
        //循环遍历
        for (var i = 0; i < fileList.length; i++) {
            //动态添加html元素
            var picHtml = "<div class='imageDiv' nm='"+fileList[i].name+"'> <img id='img"
                + fileList[i].name + "' /> <div class='image-cover'><i class='delbtn'>删除</i></div></div>";
            console.log(picHtml);
            picDiv.prepend(picHtml);
            //获取图片imgi的对象
            var imgObjPreview = document.getElementById("img" + fileList[i].name);
            if (fileList && fileList[i]) {
                //图片属性
                imgObjPreview.style.display = 'block';
                imgObjPreview.style.width = '160px';
                imgObjPreview.style.height = '130px';
                //imgObjPreview.src = docObj.files[0].getAsDataURL();
                // 火狐7以上版本不能用上面的getAsDataURL()方式获取，需要以下方式
                if (userAgent.indexOf('MSIE') == -1) {
                    //IE以外浏览器
                    imgObjPreview.src = window.URL.createObjectURL(docObj.files[i]);
                    //获取上传图片文件的物理路径;
                    console.log(imgObjPreview.src);
                } else {
                    //IE浏览器
                    if (docObj.value.indexOf(",") != -1) {
                        var srcArr = docObj.value.split(",");
                        imgObjPreview.src = srcArr[i];
                    } else {
                        imgObjPreview.src = docObj.value;
                    }
                }
            }
        }
    }
    /*删除功能*/
    $(".delbtn").click(function() {
        if(formData.getAll("file").length==0){
            formData=formData2;
        }else{
            formData2.delete("file");
            for(var i=0;i<formData.getAll("file").length;i++){
                if(formData.getAll("file")[i].name==$(this).parents(".imageDiv").attr("nm")){

                }else{
                    formData2.append("file",formData.getAll("file")[i]);
                }
            }
        }
        formData.delete("file");
        for(var i=0;i<formData2.getAll("file").length;i++){
            formData.append("file",formData2.getAll("file")[i]);
        }
        var _this = $(this);
        _this.parents(".imageDiv").remove();
    });
});
$("#bbt").click(function(){
    var grade=$("#grade").val();
    var content=$("#TextArea1").val();
    formData2.append("grade",grade);
    formData2.append("content",content);
    formData2.append("orderId",30);
    console.log(formData2);

    $.ajax({
        type:'post',
        dataType:'json',
        data:formData2,
        url:'/test1',
        cache: false, //上传文件不需要缓存
        processData: false, // 告诉jQuery不要去处理发送的数据
        contentType: false, // 告诉jQuery不要去设置Content-Type请求头
        success:function(data){
            if(data == 0){
                console.log("====success====");
                alert("评价成功！")
                window.location.href="http://localhost:8080/index.html"
            }else{
                console.log("====fail====");
                alert("出错了！")
            }
        }
    })
})

/*将date类型的时间转换成string类型*/
function changeDate(date) {
    var str = date.split('T');
    var createTime = str[0];
    return createTime;
};