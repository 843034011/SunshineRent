package com.elife.mapper;

import com.elife.pojo.StoreReply;
import com.elife.pojo.StoreReplyExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreReplyMapper {
    int countByExample(StoreReplyExample example);

    int deleteByExample(StoreReplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StoreReply record);

    int insertSelective(StoreReply record);

    List<StoreReply> selectByExample(StoreReplyExample example);

    StoreReply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StoreReply record, @Param("example") StoreReplyExample example);

    int updateByExample(@Param("record") StoreReply record, @Param("example") StoreReplyExample example);

    int updateByPrimaryKeySelective(StoreReply record);

    int updateByPrimaryKey(StoreReply record);
}