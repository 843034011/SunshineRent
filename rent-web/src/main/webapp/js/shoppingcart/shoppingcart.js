$(".choose-list").html("")

$.post({
    url:"/shoppingcart/selectall",
    dataType:"json",
    success:function (data) {
        $.each(data.data,function (index,value) {

            // 查找订单中的数量、租期

            var orderNumber = value.orderNumber

            var orderNumber = value.startTime

            var orderNumber = value.endTime


            if((value.fieldId != null) && (value.goodsId == null)){
                // 按Id查找场地图片、信息、押金、租金
                $.post({
                    url:"/shoppingcart/selectfieldbyid",
                    data:"id=" + value.fieldId,
                    dataType:"json",
                    success:function (data) {
                        $(".choose-list").append(
                            `
                            <li class="list" choosed="0">
                                <div class="col-md-2">
                                    <div class="choose-one-box text-left">
                
                                    </div>
                                    <!--<div><img src="${data.data.fieldPictures[0].fieldPicture}"></div>-->
                                    <div><img class="field_picture" src="http://img3.cache.netease.com/photo/0026/2014-01-20/9J08A41L4CJ80026.jpg"></div>
                                </div>
                
                                <div class="col-md-2 text-left">
                                    <span>【${data.data.fieldName}】</span>
                                    <span>${data.data.fieldInfo}</span>
                                </div>
                                <div class="col-md-1 text-center">${data.data.fieldDeposit}</div>
                                <div class="col-md-1 text-center">${data.data.fieldDayprice}/天</div>
                                <div class="col-md-1 text-center"><input class="order-number" type="number" value="1" min="1" max="1" step="1"></div>
                                <div class="col-md-2 text-center">租用日期</div>
                                <div class="col-md-1 text-center">金额</div>
                                <div class="col-md-2 text-center">
                                    <div class="col-md-6 text-center"><span>收藏</span></div>
                                    <div class="col-md-6 text-center"><span>删除</span></div>
                                </div>
                            </li>
                            `
                        )

                        // 将选择、全选的html设置为 ""
                        $(".choose-one-box").html("")
                        $(".choose-all").html("")

                        // 全选的click事件
                        $(".choose-all").click(function () {
                            if($(".choose-all").html() == ""){
                                $(".choose-all").html("<i class=\"icon-choose\"><img src=\"../img/shoppingcart/yes.png\" class=\"choosed\"></i>")
                                $(".choose-one-box").html("<i class=\"icon-choose\"><img src=\"../img/shoppingcart/yes.png\" class=\"choosed\"></i>")
                                $(".list").attr("choosed","1")
                                $(".list").addClass("curr")
                            } else {
                                $(".choose-all").html("")
                                $(".choose-one-box").html("")
                                $(".list").attr("choosed","0")
                                $(".list").removeClass("curr")
                            }
                        })

                        // 选择的click事件
                        $(".choose-one-box").click(function () {
                            if($(this).html() == ""){
                                $(this).html("<i class=\"icon-choose\"><img src=\"../img/shoppingcart/yes.png\" class=\"choosed\"></i>")
                                $(this).parent().parent().addClass("curr")
                                $(this).parent().parent().attr("choosed","1")
                                for (var i = 0 ; i < $(".choose-one-box").length; i ++){
                                    if($(".choose-one-box")[i].innerHTML == "<i class=\"icon-choose\"><img src=\"../img/shoppingcart/yes.png\" class=\"choosed\"></i>"){
                                        if(i == $(".choose-one-box").length - 1){
                                            $(".choose-all").html("<i class=\"icon-choose\"><img src=\"../img/shoppingcart/yes.png\" class=\"choosed\"></i>")
                                        }
                                        continue
                                    }else {
                                        break
                                    }
                                }
                            } else {
                                $(this).html("")
                                $(".choose-all").html("")
                                $(this).parent().parent().removeClass("curr")
                                $(this).parent().parent().attr("choosed","0")
                            }
                        })
                    }
                })
            } else if((value.fieldId == null) && (value.goodsId != null)){
                // 按Id查找商品图片、信息、押金、租金
            }




        })


    },
    error:function () {
        alert("失败了！！")
    }
})