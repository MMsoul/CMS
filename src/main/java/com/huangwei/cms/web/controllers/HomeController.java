package com.huangwei.cms.web.controllers;

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
import com.huangwei.cms.domain.Article;
import com.huangwei.cms.domain.Category;
import com.huangwei.cms.domain.Channel;
import com.huangwei.cms.service.IArticleService;
import com.huangwei.cms.service.ICategoryService;
import com.huangwei.cms.service.IChannelService;
import com.huangwei.cms.vo.ArticleVo;
import com.huangwei.web.Constant;

/**
 * CMS首页控制器
 * 
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
	 * 
	 * @return
	 */
	@GetMapping({ "/", "/index", "/home" })
	public ModelAndView showHomePageView(@RequestParam(required = false, value = "channel") Integer channelId,
			@RequestParam(required = false, value = "category") Integer categoryId) {
		ModelAndView mav = new ModelAndView("home");

		// 获得所有频道
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				List<Map<Channel, List<Category>>> channelsAndCategories = new ArrayList<>();

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
				// TODO Auto-generated method stub

				// 获得最新文章
				List<ArticleVo> articles = articleService.listArticlesByCateId(categoryId);

				mav.addObject("articles", articles);
			}
		});
		t2.start();
		// 获得文章列表

		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
}
