package com.huangwei.cms.vo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ImageArticle {

	private String path;
	private String desc;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public ImageArticle(String path, String desc) {
		this.path = path;
		this.desc = desc;
	}
	public ImageArticle() {
	}
	@Override
	public String toString() {
		return "ImageArticle [path=" + path + ", desc=" + desc + "]";
	}
	
	public static void main(String[] args) throws JsonProcessingException {
		System.out.println(""+System.currentTimeMillis()+(int)(Math.random()*1000)+1);
		List<ImageArticle> list = new ArrayList();
		list.add(new ImageArticle("/upload/15645335697414531.jpg", "戴尔灵燃4000"));
		list.add(new ImageArticle("/upload/15645335997181641.jpg", "机械革命"));
		list.add(new ImageArticle("/upload/15645336142911811.jpg", "外星人笔记本"));
		ObjectMapper mapper = new ObjectMapper();
		String writeValueAsString = mapper.writeValueAsString(list);
		System.out.println(writeValueAsString);
	}
	
}
