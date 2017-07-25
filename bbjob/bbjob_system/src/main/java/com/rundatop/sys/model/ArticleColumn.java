package com.rundatop.sys.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "article_column")
public class ArticleColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * ����ID
     */
    @Column(name = "article_id")
    private String articleId;

    /**
     * ��ĿID
     */
    @Column(name = "column_id")
    private String columnId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "creater_id")
    private String createrId;

    /**
     * ��ռ�á��Ƿ��ö� 1��0��Ĭ��
     */
    private String free1;

    /**
     * ��ռ�á��Ƿ�Ӿ� 1��0��Ĭ��
     */
    private String free2;

    /**
     * ���� 1�� 0��
     */
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
     * ��ȡ����ID
     *
     * @return article_id - ����ID
     */
    public String getArticleId() {
        return articleId;
    }

    /**
     * ��������ID
     *
     * @param articleId ����ID
     */
    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    /**
     * ��ȡ��ĿID
     *
     * @return column_id - ��ĿID
     */
    public String getColumnId() {
        return columnId;
    }

    /**
     * ������ĿID
     *
     * @param columnId ��ĿID
     */
    public void setColumnId(String columnId) {
        this.columnId = columnId;
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
     * ��ȡ��ռ�á��Ƿ��ö� 1��0��Ĭ��
     *
     * @return free1 - ��ռ�á��Ƿ��ö� 1��0��Ĭ��
     */
    public String getFree1() {
        return free1;
    }

    /**
     * ���á�ռ�á��Ƿ��ö� 1��0��Ĭ��
     *
     * @param free1 ��ռ�á��Ƿ��ö� 1��0��Ĭ��
     */
    public void setFree1(String free1) {
        this.free1 = free1;
    }

    /**
     * ��ȡ��ռ�á��Ƿ�Ӿ� 1��0��Ĭ��
     *
     * @return free2 - ��ռ�á��Ƿ�Ӿ� 1��0��Ĭ��
     */
    public String getFree2() {
        return free2;
    }

    /**
     * ���á�ռ�á��Ƿ�Ӿ� 1��0��Ĭ��
     *
     * @param free2 ��ռ�á��Ƿ�Ӿ� 1��0��Ĭ��
     */
    public void setFree2(String free2) {
        this.free2 = free2;
    }

    /**
     * ��ȡ���� 1�� 0��
     *
     * @return free3 - ���� 1�� 0��
     */
    public String getFree3() {
        return free3;
    }

    /**
     * ���ù��� 1�� 0��
     *
     * @param free3 ���� 1�� 0��
     */
    public void setFree3(String free3) {
        this.free3 = free3;
    }
}