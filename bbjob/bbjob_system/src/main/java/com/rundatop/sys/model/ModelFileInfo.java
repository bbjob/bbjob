package com.rundatop.sys.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "model_file_info")
public class ModelFileInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_title")
    private String fileTitle;

    @Column(name = "file_desc")
    private String fileDesc;

    @Column(name = "file_path")
    private String filePath;

    private String free1;

    private String free2;

    private String free3;

    private String remark;

    private Integer status;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "create_name")
    private String createName;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "update_name")
    private String updateName;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return file_name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return file_title
     */
    public String getFileTitle() {
        return fileTitle;
    }

    /**
     * @param fileTitle
     */
    public void setFileTitle(String fileTitle) {
        this.fileTitle = fileTitle;
    }

    /**
     * @return file_desc
     */
    public String getFileDesc() {
        return fileDesc;
    }

    /**
     * @param fileDesc
     */
    public void setFileDesc(String fileDesc) {
        this.fileDesc = fileDesc;
    }

    /**
     * @return file_path
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * @param filePath
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * @return free1
     */
    public String getFree1() {
        return free1;
    }

    /**
     * @param free1
     */
    public void setFree1(String free1) {
        this.free1 = free1;
    }

    /**
     * @return free2
     */
    public String getFree2() {
        return free2;
    }

    /**
     * @param free2
     */
    public void setFree2(String free2) {
        this.free2 = free2;
    }

    /**
     * @return free3
     */
    public String getFree3() {
        return free3;
    }

    /**
     * @param free3
     */
    public void setFree3(String free3) {
        this.free3 = free3;
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return create_name
     */
    public String getCreateName() {
        return createName;
    }

    /**
     * @param createName
     */
    public void setCreateName(String createName) {
        this.createName = createName;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return update_name
     */
    public String getUpdateName() {
        return updateName;
    }

    /**
     * @param updateName
     */
    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }
    
    @Transient
    private String conent;

	public String getConent() {
		return conent;
	}

	public void setConent(String conent) {
		this.conent = conent;
	}
    
}