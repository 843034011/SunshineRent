package com.elife.mapper;

import com.elife.pojo.UserShoppingcart;
import com.elife.pojo.UserShoppingcartExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
}