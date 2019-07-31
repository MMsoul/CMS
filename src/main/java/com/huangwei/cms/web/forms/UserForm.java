package com.huangwei.cms.web.forms;

import java.io.Serializable;

import com.huangwei.cms.enums.Gender;

public class UserForm implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7832486605796892880L;

	private String username;
	
	private String password;
	
	private String rePassword;
	
	private Gender gender;
	
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "UserForm [username=" + username + ", password=" + password + ", rePassword=" + rePassword + ", gender="
				+ gender + ", url=" + url + "]";
	}

	
}
