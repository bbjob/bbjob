package com.rundatop.biz.editerarticle.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.github.pagehelper.PageHelper;
import com.rundatop.biz.editerarticle.service.EditerArticleService;
import com.rundatop.sys.dto.SysUser;
import com.rundatop.sys.example.ArticleInfoExample;
import com.rundatop.sys.example.ArticleInfoExample.Criteria;
import com.rundatop.sys.mapper.ArticleInfoMapper;
import com.rundatop.sys.model.ArticleInfo;
import com.rundatop.sys.search.ArticleInfoSearch;

@Service
public class EditerArticleServiceImpl implements EditerArticleService {
	
	@Autowired
	private ArticleInfoMapper articleInfoMapper;

	@Override
	public List<ArticleInfo> getlistByExample(ArticleInfoSearch searchinfo) {

		ArticleInfoExample example=new ArticleInfoExample();
		Criteria c=example.createCriteria();
		//编号模糊
		if(searchinfo.getId()!=null&&!"".equals(searchinfo.getId())){
			c.andIdLike("%"+searchinfo.getId()+"%");
		}
		//状态
		if(searchinfo.getArcticleStatus()!=null){
			c.andArcticleStatusEqualTo(searchinfo.getArcticleStatus());
		}
		//标题模糊查询
		if(searchinfo.getArticleTitle()!=null&&!"".equals(searchinfo.getArticleTitle())){
			c.andArticleTitleLike("%"+searchinfo.getArticleTitle()+"%");
		}
		//原创
		if(searchinfo.getIsOriginal()!=null){
			c.andIsOriginalEqualTo(searchinfo.getIsOriginal());
		}
		//文章类型
		if(searchinfo.getArticleType()!=null){
			c.andArticleTypeEqualTo(searchinfo.getArticleType());
		}
		//摘要
		if(searchinfo.getArcticleSummary()!=null&&!"".equals(searchinfo.getArcticleSummary())){
			c.andArcticleSummaryLike("%"+searchinfo.getArcticleSummary()+"%");
		}
		//文章来源
		if(searchinfo.getArticleSource()!=null){
			c.andArticleSourceEqualTo(searchinfo.getArticleSource());
		}
		//关键字
		if(searchinfo.getKeyWordd()!=null&&!"".equals(searchinfo.getKeyWordd())){
			c.andKeyWorddLike("%"+searchinfo.getKeyWordd()+"%");
		}
		//标题2
		if(searchinfo.getArticleTitle2()!=null&&!"".equals(searchinfo.getArticleTitle2())){
			c.andArticleTitle2Like("%"+searchinfo.getArticleTitle2()+"%");
		}
		//完整标题
		if(searchinfo.getTitleAll()!=null&&!"".equals(searchinfo.getTitleAll())){
			c.andTitleAllLike("%"+searchinfo.getTitleAll()+"%");
		}
		//副标题
		if(searchinfo.getSubTitle()!=null&&!"".equals(searchinfo.getSubTitle())){
			c.andSubTitleLike("%"+searchinfo.getSubTitle()+"%");
		}
		//原标题
		if(searchinfo.getOldTitle()!=null&&!"".equals(searchinfo.getOldTitle())){
			c.andOldTitleLike("%"+searchinfo.getOldTitle()+"%");
		}
		//作者
		if(searchinfo.getAuthorId()!=null&&!"".equals(searchinfo.getAuthorId())){
			c.andAuthorIdEqualTo(searchinfo.getAuthorId());
		}
		//置顶
		if(searchinfo.getIsTop()!=null){
			c.andIsTopEqualTo(searchinfo.getIsTop());
		}
		example.setOrderByClause(" create_time desc ");
	
		return articleInfoMapper.selectByExample(example);
	}

