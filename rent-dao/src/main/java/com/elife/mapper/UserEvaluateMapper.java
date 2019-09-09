package com.elife.mapper;

import com.elife.pojo.UserEvaluate;
import com.elife.pojo.UserEvaluateExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserEvaluateMapper {
    int countByExample(UserEvaluateExample example);

    int deleteByExample(UserEvaluateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserEvaluate record);

    int insertSelective(UserEvaluate record);

    List<UserEvaluate> selectByExample(UserEvaluateExample example);

    UserEvaluate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserEvaluate record, @Param("example") UserEvaluateExample example);

    int updateByExample(@Param("record") UserEvaluate record, @Param("example") UserEvaluateExample example);

    int updateByPrimaryKeySelective(UserEvaluate record);

    int updateByPrimaryKey(UserEvaluate record);
}