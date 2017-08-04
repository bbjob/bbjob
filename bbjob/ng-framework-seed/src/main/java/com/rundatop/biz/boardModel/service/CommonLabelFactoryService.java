package com.rundatop.biz.boardModel.service;

import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rundatop.sys.model.ModelAttribute;

@Service
public class CommonLabelFactoryService {

	@Autowired
	private PicArtListService artList;
	
	@Autowired
	private VideoListService videoList;
	
	
	/**
	 * @param modelAttribute
	 * @return 
	 * @throws IntrospectionException 
	 */
	public Map<String, Object> getAllDataByModelAttr(ModelAttribute modelAttribute) throws IntrospectionException {
		
		Map<String, Object> returnMap = new HashMap<String,Object>();
		
		if ("1".equals(modelAttribute.getFlatBit())) { // 图文列表
			
			returnMap = artList.getAllData(modelAttribute);
		} else if ("2".equals(modelAttribute.getFlatBit())) {
			
			returnMap = videoList.getAllData(modelAttribute);
/*			Map<String, Object> confMap = new HashMap<String, Object>();
			confMap.put("flatBit", modelAttribute.getFlatBit());
			
			HashMap<String, String> dataItem = null;
			
			List<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
			
			dataItem = new HashMap<String, String>();
			dataItem.put("uu", "cfd9191aeb");
			dataItem.put("vu", "79ff602f42");
			dataItem.put("player", "player1");
			data.add(dataItem);
			
			dataItem = new HashMap<String, String>();
			dataItem.put("uu", "cfd9191aeb");
			dataItem.put("vu", "79ff602f42");
			dataItem.put("player", "player2");
			data.add(dataItem);
			
			returnMap.put("conf", confMap);
			returnMap.put("data", data);*/
		}
		
		return returnMap;
	}

}
