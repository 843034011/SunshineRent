package com.elife.service;

import com.elife.pojo.RentUser;

public interface UserService {

    /**
     * 注册用户时执行，向rent_user表里插入
     * @return
     */
    int insertFirst(Integer id);

    /**
     *
     * @param id
     * @return
     */
    RentUser selectByTelephone(Integer id);
}
