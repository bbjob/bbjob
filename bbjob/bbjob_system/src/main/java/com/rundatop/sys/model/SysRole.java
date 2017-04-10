package com.rundatop.sys.model;

import javax.persistence.*;

@Table(name = "sys_role")
public class SysRole {
    /**
     * ����
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * ��ɫ����
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * �Ƿ�����
     */
    private Integer enable;

    /**
     * ��ע
     */
    private String remark;

    /**
     * ��ȡ����
     *
     * @return id - ����
     */
    public Integer getId() {
        return id;
    }

    /**
     * ��������
     *
     * @param id ����
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * ��ȡ��ɫ����
     *
     * @return role_name - ��ɫ����
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * ���ý�ɫ����
     *
     * @param roleName ��ɫ����
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * ��ȡ�Ƿ�����
     *
     * @return enable - �Ƿ�����
     */
    public Integer getEnable() {
        return enable;
    }

    /**
     * �����Ƿ�����
     *
     * @param enable �Ƿ�����
     */
    public void setEnable(Integer enable) {
        this.enable = enable;
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
}