package com.elife.pojo;

import java.util.Date;

public class UserEvaluate {
    private Integer id;

    private Integer evaGrade;

    private String evaContent;

    private Byte isAnonymous;

    private Date createTime;

    private Integer regId;

    private Integer orderId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEvaGrade() {
        return evaGrade;
    }

    public void setEvaGrade(Integer evaGrade) {
        this.evaGrade = evaGrade;
    }

    public String getEvaContent() {
        return evaContent;
    }

    public void setEvaContent(String evaContent) {
        this.evaContent = evaContent == null ? null : evaContent.trim();
    }

    public Byte getIsAnonymous() {
        return isAnonymous;
    }

    public void setIsAnonymous(Byte isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getRegId() {
        return regId;
    }

    public void setRegId(Integer regId) {
        this.regId = regId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}