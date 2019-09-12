package com.elife.mapper;

import com.elife.pojo.RentField;
import com.elife.pojo.RentFieldExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentFieldMapper {
    List<RentField>selectAllFields();

    int countByExample(RentFieldExample example);

    int deleteByExample(RentFieldExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RentField record);

    int insertSelective(RentField record);

    List<RentField> selectByExample(RentFieldExample example);

    RentField selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RentField record, @Param("example") RentFieldExample example);

    int updateByExample(@Param("record") RentField record, @Param("example") RentFieldExample example);

    int updateByPrimaryKeySelective(RentField record);

    int updateByPrimaryKey(RentField record);
}