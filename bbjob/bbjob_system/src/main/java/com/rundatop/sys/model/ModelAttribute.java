package com.rundatop.sys.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Transient;

public class ModelAttribute {
    private String id;

    private String clumnId;

    private String articleNumber;

    private String userId;

    private Date createTime;

    private String createName;

    private Date updateTime;

    private String updateName;

    private String f1;

    private String f2;

    private Integer f3;

    private String f4;

    private String remark;

    private Integer status;

    private String articleType;

    private Integer lineNumber;

    private Integer timeType;

    private String displayConent;

    private Integer sortType;

    private String titleLength;

    private String titleLineNumber;

    private Integer prefixType;

    private String prefixContent;

    private String prefixPic;

    private String abstractLength;

    private Integer abstractLineNumber;

    private String picHeight;

    private String picWide;

    private String articleAuthor;

    private Integer childrenClomns;

    private Integer original;

    private String model;

    private String rotationType;

    private String keyword;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClumnId() {
        return clumnId;
    }

    public void setClumnId(String clumnId) {
        this.clumnId = clumnId;
    }

    public String getArticleNumber() {
        return articleNumber;
    }

    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public String getF1() {
        return f1;
    }

    public void setF1(String f1) {
        this.f1 = f1;
    }

    public String getF2() {
        return f2;
    }

    public void setF2(String f2) {
        this.f2 = f2;
    }

    public Integer getF3() {
        return f3;
    }

    public void setF3(Integer f3) {
        this.f3 = f3;
    }

    public String getF4() {
        return f4;
    }

    public void setF4(String f4) {
        this.f4 = f4;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Integer getTimeType() {
        return timeType;
    }

    public void setTimeType(Integer timeType) {
        this.timeType = timeType;
    }

    public String getDisplayConent() {
        return displayConent;
    }

    public void setDisplayConent(String displayConent) {
        this.displayConent = displayConent;
    }

    public Integer getSortType() {
        return sortType;
    }

    public void setSortType(Integer sortType) {
        this.sortType = sortType;
    }

    public String getTitleLength() {
        return titleLength;
    }

    public void setTitleLength(String titleLength) {
        this.titleLength = titleLength;
    }

    public String getTitleLineNumber() {
        return titleLineNumber;
    }

    public void setTitleLineNumber(String titleLineNumber) {
        this.titleLineNumber = titleLineNumber;
    }

    public Integer getPrefixType() {
        return prefixType;
    }

    public void setPrefixType(Integer prefixType) {
        this.prefixType = prefixType;
    }

    public String getPrefixContent() {
        return prefixContent;
    }

    public void setPrefixContent(String prefixContent) {
        this.prefixContent = prefixContent;
    }

    public String getPrefixPic() {
        return prefixPic;
    }

    public void setPrefixPic(String prefixPic) {
        this.prefixPic = prefixPic;
    }

    public String getAbstractLength() {
        return abstractLength;
    }

    public void setAbstractLength(String abstractLength) {
        this.abstractLength = abstractLength;
    }

    public Integer getAbstractLineNumber() {
        return abstractLineNumber;
    }

    public void setAbstractLineNumber(Integer abstractLineNumber) {
        this.abstractLineNumber = abstractLineNumber;
    }

    public String getPicHeight() {
        return picHeight;
    }

    public void setPicHeight(String picHeight) {
        this.picHeight = picHeight;
    }

    public String getPicWide() {
        return picWide;
    }

    public void setPicWide(String picWide) {
        this.picWide = picWide;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public Integer getChildrenClomns() {
        return childrenClomns;
    }

    public void setChildrenClomns(Integer childrenClomns) {
        this.childrenClomns = childrenClomns;
    }

    public Integer getOriginal() {
        return original;
    }

    public void setOriginal(Integer original) {
        this.original = original;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRotationType() {
        return rotationType;
    }

    public void setRotationType(String rotationType) {
        this.rotationType = rotationType;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    
    @Transient
    private List<Integer> artTypeList;
    @Transient
    private List<Integer> contentList;

	public List<Integer> getArtTypeList() {
		return artTypeList;
	}

	public void setArtTypeList(List<Integer> artTypeList) {
		this.artTypeList = artTypeList;
	}

	public List<Integer> getContentList() {
		return contentList;
	}

	public void setContentList(List<Integer> contentList) {
		this.contentList = contentList;
	}
	
	@Transient
	private String className;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	@Transient
	private List<String> confAlphaList;

	public List<String> getConfAlphaList() {
		return confAlphaList;
	}

	public void setConfAlphaList(List<String> confAlphaList) {
		this.confAlphaList = confAlphaList;
	}
	
	@Transient
	private String flatBit;

	public String getFlatBit() {
		return flatBit;
	}

	public void setFlatBit(String flatBit) {
		this.flatBit = flatBit;
	}

}