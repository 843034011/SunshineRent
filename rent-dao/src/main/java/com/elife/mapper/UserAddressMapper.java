package com.elife.mapper;

import com.elife.pojo.UserAddress;
import com.elife.pojo.UserAddressExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAddressMapper {
    int countByExample(UserAddressExample example);

    int deleteByExample(UserAddressExample example);

    int insert(UserAddress record);

    int insertSelective(UserAddress record);

    List<UserAddress> selectByExample(UserAddressExample example);

    UserAddress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserAddress record, @Param("example") UserAddressExample example);

    int updateByExample(@Param("record") UserAddress record, @Param("example") UserAddressExample example);

    int updateByPrimaryKeySelective(UserAddress record);

    int updateByPrimaryKey(UserAddress record);

    /**
     * @author zgy
     */
    //根据用户注册id查地址
    List<UserAddress> selectByRegId(Integer regId);
    //添加地址
    int insertAddress(UserAddress userAddress);
    //修改地址
    int updataAddress(UserAddress userAddress);
    //删除地址
    int deleteById(Integer id);
}