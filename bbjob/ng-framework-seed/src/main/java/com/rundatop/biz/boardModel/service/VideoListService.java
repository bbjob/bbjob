package com.rundatop.biz.boardModel.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.entity.Example;

import com.rundatop.core.spring.annotation.Config;
import com.rundatop.sys.mapper.VideoMapper;
import com.rundatop.sys.model.ModelAttribute;
import com.rundatop.sys.model.Video;


/**
 * 模板相关服务 
 * @author Administrator
 *
 */

@Service
public class VideoListService {

	@Config("letv.userUnique")
	private String userUnique;
	
	@Autowired
	private VideoMapper videoMapper;
	
	
	public Map<String, Object> getAllData(ModelAttribute modelAttribute) {
		Example example = new Example(Video.class);
		
		example.createCriteria().andEqualTo("columnId", modelAttribute.getClumnId());
		
		List<Video> videoList = videoMapper.selectByExample(example);
		
		for (int i = 0; i < videoList.size(); i++) {
			videoList.get(i).setPlayer("palyer" + i);
			videoList.get(i).setUu(userUnique);
		}
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		Map<String, Object> confMap = new HashMap<String, Object>();
		confMap.put("flatBit", modelAttribute.getFlatBit());
		
		returnMap.put("conf", confMap);
		returnMap.put("data", videoList);
		
		return returnMap;
	}
	
	
}
