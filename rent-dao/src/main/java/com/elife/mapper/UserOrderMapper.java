package com.elife.mapper;

import com.elife.pojo.UserOrder;
import com.elife.pojo.UserOrderExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserOrderMapper {
    int countByExample(UserOrderExample example);

    int deleteByExample(UserOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserOrder record);

    int insertSelective(UserOrder record);

    List<UserOrder> selectByExample(UserOrderExample example);

    UserOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserOrder record, @Param("example") UserOrderExample example);

    int updateByExample(@Param("record") UserOrder record, @Param("example") UserOrderExample example);

    int updateByPrimaryKeySelective(UserOrder record);

    int updateByPrimaryKey(UserOrder record);

    //购物车中显示的数据，查询订单表中未支付的数据
    List<UserOrder> selectAllUserOrderUnpaid();

    //订单中心中显示的数据，查询订单表中除了未支付意外的所有数据
    List<UserOrder> selectAllUserOrder();

    //根据订单id查询数据
    UserOrder selectById(Integer id);
}