package com.jxau.domain;

import java.io.Serializable;


public class Document implements Serializable{
	private int itemId;//作品id
	private String path;//作品存放路径
	private String introduce;
	private int documentId;
	private int decumentflag;//文件类型，如word,png

	public Document(int itemId, String path, String introduce, int documentId, int decumentflag) {
		this.itemId = itemId;
		this.path = path;
		this.introduce = introduce;
		this.documentId = documentId;
		this.decumentflag = decumentflag;
	}

	@Override
	public String toString() {
		return "Document{" +
				"itemId=" + itemId +
				", path='" + path + '\'' +
				", documentId=" + documentId +
				", decumentflag=" + decumentflag +
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
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getDocumentId() {
		return documentId;
	}
	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}
	public int getDecumentflag() {
		return decumentflag;
	}
	public void setDecumentflag(int decumentflag) {
		this.decumentflag = decumentflag;
	}
	public Document() {
		// TODO Auto-generated constructor stub
	}

}
