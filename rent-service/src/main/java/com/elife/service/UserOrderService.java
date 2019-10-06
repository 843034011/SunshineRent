package com.elife.service;


import com.elife.dto.TotalOrderResult;
import com.elife.pojo.UserOrder;

import java.util.List;

/**
 * @author byf
 */
public interface UserOrderService {

    /**
     * 查询所有订单
     * @return
     */
    List<UserOrder> selectAllUserOrder();

    /**
     * @author llb
     * 根据id查询待评价的场地起止日期
     * @param num
     * @return
     */
    List<UserOrder> selectFieldOrderDateUnEvaluate(Integer num);

    /**
     * @author llb
     * 根据id查询待评价的商品起止日期
     * @param num
     * @return
     */
    List<UserOrder> selectGoodsOrderDateUnEvaluate(Integer num);


    List<UserOrder>  selectAllByRentId(int rentId);

    UserOrder selectByOrderId(int orderId);

    int updateByPrimaryKey(UserOrder record);

    int insertOrder(TotalOrderResult totalOrderResult);
}
