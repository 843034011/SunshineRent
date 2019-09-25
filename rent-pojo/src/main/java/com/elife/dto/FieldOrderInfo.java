package com.elife.dto;

import java.math.BigDecimal;

public class FieldOrderInfo {

    private String samplePicture;
    private String fieldName;
    private String fieldType;
    private BigDecimal fieldGrade;
    private int fieldCount;
    private BigDecimal fieldDeposit;
    private BigDecimal fieldDayPrice;
    private BigDecimal fieldWeekPrice;
    private String fieldAddress;
    private String masterName;
    private String masterPhone;

    public String getSamplePicture() {
        return samplePicture;
    }

    public void setSamplePicture(String samplePicture) {
        this.samplePicture = samplePicture;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public BigDecimal getFieldGrade() {
        return fieldGrade;
    }

    public void setFieldGrade(BigDecimal fieldGrade) {
        this.fieldGrade = fieldGrade;
    }

    public int getFieldCount() {
        return fieldCount;
    }

    public void setFieldCount(int fieldCount) {
        this.fieldCount = fieldCount;
    }

    public BigDecimal getFieldDeposit() {
        return fieldDeposit;
    }

    public void setFieldDeposit(BigDecimal fieldDeposit) {
        this.fieldDeposit = fieldDeposit;
    }

    public BigDecimal getFieldDayPrice() {
        return fieldDayPrice;
    }

    public void setFieldDayPrice(BigDecimal fieldDayPrice) {
        this.fieldDayPrice = fieldDayPrice;
    }

    public BigDecimal getFieldWeekPrice() {
        return fieldWeekPrice;
    }

    public void setFieldWeekPrice(BigDecimal fieldWeekPrice) {
        this.fieldWeekPrice = fieldWeekPrice;
    }

    public String getFieldAddress() {
        return fieldAddress;
    }

    public void setFieldAddress(String fieldAddress) {
        this.fieldAddress = fieldAddress;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getMasterPhone() {
        return masterPhone;
    }

    public void setMasterPhone(String masterPhone) {
        this.masterPhone = masterPhone;
    }
}
