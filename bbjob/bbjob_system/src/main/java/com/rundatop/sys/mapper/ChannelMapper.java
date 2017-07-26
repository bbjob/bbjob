package com.rundatop.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import tk.mybatis.mapper.common.Mapper;

import com.rundatop.sys.example.ChannelExample;
import com.rundatop.sys.model.Channel;
import com.rundatop.sys.model.ChannelColumnsMember;

public interface ChannelMapper extends Mapper<Channel>{

	String selectColumnChannelID(String flagBit);
}