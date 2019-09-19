package com.elife.pojo;

import java.util.Date;
import java.util.List;

public class remarks {
    private Integer id;
    private Integer eva_grade;
    private String eva_content;
    private Date create_time;
    private Integer reg_id;
    private Integer order_id;
    private Integer zan;
    List<Pictures> picture;
    List<reply> replys;

    @Override
    public String toString() {
        return "Remarks{" +
                "id=" + id +
                ", eva_grade=" + eva_grade +
                ", eva_content='" + eva_content + '\'' +
                ", create_time=" + create_time +
                ", reg_id=" + reg_id +
                ", order_id=" + order_id +
                ", zan=" + zan +
                ", picture=" + picture +
                ", replys=" + replys +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEva_grade() {
        return eva_grade;
    }

    public void setEva_grade(Integer eva_grade) {
        this.eva_grade = eva_grade;
    }

    public String getEva_content() {
        return eva_content;
    }

    public void setEva_content(String eva_content) {
        this.eva_content = eva_content;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Integer getReg_id() {
        return reg_id;
    }

    public void setReg_id(Integer reg_id) {
        this.reg_id = reg_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getZan() {
        return zan;
    }

    public void setZan(Integer zan) {
        this.zan = zan;
    }

    public List<Pictures> getPicture() {
        return picture;
    }

    public void setPicture(List<Pictures> picture) {
        this.picture = picture;
    }

    public List<reply> getReplys() {
        return replys;
    }

    public void setReplys(List<reply> replys) {
        this.replys = replys;
    }
}
