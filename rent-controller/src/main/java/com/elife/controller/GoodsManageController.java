package com.elife.controller;


import com.elife.pojo.GoodsAndPicture;
import com.elife.pojo.GoodsPicture;
import com.elife.pojo.RentGoods;
import com.elife.service.QiniuService;
import com.elife.service.impl.GoodsManageServiceImpl;
import com.elife.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
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
    public ResultData updataGood(MultipartFile file,String goodsName,
                                 String goodsType,String goodsModel,
                                 String goodsInfo,Integer goodsNumber,
                                 Long goodsDeposit,
                                 Long goodsDayprice,Long goodsWeekprice,
                                 Integer goodsGrade,
                                 Integer rentCount,Integer regId,
                                 Integer id,Integer goodsId) throws IOException {

        ResultData resultData = new ResultData();
        RentGoods rentGoods = new RentGoods();
        GoodsPicture goodsPicture = new GoodsPicture();


        rentGoods.setId(goodsId);
        rentGoods.setGoodsName(goodsName);
        rentGoods.setGoodsType(goodsType);
        rentGoods.setGoodsModel(goodsModel);
        rentGoods.setGoodsInfo(goodsInfo);
        rentGoods.setGoodsNumber(goodsNumber);
        rentGoods.setGoodsDeposit(goodsDeposit);
        rentGoods.setGoodsDayprice(goodsDayprice);
        rentGoods.setGoodsWeekprice(goodsWeekprice);
        rentGoods.setGoodsGrade(goodsGrade);
        rentGoods.setRentCount(rentCount);
        rentGoods.setRegId(regId);
        System.out.println("==========="+rentGoods.toString()+"================");
        int picNum = 0;
        int goodsNum = goodsManageService.updataGood(rentGoods);

//        if (file != null && file.length > 0) {
//            for (int i = 0; i < file.length; i++) {
//                MultipartFile filex = file[i];
                // 保存文件
        if(file != null){
                String fileUrl = qiniuService.saveImage(file);
                System.out.println(fileUrl);
                goodsPicture.setId(id);
                goodsPicture.setGoodsPicture(fileUrl);
                goodsPicture.setGoodsId(goodsId);
                System.out.println("==============");
                System.out.println(goodsPicture.toString());
                picNum = goodsManageService.updataPic(goodsPicture);
        } else {
            System.out.println("没有上传图片！");
        }
        if (goodsNum == 0||picNum == 0) {
            resultData.setCode(5);
            resultData.setMessage("修改失败");
        } else {
            resultData.setCode(0);
            resultData.setData(goodsNum);
        }
        return resultData;
    }

//    @RequestMapping("updataPic")
//    @ResponseBody
//    public ResultData updataPic(MultipartFile file,Integer id) {
//        GoodsPicture goodsPicture = new GoodsPicture();
//        ResultData resultData = new ResultData();
//        int updateNum = 0 ;
//        if(file != null) {
//            String fileUrl= null;
//            try {
//                fileUrl = qiniuService.saveImage(file);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            goodsPicture.setId(id);
//            goodsPicture.setGoodsPicture(fileUrl);
//            System.out.println("哈哈哈哈哈哈哈哈哈哈哈");
//            System.out.println(goodsPicture.toString());
//            updateNum = goodsManageService.updataPic(goodsPicture);
//            if (updateNum == 0) {
//                resultData.setCode(5);
//                resultData.setMessage("修改失败");
//            } else {
//                resultData.setCode(0);
//                resultData.setData(updateNum);
//            }
//            return resultData;
//        }else{
//            resultData.setCode(2);
//            resultData.setMessage("没有数据");
//        }
//        return resultData;
//    }

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

//    @RequestMapping("insertGood")
//    @ResponseBody
//    public ResultData insertGood(@RequestBody RentGoods rentGoods){
//        int insertNum = goodsManageService.insertGood(rentGoods);
//        ResultData resultData = new ResultData();
//        if (insertNum == 0) {
//            resultData.setCode(6);
//            resultData.setMessage("增加失败");
//        } else {
//            resultData.setCode(0);
//            resultData.setData(insertNum);
//        }
//        return resultData;
//    }
//
//    // 图片上传
//    @ResponseBody
//    @RequestMapping("insertPic")
//    public String insertPic(MultipartFile[] file,Integer goodsId) throws IOException {
//        if (file != null && file.length > 0) {
//            for (int i = 0; i < file.length; i++) {
//                GoodsPicture goodsPicture = new GoodsPicture();
//                MultipartFile filex = file[i];
//                // 保存文件
//                String fileUrl = qiniuService.saveImage(filex);
//
//                goodsPicture.setGoodsPicture(fileUrl);
//                goodsPicture.setGoodsId(goodsId);
//                System.out.println("==============");
//                System.out.println(goodsPicture.toString());
//                goodsManageService.updataPic(goodsPicture);
//            }
//        } else {
//            System.out.println("没有上传图片！");
//        }
//        return "success";
//    }

    @RequestMapping("insertGood")
    @ResponseBody
    public ResultData insertGood(MultipartFile file,String goodsName,
                                 String goodsType,String goodsModel,
                                 String goodsInfo,Integer goodsNumber,
                                 Long goodsDeposit,
                                 Long goodsDayprice,Long goodsWeekprice,
                                 Integer goodsGrade,
                                 Integer rentCount,Integer regId,
                                 Integer id,Integer goodsId) throws IOException {

        ResultData resultData = new ResultData();
        RentGoods rentGoods = new RentGoods();
        GoodsPicture goodsPicture = new GoodsPicture();


        rentGoods.setId(goodsId);
        rentGoods.setGoodsName(goodsName);
        rentGoods.setGoodsType(goodsType);
        rentGoods.setGoodsModel(goodsModel);
        rentGoods.setGoodsInfo(goodsInfo);
        rentGoods.setGoodsNumber(goodsNumber);
        rentGoods.setGoodsDeposit(goodsDeposit);
        rentGoods.setGoodsDayprice(goodsDayprice);
        rentGoods.setGoodsWeekprice(goodsWeekprice);
        rentGoods.setGoodsGrade(goodsGrade);
        rentGoods.setRentCount(rentCount);
        rentGoods.setRegId(regId);
        System.out.println("==========="+rentGoods.toString()+"================");
        int picNum = 0;
        int goodsNum = goodsManageService.updataGood(rentGoods);

//        if (file != null && file.length > 0) {
//            for (int i = 0; i < file.length; i++) {
//                MultipartFile filex = file[i];
        // 保存文件
        if(file != null){
            String fileUrl = qiniuService.saveImage(file);
            System.out.println(fileUrl);
            goodsPicture.setId(id);
            goodsPicture.setGoodsPicture(fileUrl);
            goodsPicture.setGoodsId(goodsId);
            System.out.println("==============");
            System.out.println(goodsPicture.toString());
            picNum = goodsManageService.updataPic(goodsPicture);
        } else {
            System.out.println("没有上传图片！");
        }
        if (goodsNum == 0||picNum == 0) {
            resultData.setCode(5);
            resultData.setMessage("修改失败");
        } else {
            resultData.setCode(0);
            resultData.setData(goodsNum);
        }
        return resultData;
    }


}


