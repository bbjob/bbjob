package com.rundatop.sys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import tk.mybatis.mapper.common.Mapper;

import com.rundatop.sys.example.ArticleColumnExample;
import com.rundatop.sys.model.ArticleColumn;
import com.rundatop.sys.model.SysFunction;

public interface ArticleColumnMapper extends Mapper<ArticleColumn> {

	List<Map<String, Object>> getArtRefColList();
}