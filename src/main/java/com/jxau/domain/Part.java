package com.jxau.domain;

public class Part {
    private int id;
    private String explain;
    private int gameId;
    private double grade;

    public Part(){}

    public Part(int id, String explain, int gameId, double grade) {
        this.id = id;
        this.explain = explain;
        this.gameId = gameId;
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Part{" +
                "id=" + id +
                ", explain='" + explain + '\'' +
                ", gameId=" + gameId +
                ", grade=" + grade +
                '}';
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }
}
