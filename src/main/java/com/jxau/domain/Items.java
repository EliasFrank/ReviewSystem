/**
 * 
 */
package com.jxau.domain;

import java.io.Serializable;

/**
 * 比赛作品信息
 *
 */
public class Items implements Serializable{
	private int itemId;//作品id，数据库自增
	private int gameId;//比赛id
	private int userId;//作品提交用户id
	private int itemflag;//作品类型，分分档型与简介型
	private String submitTime;//作品提交时间
	private String itemName;//作品名字
	private String isSelected;//是否被选择了审核专家

	public Items(int itemId, int gameId, int userId, int itemflag, String submitTime, String itemName, String isSelected) {
		this.itemId = itemId;
		this.gameId = gameId;
		this.userId = userId;
		this.itemflag = itemflag;
		this.submitTime = submitTime;
		this.itemName = itemName;
		this.isSelected = isSelected;
	}

	@Override
	public String toString() {
		return "Items{" +
				"itemId=" + itemId +
				", gameId=" + gameId +
				", userId=" + userId +
				", itemflag=" + itemflag +
				", submitTime='" + submitTime + '\'' +
				", itemName='" + itemName + '\'' +
				", isSelected='" + isSelected + '\'' +
				'}';
	}

	public String getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(String isSelected) {
		this.isSelected = isSelected;
	}

	//更多作品信息字段自行添加
	/**
	 * 
	 */
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getItemflag() {
		return itemflag;
	}
	public void setItemflag(int itemflag) {
		this.itemflag = itemflag;
	}
	public String getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Items() {
		// TODO Auto-generated constructor stub
	}

}
