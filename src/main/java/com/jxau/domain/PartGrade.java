/**
 * 
 */
package com.jxau.domain;

import java.io.Serializable;

public class PartGrade implements Serializable{
	private int gradeId;//成绩id
	private double partgrade;//部分成绩
	private String partexplain;//成绩打分说明
	private int partflag;//指标分类标识
	private int itemId;
	private int expertId;
	public PartGrade(int gradeId, double partgrade, String partexplain, int partflag, int experId, int itemsId) {
		this.gradeId = gradeId;
		this.partgrade = partgrade;
		this.partexplain = partexplain;
		this.partflag = partflag;
		this.expertId = experId;
		this.itemId = itemsId;
	}

	@Override
	public String toString() {
		return "PartGrade{" +
				"partgrade=" + partgrade +
				", partexplain='" + partexplain + '\'' +
				", gradeId=" + gradeId +
				", partflag=" + partflag +
				", itemId=" + itemId +
				", expertId=" + expertId +
				'}';
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getExpertId() {
		return expertId;
	}

	public void setExpertId(int expertId) {
		this.expertId = expertId;
	}

	/**
	 * 
	 */

	public PartGrade() {
		// TODO Auto-generated constructor stub
	}
	public double getPartgrade() {
		return partgrade;
	}
	public void setPartgrade(double partgrade) {
		this.partgrade = partgrade;
	}
	public String getPartexplain() {
		return partexplain;
	}
	public void setPartexplain(String partexplain) {
		this.partexplain = partexplain;
	}
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public int getPartflag() {
		return partflag;
	}
	public void setPartflag(int partflag) {
		this.partflag = partflag;
	}
	

}
