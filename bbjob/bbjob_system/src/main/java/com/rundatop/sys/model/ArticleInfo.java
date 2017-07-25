package com.rundatop.sys.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Table(name = "article_info")
public class ArticleInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idno;

    private String id;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "creater_id")
    private String createrId;

    /**
     * ��ռ�á�������
     */
    private String free1;

    /**
     * ������ַ
     */
    private String free2;

    /**
     * �Ƿ�����ҳ������ʾ(����)
     */
    private String free3;

    /**
     * �ؼ���(��ǩ)
     */
    @Column(name = "key_wordd")
    private String keyWordd;

    /**
     * ���±���
     */
    @Column(name = "article_title")
    private String articleTitle;

    /**
     * 0����ԭ��1ԭ��
     */
    @Column(name = "is_original")
    private Integer isOriginal;

    /**
     * 0���  1��ֱ�׼�������10��֣�  2���====
     */
    @Column(name = "fee_type")
    private Integer feeType;

    /**
     * ������� �����
     */
    private Integer fee;

    /**
     * �������� 0���� 1���� 2�ڿ�3����
     */
    @Column(name = "article_type")
    private Integer articleType;

    /**
     * ������Դ 0����  1��ԱͶ��  2�༭д��  3�ɱ�OA
     */
    @Column(name = "article_source")
    private String articleSource;

    /**
     * ��Ҫ
     */
    @Column(name = "arcticle_summary")
    private String arcticleSummary;

    /**
     * ������
     */
    @Column(name = "like_count")
    private Integer likeCount;

    /**
     * �����
     */
    @Column(name = "scan_count")
    private Integer scanCount;

    /**
     * ¼��ʱ��
     */
    @Column(name = "entry_date")
    private Date entryDate;

    /**
     * ����ʱ�䣨ǰ����ʾʱ�䣩
     */
    @Column(name = "order_time")
    private Date orderTime;

    /**
     * 0���ö�1�ö�
     */
    @Column(name = "is_top")
    private Integer isTop;

    /**
     * ����2
     */
    @Column(name = "article_title2")
    private String articleTitle2;

    /**
     * ȫ��
     */
    @Column(name = "title_all")
    private String titleAll;

    /**
     * �ӱ���
     */
    @Column(name = "sub_title")
    private String subTitle;

    /**
     * ԭ����
     */
    @Column(name = "old_title")
    private String oldTitle;

    /**
     * ����
     */
    @Column(name = "arctlcle_author")
    private String arctlcleAuthor;

    /**
     * ����ID
     */
    @Column(name = "author_id")
    private String authorId;

    /**
     * ����ͼ
     */
    private String pic1;

    /**
     * ����ͼ����ͼ
     */
    private String pic2;

    /**
     * ����״̬ 0δ����  1�ѷ���4����վ
     */
    @Column(name = "arcticle_status")
    private Integer arcticleStatus;

    /**
     * ��Դid ��������Ӧ��id
     */
    @Column(name = "source_id")
    private String sourceId;

    /**
     * �Ƿ�Ӿ�0��1��
     */
    @Column(name = "is_perfect")
    private Integer isPerfect;

    /**
     * 0�ر�����  1��ͨ���� 
     */
    @Column(name = "comment_type")
    private Integer commentType;

    /**
     * ���Ϊnull�� ���û�е��飻���Ϊnull���������id
            
     */
    @Column(name = "survey_id")
    private String surveyId;

    /**
     * ��̬ҳ���ַ
     */
    @Column(name = "html_url")
    private String htmlUrl;

    /**
     * 0 �ı�1 ��pdf
     */
    private String file;

    /**
     * ��������
     */
    @Column(name = "author_name")
    private String authorName;

    /**
     * ������Դ
     */
    @Column(name = "content_source")
    private String contentSource;

    private String free4;

    private String free5;

    /**
     * �Ƿ��ڹ�����ʾ 0��  1��
     */
    private String free6;

    /**
     * ��������
     */
    @Column(name = "arcticle_content")
    private String arcticleContent;

    /**
     * @return idno
     */
    public Integer getIdno() {
        return idno;
    }

    /**
     * @param idno
     */
    public void setIdno(Integer idno) {
        this.idno = idno;
    }

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
     * ��ȡ��ռ�á�������
     *
     * @return free1 - ��ռ�á�������
     */
    public String getFree1() {
        return free1;
    }

    /**
     * ���á�ռ�á�������
     *
     * @param free1 ��ռ�á�������
     */
    public void setFree1(String free1) {
        this.free1 = free1;
    }

    /**
     * ��ȡ������ַ
     *
     * @return free2 - ������ַ
     */
    public String getFree2() {
        return free2;
    }

    /**
     * ����������ַ
     *
     * @param free2 ������ַ
     */
    public void setFree2(String free2) {
        this.free2 = free2;
    }

    /**
     * ��ȡ�Ƿ�����ҳ������ʾ(����)
     *
     * @return free3 - �Ƿ�����ҳ������ʾ(����)
     */
    public String getFree3() {
        return free3;
    }

    /**
     * �����Ƿ�����ҳ������ʾ(����)
     *
     * @param free3 �Ƿ�����ҳ������ʾ(����)
     */
    public void setFree3(String free3) {
        this.free3 = free3;
    }

    /**
     * ��ȡ�ؼ���(��ǩ)
     *
     * @return key_wordd - �ؼ���(��ǩ)
     */
    public String getKeyWordd() {
        return keyWordd;
    }

    /**
     * ���ùؼ���(��ǩ)
     *
     * @param keyWordd �ؼ���(��ǩ)
     */
    public void setKeyWordd(String keyWordd) {
        this.keyWordd = keyWordd;
    }

    /**
     * ��ȡ���±���
     *
     * @return article_title - ���±���
     */
    public String getArticleTitle() {
        return articleTitle;
    }

    /**
     * �������±���
     *
     * @param articleTitle ���±���
     */
    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    /**
     * ��ȡ0����ԭ��1ԭ��
     *
     * @return is_original - 0����ԭ��1ԭ��
     */
    public Integer getIsOriginal() {
        return isOriginal;
    }

    /**
     * ����0����ԭ��1ԭ��
     *
     * @param isOriginal 0����ԭ��1ԭ��
     */
    public void setIsOriginal(Integer isOriginal) {
        this.isOriginal = isOriginal;
    }

    /**
     * ��ȡ0���  1��ֱ�׼�������10��֣�  2���====
     *
     * @return fee_type - 0���  1��ֱ�׼�������10��֣�  2���====
     */
    public Integer getFeeType() {
        return feeType;
    }

    /**
     * ����0���  1��ֱ�׼�������10��֣�  2���====
     *
     * @param feeType 0���  1��ֱ�׼�������10��֣�  2���====
     */
    public void setFeeType(Integer feeType) {
        this.feeType = feeType;
    }

    /**
     * ��ȡ������� �����
     *
     * @return fee - ������� �����
     */
    public Integer getFee() {
        return fee;
    }

    /**
     * ���þ������ �����
     *
     * @param fee ������� �����
     */
    public void setFee(Integer fee) {
        this.fee = fee;
    }

    /**
     * ��ȡ�������� 0���� 1���� 2�ڿ�3����
     *
     * @return article_type - �������� 0���� 1���� 2�ڿ�3����
     */
    public Integer getArticleType() {
        return articleType;
    }

    /**
     * ������������ 0���� 1���� 2�ڿ�3����
     *
     * @param articleType �������� 0���� 1���� 2�ڿ�3����
     */
    public void setArticleType(Integer articleType) {
        this.articleType = articleType;
    }

    /**
     * ��ȡ������Դ 0����  1��ԱͶ��  2�༭д��  3�ɱ�OA
     *
     * @return article_source - ������Դ 0����  1��ԱͶ��  2�༭д��  3�ɱ�OA
     */
    public String getArticleSource() {
        return articleSource;
    }

    /**
     * ����������Դ 0����  1��ԱͶ��  2�༭д��  3�ɱ�OA
     *
     * @param articleSource ������Դ 0����  1��ԱͶ��  2�༭д��  3�ɱ�OA
     */
    public void setArticleSource(String articleSource) {
        this.articleSource = articleSource;
    }

    /**
     * ��ȡ��Ҫ
     *
     * @return arcticle_summary - ��Ҫ
     */
    public String getArcticleSummary() {
        return arcticleSummary;
    }

    /**
     * ���ø�Ҫ
     *
     * @param arcticleSummary ��Ҫ
     */
    public void setArcticleSummary(String arcticleSummary) {
        this.arcticleSummary = arcticleSummary;
    }

    /**
     * ��ȡ������
     *
     * @return like_count - ������
     */
    public Integer getLikeCount() {
        return likeCount;
    }

    /**
     * ���õ�����
     *
     * @param likeCount ������
     */
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * ��ȡ�����
     *
     * @return scan_count - �����
     */
    public Integer getScanCount() {
        return scanCount;
    }

    /**
     * ���������
     *
     * @param scanCount �����
     */
    public void setScanCount(Integer scanCount) {
        this.scanCount = scanCount;
    }

    /**
     * ��ȡ¼��ʱ��
     *
     * @return entry_date - ¼��ʱ��
     */
    public Date getEntryDate() {
        return entryDate;
    }

    /**
     * ����¼��ʱ��
     *
     * @param entryDate ¼��ʱ��
     */
    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    /**
     * ��ȡ����ʱ�䣨ǰ����ʾʱ�䣩
     *
     * @return order_time - ����ʱ�䣨ǰ����ʾʱ�䣩
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * ��������ʱ�䣨ǰ����ʾʱ�䣩
     *
     * @param orderTime ����ʱ�䣨ǰ����ʾʱ�䣩
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * ��ȡ0���ö�1�ö�
     *
     * @return is_top - 0���ö�1�ö�
     */
    public Integer getIsTop() {
        return isTop;
    }

    /**
     * ����0���ö�1�ö�
     *
     * @param isTop 0���ö�1�ö�
     */
    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    /**
     * ��ȡ����2
     *
     * @return article_title2 - ����2
     */
    public String getArticleTitle2() {
        return articleTitle2;
    }

    /**
     * ���ñ���2
     *
     * @param articleTitle2 ����2
     */
    public void setArticleTitle2(String articleTitle2) {
        this.articleTitle2 = articleTitle2;
    }

    /**
     * ��ȡȫ��
     *
     * @return title_all - ȫ��
     */
    public String getTitleAll() {
        return titleAll;
    }

    /**
     * ����ȫ��
     *
     * @param titleAll ȫ��
     */
    public void setTitleAll(String titleAll) {
        this.titleAll = titleAll;
    }

    /**
     * ��ȡ�ӱ���
     *
     * @return sub_title - �ӱ���
     */
    public String getSubTitle() {
        return subTitle;
    }

    /**
     * �����ӱ���
     *
     * @param subTitle �ӱ���
     */
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    /**
     * ��ȡԭ����
     *
     * @return old_title - ԭ����
     */
    public String getOldTitle() {
        return oldTitle;
    }

    /**
     * ����ԭ����
     *
     * @param oldTitle ԭ����
     */
    public void setOldTitle(String oldTitle) {
        this.oldTitle = oldTitle;
    }

    /**
     * ��ȡ����
     *
     * @return arctlcle_author - ����
     */
    public String getArctlcleAuthor() {
        return arctlcleAuthor;
    }

    /**
     * ��������
     *
     * @param arctlcleAuthor ����
     */
    public void setArctlcleAuthor(String arctlcleAuthor) {
        this.arctlcleAuthor = arctlcleAuthor;
    }

    /**
     * ��ȡ����ID
     *
     * @return author_id - ����ID
     */
    public String getAuthorId() {
        return authorId;
    }

    /**
     * ��������ID
     *
     * @param authorId ����ID
     */
    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    /**
     * ��ȡ����ͼ
     *
     * @return pic1 - ����ͼ
     */
    public String getPic1() {
        return pic1;
    }

    /**
     * ���÷���ͼ
     *
     * @param pic1 ����ͼ
     */
    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }

    /**
     * ��ȡ����ͼ����ͼ
     *
     * @return pic2 - ����ͼ����ͼ
     */
    public String getPic2() {
        return pic2;
    }

    /**
     * ���÷���ͼ����ͼ
     *
     * @param pic2 ����ͼ����ͼ
     */
    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    /**
     * ��ȡ����״̬ 0δ����  1�ѷ���4����վ
     *
     * @return arcticle_status - ����״̬ 0δ����  1�ѷ���4����վ
     */
    public Integer getArcticleStatus() {
        return arcticleStatus;
    }

    /**
     * ��������״̬ 0δ����  1�ѷ���4����վ
     *
     * @param arcticleStatus ����״̬ 0δ����  1�ѷ���4����վ
     */
    public void setArcticleStatus(Integer arcticleStatus) {
        this.arcticleStatus = arcticleStatus;
    }

    /**
     * ��ȡ��Դid ��������Ӧ��id
     *
     * @return source_id - ��Դid ��������Ӧ��id
     */
    public String getSourceId() {
        return sourceId;
    }

    /**
     * ������Դid ��������Ӧ��id
     *
     * @param sourceId ��Դid ��������Ӧ��id
     */
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    /**
     * ��ȡ�Ƿ�Ӿ�0��1��
     *
     * @return is_perfect - �Ƿ�Ӿ�0��1��
     */
    public Integer getIsPerfect() {
        return isPerfect;
    }

    /**
     * �����Ƿ�Ӿ�0��1��
     *
     * @param isPerfect �Ƿ�Ӿ�0��1��
     */
    public void setIsPerfect(Integer isPerfect) {
        this.isPerfect = isPerfect;
    }

    /**
     * ��ȡ0�ر�����  1��ͨ���� 
     *
     * @return comment_type - 0�ر�����  1��ͨ���� 
     */
    public Integer getCommentType() {
        return commentType;
    }

    /**
     * ����0�ر�����  1��ͨ���� 
     *
     * @param commentType 0�ر�����  1��ͨ���� 
     */
    public void setCommentType(Integer commentType) {
        this.commentType = commentType;
    }

    /**
     * ��ȡ���Ϊnull�� ���û�е��飻���Ϊnull���������id
            
     *
     * @return survey_id - ���Ϊnull�� ���û�е��飻���Ϊnull���������id
            
     */
    public String getSurveyId() {
        return surveyId;
    }

    /**
     * �������Ϊnull�� ���û�е��飻���Ϊnull���������id
            
     *
     * @param surveyId ���Ϊnull�� ���û�е��飻���Ϊnull���������id
            
     */
    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    /**
     * ��ȡ��̬ҳ���ַ
     *
     * @return html_url - ��̬ҳ���ַ
     */
    public String getHtmlUrl() {
        return htmlUrl;
    }

    /**
     * ���þ�̬ҳ���ַ
     *
     * @param htmlUrl ��̬ҳ���ַ
     */
    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    /**
     * ��ȡ0 �ı�1 ��pdf
     *
     * @return file - 0 �ı�1 ��pdf
     */
    public String getFile() {
        return file;
    }

    /**
     * ����0 �ı�1 ��pdf
     *
     * @param file 0 �ı�1 ��pdf
     */
    public void setFile(String file) {
        this.file = file;
    }

    /**
     * ��ȡ��������
     *
     * @return author_name - ��������
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * ������������
     *
     * @param authorName ��������
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    /**
     * ��ȡ������Դ
     *
     * @return content_source - ������Դ
     */
    public String getContentSource() {
        return contentSource;
    }

    /**
     * ����������Դ
     *
     * @param contentSource ������Դ
     */
    public void setContentSource(String contentSource) {
        this.contentSource = contentSource;
    }

    /**
     * @return free4
     */
    public String getFree4() {
        return free4;
    }

    /**
     * @param free4
     */
    public void setFree4(String free4) {
        this.free4 = free4;
    }

    /**
     * @return free5
     */
    public String getFree5() {
        return free5;
    }

    /**
     * @param free5
     */
    public void setFree5(String free5) {
        this.free5 = free5;
    }

    /**
     * ��ȡ�Ƿ��ڹ�����ʾ 0��  1��
     *
     * @return free6 - �Ƿ��ڹ�����ʾ 0��  1��
     */
    public String getFree6() {
        return free6;
    }

    /**
     * �����Ƿ��ڹ�����ʾ 0��  1��
     *
     * @param free6 �Ƿ��ڹ�����ʾ 0��  1��
     */
    public void setFree6(String free6) {
        this.free6 = free6;
    }

    /**
     * ��ȡ��������
     *
     * @return arcticle_content - ��������
     */
    public String getArcticleContent() {
        return arcticleContent;
    }

    /**
     * ������������
     *
     * @param arcticleContent ��������
     */
    public void setArcticleContent(String arcticleContent) {
        this.arcticleContent = arcticleContent;
    }
    
    @Transient
    private String artColId;

	public String getArtColId() {
		return artColId;
	}

	public void setArtColId(String artColId) {
		this.artColId = artColId;
	}
	
	@Transient
	private List<Object> dataList;

	public List<Object> getDataList() {
		return dataList;
	}

	public void setDataList(List<Object> dataList) {
		this.dataList = dataList;
	}
	
	
    
}