package com.elife.mapper;

import com.elife.pojo.RentGoods;
import com.elife.pojo.RentGoodsExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentGoodsMapper {

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

    int updateByPrimaryKey(RentGoods record);
}