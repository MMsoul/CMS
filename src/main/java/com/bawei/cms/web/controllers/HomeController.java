package com.bawei.cms.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * CMS首页控制器
 * @author zhaoming.li
 *
 */
@Controller
public class HomeController {
	
	/**
	 * 获得CMS系统首页
	 * @return
	 */
	@GetMapping({"/","/index","/home"})
	public ModelAndView showHomePageView() {
		ModelAndView mav = new ModelAndView("home");
		
		return mav;
	}
}
