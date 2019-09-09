package com.elife.pojo;

public class FieldEquipment {
    private Integer id;

    private String equipName;

    private String equipType;

    private String equipPicture;

    private Long equipPrice;

    private Integer equipNumber;

    private Integer equipStock;

    private Integer fieldId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquipName() {
        return equipName;
    }

    public void setEquipName(String equipName) {
        this.equipName = equipName == null ? null : equipName.trim();
    }

    public String getEquipType() {
        return equipType;
    }

    public void setEquipType(String equipType) {
        this.equipType = equipType == null ? null : equipType.trim();
    }

    public String getEquipPicture() {
        return equipPicture;
    }

    public void setEquipPicture(String equipPicture) {
        this.equipPicture = equipPicture == null ? null : equipPicture.trim();
    }

    public Long getEquipPrice() {
        return equipPrice;
    }

    public void setEquipPrice(Long equipPrice) {
        this.equipPrice = equipPrice;
    }

    public Integer getEquipNumber() {
        return equipNumber;
    }

    public void setEquipNumber(Integer equipNumber) {
        this.equipNumber = equipNumber;
    }

    public Integer getEquipStock() {
        return equipStock;
    }

    public void setEquipStock(Integer equipStock) {
        this.equipStock = equipStock;
    }

    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }
}