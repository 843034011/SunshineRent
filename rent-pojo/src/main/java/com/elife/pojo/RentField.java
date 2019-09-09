package com.elife.pojo;

public class RentField {
    private Integer id;

    private String fieldName;

    private String fieldType;

    private String fieldInfo;

    private Long fieldDeposit;

    private Long fieldHourprice;

    private Long fieldDayprice;

    private Long fieldWeekprice;

    private Long fieldMonthprice;

    private String fieldAddress;

    private Integer fieldGrade;

    private Integer rentCount;

    private Integer regId;

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

    public Long getFieldDeposit() {
        return fieldDeposit;
    }

    public void setFieldDeposit(Long fieldDeposit) {
        this.fieldDeposit = fieldDeposit;
    }

    public Long getFieldHourprice() {
        return fieldHourprice;
    }

    public void setFieldHourprice(Long fieldHourprice) {
        this.fieldHourprice = fieldHourprice;
    }

    public Long getFieldDayprice() {
        return fieldDayprice;
    }

    public void setFieldDayprice(Long fieldDayprice) {
        this.fieldDayprice = fieldDayprice;
    }

    public Long getFieldWeekprice() {
        return fieldWeekprice;
    }

    public void setFieldWeekprice(Long fieldWeekprice) {
        this.fieldWeekprice = fieldWeekprice;
    }

    public Long getFieldMonthprice() {
        return fieldMonthprice;
    }

    public void setFieldMonthprice(Long fieldMonthprice) {
        this.fieldMonthprice = fieldMonthprice;
    }

    public String getFieldAddress() {
        return fieldAddress;
    }

    public void setFieldAddress(String fieldAddress) {
        this.fieldAddress = fieldAddress == null ? null : fieldAddress.trim();
    }

    public Integer getFieldGrade() {
        return fieldGrade;
    }

    public void setFieldGrade(Integer fieldGrade) {
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
}