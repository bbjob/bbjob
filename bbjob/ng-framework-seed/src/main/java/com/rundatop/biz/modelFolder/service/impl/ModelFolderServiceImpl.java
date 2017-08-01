package com.rundatop.biz.modelFolder.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.rundatop.biz.modelFolder.service.ModelFolderService;
import com.rundatop.sys.dto.SysUser;
import com.rundatop.sys.example.ModelFileInfoExample;
import com.rundatop.sys.mapper.ModelFileInfoMapper;
import com.rundatop.sys.model.ModelFileInfo;


@Service
public class ModelFolderServiceImpl implements ModelFolderService {
	
	@Autowired
	private ModelFileInfoMapper modelFileInfoMapper;

	public List<HashMap<String, Object>> getList(String path) {
		String ftlRootPath = "";
		String deployPath = getDeployPath();
		
		if (path == null || "".equals(path)) {
			ftlRootPath = deployPath +  "customModel";
		} else {
			ftlRootPath = path;
		}

		List<HashMap<String, Object>> getFolderInfo = getFolderInfo(ftlRootPath);
		
		return getFolderInfo;
	}

	/**
	 * 获取指定文件路径下的所有文件信息
	 * @param ftlRootPath
	 * @return
	 */
	private List<HashMap<String, Object>> getFolderInfo(String ftlRootPath) {
		
		File file = new File(ftlRootPath);
		
		File[] tempList = file.listFiles();
		
		List<HashMap<String, Object>> returnList = new ArrayList<HashMap<String,Object>>();
		
		HashMap<String, Object> itemMap = null;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();  
		
		DecimalFormat df = new DecimalFormat("#.00");
		
		for (int i = 0; i < tempList.length; i++) {
			itemMap = new HashMap<String,Object>();
			
			File itemFile = tempList[i];
			
			if (itemFile.isDirectory()) {
				itemMap.put("fileName", itemFile.getName());
					
				itemMap.put("fileType", "[文件夹]");
				
				itemMap.put("fileSize", "[未知]");
				
				Long time = itemFile.lastModified();
				cal.setTimeInMillis(time);
				
				itemMap.put("fileModifyDate", format.format(cal.getTime()));
				
				itemMap.put("abPath", itemFile.getAbsolutePath());
			} else {
				itemMap.put("fileName", itemFile.getName());

				String type = (itemFile.getName()).split("\\.")[((itemFile.getName()).split("\\.").length)-1];
				String fileType = type.toUpperCase() + "文件";			
				
		
				itemMap.put("fileType", fileType);
				
				itemMap.put("fileSize", df.format(itemFile.length() * 1.0 /1024) + " KB");
				
				Long time = itemFile.lastModified();
				cal.setTimeInMillis(time);
				
				itemMap.put("fileModifyDate", format.format(cal.getTime()));
				itemMap.put("abPath", itemFile.getAbsolutePath());
			}
			
			
			returnList.add(itemMap);
		}
		
		return returnList;
	}

	
	/*
	 * 获取工程发布路径
	 * E:/runda/workspace(quanmeitiOr)/mnt/WebContent/
	 */
	private String getDeployPath() {
		
		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
		ServletContext servletContext = webApplicationContext.getServletContext(); 
		String projectPath = servletContext.getRealPath("/").replace("\\", "/");  // E:/runda/workspace(quanmeitiOr)/mnt/WebContent/
		
		System.out.println("------------" + projectPath);
//		String projectPath = "F:/runda/workspace(quanmeitiOr)/mnt/WebContent/";
		
		return projectPath;
	}

	public List<HashMap<String, Object>> getSampleModelFolderList() {
		
		String deployPath = getDeployPath();
		String ftlSampleRootPath = deployPath +  "customModel" + File.separator + "samples";
		
		List<HashMap<String, Object>> getSampleFolderInfo = getFolderInfo(ftlSampleRootPath);
		
		return getSampleFolderInfo;
	}

