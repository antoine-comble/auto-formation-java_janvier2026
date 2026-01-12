package com.zenika.bowling;

import java.util.Optional;

public class LastFrame implements Frame {
    Optional<Integer> firstRoll = Optional.empty();
    Optional<Integer> secondRoll = Optional.empty();
    Optional<Integer> thirdRoll = Optional.empty();

    int totalScore = 0;

    @Override
    public Game.RecursiveScore score(Game.RecursiveScore nextScore) {
        return null;
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
        } else if (thirdRoll.isEmpty()) {
            thirdRoll = Optional.of(score);
        }
    }

    public int score() {
        return firstRoll.orElseGet(() -> 0) + secondRoll.orElseGet(() -> 0) + thirdRoll.orElseGet(() -> 0);
    }

    /** Special case
     * If first roll is strike, we can have a second roll
     * If second roll is also strike, we can have a third roll
     * If first roll is not strike, we can have a second roll
     * If first roll is not strike, and second roll made a spare, we can have a third roll
     * @param score
     * @return
     */
    @Override
    public boolean accept(int score) {
        if(firstRoll.isEmpty()) {
            return true;
        } else {
            if(secondRoll.isEmpty()) {
                return true;
            } else {
                int first = firstRoll.get();
                int second = secondRoll.get();
                if(thirdRoll.isEmpty()) {
                    // Two strikes!
                    if(first==10 && second==10) {
                        return true;
                        // One spare
                    } else if(first+second==10) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    // We have a third roll, so game is over!
                    return false;
                }
            }
        }
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getTotalScore() {
        return totalScore;
    }
}
