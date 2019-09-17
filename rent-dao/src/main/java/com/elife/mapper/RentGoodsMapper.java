package com.elife.mapper;

import com.elife.pojo.RentGoods;
import com.elife.pojo.RentGoodsExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentGoodsMapper {

    /**
     * @author:zgy
     * @param regId 注册id
     * @return 返回用户商品列表
     */
    List<RentGoods> selectByRegId(Integer regId);

    int countByExample(RentGoodsExample example);

    int deleteByExample(RentGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RentGoods record);

    int insertSelective(RentGoods record);

    List<RentGoods> selectByExample(RentGoodsExample example);

    RentGoods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RentGoods record, @Param("example") RentGoodsExample example);

    int updateByExample(@Param("record") RentGoods record, @Param("example") RentGoodsExample example);

    int updateByPrimaryKeySelective(RentGoods record);

    /**
     * @author zgy
     * @param record 要修改的商品
     * @return 返回修改行数
     */
    int updateByPrimaryKey(RentGoods record);

    /**
     * @author llb
     * @param id
     * @return
     */
    RentGoods selectGoodsWithPictureById(Integer id);
}