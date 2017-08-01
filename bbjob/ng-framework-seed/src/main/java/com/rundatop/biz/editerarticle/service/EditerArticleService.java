package com.rundatop.biz.editerarticle.service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import com.rundatop.sys.dto.SysUser;
import com.rundatop.sys.model.ArticleInfo;
import com.rundatop.sys.search.ArticleInfoSearch;

public interface EditerArticleService {

	List<ArticleInfo> getlistByExample(ArticleInfoSearch info);

	List<ArticleInfo> getpageList(ArticleInfoSearch info) throws UnsupportedEncodingException;

	Integer add(ArticleInfo info, SysUser user);

	int update(ArticleInfo info, SysUser user);

	ArticleInfo info(Integer integer);

	Integer del(String ids, SysUser user);
	
}
