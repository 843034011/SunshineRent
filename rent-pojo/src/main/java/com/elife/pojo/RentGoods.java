package com.elife.pojo;

import java.math.BigDecimal;
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

    private BigDecimal goodsDeposit;

    private BigDecimal goodsDayprice;

    private BigDecimal goodsWeekprice;

    private Date createTime;

    private BigDecimal goodsGrade;

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

    public BigDecimal getGoodsDeposit() {
        return goodsDeposit;
    }

    public void setGoodsDeposit(BigDecimal goodsDeposit) {
        this.goodsDeposit = goodsDeposit;
    }

    public BigDecimal getGoodsDayprice() {
        return goodsDayprice;
    }

    public void setGoodsDayprice(BigDecimal goodsDayprice) {
        this.goodsDayprice = goodsDayprice;
    }

    public BigDecimal getGoodsWeekprice() {
        return goodsWeekprice;
    }

    public void setGoodsWeekprice(BigDecimal goodsWeekprice) {
        this.goodsWeekprice = goodsWeekprice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getGoodsGrade() {
        return goodsGrade;
    }

    public void setGoodsGrade(BigDecimal goodsGrade) {
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
}