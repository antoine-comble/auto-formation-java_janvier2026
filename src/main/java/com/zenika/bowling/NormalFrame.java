package com.zenika.bowling;

import java.util.Optional;

public class NormalFrame implements Frame {
    Optional<Integer> firstRoll = Optional.empty();
    Optional<Integer> secondRoll = Optional.empty();

    int totalScore = 0;

    @Override
    public Game.RecursiveScore score(Game.RecursiveScore nextScore) {
        if (!isSpareFrame()) {
            return new Game.RecursiveScore(
                    nextScore.score() + score(), score(), nextScore.currentScore(), nextScore.nextScore());
        } else {
            return new Game.RecursiveScore(
                    nextScore.score() + score() + nextScore.currentScore(), score(), nextScore.currentScore(), nextScore.nextScore());
        }
    }

    /**
     * Add score
     *
     * @param score
     */
    public void roll(int score) {
        // Pas de premier score, donc on en met un
        if(firstRoll.isEmpty()) {
            firstRoll = Optional.of(score);
        } else if (secondRoll.isEmpty()) {
            // on a un premier score, donc on met dans le deuxième
            secondRoll = Optional.of(score);
        }
    }

    public int score() {
        return firstRoll.orElseGet(() -> 0) + secondRoll.orElseGet(() -> 0);
    }

    @Override
    public boolean accept(int score) {
        return firstRoll.isEmpty() || secondRoll.isEmpty();
    }

    /**
     *
     * @return true if the Frame represents a Spare i.e the player knocks down all 10 pins in two rolls
     */
    public boolean isSpareFrame() {
        return score() == 10;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getTotalScore() {
        return totalScore;
    }
}
