package com.rundatop.sys.model;

import java.util.Date;
import javax.persistence.*;

public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * Ƶ������
     */
    @Column(name = "channel_name")
    private String channelName;

    /**
     * Ƶ������
     */
    @Column(name = "channel_code")
    private String channelCode;

    /**
     * Ƶ�����
     */
    @Column(name = "channel_no")
    private String channelNo;

    /**
     * ��ע
     */
    private String remark;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "creater_id")
    private String createrId;

    /**
     * �Ƿ���ʾ��ҳ���� 0����ʾ  1��ʾ
     */
    private String free1;

    private String free2;

    private String free3;

    /**
     * ��־λ��Ŀǰ���������Ƿ���ר�� 1:ר��
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
     * ��ȡƵ������
     *
     * @return channel_name - Ƶ������
     */
    public String getChannelName() {
        return channelName;
    }

    /**
     * ����Ƶ������
     *
     * @param channelName Ƶ������
     */
    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    /**
     * ��ȡƵ������
     *
     * @return channel_code - Ƶ������
     */
    public String getChannelCode() {
        return channelCode;
    }

    /**
     * ����Ƶ������
     *
     * @param channelCode Ƶ������
     */
    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    /**
     * ��ȡƵ�����
     *
     * @return channel_no - Ƶ�����
     */
    public String getChannelNo() {
        return channelNo;
    }

    /**
     * ����Ƶ�����
     *
     * @param channelNo Ƶ�����
     */
    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    /**
     * ��ȡ��ע
     *
     * @return remark - ��ע
     */
    public String getRemark() {
        return remark;
    }

    /**
     * ���ñ�ע
     *
     * @param remark ��ע
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
     * ��ȡ�Ƿ���ʾ��ҳ���� 0����ʾ  1��ʾ
     *
     * @return free1 - �Ƿ���ʾ��ҳ���� 0����ʾ  1��ʾ
     */
    public String getFree1() {
        return free1;
    }

    /**
     * �����Ƿ���ʾ��ҳ���� 0����ʾ  1��ʾ
     *
     * @param free1 �Ƿ���ʾ��ҳ���� 0����ʾ  1��ʾ
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
     * ��ȡ��־λ��Ŀǰ���������Ƿ���ר�� 1:ר��
     *
     * @return flag_bit - ��־λ��Ŀǰ���������Ƿ���ר�� 1:ר��
     */
    public Integer getFlagBit() {
        return flagBit;
    }

    /**
     * ���ñ�־λ��Ŀǰ���������Ƿ���ר�� 1:ר��
     *
     * @param flagBit ��־λ��Ŀǰ���������Ƿ���ר�� 1:ר��
     */
    public void setFlagBit(Integer flagBit) {
        this.flagBit = flagBit;
    }
}