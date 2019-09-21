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
$("#submit-btn").click(function(){
    $.ajax({
        type:'post',
        dataType:'json',
        data:formData2,
        cache: false, //上传文件不需要缓存
        url:'/evaluate/evaluateData',
        processData: false, // 告诉jQuery不要去处理发送的数据
        contentType: false, // 告诉jQuery不要去设置Content-Type请求头
        success:function(data){
            if(data.success=='ok'){
                console.log("====success====");
            }else{
                console.log("====fail====");
            }
        }
    })
})