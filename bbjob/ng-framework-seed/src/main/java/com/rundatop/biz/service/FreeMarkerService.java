package com.rundatop.biz.service;

import java.io.PrintWriter;

import com.rundatop.sys.dto.SysUser;

public interface FreeMarkerService {

	void getRoutes(SysUser user, PrintWriter out); 

	void getLazyload(PrintWriter out); 
}
