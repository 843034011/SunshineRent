package com.elife.dto;

public class ShoppingCartResult {

    private String startTime;
    private String endTime;
    private Float orderPrice;
    private Integer rid;
    private Integer fieldId;
    private Integer goodsId;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Float getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Float orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
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

    @Override
    public String toString() {
        return "ShoppingCartResult{" +
                "startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", orderPrice=" + orderPrice +
                ", rid=" + rid +
                ", fieldId=" + fieldId +
                ", goodsId=" + goodsId +
                '}';
    }
}
