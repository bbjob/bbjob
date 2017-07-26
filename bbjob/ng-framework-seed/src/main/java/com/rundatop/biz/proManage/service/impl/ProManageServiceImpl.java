package com.rundatop.biz.proManage.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.rundatop.biz.proManage.service.ProManageService;
import com.rundatop.sys.dto.SysUser;
import com.rundatop.sys.example.ArticleColumnExample;
import com.rundatop.sys.example.ArticleInfoExample;
import com.rundatop.sys.example.ChannelColumnsExample;
import com.rundatop.sys.example.ChannelColumnsMemberExample;
import com.rundatop.sys.example.MemberGroupExample;
import com.rundatop.sys.example.ModelAttributeExample;
import com.rundatop.sys.mapper.ArticleColumnMapper;
import com.rundatop.sys.mapper.ArticleInfoMapper;
import com.rundatop.sys.mapper.ChannelColumnsMapper;
import com.rundatop.sys.mapper.ChannelColumnsMemberMapper;
import com.rundatop.sys.mapper.ChannelMapper;
import com.rundatop.sys.mapper.MemberGroupMapper;
import com.rundatop.sys.mapper.ModelAttributeMapper;
import com.rundatop.sys.model.ArticleColumn;
import com.rundatop.sys.model.ArticleInfo;
import com.rundatop.sys.model.ChannelColumns;
import com.rundatop.sys.model.ChannelColumnsMember;
import com.rundatop.sys.model.MemberGroup;
import com.rundatop.sys.model.ModelAttribute;
import com.rundatop.sys.model.User;
import com.rundatop.sys.search.ArticleInfoSearch;
import com.rundatop.sys.search.ChannelColumnsScerch;
import com.rundatop.sys.example.ChannelColumnsExample.Criteria;

@Service
public class ProManageServiceImpl implements ProManageService{

	@Autowired
	private ChannelColumnsMapper mapper;
	
	@Autowired
	private ChannelMapper channelMapper;
	
	@Autowired
	private MemberGroupMapper memberGroupMapper;
	
	@Autowired
	private ChannelColumnsMemberMapper channelColumnsMemberMapper;
	
	@Autowired
	private ModelAttributeMapper modelAttributeMapper;
	
	@Autowired
	private ArticleColumnMapper articleColumnMapper;
	
	@Autowired
	private ArticleInfoMapper articleInfoMapper;
	
	@Override
	public List<ChannelColumns> getpageList(ChannelColumnsScerch info,
			User user) {
		
		List<ChannelColumns> list = getListByExampleRefChannel(info);
		
		List<Map<String, Object>> artCol = getArtRefColList();
		
		Map<String, String> dealData = dealArtColList(artCol);

		for (int i = 0; i < list.size(); i++) {
			String id = list.get(i).getId();
			if (dealData.get(id) == null) {
				list.get(i).setArtCount("0");
			} else {
				list.get(i).setArtCount(dealData.get(id));
			}
		}
		
		PageHelper.startPage(info.getPage(), info.getSize());

		return list;
	}

	/**
	 * 处理查询出的数据，将列转换为行
	 * 
	 * @param artCol
	 * @return
	 */
	private Map<String, String> dealArtColList(List<Map<String, Object>> artCol) {

		Map<String, String> returnMap = new HashMap<String, String>();

		for (int i = 0; i < artCol.size(); i++) {
			returnMap.put(artCol.get(i).get("columnId").toString(),
					artCol.get(i).get("colArtSum").toString());
		}

		return returnMap;
	}

	private List<Map<String, Object>> getArtRefColList() {
		
		return articleColumnMapper.getArtRefColList();
	}

	private List<ChannelColumns> getListByExampleRefChannel(
			ChannelColumnsScerch info) {
		
		ChannelColumnsExample example = new ChannelColumnsExample();
		Criteria c = example.createCriteria();
		
		if (info.getFlagBit() != null) {
			c.andFlagBitRefEqualTo(info.getFlagBit());
		}
		
		if (!"".equals(info.getParentId())) {
			if (info.getParentId() == null) {
				c.andParentIdRefIsNull();
			} else {
				c.andParentIdRefEqualTo(info.getParentId());
			}
		} else {
			c.andParentIdRefIsNull();
		}
		
		// 栏目名称
		if (info.getColumnsName() != null && !"".equals(info.getColumnsName())) {
			c.andColumnsNameRefLike("%" + info.getColumnsName() + "%");
		}
		// 栏目ID
		if (info.getId() != null) {
			c.andIdRefLike("%" + info.getId() + "%");
		}
		// 是否显示
		if (info.getIsShow() != null && !"".equals(info.getIsShow())) {
			c.andIsShowEqualTo(info.getIsShow());
		}
		// 备注
		if (info.getRemarks() != null && !"".equals(info.getRemarks())) {
			c.andRemarksRefLike("%" + info.getRemarks() + "%");
		}
		// 类型
		if (info.getColumnType() != null) {
			c.andColumnTypeEqualTo(info.getColumnType());
		}
		// 状态
		if (info.getStatus() != null) {
			c.andStatusRefEqualTo(info.getStatus());
		}

		example.setOrderByClause(" create_time desc ");
		
		
		return mapper.selectByExampleRefChannel(example);
	}

