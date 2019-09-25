package com.elife.service;

public interface UserService {

    /**
     * 注册用户时执行，向rent_user表里插入
     * @return
     */
    int insertFirst(Integer id);
}
