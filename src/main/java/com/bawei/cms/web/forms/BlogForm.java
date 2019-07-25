package com.bawei.cms.web.forms;

import com.bawei.cms.domain.Category;

public class BlogForm {
	private Integer id;
	private String title;
	private String content;
	private String summary;
	private Category category;
	private String cover;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	@Override
	public String toString() {
		return "BlogForm [id=" + id + ", title=" + title + ", content=" + content + ", summary=" + summary
				+ ", category=" + category + ", cover=" + cover + "]";
	}
	
	
	
	
	
	
}
