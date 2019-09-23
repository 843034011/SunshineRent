package com.elife.dto;

import com.elife.pojo.EvaluatePicture;

import java.util.Date;
import java.util.List;

/**
 * author byf
 */
public class EvaluateResult {

    private int regId;              //当前登录用户id     用户信息表
    private String userPicture;     //当前登录用户头像   用户信息表
    private String userName;        //当前登录用户昵称   用户信息表
    private Date createTime;      //评价时间           评价表
    private int grade;              //评分               评价表
    private String content;         //评价内容           评价表
    private List<String> pictureList;//评价图片路径      评价图片表
    private Integer fieldId;            //评价的场地id        场地表
    private Integer goodsId;            //评价的商品id        商品表

    public int getRegId() {
        return regId;
    }

    public void setRegId(int regId) {
        this.regId = regId;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getPictureList() {
        return pictureList;
    }

    public void setPictureList(List<String> pictureList) {
        this.pictureList = pictureList;
    }

    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return "EvaluateResult{" +
                "regId=" + regId +
                ", userPicture='" + userPicture + '\'' +
                ", userName='" + userName + '\'' +
                ", createTime=" + createTime +
                ", grade=" + grade +
                ", content='" + content + '\'' +
                ", pictureList=" + pictureList +
                ", fieldId=" + fieldId +
                ", goodsId=" + goodsId +
                '}';
    }
}
