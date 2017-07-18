package com.rundatop.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.rundatop.sys.mapper.SysLazyloadMapper;
import com.rundatop.sys.model.SysLazyload;
import com.rundatop.sys.service.IFunctionService;
import com.rundatop.sys.service.ILazyloadService;

import tk.mybatis.mapper.entity.Example;
@Service
public class LazyloadServiceImpl implements ILazyloadService{

	@Resource
	private IFunctionService functionService;
	@Resource
	private SysLazyloadMapper sysLazyloadMapper;
	
	@Override
	public List<SysLazyload> lazyload(SysLazyload sysLazyload, int page, int rows) {
		Example example=new Example(SysLazyload.class);
		Example.Criteria criteria= example.createCriteria();
		PageHelper.startPage(page, rows);
		return sysLazyloadMapper.selectByExample(example);
	}
	
	@Override
	public String delLazyload(SysLazyload sysLazyload) {
		try {
			if (sysLazyload.getIds() != null) {
				for (String id : sysLazyload.getIds()) {
					sysLazyloadMapper.deleteByPrimaryKey(Integer.parseInt(id));
				}
			}
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			return "操作失败";
		}
	}
	
	@Override
	public String addLazyload(SysLazyload sysLazyload) {
		try {
			sysLazyloadMapper.insert(sysLazyload);
			return "";
		} catch (Exception e) {
			return "操作失败";
		}
	}
	
	@Override
	public String editLazyload(SysLazyload sysLazyload) {
		if (sysLazyload.getId() == null) 
			return "id不能为空";
		SysLazyload sl = sysLazyloadMapper.selectByPrimaryKey(sysLazyload.getId());
		if (sl == null) 
			return "lazyload不存在";
		
		try {
			sysLazyloadMapper.updateByPrimaryKey(sysLazyload);
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
