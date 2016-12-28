package com.atguigu.jf.console.adv.bean.pojo;

import java.util.Date;

public class AreaDef {
    private String areaId;

    private String areaCode;

    private String areaName;

    private String areaDesc;

    private Integer areaLevel;

    private String supAreaTree;

    private String supAreaId;

    private Long creator;

    private Date createDate;

    private Long modifier;

    private Date modifyDate;

    private Short dataState;

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }

    public String getAreaDesc() {
        return areaDesc;
    }

    public void setAreaDesc(String areaDesc) {
        this.areaDesc = areaDesc == null ? null : areaDesc.trim();
    }

    public Integer getAreaLevel() {
        return areaLevel;
    }

    public void setAreaLevel(Integer areaLevel) {
        this.areaLevel = areaLevel;
    }

    public String getSupAreaTree() {
        return supAreaTree;
    }

    public void setSupAreaTree(String supAreaTree) {
        this.supAreaTree = supAreaTree == null ? null : supAreaTree.trim();
    }

    public String getSupAreaId() {
        return supAreaId;
    }

    public void setSupAreaId(String supAreaId) {
        this.supAreaId = supAreaId == null ? null : supAreaId.trim();
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Short getDataState() {
        return dataState;
    }

    public void setDataState(Short dataState) {
        this.dataState = dataState;
    }
}