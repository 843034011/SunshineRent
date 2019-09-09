package com.elife.mapper;

import com.elife.pojo.RentRegister;
import com.elife.pojo.RentRegisterExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RentRegisterMapper {
    int countByExample(RentRegisterExample example);

    int deleteByExample(RentRegisterExample example);

    int deleteByPrimaryKey(Integer regId);

    int insert(RentRegister record);

    int insertSelective(RentRegister record);

    List<RentRegister> selectByExample(RentRegisterExample example);

    RentRegister selectByPrimaryKey(Integer regId);

    int updateByExampleSelective(@Param("record") RentRegister record, @Param("example") RentRegisterExample example);

    int updateByExample(@Param("record") RentRegister record, @Param("example") RentRegisterExample example);

    int updateByPrimaryKeySelective(RentRegister record);

    int updateByPrimaryKey(RentRegister record);
}