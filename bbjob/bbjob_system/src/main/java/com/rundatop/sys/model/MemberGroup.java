package com.rundatop.sys.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "member_group")
public class MemberGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 会员组名称
     */
    @Column(name = "group_name")
    private String groupName;

    /**
     * 会员组介绍
     */
    @Column(name = "group_description")
    private String groupDescription;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "creater_id")
    private String createrId;

    private String free1;

    private String free2;

    private String free3;

    @Column(name = "group_order")
    private Integer groupOrder;

    @Column(name = "group_status")
    private Integer groupStatus;

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
     * 获取会员组名称
     *
     * @return group_name - 会员组名称
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 设置会员组名称
     *
     * @param groupName 会员组名称
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * 获取会员组介绍
     *
     * @return group_description - 会员组介绍
     */
    public String getGroupDescription() {
        return groupDescription;
    }

    /**
     * 设置会员组介绍
     *
     * @param groupDescription 会员组介绍
     */
    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
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

    /**
     * @return group_order
     */
    public Integer getGroupOrder() {
        return groupOrder;
    }

    /**
     * @param groupOrder
     */
    public void setGroupOrder(Integer groupOrder) {
        this.groupOrder = groupOrder;
    }

    /**
     * @return group_status
     */
    public Integer getGroupStatus() {
        return groupStatus;
    }

    /**
     * @param groupStatus
     */
    public void setGroupStatus(Integer groupStatus) {
        this.groupStatus = groupStatus;
    }
}