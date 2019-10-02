var orderdatas;
var databyrentID = new Array();
var i=0;
$.ajax({
    url:"/userorder/showallorders",
    dataType:"json",   //text -》 data(string)    json ->(js中的json对象)
    success:function(data){
        orderdatas=data.data;
        console.log(data);
        console.log(data.data.length);
        for(var j=0;j<data.data.length;j++){
            if(data.data[j].rentId == 3 ){
                databyrentID.push(data.data[j]);
                /*console.log(databyrentID);*/
            }
        }
        console.log(databyrentID);
        console.log(databyrentID.length);
        findresultdata = databyrentID;
        orderpaging(databyrentID);
    }
})

var findresultdata;
<!--查找全部订单-->
function findallorder(){
    var allorderdata = new Array();
    for(var j=0;j<orderdatas.length;j++){
        if(orderdatas[j].rentId == 3 ){
            allorderdata.push(orderdatas[j]);
            /*console.log(allorderdata);*/
        }
    }
    /*console.log(allorderdata);
    console.log(allorderdata.length);*/
    orderpaging(allorderdata);
    findresultdata = allorderdata;
    /*console.log(findresultdata);*/
}
<!--查找场地订单-->
function findfieldorder(){
    var fieldorderdata = new Array();
    for(var j=0;j<orderdatas.length;j++){
        if(orderdatas[j].rentId == 3 ){
            if(orderdatas[j].fieldId != null && orderdatas[j].goodsId == null){
                fieldorderdata.push(orderdatas[j]);
                /*console.log(fieldorderdata);*/
            }
        }
    }
    /*console.log(fieldorderdata);
    console.log(fieldorderdata.length);*/
    orderpaging(fieldorderdata);
    findresultdata = fieldorderdata;
    /*console.log(findresultdata);*/
}
<!--查找商品订单-->
function findgoodsorder(){
    var goodsorderdata = new Array();
    for(var j=0;j<orderdatas.length;j++){
        if(orderdatas[j].rentId == 3 ){
            if(orderdatas[j].fieldId == null && orderdatas[j].goodsId != null){
                goodsorderdata.push(orderdatas[j]);
                /*console.log(goodsorderdata);*/
            }
        }
    }
    /*console.log(goodsorderdata);
    console.log(goodsorderdata.length);*/
    orderpaging(goodsorderdata);
    findresultdata = goodsorderdata;
    /*console.log(findresultdata);
    console.log("length = " + findresultdata.length);*/
}

function findorderbytime(){
    var findresultdata2 = findresultdata;
    var findtimeorderdata = new Array();

    /* console.log(findresultdata);*/

    if($("#choose").val() == "all"){
        for(var j=0;j<findresultdata.length;j++){
            findtimeorderdata.push(findresultdata[j]);
        }
        /*console.log(findtimeorderdata);
        console.log(findtimeorderdata.length);*/
        orderpaging(findtimeorderdata);
    }
    if($("#choose").val() == "week"){
        var date1 = new Date();
        var date2 = new Date();
        date1.setDate(date1.getDate() - 7);

        for(var j=0;j<findresultdata.length;j++){
            var createTime = new Date(findresultdata[j].createTime);
            /*console.log("createTime = " + createTime);*/
            if(createTime > date1 &&  createTime < date2){
                findtimeorderdata.push(findresultdata[j]);
            }
        }
        /*console.log(findtimeorderdata);
        console.log(findtimeorderdata.length);*/
        orderpaging(findtimeorderdata);
    }
    if($("#choose").val() == "month"){
        var date1 = new Date();
        var date2 = new Date();
        date1.setDate(date1.getDate() - 30);

        for(var j=0;j<findresultdata.length;j++){
            var createTime = new Date(findresultdata[j].createTime);
            /*console.log("createTime = " + createTime);*/
            if(createTime > date1 &&  createTime < date2){
                findtimeorderdata.push(findresultdata[j]);
            }
        }
        /*console.log(findtimeorderdata);
        console.log(findtimeorderdata.length);*/
        orderpaging(findtimeorderdata);
    }
    if($("#choose").val() == "halfyear"){
        var date1 = new Date();
        var date2 = new Date();
        date1.setDate(date1.getDate() - 180);

        for(var j=0;j<findresultdata.length;j++){
            var createTime = new Date(findresultdata[j].createTime);
            /*console.log("createTime = " + createTime);*/
            if(createTime > date1 &&  createTime < date2){
                findtimeorderdata.push(findresultdata[j]);
            }
        }
        /*console.log(findtimeorderdata);
        console.log(findtimeorderdata.length);*/
        orderpaging(findtimeorderdata);
    }
    if($("#choose").val() == "year"){
        var date1 = new Date();
        var date2 = new Date();
        date1.setDate(date1.getDate() - 365);

        for(var j=0;j<findresultdata.length;j++){
            var createTime = new Date(findresultdata[j].createTime);
            /*console.log("createTime = " + createTime);*/
            if(createTime > date1 &&  createTime < date2){
                findtimeorderdata.push(findresultdata[j]);
            }
        }
        /*console.log(findtimeorderdata);
        console.log(findtimeorderdata.length);*/
        orderpaging(findtimeorderdata);
    }
}

