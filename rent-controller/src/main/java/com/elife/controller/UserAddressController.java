package com.elife.controller;

import com.elife.pojo.UserAddress;
import com.elife.service.impl.UserAddressServiceImpl;
import com.elife.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
/**
 * author:zgy
 */
@Controller
@RequestMapping("userAddressCon")
public class UserAddressController {

    @RequestMapping("showAddress")
    public String showAddress(){
        return "useraddress";
    }

    @Autowired
    UserAddressServiceImpl userAddressService;

    // 根据注册id打印所有地址
    @RequestMapping("selectRegId")
    @ResponseBody
    public ResultData selectRegId(Integer regId) {
        List<UserAddress> userAddresses = userAddressService.selectByRegId(regId);
        ResultData resultData = new ResultData();
        if (null == userAddresses || userAddresses.size() == 0) {
            resultData.setCode(3);
            resultData.setMessage("查无数据");
        } else {
            resultData.setCode(0);
            resultData.setData(userAddresses);
        }
        return resultData;
    }

    // 添加地址
    @RequestMapping("insertAddress")
    public ResultData insertAddress(@RequestBody UserAddress userAddress){
        int insertNum = userAddressService.insertAddress(userAddress);
        ResultData resultData = new ResultData();
        if (insertNum == 0) {
            resultData.setCode(6);
            resultData.setMessage("增加失败");
        } else {
            resultData.setCode(0);
            resultData.setData(insertNum);
        }
        return resultData;
    }

    // 修改地址
    @RequestMapping("updataAddress")
    public ResultData updataAddress(@RequestBody UserAddress userAddress){
        int updataNum = userAddressService.insertAddress(userAddress);
        ResultData resultData = new ResultData();
        if (updataNum == 0) {
            resultData.setCode(5);
            resultData.setMessage("修改失败");
        } else {
            resultData.setCode(0);
            resultData.setData(updataNum);
        }
        return resultData;
    }

    // 删除地址
    @RequestMapping("deleteById")
    public ResultData deleteById(Integer id){
        int deleteNum = userAddressService.deleteById(id);
//        System.out.println("受影响行数："+insertNum);
        ResultData resultData = new ResultData();
        if (deleteNum == 0) {
            resultData.setCode(4);
            resultData.setMessage("删除失败");
        } else {
            resultData.setCode(0);
            resultData.setData(deleteNum);
        }
        return resultData;
    }

}
