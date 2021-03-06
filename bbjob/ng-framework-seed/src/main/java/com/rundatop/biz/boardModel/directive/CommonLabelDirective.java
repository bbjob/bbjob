package com.rundatop.biz.boardModel.directive;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.rundatop.biz.boardModel.service.CommonLabelFactoryService;
import com.rundatop.biz.boardModel.service.PicArtListDirectiveService;
import com.rundatop.sys.model.ArticleInfo;
import com.rundatop.sys.model.ChannelColumns;
import com.rundatop.sys.model.ModelAttribute;

import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.Configuration;
import freemarker.template.SimpleScalar;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

public class CommonLabelDirective implements TemplateDirectiveModel{
	
	@Autowired
	private PicArtListDirectiveService picArtListDirectiveService;
	
	@Autowired
	private CommonLabelFactoryService commonLabelFactory;
	
	// 默认实现接口
	public void execute(Environment env, Map params, TemplateModel[] arg2,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		
		ModelAttribute modelAttributeFromParams = getParams(params); // 解析前台传递的属性复制给bean
		
		ModelAttribute modelAttributeFromDB = picArtListDirectiveService.getModelAttributebyClumnId(modelAttributeFromParams.getClumnId()); // 根据栏目ID获取模板配置信息
		
		ModelAttribute modelAttribute = dealBean(modelAttributeFromParams, modelAttributeFromDB); // 处理属性参数
		
		
		Map<String, Object> allData = new HashMap<String, Object>();
			
		try {
			allData = commonLabelFactory.getAllDataByModelAttr(modelAttribute);
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<ArticleInfo> htmlValue = (List<ArticleInfo>) allData.get("data");
		Map<String, Object> confMap = (Map<String, Object>) allData.get("conf");
		
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = attr.getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("confMap", confMap);
		
		env.setVariable("htmlValue", createBeansWrapper().wrap(htmlValue));
		env.setVariable("confMap", createBeansWrapper().wrap(confMap));
		

		// 查询该栏目下的所有内容和配置信息
		/*
		Map<String, Object> allData = MockData.getMockDataByBoardID(boardID, className);
		
		List<HashMap<String, String>> htmlValue = (List<HashMap<String, String>>) allData.get("data");
		Map<String, Object> confMap = (Map<String, Object>) allData.get("conf");
		
		env.setVariable("htmlValue", createBeansWrapper().wrap(htmlValue));
		env.setVariable("confMap", createBeansWrapper().wrap(confMap));
		*/
		
		body.render(env.getOut());
		
	}

	/**
	 * 将前台传递的参数与数据库中查询的参数合并
	 * @param modelAttributeFromParams
	 * @param modelAttributeFromDB
	 * @return
	 */
	private ModelAttribute dealBean(ModelAttribute modelAttributeFromParams,
			ModelAttribute modelAttributeFromDB) {
		
		if (modelAttributeFromDB == null) {
			return modelAttributeFromParams;
		}
		
		if ((modelAttributeFromParams.getClassName() == null || "".equals(modelAttributeFromParams.getClassName())) && modelAttributeFromDB.getClassName() != null) {
			modelAttributeFromParams.setClassName(modelAttributeFromDB.getClassName());
		}
		
		if ((modelAttributeFromParams.getClumnId() == null || "".equals(modelAttributeFromParams.getClumnId())) && modelAttributeFromDB.getClumnId() != null) {
			modelAttributeFromParams.setClumnId(modelAttributeFromDB.getClumnId());
		}
		
		if ((modelAttributeFromParams.getArticleNumber() == null || "".equals(modelAttributeFromParams.getArticleNumber())) && modelAttributeFromDB.getArticleNumber() != null) {
			modelAttributeFromParams.setArticleNumber(modelAttributeFromDB.getArticleNumber());
		}
		
		if ((modelAttributeFromParams.getArticleType() == null || "".equals(modelAttributeFromParams.getArticleType())) && modelAttributeFromDB.getArticleType() != null) {
			modelAttributeFromParams.setArticleType(modelAttributeFromDB.getArticleType());
		}
		
		if (modelAttributeFromParams.getLineNumber() == null && modelAttributeFromDB.getLineNumber() != null) {
			modelAttributeFromParams.setLineNumber(modelAttributeFromDB.getLineNumber());
		}
		
		if (modelAttributeFromParams.getTimeType() == null && modelAttributeFromDB.getTimeType() != null) {
			modelAttributeFromParams.setTimeType(modelAttributeFromDB.getTimeType());
		}
		
		if ((modelAttributeFromParams.getDisplayConent() == null || "".equals(modelAttributeFromParams.getDisplayConent())) && modelAttributeFromDB.getDisplayConent() != null) {
			modelAttributeFromParams.setDisplayConent(modelAttributeFromDB.getDisplayConent());
		}
		
		if (modelAttributeFromParams.getSortType() == null && modelAttributeFromDB.getSortType() != null) {
			modelAttributeFromParams.setSortType(modelAttributeFromDB.getSortType());
		}
		
		if ((modelAttributeFromParams.getTitleLength() == null || "".equals(modelAttributeFromParams.getTitleLength())) && modelAttributeFromDB.getTitleLength() != null) {
			modelAttributeFromParams.setTitleLength(modelAttributeFromDB.getTitleLength());
		}
		
		if ((modelAttributeFromParams.getTitleLineNumber() == null || "".equals(modelAttributeFromParams.getTitleLineNumber())) && modelAttributeFromDB.getTitleLineNumber() != null) {
			modelAttributeFromParams.setTitleLineNumber(modelAttributeFromDB.getTitleLineNumber());
		}
		
		if (modelAttributeFromParams.getPrefixType() == null && modelAttributeFromDB.getPrefixType() != null) {
			modelAttributeFromParams.setPrefixType(modelAttributeFromDB.getPrefixType());
		}
		
		if ((modelAttributeFromParams.getPrefixContent() == null || "".equals(modelAttributeFromParams.getPrefixContent())) && modelAttributeFromDB.getPrefixContent() != null) {
			modelAttributeFromParams.setPrefixContent(modelAttributeFromDB.getPrefixContent());
		}
		
		if ((modelAttributeFromParams.getPrefixPic() == null || "".equals(modelAttributeFromParams.getPrefixPic())) && modelAttributeFromDB.getPrefixPic() != null) {
			modelAttributeFromParams.setPrefixPic(modelAttributeFromDB.getPrefixPic());
		}
		
		if ((modelAttributeFromParams.getAbstractLength() == null || "".equals(modelAttributeFromParams.getAbstractLength())) && modelAttributeFromDB.getAbstractLength() != null) {
			modelAttributeFromParams.setAbstractLength(modelAttributeFromDB.getAbstractLength());
		}
		
		if (modelAttributeFromParams.getAbstractLineNumber() == null && modelAttributeFromDB.getAbstractLineNumber() != null) {
			modelAttributeFromParams.setAbstractLineNumber(modelAttributeFromDB.getAbstractLineNumber());
		}
		
		if ((modelAttributeFromParams.getPicHeight() == null || "".equals(modelAttributeFromParams.getPicHeight())) && modelAttributeFromDB.getPicHeight() != null) {
			modelAttributeFromParams.setPicHeight(modelAttributeFromDB.getPicHeight());
		}
		
		if ((modelAttributeFromParams.getPicWide() == null || "".equals(modelAttributeFromParams.getPicWide())) && modelAttributeFromDB.getPicWide() != null) {
			modelAttributeFromParams.setPicWide(modelAttributeFromDB.getPicWide());
		}
		
		if ((modelAttributeFromParams.getArticleAuthor() == null || "".equals(modelAttributeFromParams.getArticleAuthor())) && modelAttributeFromDB.getArticleAuthor() != null) {
			modelAttributeFromParams.setArticleAuthor(modelAttributeFromDB.getArticleAuthor());
		}
		
		if (modelAttributeFromParams.getChildrenClomns() == null && modelAttributeFromDB.getChildrenClomns() != null) {
			modelAttributeFromParams.setChildrenClomns(modelAttributeFromDB.getChildrenClomns());
		}
		
		if (modelAttributeFromParams.getOriginal() == null && modelAttributeFromDB.getOriginal() != null) {
			modelAttributeFromParams.setOriginal(modelAttributeFromDB.getOriginal());
		}
		
		if ((modelAttributeFromParams.getModel() == null || "".equals(modelAttributeFromParams.getModel())) && modelAttributeFromDB.getModel() != null) {
			modelAttributeFromParams.setModel(modelAttributeFromDB.getModel());
		}
		
		if ((modelAttributeFromParams.getRotationType() == null || "".equals(modelAttributeFromParams.getRotationType())) && modelAttributeFromDB.getRotationType() != null) {
			modelAttributeFromParams.setRotationType(modelAttributeFromDB.getRotationType());
		}
		
		if ((modelAttributeFromParams.getKeyword() == null || "".equals(modelAttributeFromParams.getKeyword())) && modelAttributeFromDB.getKeyword() != null) {
			modelAttributeFromParams.setKeyword(modelAttributeFromDB.getKeyword());
		}
		
		return modelAttributeFromParams;
	}


	/** 获取参数
	 * @param params
	 * @return
	 * @throws TemplateModelException
	 */
	private ModelAttribute getParams(Map params) throws TemplateModelException {

		ModelAttribute modelAttribute = new ModelAttribute();
		
		String clumnId = getParam(params, "clumnId");
		modelAttribute.setClumnId(clumnId);
		String extAttr = getParam(params, "extAttr");
		
		if (extAttr != null && !"".equals(extAttr)) {
			String[] attrs = extAttr.split("&");
			
			for (int i = 0; i < attrs.length; i++) {
				String item = attrs[i].trim();
				
				String[] items = item.split("=");
				String key = items[0].trim();
				String value = items[1].trim();
				
				if ("className".equals(key)) {
					modelAttribute.setClassName(value);
				} else if ("clumnId".equals(key)) {
					modelAttribute.setClumnId(value);
				} else if ("articleNumber".equals(key)) {
					modelAttribute.setArticleNumber(value);
				} else if ("articleType".equals(key)) {
					modelAttribute.setArticleType(value);
				} else if ("lineNumber".equals(key)) {
					modelAttribute.setLineNumber(Integer.valueOf(value));
				} else if ("timeType".equals(key)) {
					modelAttribute.setTimeType(Integer.valueOf(value));
				} else if ("displayConent".equals(key)) {
					modelAttribute.setDisplayConent(value);
				} else if ("sortType".equals(key)) {
					modelAttribute.setSortType(Integer.valueOf(value));
				} else if ("titleLength".equals(key)) {
					modelAttribute.setTitleLength(value);
				} else if ("titleLineNumber".equals(key)) {
					modelAttribute.setLineNumber(Integer.valueOf(value));
				} else if ("prefixType".equals(key)) {
					modelAttribute.setPrefixType(Integer.valueOf(value));
				} else if ("prefixContent".equals(key)) {
					modelAttribute.setPrefixContent(value);
				} else if ("prefixPic".equals(key)) {
					modelAttribute.setPrefixPic(value);
				} else if ("abstractLength".equals(key)) {
					modelAttribute.setAbstractLength(value);
				} else if ("abstractLineNumber".equals(key)) {
					modelAttribute.setAbstractLineNumber(Integer.valueOf(value));
				} else if ("picHeight".equals(key)) {
					modelAttribute.setPicHeight(value);
				} else if ("picWide".equals(key)) {
					modelAttribute.setPicWide(value);
				} else if ("articleAuthor".equals(key)) {
					modelAttribute.setArticleAuthor(value);
				} else if ("childrenClomns".equals(key)) {
					modelAttribute.setChildrenClomns(Integer.valueOf(value));
				} else if ("original".equals(key)) {
					modelAttribute.setOriginal(Integer.valueOf(value));
				} else if ("model".equals(key)) {
					modelAttribute.setModel(value);
				} else if ("rotationType".equals(key)) {
					modelAttribute.setRotationType(value);
				} else if ("keyword".equals(key)) {
					modelAttribute.setKeyword(value);
				} else if ("flagBit".equals(key)) {
					modelAttribute.setFlatBit(value);
				}
			}	
		}
		
		return modelAttribute;

	}

	// 自定义标签无法直接识别传递过来的数据类型参数， 字符串需用 SimpleScalar 转换
	private String getParam(Map params, String string) {
		
		Object value = params.get(string);
		
		if (value instanceof SimpleScalar) {
			
			return ((SimpleScalar)value).getAsString();
		}
		
		return null;
	}
	
	public BeansWrapper createBeansWrapper() {

		return new BeansWrapperBuilder(Configuration.VERSION_2_3_22).build();
		
	}

}