	public String getFileContent(String path) {
		
		String encoding = "UTF-8";
		
		File file = new File(path);
		
		Long filelength = file.length();  
        byte[] filecontent = new byte[filelength.intValue()];  
        
        try {  
            FileInputStream in = new FileInputStream(file);  
            in.read(filecontent);  
            in.close();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        
        try {  
            return new String(filecontent, encoding);  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
            return null;  
        }  
		
	}

	public int createFile(String path, String name, String tContent, String title, String description, SysUser user){
		String filePath = "";
		
		if (path == null || "".equals(path)) {
			String deployPath = getDeployPath();
			path = deployPath +  "customModel";
			
		}
		
		filePath = path + File.separator + name + ".ftl";
		
		try{
			// 创建文件
			createNewFile(filePath);
			// 将内容写入文件
			writeContentToFile(filePath, tContent);
			// 基础信息保存到数据库
			saveInfoToDB(filePath, name, title, description, user);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	
		return 1;
	}
	
	public int updateFile(String path, String name, String tContent, String title, String description, SysUser user, String originalPath){
		String filePath = "";
		
		if (path == null || "".equals(path)) {
			String deployPath = getDeployPath();
			path = deployPath +  "customModel";
			
		}
		
		filePath = "";
		
		File file = new File(originalPath);
		
		
		try{
			if (file.isDirectory()) {
				filePath = path + File.separator + name;
				file.renameTo(new File(filePath));	
				updateInfoToDB(originalPath, filePath, name, title, description, user);
				
			} else {
				filePath = path + File.separator + name + ".ftl";
				file.renameTo(new File(filePath));
				writeContentToFile(filePath, tContent);
				updateInfoToDB(originalPath, filePath, name, title, description, user);
				
			}
			
			
			// 创建文件
// 			createNewFile(filePath);
			// 将内容写入文件
// 			writeContentToFile(filePath, tContent);
			// 基础信息保存到数据库
//			saveInfoToDB(filePath, name, title, description, user);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	
		return 1;
	}

	private void updateInfoToDB(String originalPath, String filePath,
			String name, String title, String description, SysUser user) {
		
		originalPath = originalPath.replace("\\", "/").trim();
		filePath = filePath.replace("\\", "/").trim();
		ModelFileInfoExample example = new ModelFileInfoExample();
		example.createCriteria().andFilePathEqualTo(originalPath);
		
		List<ModelFileInfo> list = modelFileInfoMapper.selectByExample(example);
		
		if (list.size() == 0) {
			ModelFileInfo modelFileInfo = new ModelFileInfo();
			
			modelFileInfo.setFilePath(filePath);
			modelFileInfo.setFileDesc(description);
			modelFileInfo.setFileName(name);
			modelFileInfo.setFileTitle(title);
			modelFileInfo.setId(getUUID());
			modelFileInfo.setCreateName(user.getUsername());
			modelFileInfo.setCreateTime(new Date());

		} else {
			ModelFileInfo modelFileInfo = new ModelFileInfo();
			
			modelFileInfo.setFilePath(filePath);
			modelFileInfo.setFileDesc(description);
			modelFileInfo.setFileName(name);
			modelFileInfo.setFileTitle(title);
			modelFileInfo.setId(list.get(0).getId());
			modelFileInfo.setUpdateName(user.getUsername());
			modelFileInfo.setUpdateTime(new Date());
			modelFileInfoMapper.updateByPrimaryKeySelective(modelFileInfo);
		}
	}

	private Integer saveInfoToDB(String filePath, String name, String title,
			String description, SysUser user) {
		ModelFileInfo modelFileInfo = new ModelFileInfo();
		
		filePath = filePath.replace("\\", "/").trim();
		
		modelFileInfo.setId(getUUID());
		modelFileInfo.setFilePath(filePath);
		modelFileInfo.setFileName(name);
		modelFileInfo.setFileTitle(title);
		modelFileInfo.setFileDesc(description);
		modelFileInfo.setCreateTime(new Date());
		modelFileInfo.setCreateName(user.getUsername());
		
		return modelFileInfoMapper.insert(modelFileInfo);
	}

	private void writeContentToFile(String filePath, String tContent) throws IOException {
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		FileOutputStream fos = null;
		PrintWriter pw = null;

//************************转义标签替换**********************************************************//		
		tContent = tContent.replace("&lt;", "<");											//
		tContent = tContent.replace("&gt;", ">");											//
		tContent = tContent.replace("&#39;", "'");											//
		tContent = tContent.replace("&quot;", "\"");										//
		tContent = tContent.replace("&amp;", "&");											//
		tContent = tContent.replace("<!--#list-->", "</#list>");							//
		tContent = tContent.replace("<!--@picArtList-->", "</@picArtList>");				//
		tContent = tContent.replace("<!--#if-->", "</#if>");								//
//******************************************************************************************//		
		
		
		try {
			File file = new File(filePath);
			
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			
			StringBuffer buffer = new StringBuffer();
			
			buffer.append(tContent);
			
			fos = new FileOutputStream(file);
			pw = new PrintWriter(fos);
			pw.write(buffer.toString().toCharArray());
			
			pw.flush();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
			if (fos != null) {
				fos.close();
			}
			if (br != null) {
				br.close();
			}
			if (isr != null) {
				isr.close();
			}
			if (fis != null) {
				fis.close();
			}
			
			
		}
		
	}

	private void createNewFile(String path) {
		File file = new File(path);
		
		try{
			if (!file.exists()) {
				file.createNewFile();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public int createFolder(String path, String name, String title, String description, SysUser user) {
		String folder = "";
		
		if (path == null || "".equals(path)) {
			String deployPath = getDeployPath();
			path = deployPath +  "customModel";
			
		}
		
		folder = path + File.separator + name;
		
		File dir = new File(folder);
		if (dir.mkdirs()) {// 创建目标目录
			
			saveInfoToDB(folder, name, title, description, user);
			
			return 1;
		} else {
			return -1;
		}
	}

	public int delFile(String abPath) {
		File paramFile = new File(abPath);
		
		if (!paramFile.exists()) {
			return 1;
		}
		
		if (!paramFile.isDirectory()) {
			// paramFile.delete();
			delFileByPath(abPath);
			
			return delRecordFromDB(abPath);
		} else {
/*			if (!abPath.endsWith(File.separator)) {
				abPath = abPath + File.separator;
			}*/
			paramFile = new File(abPath);
			
			File[] files = paramFile.listFiles();
			
			for (int i = 0; i < files.length; i++) {
				if (files[i].isFile()) {
					delFileByPath(files[i].getAbsolutePath());
				} else {
					delFile(files[i].getAbsolutePath());
				}
			}
			
			if (paramFile.delete()) {
				delRecordFromDB(abPath);
				
				return delRecordFromDB(abPath);
			} else {
				return -1;
			}
		}
		
	}

	private int delFileByPath(String paramFile) {
		File file = new File(paramFile);
		
		if (file.isFile() && file.exists()) {// 路径为文件且不为空则进行删除
			file.delete();// 文件删除
			
			return 1;
		}
		
		return 0;
	}

	private int delRecordFromDB(String paramFile) {
		String filePath = paramFile.replace("\\", "/").trim();
		
		ModelFileInfoExample example = new ModelFileInfoExample();
		example.createCriteria().andFilePathEqualTo(filePath);
		
		return modelFileInfoMapper.deleteByExample(example);
		
	}

	public String getParentPath(String path) {
		File file = new File(path);
		if (path == null || "".equals(path)) {
			String deployPath = getDeployPath();
			return deployPath +  "customModel";
		} 
		
		if (!file.exists()) {
			String deployPath = getDeployPath();
			return deployPath +  "customModel";
		} else {
			
			return file.getParent();
		}
	}

	public ModelFileInfo getFileInfoByAbPath(String path) {
		
		// 获取TContent
		String TConent = getModelContentByPath(path);
		
		// 获取文件信息
		path = path.replace("\\", "/").trim();
		ModelFileInfoExample example = new ModelFileInfoExample();
		example.createCriteria().andFilePathEqualTo(path);
		
		List<ModelFileInfo> list = modelFileInfoMapper.selectByExample(example);
		
		ModelFileInfo modelFileInfo = new ModelFileInfo();
		
		if (list.size() == 0) {
			return modelFileInfo;
		}
		
		modelFileInfo = list.get(0);
		modelFileInfo.setConent(TConent);
		
		return modelFileInfo;
	}

	public String getModelContentByPath(String path) {
		if (path == null || "".equals(path)) {
			return "";
		}
		
		File file = new File(path);
		if (!file.exists()) {
			return "";
		}
		
		if (file.isDirectory()) {
			return "";
		}
		
		return getFileContent(path);
	}
	
	private String getUUID() {
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replaceAll("-", "");
		return uuid.toUpperCase();
	}
	
	private String getDateFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		
		return sdf.format(new Date());
	}

	@Override
	public void downLoadFile(String path, String fileType, String fileName,
			HttpServletRequest request, HttpServletResponse response) {
		String prefix = "";
		
		try {
			fileType = new String(fileType.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (fileType.contains("文件夹")) { // 判断是否是文件夹，如果是则返回压缩文件路径
			prefix = fileName;
			
			String zipTempPath = getDeployPath() + "/temp";
			File dir = new File(zipTempPath);
			
			if (!isExist(dir)) { // 创建临时存放目录
				dir.mkdir(); 
			}
			
			String zipNamePath = zipTempPath + "/" + prefix + ".zip";
			File targetFile = new File(zipNamePath);
			
			if (!isExist(targetFile)) {
				try {
					targetFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			File sourceFile = new File(path);
			response.reset();
			try {
				FileOutputStream fous = new FileOutputStream(targetFile);
				ZipOutputStream zipOut = new ZipOutputStream(fous);
				BufferedOutputStream bo = new BufferedOutputStream(zipOut);
				zip(zipOut, sourceFile, prefix, bo);
				
				// 1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
				response.setContentType("multipart/form-data");
				// 2.设置文件头：最后一个参数是设置下载文件名(假如我们叫a.pdf)
				response.setHeader("Content-Disposition", "attachment;fileName=" + prefix + ".zip");
				try {
					// 读取文件
					InputStream in = new FileInputStream(zipNamePath);
					OutputStream out = response.getOutputStream();

					// 写文件
					int b;
					while ((b = in.read()) != -1) {
						out.write(b);
					}

					in.close();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// prefix = fileName.substring(0, fileName.lastIndexOf("."));
			// 1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
			response.setContentType("multipart/form-data");
			// 2.设置文件头：最后一个参数是设置下载文件名(假如我们叫a.pdf)
			response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
			
			try {
				// 读取文件
				InputStream in = new FileInputStream(path);
				OutputStream out = response.getOutputStream();

				// 写文件
				int b;
				while ((b = in.read()) != -1) {
					out.write(b);
				}

				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 压缩文件
	 * @param zipOut     zipoutSteam 
	 * @param sourceFile 源文件
	 * @param prefix     文件名
	 * @param bo         BufferedOutStream
	 * @throws IOException 
	 */
	private void zip(ZipOutputStream out, File f, String base,
			BufferedOutputStream bo) throws IOException {
        if (f.isDirectory()) {  
            File[] fl = f.listFiles();  
            if (fl.length == 0) {  
                out.putNextEntry(new ZipEntry(base + "/")); // 创建zip压缩进入点base  
                System.out.println(base + "/");  
            }  
            for (int i = 0; i < fl.length; i++) {  
                zip(out, fl[i], base + "/" + fl[i].getName(), bo); // 递归遍历子文件夹  
            }  
        } else {  
            out.putNextEntry(new ZipEntry(base)); // 创建zip压缩进入点base  
            System.out.println(base);  
            FileInputStream in = new FileInputStream(f);  
            BufferedInputStream bi = new BufferedInputStream(in);  
            int b;  
            while ((b = bi.read()) != -1) {  
                bo.write(b); // 将字节流写入当前zip目录  
            }  
            bi.close();  
            in.close(); // 输入流关闭  
        } 
	}

	// 判断文件是否存在
	private boolean isExist(File file) {
		
		if (file.exists()) {
			return true;
		} else {
			
			return false;
		}
	}
}
