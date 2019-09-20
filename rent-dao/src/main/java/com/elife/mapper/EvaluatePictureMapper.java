package com.elife.mapper;

import com.elife.pojo.EvaluatePicture;
import com.elife.pojo.EvaluatePictureExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluatePictureMapper {
    int countByExample(EvaluatePictureExample example);

    int deleteByExample(EvaluatePictureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EvaluatePicture record);

    int insertSelective(EvaluatePicture record);

    List<EvaluatePicture> selectByExample(EvaluatePictureExample example);

    EvaluatePicture selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EvaluatePicture record, @Param("example") EvaluatePictureExample example);

    int updateByExample(@Param("record") EvaluatePicture record, @Param("example") EvaluatePictureExample example);

    int updateByPrimaryKeySelective(EvaluatePicture record);

    int updateByPrimaryKey(EvaluatePicture record);

    int insertEvaluatePicture(EvaluatePicture evaluatePicture);
}