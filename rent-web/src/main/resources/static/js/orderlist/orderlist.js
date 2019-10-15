// $(document).ready(function(){
//     $(function() {
//         $('.header').load('../headerandfooter/header/publicheader.html');
//     });
// })


// 从cookie中获取当前用户的regId
var regId = $.cookie("id");
console.log("regId = " + regId);

var orderdatas;
var databyrentID = new Array();
var i=0;
$.ajax({
    url:"/userorder/showallorders",
    dataType:"json",
    data:{"regId":regId},
    success:function(data){
        if(data.code == 0){
            orderdatas=data.data;
            console.log(data);
            console.log(data.data.length);
            for(var j=0;j<data.data.length;j++){
                if(data.data[j].rentId == regId ){
                    databyrentID.push(data.data[j]);
                    /*console.log(databyrentID);*/
                }
            }
            console.log(databyrentID);
            console.log(databyrentID.length);
            findresultdata = databyrentID;
            orderpaging(databyrentID);
        }else if(data.code == 3){
            console.log("该用户没有订单信息！")
            alert("您还没有订单哦！请先下单后再查看订单信息！")
            window.location.href="https://127.0.0.1/index.html"
        }else{
            console.log("数据异常！")
        }
    }

});

var findresultdata;
<!--查找全部订单-->
function findallorder(){
    var allorderdata = new Array();
    for(var j=0;j<orderdatas.length;j++){
        if(orderdatas[j].rentId == regId ){
            allorderdata.push(orderdatas[j]);
        }
    }
    orderpaging(allorderdata);
    findresultdata = allorderdata;
}
/*查找未归还的订单*/
function findNoReturnOrder(){
    var noReturnOrderdata = new Array();
    for(var m=0;m<orderdatas.length;m++){
        for(var n=0;n<orderdatas[m].orderDetails.length;n++){
            if(orderdatas[m].rentId == regId ){
                if(orderdatas[m].orderDetails[n].productStatus == "未归还"){
                    noReturnOrderdata.push(orderdatas[m]);
                }
            }
        }
    }
    if( noReturnOrderdata.length == 0 ){
        nodata();
    }else{
        console.log(noReturnOrderdata);
        console.log(noReturnOrderdata.length);
        orderpaging(noReturnOrderdata);
        findresultdata = noReturnOrderdata;
    }
}
/*查找未评价的订单*/
function findNoEvaluatedOrder(){
    var noEvaluatedOrderdata = new Array();
    for(var m=0;m<orderdatas.length;m++){
        for(var n=0;n<orderdatas[m].orderDetails.length;n++){
            if(orderdatas[m].orderDetails[n].productStatus == "未评价"){
                noEvaluatedOrderdata.push(orderdatas[m]);
            }
        }
    }

    if(noEvaluatedOrderdata.length == 0 ){
        nodata();
    }else{
        console.log(noEvaluatedOrderdata);
        console.log(noEvaluatedOrderdata.length);
        orderpaging(noEvaluatedOrderdata);
        findresultdata = noEvaluatedOrderdata;
    }
}



