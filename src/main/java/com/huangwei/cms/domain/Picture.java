package com.huangwei.cms.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("cms_picture")
public class Picture {

	@TableField("id")
	private Integer id;
	
	@TableField("path")
	private String path;
	
	@TableField("desc")
	private String desc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "Picture [id=" + id + ", path=" + path + ", desc=" + desc + "]";
	}
	
}
