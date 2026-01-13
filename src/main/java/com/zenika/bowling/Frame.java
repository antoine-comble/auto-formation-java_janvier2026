package com.zenika.bowling;

public interface Frame {

    void roll(int score);

    int score();

    boolean accept(int score);

    int getTotalScore();

    void setTotalScore(int totalScore);
}