	@Override
	public String getChannelId(String flagBit) {
		return channelMapper.selectColumnChannelID(flagBit);
	}

	@Override
	public List<MemberGroup> getMemberGroupList(MemberGroupExample info) {
		return memberGroupMapper.selectByExample(info);
	}

	@Override
	public int add(ChannelColumns info, SysUser user) {
		info.setId(getUUID());
		info.setCreateTime(new Date());
		info.setCreaterId(user.getUserId().toString());
		
		List<String> memberGroup = info.getMemberGroup();
		ChannelColumnsMember member = null;
		
		for (String str : memberGroup) {
			member = new ChannelColumnsMember();
			member.setId(getUUID());
			member.setChannelColumnsId(info.getId());
			member.setMemberGroupId(str);
			member.setCreateTime(new Date());
			member.setCreaterId(info.getCreaterId());
			channelColumnsMemberMapper.insert(member);
		}
		
		ModelAttribute modelAttribute = info.getModelAttribute();
		String artTypes = listToString(modelAttribute.getArtTypeList());
		String contents = listToString(modelAttribute.getContentList());
		modelAttribute.setArticleType(artTypes);
		modelAttribute.setDisplayConent(contents);
		modelAttribute.setClumnId(info.getId());
		modelAttribute.setId(getUUID());
		modelAttribute.setCreateName(info.getCreaterId());
		modelAttribute.setCreateTime(info.getCreateTime());
		modelAttributeMapper.insert(modelAttribute);
		
		return mapper.insert(info);
	}

	private String listToString(List<Integer> artTypeList) {
		String str = "";
		
		if (artTypeList == null) {
			return null;
		} else {
			for (int i = 0;i < artTypeList.size();i++) {
				str = str + artTypeList.get(i);
				if (i == artTypeList.size() - 1) {
					
				} else {
					str = str + ",";
				} 
			}
		}
		
		return str;
	}

	private String getUUID() {
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replaceAll("-", "");
		return uuid.toUpperCase();
	}

	@Override
	public List<ChannelColumnsMember> getSelectMemberGroupList(
			ChannelColumnsMember info) {
		ChannelColumnsMemberExample example = new ChannelColumnsMemberExample();
		
		example.createCriteria().andChannelColumnsIdEqualTo(info.getChannelColumnsId());
		
		return channelColumnsMemberMapper.selectByExample(example);
	}

	@Override
	public String getPrevParentId(String parentId) {
		
		return mapper.selectPrevParentId(parentId);
	}

	@Override
	public int del(String ids, SysUser user) {
		if(null == ids || "".equals(ids)) {
			
			return 0;
		}
		List<String> idlist = Arrays.asList(ids.split(","));
		ChannelColumnsExample example = new ChannelColumnsExample();
		Criteria c = example.createCriteria();
		c.andIdIn(idlist);
		
		return mapper.deleteByExample(example);
	}

