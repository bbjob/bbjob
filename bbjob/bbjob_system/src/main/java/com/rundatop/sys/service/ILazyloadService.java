package com.rundatop.sys.service;

import java.util.List;

import com.rundatop.sys.model.SysLazyload;
	
public interface ILazyloadService {
	List<SysLazyload> lazyload(SysLazyload sysLazyload, int page, int rows);
	
	String delLazyload(SysLazyload sysLazyload);

	String addLazyload(SysLazyload sysLazyload);

	String editLazyload(SysLazyload sysLazyload);
}
