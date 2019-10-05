package com.elife.dto;

import java.util.List;

public class TotalOrderResult {
    private String orderId;
    private String orderNumber = "1";
    private String orderTotal;
    private String orderStatus;
    private String createTime;

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    private String rId;
    private List<OrderResult> results;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(String orderTotal) {
        this.orderTotal = orderTotal;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public List<OrderResult> getResults() {
        return results;
    }

    public void setResults(List<OrderResult> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "TotalOrderResult{" +
                "orderId='" + orderId + '\'' +
                ", orderNumber=" + orderNumber +
                ", orderTotal='" + orderTotal + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", createTime='" + createTime + '\'' +
                ", rId=" + rId +
                ", results=" + results +
                '}';
    }
}
