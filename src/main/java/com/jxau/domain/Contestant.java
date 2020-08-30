package com.jxau.domain;

import java.io.Serializable;


public class Contestant implements Serializable{
	private int gameId;//比赛id
	private int userId;//参赛选手id

	@Override
	public String toString() {
		return "Contestant{" +
				"gameId=" + gameId +
				", userId=" + userId +
				'}';
	}

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
	public Contestant() {
		// TODO Auto-generated constructor stub
	}

}
