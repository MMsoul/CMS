package com.bawei.cms.vo;

import java.util.List;

import com.bawei.cms.domain.Article;
import com.bawei.cms.domain.Category;
import com.bawei.cms.domain.Channel;

public class ArticleVo extends Article {
	private Category category;
	private Channel channel;
	
	// 用户评论内容，还没有实现
	private List comments;

	

	public List getComments() {
		return comments;
	}

	public void setComments(List comments) {
		this.comments = comments;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	@Override
	public String toString() {
		return super.toString()+"\n ArticleVo [category=" + category + ", channel=" + channel + "]";
	}
	
	
}
