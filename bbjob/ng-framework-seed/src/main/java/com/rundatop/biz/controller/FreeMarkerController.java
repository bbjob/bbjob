package com.rundatop.biz.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rundatop.biz.service.FreeMarkerService;
import com.rundatop.security.base.controller.SecurityController;
import com.rundatop.sys.dto.SysUser;

@RequestMapping("sys")				
@RestController
public class FreeMarkerController extends SecurityController {
	@Resource
	private FreeMarkerService freeMarkerService;
	
	@RequestMapping(value="getRoutes")
	public String getRoutes(){
		//1.获取用户信息
		SysUser user = (SysUser) getCurrentUser();
		return freeMarkerService.getRoutes(user);
	}
	
	@RequestMapping(value="getLazyload")
	public String getLazyload(){
		return freeMarkerService.getLazyload();
	}
}
