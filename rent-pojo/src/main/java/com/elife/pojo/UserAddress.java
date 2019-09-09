package com.elife.pojo;

public class UserAddress {
    private Integer id;

    private String pickerName;

    private String pickerPhone;

    private String address;

    private Integer regId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPickerName() {
        return pickerName;
    }

    public void setPickerName(String pickerName) {
        this.pickerName = pickerName == null ? null : pickerName.trim();
    }

    public String getPickerPhone() {
        return pickerPhone;
    }

    public void setPickerPhone(String pickerPhone) {
        this.pickerPhone = pickerPhone == null ? null : pickerPhone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getRegId() {
        return regId;
    }

    public void setRegId(Integer regId) {
        this.regId = regId;
    }
}