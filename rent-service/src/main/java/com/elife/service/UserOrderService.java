package com.elife.service;


import com.elife.pojo.UserOrder;

import java.util.List;


public interface UserOrderService {

    /**
     * 查询所有订单
     * @return
     */
    List<UserOrder> selectAllUserOrder();

}
