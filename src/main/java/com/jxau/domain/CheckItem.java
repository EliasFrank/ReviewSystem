package com.jxau.domain;

public class CheckItem {
    private int itemId;
    private int  gameId;
    private int userId;
    private String gameName;
    private String itemName;
    private String userName;

    @Override
    public String toString() {
        return "CheckItem{" +
                "itemId=" + itemId +
                ", gameId=" + gameId +
                ", userId=" + userId +
                ", gameNmae='" + gameName + '\'' +
                ", itemName='" + itemName + '\'' +
                ", userName='" + userName + '\'' +
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

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
}
