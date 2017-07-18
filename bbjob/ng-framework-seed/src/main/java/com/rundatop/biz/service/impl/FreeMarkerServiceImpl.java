package com.rundatop.biz.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rundatop.biz.service.FreeMarkerService;
import com.rundatop.sys.dto.SysUser;
import com.rundatop.sys.mapper.SysFunctionMapper;
import com.rundatop.sys.mapper.SysLazyloadMapper;
import com.rundatop.sys.mapper.SysRoleFunctionMapper;
import com.rundatop.sys.mapper.SysRoutesMapper;
import com.rundatop.sys.mapper.SysUserFunctionMapper;
import com.rundatop.sys.mapper.SysUserRoleMapper;
import com.rundatop.sys.model.SysFunction;
import com.rundatop.sys.model.SysLazyload;
import com.rundatop.sys.model.SysRoleFunction;
import com.rundatop.sys.model.SysRoutes;
import com.rundatop.sys.model.SysUserFunction;
import com.rundatop.sys.model.SysUserRole;

import freemarkerUtil.FreeMarkerUtil;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class FreeMarkerServiceImpl implements FreeMarkerService{
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	@Autowired
	private SysRoleFunctionMapper sysRoleFunctionMapper;
	@Autowired
	private SysUserFunctionMapper sysUserFunctionMapper;
	@Autowired
	private SysFunctionMapper sysFunctionMapper;
	@Autowired
	private SysRoutesMapper sysRoutesMapper;
	@Autowired
	private SysLazyloadMapper sysLazyloadMapper;
	@Override
	public String getRoutes(SysUser user) {
		//1.筛选用户权限所对应的功能菜单， 默认超管拥有所有权限 type=-1
		Example sfEx = new Example(SysFunction.class);
		if (user.getUserType() != -1) {
			Criteria sfCr = sfEx.createCriteria();
			List<Integer> functionIds = new ArrayList<Integer>();
			functionIds.addAll(getFunctionIdsFromUserRole(user));
			functionIds.addAll(getFunctionIdsFromUserFunctions(user));
			sfCr.andIn("id", functionIds);
		}
		List<SysFunction> sfList = sysFunctionMapper.selectByExample(sfEx);
		
		//2.拼接routes.config.js定制部分
		String customRoutes = getCustomRoutesStr(sfList);

		//返回routes.config.js
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("customRoutes", customRoutes);
		FreeMarkerUtil fmu = new FreeMarkerUtil();
		return fmu.print("routes.ftl", root);
	}
	
	/**
	 * 根据userid从sysuserfunction中获取functionId
	 * @param user
	 * @return
	 */
	public List<Integer> getFunctionIdsFromUserRole(SysUser user){
		List<Integer> roleIds = new ArrayList<Integer>();
		List<Integer> functionIds = new ArrayList<Integer>();
		Example surEx = new Example(SysUserRole.class);
		Criteria surCr = surEx.createCriteria();
		surCr.andEqualTo("userId", user.getUserId());
		List<SysUserRole> surList = sysUserRoleMapper.selectByExample(surEx);
		for (SysUserRole sysUserRole : surList) {
			roleIds.add(sysUserRole.getRoleId());
		}
		//根据userId对应的roleId筛选function
		Example srfEx = new Example(SysRoleFunction.class);
		Criteria srfCr = srfEx.createCriteria();
		if (roleIds.size() > 0) {
			srfCr.andIn("roleId", roleIds);
		}
		List<SysRoleFunction> srfList = sysRoleFunctionMapper.selectByExample(srfEx);
		for (SysRoleFunction sysRoleFunction : srfList) {
			functionIds.add(sysRoleFunction.getFunctionId());
		}
		return functionIds;
	}
	
	/**
	 * 根据userid从sysuserfunction中获取functionId
	 * @param user
	 * @return
	 */
	public List<Integer> getFunctionIdsFromUserFunctions(SysUser user){
		List<Integer> functionIds = new ArrayList<Integer>();
		//根据userId对应的roleId筛选function
		Example sufEx = new Example(SysUserFunction.class);
		Criteria sufCr = sufEx.createCriteria();
		List<SysUserFunction> sufList = sysUserFunctionMapper.selectByExample(sufEx);
		for (SysUserFunction SysUserFunction : sufList) {
			functionIds.add(SysUserFunction.getFunctionId());
		}
		return functionIds;
	}

	/**
	 * 
	 * @return
	 */
	public String getCustomRoutesStr(List<SysFunction> sfList){
		StringBuilder sb = new StringBuilder();
		for (SysFunction sysFunction : sfList) {
			SysRoutes sysRoutes = sysRoutesMapper.selectByPrimaryKey(sysFunction.getId());
			if (sysRoutes == null) 
				continue;
			
			//routeName
			if (!isNullOrBlank(sysRoutes.getStateName())) {
				sb.append(".state(\'"+ sysRoutes.getStateName() + "\', {");
			} else {
				continue;
			}
			
			//url
			if (!isNullOrBlank(sysRoutes.getStateUrl())) {
				sb.append("url: \'"+ sysRoutes.getStateUrl() + "\',");
			}
			
			//title
			if (!isNullOrBlank(sysRoutes.getStateTitle())) {
				sb.append("title: \'"+ sysRoutes.getStateTitle() + "\',");
			}
			
			//controller
			if (!isNullOrBlank(sysRoutes.getControllerName())) {
				sb.append("controller: \'"+ sysRoutes.getControllerName() + "\',");
			}
			
			//controllerAs
			if (!isNullOrBlank(sysRoutes.getControllerNameAs())) {
				sb.append("controllerAs: \'"+ sysRoutes.getControllerNameAs() + "\',");
			}			
			
			//templateUrl
			if (!isNullOrBlank(sysRoutes.getTemplateurl())) {
				sb.append("templateUrl: helper.basepath("+ sysRoutes.getTemplateurl() + "),");
			}
			
			//resolve
			if (!isNullOrBlank(sysRoutes.getResolve())) {
				sb.append("resolve: helper.resolveFor("+ sysRoutes.getResolve() + "),");
			}
			
			//end 去掉多余的逗号
			sb.delete(sb.length()-1, sb.length());
			sb.append("})");
		}
		return sb.toString();
	}
	
	public boolean isNullOrBlank(String str) {
		if (str != null && !StringUtils.isBlank(str)) {
			return false;
		}
		return true;
	}

	@Override
	public String getLazyload() {
		
		Example ex = new Example(SysLazyload.class);
//		ex.createCriteria();
		List<SysLazyload> slList = sysLazyloadMapper.selectByExample(ex);
		//1.拼接lazyload.constants.js定制部分
		String customLazyload = getCustomLazyloadStr(slList);

		//返回routes.config.js
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("customLazyload", customLazyload);
		FreeMarkerUtil fmu = new FreeMarkerUtil();
		return fmu.print("lazyload.ftl", root);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getCustomLazyloadStr(List<SysLazyload> slList){
		StringBuilder sb = new StringBuilder();
		for (SysLazyload sysLazyload : slList) {
			if (isNullOrBlank(sysLazyload.getName())) 
				continue;
			//name
			sb.append("{name : \'"+ sysLazyload.getName() + "\', ");
			//files
			if (!isNullOrBlank(sysLazyload.getFiles())) {
				sb.append("files: ["+ sysLazyload.getFiles() + "]},");
			}
		}
		//end 去掉多余的逗号
		sb.delete(sb.length()-1, sb.length());
		return sb.toString();
	}
}
