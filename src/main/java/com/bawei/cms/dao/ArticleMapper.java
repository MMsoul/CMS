package com.bawei.cms.dao;

import com.bawei.cms.domain.Article;
import com.bawei.cms.vo.ArticleVo;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 文章表 Mapper 接口
 * </p>
 *
 * @author bawei
 * @since 2019-07-21
 */
public interface ArticleMapper extends BaseMapper<Article> {
	List<ArticleVo> listArticleVoByUserId(Integer userid);
	
	ArticleVo findArticleVoById(Integer id);

	List<ArticleVo> findArticleVoByCateId(Integer categoryId);
}
