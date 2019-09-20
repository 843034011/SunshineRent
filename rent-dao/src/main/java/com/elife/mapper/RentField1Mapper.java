package com.elife.mapper;

import com.elife.pojo.RentField1;
import com.elife.pojo.RentField1Example;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RentField1Mapper {
    int countByExample(RentField1Example example);

    int deleteByExample(RentField1Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(RentField1 record);

    int insertSelective(RentField1 record);

    List<RentField1> selectByExample(RentField1Example example);

    RentField1 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RentField1 record, @Param("example") RentField1Example example);

    int updateByExample(@Param("record") RentField1 record, @Param("example") RentField1Example example);

    int updateByPrimaryKeySelective(RentField1 record);

    int updateByPrimaryKey(RentField1 record);
}