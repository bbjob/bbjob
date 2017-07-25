package com.rundatop.sys.model;

import java.util.Date;
import javax.persistence.*;

public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 频道名称
     */
    @Column(name = "channel_name")
    private String channelName;

    /**
     * 频道编码
     */
    @Column(name = "channel_code")
    private String channelCode;

    /**
     * 频道编号
     */
    @Column(name = "channel_no")
    private String channelNo;

    /**
     * 备注
     */
    private String remark;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "creater_id")
    private String createrId;

    /**
     * 是否显示首页导航 0不显示  1显示
     */
    private String free1;

    private String free2;

    private String free3;

    /**
     * 标志位，目前用于区分是否是专题 1:专题
     */
    @Column(name = "flag_bit")
    private Integer flagBit;

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
     * 获取频道名称
     *
     * @return channel_name - 频道名称
     */
    public String getChannelName() {
        return channelName;
    }

    /**
     * 设置频道名称
     *
     * @param channelName 频道名称
     */
    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    /**
     * 获取频道编码
     *
     * @return channel_code - 频道编码
     */
    public String getChannelCode() {
        return channelCode;
    }

    /**
     * 设置频道编码
     *
     * @param channelCode 频道编码
     */
    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    /**
     * 获取频道编号
     *
     * @return channel_no - 频道编号
     */
    public String getChannelNo() {
        return channelNo;
    }

    /**
     * 设置频道编号
     *
     * @param channelNo 频道编号
     */
    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
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
     * 获取是否显示首页导航 0不显示  1显示
     *
     * @return free1 - 是否显示首页导航 0不显示  1显示
     */
    public String getFree1() {
        return free1;
    }

    /**
     * 设置是否显示首页导航 0不显示  1显示
     *
     * @param free1 是否显示首页导航 0不显示  1显示
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
     * 获取标志位，目前用于区分是否是专题 1:专题
     *
     * @return flag_bit - 标志位，目前用于区分是否是专题 1:专题
     */
    public Integer getFlagBit() {
        return flagBit;
    }

    /**
     * 设置标志位，目前用于区分是否是专题 1:专题
     *
     * @param flagBit 标志位，目前用于区分是否是专题 1:专题
     */
    public void setFlagBit(Integer flagBit) {
        this.flagBit = flagBit;
    }
}