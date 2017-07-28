package com.rundatop.sys.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rundatop.sys.model.Uploader;
import com.rundatop.sys.service.UploadService;

@Controller
@RequestMapping({"upload","images"})
public class UploadController {
	@Resource
	UploadService uploadService;
	@RequestMapping(method = RequestMethod.POST, value = "imageUp")
	@ResponseBody
	public String imageUp(HttpServletRequest request) throws Exception {
		Uploader up=uploadService.uploadImage(request);
		String callback = request.getParameter("callback");
		String result = "{\"name\":\"" + up.getFileName()
				+ "\", \"originalName\": \"" + up.getOriginalName()
				+ "\", \"size\": " + up.getSize() + ", \"state\": \""
				+ up.getState() + "\", \"type\": \"" + up.getType()
				+ "\", \"url\": \"" + up.getUrl() + "\"}";

		result = result.replaceAll("\\\\", "\\\\");

		if (callback == null) {
			return result;
		} else {
			return "<script>" + callback + "(" + result + ")</script>";
		}
	}
	
	
}
