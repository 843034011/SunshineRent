package com.elife.service;

import com.elife.pojo.RentField;
import com.elife.pojo.UserOrder;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ShoppingCartService {

    /**
     * 查询所有未支付的订单
     * @return
     */
    List<UserOrder> selectAllUserOrderUnpaid();

    RentField selectFieldById(Integer id);
}
