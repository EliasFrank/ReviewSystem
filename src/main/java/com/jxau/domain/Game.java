package com.jxau.domain;

import java.io.Serializable;
import java.sql.Date;

public class Game implements Serializable{
	private int gameId;
	private String gameName;//比赛名字
	private String welcome;//欢迎标语
	private String type;//项目类型
	private String introduction;
	private String annex;//附件地址
	private Date startTime;//起始日期
	private Date endTime;// 截止日期

	public Game(int gameId, String gameName, String welcome, String type, String introduction, String annex, Date startTime, Date endTime) {
		this.gameId = gameId;
		this.gameName = gameName;
		this.welcome = welcome;
		this.type = type;
		this.introduction = introduction;
		this.annex = annex;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Game{" +
				"gameId=" + gameId +
				", gameName='" + gameName + '\'' +
				", welcome='" + welcome + '\'' +
				", type='" + type + '\'' +
				", introduction='" + introduction + '\'' +
				", annex='" + annex + '\'' +
				", startTime=" + startTime +
				", endTime=" + endTime +
				'}';
	}

	//更多赛事信息字段自行添加
	public Game() {
		// TODO Auto-generated constructor stub
	}
	public String getWelcome() {
		return welcome;
	}
	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getAnnex() {
		return annex;
	}

	public void setAnnex(String annex) {
		this.annex = annex;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
