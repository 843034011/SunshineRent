package com.elife.service;

import com.elife.pojo.UserAddress;

import java.util.List;

/**
 * author:zgy
 */
public interface UserAddressService {
    /**
     * 通过用户注册id查找地址 ，一个用户多个地址
     * @return 返回地址集合
     */
    List<UserAddress> selectByRegId(Integer regId);

    /**
     * 新建地址
     * @param userAddress 添加的地址
     * @return 添加的行数
     */
    int insertAddress(UserAddress userAddress);

    /**
     *
     * @param userAddress 修改地址
     * @return 修改行数
     */
    int updataAddress(UserAddress userAddress);

    /**
     * 删除地址
     * @param id 地址编号
     * @return 删除行数
     */
    int deleteById(Integer id);
}
