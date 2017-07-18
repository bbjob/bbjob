package com.rundatop.sys.service;

import java.util.List;
import java.util.Map;

import com.rundatop.sys.model.SysRoutes;
	
public interface IRoutesService {
	List<SysRoutes> routes(SysRoutes sysRoutes, int page, int rows);
	
	String delRoutes(SysRoutes sysRoutes);

	String addRoutes(SysRoutes sysRoutes);

	String editRoutes(SysRoutes sysRoutes);

	Map<String, Integer> functionNames();
}