	@Override
	public int update(ChannelColumns info, SysUser user) {
		if(null == info || null == info.getId()){
			
			return 0;
		}
		info.setUpdater(user.getUserId().toString());
		ChannelColumnsMemberExample example = new ChannelColumnsMemberExample();
		
		example.createCriteria().andChannelColumnsIdEqualTo(info.getId());
		
		List<String> memberGroup = info.getMemberGroup();
		ChannelColumnsMember member = null;
		
		if (memberGroup == null) {
			
		} else {
			channelColumnsMemberMapper.deleteByExample(example);
			for (String str : memberGroup) {
				member = new ChannelColumnsMember();
				member.setId(getUUID());
				member.setChannelColumnsId(info.getId());
				member.setMemberGroupId(str);
				member.setCreateTime(new Date());
				member.setCreaterId(info.getCreaterId());
				channelColumnsMemberMapper.insert(member);
			}
		}
		
		ModelAttribute modelAttribute = info.getModelAttribute();
		if (modelAttribute == null) {
			modelAttribute = new ModelAttribute();
		}
		String artTypes = listToString(modelAttribute.getArtTypeList());
		String contents = listToString(modelAttribute.getContentList());
		modelAttribute.setArticleType(artTypes);
		modelAttribute.setDisplayConent(contents);
		
		if (modelAttribute.getClumnId() == null || "".equals(modelAttribute.getClumnId())) {
			ModelAttributeExample mExample = new ModelAttributeExample();
			com.rundatop.sys.example.ModelAttributeExample.Criteria cm = mExample.createCriteria();
			cm.andClumnIdEqualTo(info.getId());
			
			List<ModelAttribute> maList = modelAttributeMapper.selectByExample(mExample);
			if (maList.size() > 0) {
				
			} else {
				modelAttribute.setClumnId(info.getId());
				modelAttribute.setId(getUUID());
				modelAttribute.setCreateTime(new Date());
				modelAttribute.setCreateName(info.getUpdater());
				modelAttributeMapper.insert(modelAttribute);
			}
		} else {
			ModelAttributeExample mExample = new ModelAttributeExample();
			com.rundatop.sys.example.ModelAttributeExample.Criteria cm = mExample.createCriteria();
			cm.andClumnIdEqualTo(info.getId());
			modelAttribute.setUpdateTime(new Date());
			modelAttributeMapper.updateByExample(modelAttribute, mExample);
		}
		
		return mapper.updateByPrimaryKey(info);
	}

	@Override
	public List<ModelAttribute> getModelAttributeByClumnId(String clumnId) {
		List<ModelAttribute> list = new ArrayList<ModelAttribute>();
		
		
		ModelAttributeExample example = new ModelAttributeExample();
		com.rundatop.sys.example.ModelAttributeExample.Criteria c = example.createCriteria();
		c.andClumnIdEqualTo(clumnId);
		
		return modelAttributeMapper.selectByExample(example);
	}

	@Override
	public List<ArticleInfo> getArtByColPage(ArticleInfoSearch info) {
		List<ArticleInfo> list = getArtListByExample(info);
		
		PageHelper.startPage(info.getPage(), info.getSize());
		return list;
	}

	private List<ArticleInfo> getArtListByExample(ArticleInfoSearch info) {
		ArticleInfoExample example = new ArticleInfoExample();
		
		String colId = info.getColId();
		
		return articleInfoMapper.getArtListByExample(example, colId);
	}

	@Override
	public Map<String, Object> selNotinColArticle(int page, int size,
			String columnId, String channelId, String articleTitle, String colId) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		if (articleTitle != null) {
			try {
				articleTitle = new String(articleTitle.getBytes("ISO-8859-1"), "UTF-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		Integer begin = (page - 1) * size;
		// PageHelper.startPage(page, size);
		Integer containNum = articleInfoMapper.selInColArticleCount(null!=columnId?columnId:null, null!=channelId?channelId:null,null!=articleTitle?"%"+articleTitle+"%":null,colId, begin, size);

		Integer artNum = articleInfoMapper.artNumCount(null!=columnId?columnId:null, null!=channelId?channelId:null,null!=articleTitle?"%"+articleTitle+"%":null,colId, begin, size);
		
		List<ArticleInfo> list = articleInfoMapper.selNotinColArticle(null!=columnId?columnId:null, null!=channelId?channelId:null,null!=articleTitle?"%"+articleTitle+"%":null,colId, begin, size);
		// PageInfo<ArticleInfo> pi = new PageInfo<ArticleInfo>(list);
		// PageData<ArticleInfo> pd = new PageData<ArticleInfo>();
		// pd.setTotal(pi.getTotal());
		// pd.setRows(list);
		
		returnMap.put("total", artNum - containNum);
		returnMap.put("rows", list);
		
		return returnMap;
	}

	@Override
	public int addColArticles(String colId, String ids, SysUser user) {
		String[] idsary=ids.split(",");
		for(String articleId : idsary){
			ArticleColumn info=new ArticleColumn();
			info.setId(getUUID());
			info.setArticleId(articleId);
			info.setColumnId(colId);
			
			info.setCreateTime(new Date());
			info.setCreaterId(user.getUserId().toString());//创建人
			int ok = articleColumnMapper.insertSelective(info);
		}
		
		return 1;
	}

	@Override
	public int delColArticle(String ids, SysUser user) {
		String[] idsary=ids.split(",");
		ArticleColumnExample example = new ArticleColumnExample();
		example.createCriteria().andIdIn(Arrays.asList(idsary));
		int ok= articleColumnMapper.deleteByExample(example);
		
		return ok;
	}
	
}
