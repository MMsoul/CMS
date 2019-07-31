package com.huangwei.cms.vo;

import com.huangwei.cms.domain.Article;
import com.huangwei.cms.domain.Comments;

public class CommentsVo extends Comments {
	private Article article;

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
	
}
