package com.jxau.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class ResultRank {
    private String itemName;
    private String userName;
    private double grade;
    private int rank;
    private ArrayList<String> opinion;

    @Override
    public String toString() {
        return "ResultRank{" +
                "itemName='" + itemName + '\'' +
                ", userName='" + userName + '\'' +
                ", grade=" + grade +
                ", rank=" + rank +
                ", opinion=" + opinion +
                '}';
    }

    public ArrayList<String> getOpinion() {
        return opinion;
    }

    public void setOpinion(ArrayList<String> opinion) {
        this.opinion = opinion;
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
