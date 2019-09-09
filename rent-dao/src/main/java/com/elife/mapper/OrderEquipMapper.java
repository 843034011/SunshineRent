package com.elife.mapper;

import com.elife.pojo.OrderEquip;
import com.elife.pojo.OrderEquipExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderEquipMapper {
    int countByExample(OrderEquipExample example);

    int deleteByExample(OrderEquipExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderEquip record);

    int insertSelective(OrderEquip record);

    List<OrderEquip> selectByExample(OrderEquipExample example);

    OrderEquip selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderEquip record, @Param("example") OrderEquipExample example);

    int updateByExample(@Param("record") OrderEquip record, @Param("example") OrderEquipExample example);

    int updateByPrimaryKeySelective(OrderEquip record);

    int updateByPrimaryKey(OrderEquip record);
}