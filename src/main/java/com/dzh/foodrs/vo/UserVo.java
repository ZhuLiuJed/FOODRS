package com.dzh.foodrs.vo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class UserVo {
	@NotBlank(message = "不能为空")
    @Size(min = 5, message = "最小要5个字符")
	private String username;
	
	@NotBlank(message = "�ǳƲ���Ϊ��")
    @Size(min = 5, message = "��������5���ַ�")
	private String nickname;
	private String password;
	private String rpassword;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRpassword() {
		return rpassword;
	}
	public void setRpassword(String rpassword) {
		this.rpassword = rpassword;
	}
}
