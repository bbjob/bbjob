package com.rundatop.sys.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "channel_columns_member")
public class ChannelColumnsMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "channel_columns_id")
    private String channelColumnsId;

    @Column(name = "member_group_id")
    private String memberGroupId;

    private Integer status;

    private String remarks;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "creater_id")
    private String createrId;

    private String free1;

    private String free2;

    private String free3;

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
     * @return channel_columns_id
     */
    public String getChannelColumnsId() {
        return channelColumnsId;
    }

    /**
     * @param channelColumnsId
     */
    public void setChannelColumnsId(String channelColumnsId) {
        this.channelColumnsId = channelColumnsId;
    }

    /**
     * @return member_group_id
     */
    public String getMemberGroupId() {
        return memberGroupId;
    }

    /**
     * @param memberGroupId
     */
    public void setMemberGroupId(String memberGroupId) {
        this.memberGroupId = memberGroupId;
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
     * @return remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
     * @return creater_id
     */
    public String getCreaterId() {
        return createrId;
    }

    /**
     * @param createrId
     */
    public void setCreaterId(String createrId) {
        this.createrId = createrId;
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
}