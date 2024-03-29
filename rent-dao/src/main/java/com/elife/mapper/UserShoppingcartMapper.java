package com.elife.mapper;

import com.elife.pojo.UserOrder;
import com.elife.pojo.UserShoppingcart;
import com.elife.pojo.UserShoppingcartExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserShoppingcartMapper {
    int countByExample(UserShoppingcartExample example);

    int deleteByExample(UserShoppingcartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserShoppingcart record);

    int insertSelective(UserShoppingcart record);

    List<UserShoppingcart> selectByExample(UserShoppingcartExample example);

    UserShoppingcart selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserShoppingcart record, @Param("example") UserShoppingcartExample example);

    int updateByExample(@Param("record") UserShoppingcart record, @Param("example") UserShoppingcartExample example);

    int updateByPrimaryKeySelective(UserShoppingcart record);

    int updateByPrimaryKey(UserShoppingcart record);

    List<UserOrder> selectAllUserOrderUnpaidById(Integer regId);

    int insertFields(UserShoppingcart userShoppingcart);

    int insertGoods(UserShoppingcart userShoppingcart);

    List<UserShoppingcart> selectall();
}