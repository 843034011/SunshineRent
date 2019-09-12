package com.elife.dto;

import com.elife.pojo.FieldPicture;

import java.util.List;

public class ShoppingCartResult {
    private Integer shoppingcartId;

    private String fieldName;

    private String fieldInfo;

    private Long fieldDeposit;

    private Long fieldDayprice;

    private Integer rentCount;

    private List<FieldPicture> fieldPictures;

    public Integer getShoppingcartId() {
        return shoppingcartId;
    }

    public void setShoppingcartId(Integer shoppingcartId) {
        this.shoppingcartId = shoppingcartId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldInfo() {
        return fieldInfo;
    }

    public void setFieldInfo(String fieldInfo) {
        this.fieldInfo = fieldInfo;
    }

    public Long getFieldDeposit() {
        return fieldDeposit;
    }

    public void setFieldDeposit(Long fieldDeposit) {
        this.fieldDeposit = fieldDeposit;
    }

    public Long getFieldDayprice() {
        return fieldDayprice;
    }

    public void setFieldDayprice(Long fieldDayprice) {
        this.fieldDayprice = fieldDayprice;
    }

    public Integer getRentCount() {
        return rentCount;
    }

    public void setRentCount(Integer rentCount) {
        this.rentCount = rentCount;
    }

    public List<FieldPicture> getFieldPictures() {
        return fieldPictures;
    }

    public void setFieldPictures(List<FieldPicture> fieldPictures) {
        this.fieldPictures = fieldPictures;
    }
}
