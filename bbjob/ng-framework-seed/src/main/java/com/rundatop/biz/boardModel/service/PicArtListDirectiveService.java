package com.rundatop.biz.boardModel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rundatop.sys.example.ChannelColumnsExample;
import com.rundatop.sys.example.ModelAttributeExample;
import com.rundatop.sys.example.ModelAttributeExample.Criteria;
import com.rundatop.sys.mapper.ArticleInfoMapper;
import com.rundatop.sys.mapper.ChannelColumnsMapper;
import com.rundatop.sys.mapper.ModelAttributeMapper;
import com.rundatop.sys.model.ArticleInfo;
import com.rundatop.sys.model.ChannelColumns;
import com.rundatop.sys.model.ModelAttribute;


/**
 * 模板相关服务 
 * @author Administrator
 *
 */

@Service
public class PicArtListDirectiveService {
	
	@Autowired
	private ModelAttributeMapper modelAttributeMapper;
	
	@Autowired
	private ArticleInfoMapper articleInfoMapper;
	
	@Autowired
	private ChannelColumnsMapper channelColumnsMapper;
	
	public ModelAttribute getModelAttributebyClumnId(String clumnId) {
		ModelAttributeExample example = new ModelAttributeExample();
		Criteria c = example.createCriteria();
		c.andClumnIdEqualTo(clumnId);
		
		List<ModelAttribute> modelAttributeList = modelAttributeMapper.selectByExample(example);
		
		if (modelAttributeList.size() > 0) {
			return modelAttributeList.get(0);
		} else {
			return null;
		}
	}

	public List<ArticleInfo> getArticleInfoByGenerateParam(
			ModelAttribute modelAttribute) {
		
		
		List<ArticleInfo> modelAttributeList = articleInfoMapper.selectByGenereateParams(modelAttribute);
		
		return modelAttributeList;
	}

	public List<ChannelColumns> getChildClumnArtInfoList(
			ModelAttribute modelAttribute) {
		
		ChannelColumnsExample example = new ChannelColumnsExample();
		example.createCriteria().andParentIdEqualTo(modelAttribute.getClumnId());
		
		List<ChannelColumns> colList = channelColumnsMapper.selectByExample(example);
		
		return colList;
	}
}
