package com.elife.dto;

import com.elife.pojo.EvaluatePicture;

import java.util.List;

public class EvaluateResult {

    private int regId;
    private String userPicture;
    private String userName;
    private String createTime;
    private int grade;
    private String content;
    private List<EvaluatePicture> pictureList;
    private int fieldId;
    private int master;

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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
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

    public List<EvaluatePicture> getPictureList() {
        return pictureList;
    }

    public void setPictureList(List<EvaluatePicture> pictureList) {
        this.pictureList = pictureList;
    }

    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    public int getMaster() {
        return master;
    }

    public void setMaster(int master) {
        this.master = master;
    }
}
