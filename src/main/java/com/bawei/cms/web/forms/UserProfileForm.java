package com.bawei.cms.web.forms;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class UserProfileForm extends UserForm {
	
	private Integer id;
	private String nickname;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNickname() {
		return nickname;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}



	public Date getBirthday() {
		return birthday;
	}



	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}



	@Override
	public String toString() {
		return super.toString() + "\n UserProfileForm [id=" + id + ", nickname=" + nickname + ", birthday=" + birthday + "]";
	}



	
	
	
}
