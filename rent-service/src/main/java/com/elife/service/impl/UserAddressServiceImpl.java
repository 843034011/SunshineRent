package com.elife.service.impl;

import com.elife.mapper.UserAddressMapper;
import com.elife.pojo.UserAddress;
import com.elife.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAddressServiceImpl implements UserAddressService {

    @Autowired
    UserAddressMapper userAddressMapper;
    @Override
    public List<UserAddress> selectByRegId(Integer regId) {
        return userAddressMapper.selectByRegId(regId);
    }

    @Override
    public int insertAddress(UserAddress userAddress) {
        return userAddressMapper.insertAddress(userAddress);
    }

    @Override
    public int updataAddress(UserAddress userAddress) {
        return userAddressMapper.updataAddress(userAddress);
    }

    @Override
    public int deleteById(Integer id) {
        return userAddressMapper.deleteById(id);
    }
}
