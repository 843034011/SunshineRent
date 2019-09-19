package com.elife.service;

import com.elife.pojo.RentRegister;

/**
 * @author llb
 */
public interface RegisterService {

    /**
     * 根据手机号查询当前手机号是否有人注册
     * @param telephone
     * @return
     */
    RentRegister selectRegisterByTelephone(String telephone);

    /**
     * 向注册表内插入数据
     * @param telephone
     * @param password
     * @param time
     * @return
     */
    int insertRegister(String telephone, String password, String time);

    RentRegister selectRegister(String telephone, String password);
}
