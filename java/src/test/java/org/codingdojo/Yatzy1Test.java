package org.codingdojo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static java.util.List.of;
import static org.codingdojo.yatzy1.YatzyGame.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Yatzy game scoring")
public class Yatzy1Test {

    @Nested
    @DisplayName("Upper section")
    class UpperSection {
        @Test
        public void score_aces() {
            assertEquals(1, ONES.score(of(1, 2, 3, 4, 5)));
            assertEquals(2, ONES.score(of(1, 2, 1, 4, 5)));
            assertEquals(0, ONES.score(of(6, 2, 2, 4, 5)));
            assertEquals(4, ONES.score(of(1, 2, 1, 1, 1)));
        }

        @Test
        public void score_twos() {
            assertEquals(4, TWOS.score(of(1, 2, 3, 2, 6)));
            assertEquals(10, TWOS.score(of(2, 2, 2, 2, 2)));
        }

        @Test
        public void score_threes() {
            assertEquals(6, THREES.score(of(1, 2, 3, 2, 3)));
            assertEquals(12, THREES.score(of(2, 3, 3, 3, 3)));
        }

        @Test
        public void score_fours() {
            assertEquals(12, FOURS.score(of(4, 4, 4, 5, 5)));
            assertEquals(8, FOURS.score(of(4, 4, 5, 5, 5)));
            assertEquals(4, FOURS.score(of(4, 5, 5, 5, 5)));
        }

        @Test
        public void score_fives() {
            assertEquals(10, FIVES.score(of(4, 4, 4, 5, 5)));
            assertEquals(15, FIVES.score(of(4, 4, 5, 5, 5)));
            assertEquals(20, FIVES.score(of(4, 5, 5, 5, 5)));
        }

        @Test
        public void score_sixes() {
            assertEquals(0, SIXES.score(of(4, 4, 4, 5, 5)));
            assertEquals(6, SIXES.score(of(4, 4, 6, 5, 5)));
            assertEquals(18, SIXES.score(of(6, 5, 6, 6, 5)));
        }
    }

    @Nested
    @DisplayName("Lower section")
    class LowerSection {
        @Test
        public void score_one_pair() {
            assertEquals(6, PAIR.score(of(3, 4, 3, 5, 6)));
            assertEquals(10, PAIR.score(of(5, 3, 3, 3, 5)));
            assertEquals(12, PAIR.score(of(5, 3, 6, 6, 5)));
        }

        @Test
        public void score_two_pair() {
            assertEquals(16, TWO_PAIR.score(of(3, 3, 5, 4, 5)));
            assertEquals(16, TWO_PAIR.score(of(3, 3, 5, 5, 5)));
        }

        @Test
        public void score_three_of_a_kind() {
            assertEquals(9, THREE_OF_A_KIND.score(of(3, 3, 3, 4, 5)));
            assertEquals(15, THREE_OF_A_KIND.score(of(5, 3, 5, 4, 5)));
            assertEquals(9, THREE_OF_A_KIND.score(of(3, 3, 3, 3, 5)));
            assertEquals(9, THREE_OF_A_KIND.score(of(3, 3, 3, 3, 3)));
        }

        @Test
        public void score_four_of_a_kind() {
            assertEquals(12, FOUR_OF_A_KIND.score(of(3, 3, 3, 3, 5)));
            assertEquals(20, FOUR_OF_A_KIND.score(of(5, 5, 5, 4, 5)));
            assertEquals(12, FOUR_OF_A_KIND.score(of(3, 3, 3, 3, 3)));
        }

        @Test
        public void score_small_straight() {
            assertEquals(15, SMALL_STRAIGHT.score(of(1, 2, 3, 4, 5)));
            assertEquals(15, SMALL_STRAIGHT.score(of(2, 3, 4, 5, 1)));
            assertEquals(0, SMALL_STRAIGHT.score(of(1, 2, 2, 4, 5)));
        }

        @Test
        public void score_large_straight() {
            assertEquals(20, LARGE_STRAIGHT.score(of(6, 2, 3, 4, 5)));
            assertEquals(20, LARGE_STRAIGHT.score(of(2, 3, 4, 5, 6)));
            assertEquals(0, LARGE_STRAIGHT.score(of(1, 2, 2, 4, 5)));
        }

        @Test
        public void score_full_house() {
            assertEquals(18, FULL_HOUSE.score(of(6, 2, 2, 2, 6)));
            assertEquals(0, FULL_HOUSE.score(of(2, 3, 4, 5, 6)));
            assertEquals(8, FULL_HOUSE.score(of(2, 2, 2, 1, 1)));
        }

        @Test
        public void score_yatzy() {
            assertEquals(50, YATZY.score(of(4, 4, 4, 4, 4)));
            assertEquals(50, YATZY.score(of(6, 6, 6, 6, 6)));
            assertEquals(0, YATZY.score(of(6, 6, 6, 6, 3)));
        }

        @Test
        public void score_chance() {
            assertEquals(15, CHANCE.score(of(2, 3, 4, 5, 1)));
            assertEquals(16, CHANCE.score(of(3, 3, 4, 5, 1)));
        }
    }
}
