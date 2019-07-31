package com.huangwei.cms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huangwei.cms.dao.ArticleMapper;
import com.huangwei.cms.domain.Article;
import com.huangwei.cms.service.IArticleService;
import com.huangwei.cms.vo.ArticleVo;
import com.huangwei.common.utils.AssertUtil;

/**
 * <p>
 * 文章表 服务实现类
 * </p>
 *
 * @author bawei
 * @since 2019-07-21
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

	@Override
	public List<ArticleVo> listArticlesByUserId(Integer userId) {
		
		AssertUtil.assertNotNull(userId, "用户ID不能为空");
		
		List<ArticleVo> articles = baseMapper.listArticleVoByUserId(userId);

		return articles;
	}
	
	@Override
		public ArticleVo findArticleById(Integer id) {
			AssertUtil.assertNotNull(id,"文章ID不能为空");
			
			ArticleVo articleVo = baseMapper.findArticleVoById(id);
			
			return articleVo;
		}

	@Override
	public List<ArticleVo> listArticlesByCateId(Integer categoryId) {
		List<ArticleVo> articles = baseMapper.findArticleVoByCateId(categoryId);
		return articles;
	}

	@Override
	public ArticleVo findArticleAuthorById(Integer articleId) {
		AssertUtil.assertNotNull(articleId,"文章ID不能为空");
		ArticleVo articleVo = baseMapper.findArticleVoAuthorById(articleId);
		return articleVo;
	}

}
