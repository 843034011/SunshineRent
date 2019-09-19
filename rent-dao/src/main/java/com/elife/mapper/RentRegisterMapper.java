package com.elife.mapper;

import com.elife.pojo.RentRegister;
import com.elife.pojo.RentRegisterExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentRegisterMapper {
    int countByExample(RentRegisterExample example);

    int deleteByExample(RentRegisterExample example);

    int deleteByPrimaryKey(Integer regId);

    int insert(RentRegister record);

    int insertSelective(RentRegister record);

    List<RentRegister> selectByExample(RentRegisterExample example);

    RentRegister selectByPrimaryKey(Integer regId);

    int updateByExampleSelective(@Param("record") RentRegister record, @Param("example") RentRegisterExample example);

    int updateByExample(@Param("record") RentRegister record, @Param("example") RentRegisterExample example);

    int updateByPrimaryKeySelective(RentRegister record);

    int updateByPrimaryKey(RentRegister record);

    /**
     * @author llb
     * @param telephone
     * @return
     */
    RentRegister selectByTelephone(String telephone);

    /**
     * @author llb
     * @param telephone
     * @param password
     * @param time
     * @return
     */
    int insertRegister(@Param("telephone") String telephone,@Param("password") String password,@Param("time") String time);

    /**
     * @author llb
     * @param telephone
     * @param password
     * @return
     */
    RentRegister selectRegister(@Param("telephone") String telephone,@Param("password") String password);
}