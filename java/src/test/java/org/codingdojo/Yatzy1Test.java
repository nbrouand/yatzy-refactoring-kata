package org.codingdojo;

import org.codingdojo.yatzy1.Yatzy1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static java.util.List.of;
import static org.codingdojo.yatzy1.Yatzy1.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Yatzy game scoring")
public class Yatzy1Test {

    @Nested
    @DisplayName("Upper section")
    class UpperSection {
        @Test
        public void score_aces() {
            assertEquals(1, ones(of(1, 2, 3, 4, 5)));
            assertEquals(2, ones(of(1, 2, 1, 4, 5)));
            assertEquals(0, ones(of(6, 2, 2, 4, 5)));
            assertEquals(4, ones(of(1, 2, 1, 1, 1)));
        }

        @Test
        public void score_twos() {
            assertEquals(4, twos(of(1, 2, 3, 2, 6)));
            assertEquals(10, twos(of(2, 2, 2, 2, 2)));
        }

        @Test
        public void score_threes() {
            assertEquals(6, threes(of(1, 2, 3, 2, 3)));
            assertEquals(12, threes(of(2, 3, 3, 3, 3)));
        }

        @Test
        public void score_fours() {
            assertEquals(12, fours(of(4, 4, 4, 5, 5)));
            assertEquals(8, fours(of(4, 4, 5, 5, 5)));
            assertEquals(4, fours(of(4, 5, 5, 5, 5)));
        }

        @Test
        public void score_fives() {
            assertEquals(10, fives(of(4, 4, 4, 5, 5)));
            assertEquals(15, fives(of(4, 4, 5, 5, 5)));
            assertEquals(20, fives(of(4, 5, 5, 5, 5)));
        }

        @Test
        public void score_sixes() {
            assertEquals(0, sixes(of(4, 4, 4, 5, 5)));
            assertEquals(6, sixes(of(4, 4, 6, 5, 5)));
            assertEquals(18, sixes(of(6, 5, 6, 6, 5)));
        }
    }

    @Nested
    @DisplayName("Lower section")
    class LowerSection {
        @Test
        public void score_one_pair() {
            assertEquals(6, new Yatzy1().score_pair(3, 4, 3, 5, 6));
            assertEquals(10, new Yatzy1().score_pair(5, 3, 3, 3, 5));
            assertEquals(12, new Yatzy1().score_pair(5, 3, 6, 6, 5));
        }

        @Test
        public void score_two_pair() {
            assertEquals(16, Yatzy1.two_pair(3, 3, 5, 4, 5));
            assertEquals(16, Yatzy1.two_pair(3, 3, 5, 5, 5));
        }

        @Test
        public void score_three_of_a_kind() {
            assertEquals(9, Yatzy1.three_of_a_kind(3, 3, 3, 4, 5));
            assertEquals(15, Yatzy1.three_of_a_kind(5, 3, 5, 4, 5));
            assertEquals(9, Yatzy1.three_of_a_kind(3, 3, 3, 3, 5));
        }

        @Test
        public void score_four_of_a_kind() {
            assertEquals(12, Yatzy1.four_of_a_kind(3, 3, 3, 3, 5));
            assertEquals(20, Yatzy1.four_of_a_kind(5, 5, 5, 4, 5));
            assertEquals(9, Yatzy1.three_of_a_kind(3, 3, 3, 3, 3));
        }

        @Test
        public void score_small_straight() {
            assertEquals(15, Yatzy1.smallStraight(1, 2, 3, 4, 5));
            assertEquals(15, Yatzy1.smallStraight(2, 3, 4, 5, 1));
            assertEquals(0, Yatzy1.smallStraight(1, 2, 2, 4, 5));
        }

        @Test
        public void score_large_straight() {
            assertEquals(20, Yatzy1.largeStraight(6, 2, 3, 4, 5));
            assertEquals(20, Yatzy1.largeStraight(2, 3, 4, 5, 6));
            assertEquals(0, Yatzy1.largeStraight(1, 2, 2, 4, 5));
        }

        @Test
        public void score_full_house() {
            assertEquals(18, Yatzy1.fullHouse(6, 2, 2, 2, 6));
            assertEquals(0, Yatzy1.fullHouse(2, 3, 4, 5, 6));
        }

        @Test
        public void score_yatzy() {
            assertEquals(50, Yatzy1.yatzy(4, 4, 4, 4, 4));
            assertEquals(50, Yatzy1.yatzy(6, 6, 6, 6, 6));
            assertEquals(0, Yatzy1.yatzy(6, 6, 6, 6, 3));
        }

        @Test
        public void score_chance() {
            assertEquals(15, Yatzy1.chance(2, 3, 4, 5, 1));
            assertEquals(16, Yatzy1.chance(3, 3, 4, 5, 1));
        }
    }
}
