package com.elife.pojo;

public class FieldPicture {
    private Integer id;

    private String fieldPicture;

    private Integer fieldId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFieldPicture() {
        return fieldPicture;
    }

    public void setFieldPicture(String fieldPicture) {
        this.fieldPicture = fieldPicture == null ? null : fieldPicture.trim();
    }

    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }
}