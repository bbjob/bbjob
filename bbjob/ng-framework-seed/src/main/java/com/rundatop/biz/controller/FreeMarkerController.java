package com.rundatop.biz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public void getRoutes(HttpServletRequest request,HttpServletResponse response){
		//1.获取用户信息
		SysUser user = (SysUser) getCurrentUser();
		try {
			response.setContentType("application/javascript;charset=UTF-8");
			PrintWriter out = response.getWriter();
			freeMarkerService.getRoutes(user, out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="getLazyload")
	public void getLazyload(HttpServletRequest request,HttpServletResponse response){
		try {
			response.setContentType("application/javascript;charset=UTF-8");
			PrintWriter out = response.getWriter();
			freeMarkerService.getLazyload(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
