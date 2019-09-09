package com.elife.pojo;

public class EvaluatePicture {
    private Integer id;

    private String evaPicture;

    private Integer evaId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEvaPicture() {
        return evaPicture;
    }

    public void setEvaPicture(String evaPicture) {
        this.evaPicture = evaPicture == null ? null : evaPicture.trim();
    }

    public Integer getEvaId() {
        return evaId;
    }

    public void setEvaId(Integer evaId) {
        this.evaId = evaId;
    }
}