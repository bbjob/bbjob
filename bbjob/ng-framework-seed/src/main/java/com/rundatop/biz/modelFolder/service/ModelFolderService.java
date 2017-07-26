package com.rundatop.biz.modelFolder.service;

import java.util.HashMap;
import java.util.List;

import com.rundatop.sys.dto.SysUser;
import com.rundatop.sys.model.ModelFileInfo;

public interface ModelFolderService {

	List<HashMap<String, Object>> getList(String path);

	List<HashMap<String, Object>> getSampleModelFolderList();

	String getFileContent(String path);

	int createFile(String path, String name, String tContent, String title,
			String description, SysUser user);

	int updateFile(String path, String name, String tContent, String title,
			String description, SysUser user, String originalPath);

	int createFolder(String path, String name, String title,
			String description, SysUser user);

	int delFile(String abPath);

	String getParentPath(String path);

	ModelFileInfo getFileInfoByAbPath(String path);

}
