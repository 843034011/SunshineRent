package com.elife.service;

import com.elife.pojo.OrderDetail;

import java.util.List;

public interface OrderDetailRepository {

    OrderDetail save(OrderDetail orderDetail);

    List<OrderDetail> getByProductName(String productName);

}
