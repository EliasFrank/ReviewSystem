package com.jxau.domain;

import java.io.Serializable;
/**
 * 
 * 项目成绩单
 *
 */

public class Grade implements Serializable{
	private int itemId;//提交的项目id
	private double totalGrade;//根据项目各部分发成绩，综合而得总成绩

	@Override
	public String toString() {
		return "Grade{" +
				"itemId=" + itemId +
				", totalGrade=" + totalGrade +
				", explain='" + explain + '\'' +
				", userId=" + userId +
				", gradeId=" + gradeId +
				", gameId=" + gameId +
				", expertId=" + expertId +
				'}';
	}

	private String explain;

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	private int userId;//用户id
	private int gradeId;//成绩单id,数据库内不能设置，自增
	private int gameId;
	private int expertId;

	public Grade(int itemId, double totalGrade, int userId, int gradeId, int gameId, int expertId) {
		this.itemId = itemId;
		this.totalGrade = totalGrade;
		this.userId = userId;
		this.gradeId = gradeId;
		this.gameId = gameId;
		this.expertId = expertId;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public int getExpertId() {
		return expertId;
	}

	public void setExpertId(int expertId) {
		this.expertId = expertId;
	}

	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public double getTotalGrade() {
		return totalGrade;
	}
	public void setTotalGrade(double totalGrade) {
		this.totalGrade = totalGrade;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public Grade() {
		// TODO Auto-generated constructor stub
	}
	

}
