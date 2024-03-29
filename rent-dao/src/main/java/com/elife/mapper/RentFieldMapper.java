package com.elife.mapper;

import com.elife.pojo.RentField;
import com.elife.pojo.RentFieldExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentFieldMapper {
    List<RentField>selectAllFields();

    List<RentField> selectOrderByGrade(String fieldType);

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


    /**
     * @author:llb
     * @param id
     * @return
     */
    RentField selectFieldWithPictureById(@Param("id") Integer id);

    //根据价格排序
    List<RentField>orderByPrice();

    //模糊查找 排序yy
    List<RentField>selectByNameType(@Param("NameType")String NameType,@Param("name")String name,@Param("order")String order,@Param("renshumin")Integer renshumin,@Param("renshumax")Integer renshumax,@Param("quyu")String quyu);


}