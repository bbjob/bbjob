package com.rundatop.biz.boardModel.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.rundatop.security.base.controller.SecurityController;

@RestController
@RequestMapping("zhuanti")
public class GenerateTemp extends SecurityController{
	
	@RequestMapping(value="/{ftlName}",method=RequestMethod.GET)
	public ModelAndView model(@PathVariable String ftlName) {
		
		ModelAndView mv = new ModelAndView(ftlName + "/" + ftlName);
		
		return mv;
	}

}
