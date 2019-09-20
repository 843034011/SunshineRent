package com.elife.mapper;

import com.elife.pojo.FieldTag;
import com.elife.pojo.FieldTagExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FieldTagMapper {
    int countByExample(FieldTagExample example);

    int deleteByExample(FieldTagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FieldTag record);

    int insertSelective(FieldTag record);

    List<FieldTag> selectByExample(FieldTagExample example);

    FieldTag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FieldTag record, @Param("example") FieldTagExample example);

    int updateByExample(@Param("record") FieldTag record, @Param("example") FieldTagExample example);

    int updateByPrimaryKeySelective(FieldTag record);

    int updateByPrimaryKey(FieldTag record);
}