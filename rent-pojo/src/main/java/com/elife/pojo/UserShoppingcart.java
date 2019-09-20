package com.elife.pojo;

import java.util.Date;

public class UserShoppingcart {
    private Integer id;

    private Date startTime;

    private Date endTime;

    private Integer fieldId;

    private Integer goodsId;

    private Integer regId;

    private Integer extraInt1;

    private Integer extraInt2;

    private Long extraDecimal1;

    private Long extraDecimal2;

    private String extraVarchar1;

    private String extraVarchar2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public Integer getRegId() {
        return regId;
    }

    public void setRegId(Integer regId) {
        this.regId = regId;
    }

    public Integer getExtraInt1() {
        return extraInt1;
    }

    public void setExtraInt1(Integer extraInt1) {
        this.extraInt1 = extraInt1;
    }

    public Integer getExtraInt2() {
        return extraInt2;
    }

    public void setExtraInt2(Integer extraInt2) {
        this.extraInt2 = extraInt2;
    }

    public Long getExtraDecimal1() {
        return extraDecimal1;
    }

    public void setExtraDecimal1(Long extraDecimal1) {
        this.extraDecimal1 = extraDecimal1;
    }

    public Long getExtraDecimal2() {
        return extraDecimal2;
    }

    public void setExtraDecimal2(Long extraDecimal2) {
        this.extraDecimal2 = extraDecimal2;
    }

    public String getExtraVarchar1() {
        return extraVarchar1;
    }

    public void setExtraVarchar1(String extraVarchar1) {
        this.extraVarchar1 = extraVarchar1 == null ? null : extraVarchar1.trim();
    }

    public String getExtraVarchar2() {
        return extraVarchar2;
    }

    public void setExtraVarchar2(String extraVarchar2) {
        this.extraVarchar2 = extraVarchar2 == null ? null : extraVarchar2.trim();
    }
}