package com.rundatop.biz.proManage.service;

import java.util.List;
import java.util.Map;

import com.rundatop.sys.dto.SysUser;
import com.rundatop.sys.example.MemberGroupExample;
import com.rundatop.sys.model.ArticleInfo;
import com.rundatop.sys.model.ChannelColumns;
import com.rundatop.sys.model.ChannelColumnsMember;
import com.rundatop.sys.model.MemberGroup;
import com.rundatop.sys.model.ModelAttribute;
import com.rundatop.sys.model.User;
import com.rundatop.sys.search.ArticleInfoSearch;
import com.rundatop.sys.search.ChannelColumnsScerch;

public interface ProManageService {

	List<ChannelColumns> getpageList(ChannelColumnsScerch info, User object);

	String getChannelId(String flagBit);

	List<MemberGroup> getMemberGroupList(MemberGroupExample info);

	int add(ChannelColumns info, SysUser user);

	List<ChannelColumnsMember> getSelectMemberGroupList(
			ChannelColumnsMember info);

	String getPrevParentId(String parentId);

	int del(String ids, SysUser user);

	int update(ChannelColumns info, SysUser user);

	List<ModelAttribute> getModelAttributeByClumnId(String clumnId);

	List<ArticleInfo> getArtByColPage(ArticleInfoSearch info);

	Map<String, Object> selNotinColArticle(int i, int j, String columnId,
			String channelId, String articleTitle, String colId);

	int addColArticles(String colId, String ids, SysUser user);

	int delColArticle(String ids, SysUser user);

}
