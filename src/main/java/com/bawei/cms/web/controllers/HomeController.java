package com.bawei.cms.web.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bawei.cms.domain.Article;
import com.bawei.cms.domain.Category;
import com.bawei.cms.domain.Channel;
import com.bawei.cms.service.IArticleService;
import com.bawei.cms.service.ICategoryService;
import com.bawei.cms.service.IChannelService;
import com.bawei.cms.vo.ArticleVo;
import com.bawei.web.Constant;

/**
 * CMS首页控制器
 * @author zhaoming.li
 *
 */
@Controller
public class HomeController {
	
	@Autowired
	private IArticleService articleService;
	
	@Autowired
	private IChannelService channelService;
	
	@Autowired
	private ICategoryService categoryService;
	
	/**
	 * 获得CMS系统首页
	 * @return
	 */
	@GetMapping({"/","/index","/home"})
	public ModelAndView showHomePageView(@RequestParam(required=false, value="channel") Integer channelId,
			@RequestParam(required=false, value="category") Integer categoryId) {
		ModelAndView mav = new ModelAndView("home");
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				List<Map<Channel, List<Category>>> channelsAndCategories = new ArrayList<>();
				// 获得所有频道
				List<Channel> channels = channelService.list();
				
				for (Channel temp : channels) {
					QueryWrapper<Category> queryWrapper = new QueryWrapper<Category>();
					queryWrapper.eq("channel_id", temp.getId());
					List<Category> categories = categoryService.list(queryWrapper);
					
					Map<Channel, List<Category>> map = new HashMap<>();
					
					map.put(temp, categories);
					channelsAndCategories.add(map);
				}
				
				mav.addObject(Constant.CHANNELS_AND_CATEGORIES, channelsAndCategories);
				
				if (channelId != null) {
					Channel target = channelService.getById(channelId);
					mav.addObject("channel", target);
				}
			}
		});
		
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {				
				List<ArticleVo> articles = articleService.listArticlesByCateId(categoryId);
				
				mav.addObject("articles", articles);
			}
		});
		
		t2.start();
		
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				QueryWrapper queryWrapper = new QueryWrapper();
				queryWrapper.orderByDesc("created");
				Page<Article> page = new Page<Article>(0, 10);
				List<Article> lastArticles = (List<Article>) (articleService.page(page, queryWrapper).getRecords());
				mav.addObject("lastArticles", lastArticles);
			}
		});
		
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mav;
	}
}
