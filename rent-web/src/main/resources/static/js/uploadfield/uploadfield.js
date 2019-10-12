//图片上传预览功能
var userAgent = navigator.userAgent;
//用于判断浏览器类型
// 使用formData完成多图片上传
var formData = new FormData();
var formData3 = new FormData();
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
        formData3.append("file",docObj.files[0]);
        count = count+1;
    }else{
        for(var i=0; i<$(this)[0].files.length;i++){
            formData.append("file",$(this)[0].files[i]);
            formData3.append("file",$(this)[0].files[i]);
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
            formData=formData3;
        }else{
            formData3.delete("file");
            for(var i=0;i<formData.getAll("file").length;i++){
                if(formData.getAll("file")[i].name==$(this).parents(".imageDiv").attr("nm")){

                }else{
                    formData3.append("file",formData.getAll("file")[i]);
                }
            }
        }
        formData.delete("file");
        for(var i=0;i<formData3.getAll("file").length;i++){
            formData.append("file",formData3.getAll("file")[i]);
        }
        var _this = $(this);
        _this.parents(".imageDiv").remove();
    });
});

//限制商品名称输入框的字数
// function limit_name_words(){
//     //获取input输入框元素
//     var inputText = document.getElementById('goodsname').value;
//     if(inputText.length > 20){
//         var text = inputText.substring(0,20);
//         document.getElementById('goodsname').value = text;//重新设置input输入框的值
//         document.getElementById("goodsname-span").innerHTML="商品名称不能超过20个字符！";
//         document.getElementById("goodsname-span").style.color="#e5312a";
//     }else{
//         document.getElementById("goodsname-span").innerHTML="请输入商品名称！";
//         document.getElementById("goodsname-span").style.color="#0282d3";
//     }
//
// }

//限制商品名称输入框的字数
// function limit_model_words(){
//     //获取input输入框元素
//     var inputText = document.getElementById('goodsmodel').value;
//     if(inputText.length > 50){
//         var text = inputText.substring(0,50);
//         document.getElementById('goodsmodel').value = text;//重新设置input输入框的值
//         document.getElementById("goodsmodel-span").innerHTML="商品型号不能超过50个字符！";
//         document.getElementById("goodsmodel-span").style.color="#e5312a";
//     }else{
//         document.getElementById("goodsmodel-span").innerHTML="请输入商品型号！";
//         document.getElementById("goodsmodel-span").style.color="#0282d3";
//     }
//
// }

//评价字数限制
function words_deal() {

    var curLength=$("#filedinfo").val().length;
    if(curLength>140) {
        var num=$("#filedinfo").val().substr(0,140);
        $("#filedinfo").val(num);
        alert("超过字数限制，多出的字将被截断！" );
        $("#textCount").text(0);
    } else {
        $("#textCount").text(140-$("#filedinfo").val().length);
    }
}


//选择类型
$("#fieldtype-ul").find("li").click(function(){
    $("#fieldtype").val($(this).text());
});

var reg_id = $.cookie("id");
//添加地址到数据库
if(reg_id !=0 || reg_id != null){
    $('#submit-btn-add').click(function () {
        formData3.append("fieldName",$('#fieldname').val());
        // formData3.append("fieldArea", $('#fieldarea').val());
        formData3.append("fieldVolume", $('#fieldvolume').val());
        // alert( $('#fieldvolume').val())
        formData3.append("fieldAddress", $('#fieldaddress').val());
        formData3.append("fieldType", $('#fieldtype').val());
        var info = $('#filedinfo').val();
        formData3.append("fieldInfo",info);
        // alert(info)
        formData3.append("fieldDeposit",$('#fielddeposit').val());
        formData3.append("fieldArea",$('#fieldarea').val());
        formData3.append("fieldGrade",5);
        formData3.append("fieldCount",0);
        formData3.append("fieldHourprice",$('#fieldhourprice').val());
        formData3.append("fieldDayprice",$('#fielddayprice').val());
        formData3.append("fieldWeekprice",$('#fieldweekprice').val());
        formData3.append("fieldMonthprice",$('#fieldmonthprice').val());
        formData3.append("regId",reg_id);
        var up_fieldaddress = $('#fieldaddress').val();
        if(up_fieldaddress.indexOf('江苏省苏州市')!=-1){
            $.post({
                url:"/addField/insertRendField",
                data:formData3,
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
        }else{
            alert('地址输入有误')
        }
    })
}



