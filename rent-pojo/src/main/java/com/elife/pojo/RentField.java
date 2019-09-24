package com.elife.pojo;

import java.math.BigDecimal;
import java.util.List;

public class RentField {
    private Integer id;

    private String fieldName;

    private String fieldType;

    private String fieldInfo;

    private BigDecimal fieldDeposit;

    private BigDecimal fieldHourprice;

    private BigDecimal fieldDayprice;

    private BigDecimal fieldWeekprice;

    private BigDecimal fieldMonthprice;

    private String fieldAddress;

    private BigDecimal fieldGrade;

    private Integer rentCount;

    private Integer regId;

    private Integer fieldVolume;

    public Integer getFieldVolume() {
        return fieldVolume;
    }

    public void setFieldVolume(Integer fieldVolume) {
        this.fieldVolume = fieldVolume;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName == null ? null : fieldName.trim();
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType == null ? null : fieldType.trim();
    }

    public String getFieldInfo() {
        return fieldInfo;
    }

    public void setFieldInfo(String fieldInfo) {
        this.fieldInfo = fieldInfo == null ? null : fieldInfo.trim();
    }



    public String getFieldAddress() {
        return fieldAddress;
    }

    public void setFieldAddress(String fieldAddress) {
        this.fieldAddress = fieldAddress == null ? null : fieldAddress.trim();
    }

    public BigDecimal getFieldDeposit() {
        return fieldDeposit;
    }

    public void setFieldDeposit(BigDecimal fieldDeposit) {
        this.fieldDeposit = fieldDeposit;
    }

    public BigDecimal getFieldHourprice() {
        return fieldHourprice;
    }

    public void setFieldHourprice(BigDecimal fieldHourprice) {
        this.fieldHourprice = fieldHourprice;
    }

    public BigDecimal getFieldDayprice() {
        return fieldDayprice;
    }

    public void setFieldDayprice(BigDecimal fieldDayprice) {
        this.fieldDayprice = fieldDayprice;
    }

    public BigDecimal getFieldWeekprice() {
        return fieldWeekprice;
    }

    public void setFieldWeekprice(BigDecimal fieldWeekprice) {
        this.fieldWeekprice = fieldWeekprice;
    }

    public BigDecimal getFieldMonthprice() {
        return fieldMonthprice;
    }

    public void setFieldMonthprice(BigDecimal fieldMonthprice) {
        this.fieldMonthprice = fieldMonthprice;
    }

    public BigDecimal getFieldGrade() {
        return fieldGrade;
    }

    public void setFieldGrade(BigDecimal fieldGrade) {
        this.fieldGrade = fieldGrade;
    }

    public Integer getRentCount() {
        return rentCount;
    }

    public void setRentCount(Integer rentCount) {
        this.rentCount = rentCount;
    }

    public Integer getRegId() {
        return regId;
    }

    public void setRegId(Integer regId) {
        this.regId = regId;
    }




    private List<FieldPicture> fieldPictures;

    public List<FieldPicture> getFieldPictures() {
        return fieldPictures;
    }

    public void setFieldPictures(List<FieldPicture> fieldPictures) {
        this.fieldPictures = fieldPictures;
    }
}