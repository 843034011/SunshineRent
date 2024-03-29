package com.elife.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class RentGoods {
    private Integer id;

    private String goodsName;

    private String goodsType;

    private String goodsModel;

    private String goodsInfo;

    private Integer goodsNumber;

    private Integer goodsSurplus;

    private Long goodsDeposit;

    private Long goodsDayprice;

    private Long goodsWeekprice;

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private Integer goodsGrade;

    private Integer rentCount;

    private Integer regId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType == null ? null : goodsType.trim();
    }

    public String getGoodsModel() {
        return goodsModel;
    }

    public void setGoodsModel(String goodsModel) {
        this.goodsModel = goodsModel == null ? null : goodsModel.trim();
    }

    public String getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(String goodsInfo) {
        this.goodsInfo = goodsInfo == null ? null : goodsInfo.trim();
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public Integer getGoodsSurplus() {
        return goodsSurplus;
    }

    public void setGoodsSurplus(Integer goodsSurplus) {
        this.goodsSurplus = goodsSurplus;
    }

    public Long getGoodsDeposit() {
        return goodsDeposit;
    }

    public void setGoodsDeposit(Long goodsDeposit) {
        this.goodsDeposit = goodsDeposit;
    }

    public Long getGoodsDayprice() {
        return goodsDayprice;
    }

    public void setGoodsDayprice(Long goodsDayprice) {
        this.goodsDayprice = goodsDayprice;
    }

    public Long getGoodsWeekprice() {
        return goodsWeekprice;
    }

    public void setGoodsWeekprice(Long goodsWeekprice) {
        this.goodsWeekprice = goodsWeekprice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getGoodsGrade() {
        return goodsGrade;
    }

    public void setGoodsGrade(Integer goodsGrade) {
        this.goodsGrade = goodsGrade;
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

    private List<GoodsPicture> goodsPictures;

    public List<GoodsPicture> getGoodsPictures() {
        return goodsPictures;
    }

    public void setGoodsPictures(List<GoodsPicture> goodsPictures) {
        this.goodsPictures = goodsPictures;
    }

    @Override
    public String toString() {
        return "RentGoods{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", goodsType='" + goodsType + '\'' +
                ", goodsModel='" + goodsModel + '\'' +
                ", goodsInfo='" + goodsInfo + '\'' +
                ", goodsNumber=" + goodsNumber +
                ", goodsSurplus=" + goodsSurplus +
                ", goodsDeposit=" + goodsDeposit +
                ", goodsDayprice=" + goodsDayprice +
                ", goodsWeekprice=" + goodsWeekprice +
                ", createTime=" + createTime +
                ", goodsGrade=" + goodsGrade +
                ", rentCount=" + rentCount +
                ", regId=" + regId +
                ", goodsPictures=" + goodsPictures +
                '}';
    }
}