function findorderbyid(){
    var data = new Array();

    var orderID = document.getElementById("order-id-input").value;
    console.log("orderID = " + orderID);

    for(var j=0;j<databyrentID.length;j++){
        if(databyrentID[j].id == orderID ){
            data.push(databyrentID[j])
        }
    }
    if(data != null && data.length>0){
        orderpaging(data);
    }else{
        alert("没有找到该订单！请重新输入！")
    }
}
function orderpaging(data){
    var totalPages;
    if(data.length%4 == 0 ){
        totalPages = data.length/4;
    }else{
        totalPages = data.length/4+1
    }

    $.jqPaginator('#pagination2',{

        totalPages:Math.floor(totalPages),
        visiblePages:Math.floor(totalPages),
        currentPage:1,
        pageSize:4,
        first: '<li class="first"><a href="javascript:void(0);">首页</a></li>',
        prev: '<li class="prev"><a href="javascript:;">上一页</a></li>',
        next: '<li class="next"><a href="javascript:void(0);">下一页</a></li>',
        last: '<li class="last"><a href="javascript:void(0);">尾页</a></li>',
        page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
        onPageChange:function(num,type){
            console.log(data.length/4+1);
            console.log(Math.floor(data.length/4+1));
            var n=num-1;
            var html  = ''
            if(data.length-n*4>=4){
                for(i=0;i<4;i++) {
                    var createTime = changeDate(data[4 * n + i].createTime);


                    html += '<div class="user-order-info"><div class="order-info-title-div"><div class="order-info-title"><span>' + createTime
                        + '</span>&nbsp;&nbsp;&nbsp;&nbsp;<span>订单号：</span><span>' + data[4 * n + i].orderNumber
                        + '</span></div></div><div class="order-info-detail"><div><div class="order-info-detail-img"><img src="http://pxm37tv32.bkt.clouddn.com/f14-1%20-%20%E5%89%AF%E6%9C%AC.png"></div>'
                        + '<div class="order-info-detail-info"><p><a>太湖之星泳池派对别墅</a></p><p>派对沙龙</p><p>江苏省苏州市吴中区香山街道太湖之星</p></div></div>'
                        + '<div class="order-info-detail-number"><span>' + data[4 * n + i].orderNumber + '</span></div>'
                        + '<div class="order-info-detail-total"><span>' + data[4 * n + i].orderPrice + '</span></div>'
                        + '<div class="order-info-detail-status"><span>' + data[4 * n + i].orderStatus + '</span></div>'
                        + '<div class="order-info-detail-operate"><a><span>追加评论</span></a></div></div></div>';

                   /* if (i % 2 == 0) {
                        html += '<div class="OrderListShowdiv odd-column">';
                    } else {
                        html += '<div class="OrderListShowdiv even-column">';
                    }

                    html += '<div><span>' + data[8 * n + i].id +'</span></div><div><span>'
                        + createTime + '</span></div><div><span>' + data[8 * n + i].orderNumber +'</span></div><div><span>'
                        + data[8 * n + i].orderPrice +'</span></div><div><span>' + data[8 * n + i].orderStatus +'</span></div><div><span>';

                    if (data[8 * n + i].orderStatus == "未评价") {
                        html += '<a href="#">查看详情</a><a href="/userorder/evaluate" onclick="sendInfotoEvaluate(' + data[8 * n + i].id +')">添加评价</a></span></div></div>';
                    } else {
                        html += '<a href="#">查看详情</a></span></div></div>';
                    }*/
                }

            }else if(data.length-n*4>0){
                for(i=0;i<data.length-4*n;i++) {
                    var createTime = changeDate(data[4 * n + i].createTime);

                    html += '<div class="user-order-info"><div class="order-info-title-div"><div class="order-info-title"><span>' + createTime
                        + '</span>&nbsp;&nbsp;&nbsp;&nbsp;<span>订单号：</span><span>' + data[4 * n + i].orderNumber
                        + '</span></div></div><div class="order-info-detail"><div><div class="order-info-detail-img"><img src="http://pxm37tv32.bkt.clouddn.com/f14-1%20-%20%E5%89%AF%E6%9C%AC.png"></div>'
                        + '<div class="order-info-detail-info"><p><a>太湖之星泳池派对别墅</a></p><p>派对沙龙</p><p>江苏省苏州市吴中区香山街道太湖之星</p></div></div>'
                        + '<div class="order-info-detail-number"><span>' + data[4 * n + i].orderNumber + '</span></div>'
                        + '<div class="order-info-detail-total"><span>' + data[4 * n + i].orderPrice + '</span></div>'
                        + '<div class="order-info-detail-status"><span>' + data[4 * n + i].orderStatus + '</span></div>'
                        + '<div class="order-info-detail-operate"><a><span>追加评论</span></a></div></div></div>';


                   /* html += '<div><span>' + data[8 * n + i].id +'</span></div><div><span>'
                        + createTime + '</span></div><div><span>' + data[8 * n + i].orderNumber +'</span></div><div><span>'
                        + data[8 * n + i].orderPrice +'</span></div><div><span>' + data[8 * n + i].orderStatus +'</span></div><div><span>';

                    if (data[8 * n + i].orderStatus == "未评价") {
                        html += '<a href="#">查看详情</a><a href="/userorder/evaluate" onclick="sendInfotoEvaluate(' + data[8 * n + i].id +')">添加评价</a></span></div></div>';
                    } else {
                        html += '<a href="#">查看详情</a></span></div></div>';
                    }*/
                }
            }
            $('#field-goods-order').html(html)
        }
    })
}

function changeDate(date) {
    var str = date.split('T');
    var str1=str[1].split('.');
    var createTime = str[0]+" "+str1[0];
    return createTime;
};

function sendInfotoEvaluate(index){

   var order_id = index;
   sessionStorage.setItem("order_id",order_id);

}