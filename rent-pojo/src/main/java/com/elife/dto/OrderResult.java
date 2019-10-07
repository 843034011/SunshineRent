package com.elife.dto;

import java.math.BigDecimal;
import java.util.Date;

public class OrderResult {
    private String shoppingCartId;
    private String type;
    private Integer id;
    private String name;
    private BigDecimal total;
    private Date startTime;
    private Date endTime;
    private Integer fieldId;
    private Integer goodsId;
    private String orderId;
    private String address;

    @Override
    public String toString() {
        return "OrderResult{" +
                "shoppingCartId='" + shoppingCartId + '\'' +
                ", type='" + type + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", total=" + total +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", fieldId=" + fieldId +
                ", goodsId=" + goodsId +
                ", orderId=" + orderId +
                ", address='" + address + '\'' +
                '}';
    }

    public String getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(String shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
