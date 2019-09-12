package com.elife.service;

import com.elife.dto.ShoppingCartResult;
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

    /**
     * 根据id查找场地及场地图片的信息
     * @param id
     * @return
     */
    ShoppingCartResult selectFieldById(Integer id);
}
