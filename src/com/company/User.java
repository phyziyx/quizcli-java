package com.company;

public class User {
    private String name;
    private double score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void giveScore() {
        this.score += 1;
    }

    public void takeScore() {
        this.score -= 0.5;
    }
}