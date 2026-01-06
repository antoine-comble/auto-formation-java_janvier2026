package test.com.zenika;

import main.com.zenika.PremierProgramme;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PremierProgrammeTest {
    @Test
    public void test_deux_est_pair() {
        assertEquals(2 % 2, 0);
    }

    @Test
    public void test_cinq_est_impair() {
        assertEquals(5 % 2, 1);
    }

    @Test
    public void test_sept_n_est_pas_pair() {
        assertNotEquals(7 % 2, 0);
    }
}