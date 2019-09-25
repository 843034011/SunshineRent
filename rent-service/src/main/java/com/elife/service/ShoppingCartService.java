package com.elife.service;

import com.elife.pojo.RentField;
import com.elife.pojo.RentGoods;
import com.elife.pojo.UserOrder;

import java.util.List;

/**
 * @author llb
 */
public interface ShoppingCartService {

    /**
     * 根据regId查询所有未支付的订单
     * @return
     */
    List<UserOrder> selectAllUserOrderUnpaidById(Integer regId);

    /**
     * 根据id查找场地及场地图片的信息
     * @param id
     * @return
     */
    RentField selectFieldById(Integer id);

    /**
     * 根据id查找商品及商品图片的信息
     * @param id
     * @return
     */
    RentGoods selectGoodsById(Integer id);

    /**
     * 根据id删除购物车表内信息
     * @param shoppingId
     * @return
     */
    int deleteByShoppingId(Integer shoppingId);
}
