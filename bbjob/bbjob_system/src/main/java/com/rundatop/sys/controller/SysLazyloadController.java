package com.rundatop.sys.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.rundatop.core.exception.BizException;
import com.rundatop.sys.model.SysLazyload;
import com.rundatop.sys.service.ILazyloadService;

@RestController
@RequestMapping("sys")
public class SysLazyloadController {
	@Resource
	private ILazyloadService iLazyloadService;

	@RequestMapping(value = "lazyload", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public PageInfo<SysLazyload> lazyload(SysLazyload sysLazyload,@RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int rows) throws BizException {
		List<SysLazyload> lazyloadList = iLazyloadService.lazyload(sysLazyload, page, rows);
		return new PageInfo<SysLazyload>(lazyloadList);
	}
	
	@RequestMapping(value = "addLazyload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String addLazyload(@RequestBody SysLazyload sysLazyload) throws BizException {
		String message = iLazyloadService.addLazyload(sysLazyload);
		return message;
	}
	
	@RequestMapping(value = "delLazyload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String delLazyload(@RequestBody SysLazyload sysLazyload) throws BizException {
		String message = iLazyloadService.delLazyload(sysLazyload);
		return message;
	}
	
	@RequestMapping(value = "editLazyload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String editLazyload(@RequestBody SysLazyload sysLazyload) throws BizException {
		String message = iLazyloadService.editLazyload(sysLazyload);
		return message;
	}
}
