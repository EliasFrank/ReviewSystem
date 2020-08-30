package com.jxau.domain;

public class GradeRank {
    private String itemName;
    private String userName;
    private double grade;
    private int rank;

    @Override
    public String toString() {
        return "GradeRank{" +
                "itemName='" + itemName + '\'' +
                ", userName='" + userName + '\'' +
                ", grade=" + grade +
                ", rank=" + rank +
                '}';
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

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
