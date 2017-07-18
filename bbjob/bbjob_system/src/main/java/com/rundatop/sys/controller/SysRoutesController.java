package com.rundatop.sys.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.rundatop.core.exception.BizException;
import com.rundatop.sys.model.SysRoutes;
import com.rundatop.sys.service.IRoutesService;

@RestController
@RequestMapping("sys")
public class SysRoutesController {
	@Resource
	private IRoutesService iRoutesService;

	@RequestMapping(value = "functionNames", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Integer> functionNames() throws BizException {
		return iRoutesService.functionNames();
	}
	
	@RequestMapping(value = "routes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public PageInfo<SysRoutes> routes(SysRoutes sysRoutes,@RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int rows) throws BizException {
		List<SysRoutes> routesList = iRoutesService.routes(sysRoutes, page, rows);
		return new PageInfo<SysRoutes>(routesList);
	}
	
	@RequestMapping(value = "addRoutes", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String addRoutes(@RequestBody SysRoutes sysRoutes) throws BizException {
		String message = iRoutesService.addRoutes(sysRoutes);
		return message;
	}
	
	@RequestMapping(value = "delRoutes", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String delRoutes(@RequestBody SysRoutes sysRoutes) throws BizException {
		String message = iRoutesService.delRoutes(sysRoutes);
		return message;
	}
	
	@RequestMapping(value = "editRoutes", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String editRoutes(@RequestBody SysRoutes sysRoutes) throws BizException {
		String message = iRoutesService.editRoutes(sysRoutes);
		return message;
	}
}
