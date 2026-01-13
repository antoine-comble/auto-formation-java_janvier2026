package com.zenika.bowling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    List<Frame> frames =  new ArrayList<>();

    /**
     * Public api, allowing user to enter one full Bowling game at once
     * @param count
     */
    void roll(int...count) {
        Arrays.stream(count)
                .forEach(this::rollOneShot);
    }

    /**
     * Atomic operation of adding one score to the Game.
     * This should distinguish spare/strike from classical hits
     * @param score
     */
    private void rollOneShot(int score) {
        // Get last frame of frames
        Frame last = getOrCreateFrameFor(score);
        // Replace the last frame with the most suited one
        // roll on the frame
        last.roll(score);
    }

    /**
     * Get current frame f it can receive the score
     * or create a new one if needed, and add the new frame in list
     * @param score
     * @return
     */
    private Frame getOrCreateFrameFor(int score) {
        if(frames.isEmpty()) {
            // We must add a new frame
            frames.add(switch(score) {
                case 10 -> new StrikeFrame();
                default -> new NormalFrame();
            });
        } else if(frames.size()==10) {
            // We do nothing
            if(!frames.getLast().accept(score)) {
                throw new RuntimeException("GAME OVER");
            }
        } else if(frames.size()==9) {
            if(frames.getLast().accept(score)) {
                // The frame can receive the score, we do nothing
            } else {
                // The frame can't receive the score, we have to create one
                frames.add(new LastFrame());
            }
        } else {
            if(frames.getLast().accept(score)) {
                // The frame can receive the score, we do nothing
            } else {
                // The frame can't receive the score, we have to create one
                frames.add(switch(score) {
                    case 10 -> new StrikeFrame();
                    default -> new NormalFrame();
                });
            }
        }
        return frames.getLast();
    }

    int calculateResults() {
        for (int i = 0; i < frames.size(); i++) {
            Frame currentFrame = frames.get(i);

            if (i == 0) {
                calculateFirstFrame(i, currentFrame);
            } else if (i == 9) {
                currentFrame.setTotalScore(currentFrame.score() + frames.get(i - 1).getTotalScore());
            } else {
                if (!(currentFrame instanceof StrikeFrame)
                        && (currentFrame instanceof NormalFrame && !((NormalFrame) currentFrame).isSpareFrame())) {
                    currentFrame.setTotalScore(currentFrame.score() + frames.get(i - 1).getTotalScore());
                }
                if (currentFrame instanceof StrikeFrame && i != 8) {
                    if (frames.get(i + 1) instanceof StrikeFrame) {
                        int internalScore = getInternalScore(i, 1, 2);
                        currentFrame.setTotalScore(frames.get(i - 1).getTotalScore() + currentFrame.score() + frames.get(i + 1).score() + internalScore);
                    } else {
                        currentFrame.setTotalScore(frames.get(i - 1).getTotalScore() + currentFrame.score() + frames.get(i + 1).score());
                    }
                }
                if (currentFrame instanceof StrikeFrame && i == 8) {
                    currentFrame.setTotalScore(frames.get(i - 1).getTotalScore() + currentFrame.score() + frames.get(i + 1).score() - ((LastFrame) frames.get(i + 1)).thirdRoll.orElseGet(() -> 0));
                }
                if ((currentFrame instanceof NormalFrame && ((NormalFrame) currentFrame).isSpareFrame())) {
                    int internalScore = getInternalScore(i, 1, 1);
                    currentFrame.setTotalScore(frames.get(i - 1).getTotalScore() + currentFrame.score() + internalScore);
                }
            }
        }
        return (frames.isEmpty()?0:frames.getLast().getTotalScore());
    }

    private int getInternalScore(int i, int nextRoll, int nextNextRoll) {
        int internalScore = 0;
        if (NormalFrame.class.equals(frames.get(i + nextNextRoll).getClass())) {
            internalScore = ((NormalFrame)frames.get(i + nextNextRoll)).firstRoll.orElseGet(() -> 0);
        } else if (LastFrame.class.equals(frames.get(i + nextNextRoll).getClass())) {
            internalScore = ((LastFrame)frames.get(i + nextNextRoll)).firstRoll.orElseGet(() -> 0);
        } else {
            internalScore = ((StrikeFrame)frames.get(i + nextNextRoll)).singleRoll.orElseGet(() -> 0);
        }
        return internalScore;
    }

    private void calculateFirstFrame(int i, Frame currentFrame) {
        if (!(currentFrame instanceof StrikeFrame)
                && (currentFrame instanceof NormalFrame && !((NormalFrame) currentFrame).isSpareFrame())) {
            currentFrame.setTotalScore(currentFrame.score());
        }
        if (currentFrame instanceof StrikeFrame) {
            if (frames.get(i + 1) instanceof StrikeFrame) {
                currentFrame.setTotalScore(currentFrame.score() + frames.get(i + 1).score() + getInternalScore(i, 1, 2));
            } else {
                currentFrame.setTotalScore(currentFrame.score() + frames.get(i + 1).score());
            }
        }
        if (currentFrame instanceof NormalFrame && ((NormalFrame) currentFrame).isSpareFrame()) {
            currentFrame.setTotalScore(currentFrame.score() + getInternalScore(i, 1, 1));
        }
    }


    /**
     * Computation is in fact reverse
     * @return
     */
    int score(int totalScore, List<Frame> frames, int currentFrameIndex) {
        if (currentFrameIndex == -1) {
            return totalScore;
        }
        int total = totalScore + frames.get(currentFrameIndex).score();
        if (isLastFrame(frames, currentFrameIndex)) {
            // si derniere frame
            return score(total, frames, --currentFrameIndex);
        }
        if (isSpareFrame(frames, currentFrameIndex)) {
            // si spare => total + score courant + premier lancer suivant
            total += switch (frames.get(currentFrameIndex+1)) {
                case NormalFrame nf -> nf.firstRoll.orElse(0);
                case LastFrame lf -> lf.firstRoll.orElse(0);
                case StrikeFrame sf -> sf.singleRoll.orElse(0);
                default -> throw new IllegalStateException("Unexpected value: " + frames.get(currentFrameIndex+1));
            };
            return score(total, frames, --currentFrameIndex);
        }
        if (isStrikeFrame(frames, currentFrameIndex)) {
            if (currentFrameIndex < (frames.size() - 2)) {
                // si strike => total + score courant + score suivant + score suivant suivant
                total += frames.get(currentFrameIndex + 1).score() + frames.get(currentFrameIndex + 2).score();
                return score(total, frames, --currentFrameIndex);
            }
            if (currentFrameIndex == (frames.size() - 2)) {
                return score(total, frames, --currentFrameIndex);
            }
            if (currentFrameIndex < (frames.size() - 1)) {
                // si strike => total + score courant + score suivant
                total += frames.get(currentFrameIndex + 1).score();
                return score(total, frames, --currentFrameIndex);
            }
        }
        // normal frame

        currentFrameIndex = currentFrameIndex - 1;
        return score(total, frames, currentFrameIndex);
    }

    private boolean isStrikeFrame(List<Frame> frames, int currentFrameIndex) {
        return frames.get(currentFrameIndex) instanceof StrikeFrame;
    }

    private static boolean isSpareFrame(List<Frame> frames, int currentFrameIndex) {
        return frames.get(currentFrameIndex) instanceof NormalFrame
                && ((NormalFrame) frames.get(currentFrameIndex)).isSpareFrame();
    }

    private static boolean isLastFrame(List<Frame> frames, int currentFrameIndex) {
        return currentFrameIndex == (frames.size() - 1);
    }
}
