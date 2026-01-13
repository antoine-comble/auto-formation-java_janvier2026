package com.zenika.bowling;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameRecursiveTest {

    @Test
    public void au_debut_de_la_partie_score_0_recursive() {
        // Given
        Game game = new Game();
        // When
        int score = game.score(0, game.frames, game.frames.size() - 1);
        // Then
        Assertions.assertThat(score).isEqualTo(0);
    }

    @Test
    public void dix_parties_recursive() {
        // Given
        Game game = new Game();
        // When
        game.roll(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        int score = game.score(0, game.frames, game.frames.size() - 1);
        // Then
        Assertions.assertThat(score).isEqualTo(20);
    }

    @Test
    public void dix_parties_without_extra_ball_recursive() {
        // Given
        Game game = new Game();
        // When
        game.roll(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 6);
        int score = game.score(0, game.frames, game.frames.size() - 1);
        // Then
        Assertions.assertThat(score).isEqualTo(26);
    }

    @Test
    public void dix_parties_avec_spare_au_debut_recursive() {
        // Given
        Game game = new Game();
        // When
        game.roll(1, 9, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        int score = game.score(0, game.frames, game.frames.size() - 1);
        // Then
        Assertions.assertThat(score).isEqualTo(29);
    }

    @Test
    public void test_score_7_strikes_recursive() {
        // Given
        Game game = new Game();
        // When
        game.roll(10, 10, 10, 10, 10, 10, 10, 0, 0, 0, 0, 0, 0);
        int score = game.score(0, game.frames, game.frames.size() - 1);
        // Then
        Assertions.assertThat(score).isEqualTo(180);
    }

    @Test
    public void test_score_1_spare_recursive() {
        // Given
        Game game = new Game();
        // When
        game.roll(5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        int score = game.score(0, game.frames, game.frames.size() - 1);
        // Then
        Assertions.assertThat(score).isEqualTo(10);
    }

    @Test
    public void test_score_5_spare_non_identiques_recursive() {
        // Given
        Game game = new Game();
        // When
        game.roll(1, 9, 2, 8, 3, 7, 4, 6, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        int score = game.score(0, game.frames, game.frames.size() - 1);
        // Then
        Assertions.assertThat(score).isEqualTo(64);
    }

    @Test
    public void test_score_6_spare_recursive() {
        // Given
        Game game = new Game();
        // When
        game.roll(5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0);
        int score = game.score(0, game.frames, game.frames.size() - 1);
        // Then
        Assertions.assertThat(score).isEqualTo(85);
    }

    @Test
    public void test_score_7_spare_identiques_recursive() {
        // Given
        Game game = new Game();
        // When
        game.roll(5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0, 0, 0, 0, 0, 0);
        int score = game.score(0, game.frames, game.frames.size() - 1);
        // Then
        Assertions.assertThat(score).isEqualTo(100);
    }

    @Test
    public void dix_parties_avec_que_des_strikes_recursive() {
        // Given
        Game game = new Game();
        // When
        game.roll(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
        int score = game.score(0, game.frames, game.frames.size() - 1);
        // Then
        Assertions.assertThat(score).isEqualTo(300);
    }

    @Test
    public void dix_parties_avec_que_des_spares_recursive() {
        // Given
        Game game = new Game();
        // When
        game.roll(5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5);
        int score = game.score(0, game.frames, game.frames.size() - 1);
        // Then
        Assertions.assertThat(score).isEqualTo(150);
    }

    @Test
    public void un_coup_normal_recursive() {
        // Given
        Game game = new Game();
        // When
        game.roll(3, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        int score = game.score(0, game.frames, game.frames.size() - 1);
        // Then
        Assertions.assertThat(score).isEqualTo(9);
    }

    @Test
    public void un_coup_spare_recursive() {
        // Given
        Game game = new Game();
        // When
        game.roll(4, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        int score = game.score(0, game.frames, game.frames.size() - 1);
        // Then
        Assertions.assertThat(score).isEqualTo(10);
    }

    @Test
    public void deux_coups_spare_recursive() {
        // Given
        Game game = new Game();
        // When
        game.roll(4, 6, 2, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        int score = game.score(0, game.frames, game.frames.size() - 1);
        // Then
        Assertions.assertThat(score).isEqualTo(22);
    }

}
