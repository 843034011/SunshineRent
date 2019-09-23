package com.elife.controller;


import com.elife.pojo.GoodsPicture;
import com.elife.pojo.RentGoods;
import com.elife.service.QiniuService;
import com.elife.service.impl.GoodsManageServiceImpl;
import com.elife.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * author:zgy
 */
@Controller
@RequestMapping("goodsManageCon")
public class GoodsManageController {

    @Autowired
    private QiniuService qiniuService;

    @Autowired
    private GoodsManageServiceImpl goodsManageService;

    @RequestMapping("showManage")
    public String showManage(){
        return "goodsmanage";
    }

    @RequestMapping("addGoods")
    public String addGoods(){
        return "uploadgoods";
    }

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

    @RequestMapping("selectById")
    @ResponseBody
    public ResultData selectById(Integer id){
        RentGoods rentGood = goodsManageService.selectById(id);
        ResultData resultData = new ResultData();
        if(null == rentGood) {
            resultData.setCode(3);
            resultData.setMessage("查无数据");
        } else {
            resultData.setCode(0);
            resultData.setData(rentGood);
        }
        return resultData;
    }

    @RequestMapping("updataGood")
    @ResponseBody
    public ResultData updataGood(@RequestBody RentGoods rentGood){
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

    @RequestMapping("updataPic")
    @ResponseBody
    public ResultData updataPic(@RequestBody GoodsPicture goodsPicture){
        int updateNum = goodsManageService.updataPic(goodsPicture);
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
    public ResultData insertGood(@RequestBody RentGoods rentGood){
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

//    // 图片上传
//    @ResponseBody
//    @RequestMapping("sendPic")
//    public String sendPic(MultipartFile[] file) throws IOException {
//        if (file != null && file.length > 0) {
//            for (int i = 0; i < file.length; i++) {
//                MultipartFile filex = file[i];
//                // 保存文件
//                String fileUrl=qiniuService.saveImage(filex);
//                System.out.println(fileUrl);
//            }
//        }else{
//            System.out.println(file.length+"：长度就是零");
//        }
//        return "success";
//    }
}
