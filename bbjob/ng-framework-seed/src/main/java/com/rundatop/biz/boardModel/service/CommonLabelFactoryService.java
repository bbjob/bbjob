package com.rundatop.biz.boardModel.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rundatop.sys.model.ModelAttribute;

@Service
public class CommonLabelFactoryService {

	@Autowired
	private PicArtListService artList;
	
	/**
	 * @param modelAttribute
	 * @return 
	 */
	public Map<String, Object> getAllDataByModelAttr(ModelAttribute modelAttribute) {
		
		Map<String, Object> returnMap = new HashMap<String,Object>();
		
		if ("1".equals(modelAttribute.getFlatBit())) {
			System.out.println("artList:" + artList);
			returnMap = artList.getAllData(modelAttribute);
			
		} else {
			// TODO
		}
		
		return returnMap;
	}

}
