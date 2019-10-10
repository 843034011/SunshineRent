package com.elife.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;
import java.util.Date;

@Document(indexName = "orderdetail",type = "orderdetail", shards = 4, replicas = 0)
public class OrderDetail {
    @Id
    private Integer id;

    private Integer orderId;

    private Integer goodsId;

    private Integer fieldId;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String productName;

    private String productType;

    private String productModel;

    private String productAddress;

    private Integer productNumber;

    private BigDecimal productDeposit;

    private BigDecimal productPrice;

    private BigDecimal productTotal;

    private Date startTime;

    private Date endTime;

    private String productStatus;

    private Integer masterId;

    private String masterPhone;

    private String extra1;

    private String extra2;

    private String extra3;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel == null ? null : productModel.trim();
    }

    public String getProductAddress() {
        return productAddress;
    }

    public void setProductAddress(String productAddress) {
        this.productAddress = productAddress == null ? null : productAddress.trim();
    }

    public Integer getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Integer productNumber) {
        this.productNumber = productNumber;
    }

    public BigDecimal getProductDeposit() {
        return productDeposit;
    }

    public void setProductDeposit(BigDecimal productDeposit) {
        this.productDeposit = productDeposit;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public BigDecimal getProductTotal() {
        return productTotal;
    }

    public void setProductTotal(BigDecimal productTotal) {
        this.productTotal = productTotal;
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

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus == null ? null : productStatus.trim();
    }

    public Integer getMasterId() {
        return masterId;
    }

    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }

    public String getMasterPhone() {
        return masterPhone;
    }

    public void setMasterPhone(String masterPhone) {
        this.masterPhone = masterPhone == null ? null : masterPhone.trim();
    }

    public String getExtra1() {
        return extra1;
    }

    public void setExtra1(String extra1) {
        this.extra1 = extra1 == null ? null : extra1.trim();
    }

    public String getExtra2() {
        return extra2;
    }

    public void setExtra2(String extra2) {
        this.extra2 = extra2 == null ? null : extra2.trim();
    }

    public String getExtra3() {
        return extra3;
    }

    public void setExtra3(String extra3) {
        this.extra3 = extra3 == null ? null : extra3.trim();
    }

    public OrderDetail() {
    }

    public OrderDetail(Integer id, Integer orderId, Integer goodsId, Integer fieldId, String productName, String productType, String productModel, String productAddress, Integer productNumber, BigDecimal productDeposit, BigDecimal productPrice, BigDecimal productTotal, Date startTime, Date endTime, String productStatus, Integer masterId, String masterPhone, String extra1, String extra2, String extra3) {
        this.id = id;
        this.orderId = orderId;
        this.goodsId = goodsId;
        this.fieldId = fieldId;
        this.productName = productName;
        this.productType = productType;
        this.productModel = productModel;
        this.productAddress = productAddress;
        this.productNumber = productNumber;
        this.productDeposit = productDeposit;
        this.productPrice = productPrice;
        this.productTotal = productTotal;
        this.startTime = startTime;
        this.endTime = endTime;
        this.productStatus = productStatus;
        this.masterId = masterId;
        this.masterPhone = masterPhone;
        this.extra1 = extra1;
        this.extra2 = extra2;
        this.extra3 = extra3;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", goodsId=" + goodsId +
                ", fieldId=" + fieldId +
                ", productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                ", productModel='" + productModel + '\'' +
                ", productAddress='" + productAddress + '\'' +
                ", productNumber=" + productNumber +
                ", productDeposit=" + productDeposit +
                ", productPrice=" + productPrice +
                ", productTotal=" + productTotal +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", productStatus='" + productStatus + '\'' +
                ", masterId=" + masterId +
                ", masterPhone='" + masterPhone + '\'' +
                ", extra1='" + extra1 + '\'' +
                ", extra2='" + extra2 + '\'' +
                ", extra3='" + extra3 + '\'' +
                '}';
    }
}