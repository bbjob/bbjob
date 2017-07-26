package com.rundatop.biz.boardModel.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rundatop.sys.model.ArticleInfo;
import com.rundatop.sys.model.ChannelColumns;
import com.rundatop.sys.model.ModelAttribute;

@Service
public class PicArtListService {
	
	@Autowired
	private PicArtListDirectiveService picArtListDirectiveService;
	
	public Map<String, Object> getAllData(ModelAttribute modelAttribute) {
		Map<String, Object> returnMap = new HashMap<String,Object>();
		
		String authorName = modelAttribute.getArticleAuthor();
		if ("".equals(authorName)) {
			modelAttribute.setArticleAuthor(null);
		}

		List<ArticleInfo> childClumnArtInfoList = new ArrayList<ArticleInfo>();
		
		if (modelAttribute.getChildrenClomns() != null) {
			if (modelAttribute.getChildrenClomns() == 1) {
				
				childClumnArtInfoList = getChildClumnArtInfoList(modelAttribute);
			}
		}
		
		System.out.println("picArtListDirectiveService:" + picArtListDirectiveService);
		
		List<ArticleInfo> artInfoList = picArtListDirectiveService.getArticleInfoByGenerateParam(modelAttribute);
		
		artInfoList.addAll(childClumnArtInfoList);
		
		List<ArticleInfo> returnList = new ArrayList<ArticleInfo>();
		
		SimpleDateFormat sdf = null;
		
		if (modelAttribute.getTimeType() != null) {
			int flag = modelAttribute.getTimeType();
			if (flag == 0) {
				sdf = new SimpleDateFormat("yyyy/MM/dd");
			} else if (flag == 1) {
				sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			}
		}
		
		if (modelAttribute.getArticleNumber() != null && !"".equals(modelAttribute.getArticleNumber())) {
			for (int i = 0;i < Integer.valueOf(modelAttribute.getArticleNumber()); i++) {
				if (artInfoList.size() < Integer.valueOf(modelAttribute.getArticleNumber())) {
					returnList = artInfoList;
				} else {
			
					returnList.add(artInfoList.get(i));
				}
			}
	
		} else {
			
			returnList = artInfoList;
		}
		
		String showTemplate = modelAttribute.getModel();
		String alpha = "";
		if (showTemplate == null || "".equals(showTemplate)) {
			
		} else {
			alpha = showTemplate.substring(3);
		}
		List<String> alphaList = new ArrayList<String>();
		
		for (int i = 0;i < alpha.length(); i++) {
			alphaList.add(String.valueOf(alpha.charAt(i)));
		}
		
		modelAttribute.setConfAlphaList(alphaList);
		
		// 固定格式  [标题, 摘要, 图片, 作者, 浏览量, 时间, 外部链接]
		List<Object> dataList = null;
		for (int i = 0;i < returnList.size();i++) {
			dataList = new ArrayList<Object>();
			
			ArticleInfo articleInfo = returnList.get(i);
			
			dataList.add(articleInfo.getArticleTitle());       // 标题     0
			dataList.add(articleInfo.getArcticleSummary());    // 摘要    1
			dataList.add(articleInfo.getPic1());               // 图片    2
			dataList.add(articleInfo.getAuthorName());     // 作者   3
			dataList.add(articleInfo.getScanCount());          // 浏览量  4
			
			if (sdf == null) {
				dataList.add(articleInfo.getEntryDate());          // 时间  5
			} else {
				if (articleInfo.getEntryDate() == null) {
					
					dataList.add("");
				} else {
					
					dataList.add(sdf.format(articleInfo.getEntryDate()));
				}
			}
			
			dataList.add(articleInfo.getFree2());              // 外链链接  6
			
			returnList.get(i).setDataList(dataList);
			
		}
		
		returnMap.put("conf", modelAttribute);
		returnMap.put("data", returnList);
		
		return returnMap;
	}
	
	private List<ArticleInfo> getChildClumnArtInfoList(
			ModelAttribute modelAttribute) {
		
		List<ChannelColumns> colList = picArtListDirectiveService.getChildClumnArtInfoList(modelAttribute);
		
		List<ArticleInfo> artList = new ArrayList<ArticleInfo>();
		
		for (ChannelColumns col : colList) {
			modelAttribute.setClumnId(col.getId());
			
			List<ArticleInfo> artInfoList = picArtListDirectiveService.getArticleInfoByGenerateParam(modelAttribute);
			
			artList.addAll(artInfoList);
		}
		
		
		return artList;
	}
}
