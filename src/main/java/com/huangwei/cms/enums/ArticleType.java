/**
 * 
 */
package com.huangwei.cms.enums;

/**
 * 说明:文章类型
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年3月16日 上午8:05:23
 */
public enum ArticleType {

	HTML("文本"),
	IMAGE("图文");
	
	private String description;
	
	private ArticleType(String description){
		this.description = description;
	}
	
	public String getName(){
		return name();
	}
	
	public String getDescription() {
		return description;
	}

	public int getOrdinal(){
		return this.ordinal();
	}
	
}
