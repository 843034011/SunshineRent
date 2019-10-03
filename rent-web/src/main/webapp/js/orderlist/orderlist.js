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
    }
})

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
/*查找未支付的订单*/
function findUnpaidorder(){
    var unpaidorderdata = new Array();
    for(var j=0;j<orderdatas.length;j++){
        if(orderdatas[j].rentId == regId ){
            if(orderdatas[j].orderStatus == "未支付"){
                unpaidorderdata.push(orderdatas[j]);
            }
        }
    }
    orderpaging(unpaidorderdata);
    findresultdata = unpaidorderdata;
}
/*查找未归还的订单*/
function findNoReturnOrder(){
    var noReturnOrderdata = new Array();
    for(var j=0;j<orderdatas.length;j++){
        if(orderdatas[j].rentId == regId ){
            if(orderdatas[j].orderStatus == "未归还"){
                noReturnOrderdata.push(orderdatas[j]);
            }
        }
    }
    orderpaging(noReturnOrderdata);
    findresultdata = noReturnOrderdata;
}
/*查找未评价的订单*/
function findNoEvaluatedOrder(){
    var noEvaluatedOrderdata = new Array();
    for(var j=0;j<orderdatas.length;j++){
        if(orderdatas[j].rentId == regId ){
            if(orderdatas[j].orderStatus == "未评价"){
                noEvaluatedOrderdata.push(orderdatas[j]);
            }
        }
    }
    orderpaging(noEvaluatedOrderdata);
    findresultdata = noEvaluatedOrderdata;
}



function findorderbytime(){
    var findresultdata2 = findresultdata;
    var findtimeorderdata = new Array();

    if($("#choose").val() == "all"){
        for(var j=0;j<findresultdata.length;j++){
            findtimeorderdata.push(findresultdata[j]);
        }
        orderpaging(findtimeorderdata);
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
        orderpaging(findtimeorderdata);
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
        orderpaging(findtimeorderdata);
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
        orderpaging(findtimeorderdata);
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
        totalPages = data.length/4+1;
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
                        + '</span>&nbsp;&nbsp;&nbsp;&nbsp;<span>订单号：</span><span>' + data[4 * n + i].id;

                    console.log("====================");
                    console.log("orderDetails.length = " + data[4 * n + i].orderDetails.length);
                    console.log("====================");
                    for(j=0;j<data[4 * n + i].orderDetails.length;j++){
                        html +='</span></div></div><div class="order-info-detail"><div><div class="order-info-detail-img"><img src="'+ data[4 * n + i].orderDetails[j].extra1 +'"></div>'
                            + '<div class="order-info-detail-info"><p><a>'+ data[4 * n + i].orderDetails[j].productName
                            + '</a></p><p>'+ data[4 * n + i].orderDetails[j].productType + '</p><p>'+ data[4 * n + i].orderDetails[j].productAddress + '</p></div></div>'
                            + '<div class="order-info-detail-number"><span>' + data[4 * n + i].orderDetails[j].productNumber + '</span></div>'
                            + '<div class="order-info-detail-total"><span>' + data[4 * n + i].orderDetails[j].productTotal + '</span></div>'
                            + '<div class="order-info-detail-status"><span>' + data[4 * n + i].orderDetails[j].productStatus + '</span></div>'
                            + '<div class="order-info-detail-operate"><a><span>追加评论</span></a></div></div></div>';
                    }
                }

            }else if(data.length-n*4>0){
                for(i=0;i<data.length-4*n;i++) {
                    var createTime = changeDate(data[4 * n + i].createTime);

                    html += '<div class="user-order-info"><div class="order-info-title-div"><div class="order-info-title"><span>' + createTime
                        + '</span>&nbsp;&nbsp;&nbsp;&nbsp;<span>订单号：</span><span>' + data[4 * n + i].id;

                    for(j=0;j<data[4 * n + i].orderDetails.length;j++){
                        html +='</span></div></div><div class="order-info-detail"><div><div class="order-info-detail-img"><img src="'+ data[4 * n + i].orderDetails[j].extra1 +'"></div>'
                            + '<div class="order-info-detail-info"><p><a>'+ data[4 * n + i].orderDetails[j].productName
                            + '</a></p><p>'+ data[4 * n + i].orderDetails[j].productType + '</p><p>'+ data[4 * n + i].orderDetails[j].productAddress + '</p></div></div>'
                            + '<div class="order-info-detail-number"><span>' + data[4 * n + i].orderDetails[j].productNumber + '</span></div>'
                            + '<div class="order-info-detail-total"><span>' + data[4 * n + i].orderDetails[j].productTotal + '</span></div>'
                            + '<div class="order-info-detail-status"><span>' + data[4 * n + i].orderDetails[j].productStatus + '</span></div>'
                            + '<div class="order-info-detail-operate"><a><span>追加评论</span></a></div></div></div>';
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
};

function sendInfotoEvaluate(index){

   var order_id = index;
   sessionStorage.setItem("order_id",order_id);

}