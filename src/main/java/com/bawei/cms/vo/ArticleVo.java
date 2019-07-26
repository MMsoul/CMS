package com.bawei.cms.vo;

import java.util.List;

import com.bawei.cms.domain.Article;
import com.bawei.cms.domain.Category;
import com.bawei.cms.domain.Channel;
import com.bawei.cms.domain.User;

public class ArticleVo extends Article {
	private Category category;
	private Channel channel;
	private User author;
	// 用户评论内容，还没有实现
	private List comments;
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
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public List getComments() {
		return comments;
	}
	public void setComments(List comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return super.toString()+"\n ArticleVo [category=" + category + ", channel=" + channel + ", comments=" + comments + "]";
	}

	
	
	
}
