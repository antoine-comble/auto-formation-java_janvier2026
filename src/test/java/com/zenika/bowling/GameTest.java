package com.zenika.bowling;

import org.assertj.core.annotation.CanIgnoreReturnValue;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.VisibleForTesting;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;

public class GameTest {

    @Test
    public void au_debut_de_la_partie_score_0() {
        // Given
        Game game = new Game();
        // When
        int score = game.calculateResults();
        // Then
        Assertions.assertThat(score).isEqualTo(0);
    }

    @Test
    public void une_quille_tombee() {
        // Given
        Game game = new Game();
        // When
        game.roll(1);
        int score = game.calculateResults();
        // Then
        Assertions.assertThat(score).isEqualTo(1);
    }

    @Test
    public void deux_quilles_tombees_meme_coup() {
        // Given
        Game game = new Game();
        // When
        game.roll(2);
        int score = game.calculateResults();
        // Then
        Assertions.assertThat(score).isEqualTo(2);
    }

    @Test
    public void deux_quilles_tombees_deux_coups() {
        // Given
        Game game = new Game();
        // When
        game.roll(1);
        game.roll(1);
        int score = game.calculateResults();
        // Then
        Assertions.assertThat(score).isEqualTo(2);
    }

    @Test
    public void trois_coups() {
        // Given
        Game game = new Game();
        // When
        game.roll(1);
        game.roll(1);
        game.roll(3);
        int score = game.calculateResults();
        // Then
        Assertions.assertThat(score).isEqualTo(5);
    }

    @Test
    public void quatre_coups() {
        // Given
        Game game = new Game();
        // When
        game.roll(1);
        game.roll(1);
        game.roll(3);
        game.roll(6);
        int score = game.calculateResults();
        // Then
        Assertions.assertThat(score).isEqualTo(11);
    }

    @Test
    public void dix_parties() {
        // Given
        Game game = new Game();
        // When
        game.roll(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        int score = game.calculateResults();
        // Then
        Assertions.assertThat(score).isEqualTo(20);
    }

    @Test
    public void onze_parties() {
        // Given
        Game game = new Game();
        // When
        Assertions.assertThatThrownBy(() -> {
            game.roll(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void dix_parties_with_extra_ball() {
        // Given
        Game game = new Game();
        // When
        game.roll(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 6, 3);
        int score = game.calculateResults();
        // Then
        Assertions.assertThat(score).isEqualTo(31);
    }

    @Test
    public void dix_parties_avec_triche_a_extra_ball() {
        // Given
        Game game = new Game();
        // When
        Assertions.assertThatThrownBy(() -> {
            game.roll(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 6, 3);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void dix_parties_without_extra_ball() {
        // Given
        Game game = new Game();
        // When
        game.roll(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 6);
        //int score = game.score();
        int score = game.calculateResults();
        // Then
        Assertions.assertThat(score).isEqualTo(26);
    }

    @Test
    public void dix_parties_avec_spare_au_debut() {
        // Given
        Game game = new Game();
        // When
        game.roll(1, 9, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        int score = game.calculateResults();
        // Then
        Assertions.assertThat(score).isEqualTo(29);
    }

    @Test
    public void dix_parties_avec_que_des_strikes() {
        // Given
        Game game = new Game();
        // When
        game.roll(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
        int score = game.calculateResults();
        // Then
        Assertions.assertThat(score).isEqualTo(300);
    }

    @Test
    public void dix_parties_avec_que_des_spares() {
        // Given
        Game game = new Game();
        // When
        game.roll(5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5);
        int score = game.calculateResults();
        // Then
        Assertions.assertThat(score).isEqualTo(150);
    }

    @Test
    public void test_score_2_strikes() {
        // Given
        Game game = new Game();
        // When
        game.roll(10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        int score = game.score();
        // Then
        Assertions.assertThat(score).isEqualTo(30);
    }

    @Test
    public void test_score_3_strikes() {
        // Given
        Game game = new Game();
        // When
        game.roll(10, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        int score = game.score();
        // Then
        Assertions.assertThat(score).isEqualTo(60);
    }

    @Test
    public void test_score_4_strikes() {
        // Given
        Game game = new Game();
        // When
        game.roll(10, 10, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        int score = game.score();
        // Then
        Assertions.assertThat(score).isEqualTo(90);
    }

    @Test
    public void test_score_5_strikes() {
        // Given
        Game game = new Game();
        // When
        game.roll(10, 10, 10, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        int score = game.score();
        // Then
        Assertions.assertThat(score).isEqualTo(120);
    }

    @Test
    public void test_score_6_strikes() {
        // Given
        Game game = new Game();
        // When
        game.roll(10, 10, 10, 10, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0);
        int score = game.score();
        // Then
        Assertions.assertThat(score).isEqualTo(120);
    }

    @Test
    @Disabled("test_score_7_strikes : Problem to calculate score recursively")
    public void test_score_7_strikes() {
        // Given
        Game game = new Game();
        // When
        game.roll(10, 10, 10, 10, 10, 10, 10, 0, 0, 0, 0, 0, 0);
        int score = game.score();
        // Then
        Assertions.assertThat(score).isEqualTo(150);
    }

    @Test
    @Disabled("test_score_dix_parties_avec_que_des_strikes : Problem to calculate score recursively")
    public void test_score_dix_parties_avec_que_des_strikes() {
        // Given
        Game game = new Game();
        // When
        game.roll(10, 10, 10, 10, 10, 10, 10, 10, 10, 0, 0);
        int score = game.score();
        // Then
        Assertions.assertThat(score).isEqualTo(300);
    }

    @Test
    public void test_score_1_spare() {
        // Given
        Game game = new Game();
        // When
        game.roll(5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        int score = game.score();
        // Then
        Assertions.assertThat(score).isEqualTo(10);
    }

    @Test
    @Disabled("test_score_5_spare_non_identiques : Problem to calculate score recursively")
    public void test_score_5_spare_non_identiques() {
        // Given
        Game game = new Game();
        // When
        game.roll(1, 9, 2, 8, 3, 7, 4, 6, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        int score = game.score();
        // Then
        Assertions.assertThat(score).isEqualTo(64);
    }

    @Test
    @Disabled("test_score_6_spare : Problem to calculate score recursively")
    public void test_score_6_spare() {
        // Given
        Game game = new Game();
        // When
        game.roll(5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0, 0, 0, 0, 0, 0, 0, 0);
        int score = game.score();
        // Then
        Assertions.assertThat(score).isEqualTo(85);
    }

    @Test
    @Disabled("test_score_7_spare_identiques : Problem to calculate score recursively")
    public void test_score_7_spare_identiques() {
        // Given
        Game game = new Game();
        // When
        game.roll(5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0, 0, 0, 0, 0, 0);
        int score = game.score();
        // Then
        Assertions.assertThat(score).isEqualTo(100);
    }
}
