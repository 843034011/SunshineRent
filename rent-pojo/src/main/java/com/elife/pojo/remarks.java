package com.elife.pojo;

import java.util.Date;
import java.util.List;

public class remarks {
    private Integer id;
    private String userImg;
    private String userName;
    private Date createTime;
    private Integer remark;
    private String remarkContent;
    private Integer fieldId;
    private Integer masterId;
    private String reply_content;
    List<Pictures> picture;

    @Override
    public String toString() {
        return "remarks{" +
                "id=" + id +
                ", userImg='" + userImg + '\'' +
                ", userName='" + userName + '\'' +
                ", createTime=" + createTime +
                ", remark=" + remark +
                ", remarkContent='" + remarkContent + '\'' +
                ", fieldId=" + fieldId +
                ", masterId=" + masterId +
                ", reply_content='" + reply_content + '\'' +
                ", picture=" + picture +
                '}';
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
