package com.rundatop.biz.modelFolder.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rundatop.biz.modelFolder.service.ModelFolderService;
import com.rundatop.security.base.controller.SecurityController;
import com.rundatop.sys.dto.SysUser;
import com.rundatop.sys.model.ModelFileInfo;


@RestController
@RequestMapping("modelFolderController")
public class ModelFolderController extends SecurityController{
	
	@Autowired
	private ModelFolderService modelFolderService;
	
	/**
	 * 测试，获取模板文件目录
	 */
	@RequestMapping(value = "/getModelFolderList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> getModelFolderList(String path, String folderName) {
		
		List<HashMap<String, Object>> getList = modelFolderService.getList(path);
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		returnMap.put("data", getList);
		
		return returnMap;
	}
	
	/**
	 * 获取样例模板文件信息
	 */
	@RequestMapping(value = "/getSampleModelFolderList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<HashMap<String, Object>> getSampleModelFolderList() {
		
		List<HashMap<String, Object>> getList = modelFolderService.getSampleModelFolderList();
		
		return getList;
	}
	
	/**
	 * 获取样例模板文件信息
	 */
	@RequestMapping(value = "/getSampleModelContent", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getSampleModelContent(String path) {
		
		String modelContent = modelFolderService.getFileContent(path);
		
		return modelContent;
	}
	
	/**
	 * 新增文件
	 * @throws IOException 
	 */
	@RequestMapping(value = "/addFile", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer createFile(String path, String name, String TContent, String title, String description) {
		int ok=0;
		try {
			SysUser user = (SysUser) getCurrentUser();
			ok = modelFolderService.createFile(path, name, TContent, title, description, user);
		} catch (Exception e) {
		}
		
		return ok;
	}
	
	/**
	 * 更新文件
	 * @throws IOException 
	 */
	@RequestMapping(value = "/updateFile", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer updateFile(String path, String name, String TContent, String title, String description, String originalPath) {
		int ok=0;
		try {
			SysUser user = (SysUser) getCurrentUser();
			ok = modelFolderService.updateFile(path, name, TContent, title, description, user, originalPath);
		} catch (Exception e) {
		}
		
		return ok;
	}

	/**
	 * 新增文件夹
	 * @throws IOException 
	 */
	@RequestMapping(value = "/addFolder", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer createFolder(String path, String name, String title, String description) {
		int ok=0;
		try {
			SysUser user = (SysUser) getCurrentUser();
			ok = modelFolderService.createFolder(path, name, title, description, user);
		} catch (Exception e) {
		}
		
		return ok;
	}
	
	/**
	 * 删除文件操作
	 * @throws IOException 
	 */
	@RequestMapping(value = "/delFile", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer delFile(String abPath) {
		int ok=0;
		try {
			ok = modelFolderService.delFile(abPath);
		} catch (Exception e) {
		}
		
		return ok;
	}
	
	/**
	 * 获取父文件夹路径
	 * @throws IOException 
	 */
	@RequestMapping(value = "/getParentPath", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getParentPath(String path) {
		
		return modelFolderService.getParentPath(path);
	}
	
	/**
	 * 根据传递的路径获取文件信息 和 模板内容
	 * @throws IOException 
	 */
	@RequestMapping(value = "/getFileInfoByAbPath", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelFileInfo getFileInfoByAbPath(String path) {
		
		return modelFolderService.getFileInfoByAbPath(path);
	}
	
}
