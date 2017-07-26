package com.rundatop.sys.model;

import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

public class ChannelColumns {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String channelId;

    private String columnsName;

    private String parentId;

    private Integer columnsOrder;

    private Integer lvl;

    private Integer clientType;

    private Date createTime;

    private String createrId;

    private Integer status;

    private String remarks;

    private String free1;

    private String free2;

    private String free3;
    @Transient
    private boolean flag=false;

    @Transient
    private List<ChannelColumns> childs; //子类存储

    public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public List<ChannelColumns> getChilds() {
		return childs;
	}

	public void setChilds(List<ChannelColumns> childs) {
		this.childs = childs;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getColumnsName() {
        return columnsName;
    }

    public void setColumnsName(String columnsName) {
        this.columnsName = columnsName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getColumnsOrder() {
        return columnsOrder;
    }

    public void setColumnsOrder(Integer columnsOrder) {
        this.columnsOrder = columnsOrder;
    }

    public Integer getLvl() {
        return lvl;
    }

    public void setLvl(Integer lvl) {
        this.lvl = lvl;
    }

    public Integer getClientType() {
        return clientType;
    }

    public void setClientType(Integer clientType) {
        this.clientType = clientType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getFree1() {
        return free1;
    }

    public void setFree1(String free1) {
        this.free1 = free1;
    }

    public String getFree2() {
        return free2;
    }

    public void setFree2(String free2) {
        this.free2 = free2;
    }

    public String getFree3() {
        return free3;
    }

    public void setFree3(String free3) {
        this.free3 = free3;
    }
    
    // 增加字段
    private Integer isShow;
    private Integer columnType;
    private String externalLinks;
    private String folder;
    private String tempTag;
    private String columnFile;



	public Integer getIsShow() {
		return isShow;
	}

	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}

	public Integer getColumnType() {
		return columnType;
	}

	public void setColumnType(Integer columnType) {
		this.columnType = columnType;
	}

	public String getExternalLinks() {
		return externalLinks;
	}

	public void setExternalLinks(String externalLinks) {
		this.externalLinks = externalLinks;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public String getTempTag() {
		return tempTag;
	}

	public void setTempTag(String tempTag) {
		this.tempTag = tempTag;
	}

	public String getColumnFile() {
		return columnFile;
	}

	public void setColumnFile(String columnFile) {
		this.columnFile = columnFile;
	}
    
	@Transient
	private String artCount;

	public String getArtCount() {
		return artCount;
	}

	public void setArtCount(String long1) {
		this.artCount = long1;
	}
	@Transient
	private Integer flagBit;

	public Integer getFlagBit() {
		return flagBit;
	}

	public void setFlagBit(Integer flagBit) {
		this.flagBit = flagBit;
	}
	@Transient
	private String isShowStr;
	@Transient
	private String columnTypeStr;
	@Transient
	private String statusStr;

	public String getIsShowStr() {
		return isShowStr;
	}

	public void setIsShowStr(String isShowStr) {
		this.isShowStr = isShowStr;
	}

	public String getColumnTypeStr() {
		return columnTypeStr;
	}

	public void setColumnTypeStr(String columnTypeStr) {
		this.columnTypeStr = columnTypeStr;
	}

	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}
	
	@Transient
	private List<String> memberGroup;

	public List<String> getMemberGroup() {
		return memberGroup;
	}

	public void setMemberGroup(List<String> memberGroup) {
		this.memberGroup = memberGroup;
	}
	
	@Transient
	private ModelAttribute modelAttribute;

	public ModelAttribute getModelAttribute() {
		return modelAttribute;
	}

	public void setModelAttribute(ModelAttribute modelAttribute) {
		this.modelAttribute = modelAttribute;
	}
	@Transient
	private String updater;

	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}
	
	
}