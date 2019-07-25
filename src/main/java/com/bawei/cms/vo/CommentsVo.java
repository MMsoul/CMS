package com.bawei.cms.vo;

import com.bawei.cms.domain.Article;
import com.bawei.cms.domain.Comments;

public class CommentsVo extends Comments {
	private Article article;

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
	
}
