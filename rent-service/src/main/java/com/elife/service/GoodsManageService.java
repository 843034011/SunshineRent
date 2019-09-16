package com.elife.service;

import com.elife.pojo.RentGoods;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:zgy
 */
@Service
public interface GoodsManageService {

    /**
     * 通过用户id查找商品 ，一个用户多个商品
     * @return 返回商品集合
     */
    List<RentGoods> selectByRegId(Integer regId);
}
