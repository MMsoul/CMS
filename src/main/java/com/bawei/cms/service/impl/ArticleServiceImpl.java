package com.bawei.cms.service.impl;

import com.bawei.cms.domain.Article;
import com.bawei.cms.dao.ArticleMapper;
import com.bawei.cms.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
