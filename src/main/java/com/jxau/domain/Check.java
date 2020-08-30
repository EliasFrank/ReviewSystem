package com.jxau.domain;

public class Check {
    private int id;
    private int userId;
    private int gameId;
    private int itemId;
    private int isCheck;


    @Override
    public String toString() {
        return "Check{" +
                "id=" + id +
                ", userId=" + userId +
                ", gameId=" + gameId +
                ", itemId=" + itemId +
                ", isCheck=" + isCheck +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(int isCheck) {
        this.isCheck = isCheck;
    }
}
