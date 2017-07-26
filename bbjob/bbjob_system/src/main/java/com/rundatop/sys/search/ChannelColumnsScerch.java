package com.rundatop.sys.search;

import com.rundatop.sys.model.ChannelColumns;

public class ChannelColumnsScerch extends ChannelColumns{
   
	public Integer page=1; //页数
	public Integer size=10; //每页数量
	
	public String channelName; //频道名称
	
	public String channelCode; //频道编码/
	
	public String channelNo;   //频道编号
	
	public String channelremark;    //频道备注
	
	public Integer articleCount; //文章统计count
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public String getChannelCode() {
		return channelCode;
	}
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}
	public String getChannelNo() {
		return channelNo;
	}
	public void setChannelNo(String channelNo) {
		this.channelNo = channelNo;
	}
	public String getChannelremark() {
		return channelremark;
	}
	public void setChannelremark(String channelremark) {
		this.channelremark = channelremark;
	}
	public Integer getArticleCount() {
		return articleCount;
	}
	public void setArticleCount(Integer articleCount) {
		this.articleCount = articleCount;
	}
}



