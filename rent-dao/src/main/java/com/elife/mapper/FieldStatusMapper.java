package com.elife.mapper;

import com.elife.pojo.FieldStatus;
import com.elife.pojo.FieldStatusExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FieldStatusMapper {
    int countByExample(FieldStatusExample example);

    int deleteByExample(FieldStatusExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FieldStatus record);

    int insertSelective(FieldStatus record);

    List<FieldStatus> selectByExample(FieldStatusExample example);

    FieldStatus selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FieldStatus record, @Param("example") FieldStatusExample example);

    int updateByExample(@Param("record") FieldStatus record, @Param("example") FieldStatusExample example);

    int updateByPrimaryKeySelective(FieldStatus record);

    int updateByPrimaryKey(FieldStatus record);
}