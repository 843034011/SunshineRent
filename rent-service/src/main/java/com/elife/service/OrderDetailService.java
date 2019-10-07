package com.elife.service;

import com.elife.dto.OrderResult;
import com.elife.pojo.OrderDetail;
import com.elife.pojo.RentField;
import com.elife.pojo.RentGoods;

import java.util.List;

public interface OrderDetailService {

    /**
     * 根据order_detail表中的id字段查询相关信息
     * @param id
     * @return
     */
    OrderDetail selectById(Integer id);

    /**
     * 查询场地的被禁用时间
     * @param num
     * @return
     */
    List<OrderDetail> selectFieldOrderDateUnEvaluate(Integer num);

    /**
     * 查询商品的被禁用时间
     * @param num
     * @return
     */
    List<OrderDetail> selectGoodsOrderDateUnEvaluate(Integer num);

    int insertOrderDetailField(OrderResult orderResult, RentField rentField, String orderId);

    int insertOrderDetailGoods(OrderResult orderResult, RentGoods rentGoods, String orderId);
}
