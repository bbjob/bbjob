package com.rundatop.biz.proManage.controller;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.rundatop.biz.proManage.service.ProManageService;
import com.rundatop.security.base.controller.SecurityController;
import com.rundatop.sys.dto.SysUser;
import com.rundatop.sys.example.MemberGroupExample;
import com.rundatop.sys.model.ArticleInfo;
import com.rundatop.sys.model.ChannelColumns;
import com.rundatop.sys.model.ChannelColumnsMember;
import com.rundatop.sys.model.MemberGroup;
import com.rundatop.sys.model.ModelAttribute;
import com.rundatop.sys.model.User;
import com.rundatop.sys.search.ArticleInfoSearch;
import com.rundatop.sys.search.ChannelColumnsScerch;


/**
 * 待替换的专题
 * 
 * @author Administrator
 *
 */

@RestController
@RequestMapping("manage/proManage")
public class ProManageController extends SecurityController {

	@Resource
	private ProManageService service;
	
	/****
	 * 分页
	 * 
	 * ****/
	@RequestMapping(value = "/page",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public PageInfo<ChannelColumns> page(ChannelColumnsScerch info) {
		List<ChannelColumns> list = service.getpageList(info, null);
		return new PageInfo<ChannelColumns>(list);
	}
	
	/**
	 * 获取频道ID
	 */
	@RequestMapping(value = "/getChannelId",method = RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
	public String getChannelId(String flagBit) {
		
		return service.getChannelId(flagBit);
	}

	/**
	 * 获取会员组信息
	 */
	@RequestMapping(value = "/getMemberGroupList", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MemberGroup> getMemberGroupList(MemberGroupExample info) {
		
		List<MemberGroup> list = service.getMemberGroupList(info);
		
		return list;
	}
	
	/****
	 * 新增专题
	 * 
	 * ****/
	@RequestMapping(value="/add",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public Integer add(@RequestBody ChannelColumns info){
		int ok=0;
		try {
			SysUser user = (SysUser) getCurrentUser();
			ok = service.add(info,user);
		} catch (Exception e) {
			
		}
		return ok;
	}

	/**
	 * 获取专题已选中的会员组信息
	 */
	@RequestMapping(value = "/getSelectMemberGroupList", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ChannelColumnsMember> getSelectMemberGroupList(ChannelColumnsMember info) {
		
		List<ChannelColumnsMember> list = service.getSelectMemberGroupList(info);
		
		return list;
	}
	
	/**
	 * 获取当前节点的上一级父节点ID
	 */
	@RequestMapping(value = "/getPrevParentId", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public String getPrevParentId(String parentId) {
		
		return service.getPrevParentId(parentId);
	}
	
	/****
	 * 批量删除
	 * 
	 * ****/
	@RequestMapping(value="/delproManage",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public Integer delSubjects(String ids){
		int ok=0;
		try {
			SysUser user = (SysUser) getCurrentUser();
			ok = service.del(ids,user);
		} catch (Exception e) {
		}
		return ok;
	}
	
	/****
	 * 更新专题信息
	 * 
	 * ****/
	@RequestMapping(value="/update",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public Integer update(@RequestBody ChannelColumns info){
		int ok=0;
		try {
			SysUser user = (SysUser) getCurrentUser();
			ok = service.update(info,user);
		} catch (Exception e) {
		
		}
		
		return ok;
	}
	
	/**
	 * 获取栏目对应模板的配置信息
	 */
	@RequestMapping(value = "/getModelAttributeByClumnId", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<ModelAttribute> getModelAttributeByClumnId(String ClumnId) {
		
		return service.getModelAttributeByClumnId(ClumnId);
	}
	
	/****
	 * 查询当前栏目下的文章 分页
	 * 
	 * ****/
	@RequestMapping(value="/getArtByColPage",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public PageInfo<ArticleInfo> getArtByColPage(ArticleInfoSearch info){
		List<ArticleInfo> list = service.getArtByColPage(info);
		return new PageInfo(list);
	}
	
	/**
	 * 查询未关联栏目的文章 分页
	 * @param page
	 * @param size
	 * @param columnId
	 * @param channelId
	 * @param articleTitle
	 * @param colId
	 * @return
	 */
	@RequestMapping(value="/selNotinColArticle",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> selNotinColArticle(Integer page,Integer size,String columnId,String channelId,String articleTitle,String colId){
		Map<String, Object> list = service.selNotinColArticle(null==page?1:page,null==size?10:size,columnId,channelId,articleTitle,colId);
		return list;
	}
	
	/****
	 * 批量关联
	 * 
	 * ****/
	@RequestMapping(value="/addColArticles",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public Integer addsubjectarticle(String colId,String ids){
		int ok=0;
		try {
			SysUser user=(SysUser) getCurrentUser();
			ok = service.addColArticles(colId, ids, user);
		} catch (Exception e) {
		}
		return ok;
	}
	
	/****
	 * 删除
	 * 
	 * ****/
	@RequestMapping(value="/delColArticle",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public Integer delColArticle(String ids){
		int ok=0;
		try {
			SysUser user=(SysUser) getCurrentUser();
			ok = service.delColArticle(ids,user);
		} catch (Exception e) {
		}
		return ok;
	}
	
}