	@Override
	public List<ArticleInfo> getpageList(ArticleInfoSearch searchinfo) throws UnsupportedEncodingException {
		ArticleInfoExample example=new ArticleInfoExample();
		Criteria c=example.createCriteria();
		//编号模糊
		if(searchinfo.getId()!=null&&!"".equals(searchinfo.getId())){
			c.andIdLike("%"+searchinfo.getId()+"%");
		}
		//状态
		if(searchinfo.getArcticleStatus()!=null){
			c.andArcticleStatusEqualTo(searchinfo.getArcticleStatus());
		}
		//标题模糊查询
		if(searchinfo.getArticleTitle()!=null&&!"".equals(searchinfo.getArticleTitle())){
			c.andArticleTitleLike("%"+searchinfo.getArticleTitle()+"%");
		}
		//原创
		if(searchinfo.getIsOriginal()!=null){
			c.andIsOriginalEqualTo(searchinfo.getIsOriginal());
		}
		//文章类型
		if(searchinfo.getArticleType()!=null){
			c.andArticleTypeEqualTo(searchinfo.getArticleType());
		}
		//摘要
		if(searchinfo.getArcticleSummary()!=null&&!"".equals(searchinfo.getArcticleSummary())){
			c.andArcticleSummaryLike("%"+searchinfo.getArcticleSummary()+"%");
		}
		//文章来源
		if(searchinfo.getArticleSource()!=null){
			c.andArticleSourceEqualTo(searchinfo.getArticleSource());
		}
		//关键字
		if(searchinfo.getKeyWordd()!=null&&!"".equals(searchinfo.getKeyWordd())){
			c.andKeyWorddLike("%"+searchinfo.getKeyWordd()+"%");
		}
		//标题2
		if(searchinfo.getArticleTitle2()!=null&&!"".equals(searchinfo.getArticleTitle2())){
			c.andArticleTitle2Like("%"+searchinfo.getArticleTitle2()+"%");
		}
		//完整标题
		if(searchinfo.getTitleAll()!=null&&!"".equals(searchinfo.getTitleAll())){
			c.andTitleAllLike("%"+searchinfo.getTitleAll()+"%");
		}
		//副标题
		if(searchinfo.getSubTitle()!=null&&!"".equals(searchinfo.getSubTitle())){
			c.andSubTitleLike("%"+searchinfo.getSubTitle()+"%");
		}
		//原标题
		if(searchinfo.getOldTitle()!=null&&!"".equals(searchinfo.getOldTitle())){
			c.andOldTitleLike("%"+searchinfo.getOldTitle()+"%");
		}
		//作者
		if(searchinfo.getArctlcleAuthor()!=null&&!"".equals(searchinfo.getArctlcleAuthor())){
			c.andArctlcleAuthorLike("%"+searchinfo.getArctlcleAuthor()+"%");
		}
		if(searchinfo.getAuthorId()!=null&&!"".equals(searchinfo.getAuthorId())){
			c.andAuthorIdEqualTo(searchinfo.getAuthorId());
		}
		if (searchinfo.getAuthorName() != null && !"".equals(searchinfo.getAuthorName())) {
			c.andAuthorNameLike("%" + searchinfo.getAuthorName() + "%");
		}
		
		//置顶
		if(searchinfo.getIsTop()!=null){
			c.andIsTopEqualTo(searchinfo.getIsTop());
		}
		example.setOrderByClause(" create_time desc ");		
		
		PageHelper.startPage(searchinfo.getPage(), searchinfo.getSize());
		List<ArticleInfo> list = articleInfoMapper.selectByExampleWithBLOBs(example);
		
		
		return list;
	}

	@Override
	public Integer add(ArticleInfo info, SysUser user) {
		// TODO Auto-generated method stub
		
		info.setId(getUUID());
		return articleInfoMapper.insert(info);
	}

	private String getUUID() {
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replaceAll("-", "");
		return uuid.toUpperCase();
	}

	@Override
	public int update(ArticleInfo info, SysUser user) {
		
		return articleInfoMapper.updateByPrimaryKey(info);
	}

	@Override
	public ArticleInfo info(Integer id) {
		
		return articleInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public Integer del(String ids, SysUser user) {
		
		String[] idsary=ids.split(",");
		
		Example example = new Example(ArticleInfo.class);
		
		example.createCriteria().andIn("id", new ArrayList<String>(Arrays.asList(idsary)));
		
		return articleInfoMapper.deleteByExample(example);
	}

}
