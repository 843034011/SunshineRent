package com.elife.mapper;

import com.elife.pojo.GoodsPicture;
import com.elife.pojo.GoodsPictureExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsPictureMapper {
    int countByExample(GoodsPictureExample example);

    int deleteByExample(GoodsPictureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsPicture record);

    int insertSelective(GoodsPicture record);

    List<GoodsPicture> selectByExample(GoodsPictureExample example);

    GoodsPicture selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsPicture record, @Param("example") GoodsPictureExample example);

    int updateByExample(@Param("record") GoodsPicture record, @Param("example") GoodsPictureExample example);

    int updateByPrimaryKeySelective(GoodsPicture record);

    int updateByPrimaryKey(GoodsPicture record);

    /**
     * @author llb
     * @param goodsId
     * @return
     */
    List<GoodsPicture> selectByGoodsId(Integer goodsId);
}