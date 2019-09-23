package com.elife.service;

import com.elife.pojo.GoodsPicture;
import com.elife.pojo.RentGoods;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author:zgy
 */
@Repository
public interface GoodsManageService {

    /**
     * 通过用户id查找商品 ，一个用户多个商品
     * @return 返回商品集合
     */
    List<RentGoods> selectByRegId(Integer regId);

    /**
     * 通过商品id查找商品
     * @return 返回商品
     */
    RentGoods selectById(Integer id);

    /**
     * @param record
     * @return
     */
    int updataGood(RentGoods record);
    /**
     * @param goodsPicture
     * @return
     */
    int updataPic(GoodsPicture goodsPicture);

    /**
     * @author zgy
     * @param rentGood
     * @return 返回修改行数
     */
    int insertGood(RentGoods rentGood);

    /**
     * @author zgy
     * @param id 商品编号
     * @return
     */
    int deleteById(Integer id);
}