function findorderbytime(){
    var findresultdata2 = findresultdata;
    var findtimeorderdata = new Array();

    if($("#choose").val() == "all"){
        for(var j=0;j<findresultdata.length;j++){
            findtimeorderdata.push(findresultdata[j]);
        }
        if(findtimeorderdata.length == 0 ){
            nodata();
        }else{
            console.log(findtimeorderdata);
            console.log(findtimeorderdata.length);
            orderpaging(findtimeorderdata);
        }
    }
    if($("#choose").val() == "week"){
        var date1 = new Date();
        var date2 = new Date();
        date1.setDate(date1.getDate() - 7);

        for(var j=0;j<findresultdata.length;j++){
            var createTime = new Date(findresultdata[j].createTime);
            if(createTime > date1 &&  createTime < date2){
                findtimeorderdata.push(findresultdata[j]);
            }
        }
        if(findtimeorderdata.length == 0 ){
            nodata();
        }else{
            console.log(findtimeorderdata);
            console.log(findtimeorderdata.length);
            orderpaging(findtimeorderdata);
        }
    }
    if($("#choose").val() == "month"){
        var date1 = new Date();
        var date2 = new Date();
        date1.setDate(date1.getDate() - 30);

        for(var j=0;j<findresultdata.length;j++){
            var createTime = new Date(findresultdata[j].createTime);
            if(createTime > date1 &&  createTime < date2){
                findtimeorderdata.push(findresultdata[j]);
            }
        }
        if(findtimeorderdata.length == 0 ){
            nodata();
        }else{
            console.log(findtimeorderdata);
            console.log(findtimeorderdata.length);
            orderpaging(findtimeorderdata);
        }
    }
    if($("#choose").val() == "halfyear"){
        var date1 = new Date();
        var date2 = new Date();
        date1.setDate(date1.getDate() - 180);

        for(var j=0;j<findresultdata.length;j++){
            var createTime = new Date(findresultdata[j].createTime);
            if(createTime > date1 &&  createTime < date2){
                findtimeorderdata.push(findresultdata[j]);
            }
        }
        if(findtimeorderdata.length == 0 ){
            nodata();
        }else{
            console.log(findtimeorderdata);
            console.log(findtimeorderdata.length);
            orderpaging(findtimeorderdata);
        }
    }
    if($("#choose").val() == "year"){
        var date1 = new Date();
        var date2 = new Date();
        date1.setDate(date1.getDate() - 365);

        for(var j=0;j<findresultdata.length;j++){
            var createTime = new Date(findresultdata[j].createTime);
            if(createTime > date1 &&  createTime < date2){
                findtimeorderdata.push(findresultdata[j]);
            }
        }

        if(findtimeorderdata.length == 0 ){
            nodata();
        }else{
            console.log(findtimeorderdata);
            console.log(findtimeorderdata.length);
            orderpaging(findtimeorderdata);
        }
    }
}

function findorderbyName(){
    var findresultdata3;
    var findresultByName = new Array();

    var keywords = document.getElementById("order-id-input").value;


    console.log("keywords = " + keywords);
    console.log("regId = " + regId);


    $.ajax({
        url:"/ESTest",
        dataType:"json",
        data:{"regId":regId,"keywords":keywords},
        success:function(data){
            findresultdata3=data.data;
            console.log(data);
            console.log(data.data.length);
            for(var j=0;j<data.data.length;j++){
                if(data.data[j].rentId == regId ){
                    findresultByName.push(data.data[j]);
                }
            }
            if(findresultByName.length == 0 ){
                nodata();
            }else{
                console.log(findresultByName);
                console.log(findresultByName.length);
                orderpaging(findresultByName);
            }


        }
    })


}

function nodata(){
    var html  = '';
    console.log("没有查到符合条件的数据！")
    html +=  '<div class="MyOrderPersonalList" id="field-goods-order"><div class="noDataTips" style="height:500px;width:960px;margin-top:50px;">' +
        '<img src="../img/orderlist/icon_page_noData.png" height="337" width="400"/>' +
        '<p style="color:#666;font-size:16px;">暂无订单</p>' +
        '<p style="color:#999;font-size:12px;">快去挑选商品或场地吧</p>' +
        '<button type="button" class="btn btn-primary" onclick="jumptoindex()">前往首页</button>'+
        '</div></div> ';
    $('#data-page-div').html(html);
}

function jumptoindex(){
    window.location.href="https://127.0.0.1/index.html";
}


