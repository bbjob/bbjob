package com.rundatop.sys.model;

import javax.persistence.*;

@Table(name = "sys_function")
public class SysFunction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * �ϼ�����id�������Եݹ飬1������ʱ���ֶο�����
     */
    @Column(name = "p_id")
    private Integer pId;

    /**
     * ��������
     */
    private String name;

    /**
     * �������ͣ�
1��ģ�����ƣ��˵��ϵķ��飬����û��url
2�����幦�ܣ�����ָ�������ĸ�ģ�顣
     */
    private String type;

    /**
     * ��ģ���ģ����+Ȩ�޴��룬�磺�û�ģ�������û����ܣ�(Ĭ����XXX_VIEWȨ��)
     */
    @Column(name = "permission_code")
    private String permissionCode;

    /**
     * �ù����Ƿ�����ڲ˵���
     */
    @Column(name = "is_menu")
    private String isMenu;

    /**
     * �ù��ܵĴ򿪷�ʽ��
1��tab��
2��window
3����ҳ��
     */
    @Column(name = "open_type")
    private String openType;

    /**
     * �˵���iconͼ��
��֤icon_cls��icon.css���ڣ���ͼƬ���ڡ�
     */
    @Column(name = "icon_cls")
    private String iconCls;

    /**
     * �����window��ʽ�򿪣�������Ҫ��дwindow������ֵ��
     */
    @Column(name = "window_option")
    private String windowOption;

    /**
     * �����ģ�飬���п�Ϊ��
     */
    private String url;

    /**
     * �ù����Ƿ��,����Ȩ��ʱ�Ƿ�ɷ��䡣���ֶζԳ�����Ч��
     */
    @Column(name = "is_visible")
    private String isVisible;

    @Column(name = "sort_no")
    private Integer sortNo;

    private String remark;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * ��ȡ�ϼ�����id�������Եݹ飬1������ʱ���ֶο�����
     *
     * @return p_id - �ϼ�����id�������Եݹ飬1������ʱ���ֶο�����
     */
    public Integer getpId() {
        return pId;
    }

    /**
     * �����ϼ�����id�������Եݹ飬1������ʱ���ֶο�����
     *
     * @param pId �ϼ�����id�������Եݹ飬1������ʱ���ֶο�����
     */
    public void setpId(Integer pId) {
        this.pId = pId;
    }

    /**
     * ��ȡ��������
     *
     * @return name - ��������
     */
    public String getName() {
        return name;
    }

    /**
     * ���ù�������
     *
     * @param name ��������
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ��ȡ�������ͣ�
1��ģ�����ƣ��˵��ϵķ��飬����û��url
2�����幦�ܣ�����ָ�������ĸ�ģ�顣
     *
     * @return type - �������ͣ�
1��ģ�����ƣ��˵��ϵķ��飬����û��url
2�����幦�ܣ�����ָ�������ĸ�ģ�顣
     */
    public String getType() {
        return type;
    }

    /**
     * ���ù������ͣ�
1��ģ�����ƣ��˵��ϵķ��飬����û��url
2�����幦�ܣ�����ָ�������ĸ�ģ�顣
     *
     * @param type �������ͣ�
1��ģ�����ƣ��˵��ϵķ��飬����û��url
2�����幦�ܣ�����ָ�������ĸ�ģ�顣
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * ��ȡ��ģ���ģ����+Ȩ�޴��룬�磺�û�ģ�������û����ܣ�(Ĭ����XXX_VIEWȨ��)
     *
     * @return permission_code - ��ģ���ģ����+Ȩ�޴��룬�磺�û�ģ�������û����ܣ�(Ĭ����XXX_VIEWȨ��)
     */
    public String getPermissionCode() {
        return permissionCode;
    }

    /**
     * ���ø�ģ���ģ����+Ȩ�޴��룬�磺�û�ģ�������û����ܣ�(Ĭ����XXX_VIEWȨ��)
     *
     * @param permissionCode ��ģ���ģ����+Ȩ�޴��룬�磺�û�ģ�������û����ܣ�(Ĭ����XXX_VIEWȨ��)
     */
    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    /**
     * ��ȡ�ù����Ƿ�����ڲ˵���
     *
     * @return is_menu - �ù����Ƿ�����ڲ˵���
     */
    public String getIsMenu() {
        return isMenu;
    }

    /**
     * ���øù����Ƿ�����ڲ˵���
     *
     * @param isMenu �ù����Ƿ�����ڲ˵���
     */
    public void setIsMenu(String isMenu) {
        this.isMenu = isMenu;
    }

    /**
     * ��ȡ�ù��ܵĴ򿪷�ʽ��
1��tab��
2��window
3����ҳ��
     *
     * @return open_type - �ù��ܵĴ򿪷�ʽ��
1��tab��
2��window
3����ҳ��
     */
    public String getOpenType() {
        return openType;
    }

    /**
     * ���øù��ܵĴ򿪷�ʽ��
1��tab��
2��window
3����ҳ��
     *
     * @param openType �ù��ܵĴ򿪷�ʽ��
1��tab��
2��window
3����ҳ��
     */
    public void setOpenType(String openType) {
        this.openType = openType;
    }

    /**
     * ��ȡ�˵���iconͼ��
��֤icon_cls��icon.css���ڣ���ͼƬ���ڡ�
     *
     * @return icon_cls - �˵���iconͼ��
��֤icon_cls��icon.css���ڣ���ͼƬ���ڡ�
     */
    public String getIconCls() {
        return iconCls;
    }

    /**
     * ���ò˵���iconͼ��
��֤icon_cls��icon.css���ڣ���ͼƬ���ڡ�
     *
     * @param iconCls �˵���iconͼ��
��֤icon_cls��icon.css���ڣ���ͼƬ���ڡ�
     */
    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    /**
     * ��ȡ�����window��ʽ�򿪣�������Ҫ��дwindow������ֵ��
     *
     * @return window_option - �����window��ʽ�򿪣�������Ҫ��дwindow������ֵ��
     */
    public String getWindowOption() {
        return windowOption;
    }

    /**
     * ���������window��ʽ�򿪣�������Ҫ��дwindow������ֵ��
     *
     * @param windowOption �����window��ʽ�򿪣�������Ҫ��дwindow������ֵ��
     */
    public void setWindowOption(String windowOption) {
        this.windowOption = windowOption;
    }

    /**
     * ��ȡ�����ģ�飬���п�Ϊ��
     *
     * @return url - �����ģ�飬���п�Ϊ��
     */
    public String getUrl() {
        return url;
    }

    /**
     * ���������ģ�飬���п�Ϊ��
     *
     * @param url �����ģ�飬���п�Ϊ��
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * ��ȡ�ù����Ƿ��,����Ȩ��ʱ�Ƿ�ɷ��䡣���ֶζԳ�����Ч��
     *
     * @return is_visible - �ù����Ƿ��,����Ȩ��ʱ�Ƿ�ɷ��䡣���ֶζԳ�����Ч��
     */
    public String getIsVisible() {
        return isVisible;
    }

    /**
     * ���øù����Ƿ��,����Ȩ��ʱ�Ƿ�ɷ��䡣���ֶζԳ�����Ч��
     *
     * @param isVisible �ù����Ƿ��,����Ȩ��ʱ�Ƿ�ɷ��䡣���ֶζԳ�����Ч��
     */
    public void setIsVisible(String isVisible) {
        this.isVisible = isVisible;
    }

    /**
     * @return sort_no
     */
    public Integer getSortNo() {
        return sortNo;
    }

    /**
     * @param sortNo
     */
    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
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
}