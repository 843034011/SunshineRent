package com.elife.pojo;

import java.util.Date;
import java.util.List;

public class remarks {
    private Integer id;
    private Integer reg_id;
    private String userImg;
    private String userName;
    private Date createTime;
    private Integer remark;
    private String remarkContent;
    private Integer fieldId;
    private Integer goodsId;
    private Integer masterId;
    private String reply_content;
    List<Pictures> picture;
    List<Zans> zan;


    @Override
    public String toString() {
        return "remarks{" +
                "id=" + id +
                ", reg_id=" + reg_id +
                ", userImg='" + userImg + '\'' +
                ", userName='" + userName + '\'' +
                ", createTime=" + createTime +
                ", remark=" + remark +
                ", remarkContent='" + remarkContent + '\'' +
                ", fieldId=" + fieldId +
                ", goodsId=" + goodsId +
                ", masterId=" + masterId +
                ", reply_content='" + reply_content + '\'' +
                ", picture=" + picture +
                ", zan=" + zan +
                '}';
    }

    public List<Zans> getZan() {
        return zan;
    }

    public void setZan(List<Zans> zan) {
        this.zan = zan;
    }

    public Integer getReg_id() {
        return reg_id;
    }

    public void setReg_id(Integer reg_id) {
        this.reg_id = reg_id;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
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

    public Integer getRemark() {
        return remark;
    }

    public void setRemark(Integer remark) {
        this.remark = remark;
    }

    public String getRemarkContent() {
        return remarkContent;
    }

    public void setRemarkContent(String remarkContent) {
        this.remarkContent = remarkContent;
    }

    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getMasterId() {
        return masterId;
    }

    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }

    public String getReply_content() {
        return reply_content;
    }

    public void setReply_content(String reply_content) {
        this.reply_content = reply_content;
    }

    public List<Pictures> getPicture() {
        return picture;
    }

    public void setPicture(List<Pictures> picture) {
        this.picture = picture;
    }
}
