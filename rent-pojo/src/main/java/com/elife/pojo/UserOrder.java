package com.elife.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class UserOrder {
    private Integer id;

    private String orderNo;

    private Integer orderNumber;

    private BigDecimal orderPrice;

    private Date startTime;

    private Date endTime;

    private String orderRemark;

    private String orderStatus;

    private Date createTime;

    private Integer rentId;

    private Integer fieldId;

    private Integer goodsId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
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

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark == null ? null : orderRemark.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getRentId() {
        return rentId;
    }

    public void setRentId(Integer rentId) {
        this.rentId = rentId;
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

    private List<OrderDetail> orderDetails;

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "UserOrder{" +
                "id=" + id +
                ", orderNO='" + orderNo + '\'' +
                ", orderNumber=" + orderNumber +
                ", orderPrice=" + orderPrice +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", orderRemark='" + orderRemark + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", createTime=" + createTime +
                ", rentId=" + rentId +
                ", fieldId=" + fieldId +
                ", goodsId=" + goodsId +
                ", orderDetails=" + orderDetails +
                '}';
    }
}