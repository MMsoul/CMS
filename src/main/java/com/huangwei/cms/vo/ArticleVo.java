package com.huangwei.cms.vo;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huangwei.cms.domain.Article;
import com.huangwei.cms.domain.Category;
import com.huangwei.cms.domain.Channel;
import com.huangwei.cms.domain.User;

public class ArticleVo extends Article {
	private Category category;
	private Channel channel;
	private User author;
	
	// 用于封装图片文章内容的列表
	private List<ImageArticle> imgArticles;
	
	public List<ImageArticle> getImgArticles() {
		return imgArticles;
	}
	public void setImgArticles(List<ImageArticle> imgArticles) {
		this.imgArticles = imgArticles;
	}
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
	
	
	
	
}
