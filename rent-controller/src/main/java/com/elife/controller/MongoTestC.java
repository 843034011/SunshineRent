
package com.elife.controller;

import com.elife.dao.MongoTestDao;
import com.elife.dto.EvaluateResult;
import com.elife.pojo.*;
import com.elife.service.EvaluateResultService;
import com.elife.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.awt.peer.PanelPeer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@RestController
public class MongoTestC {

    @Autowired
    private MongoTestDao mtdao;

    @Autowired
    EvaluateResultService evaluateResultService;

    @Autowired
    OrderDetailService orderDetailService;


 /* evaluateResult.setRegId(regId);
        evaluateResult.setUserPicture(userPicture);
        evaluateResult.setUserName(userName);
        evaluateResult.setCreateTime(date);
        evaluateResult.setGrade(grade);
        evaluateResult.setContent(content);
        evaluateResult.setPictureList(pictureList);
        evaluateResult.setFieldId(fieldId);*/
/* 评论内容图片插入数据库*/
    @PostMapping(value = "/test1")
    public int saveTest(MultipartFile[] file, int grade, String content,Integer detailId) throws Exception {
        System.out.println("============" + detailId + "=================");

        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HHmmss");
        String date1=simpleDateFormat.format(date);

        System.out.println(file);
        System.out.println(content);
        EvaluateResult evaluateResult=evaluateResultService.saveEvaluateResult( file,grade,content,detailId);
        remarks mgtest = new remarks();
        mgtest.setId( Integer.parseInt(date1));
        mgtest.setReg_id(evaluateResult.getRegId());
        mgtest.setUserImg(evaluateResult.getUserPicture());
        mgtest.setUserName(evaluateResult.getUserName());
        mgtest.setCreateTime(evaluateResult.getCreateTime());
        mgtest.setRemark(evaluateResult.getGrade());
        mgtest.setRemarkContent(evaluateResult.getContent());
        List<Pictures> pictures=new ArrayList<Pictures>();

       /* List<zan> zanList=new ArrayList<>();
        zan zan=new zan();
        mgtest.setZanId(zan.getZanId());*/

        for(int i=0;i<evaluateResult.getPictureList().size();i++){
            Pictures p=new Pictures();
            p.setPicture(evaluateResult.getPictureList().get(i));
            pictures.add(p);
        }
        if(evaluateResult.getFieldId() != null){
            mgtest.setFieldId(evaluateResult.getFieldId());
            mgtest.setGoodsId(0);
        }else if(evaluateResult.getGoodsId() != null){
            mgtest.setFieldId(0);
            mgtest.setGoodsId(evaluateResult.getGoodsId());
        }

        mgtest.setPicture(pictures);

        List<Zans> zansList = new ArrayList<>();
        Zans zans = new Zans();
        zans.setZan(0);
        zansList.add(zans);
        mgtest.setZan(zansList);
        mtdao.saveTest(mgtest);

        OrderDetail orderDetail = orderDetailService.selectById(detailId);

        if(mgtest==null){
            return 0;
        }else{
            //评价成功后修改订单状态
            orderDetail.setProductStatus("已完成");
            int result = orderDetailService.updateByPrimaryKey(orderDetail);
            if(result>=1){
                return 1;
            }else{
                return 0;
            }
        }
    }

    @PostMapping(value="/quxiao")
    public int cancelZan(Integer reid, Integer reg, HttpSession session){
        remarks remarks=new remarks();
        List<Zans>zansList=new ArrayList<>();
        Zans zans1=new Zans();
        zans1.setZan(reid);
        zansList.add(zans1);
        remarks.setReg_id(reg);
        remarks.setZan(zansList);

        System.out.println("+++++++++++++++++++++++++++++++"+remarks.toString());
        System.out.println(reid);
        System.out.println(reg);

        mtdao.delete(remarks);

        return 0;
    }


   @PostMapping(value="/dianzan")
   public int addzan(Integer reid, Integer reg, HttpSession session){


     /*  RentRegister rentRegister = (RentRegister) session.getAttribute("rentRegister");
       int id=rentRegister.getRegId();*/

        remarks remarks=new remarks();
        List<Zans>zansList=new ArrayList<>();
        Zans zans1=new Zans();
        zans1.setZan(reid);
        zansList.add(zans1);
        remarks.setReg_id(reg);
        remarks.setZan(zansList);

       System.out.println(zansList.toString());
        System.out.println(reid);
        System.out.println(reg);
        remarks remarks1=mtdao.updateTest(remarks);

       /*System.out.println("cccccccccc"+remarks.toString());
*/

     /* remarks remarks = mtdao.updateTest(query, remarks.class);*/


      /*  System.out.println(likeComment.toString());

       Comment comment = mongoTemplate.findOne(query, Comment.class);
        List<LikeComment> likeCommentList = comment.getLikeCommentList();
        for (int i = 0; i < likeCommentList.size(); i++) {
/          System.out.println(likeCommentList.get(i).toString());
        }
//        likeCommentList.remove(likeComment);
//        mongoTemplate.updateFirst(query, new Update().set("likeCommentList", likeCommentList), Comment.class);*/
//
//
       return 0;
    }


    @GetMapping(value = "/test2")
    public List<remarks> findTestByRegId() {
        List<remarks> remark= mtdao.findALL();
        System.out.println("mgtest is " + remark);
        return remark;
    }
/*
    @GetMapping(value = "/dianzan")
    public void updateTest() {
       remarks mgtest = new remarks();
        mgtest.setId(11);

        mtdao.updateTest(mgtest);
    }*/

 /*   @GetMapping(value = "/test4")
    public void deleteTestById() {
        mtdao.deleteTestById(11);
    }*/

}


