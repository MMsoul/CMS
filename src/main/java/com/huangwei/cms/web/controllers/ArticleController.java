package com.huangwei.cms.web.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huangwei.cms.domain.Article;
import com.huangwei.cms.domain.Category;
import com.huangwei.cms.domain.Comments;
import com.huangwei.cms.domain.Picture;
import com.huangwei.cms.domain.User;
import com.huangwei.cms.enums.ArticleType;
import com.huangwei.cms.service.IArticleService;
import com.huangwei.cms.service.ICategoryService;
import com.huangwei.cms.vo.ArticleVo;
import com.huangwei.cms.vo.BuinessInfo;
import com.huangwei.cms.vo.ImageArticle;
import com.huangwei.cms.web.forms.BlogForm;
import com.huangwei.cms.web.forms.BlogPicture;
import com.huangwei.common.utils.AssertUtil;
import com.huangwei.common.utils.AssertionException;
import com.huangwei.web.Constant;

/**
 * <p>
 * 文章表 前端控制器
 * </p>
 *
 * @author bawei
 * @since 2019-07-21
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private IArticleService articleService;

	@GetMapping("/{articleId}")
	public ModelAndView showArticle(@PathVariable("articleId") Integer articleId)
			throws JsonParseException, JsonMappingException, IOException {
		ModelAndView mav = new ModelAndView("blog");

		ArticleVo blog = articleService.findArticleAuthorById(articleId);
		//获取图片
		if(blog.getType() !=null ) {
			if(blog.getType() == ArticleType.IMAGE.getOrdinal()) {
				ObjectMapper mapper = new ObjectMapper();
				List<ImageArticle> imgArticles = mapper.readValue(blog.getContent(), List.class);
				blog.setImgArticles(imgArticles);
			}
		}else {
			blog.setType(0);
		}
		Comments comments = null;
		
		Article hitBlogs = null;

		mav.addObject("blog", blog);
		mav.addObject("comments", comments);
		mav.addObject("hitBlogs", hitBlogs);

		return mav;
	}

	@GetMapping("/editPicture")
	public ModelAndView showPicture(@RequestParam(value = "id", required = false) Integer id) {
		ModelAndView mav = new ModelAndView("user-space/blog_picture");
		BlogForm blog = new BlogForm();
		mav.addObject("blog", blog);
		return mav;
	}

	
	/**
	 * 上传图片
	 * @param session
	 * @param blog
	 * @param file
	 * @param request
	 * @return
	 */
	@PostMapping("/editPictures")
	public ModelAndView addPicture(HttpSession session, @ModelAttribute("blog") BlogForm blog, MultipartFile file,
			HttpServletRequest request) {
		User loginedUser = (User) session.getAttribute(Constant.LOGIN_USER);
		ModelAndView mav = new ModelAndView("redirect:/article/list?userid=" + loginedUser.getId());
		try {
			AssertUtil.assertHasLength(blog.getSummary(), "描述不能为空");
			// 创建图片类
			Article article = new Article();

			article.setId(null);
			article.setChannelId(0);
			article.setTitle(null);
			article.setSummary(blog.getSummary());
			article.setCategoryId(null);
			
			if (file.getSize() != 0) {
				// 获得当前应用部署在服务器上的根路径，它是一个文件系统绝对路径
				String picRealDir = request.getServletContext().getRealPath("/") + Constant.UPLOAD_DIR;

				// 上传工作
				String fileOriginalName = file.getOriginalFilename();
				String fileSuffix = fileOriginalName.substring(fileOriginalName.lastIndexOf("jsp"));
				String newFileName = "" + System.currentTimeMillis() + (Math.random() * 1000 + 1);

				file.transferTo(new File(picRealDir + "/" + newFileName));
				String path = Constant.UPLOAD_DIR + "/" + newFileName;
				ObjectMapper mapper = new ObjectMapper();
				String jsonString = mapper.writeValueAsString(path);
				article.setContent(jsonString);
			}
				article.setUserId(6);
				article.setCreated(new Date());
				article.setUpdated(article.getCreated());
				articleService.saveOrUpdate(article);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return mav;
	}

	@GetMapping("/edit")
	public ModelAndView showArticleEditPage(@RequestParam(value = "id", required = false) Integer id) {
		ModelAndView mav = new ModelAndView("user-space/blog_edit");

		BlogForm blog = new BlogForm();

		if (id != null) {
			ArticleVo articleVo = articleService.findArticleById(id);
			blog.setId(articleVo.getId());
			blog.setTitle(articleVo.getTitle());
			blog.setContent(articleVo.getContent());
			blog.setSummary(articleVo.getSummary());
			blog.setCover(articleVo.getPicture());
			blog.setCategory(articleVo.getCategory());
		}

		List<Category> categories = categoryService.list();

		mav.addObject("blog", blog);
		mav.addObject(Constant.CATEGORIES, categories);

		return mav;
	}

	/**
	 * 上传文章信息
	 * @param blog
	 * @param file
	 * @param session
	 * @param request
	 * @return
	 */
	@PostMapping("/edit")
	public ModelAndView editArticle(@ModelAttribute("blog") BlogForm blog, MultipartFile file, HttpSession session,
			HttpServletRequest request) {

		User loginedUser = (User) session.getAttribute(Constant.LOGIN_USER);
		ModelAndView mav = new ModelAndView("redirect:/article/list?userid=" + loginedUser.getId());

		try {
			AssertUtil.assertHasLength(blog.getTitle(), "标题不能为空");
			AssertUtil.assertHasLength(blog.getContent(), "内容不能为空");
			AssertUtil.assertNotNull(blog.getCategory(), "文章类型不能为空");

			// 取出session中的当前用户id

			Article article = new Article();

			article.setId(null);
			article.setChannelId(0);
			article.setTitle(blog.getTitle());
			article.setContent(blog.getContent());
			article.setSummary(blog.getSummary());
			article.setCategoryId(blog.getCategory().getId());

			if (file.getSize() != 0) {
				// 获得当前应用部署在服务器上的根路径，它是一个文件系统绝对路径
				String picRealDir = request.getServletContext().getRealPath("/") + Constant.UPLOAD_DIR;

				// 上传工作
				String fileOriginalName = file.getOriginalFilename();
				String fileSuffix = fileOriginalName.substring(fileOriginalName.lastIndexOf("."));
				String newFileName = "" + System.currentTimeMillis() + (Math.random() * 1000 + 1) + fileSuffix;

				file.transferTo(new File(picRealDir + "/" + newFileName));
				article.setPicture(Constant.UPLOAD_DIR + "/" + newFileName);
			}

			article.setUserId(loginedUser.getId());

			article.setCreated(new Date());
			article.setUpdated(article.getCreated());

			boolean result = articleService.saveOrUpdate(article);

			AssertUtil.assertTrue(result, "文章发布失败");

		} catch (AssertionException e) {
			mav.addObject("message", e.getMessage());
			mav.setViewName("user-space/blog_edit");
		} catch (Exception e) {
			mav.addObject("message", "文件上传失败");
			mav.setViewName("user-space/blog_edit");
		}

		return mav;
	}

	@GetMapping("/list")
	public ModelAndView showUserArticlesPage(@RequestParam("userid") Integer userId) {
		ModelAndView mav = new ModelAndView("user-space/blog_list");
		if(userId==null) {
			return mav;
		}
		List<ArticleVo> blogs = articleService.listArticlesByUserId(userId);
		mav.addObject("blogs", blogs);

		return mav;
	}

	@GetMapping("/remove")
	@ResponseBody
	public BuinessInfo removeArticle(@RequestParam("id") Integer id) {
		BuinessInfo buinessInfo = new BuinessInfo(true, "删除成功！");

		Article entity = new Article();
		entity.setId(id);
		entity.setDeleted(false);
		boolean result = articleService.updateById(entity);

		if (!result) {
			buinessInfo.setStatus(false);
			buinessInfo.setMessage("删除失败！");
		}

		return buinessInfo;
	}
}
