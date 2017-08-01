package com.rundatop.biz.editerarticle.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.rundatop.biz.editerarticle.service.EditerArticleService;
import com.rundatop.security.base.controller.SecurityController;
import com.rundatop.sys.dto.SysUser;
import com.rundatop.sys.model.ArticleInfo;
import com.rundatop.sys.search.ArticleInfoSearch;

/**
 * 文章主表（编辑写稿/资讯编辑）
 * @author sven yu
 * @data 2016年8月27日17:16:44
 * 
 * **/

@RestController
@RequestMapping("manage/editerarticle")
public class EditerArticleController extends SecurityController {
	
	@Autowired
	private EditerArticleService service;
	
	/****
	 * 不分页
	 * ****/
	@RequestMapping(value="/list",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<ArticleInfo> getlist(ArticleInfoSearch info){
		List<ArticleInfo> list = service.getlistByExample(info);
		return list;
	}
	
	/****
	 * 分页
	 * @throws UnsupportedEncodingException 
	 * 
	 * ****/
	@RequestMapping(value="/page",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public PageInfo<ArticleInfo> page(ArticleInfoSearch info) throws UnsupportedEncodingException{
		List<ArticleInfo> list = service.getpageList(info);
		return new PageInfo<ArticleInfo>(list);
	}
	
	/****
	 * 详情 
	 * 
	 * ****/
	@RequestMapping(value="/info",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ArticleInfo info(String id){
		return service.info(Integer.valueOf(id));
	}
	
	/****
	 * 新增内容
	 * 
	 * ****/
	@RequestMapping(value="/add",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public Integer add(@RequestBody ArticleInfo info){
		Integer ok = 0;
		try {
			SysUser user = (SysUser) getCurrentUser();
			ok = service.add(info,user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok; 
	}

	/****
	 * 更新内容
	 * 
	 * ****/
	@RequestMapping(value="/update",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public Integer update(@RequestBody ArticleInfo info){
		Integer ok = 0;
		try {
			SysUser user = (SysUser) getCurrentUser();
			ok = service.update(info,user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}
	
	/**
	 * 删除内容
	 */
	@RequestMapping(value="/del",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public Integer del(String ids) {
		Integer ok = 0;
		try {
			SysUser user = (SysUser) getCurrentUser();
			ok = service.del(ids,user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}
	
}
