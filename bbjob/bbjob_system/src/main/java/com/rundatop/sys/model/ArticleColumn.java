package com.rundatop.sys.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "article_column")
public class ArticleColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 文章ID
     */
    @Column(name = "article_id")
    private String articleId;

    /**
     * 栏目ID
     */
    @Column(name = "column_id")
    private String columnId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "creater_id")
    private String createrId;

    /**
     * 【占用】是否置顶 1是0否默认
     */
    private String free1;

    /**
     * 【占用】是否加精 1是0否默认
     */
    private String free2;

    /**
     * 滚动 1是 0否
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
     * 获取文章ID
     *
     * @return article_id - 文章ID
     */
    public String getArticleId() {
        return articleId;
    }

    /**
     * 设置文章ID
     *
     * @param articleId 文章ID
     */
    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    /**
     * 获取栏目ID
     *
     * @return column_id - 栏目ID
     */
    public String getColumnId() {
        return columnId;
    }

    /**
     * 设置栏目ID
     *
     * @param columnId 栏目ID
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
     * 获取【占用】是否置顶 1是0否默认
     *
     * @return free1 - 【占用】是否置顶 1是0否默认
     */
    public String getFree1() {
        return free1;
    }

    /**
     * 设置【占用】是否置顶 1是0否默认
     *
     * @param free1 【占用】是否置顶 1是0否默认
     */
    public void setFree1(String free1) {
        this.free1 = free1;
    }

    /**
     * 获取【占用】是否加精 1是0否默认
     *
     * @return free2 - 【占用】是否加精 1是0否默认
     */
    public String getFree2() {
        return free2;
    }

    /**
     * 设置【占用】是否加精 1是0否默认
     *
     * @param free2 【占用】是否加精 1是0否默认
     */
    public void setFree2(String free2) {
        this.free2 = free2;
    }

    /**
     * 获取滚动 1是 0否
     *
     * @return free3 - 滚动 1是 0否
     */
    public String getFree3() {
        return free3;
    }

    /**
     * 设置滚动 1是 0否
     *
     * @param free3 滚动 1是 0否
     */
    public void setFree3(String free3) {
        this.free3 = free3;
    }
}