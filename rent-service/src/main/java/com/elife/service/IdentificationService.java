package com.elife.service;

import com.elife.dto.UserResult;

public interface IdentificationService {
    /**
     * 用户信息认证
     * @param userResult
     * @param imgUrl
     * @return
     */
    int updateUser(UserResult userResult,String imgUrl);
}
