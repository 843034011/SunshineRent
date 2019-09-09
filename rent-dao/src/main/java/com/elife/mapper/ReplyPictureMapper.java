package com.elife.mapper;

import com.elife.pojo.ReplyPicture;
import com.elife.pojo.ReplyPictureExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyPictureMapper {
    int countByExample(ReplyPictureExample example);

    int deleteByExample(ReplyPictureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ReplyPicture record);

    int insertSelective(ReplyPicture record);

    List<ReplyPicture> selectByExample(ReplyPictureExample example);

    ReplyPicture selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ReplyPicture record, @Param("example") ReplyPictureExample example);

    int updateByExample(@Param("record") ReplyPicture record, @Param("example") ReplyPictureExample example);

    int updateByPrimaryKeySelective(ReplyPicture record);

    int updateByPrimaryKey(ReplyPicture record);
}