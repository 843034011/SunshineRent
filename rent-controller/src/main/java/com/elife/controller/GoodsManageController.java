package com.elife.controller;


import com.elife.pojo.RentGoods;
import com.elife.service.impl.GoodsManageServiceImpl;
import com.elife.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * author:zgy
 */
@Controller
@RequestMapping("goodsManageCon")
public class GoodsManageController {

    @RequestMapping("showManage")
    public String showManage(){
        return "goodsmanage";
    }

    @Autowired
    GoodsManageServiceImpl goodsManageService;

    @RequestMapping("selectRegId")
    @ResponseBody
    public ResultData selectRegId(Integer regId){
        List<RentGoods> rentGoods = goodsManageService.selectByRegId(regId);
        ResultData resultData = new ResultData();
        if(null == rentGoods || rentGoods.size() ==0) {
            resultData.setCode(3);
            resultData.setMessage("查无数据");
        } else {
            resultData.setCode(0);
            resultData.setData(rentGoods);
        }
        return resultData;
    }

    @RequestMapping("updataGood")
    @ResponseBody
    public ResultData updataGood(RentGoods rentGood){
        int updateNum = goodsManageService.updataGood(rentGood);
        ResultData resultData = new ResultData();
        if (updateNum == 0) {
            resultData.setCode(5);
            resultData.setMessage("修改失败");
        } else {
            resultData.setCode(0);
            resultData.setData(updateNum);
        }
        return resultData;
    }


    @RequestMapping("deleteGood")
    @ResponseBody
    public ResultData deleteGood(Integer id){
        int deleteNum = goodsManageService.deleteById(id);
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

    @RequestMapping("insertGood")
    @ResponseBody
    public ResultData insertGood(RentGoods rentGood){
        int insertNum = goodsManageService.insertGood(rentGood);
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
}
