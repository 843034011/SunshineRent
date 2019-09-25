package com.elife.mapper;

import com.elife.pojo.FieldPicture;
import com.elife.pojo.FieldPictureExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FieldPictureMapper {

    int countByExample(FieldPictureExample example);

    int deleteByExample(FieldPictureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FieldPicture record);

    int insertSelective(FieldPicture record);

    List<FieldPicture> selectByExample(FieldPictureExample example);

    FieldPicture selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FieldPicture record, @Param("example") FieldPictureExample example);

    int updateByExample(@Param("record") FieldPicture record, @Param("example") FieldPictureExample example);

    int updateByPrimaryKeySelective(FieldPicture record);

    int updateByPrimaryKey(FieldPicture record);

    /**
     * @author llb
     * @param fieldId
     * @return
     */
    List<FieldPicture> selectByFieldId(Integer fieldId);
}