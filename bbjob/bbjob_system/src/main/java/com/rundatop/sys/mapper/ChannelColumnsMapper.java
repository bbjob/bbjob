package com.rundatop.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import tk.mybatis.mapper.common.Mapper;

import com.rundatop.sys.example.ChannelColumnsExample;
import com.rundatop.sys.model.ChannelColumns;

public interface ChannelColumnsMapper extends Mapper<ChannelColumns>{

	List<ChannelColumns> selectByExampleRefChannel(
		@Param("example") ChannelColumnsExample example);
	
	String selectPrevParentId(String parentId);

}