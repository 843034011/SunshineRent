package com.elife.service;

import com.elife.pojo.UserEvaluate;

/**
 * @author:byf
 */
public interface UserEvaluateService {


    int insertUserEvaluate(int grade,String content,int isAnonymous,String time,int regid,int orderid);

}
