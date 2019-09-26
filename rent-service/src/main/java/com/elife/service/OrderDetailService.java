package com.elife.service;

import com.elife.pojo.OrderDetail;

public interface OrderDetailService {

    /**
     * 根据order_detail表中的id字段查询相关信息
     * @param id
     * @return
     */
    OrderDetail selectById(Integer id);

}
