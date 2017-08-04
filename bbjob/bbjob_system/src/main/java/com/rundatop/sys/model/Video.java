package com.rundatop.sys.model;

import javax.persistence.*;

public class Video {
    /**
     * ����;����
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Դ�ļ���ַ
     */
    @Column(name = "root_url")
    private String rootUrl;

    /**
     * ���ŵ�ַ
     */
    private String url;

    /**
     * ����:hh:mm:ss
     */
    private String time;

    @Column(name = "file_name")
    private String fileName;

    private String suffix;

    /**
     * ��ĿID
     */
    @Column(name = "column_id")
    private String columnId;

    @Column(name = "video_id")
    private Integer videoId;

    @Column(name = "video_unique")
    private String videoUnique;

    @Column(name = "upload_url")
    private String uploadUrl;

    @Column(name = "progress_url")
    private String progressUrl;

    private String token;

    @Transient
    private Integer index;

    /**
     * ��ȡ����;����
     *
     * @return id - ����;����
     */
    public Integer getId() {
        return id;
    }

    /**
     * ��������;����
     *
     * @param id ����;����
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * ��ȡԴ�ļ���ַ
     *
     * @return root_url - Դ�ļ���ַ
     */
    public String getRootUrl() {
        return rootUrl;
    }

    /**
     * ����Դ�ļ���ַ
     *
     * @param rootUrl Դ�ļ���ַ
     */
    public void setRootUrl(String rootUrl) {
        this.rootUrl = rootUrl;
    }

    /**
     * ��ȡ���ŵ�ַ
     *
     * @return url - ���ŵ�ַ
     */
    public String getUrl() {
        return url;
    }

    /**
     * ���ò��ŵ�ַ
     *
     * @param url ���ŵ�ַ
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * ��ȡ����:hh:mm:ss
     *
     * @return time - ����:hh:mm:ss
     */
    public String getTime() {
        return time;
    }

    /**
     * ���ó���:hh:mm:ss
     *
     * @param time ����:hh:mm:ss
     */
    public void setTime(String time) {
        this.time = time;
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
     * @return suffix
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * @param suffix
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
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
     * @return video_id
     */
    public Integer getVideoId() {
        return videoId;
    }

    /**
     * @param videoId
     */
    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    /**
     * @return video_unique
     */
    public String getVideoUnique() {
        return videoUnique;
    }

    /**
     * @param videoUnique
     */
    public void setVideoUnique(String videoUnique) {
        this.videoUnique = videoUnique;
    }

    /**
     * @return upload_url
     */
    public String getUploadUrl() {
        return uploadUrl;
    }

    /**
     * @param uploadUrl
     */
    public void setUploadUrl(String uploadUrl) {
        this.uploadUrl = uploadUrl;
    }

    /**
     * @return progress_url
     */
    public String getProgressUrl() {
        return progressUrl;
    }

    /**
     * @param progressUrl
     */
    public void setProgressUrl(String progressUrl) {
        this.progressUrl = progressUrl;
    }

    /**
     * @return token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return index
     */
    public Integer getIndex() {
        return index;
    }

    /**
     * @param index
     */
    public void setIndex(Integer index) {
        this.index = index;
    }
    
    @Transient
    private String player;

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}
	
	@Transient
	private String uu;

	public String getUu() {
		return uu;
	}

	public void setUu(String uu) {
		this.uu = uu;
	}
}