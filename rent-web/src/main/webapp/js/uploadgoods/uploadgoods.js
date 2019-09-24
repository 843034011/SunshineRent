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



//获取系统当前时间
function getNowData() {
    function getNow(s) {//判断是否在前面加0
        return s < 10 ? '0' + s: s;
    }
    var myDate = new Date();
    var year=myDate.getFullYear();        //获取当前年
    var month=myDate.getMonth()+1;   //获取当前月
    var date=myDate.getDate();            //获取当前日
    var h=myDate.getHours();              //获取当前小时数(0-23)
    var m=myDate.getMinutes();          //获取当前分钟数(0-59)
    var s=myDate.getSeconds();
    var now=year+'-'+getNow(month)+"-"+getNow(date)+" "+getNow(h)+':'+getNow(m)+":"+getNow(s);
    return now;
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
function words_deal() {

    var curLength=$("#goodsinfo").val().length;
    if(curLength>140) {
        var num=$("#goodsinfo").val().substr(0,140);
        $("#goodsinfo").val(num);
        alert("超过字数限制，多出的字将被截断！" );
        $("#textCount").text(0);
    } else {
        $("#textCount").text(140-$("#goodsinfo").val().length);
    }
}

//选择商品类型
$("#goodstype-ul").find("li").click(function(){
    $("#goodstype").val($(this).text());
});

//添加商品到数据库
$('#submit-btn-add').click(function () {

    formData2.append("goodsName",$('#goodsname').val());
    formData2.append("goodsType", $('#goodstype').val());
    formData2.append("goodsModel",$('#goodsmodel').val());
    formData2.append("goodsInfo",$('#goodsinfo').val());
    formData2.append("goodsNumber",$('#goodsnumber').val());
    formData2.append("goodsDeposit",$('#goodsdeposit').val());
    formData2.append("goodsSurplus",0);
    formData2.append("goodsDayprice",$('#goodsdayprice').val());
    formData2.append("goodsWeekprice",$('#goodsweekprice').val());
    formData2.append("createTime",getNowData());
    formData2.append("goodsGrade",0);
    formData2.append("rentCount",0);
    formData2.append("regId",datas.regId);
    // formData2.append("id",datas.goodsPictures[0].id);
    formData2.append("goodsId",datas.id);
    // var postData = {
    //     "goodsName":$('#goodsname').val(),
    //     "goodsType":$('#goodstype').val(),
    //     "goodsModel":$('#goodsmodel').val(),
    //     "goodsInfo":$('#goodsinfo').val(),
    //     "goodsNumber":$('#goodsnumber').val(),
    //     "goodsDeposit":$('#goodsdeposit').val(),
    //     "goodsSurplus":0,
    //     "goodsDayprice":$('#goodsdayprice').val(),
    //     "goodsWeekprice":$('#goodsweekprice').val(),
    //     "createTime":getNowData(),
    //     "goodsGrade":0,
    //     "rentCount":0,
    //     // 另一个页面传过来
    //     "regId":4
    // }
    $.post({
        url:"/goodsManageCon/insertGood",
        data:formData2,
        dataType:"json",
        contentType:"application/json",
        cache: false, //上传文件不需要缓存
        processData: false,
        contentType: false,
        success:function (data) {
            if(data.code == 0) {
                alert("添加成功")
            } else {
                alert("添加失败")
            }
        }
    })
    // $.post({
    //     url:"/goodsManageCon/insertPic",
    //     data:formData2,
    //     dataType:"json",
    //     success:function (data) {
    //         if(data.code == 0) {
    //             alert("添加成功")
    //         } else {
    //             alert("添加失败")
    //         }
    //     }
    //
    // })
})

//修改商品信息
//接收商品页的id值
function getId(){
    var result;
    var url=window.location.search;
    //获取url中"?"符后的字串
    // if(url.indexOf("?")!=-1){
    result = url.substr(url.indexOf("=")+1);
    // }
    if(result != null){
        return result;
    }else{
        return 0;
    }
};
var datas;
if(getId()!=0){
    $.post({
        url: "/goodsManageCon/selectById",
        dataType: "json",
        data: "id=" + getId(),
        success: function (data) {
            datas = data.data;
            $('h4').text('修改商品信息')
            $('#submit-btn-add').css('display','none');
            $('#submit-btn-updata').css('display','block');
            $('#goodsname').val(datas.goodsName)
            $('#goodstype').val(datas.goodsType)
            $('#goodsmodel').val(datas.goodsModel)
            $('#goodsinfo').val(datas.goodsInfo)
            $('#goodsnumber').val(datas.goodsNumber)
            $('#goodsdeposit').val(datas.goodsDeposit)
            $('#goodssurplus').val(datas.goodsSurplus)
            $('#goodsdayprice').val(datas.goodsDayprice)
            $('#goodsweekprice').val(datas.goodsWeekprice)
            $('#goodsgrade').val(datas.goodsGrade)
            $('#rentcount').val(datas.rentCount)
            $('#submit-btn-updata').click(function () {
                // 修改商品
                // formData2.append("id",datas.id);
                formData2.append("goodsName",$('#goodsname').val());
                formData2.append("goodsType", $('#goodstype').val());
                formData2.append("goodsModel",$('#goodsmodel').val());
                formData2.append("goodsInfo",$('#goodsinfo').val());
                formData2.append("goodsNumber",$('#goodsnumber').val());
                formData2.append("goodsDeposit",$('#goodsdeposit').val());
                // formData2.append("goodsSurplus",$('#goodssurplus').val());
                formData2.append("goodsDayprice",$('#goodsdayprice').val());
                formData2.append("goodsWeekprice",$('#goodsweekprice').val());
                // formData2.append("createTime",datas.createTime);
                formData2.append("goodsGrade",datas.goodsGrade);
                formData2.append("rentCount",datas.rentCount);
                formData2.append("regId",datas.regId);
                formData2.append("id",datas.goodsPictures[0].id);
                formData2.append("goodsId",datas.id);
                // var updatagood = JSON.stringify(
                //     {
                //         "id":datas.id,
                //         "goodsName":$('#goodsname').val(),
                //         "goodsType":$('#goodstype').val(),
                //         "goodsModel":$('#goodsmodel').val(),
                //         "goodsInfo":$('#goodsinfo').val(),
                //         "goodsNumber":$('#goodsnumber').val(),
                //         "goodsDeposit":$('#goodsdeposit').val(),
                //         "goodsSurplus":datas.goodsSurplus,
                //         "goodsDayprice":$('#goodsdayprice').val(),
                //         "goodsWeekprice":$('#goodsweekprice').val(),
                //         "createTime":datas.createTime,
                //         "goodsGrade":datas.goodsGrade,
                //         "rentCount":datas.rentCount,
                //         "regId":datas.regId,
                //         "picId":datas.goodsPictures[0].id
                //     });
                // console.log(updatagood)
                $.ajax({
                    type:"post",
                    url:"/goodsManageCon/updataGood",
                    data:formData2,
                    contentType:"application/json",
                    dataType:"json",
                    processData: false, // 告诉jQuery不要去处理发送的数据
                    contentType: false, // 告诉jQuery不要去设置Content-Type请求头
                    cache: false, //上传文件不需要缓存
                    success:function (data) {
                        if(data.code == 0) {
                            alert("修改成功")
                        } else {
                            alert("修改失败")
                        }
                    }
                })
                // alert("datas.id:"+datas.id);
                // alert("id:"+datas.goodsPictures[0].id);
                // $.post({
                //     url:"/goodsManageCon/updataPic",
                //     data:{"id":datas.goodsPictures[0].id},
                //     // contentType:"application/json",
                //     dataType:"json",
                //     success:function (data) {
                //         if(data.code == 0) {
                //             alert("图片修改成功")
                //         } else {
                //             alert("图片修改失败")
                //         }
                //     }
                // })
            })
        }
    })
}

