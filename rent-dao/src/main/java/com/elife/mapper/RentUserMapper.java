package com.elife.mapper;

import com.elife.dto.UserResult;
import com.elife.pojo.RentUser;
import com.elife.pojo.RentUserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentUserMapper {
    int countByExample(RentUserExample example);

    int deleteByExample(RentUserExample example);

    int insert(RentUser record);

    int insertSelective(RentUser record);

    List<RentUser> selectByExample(RentUserExample example);

    int updateByExampleSelective(@Param("record") RentUser record, @Param("example") RentUserExample example);

    int updateByExample(@Param("record") RentUser record, @Param("example") RentUserExample example);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    RentUser selectById(Integer id);

    /**
     * 注册时插入未认证的标识
     * @param id
     * @return
     */
    int insertFirst(Integer id);

    /**
     * 认证时修改用户信息
     * @param userResult
     * @param imgUrl
     * @return
     */
    int updateUser(@Param("userResult") UserResult userResult, @Param("imgUrl") String imgUrl);

}