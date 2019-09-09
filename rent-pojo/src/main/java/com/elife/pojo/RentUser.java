package com.elife.pojo;

public class RentUser {
    private Integer userId;

    private String userIdcard;

    private String idcardFront;

    private String idcardBack;

    private String userNickname;

    private String userRealname;

    private String userPicture;

    private String userPhone;

    private String userEmail;

    private Integer rentCredit;

    private Integer rentoutCredit;

    private Byte isIdentified;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserIdcard() {
        return userIdcard;
    }

    public void setUserIdcard(String userIdcard) {
        this.userIdcard = userIdcard == null ? null : userIdcard.trim();
    }

    public String getIdcardFront() {
        return idcardFront;
    }

    public void setIdcardFront(String idcardFront) {
        this.idcardFront = idcardFront == null ? null : idcardFront.trim();
    }

    public String getIdcardBack() {
        return idcardBack;
    }

    public void setIdcardBack(String idcardBack) {
        this.idcardBack = idcardBack == null ? null : idcardBack.trim();
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    public String getUserRealname() {
        return userRealname;
    }

    public void setUserRealname(String userRealname) {
        this.userRealname = userRealname == null ? null : userRealname.trim();
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture == null ? null : userPicture.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public Integer getRentCredit() {
        return rentCredit;
    }

    public void setRentCredit(Integer rentCredit) {
        this.rentCredit = rentCredit;
    }

    public Integer getRentoutCredit() {
        return rentoutCredit;
    }

    public void setRentoutCredit(Integer rentoutCredit) {
        this.rentoutCredit = rentoutCredit;
    }

    public Byte getIsIdentified() {
        return isIdentified;
    }

    public void setIsIdentified(Byte isIdentified) {
        this.isIdentified = isIdentified;
    }
}