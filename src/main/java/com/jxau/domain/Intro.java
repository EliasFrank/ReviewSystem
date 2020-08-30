package com.jxau.domain;

import java.io.Serializable;

/**
 * 简介型
 * 
 *
 */
public class Intro implements Serializable{
	private int itemId;//作品id
	private String introduce;
	private int introId;//简介id,数据库自增

	public Intro(int itemId, String introduce, int introId) {
		this.itemId = itemId;
		this.introduce = introduce;
		this.introId = introId;
	}


	@Override
	public String toString() {
		return "Intro{" +
				"itemId=" + itemId +
				", introId=" + introId +
				", introduce='" + introduce + '\'' +
				'}';
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getIntroId() {
		return introId;
	}

	public void setIntroId(int introId) {
		this.introId = introId;
	}

	/**
	 * 简介内容字段自行添加
	 */

	public Intro() {
		// TODO Auto-generated constructor stub
	}

}
