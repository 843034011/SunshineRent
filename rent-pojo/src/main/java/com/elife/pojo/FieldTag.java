package com.elife.pojo;

public class FieldTag {
    private Integer id;

    private String tagName;

    private Integer tagCount;

    private Integer fieldId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName == null ? null : tagName.trim();
    }

    public Integer getTagCount() {
        return tagCount;
    }

    public void setTagCount(Integer tagCount) {
        this.tagCount = tagCount;
    }

    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }
}