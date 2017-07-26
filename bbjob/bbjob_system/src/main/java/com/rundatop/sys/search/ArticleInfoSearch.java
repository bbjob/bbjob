package com.rundatop.sys.search;

import com.rundatop.sys.model.ArticleInfo;

/****
 * 封装文章主表的查询类  如果需要参数在此定义(已继承ArticleInfo)
 * @author sven yu
 * @date 2016年8月27日15:36:16
 * 
 * ***/
public class ArticleInfoSearch extends ArticleInfo {
    
	public Integer page=1; //页数
	public Integer size=10; //每页数量
	public String ids; //发布时用
	public String colId; // 栏目下查询文章时用
	
	
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
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
	public String getColId() {
		return colId;
	}
	public void setColId(String colId) {
		this.colId = colId;
	}
	
	
}