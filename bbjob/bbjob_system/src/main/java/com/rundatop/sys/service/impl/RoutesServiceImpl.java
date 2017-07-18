package com.rundatop.sys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.rundatop.sys.mapper.SysFunctionMapper;
import com.rundatop.sys.mapper.SysRoutesMapper;
import com.rundatop.sys.model.SysFunction;
import com.rundatop.sys.model.SysRoutes;
import com.rundatop.sys.service.IFunctionService;
import com.rundatop.sys.service.IRoutesService;

import tk.mybatis.mapper.entity.Example;
@Service
public class RoutesServiceImpl implements IRoutesService{

	@Resource
	private IFunctionService functionService;
	@Resource
	private SysRoutesMapper sysRoutesMapper;
	@Resource
	private SysFunctionMapper sysFunctionMapper;
	
	@Override
	public Map<String, Integer> functionNames(){
		Example ex = new Example(SysFunction.class);
		Example.Criteria criteria= ex.createCriteria();
		List<SysFunction> sfList = sysFunctionMapper.selectByExample(ex);
		HashMap<String, Integer> functionMap = new HashMap<String, Integer>();
		for (SysFunction sf : sfList) {
			functionMap.put(sf.getName(), sf.getId());
		}
		return functionMap;
	}
	
	@Override
	public List<SysRoutes> routes(SysRoutes sysRoutes, int page, int rows) {
		Example example=new Example(SysRoutes.class);
		Example.Criteria criteria= example.createCriteria();
		PageHelper.startPage(page, rows);
		List<SysRoutes> srList = sysRoutesMapper.selectByExample(example);
		for (SysRoutes sr : srList) {
			SysFunction sf = sysFunctionMapper.selectByPrimaryKey(sr.getFunctionId());
			if (sf != null) {
				sr.setFunctionName(sf.getName());
			}
		}
		return srList;
	}
	
	@Override
	public String delRoutes(SysRoutes sysRoutes) {
		try {
			if (sysRoutes.getIds() != null) {
				for (String id : sysRoutes.getIds()) {
					sysRoutesMapper.deleteByPrimaryKey(Integer.parseInt(id));
				}
			}
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			return "操作失败";
		}
	}
	
	@Override
	public String addRoutes(SysRoutes sysRoutes) {
		try {
			sysRoutesMapper.insert(sysRoutes);
			return "";
		} catch (Exception e) {
			return "操作失败";
		}
	}
	
	@Override
	public String editRoutes(SysRoutes sysRoutes) {
		if (sysRoutes.getFunctionId() == null) 
			return "id不能为空";
		SysRoutes sr = sysRoutesMapper.selectByPrimaryKey(sysRoutes.getFunctionId());
		if (sr == null) 
			return "routes不存在";
		
		try {
			sysRoutesMapper.updateByPrimaryKey(sysRoutes);
			return "";
		} catch (Exception e) {
			return "操作失败";
		}
	}
	
	public boolean isNullOrBlank(String str) {
		if (str != null && !StringUtils.isBlank(str)) {
			return false;
		}
		return true;
	}

}
