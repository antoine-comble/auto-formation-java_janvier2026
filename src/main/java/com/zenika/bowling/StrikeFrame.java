package com.zenika.bowling;

import java.util.Optional;

public class StrikeFrame implements Frame{
    Optional<Integer> singleRoll = Optional.empty();

    public int totalScore = 0;

    @Override
    public Game.RecursiveScore score(Game.RecursiveScore nextScore) {
        return new Game.RecursiveScore(
                nextScore.score() + score() + nextScore.currentScore() + nextScore.nextScore()
                , score(), nextScore.currentScore(), nextScore.nextScore());
    }

    /**
     * Add score
     *
     * @param score
     */
    public void roll(int score) {
        // Pas de premier score, donc on en met un
        if (score == 10 && singleRoll.isEmpty()) {
            singleRoll = Optional.of(score);
        }
    }

    public int score() {
        return singleRoll.orElseGet(() -> 0);
    }

    @Override
    public boolean accept(int score) {
        return singleRoll.isEmpty();
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
}
