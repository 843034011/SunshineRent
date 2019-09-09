package com.elife.mapper;

import com.elife.pojo.RentUser;
import com.elife.pojo.RentUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RentUserMapper {
    int countByExample(RentUserExample example);

    int deleteByExample(RentUserExample example);

    int insert(RentUser record);

    int insertSelective(RentUser record);

    List<RentUser> selectByExample(RentUserExample example);

    int updateByExampleSelective(@Param("record") RentUser record, @Param("example") RentUserExample example);

    int updateByExample(@Param("record") RentUser record, @Param("example") RentUserExample example);
}