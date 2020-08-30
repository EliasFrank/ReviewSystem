package com.jxau.domain;

import java.util.Date;
import java.util.ArrayList;

public class Choose {
    private int userId;
    private String userName;
    private int itemId;
    private String itemName;
    private String gameName;
    private String subTime;

    @Override
    public String toString() {
        return "Choose{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", gameName='" + gameName + '\'' +
                ", subTime=" + subTime +
                '}';
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getSubTime() {
        return subTime;
    }

    public void setSubTime(String subTime) {
        this.subTime = subTime;
    }
}
