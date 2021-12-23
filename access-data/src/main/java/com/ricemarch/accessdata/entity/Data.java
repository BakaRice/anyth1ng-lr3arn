package com.ricemarch.accessdata.entity;

import java.util.Date;

/**
 * 数据表
 */
public class Data {
    /**
     * 数据记录id
     */
    private Long id;

    /**
     * 当前hash值
     */
    private String hash;

    /**
     * 前hash值
     */
    private String previousHash;

    /**
     * 文件hash值
     */
    private String fileHash;

    private String send;

    private String rece;

    private String name;

    private Date createTime;

    private Date updateTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 修人
     */
    private String updateBy;

    /**
     * 是否已经删除
     */
    private Integer isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getFileHash() {
        return fileHash;
    }

    public void setFileHash(String fileHash) {
        this.fileHash = fileHash;
    }

    public String getSend() {
        return send;
    }

    public void setSend(String send) {
        this.send = send;
    }

    public String getRece() {
        return rece;
    }

    public void setRece(String rece) {
        this.rece = rece;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}