package com.rundatop.sys.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItemStream;
import org.springframework.stereotype.Service;

import com.rundatop.core.spring.annotation.Config;
import com.rundatop.sys.model.Uploader;

@Service
public class UploadService {
	@Config("upload.phy_path")
	private String phyPath;
	@Config("upload.image_save_path")
	private String imageSavePath;
	@Config("upload.file_save_path")
	private String fileSavePath;
	@Config("upload.image_file_Type")
	private String imageFileType;
	@Config("upload.imageMaxSize")
	private int imageMaxSize;
	public Uploader uploadImage(HttpServletRequest request) throws Exception {
		Uploader up=new Uploader(request);
		up.setPhyPath(phyPath);
		up.setSavePath(imageSavePath);
	    String[] fileType = imageFileType.split(",");
	    up.setAllowFiles(fileType);
	    up.setMaxSize(imageMaxSize); //单位KB
	    up.upload();
		return up;
	}
	
	public Uploader uploadResourse(HttpServletRequest request) throws Exception {
		Uploader up=new Uploader(request);
		up.setPhyPath(phyPath);
		up.setSavePath(imageSavePath);
//	    String[] fileType = imageFileType.split(",");
//	    up.setAllowFiles(fileType);
	    up.setMaxSize(30000000); //单位KB
	    up.upload();
		return up;
	}
	
	public File getUploadFile(HttpServletRequest request) throws Exception {
		Uploader up=new Uploader(request);
		up.setPhyPath(phyPath);
		up.setSavePath(imageSavePath);
	    String[] fileType = imageFileType.split(",");
	    up.setAllowFiles(fileType);
	    up.setMaxSize(5000); //单位KB
	    up.upload();
		return up.getUploadFile();
	}
	
	//yxw 上传和获取用户上传的文件  isusename  true 使用原文件名
	public File getAndUploadFile(HttpServletRequest request,boolean isusename) throws Exception {
		Uploader up=new Uploader(request);
		up.setPhyPath(phyPath);
		up.setSavePath(fileSavePath);
		up.setIsusename(isusename);
//		String[] fileType = imageFileType.split(",");
//		up.setAllowFiles(fileType);
		up.setMaxSize(50000000); //单位KB
		return up.uploadFile();
//		return up.getUploadFile();
	}
	
	/***
	 * yxw 上传和获取用户上传的文件  isusename  true 使用原文件名
	 * @param request
	 * @param isusename
	 * @param isUseUserName 当需要使用用户自定的名字时 传true
	 * @param userName isUseUserName为true 时传要存储的名字 
	 * @param isUserUserSsavePath 当需要使用用户自定的路径时 传true
	 * @param savePath 用户自定的路径
	 * @param maxSize 大小限制 单位KB 传null即为默认限制10000KB 
	 * @return
	 * @throws Exception
	 */
	public File getAndUploadFile(HttpServletRequest request,boolean isusename,boolean isUseUserName,boolean isUserUserSsavePath,String userName,String savePath,Integer maxSize) throws Exception {
		Uploader up=new Uploader(request);
		up.setPhyPath(phyPath);
		up.setSavePath(savePath);
		up.setIsusename(isusename);
		up.setUseUserName(isUseUserName);
		up.setUserUserSsavePath(isUserUserSsavePath);
		up.setUserFileName(userName);
//		String[] fileType = imageFileType.split(",");
//		up.setAllowFiles(fileType);
		if(null!=maxSize)
			up.setMaxSize(maxSize); //单位KB
		return up.uploadFile();
//		return up.getUploadFile();
	}
	
	public FileItemStream getFis(HttpServletRequest request) throws Exception {
		Uploader up=new Uploader(request);
		up.setPhyPath(phyPath);
		up.setSavePath(imageSavePath);
	    String[] fileType = imageFileType.split(",");
	    up.setAllowFiles(fileType);
	    up.setMaxSize(5000); //单位KB
	  //  up.upload();
		return up.getFis();
	}
}
