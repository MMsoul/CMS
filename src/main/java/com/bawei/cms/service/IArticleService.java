package com.bawei.cms.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bawei.cms.domain.Article;
import com.bawei.cms.vo.ArticleVo;

/**
 * <p>
 * 文章表 服务类
 * </p>
 *
 * @author bawei
 * @since 2019-07-21
 */
public interface IArticleService extends IService<Article> {

	List<ArticleVo> listArticlesByUserId(Integer userId);
	
	ArticleVo findArticleById(Integer id);

	List<ArticleVo> listArticlesByCateId(Integer categoryId);

}
