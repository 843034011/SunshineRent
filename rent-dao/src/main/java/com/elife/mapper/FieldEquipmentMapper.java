package com.elife.mapper;

import com.elife.pojo.FieldEquipment;
import com.elife.pojo.FieldEquipmentExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FieldEquipmentMapper {
    int countByExample(FieldEquipmentExample example);

    int deleteByExample(FieldEquipmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FieldEquipment record);

    int insertSelective(FieldEquipment record);

    List<FieldEquipment> selectByExample(FieldEquipmentExample example);

    FieldEquipment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FieldEquipment record, @Param("example") FieldEquipmentExample example);

    int updateByExample(@Param("record") FieldEquipment record, @Param("example") FieldEquipmentExample example);

    int updateByPrimaryKeySelective(FieldEquipment record);

    int updateByPrimaryKey(FieldEquipment record);
}