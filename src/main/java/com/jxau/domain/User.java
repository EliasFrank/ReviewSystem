/**
 *
 */
package com.jxau.domain;

import java.io.Serializable;

/**
 *用户信息
 *
 */
public class User implements Serializable{
	private String userId;//用户id,数据库内不能添加，自增
	private String number;//用户的工号/学号
	private String password;//用户密码
	private int userflag;//用户标识
	private String email; //用户邮箱
	private String name;//姓名
	private String tel;//电话号码

	public User(String userId, String number, String password, int userflag, String email, String name, String tel) {
		this.userId = userId;
		this.number = number;
		this.password = password;
		this.userflag = userflag;
		this.email = email;
		this.name = name;
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "User{" +
				"number='" + number + '\'' +
				", password='" + password + '\'' +
				", userId='" + userId + '\'' +
				", email='" + email + '\'' +
				", name='" + name + '\'' +
				", tel='" + tel + '\'' +
				", userflag=" + userflag +
				'}';
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getUserflag() {
		return userflag;
	}
	public void setUserflag(int userflag) {
		this.userflag = userflag;
	}
	/**
	 * 
	 */
	public User() {
		// TODO Auto-generated constructor stub
	}

}