function orderpaging(data){
    var totalPages;
    if(data.length%4 == 0 ){
        totalPages = data.length/4;
    }else{
        totalPages = data.length/4+1;
    }
    var html1  = '';
    html1 +='<div class="MyOrderPersonalList" id="field-goods-order"></div>' +
        '<div class="pagination-nav"><ul class="pagination" id="pagination2"></ul></div>';


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
            var html = '';
            if(data.length-n*4>=4){
                for(i=0;i<4;i++) {
                    var createTime = changeDate(data[4 * n + i].createTime);


                    html += '<div class="user-order-info"><div class="order-info-title-div"><div class="order-info-title"><span>' + createTime
                        + '</span>&nbsp;&nbsp;&nbsp;&nbsp;<span>订单号：</span><span>' + data[4 * n + i].orderNo;

                    for(j=0;j<data[4 * n + i].orderDetails.length;j++){
                        html +='</span></div></div><div class="order-info-detail"><div><div class="order-info-detail-img"><img src="'+ data[4 * n + i].orderDetails[j].extra3 +'"></div>'
                            + '<div class="order-info-detail-info"><p><a>'+ data[4 * n + i].orderDetails[j].productName
                            + '</a></p><p>'+ data[4 * n + i].orderDetails[j].productType + '</p><p>'+ data[4 * n + i].orderDetails[j].productAddress + '</p></div></div>'
                            + '<div class="order-info-detail-number"><span>' + data[4 * n + i].orderDetails[j].productNumber + '</span></div>'
                            + '<div class="order-info-detail-total"><span>' + data[4 * n + i].orderDetails[j].productTotal + '</span></div>'
                            + '<div class="order-info-detail-status"><span>' + data[4 * n + i].orderDetails[j].productStatus + '</span></div>';
                        if( data[4 * n + i].orderDetails[j].productStatus == "未归还" ){
                            html += '<div class="order-info-detail-operate"><a><span>查看详情</span></a><br><a onclick="giveBack(' + data[4 * n + i].orderDetails[j].id +')"><span>立即归还</span></a></div></div></div>';
                        }else if( data[4 * n + i].orderDetails[j].productStatus == "未评价" ){
                            html += '<div class="order-info-detail-operate"><a><span>查看详情</span></a><br><a href="/userorder/evaluate" onclick="sendInfotoEvaluate(' + data[4 * n + i].orderDetails[j].id +')"><span>立即评价</span></a></div></div></div>';
                        }else if( data[4 * n + i].orderDetails[j].productStatus == "已完成" ){
                            html += '<div class="order-info-detail-operate"><a><span>查看详情</span></a></div></div></div>';
                        }else{
                            html += '<div class="order-info-detail-operate"><a><span>查看详情</span></a></div></div></div>';
                        }
                    }
                }

            }else if(data.length-n*4>0){
                for(i=0;i<data.length-4*n;i++) {
                    var createTime = changeDate(data[4 * n + i].createTime);

                    html += '<div class="user-order-info"><div class="order-info-title-div"><div class="order-info-title"><span>' + createTime
                        + '</span>&nbsp;&nbsp;&nbsp;&nbsp;<span>订单号：</span><span>' + data[4 * n + i].orderNo;

                    for(j=0;j<data[4 * n + i].orderDetails.length;j++){
                        html +='</span></div></div><div class="order-info-detail"><div><div class="order-info-detail-img"><img src="'+ data[4 * n + i].orderDetails[j].extra3 +'"></div>'
                            + '<div class="order-info-detail-info"><p><a>'+ data[4 * n + i].orderDetails[j].productName
                            + '</a></p><p>'+ data[4 * n + i].orderDetails[j].productType + '</p><p>'+ data[4 * n + i].orderDetails[j].productAddress + '</p></div></div>'
                            + '<div class="order-info-detail-number"><span>' + data[4 * n + i].orderDetails[j].productNumber + '</span></div>'
                            + '<div class="order-info-detail-total"><span>' + data[4 * n + i].orderDetails[j].productTotal + '</span></div>'
                            + '<div class="order-info-detail-status"><span>' + data[4 * n + i].orderDetails[j].productStatus + '</span></div>';
                        if( data[4 * n + i].orderDetails[j].productStatus == "未归还" ){
                            html += '<div class="order-info-detail-operate"><a><span>查看详情</span></a><br><a onclick="giveBack(' + data[4 * n + i].orderDetails[j].id +')"><span>立即归还</span></a></div></div></div>';
                        }else if( data[4 * n + i].orderDetails[j].productStatus == "未评价" ){
                            html += '<div class="order-info-detail-operate"><a><span>查看详情</span></a><br><a href="/userorder/evaluate" onclick="sendInfotoEvaluate(' + data[4 * n + i].orderDetails[j].id +')"><span>立即评价</span></a></div></div></div>';
                        }else if( data[4 * n + i].orderDetails[j].productStatus == "已完成" ){
                            html += '<div class="order-info-detail-operate"><a><span>查看详情</span></a></div></div></div>';
                        }else{
                            html += '<div class="order-info-detail-operate"><a><span>查看详情</span></a></div></div></div>';
                        }
                    }
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
}

function sendInfotoEvaluate(index){

   var detail_id = index;
   sessionStorage.setItem("detail_id",detail_id);

}

function giveBack(index){
    alert("是否归还租品！");
    var detailId  = index;
    $.ajax({
        type: "post",
        url: "/orderDetail/giveback",
        dataType: "json",   //text -》 data(string)    json ->(js中的json对象)
        data: {"detailId":detailId},
        success: function (data) {
            if(data.code == 0 ){
                alert("归还成功！")
            }else{
                alert("归还失败！")
            }
        }
    })
}