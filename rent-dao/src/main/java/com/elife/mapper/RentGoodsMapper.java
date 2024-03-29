package com.elife.mapper;

import com.elife.pojo.GoodsPicture;
import com.elife.pojo.RentField;
import com.elife.pojo.RentGoods;
import com.elife.pojo.RentGoodsExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentGoodsMapper {

    /**
     * @author:zgy
     * @return 返回所有商品
     */
    @Select("select * from rent_goods")
    List<RentGoods> selectAllGoods();


    List<RentGoods> showAllGoods();

    //模糊查找 排序yy
    List<RentGoods>selectByNameTypegoods(@Param("NameType")String NameType, @Param("name")String name, @Param("order")String order, @Param("renshumin")Integer renshumin, @Param("renshumax")Integer renshumax, @Param("quyu")String quyu);



    /**
     * @author:zgy
     * @return 通过类型进行排序返回所有商品
     */
    List<RentGoods> selectByType(String goodsType);

    /**
     * @author:zgy
     * @param regId 注册id
     * @return 返回用户商品列表
     */
    List<RentGoods> selectByRegId(Integer regId);
    /**
     * @author:zgy
     * @param id 商品id
     * @return 返回用户商品
     */
    RentGoods selectById(Integer id);
    /**
     * @author zgy
     * @param rentGood 要修改的商品
     * @return 返回修改行数
     */
    int updataGood(RentGoods rentGood);
    /**
     * @author zgy
     * @param goodsPicture 要修改的商品
     * @return 返回修改行数
     */
    int updataPic(GoodsPicture goodsPicture);
    /**
     * @author zgy
     * @param rentGood 要删除的商品
     * @return 返回修改行数
     */
    int insertGood(RentGoods rentGood);

    /**
     * @author zgy
     * @param goodsPicture
     * @return 返回修改行数
     */
    int insertPic(GoodsPicture goodsPicture);
    /**
     * @author zgy
     * @param id 商品编号
     * @return
     */
    int deleteById(Integer id);


    int countByExample(RentGoodsExample example);

    int deleteByExample(RentGoodsExample example);

    int insertSelective(RentGoods record);

    List<RentGoods> selectByExample(RentGoodsExample example);

    RentGoods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RentGoods record, @Param("example") RentGoodsExample example);

    int updateByExample(@Param("record") RentGoods record, @Param("example") RentGoodsExample example);

    int updateByPrimaryKeySelective(RentGoods record);

    /**
     * @author llb
     * @param id
     * @return
     */
    RentGoods selectGoodsWithPictureById(Integer id);


}