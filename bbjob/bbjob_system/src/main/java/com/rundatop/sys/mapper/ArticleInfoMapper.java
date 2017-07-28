package com.rundatop.sys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import tk.mybatis.mapper.common.Mapper;

import com.rundatop.sys.example.ArticleInfoExample;
import com.rundatop.sys.model.ArticleColumn;
import com.rundatop.sys.model.ArticleInfo;
import com.rundatop.sys.model.ModelAttribute;
import com.rundatop.sys.search.ArticleInfoSearch;


public interface ArticleInfoMapper extends Mapper<ArticleInfo>{
	
	List<ArticleInfo> getArtListByExample(@Param("example") ArticleInfoExample example, @Param("colId") String colId);
	List<ArticleInfo> selNotinColArticle(@Param("columnId") String columnId,@Param("channelId") String channelId,@Param("name")String name,@Param("colId")String colId, @Param("begin")Integer begin, @Param("size")int size);
	Integer selInColArticleCount(@Param("columnId") String columnId,@Param("channelId") String channelId,@Param("name")String name,@Param("colId")String colId, @Param("begin")Integer begin, @Param("size")int size);
	Integer artNumCount(@Param("columnId") String columnId,@Param("channelId") String channelId,@Param("name")String name,@Param("colId")String colId, @Param("begin")Integer begin, @Param("size")int size);
	List<ArticleInfo> selectByGenereateParams(@Param("record")ModelAttribute modelAttribute);
	List<ArticleInfo> selectByExampleWithBLOBs(@Param("example")ArticleInfoExample example);

}