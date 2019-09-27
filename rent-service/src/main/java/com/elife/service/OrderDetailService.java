package com.elife.service;

import com.elife.pojo.OrderDetail;

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
}
